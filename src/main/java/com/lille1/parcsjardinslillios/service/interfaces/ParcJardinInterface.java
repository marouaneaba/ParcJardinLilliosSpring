package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

public interface ParcJardinInterface {

	public List<ParcJardin> ConsulterParcsJardin();

	public ParcJardin ChercherPJParId(Long id);

	public void SupprimerPJ(ParcJardin PJ);

	public ParcJardin AjouterListCatToPJ(List<Categorie> lcat, ParcJardin PJ);

	public ParcJardin chercherPJParNom(String nomPj);

	public List<ParcJardin> chercherPJParCategorie(Categorie categorie);

	public boolean AjouterPJ(ParcJardin PJ);

	public ParcJardin ModifierDescriptionPJ(Long idPJ, String desc);

	public ParcJardin ModifierNomPJ(Long idPJ, String nom);

	public List<Categorie> ConsulterCategoriesPJ(Long idPJ);

	public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin PJ);

	public ParcJardin chercherPJLG(String l, String g);

	public List<ParcJardin> consulterPJByType(String type);

	public void supprimercatFromPJ(Long idPJ);

	public ParcJardin modifierPJ(ParcJardin pj, String name, String description, String adresse, String l, String g,
			String type, List<Categorie> cats);

}
