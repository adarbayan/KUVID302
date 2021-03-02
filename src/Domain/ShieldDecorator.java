package Domain;

import java.util.ArrayList;

public class ShieldDecorator implements Atoms {
	
    public double etaSpeedReduce = 0.05;
    public double lotaSpeedReduce = 0.07;
    public double thetaSpeedReduce = 0.09;
    public double zetaSpeedReduce = 0.11;
	private int xPos;
	private int yPos;
	private int width;
	private int length;
	private int neutron;
	private int proton;
	private double efficiency;
	private double xSpeed;
	private double ySpeed;
	private ArrayList<ShieldDecorator> shields;
	

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



	public int getNeutron() {
		return neutron;
	}



	public void setNeutron(int neutron) {
		this.neutron = neutron;
	}



	public int getProton() {
		return proton;
	}



	public void setProton(int proton) {
		this.proton = proton;
	}



	public double getEfficiency() {
		return efficiency;
	}



	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}



	public double getxSpeed() {
		return xSpeed;
	}



	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}



	public double getySpeed() {
		return ySpeed;
	}



	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}



	public ArrayList<ShieldDecorator> getShields() {
		return shields;
	}



	public void setShields(ArrayList<ShieldDecorator> shields) {
		this.shields = shields;
	}



	@Override
	public double calculateEfficiency() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addShields(int i) {
		// TODO Auto-generated method stub
		
	}
	
}