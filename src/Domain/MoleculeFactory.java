package Domain;
import java.util.Random;

// Factory
import java.util.Random;
public class MoleculeFactory {
	
	
	public static Molecule createMolecule(int type){
		
		int length = 10;
		int width = length;
		double xSpeed = 0;
		double ySpeed = 0;
		Random random = new Random();
		int ran = random.nextInt(450);
		int yPos = -40;
		
		if (ySpeed < 0) {
	        throw new IllegalArgumentException("Fall rate cannot be negative.");
	    }
		
		Molecule mol;
		
		if(type==0){
			mol= new MoleculeAlpha(ran,yPos,length,width,random.nextInt(1)+1,xSpeed,ySpeed);
		}else if (type==1){
			mol= new MoleculeBeta(ran,yPos,length,width,random.nextInt(1)+1,xSpeed,ySpeed);
		}else if (type==2){
			mol= new MoleculeSigma(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else if (type==3){
			mol= new MoleculeGamma(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else{
			return null;
		}
		return mol;
		
	}
}