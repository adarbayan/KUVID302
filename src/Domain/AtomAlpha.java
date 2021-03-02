package Domain;
import java.lang.Math;
import java.util.ArrayList;

public class AtomAlpha implements Atoms {
	
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
		
	public AtomAlpha(int xPos, int yPos, int width, int length, int neutron, int proton, double efficiency, double xSpeed, double ySpeed, ArrayList<ShieldDecorator> shields) {
	
		this.xPos = xPos;
		this.yPos = yPos;
		this.length=length;
		this.width=width;
		this.neutron = neutron;
		this.proton = proton;
		this.efficiency = efficiency;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.shields = shields;
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
		if(shields.size() > 0) {
			this.yPos = (int) (yPos - (ySpeed*10)/100);
		} else {
			this.yPos = yPos;
		}
		
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

	@Override
	public void addShields(int i) {
		ShieldDecorator s = new ShieldDecorator();
		shields.add(s);
	}
	
	public void setShields(ArrayList<ShieldDecorator> shields) {
		this.shields = shields;
	}

	@Override
	public double calculateEfficiency() {
		// TODO Auto-generated method stub
		if(shields.size() > 0 && this.neutron == this.proton) {
			return ((1 - (Math.abs(this.neutron - Atoms.alphaProton) / Atoms.alphaProton) ) * Atoms.alphaStability) * 1.25;
		}
		return (1 - (Math.abs(this.neutron - Atoms.alphaProton) / Atoms.alphaProton) ) * Atoms.alphaStability;	
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "alpha-atom";
	}




}