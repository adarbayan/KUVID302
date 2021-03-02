package Domain;

import java.awt.image.BufferedImage;

public interface PowerUp {
	public int getXpos();
	public int getYpos();
	public int getRadius();
	public int getXRightSide();
	public int getYBottomSide();
	public void setXpos(int X);
	public void setYpos(int Y);
	public void setImage(BufferedImage image);
	public BufferedImage getImage();
	public int getType();
	public void setType(int t);
	public double getxSpeed();
	public double getySpeed();
	void setSpeed(int speed);
	public void setDisplay(boolean onDisplay);
	public boolean onDisplay();
	public void setAlreadyDisplayed(boolean alreadyDisplayed);
	public boolean isAlreadyDisplayed();
	void setxSpeed(double d);
	void setySpeed(double yspeed);
}

