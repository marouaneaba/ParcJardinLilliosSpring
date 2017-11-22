package com.lille1.ParcsJardinnsLillios.Entity;

import javax.persistence.*;

@Entity
public class Commentaire {


	@Id
	private Long id;
	@ManyToOne
	private Long id_parcJardinn;
	@Column
	private String commentaire;
	@Column
	private boolean confirmer;
	
	
	
	
	public Commentaire(Long id_parcJardinn, String commentaire, boolean confirmer) {
		super();
		this.id_parcJardinn = id_parcJardinn;
		this.commentaire = commentaire;
		this.confirmer = confirmer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_parcJardinn() {
		return id_parcJardinn;
	}
	public void setId_parcJardinn(Long id_parcJardinn) {
		this.id_parcJardinn = id_parcJardinn;
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
	
	
	
	
	
}