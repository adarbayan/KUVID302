package UI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.GameController;

public class HealthDisplay  extends JComponent{
	public GameController game;
	public int xPos = 560;
	public int yPos = 50;
	private BufferedImage image;
	
	public HealthDisplay() {

	}
	
	public void paintComponent(Graphics p, int health) {
		
		try {                
	          image = ImageIO.read(new File("assets/heart.png"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }
		super.paintComponent(p);
		p.drawImage(image, xPos,yPos,20,20, this);
		p.drawString(Integer.toString(health), xPos + 23, yPos + 15);
		
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}