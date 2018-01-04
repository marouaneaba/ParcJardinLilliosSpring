package com.lille1.ParcsJardinsLillios.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.lille1.ParcsJardinsLillios.UI.Enum.EnumTypePJ;

@Entity
public class ParcJardin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private EnumTypePJ type;  // parc ou jardin
	@Column
	private double L;
	@Column
	private double G;
	@Column
	private String adresse;



	//@OneToMany(mappedBy = "parcJardinCommentaire")
	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "parcJardinCommentaire")
	private List<Commentaire> commentaire;

	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
		      name="ParcJardinn_Categorie",
		      joinColumns=@JoinColumn(name="parcJardin_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="categorie_id", referencedColumnName="id"))
	private List<Categorie> categories;
	
	
	
	@OneToMany(targetEntity = Horaire.class)
	private List<Horaire> horaire;


	public ParcJardin(){}
	
	public ParcJardin(String name, String description, EnumTypePJ type, double l, double g, String adresse
			) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.L = l;
		this.G = g;
		this.adresse = adresse;

	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	public EnumTypePJ getType() {
		return type;
	}

	public void setType(EnumTypePJ type) {
		this.type = type;
	}

	public double getL() {
		return L;
	}



	public void setL(double l) {
		L = l;
	}



	public double getG() {
		return G;
	}



	public void setG(double g) {
		G = g;
	}



	public List<Commentaire> getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}



	public List<Categorie> getCategorie() {
		return categories;
	}



	public void setCategorie(List<Categorie> categorie) {
		this.categories = categorie;
	}



	public List<Horaire> getHoraire() {
		return horaire;
	}



	public void setHoraire(List<Horaire> horaire) {
		this.horaire = horaire;
	}


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "ParcJardin{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", type=" + type +
				", L=" + L +
				", G=" + G +
				", adresse='" + adresse + '\'' +
				'}';
	}
}
