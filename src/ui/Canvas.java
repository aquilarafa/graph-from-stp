package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	public Canvas() {
		
		this.setBackground(Color.WHITE);
		JFrame frame = new JFrame();
		frame.add(this);
		
		frame.setSize(800,800);
		frame.setVisible(true);
	}


	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 50, 50);
	}
	
	public static void main(String[] args) {
		
		new Canvas();
	}
}
