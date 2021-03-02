package Domain;

public class Gun {
	private int xPos;
	private int yPos;
	private int vel;
	private int rotAngle;
	
	public Gun(int xPos, int yPos, int vel, int rotAngle) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.vel = vel;
		this.rotAngle = rotAngle;
		
	}
	public int getRotAngle() {
		return rotAngle;
	}
	public void setRotAngle(int rotAngle) {
		this.rotAngle = rotAngle;
	}
	public int getVel() {
		return vel;
	}
	public void setVel(int vel) {
		this.vel = vel;
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
