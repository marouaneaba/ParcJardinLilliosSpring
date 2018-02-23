package com.lille1.parcsjardinslillois.entity;

import javax.persistence.*;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private int nbrEtoile;
	@Column
	private String scommentaire;
	@Column
	private boolean confirmer;

	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin parcJardinn;

	public Commentaire() {
		//constructeur sans parametres
	}

	public Commentaire(String commentaire, int nbrEtoile, String nomCommentaire, boolean confirmer,
			ParcJardin parcJardin) {
		super();
		this.name = nomCommentaire;
		this.nbrEtoile = nbrEtoile;
		this.scommentaire = commentaire;
		this.confirmer = confirmer;
		this.parcJardinn = parcJardin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbrEtoile() {
		return nbrEtoile;
	}

	public void setNbrEtoile(int nbrEtoile) {
		this.nbrEtoile = nbrEtoile;
	}

	public String getScommentaire() {
		return scommentaire;
	}

	public void setScommentaire(String scommentaire) {
		this.scommentaire = scommentaire;
	}

	public boolean isConfirmer() {
		return confirmer;
	}

	public void setConfirmer(boolean confirmer) {
		this.confirmer = confirmer;
	}

	public ParcJardin getParcJardinn() {
		return parcJardinn;
	}

	public void setParcJardinn(ParcJardin parcJardinn) {
		this.parcJardinn = parcJardinn;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", name=" + name + ", nbrEtoile=" + nbrEtoile + ", scommentaire="
				+ scommentaire + ", confirmer=" + confirmer + ", parcJardinn=" + parcJardinn + "]";
	}

	
}
