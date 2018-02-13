package com.lille1.ParcsJardinsLillios.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Commentaire implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String Name;
	@Column
	private int nbrEtoile;
	@Column
	private String commentaire;
	@Column
	private boolean confirmer;

	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin parcJardinn;


	
	
	public Commentaire(){}
	
	public Commentaire(String commentaire,int nbrEtoile, String nomCommentaire, boolean confirmer, ParcJardin parcJardin) {
		super();
		this.Name=nomCommentaire;
		this.nbrEtoile = nbrEtoile;
		this.commentaire = commentaire;
		this.confirmer = confirmer;
		this.parcJardinn=parcJardin;
	}

	public ParcJardin getParcJardinn() {
		return parcJardinn;
	}

	public void setParcJardinn(ParcJardin parcJardinn) {
		this.parcJardinn = parcJardinn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getNbrEtoile() {
		return nbrEtoile;
	}

	public void setNbrEtoile(int nbrEtoile) {
		this.nbrEtoile = nbrEtoile;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isConfirmer() {
		return confirmer;
	}

	public void setConfirmer(boolean confirmer) {
		this.confirmer = confirmer;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", Name=" + Name + ", nbrEtoile=" + nbrEtoile + ", commentaire=" + commentaire
				+ ", confirmer=" + confirmer + "]";
	}
	
	
	
	
	
	
	
}
