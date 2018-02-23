package com.lille1.parcsjardinslillois.entity;

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
	private String latitude;
	@Column
	private String longitude;
	@Column
	private String adresse;
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> nameImage;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Categorie> categories = new ArrayList<>();

	public ParcJardin() {
		//constructeur sans parametres
	}

	public ParcJardin(java.lang.String name, java.lang.String description, String type, String l, String g,
			java.lang.String adresse) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.latitude = l;
		this.longitude = g;
		this.adresse = adresse;
		this.nameImage = new ArrayList<>();

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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<String> getNameImage() {
		return nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage.add(nameImage);
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories.add(categories);
	}
	
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "ParcJardin [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", adresse=" + adresse + ", nameImage="
				+ nameImage + ", categories=" + categories + "]";
	}

	

}
