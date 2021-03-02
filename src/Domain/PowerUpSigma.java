package Domain;

import java.awt.image.BufferedImage;

public class PowerUpSigma implements PowerUp{
	
	private int xPos;
	private int yPos;
	private int radius;
	private BufferedImage image;
	private int type = 3;
	public double xspeed = 0;
	public double yspeed = 0;
	private boolean onDisplay = false;
	private boolean alreadyDisplayed = false;
	
	public PowerUpSigma(int xPos, int yPos, int radius, double xspeed, double yspeed,int unitLength) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.radius = radius;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		
	}

	@Override
	public int getXpos() {
		return xPos;
	}

	@Override
	public int getYpos() {
		return yPos;
	}

	@Override
	public int getRadius() {
		return radius;
	}

	@Override
	public int getXRightSide() {
		return xPos+radius;
	}

	@Override
	public int getYBottomSide() {
		return yPos+radius;
	}

	@Override
	public void setXpos(int X) {
		this.xPos = X;
	}

	@Override
	public void setYpos(int Y) {
		this.yPos = Y;
	}

	@Override
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public void setType(int t) {
		this.type = t;
	}

	
	@Override
	public void setxSpeed(double xspeed) {
		this.xspeed = xspeed;
	}
	
	@Override
	public void setySpeed(double yspeed) {
		this.yspeed = yspeed;
	}

	@Override
	public void setDisplay(boolean onDisplay) {
		this.onDisplay = onDisplay;
	}

	@Override
	public boolean onDisplay() {
		return onDisplay;
	}

	@Override
	public void setAlreadyDisplayed(boolean alreadyDisplayed) {
		this.alreadyDisplayed = alreadyDisplayed;
	}

	@Override
	public boolean isAlreadyDisplayed() {
		return alreadyDisplayed;
	}

	@Override
	public double getxSpeed() {
		// TODO Auto-generated method stub
		return this.xspeed;
	}

	@Override
	public double getySpeed() {
		// TODO Auto-generated method stub
		return this.yspeed;
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		
	}

	

}

