package pack;

public class Player {

	//id of the player
	private String id;
	//score of the player
	private int score;
	//player's status 
	private boolean hasPlayed;
	
	public Player(String id) {
		this.id = id;
		score = 0;
		hasPlayed = false;
	}
	
	/** @return the id of the current player */
	public String getId() {
		return id;
	}
	
	/** @return the score of the current player */
	public int getScore() {
		return score;
	}
	
	/** a player cannot play anymore in the round */
	public void plays() {
		hasPlayed = true;
	}
	
	/** @return true if a player has already played */
	public boolean hasPlayed() {
		return this.hasPlayed;
	}
	
	/** give a point to a player */
	public void hasWon() {
		score++;
	}
	
	/** the player can play in the other round */
	public void restart() {
		hasPlayed = false;
	}
}
