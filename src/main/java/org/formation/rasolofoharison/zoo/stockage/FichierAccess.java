package org.formation.rasolofoharison.zoo.stockage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.rasolofoharison.zoo.modele.Cage;
import org.formation.rasolofoharison.zoo.modele.Gazelle;
import org.formation.rasolofoharison.zoo.modele.Lion;
import org.formation.rasolofoharison.zoo.modele.Singe;
import org.formation.rasolofoharison.zoo.modele.technique.CagePleineException;
import org.formation.rasolofoharison.zoo.modele.technique.PorteException;

/**
 * Classe technique qui gère les accès fichier pour la sauvegarde des animaux du zoo.
 * @author jacques
 *
 */
public class FichierAccess <T> implements DaoAccess<T>{
	private static final Logger logger = Logger.getLogger("FichierAccess");
	/**
	 * nom du fichier
	 */
	private String fichier;
	/**
	 * Collection des animaux lus
	 */
	private List<T> elts;
	/**
	 * constructeur
	 * @param f nom du fichier à lire et écrire
	 */
	public FichierAccess(String f)
	{
		fichier = f;
		fichier = DaoFactory.getInstance().getProps().getProperty("nomFichier");
		elts = null;
		read();
	}

	/**
	 * méthode privée d'écriture de la collection
	 */
	private void write()
	{
	      try (ObjectOutputStream  fic= new ObjectOutputStream(new FileOutputStream(fichier))){
	             
	             fic.writeObject(elts);
	             fic.close();
	        } catch (IOException e) {
	          logger.log(Level.SEVERE, e.getMessage());
	        }			
	}
	/**
	 * méthode privée de lecture de la collection dans, le fichier<s
	 */
	@SuppressWarnings("unchecked")
	private void read() {
	   
		try (ObjectInputStream fic= new ObjectInputStream(new FileInputStream(fichier))){
			
			elts = (List<T>)fic.readObject();
			fic.close();
		}
		catch (IOException e) {
			//fichier inexistant tout remplir à la main en appelant init en instanciant DaoDur ==> lireTous()
			DaoDur dao = new DaoDur();
			elts = (List<T>) dao.lireTous();
		}
		catch(ClassNotFoundException ex)
		{
			logger.log(Level.SEVERE,ex.getMessage());		}
	}
	/**
	 * méthode privée qui rempli la liste si aucun fichier n'est trouvé
	 */
	

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	/**
	 * méthode qui permet l'accès en lecture à l'information (fait partie de l'api)
	 * @return la collection lue
	 */
	public List<T> lireTous(){
		if (elts == null){
			read();
		}
		return elts;
	}
	/**
	 * méthode qui permet l'accès en écriture à l'information (fait partie de l'api)
	 * @param lesCages la collection à persister
	 */
	public void ecrireTous(List<T> lesElts) {
		elts = lesElts;
		write();
		
	}


	@Override
	public T lire(int cle) {
		// TODO Auto-generated method stub
		return elts.get(cle);
		}

	@Override
	public void modifier(int cle) {
		// TODO Auto-generated method stub
		
	}

}
