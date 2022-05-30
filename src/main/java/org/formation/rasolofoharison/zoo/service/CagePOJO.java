package org.formation.rasolofoharison.zoo.service;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "animal")
@NamedQueries({
	@NamedQuery(name = "un", query = "SELECT cp FROM CagePOJO cp WHERE cp.id =:cle"),
	@NamedQuery(name = "tous", query = "SELECT cp FROM CagePOJO cp")

})
public class CagePOJO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idAnimal")
	private int id; 
	private int x;
	private int y;
	private String codeAnimal; //lion, Singe, Gazelle ou autre
	private String nom;
	private int age;
	private double poids;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name= "idAnimal", referencedColumnName = "idAnimal" , updatable = false, insertable = false)
	private GazellePOJO gazelle;
	@Transient
	private String image;
	@Transient
	private String pancarte;
	
	
	public CagePOJO() {
		this(0,0,null,null,0,0, null);
	}
	public CagePOJO(int x, int y, String codeAnimal,String nom, int age, double poids, GazellePOJO gp) {
		
		setAge(age);
		setCodeAnimal(codeAnimal);
		setNom(nom);
		setPoids(poids);
		setX(x);
		setY(y);
		setGazelle(gp);
	}
	public void setGazelle(GazellePOJO gazelle) {
		this.gazelle=gazelle;		
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the codeAnimal
	 */
	public String getCodeAnimal() {
		return codeAnimal;
	}
	/**
	 * @param codeAnimal the codeAnimal to set
	 */
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
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
	public void setNom(String nom) {
		this.nom = nom;
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
	public void setAge(int age) {
		this.age = age;
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
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public GazellePOJO getGazelle() {
		return gazelle;
	}
	public void setGazelle() {
		this.gazelle = gazelle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPancarte() {
		return pancarte;
	}
	public void setPancarte(String pancarte) {
		this.pancarte = pancarte;
	}
}