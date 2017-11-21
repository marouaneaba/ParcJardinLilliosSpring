package com.lille1.ParcsJardinnsLilios.Entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class HoraireEntity {

	
	@Id
	private Long id;
	@Column
	private Collection<Long> id_jardinn;
	@Column
	private String ouverture;
	@Column
	private String fermuture;
	@Column
	private String journee;
	
	
	
	public HoraireEntity(Collection<Long> id_jardinn, String ouverture, String fermuture, String journee) {
		super();
		this.id_jardinn = id_jardinn;
		this.ouverture = ouverture;
		this.fermuture = fermuture;
		this.journee = journee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Long> getId_jardinn() {
		return id_jardinn;
	}
	public void setId_jardinn(Collection<Long> id_jardinn) {
		this.id_jardinn = id_jardinn;
	}
	public String getOuverture() {
		return ouverture;
	}
	public void setOuverture(String ouverture) {
		this.ouverture = ouverture;
	}
	public String getFermuture() {
		return fermuture;
	}
	public void setFermuture(String fermuture) {
		this.fermuture = fermuture;
	}
	public String getJournee() {
		return journee;
	}
	public void setJournee(String journee) {
		this.journee = journee;
	}
	
	
	
	
	
	
}
