package pack;

import java.util.LinkedList;

public class Carte {

	public LinkedList<Enum<ANIMAUX>> podiumBleu;
	public LinkedList<Enum<ANIMAUX>> podiumRouge;
	public static final int MAX_TAILLE = 3;
	
	public Carte(){
		podiumBleu = new LinkedList<>();
		podiumRouge = new LinkedList<>();
	}
	
	/** @return a card */
	public String toString() {
		return podiumBleu.toString() + podiumRouge.toString();
	}

	/** @param i position of animal 
	 * @return animal at i in blue podium */
	public Enum<ANIMAUX> getAnimalBAt(int i) {
		return podiumBleu.get(i);
	}
	
	/** @param i position of animal 
	 * @return animal at i in red podium*/
	public Enum<ANIMAUX> getAnimalRAt(int i) {
		return podiumRouge.get(i);
	}
	
	/**   @param card c to compare
	 * @return true if the current card if equal to the c card */
	public boolean isEqualTo(Carte c) {
		
		//compare the lengths
		if(c.podiumBleu.size() != podiumBleu.size() || c.podiumRouge.size() != podiumRouge.size()) {
			return false;
		}
		
		//compare in blue
		for(int i = 0; i < podiumBleu.size(); i++) {
			if(c.podiumBleu.get(i) != podiumBleu.get(i)) {
				return false;
			}
		}
		
		//compare in red 
		for(int i = 0; i < podiumRouge.size() && i < podiumRouge.size(); i++) {
			if(c.podiumRouge.get(i) != podiumRouge.get(i)) {
				return false;
			}
		}
		
		return true;
	}

	/** add an animal in blue podium */
	public void addPodiumB(Enum<ANIMAUX> s) {
		if(animalMissing(s)){
			podiumBleu.add(s);
		}
	}
	
	/** add an animal in red podium */
	public void addPodiumR(Enum<ANIMAUX> s) {
		if(animalMissing(s)){
			podiumRouge.add(s);
		}	
	}
	
	/** set the card as a copy of another
	 * @param c card to copy
	 * @return copy of the card
	 */
	public Carte setCarteAs(Carte c) {
		this.podiumRouge = new LinkedList<>();
		this.podiumBleu = new LinkedList<>();
		
		for(Enum<ANIMAUX> s : c.podiumBleu) {
			this.addPodiumB(s);
		}
		for(Enum<ANIMAUX> s : c.podiumRouge) {
			this.addPodiumR(s);
		}
		return this;
	}
	
	public boolean animalMissing(Enum<ANIMAUX> e) {
		for(Enum<ANIMAUX> E : podiumBleu) {
			if(E==e) {
				return true;
			}
		}
		for(Enum<ANIMAUX> E : podiumRouge) {
			if(E==e) {
				return true;
			}
		}
		return false;
	}
	

	//---------------------ORDERS
	
	/** move blue top to red top */
	public void makeKI() {
		if(!podiumBleu.isEmpty()) {
			podiumRouge.add(podiumBleu.getLast());
			podiumBleu.removeLast();
		}
	}
	
	/** move red top to blue */
	public void makeLO() {
		if(!podiumRouge.isEmpty()) {
			podiumBleu.add(podiumRouge.getLast());	
			podiumRouge.removeLast();
		}
	}
	
	/** change blue top and red top */
	public void makeSO() {
		if(!podiumBleu.isEmpty() && !podiumRouge.isEmpty()) {
			Enum<ANIMAUX> a = podiumBleu.getLast();
			podiumBleu.removeLast();
			Enum<ANIMAUX> b = podiumRouge.getLast();
			podiumRouge.removeLast();
			
			podiumBleu.add(b);
			podiumRouge.add(a);
			
		}		
	}
	
	/** push bottom of blue to top */
	public void makeNI() {
		if(!podiumBleu.isEmpty() && podiumBleu.size() > 1) {
			podiumBleu.add(podiumBleu.getFirst());
			podiumBleu.removeFirst();
		}
	}
	
	/** push bottom of red to top */
	public void makeMA() {
		if(!podiumRouge.isEmpty() && podiumRouge.size() > 1) {
			podiumRouge.add(podiumRouge.getFirst());
			podiumRouge.removeFirst();
		}
	}

}

