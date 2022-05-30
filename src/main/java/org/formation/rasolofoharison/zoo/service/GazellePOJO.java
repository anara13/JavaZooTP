package org.formation.rasolofoharison.zoo.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gazelle")

public class GazellePOJO implements Serializable{
	
	@Id
	@Column (name="id")
	private int id;
	private int idAnimal;
	private int lgCornes;

	public GazellePOJO() {
		this(0,0,0);
		}
	public GazellePOJO(int cle, int idAnimal, int cornes) {
		setId(cle);
		setIdAnimal(idAnimal);
		setLgCornes(cornes);
		 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getLgCornes() {
		return lgCornes;
	}

	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
	}

}
