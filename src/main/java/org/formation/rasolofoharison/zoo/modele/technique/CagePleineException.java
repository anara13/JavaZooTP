package org.formation.rasolofoharison.zoo.modele.technique;

/**
 * Exception levée quand la  cage est occupée et quel'on veut faire entrer un animal
 * @author j.vincensini
 *
 */
public class CagePleineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CagePleineException() {
		super("La cage est déjà occupée");
	}

	public CagePleineException(String raison) {
		super(raison);
	}


}
