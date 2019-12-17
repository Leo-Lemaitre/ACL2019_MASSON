package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Constants;
import Model.Hero;
import Model.Labyrinth;

public class Tests {

	static Hero heros;
	static Labyrinth l;
	
	@Before
	public void init() throws IOException{
		l=Labyrinth.getInstance();
		 System.out.println(l);
		 heros=l.getHeros();
		 heros.setPosColonne(2);
		 heros.setPosLigne(2);
		 System.out.println(heros.getPosLigne() +" "+heros.getPosColonne());
	}
	
	
	@Test
	public void testDeplacementUpLibre() {
		heros.changePosition(Constants.UP);
		assertEquals(1,heros.getPosLigne());
		assertEquals(2,heros.getPosColonne());
	}
	
	@Test
	public void testDeplacementBasLibre() {
		heros.changePosition(Constants.DOWN);
		assertEquals(3,heros.getPosLigne());
		assertEquals(2,heros.getPosColonne());
	}
	
	@Test
	public void testDeplacementLEFTLibre() {
		heros.changePosition(Constants.LEFT);
		assertEquals(2,heros.getPosLigne());
		assertEquals(1,heros.getPosColonne());
	}
	
	@Test
	public void testDeplacementDroiteLibre() {
		heros.changePosition(Constants.RIGHT);
		assertEquals(2,heros.getPosLigne());
		assertEquals(3,heros.getPosColonne());
	}
	
	/* A FAIRE Placer heros près d'un mur et aller a gauche en faire un pour toutes les directions
	 * 
	 */
	@Test
	public void testDeplacementLEFTMur() {
		heros.setPosLigne(2);
		heros.setPosColonne(1);
		heros.changePosition(Constants.LEFT);
		assertEquals(2,heros.getPosLigne());
		assertEquals(0,heros.getPosColonne());
	}
	
	@Test
	public void testDeplacementRIGHTMur() {
		heros.setPosLigne(2);
		heros.setPosColonne(1);
		heros.changePosition(Constants.RIGHT);
		assertEquals(2,heros.getPosLigne());
		assertEquals(2,heros.getPosColonne());
	}
	@Test
	public void testDeplacementUPMur() {
		heros.setPosLigne(2);
		heros.setPosColonne(3);
		heros.changePosition(Constants.UP);
		assertEquals(1,heros.getPosLigne());
		assertEquals(3,heros.getPosColonne());
	}
	@Test
	public void testDeplacementDOWNMur() {
		heros.setPosLigne(3);
		heros.setPosColonne(2);
		heros.changePosition(Constants.DOWN);
		assertEquals(4,heros.getPosLigne());
		assertEquals(2,heros.getPosColonne());
	}

	/**
	 * A FAIRE DAns toutes les directions
	 */
	@Test
	public void testDeplacementHorsLimitesLEFTMur() {
		heros.setPosLigne(1);
		heros.setPosColonne(1);
		heros.changePosition(Constants.LEFT);
		assertEquals(1,heros.getPosLigne());
		assertEquals(1,heros.getPosColonne());
		
	}
	
	@Test
	public void testDeplacementHorsLimitesRIGHTMur() {
		heros.setPosLigne(1);
		heros.setPosColonne(3);
		heros.changePosition(Constants.RIGHT);
		assertEquals(1,heros.getPosLigne());
		assertEquals(3,heros.getPosColonne());
		
	}
	
	@Test
	public void testDeplacementHorsLimitesUPMur() {
		heros.setPosLigne(1);
		heros.setPosColonne(3);
		heros.changePosition(Constants.UP);
		assertEquals(1,heros.getPosLigne());
		assertEquals(3,heros.getPosColonne());
		
	}
	
	@Test
	public void testDeplacementHorsLimitesDOWNMur() {
		heros.setPosLigne(3);
		heros.setPosColonne(1);
		heros.changePosition(Constants.DOWN);
		assertEquals(3,heros.getPosLigne());
		assertEquals(1,heros.getPosColonne());
		
	}
	
	
	@After
	public void fin(){
		 System.out.println(l);
	}

}
