package Domain;

public class Mixer {
	private int xPos;
	private int yPos;
	private int vel;
	
	public Mixer(int xPos, int yPos, int vel) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.vel = vel;
		
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
