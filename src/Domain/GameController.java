package Domain;

import java.util.ArrayList;

import UI.GameEngine;

public class GameController {

	Board board;
	
	public static int xSpeed;
	public static int ySpeed;

	public GameController(int[] numberOfGameObjects, int unitLengthL) {
		board = new Board(numberOfGameObjects, unitLengthL);
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ArrayList<Atoms> AtomList() {
		return Board.AtomList();
	}
	
	public ArrayList<Molecule> MoleculeList() {
		return Board.MoleculeList();
	}
	
	public ArrayList<ReactionBlocker> ReactionBlockerList() {
		return Board.ReactionBlockerList();
	}

	public ArrayList<Molecule> AllMoleculesList() {
		return Board.getAllMolecules();
	}
	
	public ArrayList<ReactionBlocker> AllReactionBlockersList() {
		return Board.getAllReactionBlockers();
	}
	
	public ArrayList<PowerUp> PowerUpList() {
		return Board.PowerUpList();
	}
	
	public ArrayList<PowerUp> AllPowerUpsList() {
		return Board.getAllPowerUps();
	}
	
	public ArrayList<Molecule> createMolecules() {
		return Board.getAllMolecules();
	}
	
	public void addAtoms(Atoms a) {
		board.addAtoms(a);
	}
	
	public void addMolecules(Molecule m) {
		board.addMolecules(m);
	}
	
	public int moveGun(String input) {
		return board.moveGun(input);
	}
	
	public int rotateGun(String input) {
		return board.rotateGun(input);
	}

	public int getGunXPosition() {
		return board.getGunXPos();
	}
	public int getGunYPosition() {
		return board.getGunYPos();
	}
	
	public void setXSpeed(int xSpeed) {
		GameController.xSpeed = xSpeed;
	}
	
	public void setYSpeed(int ySpeed) {
		GameController.ySpeed = ySpeed;
	}

	public void addPowerUps(PowerUp p) {
		// TODO Auto-generated method stub
		board.addPowerUps(p);
	}

	public void addReactionBlockers(ReactionBlocker tempRB) {
		// TODO Auto-generated method stub
		board.addReactionBlockers(tempRB);
	}

	


}
