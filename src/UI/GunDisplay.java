package UI;

import java.awt.Graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.GameController;


public class GunDisplay extends JComponent{
	
	
	public int rotateAngle=0;
	public int xPos = 305;
	public int yPos = 500;
	public int wid = 50;
	private BufferedImage image;
	private BufferedImage imageToPaint;
	
	
	public GunDisplay() {

	}
	
	@Override
	public void paintComponent(Graphics p) {
		
		try {                
	          image = ImageIO.read(new File("Images/bullet.png"));
	       } catch (IOException ex) {
	    	   ex.printStackTrace();
	       }
		super.paintComponent(p);
		
		AffineTransform tx = new AffineTransform();
	    tx.rotate(Math.toRadians(rotateAngle), image.getWidth() / 2, image.getHeight() / 2);

	    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
	    imageToPaint = op.filter(image, null);
	    
	    p.drawImage(imageToPaint, xPos,yPos, this);
		
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
	
	public int getRotateAngle() {
		return rotateAngle;
	}

	public void setRotateAngle(int rotateAngle) {
		this.rotateAngle = rotateAngle;
	}
	
	

}
