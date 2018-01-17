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
	@ManyToMany(mappedBy = "categories")
	private List<ParcJardin> ParcJardinn = new ArrayList<>();
	@Column
	private String Nomcategorie;


	public Categorie() {
	}



	public Categorie(String Nomcategorie) {
		super();

		this.Nomcategorie = Nomcategorie;
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



	public String getNomCategorie() {
		return Nomcategorie;
	}



	public void setNomcategorie(String Nomcategorie) {
		this.Nomcategorie = Nomcategorie;
	}



	@Override
	public String toString() {
		return "Categorie{" +
				", nom='" + Nomcategorie + '\'' +

				'}';
	}

}
