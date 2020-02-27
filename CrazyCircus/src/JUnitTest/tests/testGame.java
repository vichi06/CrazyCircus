package JUnitTest.tests;

import org.junit.Assert;
import org.junit.Test;

import pack.ANIMAUX;
import pack.Carte;
import pack.Game;
import pack.Paquet;
import pack.Player;

public class testGame {
	
	//PLAYER
	@Test
	public void testPlayerName() throws Exception{
		Player p = new Player("Xavier");
		Assert.assertEquals("Xavier", p.getId());
	}
	
	@Test
	public void testPlayerScore() throws Exception{
		Player p = new Player("Xavier");
		Assert.assertEquals(0, p.getScore());
	}
	
	@Test
	public void testPlayerWins() throws Exception{
		Player p = new Player("Xavier");
		p.hasWon();
		Assert.assertEquals(1, p.getScore());
	}
	
	//CARTE
	@Test 
	public void testCarte() throws Exception {
		Carte c = new Carte();
		c.addPodiumB(ANIMAUX.OURS);
		c.addPodiumB(ANIMAUX.LION);
		c.addPodiumB(ANIMAUX.ELEPHANT);
		
		Carte ca = new Carte();
		c.addPodiumB(ANIMAUX.OURS);
		c.addPodiumB(ANIMAUX.LION);
		c.addPodiumB(ANIMAUX.ELEPHANT);
		
		Assert.assertTrue(c.isEqualTo(ca));
		
	}
	
	//PAQUET
	@Test
	public void testPaquet() throws Exception{
		Paquet p = new Paquet();
		Assert.assertFalse(p.isEmpty());
	}
	
	//GAME
	@Test 
	public void testGameOver() throws Exception{
		String[] s = {"a" , "b ", "c"};
		Game g = new Game(s);
		Assert.assertFalse(g.isFinished());
	}
	
	@Test
	public void testGameIdentify() throws Exception{
		String[] s = {"Xavier"};
		Game g = new Game(s);
		Assert.assertEquals("Xavier", g.identify("Xavier").getId());
	}
}
