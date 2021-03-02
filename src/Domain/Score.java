package Domain;

public class Score {
	private static double score;
	
	public Score(double score) {
		this.score = score;
	}

	public static double getScore() {
		return score;
	}

	public static void setScore(double score) {
		Score.score = score;
	}
	
	
}