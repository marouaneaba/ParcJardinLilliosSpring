package com.lille1.parcsjardinslillois.entity;

import javax.persistence.*;

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nomcategorie;

	public Categorie() {
		//constructeur
	}

	public Categorie(String nomcategorie) {
		super();
		this.nomcategorie = nomcategorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomcategorie() {
		return nomcategorie;
	}

	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomcategorie=" + nomcategorie + "]";
	}

	
}
