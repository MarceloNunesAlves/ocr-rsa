package br.com.flexvision.ocrrsa;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.*;
import org.springframework.stereotype.Component;

@Component
public class CaptureWindow {

	public CaptureWindow() {

		/* Verifique o recurso de transparência */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
			System.err.println("Translucency is not supported");
			System.exit(0);
		}

		TransparentFrame tw = new TransparentFrame();

		// Set a janela com 55% opacidade.
		tw.setOpacity(0.55f);

		// Abre a janela.
		tw.setVisible(true);
	}

	/*
	 * public static void main(String[] args){ // Calling the capture windows
	 * windowReader = new CaptureWindow(); }
	 */
}



