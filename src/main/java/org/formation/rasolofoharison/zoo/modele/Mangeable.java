package org.formation.rasolofoharison.zoo.modele;

/**
 * Contrat pour être mangeabe par le lion.
 * @author j.vincensini
 *
 */
public interface Mangeable {
	/**
	 * Design Pattern ADAPTER
	 * @return la part du lion. soit 1/3 du poids de la proie
	 */
	public double prelever();
}
