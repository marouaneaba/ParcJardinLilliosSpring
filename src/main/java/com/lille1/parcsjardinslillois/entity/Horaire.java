package com.lille1.parcsjardinslillois.entity;

import javax.persistence.*;

@Entity
public class Horaire {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String ouverture;
	@Column
	private String fermeture;
	@Column
	private String journee;

	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin parcJardin;

	public Horaire() {
		//constructeur sans parametres
	}

	public Horaire(String ouverture, String fermeture, String journee, ParcJardin parcJardin) {
		super();
		this.ouverture = ouverture;
		this.fermeture = fermeture;
		this.journee = journee;
		this.parcJardin = parcJardin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOuverture() {
		return ouverture;
	}

	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}

	public String getFermeture() {
		return fermeture;
	}

	public void setFermeture(String fermeture) {
		this.fermeture = fermeture;
	}

	public String getJournee() {
		return journee;
	}

	public void setJournee(String journee) {
		this.journee = journee;
	}

	public ParcJardin getParcJardin() {
		return parcJardin;
	}

	public void setParcJardin(ParcJardin parcJardin) {
		this.parcJardin = parcJardin;
	}

	@Override
	public String toString() {
		return "Horaire [id=" + id + ", ouverture=" + ouverture + ", fermeture=" + fermeture + ", journee=" + journee
				+ ", parcJardin=" + parcJardin + "]";
	}

	

}
