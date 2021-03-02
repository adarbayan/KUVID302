package Domain;

public class LotaShield extends ShieldDecorator{
	
	Atoms atom;
	private double Lota_efficiency_boost = 0.1;	
	public LotaShield(Atoms atom) {
		this.atom = atom;
	}
	@Override
	public double calculateEfficiency() {
		// TODO Auto-generated method stub
		return (1 - atom.calculateEfficiency()) * Lota_efficiency_boost;
	}
	
	public int xSpeed() {
		return (int) (GameController.xSpeed*0.93);
	}
	public int ySpeed() {
		return (int) (GameController.ySpeed*0.93);
	}

}
