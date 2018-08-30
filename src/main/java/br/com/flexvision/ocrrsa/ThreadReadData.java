package br.com.flexvision.ocrrsa;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

class ThreadReadData extends Thread {

	public TransparentFrame windowRefence;

	public void run() {
		try {
			while (true) {
				if (this.windowRefence.isShowing()) {
					// Capturing the screen with the Robot cass
					Robot robot;
					try {
						robot = new Robot();

						BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
								windowRefence.getLocationOnScreen().x, windowRefence.getLocationOnScreen().y,
								windowRefence.getSize().width, windowRefence.getSize().height));
						Graphics2D graphics = screenShot.createGraphics();

						// Save your screen shot with its label
						ImageIO.write(screenShot, "png", new File("c:\\OCR\\myScreenShot.png"));

						// Call the tesseract.exe OCR
						Process process = new ProcessBuilder(
								".\\ocr-lib\\Tesseract-OCR-WIN\\Tesseract-OCR\\tesseract.exe",
								"c:\\tmp\\myScreenShot.png", "c:\\tmp\\out").start();

						// Read the data from the output file
						String everything = this.readFile("c:\\\\tmp\\out.txt");

						System.out.println("OCR:" + everything);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				this.sleep(1000);
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
}
