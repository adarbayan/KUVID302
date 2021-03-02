package UI;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

import Domain.GameController;

public class SideBarDisplay extends JComponent {
	public Timer timer;
	public int delay = 4;
	public int xPos = 550;
	public int yPos = 0;
	private BufferedImage image;

	public int Sigma;
	public int numberOfAlphaAtoms;
	public int numberOfBetaAtoms;
	public int numberOfGammaAtoms;
	public int numberOfSigmaAtoms;

	public int numberOfAlphaPowerUp;
	public int numberOfBetaPowerUp;
	public int numberOfGammaPowerUp;
	public int numberOfSigmaPowerUp;
	public double score;

	public long startTime;
	public int elapsedTime;

	public int blenderCount = 0;

	public int[] numberOfGameElements;

	public int[] getNumberOfGameElements() {
		return numberOfGameElements;
	}

	public void setNumberOfGameElements(int[] numberOfGameElements) {
		this.numberOfGameElements = numberOfGameElements;
	}

	public SideBarDisplay() {
		elapsedTime = 0;
	}

	@Override
	public void paintComponent(Graphics p) {

		try {
			image = ImageIO.read(new File("assets/sidebar.png"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		super.paintComponent(p);
		p.drawImage(image, xPos, yPos, this);
		JLabel label = new JLabel("Hello, Java!", JLabel.CENTER);
		// p.drawString("S: " + Integer.toString(numberOfAlphaAtoms), xPos + 2, 460);
		if ((int) elapsedTime < 2) {
			p.drawString("Timer: " + Integer.toString((int) elapsedTime) + " second", xPos + 2, 160);
		} else {
			p.drawString("Timer: " + Integer.toString((int) elapsedTime) + " seconds", xPos + 2, 160);
		}
		p.drawString("Alpha atoms: " + Integer.toString(numberOfGameElements[0]), xPos + 2, 460);
		p.drawString("Beta atoms: " + Integer.toString(numberOfGameElements[1]), xPos + 2, 475);
		p.drawString("Gamma atoms: " + Integer.toString(numberOfGameElements[2]), xPos + 2, 490);
		p.drawString("Sigma atoms: " + Integer.toString(numberOfGameElements[3]), xPos + 2, 505);

		p.drawString("Alpha PowerUp: " + Integer.toString(numberOfGameElements[12]), xPos + 2, 240);
		p.drawString("Beta PowerUp: " + Integer.toString(numberOfGameElements[13]), xPos + 2, 255);
		p.drawString("Gamma PowerUp: " + Integer.toString(numberOfGameElements[14]), xPos + 2, 270);
		p.drawString("Sigma PowerUp: " + Integer.toString(numberOfGameElements[15]), xPos + 2, 285);

		p.drawString("Current Blender Option:", xPos + 2, 200);
		p.drawString(getBlenderOption(blenderCount), xPos + 2, 220);
	}

	public String getBlenderOption(int blenderCount) {
		switch (blenderCount % 12) {
		case 0:
			return "2 Alpha -> 1 Beta";
		case 1:
			return "3 Alpha -> 1 Gamma";
		case 2:
			return "4 Alpha -> 1 Sigma";
		case 3:
			return "2 Beta -> 1 Gamma";
		case 4:
			return "3 Beta -> 1 Sigma";
		case 5:
			return "2 Gamma -> 1 Sigma";
		case 6:
			return "1 Beta -> 2 Alpha";
		case 7:
			return "1 Gamma -> 3 Alpha";
		case 8:
			return "1 Sigma -> 4 Alpha";
		case 9:
			return "1 Gamma -> 2 Beta";
		case 10:
			return "1 Sigma -> 3 Beta";
		case 11:
			return "1 Sigma -> 2 Gamma";
		default:
			return "";
		}
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

	public int getNumberOfAlphaAtoms() {
		return numberOfAlphaAtoms;
	}

	public void setNumberOfAlphaAtoms(int numberOfAlphaAtoms) {
		this.numberOfAlphaAtoms = numberOfAlphaAtoms;
	}

	public int getNumberOfBetaAtoms() {
		return numberOfBetaAtoms;
	}

	public void setNumberOfBetaAtoms(int numberOfBetaAtoms) {
		this.numberOfBetaAtoms = numberOfBetaAtoms;
	}

	public int getNumberOfGammaAtoms() {
		return numberOfGammaAtoms;
	}

	public void setNumberOfGammaAtoms(int numberOfGammaAtoms) {
		this.numberOfGammaAtoms = numberOfGammaAtoms;
	}

	public int getNumberOfSigmaAtoms() {
		return numberOfSigmaAtoms;
	}

	public void setNumberOfSigmaAtoms(int numberOfSigmaAtoms) {
		this.numberOfSigmaAtoms = numberOfSigmaAtoms;
	}

	public int getNumberOfAlphaPowerUp() {
		return numberOfAlphaPowerUp;
	}

	public void setNumberOfAlphaPowerUp(int numberOfAlphaPowerUp) {
		this.numberOfAlphaPowerUp = numberOfAlphaPowerUp;
	}

	public int getNumberOfBetaPowerUp() {
		return numberOfBetaPowerUp;
	}

	public void setNumberOfBetaPowerUp(int numberOfBetaPowerUp) {
		this.numberOfBetaPowerUp = numberOfBetaPowerUp;
	}

	public int getNumberOfGammaPowerUp() {
		return numberOfGammaPowerUp;
	}

	public void setNumberOfGammaPowerUp(int numberOfGammaPowerUp) {
		this.numberOfGammaPowerUp = numberOfGammaPowerUp;
	}

	public int getNumberOfSigmaPowerUp() {
		return numberOfSigmaPowerUp;
	}

	public void setNumberOfSigmaPowerUp(int numberOfSigmaPowerUp) {
		this.numberOfSigmaPowerUp = numberOfSigmaPowerUp;
	}

	public void updateTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;

	}
}