package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.Molecule;
import Domain.PowerUp;

public class PowerUpDisplay extends JComponent{

	private BufferedImage image;
	static ArrayList<PowerUp> powerUps = new ArrayList<PowerUp>();
	static Random rand = new Random();
	long nextSecond;
	private int L;
	private int numOfRenderedPUs = 5;
	public int totalFallenPowerUps = 0;
	private int totalPUNumber;
	public int xPos = 305;
	public int yPos = 490;
	public int length = 0;
	
	public PowerUpDisplay() {
		long timeMillis = System.currentTimeMillis();
		long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		nextSecond = timeSeconds+1;
	}
	
	public void paintComponent(Graphics p) {
		super.paintComponent(p);
	    p.drawImage(image, xPos,yPos, length, length, this);
		/*
		for(PowerUp powerUp : powerUps) {
			if(powerUp.onDisplay()) {
				int type = powerUp.getType();
				setImage(type);
				super.paintComponent(p);
				p.drawImage(image, powerUp.getXpos(),powerUp.getYpos(),powerUp.getRadius(), powerUp.getRadius(), this);
				updateOffset((int) powerUp.getySpeed());
			}
		}	
		*/
	}
	
	public void paintGunPU(Graphics p, int x, int y, int r) {
		super.paintComponent(p);
		p.drawImage(image, x, y, r, r, this);
	}
	
	public static ArrayList<Integer> getCoor(){
		ArrayList<Integer> coords = new ArrayList<Integer>();
		for(PowerUp powerUp : powerUps) {
			coords.add(powerUp.getXpos());
			coords.add(powerUp.getYpos() + 40);
		}
		return coords;
	}
	
	public static void updatePowerUpList() {
		for (PowerUp pu: powerUps) {
			pu.setXpos(rand.nextInt(500));
			pu.setYpos(-(rand.nextInt(550)+50));
			int newType = rand.nextInt(4);
			pu.setType(newType);
		}
	}
	
	public void initialSetUp(int L) {
		this.L = L;
		int totalPUs = powerUps.size();
		for(int i = 0; i < numOfRenderedPUs; i++) {
			int idx = rand.nextInt(totalPUs);
			powerUps.get(idx).setDisplay(true);

		}

	}
	
	public void setImage(int type) {
			
			try {   
				if (type==0) {
					this.image = ImageIO.read(new File("assets/powerups/+alpha-b.png"));
				} else if (type==1) {
					this.image = ImageIO.read(new File("assets/powerups/+beta-b.png"));
				} else if (type==2) {
					this.image = ImageIO.read(new File("assets/powerups/+gamma-b.png"));
				} else if (type==3) {
					this.image = ImageIO.read(new File("assets/powerups/+sigma-b.png"));
				}
		          
		       } catch (IOException ex) {
		    	   ex.printStackTrace();
		       }
	}

	public void updateOffset(int update) {
		
		if (powerUps.get(0).getYpos()>=650) {
			updatePowerUpList();
		} else {
			for (PowerUp pu: powerUps) {
				pu.setYpos(pu.getYpos()+update);
			}
		}
		
	}
	
	public void setPowerUps(ArrayList<PowerUp> powerUps) {
		System.out.println("Board PowerUps blockers set");
		
		this.powerUps = powerUps;
		this.totalPUNumber = powerUps.size();
	}


	public void removePUBelowScreen() {
	
		int fallenPUs = 0;
		for (PowerUp pu: powerUps) { 
			
			if (pu.getYpos()>=540) {
				int idx = powerUps.indexOf(pu);
				fallenPUs++;
				int newY = -rand.nextInt(100);
				pu.setYpos(newY);
				pu.setAlreadyDisplayed(true);
				pu.setDisplay(false);
				totalFallenPowerUps++;	
			}	
		}

		for(int i = 0; i < fallenPUs; i++) {
			int newIdx = rand.nextInt(powerUps.size()); 
			PowerUp newPU = powerUps.get(newIdx);
			while(newPU.isAlreadyDisplayed()) {
				newPU = powerUps.get(newIdx);
			}
			newPU.setDisplay(true);
		}
	}

	public BufferedImage getImage() {
		return image;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	


}

