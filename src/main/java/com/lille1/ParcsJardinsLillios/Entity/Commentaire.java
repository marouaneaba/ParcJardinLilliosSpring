package com.lille1.ParcsJardinsLillios.Entity;

import javax.persistence.*;

@Entity
public class Commentaire {


	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin parcJardinn;
	@Column
	private String commentaire;
	@Column
	private boolean confirmer;
	
	
	public Commentaire(){}
	
	public Commentaire(ParcJardin parcJardinn, String commentaire, boolean confirmer) {
		super();
		this.parcJardinn = parcJardinn;
		this.commentaire = commentaire;
		this.confirmer = confirmer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ParcJardin getParcJardinn() {
		return parcJardinn;
	}
	public void setParcJardinn(ParcJardin parcJardinn) {
		this.parcJardinn = parcJardinn;
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
