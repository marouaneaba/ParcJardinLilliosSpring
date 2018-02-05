package com.lille1.ParcsJardinsLillios.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;



@Entity
public class Categorie implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany
	private List<ParcJardin> ParcJardinn = new ArrayList<>();
	@Column
	private String nomcategorie;
	
	public Categorie( ) {}
	
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



	public List<ParcJardin> getParcJardinn() {
		return ParcJardinn;
	}



	public void setParcJardinn(List<ParcJardin> parcJardinn) {
		ParcJardinn = parcJardinn;
	}



	public String getNomcategorie() {
		return nomcategorie;
	}



	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}



	@Override
	public String toString() {
		return "Categorie [id=" + id + ", ParcJardinn=" + ParcJardinn + ", nomcategorie=" + nomcategorie + "]";
	}


	
	

}
