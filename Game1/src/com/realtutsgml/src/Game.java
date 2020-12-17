package com.realtutsgml.src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.realtutsgml.src.input.Controller;
import com.realtutsgml.src.input.KeyInput;
import com.realtutsgml.src.objects.Enemy;
import com.realtutsgml.src.objects.Player; 

public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Timer gamelooptimer;
	
	String background = "/images/BossBack.png";
	
	//objects
	Player p;
	Controller c;

	public Game(){
		setFocusable(true);
		
		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();
		
		p = new Player(100,200);
		c = new Controller();
		addKeyListener(new KeyInput(p));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), 0, 0, null);
		
		p.draw(g2d);
		c.draw(g2d);
		
	}
	
	public Image getBackgroundImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
		
	}

	@Override
	public void actionPerformed(ActionEvent ee) {
		//System.out.println("running game loop");
		repaint(); //calls paint class every 10 millisecs
		p.update();
		c.update();
	}
	
}
