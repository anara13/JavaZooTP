package org.formation.rasolofoharison.zoo.stockage;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface DaoAccess<T> {
	public List<T> lireTous();
	@Deprecated(since = "1.0")
	public void ecrireTous(List<T> elts);
	public T lire (int cle);
	public void modifier (int cle);
	
	
}
