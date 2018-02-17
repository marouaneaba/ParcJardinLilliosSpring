package com.lille1.parcsjardinslillios.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class ParcJardin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private java.lang.String name;
	@Column
	private java.lang.String description;
	@Column
	private String type; // parc ou jardin
	@Column
	private String L;
	@Column
	private String G;
	@Column
	private String adresse;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<java.lang.String> NameImage;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Categorie> categories = new ArrayList<>();

	public ParcJardin() {
	}

	public ParcJardin(java.lang.String name, java.lang.String description, String type, String l, String g,
			java.lang.String adresse) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.L = l;
		this.G = g;
		this.adresse = adresse;
		// this.commentaires = new ArrayList<>();
		this.NameImage = new ArrayList<>();

	}

	public List<String> getNameImage() {
		return NameImage;
	}

	public void setNameImage(String nameImage) {
		NameImage.add(nameImage);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

	public String getG() {
		return G;
	}

	public void setG(String g) {
		G = g;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories.add(categories);
	}

	public void setCat(List<Categorie> cats) {
		this.categories = cats;
	}

	@Override
	public String toString() {
		return "ParcJardin [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", L="
				+ L + ", G=" + G + ", adresse=" + adresse + "]";
	}

}
