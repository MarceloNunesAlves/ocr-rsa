package br.com.flexvision.ocrrsa;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaptureWindow {

	@Autowired
	private TransparentFrame tw;
	
	public void init() {
		/* Verifique o recurso de transparência */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();

		if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
			System.err.println("Translucency is not supported");
			System.exit(0);
		}

		// Set a janela com 15% opacidade.
		tw.setOpacity(0.15f);

		// Abre a janela.
		tw.setVisible(true);
	}

}



