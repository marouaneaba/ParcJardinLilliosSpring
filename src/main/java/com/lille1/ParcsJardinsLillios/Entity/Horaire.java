package com.lille1.ParcsJardinsLillios.Entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Horaire {

	
	@Id
	private Long id;
	@Column
	private String ouverture;
	@Column
	private String fermuture;
	@Column
	private String journee;
	
	@ManyToOne(targetEntity = ParcJardinn.class)
	private ParcJardinn ParcJardinn;

	
	public Horaire(){}
	
	public Horaire(String ouverture, String fermuture, String journee,ParcJardinn parcJardinn) {
		super();
		this.ouverture = ouverture;
		this.fermuture = fermuture;
		this.journee = journee;
		ParcJardinn = parcJardinn;
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

	public ParcJardinn getParcJardinn() {
		return ParcJardinn;
	}

	public void setParcJardinn(ParcJardinn parcJardinn) {
		ParcJardinn = parcJardinn;
	}

	
	
	
	
	
	
	
	
	
}
