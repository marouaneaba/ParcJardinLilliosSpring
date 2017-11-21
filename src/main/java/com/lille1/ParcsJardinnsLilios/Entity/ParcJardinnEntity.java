package com.lille1.ParcsJardinnsLilios.Entity;

import javax.persistence.*;

@Entity
public class ParcJardinnEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private boolean Parc;
	
	
	public ParcJardinnEntity(){}
	
	public ParcJardinnEntity(String name, String description,boolean parc) {
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
