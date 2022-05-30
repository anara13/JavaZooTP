package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.modele.Lion;
import org.junit.jupiter.api.Test;

class LionTests {
	private static Lion leLion = new Lion("Gerard",12,  100);
	@Test
	void testManger() {
		double poids = 0;
		poids = leLion.getPoids();
		
		assertEquals(100.0, poids);
		leLion.manger();
		assertEquals(poids+1.9, leLion.getPoids());
		for(int i = 0; i < 200; i++) {
			leLion.manger();
		}
		assertTrue(leLion.getPoids() < 230.0);
//		leLion.setPoids(-10);
//		assertEquals(poids+1.9, leLion.getPoids());
//		leLion.setPoids(266);
//		assertEquals(poids+1.9, leLion.getPoids());
//		leLion.setPoids(poids);
	}

	@Test
	void testMangerGazelle() {
		double lePoids = 0;
		Gazelle gaz = new Gazelle("lady gaga",4,  60, 10);
		lePoids = leLion.getPoids();
		
		assertEquals(100.0, lePoids);
		leLion.manger(gaz);
		assertEquals(lePoids+(gaz.getPoids()/3), leLion.getPoids());
		leLion.setPoids(lePoids);
	}

	@Test
	void testCrier() {
		double lePoids = 0;
		lePoids = leLion.getPoids();
		assertEquals(100.0, lePoids);
		assertEquals("je rugis!!!! woaw!!!!!", leLion.crier());
		//perte de poids!!!!
		assertEquals(lePoids-0.003, leLion.getPoids());
		leLion.setPoids(lePoids);
	}

	@Test
	void testGetInfos() {
		assertEquals("je suis un(e) Lion je m'appelle Gerard j'ai 12 an(s) et je pèse 100.0 kg", leLion.getInfos());
	}

}
