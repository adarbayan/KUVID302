package UI;

import Domain.AtomFactory;
import Domain.Atoms;
import Domain.Board;
import Domain.EtaShield;
import Domain.GameController;
import Domain.Health;
import Domain.LocalFile;
import Domain.LotaShield;
import Domain.Molecule;
import Domain.MoleculeFactory;
import Domain.MongoDataBase;
import Domain.PowerUp;
import Domain.PowerUpFactory;
import Domain.ReactionBlocker;
import Domain.ReactionBlockerFactory;
import Domain.Score;
import Domain.ThetaShield;
import Domain.ZetaShield;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class GameEngine extends JPanel implements KeyListener, ActionListener {
	public Timer timer;
	private int delay = 0;
	public static int[] numberOfElements;
	public static int unitlengthL;
	public static int xSpeed;
	public static int ySpeed;
	protected GunDisplay gun;
	protected MixerDisplay mixer;
	protected HealthDisplay heart;
	protected ScoreDisplay scoreDisp;
	public static Score score = new Score(0);
	public static Health health = new Health(100);
	public static GameController game;
	protected BackgroundDisplay playground;
	public static MoleculeDisplay molecule;
	public static ReactionBlockerDisplay reactionBlocker;
	private PowerUpDisplay powerUp;
	private SideBarDisplay sidebar;
	private int unitL;
	private String atomType = "alpha-atom";
	public long timeMillis;
	public long timeSeconds;
	public int atomSelect = 3;
	public int c = 0;
	public int c2 = 0;
	public int c3 = 0;
	public long startTime;
	public long elapsedTime;
	private AtomFactory atomFactory;
	private PowerUpFactory PUFactory;
	protected ArrayList<Atoms> atomList;
	private ArrayList<Molecule> moleculeList;
	private ArrayList<ReactionBlocker> reactionBlockerList;
	private ArrayList<PowerUp> powerUpList;
	private ArrayList<PowerUp> ShootPU = new ArrayList<PowerUp>();
	
	ArrayList<Integer> shields = new ArrayList<Integer>();

	public GameEngine(int[] numberOfGameElements, int unitLength) {

		setNumberOfElements(numberOfGameElements);
		setUnitLengthL(unitLength);

		gun = new GunDisplay();
		mixer = new MixerDisplay();
		heart = new HealthDisplay();
		scoreDisp = new ScoreDisplay();
		sidebar = new SideBarDisplay();
		sidebar.setNumberOfGameElements(numberOfElements);
		playground = new BackgroundDisplay();

		game = new GameController(numberOfGameElements, numberOfGameElements[16]);
		powerUp = new PowerUpDisplay();
		atomList = game.AtomList();
		moleculeList = game.MoleculeList();
		reactionBlockerList = game.ReactionBlockerList();
		powerUpList = game.PowerUpList();

		setSize(300, 300);
		setLayout(null);
		setVisible(true);

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		timer = new Timer(delay, this);
		timer.start();
		startTime = System.currentTimeMillis();
	}

	public void go() {
		ArrayList<PowerUp> allPowerUps = game.AllPowerUpsList();
		unitL = numberOfElements[16];
		powerUp.setPowerUps(allPowerUps);
		powerUp.initialSetUp(unitL);
	}

	public void paint(Graphics g) {
		elapsedTime = (new Date()).getTime() - startTime;
		sidebar.updateTime((int) elapsedTime / 1000);
		playground.paintComponent((Graphics2D) g);
		gun.paintComponent((Graphics2D) g);
		sidebar.paintComponent((Graphics2D) g);
		mixer.paintComponent((Graphics2D) g);
		heart.paintComponent((Graphics2D) g, health.getHealth());
		scoreDisp.paintComponent((Graphics2D) g, score.getScore());
		paintAtom((Graphics2D) g);
		paintMolecule((Graphics2D) g);
		paintPU((Graphics2D) g);
		paintRB((Graphics2D) g);
		// reactionBlocker.paintComponent((Graphics2D) g);
		powerUp.paintComponent((Graphics2D) g);
		g.dispose();
	}

	public void paintAtom(Graphics g) {
		int atomSelect_gun = 3;
		if (atomType == "alpha-atom") {
			atomSelect_gun = 0;
		} else if (atomType == "beta-atom") {
			atomSelect_gun = 1;
		} else if (atomType == "gamma-atom") {
			atomSelect_gun = 2;
		} else if (atomType == "sigma-atom") {
			atomSelect_gun = 3;
		} else if (atomType == "alpha") {
			atomSelect_gun = 4;
		} else if (atomType == "beta") {
			atomSelect_gun = 5;
		} else if (atomType == "gamma") {
			atomSelect_gun = 6;
		} else if (atomType == "sigma") {
			atomSelect_gun = 7;
		}

		if (atomSelect_gun < 4) {
			if (numberOfElements[atomSelect_gun] > 0) {
				AtomDisplay gunAtom = new AtomDisplay();
				gunAtom.setType(atomType);
				gunAtom.setxPos((int) xGetPos2());
				gunAtom.setyPos((int) yGetPos2());
				gunAtom.setLength(numberOfElements[16] / 3);
				gunAtom.setWidth(numberOfElements[16] / 3);
				gunAtom.paintComponent((Graphics2D) g);
			}
		} else if (atomSelect_gun < 8) {
			if (numberOfElements[atomSelect_gun + 8] > 0) {
				PowerUpDisplay gunPU = new PowerUpDisplay();
				gunPU.setImage(atomSelect_gun - 4);
				// System.out.println(gunPU.getImage());
				gunPU.paintGunPU((Graphics2D) g, (int) xGetPos(), (int) yGetPos(), numberOfElements[16] / 2);
			}
		} else {
			AtomDisplay gunAtom = new AtomDisplay();
			gunAtom.setType(atomType);
			gunAtom.setxPos(gun.xPos + numberOfElements[16] / 5);
			gunAtom.setyPos(gun.yPos - 10 * numberOfElements[16]);
			gunAtom.setLength(numberOfElements[16] / 3);
			gunAtom.setWidth(numberOfElements[16] / 3);
			gunAtom.paintComponent((Graphics2D) g);
		}

		if (atomList != null) {
			for (Atoms a : atomList) {
				AtomDisplay tempAtom = new AtomDisplay();
				tempAtom.setType(a.getType());
				tempAtom.setxPos(a.getxPos());
				tempAtom.setyPos(a.getyPos());
				tempAtom.setLength(numberOfElements[16] / 3);
				tempAtom.setWidth(numberOfElements[16] / 3);
				tempAtom.paintComponent((Graphics2D) g);
				if (a.getxPos() > 550 - a.getWidth())
					a.setxSpeed(-Math.abs(a.getxSpeed()));
				if (a.getxPos() < 0)
					a.setxSpeed(Math.abs(a.getxSpeed()));
				a.setxPos((int) (a.getxPos() + a.getxSpeed()));
				a.setyPos((int) (a.getyPos() + a.getySpeed()));
			}
		}
		if (ShootPU != null) {
			for (PowerUp p : ShootPU) {
				PowerUpDisplay gunPU = new PowerUpDisplay();
				gunPU.setImage(p.getType());
				gunPU.paintGunPU((Graphics2D) g, p.getXpos(), p.getYpos(), numberOfElements[16] / 2);
				if (p.getXpos() > 550 - numberOfElements[16] / 2)
					p.setxSpeed(-Math.abs(p.getxSpeed()));
				if (p.getXpos() < 0)
					p.setxSpeed(Math.abs(p.getxSpeed()));
				p.setXpos((int) (p.getXpos() + p.getxSpeed()));
				p.setYpos((int) (p.getYpos() + p.getySpeed()));
			}
		}
	}

	public void paintMolecule(Graphics g) {

		createMolecules();
		for (Molecule m : moleculeList) {
			MoleculeDisplay tempMolDisp = new MoleculeDisplay(m.getType(), numberOfElements[17]);
			tempMolDisp.setxPos(m.getxPos());
			tempMolDisp.setyPos(m.getyPos());
			// System.out.println("MOLEKUL" + tempMolDisp.getxPos() + " " +
			// tempMolDisp.getyPos());
			tempMolDisp.setLength(numberOfElements[16] / 2);
			tempMolDisp.setWidth(numberOfElements[16] / 2);
			tempMolDisp.paintComponent((Graphics2D) g);
			m.setVel(m.getVel() + 1);
			if (m.getVel() % 20 == 0) {
				m.setVel(1);
				m.setLeft(!m.isLeft());
				m.setRight(!m.isRight());
			}
			if (!m.isLeft() && !m.isRight()) {
				m.setxPos((int) (m.getxPos() + m.getxSpeed()));
			} else if (m.isLeft() && !m.isRight() && (m.getyPos() > m.getType() * 710 / 4)) {
				m.setxPos((int) (m.getxPos() + 2));
			} else if (!m.isLeft() && m.isRight() && (m.getyPos() > m.getType() * 710 / 4)) {
				m.setxPos((int) (m.getxPos() - 2));
			}
			m.setyPos((int) (m.getyPos() + m.getySpeed()));

		}
	}
	
	public void paintRB(Graphics g) {

		createRB();
		for (ReactionBlocker r : reactionBlockerList) {
			ReactionBlockerDisplay temRBDisp = new ReactionBlockerDisplay(r.getType(), numberOfElements[17]);
			temRBDisp.setxPos(r.getxPos());
			temRBDisp.setyPos(r.getyPos());
			temRBDisp.setLength(numberOfElements[16] / 2);
			temRBDisp.setWidth(numberOfElements[16] / 2);
			temRBDisp.paintComponent((Graphics2D) g);
			r.setxPos((int) (r.getxPos() + r.getxSpeed()));
			r.setyPos((int) (r.getyPos() + r.getySpeed()));
		}

	}

	public void paintPU(Graphics g) {

		createPU();
		for (PowerUp p : powerUpList) {
			PowerUpDisplay tempPUDisp = new PowerUpDisplay();
			tempPUDisp.setImage(p.getType());
			tempPUDisp.setxPos(p.getXpos());
			tempPUDisp.setyPos(p.getYpos());
			tempPUDisp.setLength(numberOfElements[16] / 2);
			tempPUDisp.paintComponent((Graphics2D) g);
			p.setXpos((int) (p.getXpos() + p.getxSpeed()));
			p.setYpos((int) (p.getYpos() + p.getySpeed()));
		}
	}

	

	public void createMolecules() {
		Random random = new Random();
		int tempType = random.nextInt(4);

		c2 += 1;
		if (c2 == 40) {
			if (numberOfElements[tempType + 4] > 0) {
				Molecule tempMol = MoleculeFactory.createMolecule(tempType);
				tempMol.setxSpeed(0);
				tempMol.setySpeed(numberOfElements[16] / 15);
				game.addMolecules(tempMol);
				numberOfElements[tempType + 4] -= 1;
				c2 = 0;
			}
		}
	}

	public void createRB() {
		Random random = new Random();
		int tempType = random.nextInt(4);

		c3 += 1;
		if (c3 == 10) {
			if (numberOfElements[tempType + 8] > 0) {
				ReactionBlocker tempRB = ReactionBlockerFactory.createReactionBlocker(tempType);
				System.out.println(tempRB.getType());
				tempRB.setxSpeed(0);
				tempRB.setySpeed(numberOfElements[16] / 15);
				game.addReactionBlockers(tempRB);
				numberOfElements[tempType + 8] -= 1;
			}
			c3 = 0;
		}
	}

	public void createPU() {
		Random random = new Random();
		int tempType = random.nextInt(4);
		int xPos = random.nextInt(500);
		int yPos = -50;
		int radius = numberOfElements[16] / 2;
		double xspeed = 0;
		double yspeed = numberOfElements[16] / 15;

		c += 1;
		if (c == 40) {
			PowerUp tempPU = PowerUpFactory.createPowerUp(tempType, xPos, yPos, radius, xspeed, yspeed,
					numberOfElements[16]);
			tempPU.setxSpeed(0);
			tempPU.setySpeed(numberOfElements[16] / 15);
			game.addPowerUps(tempPU);
			c = 0;
		}
	}

	public void addShields(Integer type) {
		shields.add(type);
	}

	public double xGetSpeed() {
		return (Math.sin(Math.toRadians(gun.rotateAngle)) * numberOfElements[16] / 15);
	}

	public double yGetSpeed() {
		return (Math.cos(Math.toRadians(gun.rotateAngle)) * numberOfElements[16] / 15);
	}

	public double xGetPos() {
		return (Math.sin(Math.toRadians(gun.rotateAngle)) * 40 + gun.xPos + 10);
	}

	public double yGetPos() {
		// System.out.println(gun.rotateAngle);
		return (507 - Math.cos(Math.toRadians(gun.rotateAngle)) * 30);
	}

	public double xGetPos2() {
		return (Math.sin(Math.toRadians(gun.rotateAngle)) * 30 + gun.xPos + 15);
	}

	public double yGetPos2() {
		// System.out.println(gun.rotateAngle);
		return (515 - Math.cos(Math.toRadians(gun.rotateAngle)) * 30);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		collision();
		// System.out.println(health.getHealth());
		while (health.getHealth() < 1) {
			System.out.println("You Lose");
		}
		// System.out.println(health.getHealth());
	}

	public void healthUpdate(int x1, int y1, int x2, int y2) {
		health.setHealth((int) (health.getHealth() - (500 / distance(x1, x2, y1, y2))));
	}



	public void collision() {
		// TODO Auto-generated method stub
		Iterator<Molecule> itr2 = moleculeList.iterator();
		while (itr2.hasNext()) {
			Molecule m = itr2.next();
			if (m.getyPos() > 620) {
				itr2.remove();
				break;
			}
			Iterator<Atoms> itr = atomList.iterator();
			while (itr.hasNext()) {
				Boolean atomExists = true; // prevents to remove an atom more than once
				Atoms a = itr.next();
				if (a.getyPos() > 620) {
					itr.remove();
					break;
				}
				if (a.getyPos() < 0) {
					itr.remove();
					atomExists = false;
					break;
				}
				int atomType1 = 4;
				if (a.getType().equals("alpha-atom")) {
					atomType1 = 0;
				} else if (a.getType().equals("beta-atom")) {
					atomType1 = 1;
				} else if (a.getType().equals("gamma-atom")) {
					atomType1 = 2;
				} else if (a.getType().equals("sigma-atom")) {
					atomType1 = 3;
				}

				if ((distance(a.getxPos(), a.getyPos(), m.getxPos(), m.getyPos()) < (a.getLength() + m.getLength()))
						&& m.getType() == atomType1) {
					boolean flag = true; // check if there is any ReactionBlocker in the radius
					if (flag && atomExists) {
						score.setScore(score.getScore() + a.calculateEfficiency());
						itr.remove();
						atomExists = false;
						itr2.remove();
						break;
					}
				}
			}
		}
		Iterator<PowerUp> itr4 = powerUpList.iterator();
		while (itr4.hasNext()) {
			PowerUp p = itr4.next();
			if (p.getYpos() > 477) {
				if (Math.abs(p.getXpos() - gun.xPos) < 50) {
					itr4.remove();
					if (p.getType() == 0) {
						numberOfElements[12] += 1;
					} else if (p.getType() == 1) {
						numberOfElements[13] += 1;
					} else if (p.getType() == 2) {
						numberOfElements[14] += 1;
					} else {
						numberOfElements[15] += 1;
					}
					break;
				}
			}
		}
		Iterator<ReactionBlocker> itr5 = reactionBlockerList.iterator();
		while (itr5.hasNext()) {
			ReactionBlocker r = itr5.next();
			if (r.getyPos() > 477) {
				if (Math.abs(r.getxPos() - gun.xPos) < 50) {
					healthUpdate(r.getxPos(), r.getyPos(), gun.getX(), gun.getY());
					itr5.remove();
					break;
				}
			}
			Iterator<PowerUp> itr6 = ShootPU.iterator();
			while (itr6.hasNext()) {
				PowerUp p = itr6.next();
				if ((distance(p.getXpos(), p.getYpos(), r.getxPos(), r.getyPos()) < (numberOfElements[16] / 3))
						&& r.getType() == p.getType()) {
					itr5.remove();
					itr6.remove();
					break;
				}
			}
		}

	}

	public double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow((y1 - y2), 2)));
	}

	public double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow((y1 - y2), 2)));
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && gun.xPos < 563 - gun.wid) {
			gun.xPos += game.moveGun("right");
		}
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT && gun.xPos > 0) {
			gun.xPos += game.moveGun("left");
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			if (gun.rotateAngle < 90)
				gun.rotateAngle += game.rotateGun("clockwise");
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			if (gun.rotateAngle > -90)
				gun.rotateAngle += game.rotateGun("counter-clockwise");
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			if (atomType == "alpha") {
				atomSelect = 4;
			} else if (atomType == "beta") {
				atomSelect = 5;
			} else if (atomType == "gamma") {
				atomSelect = 6;
			} else if (atomType == "sigma") {
				atomSelect = 7;
			}
			if (atomSelect < 4 && numberOfElements[atomSelect] > 0) {
				Atoms tempAtom = atomFactory.createAtom(atomType);
				for (Integer type : shields) {
					switch (type) {
					case 0:
						tempAtom.addShields(type);
						break;
					case 1:
						tempAtom.addShields(type);
						break;
					case 2:
						tempAtom.addShields(type);
						break;
					case 3:
						tempAtom.addShields(type);
						break;
					}
				}
				shields.clear();
				tempAtom.setxPos((int) xGetPos2());
				tempAtom.setyPos((int) yGetPos2());
				tempAtom.setxSpeed(xGetSpeed());
				tempAtom.setySpeed(-yGetSpeed());
				game.addAtoms(tempAtom);
				if (atomType == "alpha-atom") {
					atomSelect = 0;
				} else if (atomType == "beta-atom") {
					atomSelect = 1;
				} else if (atomType == "gamma-atom") {
					atomSelect = 2;
				} else if (atomType == "sigma-atom") {
					atomSelect = 3;
				}
				if (atomSelect < 4)
					numberOfElements[atomSelect] -= 1;
			} else if (numberOfElements[atomSelect + 8] > 0) {
				PowerUp tempPU = PUFactory.createPowerUp(atomSelect - 4, (int) xGetPos(), (int) yGetPos(),
						numberOfElements[16] / 2, xGetSpeed(), -yGetSpeed(), numberOfElements[16]);
				if (tempPU != null) {
					tempPU.setxSpeed(xGetSpeed());
					tempPU.setySpeed(-yGetSpeed());
					System.out.println(tempPU.getySpeed());
					ShootPU.add(tempPU);
					numberOfElements[atomSelect + 8] -= 1;
				}
			}

		}
		if (arg0.getKeyCode() == KeyEvent.VK_A) {
			atomType = "alpha-atom";
			atomSelect = 0;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_S) {
			atomType = "beta-atom";
			atomSelect = 1;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_D) {
			atomType = "gamma-atom";
			atomSelect = 2;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_F) {
			atomType = "sigma-atom";
			atomSelect = 3;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_Z) {
			atomType = "alpha";
			atomSelect = 4;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_X) {
			atomType = "beta";
			atomSelect = 5;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_C) {
			atomType = "gamma";
			atomSelect = 6;
		}
		if (arg0.getKeyCode() == KeyEvent.VK_V) {
			atomType = "sigma";
			atomSelect = 7;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_B) {
			sidebar.blenderCount++;
		}

		if (arg0.getKeyCode() == KeyEvent.VK_0) {
			sidebar.blenderCount = 0;
			if (numberOfElements[0] >= 2) {
				numberOfElements[0] = numberOfElements[0] - 2;
				numberOfElements[1] = numberOfElements[1] + 1;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_1) {

			sidebar.blenderCount = 1;
			if (numberOfElements[0] >= 3) {
				numberOfElements[0] -= 3;
				numberOfElements[2] += 1;
			}

		}

		if (arg0.getKeyCode() == KeyEvent.VK_2) {

			sidebar.blenderCount = 2;
			if (numberOfElements[0] >= 4) {
				numberOfElements[0] -= 4;
				numberOfElements[3] += 1;
			}

		}

		if (arg0.getKeyCode() == KeyEvent.VK_3) {
			sidebar.blenderCount = 3;
			if (numberOfElements[1] >= 2) {
				numberOfElements[1] -= 2;
				numberOfElements[2] += 1;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_4) {
			sidebar.blenderCount = 4;
			if (numberOfElements[1] >= 3) {
				numberOfElements[1] -= 3;
				numberOfElements[3] += 1;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_5) {
			sidebar.blenderCount = 5;
			if (numberOfElements[2] >= 2) {
				numberOfElements[2] -= 2;
				numberOfElements[3] += 1;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_6) {
			sidebar.blenderCount = 6;
			if (numberOfElements[1] >= 1) {
				numberOfElements[1] -= 1;
				numberOfElements[0] += 2;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_7) {
			sidebar.blenderCount = 7;
			if (numberOfElements[2] >= 1) {
				numberOfElements[2] -= 1;
				numberOfElements[0] += 3;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_8) {
			sidebar.blenderCount = 8;
			if (numberOfElements[3] >= 1) {
				numberOfElements[3] -= 1;
				numberOfElements[0] += 4;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_9) {
			sidebar.blenderCount = 9;
			if (numberOfElements[2] >= 1) {
				numberOfElements[2] -= 1;
				numberOfElements[1] += 2;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_B) {
			sidebar.blenderCount = 10;
			if (numberOfElements[3] >= 1) {
				numberOfElements[3] -= 1;
				numberOfElements[1] += 3;
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_N) {
			sidebar.blenderCount = 11;
			if (numberOfElements[3] >= 1) {
				numberOfElements[3] -= 1;
				numberOfElements[2] += 2;
			}
		}

	}

	public static int[] getNumberOfElements() {
		return numberOfElements;
	}

	public static void setNumberOfElements(int[] numberOfElements) {
		GameEngine.numberOfElements = numberOfElements;
	}

	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static int getUnitLengthL() {
		return unitlengthL;
	}

	public static void setUnitLengthL(int unitlenghtL) {
		GameEngine.unitlengthL = unitlenghtL;
	}

	public ArrayList<Atoms> getAtomList() {
		return atomList;
	}

	public void setAtomList(ArrayList<Atoms> atomList) {
		this.atomList = atomList;
	}

	public MoleculeDisplay getMolecule() {
		return molecule;
	}

	public void setMolecule(MoleculeDisplay molecule) {
		this.molecule = molecule;
	}

	public ReactionBlockerDisplay getReactionBlocker() {
		return reactionBlocker;
	}

	public void setReactionBlocker(ReactionBlockerDisplay reactionBlocker) {
		this.reactionBlocker = reactionBlocker;
	}

	public PowerUpDisplay getPowerUp() {
		return powerUp;
	}

	public void setPowerUp(PowerUpDisplay powerUp) {
		this.powerUp = powerUp;
	}

}