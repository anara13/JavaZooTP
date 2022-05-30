package org.formation.rasolofoharison.zoo.modele;
/**
 * 
 * @author Anais
 *
 */
public class Visiteur implements Mangeable{
	
	public static final int MAX = 10;
	private static int nb = 0;
	
	public Visiteur() {
		Visiteur.nb++;
	}
	
	@Override
	protected void finalize() throws Throwable {
		Visiteur.nb--;
		super.finalize();
	}
/**
 * 
 * @return the nb
 */
	public static int getNb() {
		return nb;
	}
	
	@Override
	public double prelever() {
		return 60;
	}

}