package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Playground {
	public static int WINDOW_SIZE = 700;
	public static int FALL = 5;
	
	private  int width = 700;
	private  int length = 700;
	private  int upperbound = 0;
	private  int lowerbound = 700;
	private  int leftbound = 0;
	private  int rightbound = 700;
	
	
	private static ArrayList<AtomsPositions> atoms;
	public static ArrayList<MoleculePositions> molecules;

	

	public Playground() {
	
			
	}
	
	public  int getWidth() {
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
	public int getUpperbound() {
		return upperbound;
	}
	public void setUpperbound(int upperbound) {
		this.upperbound = upperbound;
	}
	public int getLowerbound() {
		return lowerbound;
	}
	public void setLowerbound(int lowerbound) {
		this.lowerbound = lowerbound;
	}
	public int getLeftbound() {
		return leftbound;
	}
	public void setLeftbound(int leftbound) {
		this.leftbound = leftbound;
	}
	public int getRightbound() {
		return rightbound;
	}
	public void setRightbound(int rightbound) {
		this.rightbound = rightbound;
	}


	public ArrayList<AtomsPositions> getAtoms() {
		return atoms;
	}

	public static void setAtoms(ArrayList<AtomsPositions> atoms) {
		Playground.atoms = atoms;
	}
	
	public static ArrayList<MoleculePositions> getMolecules() {
		return molecules;
	}

	public static void setMolecules(ArrayList<MoleculePositions> molecules) {
		Playground.molecules = molecules;
	}
	


}
