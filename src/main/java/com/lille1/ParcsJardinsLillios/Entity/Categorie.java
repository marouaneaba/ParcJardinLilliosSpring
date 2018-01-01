package com.lille1.ParcsJardinsLillios.Entity;

import java.util.Collection;

import javax.persistence.*;

import com.lille1.ParcsJardinsLillios.UI.Enum.EnumCategorie;

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany(mappedBy = "categorieList")
	private Collection<ParcJardin> ParcJardinn;
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



	public Collection<ParcJardin> getParcJardinn() {
		return ParcJardinn;
	}



	public void setParcJardinn(Collection<ParcJardin> parcJardinn) {
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
		return "Bar{" +
				", nom='" + Nomcategorie + '\'' +


				'}';
	}
	
}
