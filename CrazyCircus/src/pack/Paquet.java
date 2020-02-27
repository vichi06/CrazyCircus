package pack;

import java.util.LinkedList;
import java.util.Random;



public class Paquet {
	
	/** list of cards */
	private LinkedList<Carte> cartes;
	private Random rand;

	public Paquet() {
		cartes = new LinkedList<>();
		createCartes();
		rand = new Random();
	}
	
	/** @return true if a deck is empty */
	public boolean isEmpty() {
		return cartes.isEmpty();
	}
	
	/** choose a random card and take it off the deck
	 * @return a new card of the deck */
	public Carte piocherCarte() {
		assert(!this.isEmpty());
		Carte c = cartes.get(rand.nextInt(this.cartes.size()));
		cartes.remove(c);
		return c;
	}
	
	/** create all the cards in the deck */
	private void createCartes() {
		Carte c1 = new Carte();
		c1.podiumBleu.add(ANIMAUX.OURS);
		c1.podiumBleu.add(ANIMAUX.ELEPHANT);
		c1.podiumBleu.add(ANIMAUX.LION);
		cartes.add(c1);

		Carte c2 = new Carte();
		c2.podiumBleu.add(ANIMAUX.OURS);
		c2.podiumBleu.add(ANIMAUX.LION);
		c2.podiumBleu.add(ANIMAUX.ELEPHANT);
		cartes.add(c2);

		Carte c3 = new Carte();
		c3.podiumBleu.add(ANIMAUX.ELEPHANT);
		c3.podiumBleu.add(ANIMAUX.OURS);
		c3.podiumBleu.add(ANIMAUX.LION);
		cartes.add(c3);

		Carte c4 = new Carte();
		c4.podiumBleu.add(ANIMAUX.ELEPHANT);
		c4.podiumBleu.add(ANIMAUX.LION);
		c4.podiumBleu.add(ANIMAUX.OURS);
		cartes.add(c4);

		Carte c5 = new Carte();
		c5.podiumBleu.add(ANIMAUX.LION);
		c5.podiumBleu.add(ANIMAUX.ELEPHANT);
		c5.podiumBleu.add(ANIMAUX.OURS);
		cartes.add(c5);

		Carte c6 = new Carte();
		c6.podiumBleu.add(ANIMAUX.LION);
		c6.podiumBleu.add(ANIMAUX.OURS);
		c6.podiumBleu.add(ANIMAUX.ELEPHANT);
		cartes.add(c6);

		Carte c7 = new Carte();
		c7.podiumRouge.add(ANIMAUX.ELEPHANT);
		c7.podiumRouge.add(ANIMAUX.OURS);
		c7.podiumRouge.add(ANIMAUX.LION);
		cartes.add(c7);

		Carte c8 = new Carte();
		c8.podiumRouge.add(ANIMAUX.ELEPHANT);
		c8.podiumRouge.add(ANIMAUX.LION);
		c8.podiumRouge.add(ANIMAUX.OURS);
		cartes.add(c8);

		Carte c9 = new Carte();
		c9.podiumRouge.add(ANIMAUX.LION);
		c9.podiumRouge.add(ANIMAUX.ELEPHANT);
		c9.podiumRouge.add(ANIMAUX.OURS);
		cartes.add(c9);

		Carte c10 = new Carte();
		c10.podiumRouge.add(ANIMAUX.LION);
		c10.podiumRouge.add(ANIMAUX.OURS);
		c10.podiumRouge.add(ANIMAUX.ELEPHANT);
		cartes.add(c10);

		Carte c11 = new Carte();
		c11.podiumRouge.add(ANIMAUX.OURS);
		c11.podiumRouge.add(ANIMAUX.ELEPHANT);
		c11.podiumRouge.add(ANIMAUX.LION);
		cartes.add(c11);

		Carte c12 = new Carte();
		c12.podiumRouge.add(ANIMAUX.OURS);
		c12.podiumRouge.add(ANIMAUX.LION);
		c12.podiumRouge.add(ANIMAUX.ELEPHANT);
		cartes.add(c12);

		Carte c13 = new Carte();
		c13.podiumBleu.add(ANIMAUX.OURS);
		c13.podiumBleu.add(ANIMAUX.LION);
		c13.podiumRouge.add(ANIMAUX.ELEPHANT);
		cartes.add(c13);

		Carte c14 = new Carte();
		c14.podiumRouge.add(ANIMAUX.OURS);
		c14.podiumRouge.add(ANIMAUX.LION);
		c14.podiumBleu.add(ANIMAUX.ELEPHANT);
		cartes.add(c14);

		Carte c15 = new Carte();
		c15.podiumBleu.add(ANIMAUX.OURS);
		c15.podiumBleu.add(ANIMAUX.ELEPHANT);
		c15.podiumRouge.add(ANIMAUX.LION);
		cartes.add(c15);

		Carte c16 = new Carte();
		c16.podiumRouge.add(ANIMAUX.OURS);
		c16.podiumRouge.add(ANIMAUX.ELEPHANT);
		c16.podiumBleu.add(ANIMAUX.LION);
		cartes.add(c16);

		Carte c17 = new Carte();
		c17.podiumBleu.add(ANIMAUX.LION);
		c17.podiumBleu.add(ANIMAUX.OURS);
		c17.podiumRouge.add(ANIMAUX.ELEPHANT);
		cartes.add(c17);

		Carte c18 = new Carte();
		c18.podiumRouge.add(ANIMAUX.LION);
		c18.podiumRouge.add(ANIMAUX.OURS);
		c18.podiumBleu.add(ANIMAUX.ELEPHANT);
		cartes.add(c18);


		Carte c19 = new Carte();
		c19.podiumRouge.add(ANIMAUX.LION);
		c19.podiumRouge.add(ANIMAUX.ELEPHANT);
		c19.podiumBleu.add(ANIMAUX.OURS);
		cartes.add(c19);

		Carte c20 = new Carte();
		c20.podiumBleu.add(ANIMAUX.LION);
		c20.podiumBleu.add(ANIMAUX.ELEPHANT);
		c20.podiumRouge.add(ANIMAUX.OURS);
		cartes.add(c20);

		Carte c21 = new Carte();
		c21.podiumBleu.add(ANIMAUX.ELEPHANT);
		c21.podiumBleu.add(ANIMAUX.LION);
		c21.podiumRouge.add(ANIMAUX.OURS);
		cartes.add(c21);

		Carte c22 = new Carte();
		c22.podiumRouge.add(ANIMAUX.ELEPHANT);
		c22.podiumRouge.add(ANIMAUX.LION);
		c22.podiumBleu.add(ANIMAUX.OURS);
		cartes.add(c22);

		Carte c23 = new Carte();
		c23.podiumRouge.add(ANIMAUX.ELEPHANT);
		c23.podiumRouge.add(ANIMAUX.OURS);
		c23.podiumBleu.add(ANIMAUX.LION);
		cartes.add(c23);

		Carte c24 = new Carte();
		c24.podiumBleu.add(ANIMAUX.ELEPHANT);
		c24.podiumBleu.add(ANIMAUX.OURS);
		c24.podiumRouge.add(ANIMAUX.LION);
		cartes.add(c24);	
	}
}
