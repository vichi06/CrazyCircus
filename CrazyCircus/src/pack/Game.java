package pack;

import java.util.ArrayList;

public class Game {

	/** list of players */
	private ArrayList<Player> players;
	private Paquet paquet;
	private Carte carteInitial;
	private Carte carteObjectif;
	private boolean answerFound;
	
	public Game(String[] allPlayers) {
		players = new ArrayList<>();
		registerPlayers(allPlayers);
		paquet = new Paquet();
		answerFound = false;
		getFirstCards();
	}
	
	/** Tells if the game is over */
	public boolean isFinished() {
		return carteInitial==null && paquet.isEmpty();
	}
	
	/** Register players */
	private void registerPlayers(String[] names) {
		for(String s : names) {
			Player pl = new Player(s);
			players.add(pl);
		}
	}
	
	/** Identify a player with only his name */
	public Player identify(String name) {
		assert(!players.isEmpty());
		for(Player p : players) {
			if(p.getId().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	/** make orders of the player and 
	 * @return a card corresponding to the player's moves */
	public Carte act(String order) {
		
		Carte c = new Carte();
		c.setCarteAs(carteInitial);
		
		String p = null;
		for(int i = 0; i < order.length(); i = i + 2) {
			//verify it is a two-letter word
			if(order.length()%2 == 0) {
				p = order.substring(i, i+2);
			}
			else {
				p = "";
			}
			//make orders if called
			if(p.equalsIgnoreCase("KI")) {
				c.makeKI();
			}
			if(p.equalsIgnoreCase("LO")) {
				c.makeLO();
			}
			if(p.equalsIgnoreCase("SO")) {
				c.makeSO();
			}
			if(p.equalsIgnoreCase("NI")) {
				c.makeNI();
			}
			if(p.equalsIgnoreCase("MA")) {
				c.makeMA();
			}	
		}
		return c;
	}
	
	/** Initialize the Initial Card and Objective Card with new cards drawn from the deck */
	private void getFirstCards() {
		assert(carteInitial == null && carteObjectif == null);
		
		carteInitial = paquet.piocherCarte();
		
		carteObjectif = paquet.piocherCarte();
	}
	
	 /** changes the Initial Card and Objective Card for a new round */
	public void enchainer() {
		assert(!isFinished());
		//carteInitial becomes carteObjectif
		carteInitial.setCarteAs(carteObjectif); 
		
		//carteObjectif becomes a new card from the deck
		if(!paquet.isEmpty()) {
			carteObjectif = paquet.piocherCarte();
		} else { carteInitial = null; }
		
		//all the players should not have already played in the new round
		for(Player p : players) {
			p.restart();
		}
		
		//the answer has to turn into 'not found'
		answerFound = false;
	}
	
	/** @return the last player of the list */
	public Player getLastPlayer() {
		assert(onePlayerLeft());
		
		for(Player p : players) {
			if(!p.hasPlayed()) {
				return p;
			}
		}
		return null;
	}
	
	/** @return true if one player is left */
	public boolean onePlayerLeft() {
		assert(!players.isEmpty());
		int cmpt = 0;
		for(Player p : players) {
			if(!p.hasPlayed()) {
				cmpt++;
			}
		}
		return cmpt==1;
	}
	
	/** turns answerFound into true */
	public void answerF() {
		answerFound = true;
	}
	
	/** @return end game display */
	public StringBuilder endGame() {
		assert(isFinished());
		this.classement();
		StringBuilder s= new StringBuilder();
		s.append("This is the end!" + "\n" + "Voici le classement :" + "\n");
		for(Player p : players) {
			s.append(p.getId() + " : " + p.getScore() + " points\n");
		} 
		s.append("Bravo " + players.get(0).getId() + ", vous avez gagné la partie avec un score de "
				+ players.get(0).getScore() + "!");
		return s;
	}
	
	/** @return the display of cards in a round*/
	public StringBuilder toStringBuilder() {
		StringBuilder s = new StringBuilder();
		s.append("\n");
		for(int i = Carte.MAX_TAILLE-1; i >=0 ; i--) {
			//first colon
			if(carteInitial.podiumBleu.size() > i) {
				if(carteInitial.getAnimalBAt(i).equals(ANIMAUX.ELEPHANT)) {
					s.append(carteInitial.getAnimalBAt(i) + "  ");		
				}
				else {
				s.append("  " + carteInitial.getAnimalBAt(i) + "    ");
				}
			}
			else { s.append("          "); } 
			
			//second colon
			if(carteInitial.podiumRouge.size() > i) {
				if(carteInitial.getAnimalRAt(i).equals(ANIMAUX.ELEPHANT)) {
					s.append(carteInitial.getAnimalRAt(i) + "       ");		
				}
				else {
				s.append("  " + carteInitial.getAnimalRAt(i) + "         ");
				}
			}
			else { s.append( "               "); }
			
			//third colon
			if(carteObjectif.podiumBleu.size() > i) {
				if(carteObjectif.getAnimalBAt(i).equals(ANIMAUX.ELEPHANT)) {
					s.append(carteObjectif.getAnimalBAt(i) + "  ");		
				}
				else {
				s.append("  " + carteObjectif.getAnimalBAt(i) + "    ");
				}
			}
			else { s.append( "          "); } 
			
			//fourth colon
			if(carteObjectif.podiumRouge.size() > i) {
				if(carteObjectif.getAnimalRAt(i).equals(ANIMAUX.ELEPHANT))
					s.append(carteObjectif.getAnimalRAt(i));
				else
					s.append("  " + carteObjectif.getAnimalRAt(i));
			}
			s.append("\n");	
		}
		
		s.append("  ----      ----    ==>    ----      ----\n"
				+ "  BLEU      ROUGE          BLEU      ROUGE\n"
				+ "--------------------------------------------"
				+ "\nKI : BLEU --> ROUGE NI : BLEU ˆ\r\n" + 
				"LO : BLEU <-- ROUGE MA : ROUGE ˆ\r\n" + 
				"SO : BLEU <-> ROUGE\n");
		
		return s;
	}
	
	/** @return Initial Card */
	public Carte getCarteInitial() {
		return carteInitial;
	}
	
	/** @return Objective Card */
	public Carte getCarteObjectif() {
		return carteObjectif;
	}
	
	/** @return true if answer is found during a round */
	public boolean isAnswerFound() {
		return answerFound;
	}
	
	/** trie les joueurs */
	private void classement() {
		for(int i = 0; i < players.size(); i++) {
			for(int y = i + 1; y < players.size(); y++) {
				if(players.get(i).getScore() < players.get(y).getScore()) {
					Player p = players.get(y);
					players.remove(y);
					players.add(i, p);
				}
				//trie par ordre alphabétique
				if(players.get(i).getScore() == players.get(y).getScore()) {
					if(players.get(y).getId().compareTo(players.get(i).getId()) < 0){
						Player p = players.get(y);
						players.remove(y);
						players.add(i, p);
					}
				}
			}
		}
	}
}
