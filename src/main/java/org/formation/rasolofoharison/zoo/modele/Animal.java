/**
 * 
 */
package org.formation.rasolofoharison.zoo.modele;

import java.io.Serializable;

import org.formation.rasolofoharison.zoo.modele.technique.BeurkException;

/**
 * @author jacques
 *
 */
public abstract class Animal implements Individu,Serializable{
	private int age;
	private String nom;
	private double poids;
	private final double POIDSMAX;
	/**
	 * 
	 */
	public Animal() {
		this("XXXXXXXX",1,1,0);
	}
	/**
	 * @param age
	 * @param nom
	 * @param poids
	 */
	public Animal(String nom,int age,  double poids,double pm) {
		POIDSMAX = pm;
		setAge(age);
		setNom(nom);
		setPoids(poids);
	}
	public String getInfos() { 
		// <animal type="Lion"> <nom></nom></animal>
//		StringJoiner ret;
//		ret = new StringJoiner(" ");
//		ret.add("je suis un lion je m'appelle").add(getNom()).add("j'ai").add(Integer.toString(getAge()));
//		return ret.toString(); 
		String ret="";
		ret = String.join(" ", "je suis un(e)",this.getClass().getSimpleName(),"je m'appelle",getNom(),"j'ai",Integer.toString(getAge()),"an(s) et je pèse",Double.toString(getPoids()),"kg"); 
		return ret;
	}
	
	public String crier() {
		return "...";
	}
	/**
	 * optionnelle
	 */
	public void sauter() {}
	public void courir() {}
	@Override
	@Deprecated
	public String manger(Gazelle g) {
		return "Beurk";
	}
	
	@Override
	public String manger(Mangeable m) throws BeurkException {
		throw new BeurkException();
	}
	public final void vieillir()
	{
		setAge(getAge()+1);
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	protected void setAge(int a) {
		if (a >= 0) {
			age = a;
		}
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	protected void setNom(String nom) {
		if (nom != null) {
			this.nom = nom;
		}else {
			this.nom = "-------";
		}
	}
	/**
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}
	/**
	 * @param poids the poids to set
	 */
	public void setPoids(double p) {
		if (p > 0 && p < POIDSMAX) {
			poids = p;
		}
	}

	@Override
	public String toString() {
		return getInfos();
	}


}
