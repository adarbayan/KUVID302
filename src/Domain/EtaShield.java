package Domain;
import java.lang.Math;

public class EtaShield extends ShieldDecorator{
	
	Atoms atom;
	private double Eta_efficiency_boost = 0.05;
	public EtaShield(Atoms atom) {
		this.atom = atom;
	}
	public double calculateEfficiency() {
		if (atom.getNeutron() != atom.getProton()){
			return(1 - atom.calculateEfficiency()) * Math.abs(atom.getNeutron() - atom.getProton()) / atom.getProton();
		}else{
			return(1 - atom.calculateEfficiency()) * Eta_efficiency_boost; 
		}
	}

	public int xSpeed() {
		return (int) (GameController.xSpeed*0.95);
	}
	public int ySpeed() {
		return (int) (GameController.ySpeed*0.95);
	}
}
