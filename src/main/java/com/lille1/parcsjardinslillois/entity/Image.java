package com.lille1.parcsjardinslillois.entity;

import javax.persistence.*;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nomImage;
	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin parcJardinn;

	public Image() {
		//constructeur sans parametres
	}

	public Image(String nomImage, ParcJardin parcJardinn) {
		this.nomImage = nomImage;
		this.parcJardinn = parcJardinn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomImage() {
		return nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public ParcJardin getParcJardinn() {
		return parcJardinn;
	}

	public void setParcJardinn(ParcJardin parcJardinn) {
		this.parcJardinn = parcJardinn;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", nomImage=" + nomImage + ", parcJardinn=" + parcJardinn + "]";
	}

	
}
