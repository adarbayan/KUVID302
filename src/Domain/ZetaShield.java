package Domain;

public class ZetaShield extends ShieldDecorator{
	
	Atoms atom;
	double Zeta_efficiency_boost = 0.2;
	public ZetaShield(Atoms atom) {
		this.atom = atom;
	}

	public double calculateEfficiency() {
		//(1 - shielded atom efficiency) * Zeta_efficiency_boost 
		if (atom.getProton() == atom.getNeutron()) {
			return (1-atom.calculateEfficiency()*Zeta_efficiency_boost);
		} else {
			return atom.calculateEfficiency();
		}
		
	}
	
	public int xSpeed() {
		return (int) (GameController.xSpeed*0.89);
	}
	public int ySpeed() {
		return (int) (GameController.ySpeed*0.89);
	}

}
