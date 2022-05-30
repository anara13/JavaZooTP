package org.formation.rasolofoharison.zoo.modele.technique;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Lion;
import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.service.CagePOJO;
import org.junit.jupiter.api.Test;

class UtilitaireTest {
		

	@Test
	void testPojoToCage() {
		CagePOJO cp = new CagePOJO(100,200,null,null,0,0, null);
		Cage cage = null;
		cage = Utilitaire.pojoToCage(cp);
		assertEquals(cage.getOccupant(), null);
		assertEquals(100, cage.getX());
		assertEquals(200, cage.getY());
		
		cp = new CagePOJO(100,200,"Lion","essai",2,123.4, null);
		cage = Utilitaire.pojoToCage(cp);//soucis n'affecte pas les valeurs
		assertNotNull(cage.getOccupant());
		assertEquals(Lion.class, cage.getOccupant().getClass());
		assertEquals("essai", cage.getOccupant().getNom());
		assertEquals(2, cage.getOccupant().getAge());
		assertEquals(123.4, cage.getOccupant().getPoids());
		
		cp = new CagePOJO(100,200,"Lion","essai",2,123.4, null);
		cage = Utilitaire.pojoToCage(cp);
		assertNotNull(cage.getOccupant());
		assertEquals(Lion.class, cage.getOccupant().getClass());
		assertEquals("essai", cage.getOccupant().getNom());
		assertEquals(2, cage.getOccupant().getAge());
		assertEquals(123.4, cage.getOccupant().getPoids());
		//assertEquals(99, ((Gazelle)cage.getOccupant()).getLgCornes());
	}
	
	@Test
	void testCageToPojoCagePOJO(){
		

			Cage c = new Cage(200,300);
			CagePOJO cp = null;
			final Animal bete = new Lion("essia",3,177);
			
			cp = Utilitaire.cageToPojoCagePOJO(c);
			assertNull(cp.getCodeAnimal());
			assertEquals(c.getX(), cp.getX());
			assertEquals(c.getY(), cp.getY());
			
			c.ouvrir();
			assertDoesNotThrow(()->{c.entrer(bete);});
			c.fermer();
			cp = Utilitaire.cageToPojoCagePOJO(c);
			assertEquals(bete.getClass().getSimpleName(), cp.getCodeAnimal());
			assertEquals(bete.getNom(), cp.getNom());
	}
	

}
