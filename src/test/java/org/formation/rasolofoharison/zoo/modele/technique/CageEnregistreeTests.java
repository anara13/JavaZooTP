package org.formation.rasolofoharison.zoo.modele.technique;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.technique.*;

import org.junit.jupiter.api.Test;

class CageEnregistreeTests {

	private CageEnregistree nouvelleCage = new CageEnregistree(null, null);
	
	@Test
	void estVideTest() {
		assertTrue(nouvelleCage.estVide());
	}
//	public void entrer(Animal a) throws PorteException, CagePleineException{
//		cage.entrer(a);
//		pojo=Utilitaire.cageToPojoCagePOJO(cage);
//		//FIXME appeler dao.modifier(pojo) à coder dans dao
//	}
//	
//	//TODO faire le sortir aussi et outes les méthodes de zoo pour juste les mettre simplement dans le projet
//	
//	public void nourrir() {//nourrir l'animal
//		if (cage.getOccupant() != null) {
//		cage.getOccupant().manger();
//		pojo.setPoids(cage.getOccupant().getPoids());
//		//FIXME appeler dao.modifier(pojo) à coder dans dao
//	}
//	}


	@Test
	void testgetOccupant() {
		
		assertEquals(null, nouvelleCage.getOccupant());
	}

}
