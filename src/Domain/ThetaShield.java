package Domain;

import java.util.Random;

public class ThetaShield extends ShieldDecorator {
	
	Atoms atom;
	private double thetaSpeedReduce = 0.09;
	public ThetaShield(Atoms atom) {
		this.atom = atom;
	}
	Random random = new Random();
	private double Theta_efficiency_boost = 0.05 + (0.15 - 0.05) * random.nextDouble(); //generating random double between 0.05 and 0.15

	@Override
	public double calculateEfficiency() {	
		return (1 - atom.calculateEfficiency()) * Theta_efficiency_boost;
	}
	
	public int xSpeed() {
		return (int) (GameController.xSpeed*0.91);
	}
	public int ySpeed() {
		return (int) (GameController.ySpeed*0.91);
	}
}
