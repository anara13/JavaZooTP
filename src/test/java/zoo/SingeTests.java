package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.formation.rasolofoharison.zoo.modele.Singe;
import org.junit.jupiter.api.Test;

class SingeTests {

	private static Singe moi = new Singe("Francis",4,15);

	@Test
	void testGetInfos() {
		assertEquals("je suis un(e) Singe je m'appelle Francis j'ai 4 an(s) et je pèse 15.0 kg", moi.getInfos());
	}

	@Test
	void testManger() {
		double poids = 0;
		
		poids = moi.getPoids();
		
		assertEquals(15.0, poids);
		moi.manger();
		assertEquals(poids+0.8, moi.getPoids());
		for(int i = 0; i < 200; i++) {
			moi.manger();
		}
		assertTrue(moi.getPoids() < 150.0);
		moi.setPoids(poids);
	}

}
