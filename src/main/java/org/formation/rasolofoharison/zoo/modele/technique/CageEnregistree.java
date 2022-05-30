package org.formation.rasolofoharison.zoo.modele.technique;

import org.formation.rasolofoharison.zoo.modele.Animal;
import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Mangeable;
import org.formation.rasolofoharison.zoo.service.CagePOJO;
import org.formation.rasolofoharison.zoo.stockage.DaoAccess;

public class CageEnregistree {
	
	private Cage cage;
	private CagePOJO pojo;
	private DaoAccess<CagePOJO> dao;
	
	public CageEnregistree(CagePOJO pojo, DaoAccess<CagePOJO> dao) {
		
		this.cage=Utilitaire.pojoToCage(pojo);
		this.pojo=pojo;
		this.dao=dao;
		
	}
	public void entrer(Animal a) throws PorteException, CagePleineException{
		cage.entrer(a);
		pojo=Utilitaire.cageToPojoCagePOJO(cage);
		//FIXME appeler dao.modifier(pojo) à coder dans dao
	}
	
	//TODO faire le sortir aussi et outes les méthodes de zoo pour juste les mettre simplement dans le projet
	
	public void nourrir() {//nourrir l'animal
		if (cage.getOccupant() != null) {
		cage.getOccupant().manger();
		pojo.setPoids(cage.getOccupant().getPoids());
		//FIXME appeler dao.modifier(pojo) à coder dans dao
	}
	}
	
	public CagePOJO getPOJO() {
		return pojo;
	}
	
	public String getPancarte() {
		String ret = "Cage vide";
		if (!estVide()) {
			ret = cage.getOccupant().toString();
		}
		return ret;
	}
	
	public String getImage() {
		String ret = "images/cage.jpg";
		if (!estVide()) {
			ret = String.join("","images/", pojo.getCodeAnimal().toLowerCase(), ".gif");
		}
		return ret;
	}
	public boolean estVide() {
		boolean occupe;
		if (cage.getOccupant() != null){
			occupe = false;
		}
		else {
			occupe = true;
		}
		return occupe;
	}
	public void sortir() throws PorteException {
		Animal a = null;
		if (!cage.isOuvert())
		{
			throw new PorteException();
		}
		//cage.occupant = null;
		//return ret;
	}
	
	public void ouvrir() {
		cage.setOuvert(true);
	}
	
	public void fermer() {
		cage.setOuvert(false);
	}
	public String toString() {
		return cage.toString();
	}
	public Animal getOccupant() {
		
		return cage.getOccupant();
	}
}
