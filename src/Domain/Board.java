package Domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Board {


	private int atomNumber;
	private int moleculeNumber;
	private int reactionBLockerNumber;
	private int powerUpsNumber;
	private int unitLengthL;
	static int[] numberOfGameObjects;

	public int score = 0;

	private  Gun g = new Gun(305, 500, unitLengthL, 0);
	
	public static ArrayList<Atoms> atomList;
	public static ArrayList<Molecule> moleculeList;
	public static ArrayList<ReactionBlocker> reactionBlockers;

	public static ArrayList<PowerUp> powerUps;
	
	LocalFile locafile = new LocalFile();

	
	public static int currentSize;

	public Board(int[] numberOfGameObjects, int unitLengthL) {
		System.out.println("Board is created");
		
		this.unitLengthL = unitLengthL;
		Board.numberOfGameObjects = numberOfGameObjects;
		System.out.println("L is:" + unitLengthL);

		atomList = new ArrayList<Atoms>();
		moleculeList = new ArrayList<Molecule>();
		reactionBlockers = new ArrayList<ReactionBlocker>();
		
		powerUps = new ArrayList<PowerUp>();
		
		createPowerUps();


		g.setVel(numberOfGameObjects[16]/10);
		System.out.println("Velo:" + g.getVel());
		g.setRotAngle(10);

	}
	public void localSaver() throws IOException {
		LocalFile.savedMolecules = MoleculeList();
		LocalFile.savedAtoms = AtomList();
		LocalFile.savedReactionBlockers =ReactionBlockerList();
		LocalFile.savedPowerUps =PowerUpList();
		ArrayList<int[]> numberOfElementsArrays = new ArrayList<int[]>(Arrays.asList(numberOfGameObjects));
		LocalFile.savedNumberOfMolecules = numberOfElementsArrays;
		locafile.upload();

	}

	public void localLoad() throws IOException {
		LocalFile.savedMolecules = MoleculeList();
		LocalFile.savedAtoms = AtomList();
		LocalFile.savedReactionBlockers = ReactionBlockerList();
		LocalFile.savedPowerUps = PowerUpList();
		ArrayList<int[]> numberOfElementsArrays = new ArrayList<int[]>(Arrays.asList(numberOfGameObjects));
		LocalFile.savedNumberOfMolecules = numberOfElementsArrays;
		locafile.download();

	}

	public void mongoSaver() throws IOException {
		MongoDataBase mongoDb = new MongoDataBase();
		mongoDb.savedMolecules = MoleculeList();
		mongoDb.savedAtoms = AtomList();
		mongoDb.savedReactionBlockers =ReactionBlockerList();
		mongoDb.savedPowerUps = PowerUpList();
		ArrayList<int[]> numberOfElementsArrays = new ArrayList<int[]>(Arrays.asList(numberOfGameObjects));
		mongoDb.savedNumberOfMolecules = numberOfElementsArrays;
		mongoDb.main(null);
	}

	
	
	
	public void createPowerUps() {
		int radius = (int) (unitLengthL*0.5);
		
		Random rand = new Random();
		//here, the power up number from building mode should be used for the initial power up creation
		int numOfAlphaPU = numberOfGameObjects[12];
		int numOfBetaPU = numberOfGameObjects[13];
		int numOfGammaPU = numberOfGameObjects[14];
		int numOfSigmaPU = numberOfGameObjects[15];


	
		//alpha power up creation
		for (int i = 0; i < numOfAlphaPU; i++) {
			int xb = rand.nextInt(500);
			int yb = -(rand.nextInt(550)+50);
			int type = 0;
			PowerUp pu1 = PowerUpFactory.createPowerUp(type, xb, yb, radius,1,0, unitLengthL);
			
	
			powerUps.add(pu1);
		}
		//beta power up creation
		for (int i = 0; i < numOfBetaPU; i++) {
			int xb = rand.nextInt(500);
			int yb = -(rand.nextInt(550)+50);
			int type = 1;
			PowerUp pu2 = PowerUpFactory.createPowerUp(type, xb, yb, radius,1,0, unitLengthL);

			powerUps.add(pu2);
		}
		//gamma power up creation
		for (int i = 0; i < numOfGammaPU; i++) {
			int xb = rand.nextInt(500);
			int yb = -(rand.nextInt(550)+50);
			int type = 2;
			PowerUp pu3 = PowerUpFactory.createPowerUp(type, xb, yb, radius,1,0, unitLengthL);

			powerUps.add(pu3);
		}
		//sigma power up creation
		for (int i = 0; i < numOfSigmaPU; i++) {
			int xb = rand.nextInt(500);
			int yb = -(rand.nextInt(550)+50);
			int type = 3;
			PowerUp pu4 = PowerUpFactory.createPowerUp(type, xb, yb, radius,1,0, unitLengthL);

			powerUps.add(pu4);
		}
		Collections.shuffle(powerUps); 
	}
	

	public static ArrayList<Molecule> getAllMolecules() {
		return moleculeList;
	}
	
	public static ArrayList<ReactionBlocker> getAllReactionBlockers() {
		return reactionBlockers;
	}
	

	public static ArrayList<PowerUp> getAllPowerUps() {
		return powerUps;
	}

	public static void setAllMolecules(ArrayList<Molecule> allMolecules) {
		Board.moleculeList = allMolecules;
	}

	public void addAtoms(Atoms a) {
		atomList.add(a);
	}
	
	public void addMolecules(Molecule m) {
		moleculeList.add(m);
	}
	
	public int[] getNumberOfGameObjects() {
		return numberOfGameObjects;
	}

	public void setNumberOfGameObjects(int[] numberOfGameObjects) {
		this.numberOfGameObjects = numberOfGameObjects;
	}

	public int getAtomNumber() {
		return atomNumber;
	}

	public void setAtomNumber(int atomNumber) {
		this.atomNumber = atomNumber;
	}

	public int getMoleculeNumber() {
		return moleculeNumber;
	}

	public void setMoleculeNumber(int moleculeNumber) {
		this.moleculeNumber = moleculeNumber;
	}

	public int getReactionBLockerNumber() {
		return reactionBLockerNumber;
	}

	public void setReactionBLockerNumber(int reactionBLockerNumber) {
		this.reactionBLockerNumber = reactionBLockerNumber;
	}

	public int getPowerUpsNumber() {
		return powerUpsNumber;
	}

	public void setPowerUpsNumber(int powerUpsNumber) {
		this.powerUpsNumber = powerUpsNumber;
	}

	public static ArrayList<Atoms> AtomList() {
		return atomList;
		
	}

	public static void setAtomList(ArrayList<Atoms> atomList) {
		Board.atomList = atomList;
	}
	
	public static ArrayList<Molecule> MoleculeList() {
		return moleculeList;
	}

	public static void setMoleculeList(ArrayList<Molecule> moleculeList) {
		Board.moleculeList = moleculeList;
	}
	
	
	public static ArrayList<Molecule> getMoleculeList() {
		return moleculeList;
	}
	
	public static ArrayList<ReactionBlocker> ReactionBlockerList() {
		return reactionBlockers;
	}

	public static void setReactionBlockerList(ArrayList<ReactionBlocker> reactionBlockerList) {
		Board.reactionBlockers = reactionBlockerList;
	}
	
	
	public static ArrayList<ReactionBlocker> getReactionBlockerList() {
		return reactionBlockers;
	}
	
	public static ArrayList<PowerUp> PowerUpList() {
		return powerUps;
	}

	public static void setPowerUpList(ArrayList<PowerUp> powerUpList) {
		Board.powerUps = powerUpList;
	}
	

	public static void setmStructure(int mStructure) {
		numberOfGameObjects[17] = mStructure;
		System.out.printf("Board setmStructure: %d\n", mStructure);
	}


	public int moveGun(String input) {
		
		if (input.equals("right")) {
			//System.out.println(unitLengthL);
			//System.out.println(g.getVel());
			return g.getVel();
		} 
		else if (input.equals("left"))
		{
			return -g.getVel();
		}
		return 0;
	}
	
	public int rotateGun(String input)
	{
		if (input.equals("clockwise"))
		{
			return g.getRotAngle();
		}
		else if (input.equals("counter-clockwise"))
		{
			return -g.getRotAngle();
		}
		return 0;
	}

	public int getGunXPos() {
		return g.getxPos();
	}
	
	public int getGunYPos() {
		return g.getyPos();
	}


	public void addPowerUps(PowerUp p) {
		// TODO Auto-generated method stub
		powerUps.add(p);
	}




	public void addReactionBlockers(ReactionBlocker tempRB) {
		// TODO Auto-generated method stub
		reactionBlockers.add(tempRB);
	}



}