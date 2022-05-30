package org.formation.rasolofoharison.zoo.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Mangeable;
import org.formation.rasolofoharison.zoo.modele.Visiteur;
import org.formation.rasolofoharison.zoo.modele.technique.BeurkException;
import org.formation.rasolofoharison.zoo.modele.technique.CageEnregistree;
import org.formation.rasolofoharison.zoo.modele.technique.CagePleineException;
import org.formation.rasolofoharison.zoo.modele.technique.PorteException;
import org.formation.rasolofoharison.zoo.modele.technique.Utilitaire;
import org.formation.rasolofoharison.zoo.service.CagePOJO;
import org.formation.rasolofoharison.zoo.stockage.DaoAccess;
import org.formation.rasolofoharison.zoo.stockage.DaoFactory;
import org.formation.rasolofoharison.zoo.stockage.FichierAccess;

/**
 * 
 * @author jacques
 * @startuml
 * package controleur{
 * 	class Zoo <<Singleton>>{
 * 		
 * 	}
 * }
 * 
 * @enduml
 * 
 */
public class Zoo {

	private static Zoo instance = new Zoo();
	private List<CageEnregistree> lesCages;
	private DaoAccess<CagePOJO> acces;
	private Visiteur[] lesVisiteurs;
	
	private Zoo() {
		lesCages = new Vector<>();
		acces = DaoFactory.getInstance().getDao();
		lesVisiteurs = new Visiteur[Visiteur.MAX];
		init();
	}
	//touc ce qui est en rouger il faut le deplacer  ne cage enregistrer

	private void init() {
		//TODO modifier
		acces.lireTous().forEach(elt->{lesCages.add(new CageEnregistree(elt, acces));});
		
	}

	public Visiteur[] getLesVisiteurs() {
		return lesVisiteurs;
	}

	public List<CageEnregistree> getLesCages(){
		return lesCages;
	}
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		for (int i = 0; i < lesCages.size(); i++) {
			if (!lesCages.get(i).estVide())
			{
				lesCages.get(i).nourrir();
			}
		}
	}
	/**
	 * 
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
//	public String devorer(int mangeur, int mange)
//	{
//		Mangeable laBeteConvoitee = null;
//		String s = "INCOMPATIBLE";
//		if (!lesCages.get(mange).estVide() && !lesCages.get(mangeur).estVide() && lesCages.get(mange).getOccupant() instanceof Mangeable)
//			{
//				lesCages.get(mange).ouvrir();
//				try {
//					laBeteConvoitee = (Mangeable)lesCages.get(mange).sortir();
//				} catch (PorteException e2) {
//					e2.printStackTrace();
//				}
//				try
//				{
//					s = lesCages.get(mangeur).getOccupant().manger(laBeteConvoitee);
//				}
//				catch (BeurkException e)
//				{
//					s = e.getMessage();
//					try {
//						lesCages.get(mange).entrer((Animal)laBeteConvoitee);
//					} catch (PorteException | CagePleineException e1) {
//						logger.log(Level.SEVERE, e.getMessage());
//					}
//					lesCages.get(mange).fermer();
//				}
//		}
//		return s;
//	}

	public List<String> getInfos() {
		List<String> ret = new ArrayList<>();
		for (CageEnregistree cage:lesCages) {
			ret.add(cage.toString());
		}
		return ret;

	}
//
//	//TODO doit disparaître!!!!
//	public void fermer() {
//		List<CagePOJO> liste = new Vector<>();
//		lesCages.forEach((cage)->{liste.add(Utilitaire.cageToPojoCagePOJO(cage));});
//		acces.ecrireTous(liste);
//	}

	public List<CagePOJO> getPOJO(){
		List<CagePOJO> ret = new Vector<CagePOJO>();
		CagePOJO cp = null;
		for (CageEnregistree ce : lesCages) {
			cp = ce.getPOJO();
			cp.setImage(ce.getImage());
			cp.setPancarte(ce.getPancarte());
			ret.add(cp);
		}
		return ret;
	}

	public String entrer() {
		String ret ="ok";
		if (Visiteur.getNb()<Visiteur.MAX) {
			lesVisiteurs[Visiteur.getNb()]= new Visiteur();
		}
		else {
			ret = "attendez un peu";
		}
		return ret;
	}
	
	public void sortir() {
		if (Visiteur.getNb() > 0) {
			lesVisiteurs[Visiteur.getNb()-1] = null;
			Utilitaire.nettoyer();
		}
	}

	public int denombrer() {
		return Visiteur.getNb();
	}
	
	public static Zoo getInstance() {
		return Zoo.instance;
	}
	
	public String afficherZoo(List<CagePOJO> liste){
		
		int longueur = liste.size();
		String contenu ="";
		for (int i = 0; i < longueur; i++){
			
			String nouveauContenu = "<div id=\"animal="+i+"\" style=\"position:absolute;top:"+liste.get(i).getY()+"px;left:"+liste.get(i).getX()+"px\">"+
					"\"<img alt=\"\" src=\"images/"+liste.get(i).getImage()+".gif\" class=\"animal\"/>"+
					"<div class=\"afficheAnimal\" >"+liste.get(i).getPancarte() +"</div></div>";
				
			contenu = contenu + nouveauContenu;
		
			}
		
		return contenu;
		
		}
	

}
