package zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.rasolofoharison.zoo.controleur.Singleton;
import org.junit.jupiter.api.Test;

class SingletonTest {

	@Test
	void testGetInstance() {
		Singleton s = Singleton.getInstance();
		assertEquals(s, Singleton.getInstance());
	}

}
