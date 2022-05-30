package org.formation.rasolofoharison.zoo.stockage;
import java.util.Vector;
import java.util.List;

import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.modele.Lion;
import org.formation.rasolofoharison.zoo.modele.Singe;
import org.formation.rasolofoharison.zoo.modele.technique.CagePleineException;
import org.formation.rasolofoharison.zoo.modele.technique.PorteException;
import org.formation.rasolofoharison.zoo.service.CagePOJO;
import org.formation.rasolofoharison.zoo.service.GazellePOJO;

public class DaoDur implements DaoAccess<CagePOJO> {
	private List<CagePOJO> elts;

	//les différente methodes de dao access +contructeur
	public DaoDur() {
		//finr de rajouter la lisete des trucs
		elts = new Vector<>();
		init();
	}
	
	private void init()
	{
		CagePOJO tmp = null;
		tmp = new CagePOJO(101,201, "Singe", "Cheeta",20,75, null);
			tmp.setId(0);
			elts.add(tmp);
			//DaoAccess.DaoAjout(tmp);
			
			tmp = new CagePOJO(100,50, "Lion", "Simba",3,20, null);
			tmp.setId(1);
			elts.add(tmp);
			//DaoAccess.DaoAjout(tmp);
			
			tmp = new CagePOJO(150,250, null, null, 0, 0,null); //CAGE VIDE
			tmp.setId(2);
			elts.add(tmp);
			//DaoAccess.DaoAjout(tmp);
			
			GazellePOJO gp = new GazellePOJO(0, 3, 99);
			tmp = new CagePOJO(90,230,"Gazelle","Lady Gaga",20,75, gp);
			tmp.setId(3);
			elts.add(tmp);
			//DaoAccess.DaoAjout(tmp);
			
			tmp = new CagePOJO(60,100,"Singe", "Baloo",30,50,null);
			elts.add(tmp);
			//DaoAccess.DaoAjout(tmp);
		}
	
	@Override
	public List<CagePOJO> lireTous(){
		return elts;
	}
	
	@Override
	/**
	 * clé= n° dordre dans la liste
	 * 
	 */
	public CagePOJO lire(int cle) {
		return this.elts.get(cle);
		
	}
	
	@Override
	public void ecrireTous(List<CagePOJO> elts) {
		this.elts = elts;
	}

	@Override
	public void modifier(int cle) {
		// TODO Auto-generated method stub
		
	}
	
	
}
