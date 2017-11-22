package com.lille1.ParcsJardinsLillios.Entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Categorie {

	@Id
	private Long id;
	@ManyToMany(mappedBy = "categorie")
	private Collection<ParcJardinn> ParcJardinn;
	@Column
	private String categorie;
	
	
	public Categorie() {
		
	}



	public Categorie(Collection<ParcJardinn> parcJardinn, String categorie) {
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



	public Collection<ParcJardinn> getParcJardinn() {
		return ParcJardinn;
	}



	public void setParcJardinn(Collection<ParcJardinn> parcJardinn) {
		ParcJardinn = parcJardinn;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	

	
	
}
