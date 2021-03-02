package Domain;


public interface Molecule {

	public int getType();
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

	public void setRight(boolean r);
	public void setLeft(boolean l);
	public boolean isLeft();
	public boolean isRight();
	public boolean onDisplay();
	public void setOnDisplay(boolean b);
	public int getStructure();
	public void setStructure(int s);
	public int getVel();
	public void setVel(int i);
}
