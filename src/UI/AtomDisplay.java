package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.GameController;

public class AtomDisplay extends JComponent{

	public int radii=13;
	public int x,y,l,h;
	public String type;
	private BufferedImage image;
	public int xPos = 305;
	public int yPos = 490;
	public int moveAngle;
	public int length = 50;
	public int width = 50;



	@Override
	public String toString() {
		return "AtomDisplay [xPos=" + xPos + ", yPos=" + yPos + ", moveAngle=" + moveAngle + "]";
	}



	public int getMoveAngle() {
		return moveAngle;
	}
	
	
	public static ArrayList<AlphaAtomDisplay> alphaAtoms;
	
	public AtomDisplay(){
	
		}
		
		
	 
	public void paintComponent(Graphics p) {
		// TODO Auto-generated method stub
		if (this.type == "alpha-atom"){
			try {                
		          image = ImageIO.read(new File("assets/atoms/alpha.png"));
		       } catch (IOException ex) {
		    	   ex.printStackTrace();
		       }
		}else if (this.type == "beta-atom") {
			try {                
		          image = ImageIO.read(new File("assets/atoms/beta.png"));
		       } catch (IOException ex) {
		    	   ex.printStackTrace();
		       }
		}else if (this.type == "gamma-atom") {
			try {                
		          image = ImageIO.read(new File("assets/atoms/gamma.png"));
		       } catch (IOException ex) {
		    	   ex.printStackTrace();
		       }
		}else{
			try {                
		          image = ImageIO.read(new File("assets/atoms/sigma.png"));
		       } catch (IOException ex) {
		    	   ex.printStackTrace();
		       }
		}
		
		
		super.paintComponent(p);
		
	    p.drawImage(image, xPos,yPos, length, width, this);
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



	public String getType() {
		return type;
	}


	public void setType(String atomType) {
		this.type = atomType;		
	}


	public void setMoveAngle(int rotateAngle) {
		// TODO Auto-generated method stub
		this.moveAngle = rotateAngle;
	}
	
	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}
	
}
