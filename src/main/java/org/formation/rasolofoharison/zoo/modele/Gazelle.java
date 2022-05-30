package org.formation.rasolofoharison.zoo.modele;

/**
 * 
 * @author jacques
 *
 */
public class Gazelle extends Animal implements Mangeable {
	private int lgCornes;
	public Gazelle() {
		this("!beepbeep",3,60,12);
	}

	public Gazelle(String nom, int age, double poids,int cornes) {
		super(nom, age, poids,150.0);
		setLgCornes(cornes);
	}

	/**
	 * @return the lgCornes
	 */
	public int getLgCornes() {
		return lgCornes;
	}

	/**
	 * @param lgCornes the lgCornes to set
	 */
	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
	}
	@Override
	public void manger() {
		setPoids(getPoids()+0.4);
		setLgCornes(getLgCornes()+2);
	}
	@Override
	/**
	 * normalement pas de sysout dans du metier juste pour vérif 
	 */
	protected void finalize() {
		//FIXME ajouter � un fichier de log
		System.out.println("je meurs!!!!!!");
	}

	@Override
	public String getInfos() {
		return String.join(" ", super.getInfos(),"et mes cornes font",Integer.toString(getLgCornes()),"cm");
	}

	@Override
	public void dormir() {
		setPoids(getPoids()-0.15);
		
	}

	@Override
	public double prelever() {
		return getPoids();
	}

	public int getCornes() {
		// TODO Auto-generated method stub
		return lgCornes;
	}

}
