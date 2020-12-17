package com.realtutsgml.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.realtutsgml.src.GlobalPosition;
import com.realtutsgml.src.input.Controller;

public class Player extends GlobalPosition{
	
	private int velX = 0;
	private int velY = 0;
	
	private String playerimage = "/images/rockdude.png";
	
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	
	public Player(int x, int y) {
		super(x, y);
		
	}

	public void update(){
		x+=velX;
		y+=velY;
		
		//collision with outside
		if(x < 0){
			x = 0;
		}
		if(y < 0){
			y = 0;
		}
		if(x > 520){
			x = 520;
		}
		if(y > 200){
			y = 200;
		}
		
		Collision();
		
	}
	
	public void Collision(){
		for (int i  = 0; i<e.size(); i++){
			if (getBounds().intersects(e.get(i).getBounds())){
				System.out.println("HIT");
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if( key == KeyEvent.VK_RIGHT){
			velX = 5;
		} else if (key == KeyEvent.VK_LEFT){
			velX = -5;
		} else if (key == KeyEvent.VK_DOWN){
			velY = 5;
		} else if (key == KeyEvent.VK_UP){
			velY = -5;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
			
		if( key == KeyEvent.VK_RIGHT){
			velX = 0;
		} else if (key == KeyEvent.VK_LEFT){
			velX = 0;
		} else if (key == KeyEvent.VK_DOWN){
			velY = 0;
		} else if (key == KeyEvent.VK_UP){
			velY = 0;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 200, 200); 
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImage(), x, y, null);
		
		//g2d.draw(getBounds()); // see the box
	}
	
	public Image getPlayerImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}
}
