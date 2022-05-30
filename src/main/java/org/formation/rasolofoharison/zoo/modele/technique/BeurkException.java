package org.formation.rasolofoharison.zoo.modele.technique;

/**
 * exception pour signaler qu'un animal n'aime pas ce qu'on lui donne à manger
 * @author j.Vincensini
 *
 */
public class BeurkException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeurkException() {
		super("Je n'aime pas ça");
	}

	public BeurkException(String raison) {
		super(raison);
		
	}


}
