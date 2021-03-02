package Domain;

public class Health {
	private static int health;
	
	public Health(int health) {
		this.health = health;
	}

	public static int getHealth() {
		return health;
	}

	public static void setHealth(int health) {
		Health.health = health;
	}
	
	
}