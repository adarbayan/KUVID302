package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class BackgroundDisplay extends JComponent{
	

	public int xPos = 0;
	public int yPos = 0;
	private BufferedImage image;
	
	
	public BackgroundDisplay() {

	}
	
	@Override
	public void paintComponent(Graphics p) {
		
		
		
		try {                
	          image = ImageIO.read(new File("assets/kuvid_bc.png"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }
		super.paintComponent(p);
		p.drawImage(image, xPos,yPos,700,600, this);
		
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
