package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.GameController;


public class MixerDisplay extends JComponent{

	
	public int xPos = 575;
	public int yPos = 300;
	private BufferedImage image;
	
	
	public MixerDisplay() {

	}
	
	@Override
	public void paintComponent(Graphics p) {
		
		
		
		try {                
	          image = ImageIO.read(new File("assets/mixer.png"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }
		super.paintComponent(p);
		p.drawImage(image, xPos,yPos,50,50, this);
		
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
