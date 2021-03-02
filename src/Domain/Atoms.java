package Domain;

import java.util.ArrayList;

public interface Atoms {
	
	public static final double alphaStability = 0.85;
	public static final double betaStability = 0.9;
	public static final double gammaStability = 0.8;
	public static final double sigmaStability = 0.7;
	
	public static final int alphaProton = 8;
	public static final int betaProton = 16;
	public static final int gammaProton = 32;
	public static final int sigmaProton = 64;

	
	public ArrayList<ShieldDecorator> shields = new ArrayList<ShieldDecorator>();
	

	public double calculateEfficiency();
	public String getType();
	public int getxPos();
	public void setxPos(int xPos);
	public int getyPos();
	public void setyPos(int yPos);
	public int getWidth();
	public void setWidth(int width);
	public int getLength();
	public void setLength(int length);
	public int getNeutron();
	public void setNeutron(int neutron);
	public int getProton();
	public void setProton(int proton);
	public double getEfficiency();
	public void setEfficiency(double efficiency);
	public double getxSpeed();
	public void setxSpeed(double xSpeed) ;
	public double getySpeed();
	public void setySpeed(double ySpeed);
	public ArrayList<ShieldDecorator> getShields();
	public void setShields(ArrayList<ShieldDecorator> s);
	public void addShields(int i);
}