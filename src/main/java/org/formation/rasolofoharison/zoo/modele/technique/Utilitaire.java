package org.formation.rasolofoharison.zoo.modele.technique;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.service.CagePOJO;
import org.formation.rasolofoharison.zoo.service.GazellePOJO;

public interface Utilitaire {
	public static Logger logger = Logger.getLogger("Zoo");

    static final CharSequence PACKAGE = "org.formation.rasolofoharison.zoo.modele.";

    public static void nettoyer() {
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			}
		}

	public static Cage pojoToCage(CagePOJO cp) {
		Cage ret = null;
		Animal bete = null;
		Class<?> classeDeLaBete = null;
		Class<?>[] lesTypes = null;
		Object[] lesValeurs = null;
		Constructor<?> construct = null;
		
		ret = new Cage(cp.getX(), cp.getY());
		if (cp.getCodeAnimal() != null) {

			if ((cp.getCodeAnimal().equals("Gazelle")) && cp.getGazelle() != null ) {
		
			lesTypes = new Class<?>[4];
			lesValeurs = new Object[4];
			lesTypes[3] = int.class; 
			lesValeurs[3] = cp.getGazelle().getLgCornes();
				
			}else {
				lesTypes = new Class<?>[3];
				lesValeurs = new Object[3];
				
			}
			
			lesTypes[0] = String.class;
			lesTypes[1] = int.class;
			lesTypes[2] = double.class;
			//le soucis de utilitaire test vient d'ici
			lesValeurs[0] = cp.getNom();
			lesValeurs[1] = cp.getAge();
			lesValeurs[2] = cp.getPoids();
			
			
			
			try {
				classeDeLaBete = Class.forName(String.join("",PACKAGE,cp.getCodeAnimal()));
				construct = classeDeLaBete.getConstructor(lesTypes);
				//ou bien d'ici
				bete = (Animal) construct.newInstance(lesValeurs);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
			ret.ouvrir();
			try {
				ret.entrer(bete);
			} catch (PorteException | CagePleineException e) {
				e.printStackTrace();
			}
			ret.fermer();
			
		}
		
		return ret;
	}
	
	
    public static CagePOJO cageToPojoCagePOJO (Cage cage1) {
    	
    	CagePOJO nouvelleCage = null;
    	nouvelleCage = new CagePOJO();
    	GazellePOJO gaz = null;
    	
    	nouvelleCage.setX(cage1.getX());
    	nouvelleCage.setY(cage1.getY());
    	
    	if (cage1.getOccupant() != null) {

    		nouvelleCage.setCodeAnimal(cage1.getOccupant().getClass().getSimpleName());
    		nouvelleCage.setAge(cage1.getOccupant().getAge());
        	nouvelleCage.setNom(cage1.getOccupant().getNom());
        	nouvelleCage.setPoids(cage1.getOccupant().getPoids());
        	
        	if (cage1.getOccupant() instanceof Gazelle) {
        		gaz = new GazellePOJO(0, nouvelleCage.getId(), ((Gazelle) cage1.getOccupant()).getCornes());
        		nouvelleCage.setGazelle(gaz);
				
			}
    	}
		return nouvelleCage;
    	
    }
}
