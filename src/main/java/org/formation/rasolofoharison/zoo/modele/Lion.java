/**
 * 
 */
package org.formation.rasolofoharison.zoo.modele;

import org.formation.rasolofoharison.zoo.modele.technique.BeurkException;

/**
 * @author jacques
 * 
 *
 */
public  final class Lion extends Animal{
	
	public Lion() {
		this("Leo",34,156);
	}
	
	/**
	 * @param age
	 * @param nom
	 * @param poids
	 */
	public Lion(String nom, int age, double poids) {
		super(nom,age,poids,230.0);
	}
	/**
	 * 
	 */
	public void manger() {
		setPoids(getPoids() + 1.9);
	}
	/**
	 * mécanisme de la surcharge 
	 * @param aManger la gazelle qui doit etre mangee et tuée!!!!
	 */
	@Override
	@Deprecated(since = "0.1",forRemoval = true)
	public String manger(Gazelle aManger) {
		setPoids(getPoids()+aManger.getPoids()/3);
		return "Miam miam";
	}
	
	@Override
	public String manger(Mangeable m) throws BeurkException {
		String ret = "Miam miam";
		if (m != null) {
			setPoids(getPoids()+m.prelever()/3);
		}
		return ret;
	}

	/**
	 * 
	 * @return le cri sous forme de string (xml,JSON,csv)
	 */
	@Override
	public String crier() {
		setPoids(getPoids()-0.003);
		return "je rugis!!!! woaw!!!!!";
	}

	@Override
	public void dormir() {
		setPoids(getPoids()-0.750);
		
	}


}
