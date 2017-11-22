package com.lille1.ParcsJardinnsLillios.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class ParcJardinn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private boolean Parc;
	@Column
	private double L;
	@Column
	private double G;
	
	
	@OneToMany
	private List<Long> id_commentaire;
	@JoinTable(name="ParcJardinn_Categorie", joinColumns =@JoinColumn(name="id_parcJardinn",referencedColumnName="id")
	,inverseJoinColumns = @JoinColumn(name="id_categorie",referencedColumnName="id"))
	private List<Long> id_categorie;
	@JoinTable(name="ParcJardinn_Categorie", joinColumns =@JoinColumn(name="id_parcJardinn",referencedColumnName="id")
	,inverseJoinColumns = @JoinColumn(name="id_horaire",referencedColumnName="id"))
	private List<Long> id_horaire;
	
	
	
	public ParcJardinn(){}
	
	public ParcJardinn(String name, String description,boolean parc) {
		super();
		this.name = name;
		this.description = description;
		this.Parc = parc;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public boolean isParc() {
		return Parc;
	}

	public void setParc(boolean parc) {
		Parc = parc;
	}
	
	
	
	
	
}
