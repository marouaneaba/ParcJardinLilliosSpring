package com.lille1.parcsjardinslillois.service.interfaces;

import java.util.List;


import com.lille1.parcsjardinslillois.entity.Categorie;
import com.lille1.parcsjardinslillois.entity.ParcJardin;

public interface ParcJardinInterface {

	public List<ParcJardin> consulterParcsJardin();

	public ParcJardin chercherPJParId(Long id);

	public void supprimerPJ(ParcJardin pj);

	public ParcJardin ajouterListCatToPJ(List<Categorie> lcat, ParcJardin pj);

	public ParcJardin chercherPJParNom(String nomPj);

	public List<ParcJardin> chercherPJParCategorie(Categorie categorie);

	public boolean ajouterPJ(ParcJardin pj);

	public ParcJardin modifierDescriptionPJ(Long idPJ, String desc);

	public ParcJardin modifierNomPJ(Long idPJ, String nom);

	public List<Categorie> consulterCategoriesPJ(Long idPJ);

	public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin pj);

	public ParcJardin chercherPJLG(String l, String g);

	public List<ParcJardin> consulterPJByType(String type);

	public void supprimercatFromPJ(Long idPJ);

	public ParcJardin modifierPJ(ParcJardin pj, String name, String description, String adresse, String l, String g,
			String type, List<Categorie> cats);

}
