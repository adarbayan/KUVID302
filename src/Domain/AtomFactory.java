package Domain;
import java.util.ArrayList;
import java.util.Random;

import UI.GameEngine;
// Factory
public class AtomFactory {
	
	
	public static Atoms createAtom(String type){
		
		Atoms atom;
		int length = 10;
		int width = length;
		double xSpeed = 0;
		double ySpeed = 0;
		int xPosDefault = 22000;
		int yPosDefault = 22000;
		ArrayList <ShieldDecorator> shields = new ArrayList<ShieldDecorator>();
		
		int alphaNeutronArray[] = {7, 8, 9};
		int betaNeutronArray[] = {15, 16, 17, 18, 21};
		int gammaNeutronArray[] = {29, 32, 33};
		int sigmaNeutronArray[] = {63, 64, 67};
		
		int alphaProton = 8;
		int betaProton = 16;
		int gammaProton = 32;
		int sigmaProton = 64;
		
		double alphaEff = 0.85;
		double betaEff = 0.9;
		double gammaEff = 0.8;
		double sigmaEff = 0.7;

		if(type.equals("alpha-atom")){
			atom= new AtomAlpha(xPosDefault,xPosDefault,length,width,alphaNeutronArray[getRandomNeutron(alphaNeutronArray.length)], alphaProton, alphaEff, xSpeed, ySpeed, shields);
			
		}else if (type.equals("beta-atom")){
			atom= new AtomBeta(xPosDefault,xPosDefault,length,width,betaNeutronArray[getRandomNeutron(betaNeutronArray.length)], betaProton, betaEff, xSpeed, ySpeed, shields);
			
		}else if (type.equals("sigma-atom")){
			atom= new AtomSigma(xPosDefault,xPosDefault,length,width,sigmaNeutronArray[getRandomNeutron(sigmaNeutronArray.length)], gammaProton, gammaEff, xSpeed, ySpeed, shields);
			
		}else if (type.equals("gamma-atom")){
			atom= new AtomGamma(xPosDefault,xPosDefault,length,width,gammaNeutronArray[getRandomNeutron(gammaNeutronArray.length)], sigmaProton, sigmaEff, xSpeed, ySpeed, shields);
			
		}else{
			return null;
		}
		return atom;
		
	}
	
	public static int getRandomNeutron(int arraySize){
		Random random = new Random();
		return random.nextInt(arraySize);
	}
}