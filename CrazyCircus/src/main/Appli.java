package main;

import java.util.Scanner;

import pack.Game;
import pack.Player;

public class Appli {

	public static void main(String[] args) {
	
		Game game = new Game(args);

		Scanner sc = new Scanner(System.in);
			
		int nbreTours = 1;

		while(!game.isFinished()) {
			
			System.out.println("Tour numéro : " + nbreTours + "\n" + game.toStringBuilder());
		
			while(!game.isAnswerFound()) {
				sc = new Scanner(System.in);
				
				String name = sc.next(); 
				String order = sc.next();
				
				//if it corresponds to a player
				if(game.identify(name) != null){
					//define the player who is trying to win
					Player p = game.identify(name);
					//if the player has not already played
					if(!p.hasPlayed()){
						p.plays();
						if(game.getCarteObjectif().isEqualTo(game.act(order))){
							p.hasWon();
							game.answerF();
							System.out.println(p.getId() + " has won 1 point \n");
						} 
						else { System.out.println("wrong orders"); }
					} 
					else { System.out.println("player has already played"); }
				}
				else { System.out.println("player does not exist"); }
				
				if(game.onePlayerLeft() && !game.isAnswerFound()) {
					game.getLastPlayer().hasWon();
					game.answerF();
					System.out.println(game.getLastPlayer().getId() + " has won 1 point for not having played \n");
				}
			}
			nbreTours++;
			game.enchainer();
		}

		sc.close();
		
		System.out.println(game.endGame());
	}
}
