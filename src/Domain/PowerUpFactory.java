package Domain;

public class PowerUpFactory {
	
	public static PowerUp createPowerUp(int type, int xPos, int yPos, int radius, double xspeed, double yspeed, int unitLengthL){
		
		
		PowerUp powerUp;
		
		if(type==0){
			powerUp= new PowerUpAlpha(xPos,yPos,radius,xspeed,yspeed,unitLengthL);
		}else if (type==1){
			powerUp= new PowerUpBeta(xPos,yPos,radius,xspeed,yspeed,unitLengthL);
		}else if (type==2){
			powerUp= new PowerUpGamma(xPos,yPos,radius,xspeed,yspeed,unitLengthL);
		}else if (type==3){
			powerUp= new PowerUpSigma(xPos,yPos,radius,xspeed,yspeed,unitLengthL);
		}else{
			return null;
		}
		return powerUp;
		
	}
}

