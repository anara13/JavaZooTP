/**
 * 
 */
package org.formation.rasolofoharison.zoo.modele;

import org.formation.rasolofoharison.zoo.modele.technique.BeurkException;

/**
 * @author jacques
 *
 */
public interface Individu {
	public void dormir();
	public void manger();
	public String crier();
	public String manger(Mangeable m) throws BeurkException ;
	@Deprecated
	public String manger(Gazelle g);

}
