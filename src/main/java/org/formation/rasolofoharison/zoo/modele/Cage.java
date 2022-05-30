package org.formation.rasolofoharison.zoo.modele;

import java.io.Serializable;

import org.formation.rasolofoharison.zoo.modele.technique.CagePleineException;
import org.formation.rasolofoharison.zoo.modele.technique.PorteException;

/**
 *  Une cage du zoo. 
 *  Peut être vide ou contenir un seul animal (ASSOCIATION)
 * @author j.Vincensini
 * @version 1.0
 * @since 1.0
 *
 */
public class Cage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * L'associé dans la relation
	 */
	private Animal occupant;
	/**
	 * absisse de la cage (en pixels)
	 */
	private int x;
	/**
	 * ordonnée de la cage (en pixels)
	 */
	private int y;
	/**
	 * Vrai si la cage est ouverte faux autrement
	 */
	private boolean ouvert;
	
	public Cage() {
		this(0,0);
	}
	public Cage(int x, int y)
	{
		setX(x);
		setY(y);
		setOuvert(true);
		setOccupant(null);
	}
	/**
	 * 
	 * @param a l'animal que l'on veut faire entrer
	 * @throws PorteException si la cage est fermée
	 * @throws CagePleineException  si la cage est déjà occupée
	 */
	public void entrer(Animal a) throws PorteException, CagePleineException
	{
		if(!ouvert)
		{
			throw new PorteException();
		}
		if (occupant != null) { //déjà occupée
			throw new CagePleineException();
		}
		setOccupant(a);
	}
	/**
	 * 
	 * @return l'animal qui était dans la cage.
	 * Si la cage est vide retourne null
	 * @throws PorteException si la cage n'est pas ouverte
	 */
	public Animal sortir()throws PorteException
	{
		Animal ret = null;
		if (!ouvert)
		{
			throw new PorteException();
		}
		ret = occupant;
		occupant = null;
		return ret;
	}
	/**
	 * permet l'ouverture de la cage
	 */
	public void ouvrir()
	{
		setOuvert(true);
	}
	/**
	 * permet la fermeture de la cage
	 */
	public void fermer()
	{
		setOuvert(false);
	}
	public Animal getOccupant() {
		return occupant;
	}
	public void setOccupant(Animal occupant) {
		this.occupant = occupant;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isOuvert() {
		return ouvert;
	}
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
	@Override
	public String toString() {
		String ret = null;
		ret =  String.join("", "Cage [x=", Integer.toString(x), ", y=" , Integer.toString(y),"]");
		if (occupant != null)
		{
			ret = String.join("----", ret, occupant.getInfos());
		}
		else
		{
			ret = String.join("----", ret, "VIDE");
		}
		return ret;
	}
	
}