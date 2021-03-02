package Domain;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LocalFile implements saveLoadInterface {

	public static ArrayList<Atoms> savedAtoms;
	public static ArrayList<Molecule> savedMolecules;
	public static ArrayList<ReactionBlocker> savedReactionBlockers;
	public static ArrayList<PowerUp> savedPowerUps;
	public static ArrayList<int[]> savedNumberOfMolecules;
	public static int[] numberOfGameObjects;

	ArrayList<int[]> moleculeSavedArray = new ArrayList<int[]>();

	ArrayList<int[]> reactionBlockerSavedArray = new ArrayList<int[]>();
	ArrayList<int[]> PowerUpsSavedArray = new ArrayList<int[]>();
	ArrayList<int[]> numberOfGameObjectsSavedArray = new ArrayList<int[]>();

	ArrayList<int[]> moleculeArray = new ArrayList<int[]>();
	ArrayList<double[]> atomArray = new ArrayList<double[]>();
	ArrayList<int[]> reactionBlockerArray = new ArrayList<int[]>();
	ArrayList<int[]> PowerUpsArray = new ArrayList<int[]>();
	ArrayList<int[]> numberOfGameObjectsArray = new ArrayList<int[]>();

//For molecule
	public void upload() throws IOException {
		for (Molecule m : savedMolecules) {
			if(m.getyPos()<=540) {
			int[] a = { m.getxPos(), m.getyPos(), m.getLength(), m.getWidth(), m.getType(), (int) m.getySpeed() };
			moleculeArray.add(a);
		}
		}
		for (Atoms a : savedAtoms) {

			double[] b = { a.getxPos(), a.getyPos(), a.getLength(), a.getWidth(), a.getNeutron(), a.getProton(),
					a.calculateEfficiency(), a.getxSpeed(), a.getySpeed() };
			atomArray.add(b);
		}
		for (ReactionBlocker r : savedReactionBlockers) {
			int[] c = { r.getxPos(), r.getyPos(), r.getLength(), r.getWidth(), r.getType(), (int) r.getySpeed() };
			reactionBlockerArray.add(c);
		}
		for (PowerUp d : savedPowerUps) {
			int[] c = { d.getXpos(), d.getYpos(), d.getRadius(), d.getType(), (int) d.getySpeed() };
			PowerUpsArray.add(c);
		}
		for (int[] d : savedNumberOfMolecules) {
			int[] c = d;
			numberOfGameObjectsArray.add(c);
		}
		PrintWriter pwM = null;
		PrintWriter pwRB = null;
		PrintWriter pwAtom = null;
		PrintWriter pwPU = null;
		PrintWriter pwNOE = null;

		FileOutputStream foM = null;
		FileOutputStream foRB = null;
		FileOutputStream foAtom = null;
		FileOutputStream foPU = null;
		FileOutputStream foNOE = null;

		File fileM = null;
		File fileRB = null;
		File fileAtom = null;
		File filePU = null;
		File fileNOE = null;
		try {
			fileM = new File("savedMolecules.txt");
			fileRB = new File("savedReactionBlockers.txt");
			fileAtom = new File("savedAtoms.txt");
			filePU = new File("savedPowerUps.txt");
			fileNOE = new File("savedNumberOfElements.txt");

			pwM = new PrintWriter(new FileOutputStream(fileM));
			pwRB = new PrintWriter(new FileOutputStream(fileRB));
			pwAtom = new PrintWriter(new FileOutputStream(fileAtom));
			pwPU = new PrintWriter(new FileOutputStream(filePU));
			pwNOE = new PrintWriter(new FileOutputStream(fileNOE));
			foM = new FileOutputStream(fileM);
			foRB = new FileOutputStream(fileRB);
			foAtom = new FileOutputStream(fileAtom);
			foPU = new FileOutputStream(filePU);
			foNOE = new FileOutputStream(fileNOE);

			for (int[] al : moleculeArray) {
				for (int i : al) {
					pwM.write(i + " ");

				}
				pwM.write("\n");

			}
			pwM.write("Molecules" + "\n");

			for (int[] al : reactionBlockerArray) {
				for (int i : al) {
					pwRB.write(i + " ");

				}
				pwRB.write("\n");
			}
			pwRB.write("Reaction Blockers" + "\n");

			for (double[] al : atomArray) {
				for (double i : al) {
					pwAtom.write(i + " ");

				}
				pwAtom.write("\n");
			}
			pwAtom.write("Atoms" + "\n");

			for (int[] al : PowerUpsArray) {
				for (int i : al) {
					pwPU.write(i + " ");

				}
				pwPU.write("\n");
			}
			pwPU.write("PowerUps" + "\n");

			for (int[] al : numberOfGameObjectsArray) {
				for (int i : al) {
					pwNOE.write(i + " ");

				}
				pwNOE.write("\n");

			}
			pwNOE.write("NumberOfGameObjects" + "\n");
		} finally {
			pwM.flush();
			pwRB.flush();
			pwAtom.flush();
			pwPU.flush();
			pwNOE.flush();
			pwM.close();
			pwRB.close();
			pwAtom.close();
			pwPU.close();
			pwNOE.close();
			foM.close();
			foRB.close();
			foAtom.close();
			foPU.close();
			foNOE.close();
		}

	}

	public void download() throws FileNotFoundException, IOException {
		int flag = 0;
		Scanner scanM = new Scanner(new File("savedMolecules.txt"));
		Scanner scanRB = new Scanner(new File("savedReactionBlockers.txt"));
		Scanner scanAtoms = new Scanner(new File("savedAtoms.txt"));
		Scanner scanPU = new Scanner(new File("savedPowerUps.txt"));
		Scanner scanNOE = new Scanner(new File("savedNumberOfElements.txt"));
		while (scanM.hasNextLine()) {
			String line;
			line = scanM.nextLine();
			String[] s = line.split(" ");
			int[] arr = new int[s.length];
			if (!line.equals("Molecules") && !line.equals("Reaction Blockers") && !line.equals("Atoms")
					&& !line.equals("PowerUps") && !line.equals("NumberOfGameObjects")) {

				for (int i = 0; i < s.length; i++) {
					arr[i] = Integer.parseInt(s[i]); // parses the integer of each string

				}
				ArrayList<Integer> moleculeSavedArray = new ArrayList<Integer>(arr.length);
				for (int i : arr) {
					moleculeSavedArray.add(i);
				}

			}
		}

		while (scanRB.hasNextLine()) {
			String line;
			line = scanRB.nextLine();
			String[] s = line.split(" ");
			int[] arr = new int[s.length];
			if (!line.equals("Molecules") && !line.equals("Reaction Blockers") && !line.equals("Atoms")
					&& !line.equals("PowerUps") && !line.equals("NumberOfGameObjects")) {

				for (int i = 0; i < s.length; i++) {
					arr[i] = Integer.parseInt(s[i]); // parses the integer of each string

				}
				ArrayList<Integer> ReactionBlockerSavedArray = new ArrayList<Integer>(arr.length);
				for (int i : arr) {
					ReactionBlockerSavedArray.add(i);
				}

			}
		}
		while (scanAtoms.hasNextLine()) {
			String line;
			line = scanAtoms.nextLine();
			String[] s = line.split(" ");
			int[] arr = new int[s.length];
			if (!line.equals("Molecules") && !line.equals("Reaction Blockers") && !line.equals("Atoms")
					&& !line.equals("PowerUps") && !line.equals("NumberOfGameObjects")) {

				for (int i = 0; i < s.length; i++) {
					arr[i] = Integer.parseInt(s[i]); // parses the integer of each string

				}
				ArrayList<Integer> AtomsSavedArray = new ArrayList<Integer>(arr.length);
				for (int i : arr) {
					AtomsSavedArray.add(i);
				}

			}
		}
		while (scanPU.hasNextLine()) {
			String line;
			line = scanPU.nextLine();
			String[] s = line.split(" ");
			int[] arr = new int[s.length];
			if (!line.equals("Molecules") && !line.equals("Reaction Blockers") && !line.equals("Atoms")
					&& !line.equals("PowerUps") && !line.equals("NumberOfGameObjects")) {

				for (int i = 0; i < s.length; i++) {
					arr[i] = Integer.parseInt(s[i]); // parses the integer of each string

				}
				ArrayList<Integer> powerUpsSavedArray = new ArrayList<Integer>(arr.length);
				for (int i : arr) {
					powerUpsSavedArray.add(i);
				}

			}
		}
		while (scanNOE.hasNextLine()) {
			String line;
			line = scanNOE.nextLine();
			String[] s = line.split(" ");
			int[] arr = new int[s.length];
			if (!line.equals("Molecules") && !line.equals("Reaction Blockers") && !line.equals("Atoms")
					&& !line.equals("PowerUps") && !line.equals("NumberOfGameObjects")) {

				for (int i = 0; i < s.length; i++) {
					arr[i] = Integer.parseInt(s[i]); // parses the integer of each string

				}
				ArrayList<Integer> numberOfElementsSavedArray = new ArrayList<Integer>(arr.length);
				for (int i : arr) {
					numberOfElementsSavedArray.add(i);
				}

			}
		}

	}
}
