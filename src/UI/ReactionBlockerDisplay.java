package UI;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Domain.Atoms;
import Domain.Board;
import Domain.GameController;
import Domain.LocalFile;
import Domain.Molecule;
import Domain.MoleculeAlpha;

public class ReactionBlockerDisplay extends JComponent {

	public int radii = 13;
	public int x, y, l, h;
	public int type;
	private BufferedImage image;
	public int xPos = 305;
	public int yPos = 490;
	public int moveAngle;
	public int length = 50;
	public int width = 50;

	public int structure;

	public ReactionBlockerDisplay(int type, int structure) {
		this.type = type;
		this.structure = structure;
	}

	public void paintComponent(Graphics p) {
		setImage(type, structure);
		super.paintComponent(p);
		p.drawImage(image, xPos, yPos, length, width, this);
	}

	private void setImage(int type, int structure) {

		try {
			if (type == 0) {
				image = ImageIO.read(new File("assets/blockers/alpha-b.png"));
			} else if (type == 1) {
				image = ImageIO.read(new File("assets/blockers/beta-b.png"));
			} else if (type == 2) {
				image = ImageIO.read(new File("assets/blockers/gamma-b.png"));
			} else if (type == 3) {
				image = ImageIO.read(new File("assets/blockers/sigma-b.png"));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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

	/*
	 * public void removeMolBelowScreen() { // This method detects the molecules
	 * below the game screen // It sets true "isAlreadyDisplayed" flags of those
	 * molecules // It sets false "onDisplay" flags of those molecules int
	 * fallenMols = 0; for (Molecule mol : molecules) { // this loop detects
	 * molecules below the screen
	 * 
	 * if (mol.getYpos() >= 540) { molecules.indexOf(mol); fallenMols++; int newY =
	 * -rand.nextInt(100); mol.setYpos(newY); mol.setAlreadyDisplayed(true);
	 * mol.setDisplay(false); totalFallenMolecules++; } }
	 * 
	 * // int sz = molsToRemove.size(); for (int i = 0; i < fallenMols; i++) { //
	 * molecules.remove(molsToRemove.get(i)); //thi is if you wanna remove the //
	 * fallen molecules from list, but it throws exception int newIdx =
	 * rand.nextInt(molecules.size()); Molecule newMol = molecules.get(newIdx);
	 * while (newMol.isAlreadyDisplayed()) { newMol = molecules.get(newIdx); }
	 * newMol.setDisplay(true); } }
	 */

}