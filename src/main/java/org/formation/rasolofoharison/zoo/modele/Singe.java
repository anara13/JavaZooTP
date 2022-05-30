/**
 * 
 */
package org.formation.rasolofoharison.zoo.modele;

/**
 * @author jacques
 *
 */
public class Singe extends Animal {

	/**
	 * 
	 */
	public Singe() {
		this("Cheeta",2,34);
	}

	/**
	 * @param age
	 * @param nom
	 * @param poids
	 */
	public Singe(String nom, int age, double poids) {
		super(nom, age, poids,45);
	}
	@Override
	public void manger() {
		setPoids(getPoids()+0.8);
	}

	@Override
	public void dormir() {
		// TODO a finir
		
	}

}
