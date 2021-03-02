package Domain;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Domain.Atoms;

public class ReactionBlockerBeta implements ReactionBlocker {
	
	private int xPos;
	private int yPos;
	private int width;
	private int length;
	private BufferedImage image;
	private int structure;
	public int speed = 0;
	private boolean onDisplay = false;
	private boolean alreadyDisplayed = false;
	private int nextYpos;
	private float angle = 0;
	private int vel;
	private boolean left = true;
	private boolean right = false;
	private int xSpeed;
	private int ySpeed;
	



	public ReactionBlockerBeta(int xPos, int yPos, int width, int length, int structure,double xSpeed, double ySpeed) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.length=length;
		this.width=width;
		this.structure = structure;
		this.xSpeed=(int) xSpeed;
		this.ySpeed=(int) ySpeed;
		this.nextYpos = (int) (yPos + ySpeed);
		this.vel = 1;
		
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getStructure() {
		return structure;
	}

	public void setStructure(int structure) {
		this.structure = structure;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOnDisplay() {
		return onDisplay;
	}

	public void setOnDisplay(boolean onDisplay) {
		this.onDisplay = onDisplay;
	}

	public boolean isAlreadyDisplayed() {
		return alreadyDisplayed;
	}

	public void setAlreadyDisplayed(boolean alreadyDisplayed) {
		this.alreadyDisplayed = alreadyDisplayed;
	}

	public int getNextYpos() {
		return nextYpos;
	}

	public void setNextYpos(int nextYpos) {
		this.nextYpos = nextYpos;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setRight() {
		this.left = false;
		this.right = true;
		this.vel = 1;
	}
	
	public void setLeft() {
		this.right = false;
		this.left = true;
		this.vel = -1;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public boolean onDisplay() {
		// TODO Auto-generated method stub
		return this.onDisplay;
	}

	@Override
	public int getNeutron() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNeutron(int neutron) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getProton() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setProton(int proton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEfficiency(double efficiency) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getxSpeed() {
		// TODO Auto-generated method stub
		return this.xSpeed;
	}

	@Override
	public void setxSpeed(double xSpeed) {
		// TODO Auto-generated method stub
		this.xSpeed = (int) xSpeed;
	}

	@Override
	public double getySpeed() {
		// TODO Auto-generated method stub
		return this.ySpeed;
	}

	@Override
	public void setySpeed(double ySpeed) {
		// TODO Auto-generated method stub
		this.ySpeed = (int) ySpeed;
	}
	
	


}
