package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.formation.rasolofoharison.zoo.modele.Cage;

import org.junit.jupiter.api.Test;

class CageTests{
	
		private Cage nouvelleCage = new Cage();
		
		@Test
		void testEntrer()
		{

		}


		@Test
		void testSortir(){
			
		}
		
		@Test
		void testOuvrir()
		{
			nouvelleCage.ouvrir();
			assertEquals(nouvelleCage.isOuvert(), true);
		}

		@Test
		void testFermer()
		{
			nouvelleCage.fermer();
			assertEquals(nouvelleCage.isOuvert(), false);
		}

		@Test
		void testgetOccupant() {
			
			assertEquals(null, nouvelleCage.getOccupant());
		}

		@Test
		void testsetOccupant() {

		}

		@Test
		void testgetX() {
			assertEquals(0, nouvelleCage.getX());
		}

		@Test
		void testsetX() {
			
		}

		@Test
		void testgetY() {
			assertEquals(0, nouvelleCage.getY());
		}

		@Test
		void testsetY() {
			
		}

		@Test
		void testisOuvert() {
			assertEquals(true, nouvelleCage.isOuvert());
		}

		@Test
		void testsetOuvert() {
			
		}
		@Test
		void testtoString() {
			//assertEquals(null, nouvelleCage);
		}
		
}