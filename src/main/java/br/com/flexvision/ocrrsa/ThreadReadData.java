package br.com.flexvision.ocrrsa;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

class ThreadReadData extends Thread {

	private TransparentFrame windowRefence;
	
	public void run() {
		try {
			while (true) {
				if (this.windowRefence.isShowing()) {
					// Capturing the screen with the Robot cass
					Robot robot;
					try {
						robot = new Robot();
						
						String path = System.getProperty("user.dir");//Caminho do lugar onde o App esta rodando
						
						Rectangle r = new Rectangle(windowRefence.getLocationOnScreen().x, windowRefence.getLocationOnScreen().y,
													windowRefence.getSize().width, windowRefence.getSize().height);
						
						BufferedImage screenShot = robot.createScreenCapture(r);
						
						// Save your screen shot with its label
						ImageIO.write(screenShot, "png", new File(path+"\\screenShot.png"));

						// Call the tesseract.exe OCR
						Process process = new ProcessBuilder(
								path+"\\ocr-lib\\Tesseract-OCR-WIN\\tesseract.exe",
								path+"\\screenShot.png", path+"\\out").start();

						// Read the data from the output file
						String rsaString = this.readFile(path+"\\out.txt");
						
						rsaString = rsaString.replaceAll(" ", "");
						rsaString = rsaString.replaceAll("\r", "").replaceAll("\n", "");

						System.out.println("OCR:" + rsaString);
						
						Rsa rsa = new Rsa("rsa",rsaString);
						windowRefence.getRsaRepository().save(rsa);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				this.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readFile(String f) {
		String everything = "";
		BufferedReader br;
		try {

			br = new BufferedReader(new FileReader(f));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return everything;
	}

	public void setWindowRefence(TransparentFrame windowRefence) {
		this.windowRefence = windowRefence;
	}
	
}
