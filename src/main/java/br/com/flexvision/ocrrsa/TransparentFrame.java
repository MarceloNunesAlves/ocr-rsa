package br.com.flexvision.ocrrsa;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TransparentFrame extends JFrame implements MouseMotionListener, ActionListener {

	@Autowired
	private RsaRepository rsaRepository;
	
	public TransparentFrame() {
		addMouseMotionListener(this);

		setUndecorated(true);

		setLayout(new GridBagLayout());

		setSize(150, 35);

		setLocation(200, 200);

		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		
		// Starting the thread that will read the screen
		ThreadReadData t = new ThreadReadData();
		t.setWindowRefence(this);
		t.start();

	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// Positioning with the mouse
		this.setLocation(e.getLocationOnScreen().x - this.getSize().width / 2,
				e.getLocationOnScreen().y - this.getSize().height / 2);
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public RsaRepository getRsaRepository() {
		return rsaRepository;
	}
	
	
}