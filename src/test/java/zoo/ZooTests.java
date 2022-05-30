package zoo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.formation.rasolofoharison.zoo.controleur.Zoo;
import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.modele.Singe;
import org.formation.rasolofoharison.zoo.modele.Visiteur;
import org.formation.rasolofoharison.zoo.modele.technique.CagePleineException;
import org.formation.rasolofoharison.zoo.modele.technique.PorteException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * Ces tests fonctionnent avec ou sans fichier de données.
 * On a 5 cages dont la 3ieme est vide
 *
 * @author jacques
 *
 */
class ZooTests {
	private static Zoo controleur;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		controleur = Zoo.getInstance();
	}

	@Test
	void testSingleton() {
		assertEquals(controleur, Zoo.getInstance());
	}
	@Test
	void testNourrir() {
		Animal premier = null;
		double poidsAvant = 0;
		assertEquals(5, controleur.getLesCages().size());
		//Cage VIDE
		assertNull(controleur.getLesCages().get(2).getOccupant());
		premier = controleur.getLesCages().get(0).getOccupant();
		poidsAvant = premier.getPoids();
		assertEquals("Cheeta", premier.getNom());
		assertTrue(premier instanceof Singe);
		controleur.nourrir();
		assertEquals(poidsAvant, premier.getPoids());
		premier.setPoids(poidsAvant);
	}

//	@Test
//	void testDevorer() {
//		Exception exc = null; 
//		Animal mangeur = null;
//		final Gazelle aManger = new Gazelle("oups", 3, 60, 10);
//		double poidsLion = 0;
//		Animal laGazelle = controleur.getLesCages().get(3).getOccupant();
//		
//		assertEquals(5, controleur.getLesCages().size());
//		//Cage VIDE
//		assertNull(controleur.getLesCages().get(2).getOccupant());
//		//singe (0) mange Gazelle (3)
//		assertEquals("Je n'aime pas ça", controleur.devorer(0, 3));
//		//		exc = assertThrows(BeurkException.class,() -> {controleur.devorer(0, 3);});
//		//singe (0) mange un lion (1)
////		exc = assertThrows(BeurkException.class,() -> {controleur.devorer(0, 1);});
//		assertEquals("INCOMPATIBLE", controleur.devorer(0, 1));
//		// lion(1) mange singe (4)
//		assertEquals("INCOMPATIBLE", controleur.devorer(1, 4));
//		//lion (1) mange gazelle (3)
//		poidsLion = controleur.getLesCages().get(1).getOccupant().getPoids();
//		assertEquals("Miam miam", controleur.devorer(1, 3));
//		assertEquals(poidsLion+(laGazelle.getPoids()/3), controleur.getLesCages().get(1).getOccupant().getPoids());
//		controleur.getLesCages().get(1).getOccupant().setPoids(poidsLion);
//		assertNull(controleur.getLesCages().get(3).getOccupant());
//		controleur.getLesCages().get(3).ouvrir();
//		assertDoesNotThrow(()->{controleur.getLesCages().get(3).entrer(laGazelle);});
//
//		controleur.getLesCages().get(3).fermer();
//		
//	}


	@Test
	void testGetInfos() {
		List<String> infos = null;
		assertEquals(5, controleur.getLesCages().size());
		//Cage VIDE
		assertNull(controleur.getLesCages().get(2).getOccupant());
		infos = controleur.getInfos();
		assertTrue(infos.get(0).startsWith("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta"));
		assertTrue(infos.get(infos.size()-1).startsWith("Cage [x=60, y=100]----je suis un(e) Singe je m'appelle Baloo"));
	}
	
	@Test
	void testEntrer() {
		assertEquals(0, controleur.denombrer());
		controleur.entrer();
		assertEquals(1, controleur.denombrer());
		for(int i = 0; i<Visiteur.MAX*2; i++) {
			controleur.entrer();
		}
		assertEquals("attendez un peu", controleur.entrer());
		assertEquals(Visiteur.MAX, controleur.denombrer());
		for(int i= 0; i<Visiteur.MAX;i++) {
			controleur.getLesVisiteurs()[i] = null;
		}
		System.gc();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0, controleur.denombrer());
	}
	
	@Test 
	void testSortir(){
		assertEquals(0, controleur.denombrer());
		for(int i= 0; i<Visiteur.MAX;i++) {
			controleur.getLesVisiteurs()[i] = new Visiteur();
			}
		assertEquals(Visiteur.MAX, controleur.denombrer());
		controleur.sortir();
		assertEquals(Visiteur.MAX-1, controleur.denombrer());
		for (int i = 0;i<Visiteur.MAX*2; i++) {
			controleur.sortir();
		}
		assertEquals(0, controleur.denombrer());
	}

}
