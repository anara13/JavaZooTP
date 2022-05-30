package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.modele.Mangeable;
import org.formation.rasolofoharison.zoo.modele.technique.BeurkException;
import org.junit.jupiter.api.Test;

class GazelleTests {

	private static Gazelle moi = new Gazelle("Moaa",3,60,10);

	@Test
	void testGetInfos() {
		assertEquals("je suis un(e) Gazelle je m'appelle Moaa j'ai 3 an(s) et je pèse 60.0 kg et mes cornes font 10 cm", moi.getInfos());
	}

	@Test
	void testManger() {
		double poids = 0;
		int cornes = 0;
		
		poids = moi.getPoids();
		cornes = moi.getLgCornes();
		
		assertEquals(60.0, poids);
		assertEquals(10, cornes);
		moi.manger();
		assertEquals(poids+0.4, moi.getPoids());
		assertEquals(cornes+2, moi.getLgCornes());
		for(int i = 0; i < 200; i++) {
			moi.manger();
		}
		assertTrue(moi.getPoids() < 150.0);
		moi.setPoids(poids);
		moi.setLgCornes(cornes);
	}

	@Test
	void testDormir() {
		double poids = 0;
		
		poids = moi.getPoids();
		
		assertEquals(60.0, poids);
		moi.dormir();
		assertEquals(poids-0.15, moi.getPoids());
		for(int i = 0; i < 200; i++) {
			moi.dormir();
		}
		assertTrue(moi.getPoids() >= 0);
		moi.setPoids(poids);
	}

	@Test
	void testMangerMangeable() {
		Mangeable autre = new Gazelle();
		Exception exc = null;
		
		exc = assertThrows(BeurkException.class, () -> {moi.manger(autre);});
		assertEquals("Je n'aime pas ça", exc.getMessage());
	}

}
