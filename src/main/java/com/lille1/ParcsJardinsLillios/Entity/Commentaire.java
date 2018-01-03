package com.lille1.ParcsJardinsLillios.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Commentaire implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String commentaire;
	@Column
	private boolean confirmer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parcJardin_id")
	private ParcJardin parcJardinCommentaire;
	
	
	public Commentaire(){}
	
	public Commentaire(String commentaire, ParcJardin parcJardinn, boolean confirmer) {
		super();
		this.parcJardinCommentaire = parcJardinn;
		this.commentaire = commentaire;
		this.confirmer = confirmer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ParcJardin getParcJardinCommentaire() {
		return parcJardinCommentaire;
	}
	public void setParcJardinCommentaire(ParcJardin parcJardinn) {
		this.parcJardinCommentaire = parcJardinn;
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
