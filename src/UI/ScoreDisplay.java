package UI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.GameController;

public class ScoreDisplay  extends JComponent{
	public GameController game;
	public int xPos = 560;
	public int yPos = 50;
	private BufferedImage image;
	
	public ScoreDisplay() {

	}
	
	public void paintComponent(Graphics p, double score) {
		
		super.paintComponent(p);
		
		p.drawString("Score: " + Double.toString(Math.round(score*1000.0)/1000.0), xPos, yPos);
		
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