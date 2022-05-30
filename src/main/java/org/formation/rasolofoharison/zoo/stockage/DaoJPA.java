package org.formation.rasolofoharison.zoo.stockage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.formation.rasolofoharison.zoo.service.CagePOJO;


@Stateless
public class DaoJPA<T> implements DaoAccess<T> {
	@PersistenceContext(unitName = "correctionZOO")
	private EntityManager manager;

	public DaoJPA() {
//		manager = Persistence.createEntityManagerFactory("correctionZOO").createEntityManager();
	}

	@Override
	public List<T> lireTous() {

		return manager.createNamedQuery("tous").getResultList();
	}

	@Deprecated
	@Override
	public void ecrireTous(List<T> elts) {
		// TODO Auto-generated method stub

	}

	@Override
	public T lire(int cle) {
		return (T) manager.createNamedQuery("un").setParameter("id", cle).getResultList().get(0);
	}

	@Override
	public void modifier(int cle) {
//		manager.getTransaction().begin();
		manager.merge(cle);
	//	manager.getTransaction().commit();
	}

	public void ajout(T obj) {
	//	manager.getTransaction().begin();
		manager.persist(obj);
		//manager.getTransaction();
	}
	
	public void supprimer(int cle) {
	//	manager.getTransaction().begin();
		manager.remove(lire(cle));
		//manager.getTransaction().commit();
	}
	
	public static void main (String[] args) {
		DaoJPA<CagePOJO> dao = new DaoJPA<CagePOJO>();
		System.out.println(dao);
		
	}
	
}
