package com.realtutsgml.src;

import javax.swing.JFrame;

public class MainClass {

	public static final int WIDTH = 800, HEIGHT = 400;
	public static final String TITLE = "GAME"; 
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame(TITLE);
		frame.pack();
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(new Game());
		frame.setVisible(true);
		
	}
	
}
