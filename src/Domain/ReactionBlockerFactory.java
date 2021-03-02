package Domain;

import java.util.Random;

public class ReactionBlockerFactory {
	
	public static ReactionBlocker createReactionBlocker(int type){
		
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
		
		
		ReactionBlocker reactionBlocker;
		
		if(type==0){
			reactionBlocker= new ReactionBlockerAlpha(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else if (type==1){
			reactionBlocker= new ReactionBlockerBeta(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else if (type==2){
			reactionBlocker= new ReactionBlockerGamma(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else if (type==3){
			reactionBlocker= new ReactionBlockerSigma(ran,yPos,length,width,0,xSpeed,ySpeed);
		}else{
			return null;
		}
		return reactionBlocker;
		
	}
}

