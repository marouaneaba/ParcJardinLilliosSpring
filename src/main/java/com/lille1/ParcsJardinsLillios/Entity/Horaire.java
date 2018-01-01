package com.lille1.ParcsJardinsLillios.Entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.lille1.ParcsJardinsLillios.UI.Enum.EnumJournees;

@Entity
public class Horaire {

	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String ouverture;
	@Column
	private String fermuture;
	@Column
	private EnumJournees journee;
	
	@ManyToOne(targetEntity = ParcJardin.class)
	private ParcJardin ParcJardinn;

	
	public Horaire(){}
	
	public Horaire(String ouverture, String fermuture, EnumJournees journee,ParcJardin parcJardinn) {
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

	public EnumJournees getJournee() {
		return journee;
	}

	public void setJournee(EnumJournees journee) {
		this.journee = journee;
	}

	public ParcJardin getParcJardinn() {
		return ParcJardinn;
	}

	public void setParcJardinn(ParcJardin parcJardinn) {
		ParcJardinn = parcJardinn;
	}

	
	
	
	
	
	
	
	
	
}
