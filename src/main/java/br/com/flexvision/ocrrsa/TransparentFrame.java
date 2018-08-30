package br.com.flexvision.ocrrsa;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

class TransparentFrame extends JFrame implements MouseMotionListener, ActionListener {

	public TransparentFrame() {
		addMouseMotionListener(this);

		setUndecorated(true);

		setLayout(new GridBagLayout());

		setSize(150, 150);

		setLocation(200, 200);

		// Starting the thread that will read the screen
		ThreadReadData t = new ThreadReadData();
		t.windowRefence = this;
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
	
}