package com.lille1.ParcsJardinsLillios.Entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Categorie {

	@Id
	private Long id;
	@ManyToMany(mappedBy = "categorie")
	private Collection<ParcJardin> ParcJardinn;
	@Column
	private String categorie;
	
	
	public Categorie() {
		
	}



	public Categorie(Collection<ParcJardin> parcJardinn, String categorie) {
		super();
		ParcJardinn = parcJardinn;
		this.categorie = categorie;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Collection<ParcJardin> getParcJardinn() {
		return ParcJardinn;
	}



	public void setParcJardinn(Collection<ParcJardin> parcJardinn) {
		ParcJardinn = parcJardinn;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	

	
	
}
