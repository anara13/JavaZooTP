package org.formation.rasolofoharison.zoo.vue;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.rasolofoharison.zoo.controleur.Zoo;

public class Lanceur {
	private static Logger log = Logger.getLogger("lanceur");
	public Lanceur() {
		//attention vide volantaire
	}
	public void afficher() {
		for (String s : Zoo.getInstance().getInfos()) {
			System.out.println(s);
		}
		
	}
	public void nourrir() {
		Zoo.getInstance().nourrir();
	}
//	public void fermer() {
//		Zoo.getInstance().fermer();
//	}
	public void go() {
		afficher();
		nourrir();
		log.log(Level.INFO, "A TABLE!!!");
		afficher();
		//fermer();
		
	}
	public static void main(String[] args) {
		Lanceur lanceur = null;
		lanceur = new Lanceur();
		lanceur.go();
	}
}
