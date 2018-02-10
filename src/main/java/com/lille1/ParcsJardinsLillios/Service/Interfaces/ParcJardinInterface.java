package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import com.lille1.ParcsJardinsLillios.Entity.*;
import com.sun.org.omg.CORBA.ParDescriptionSeqHelper;

import java.util.List;

public interface ParcJardinInterface {

	public List<ParcJardin> ConsulterParcsJardin();

	public ParcJardin ChercherPJParId(Long id);

	public void SupprimerPJ(ParcJardin PJ);

	public ParcJardin JardinSet(ParcJardin pj);

	public List<ParcJardin> ChercherPJParMotCle(String KeyWordJP);

	public ParcJardin chercherPJParNom(String nomPj);

	public List<ParcJardin> chercherPJParCategorie(Categorie categorie);

	public boolean AjouterPJ(ParcJardin PJ);

	public ParcJardin ModifierDescriptionPJ(Long idPJ, String desc);

	public ParcJardin ModifierNomPJ(Long idPJ, String nom);

	// public List<Horaire> ConsulterHorairesPJ(Long idPJ);
	public void ModifierHorairesPJ(ParcJardin PJ, List<Horaire> horaire);

	// public List<Commentaire> ConsulterCommentairesPJ(ParcJardin PJ);
	// public ParcJardin ajouterCommentaireToPJ(Commentaire commentaire ,
	// ParcJardin PJ);
	// public ParcJardin supprimerCommetaireFromPJ(Commentaire commentire,
	// ParcJardin PJ );

	public List<Categorie> ConsulterCategoriesPJ(Long idPJ);

	public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin PJ);

	public ParcJardin supprimerCategorieFromPJ(Categorie categorie, ParcJardin PJ);

	public ParcJardin chercherPJLG(String l, String g);

	public List<ParcJardin> consulterPJByType(String type);

}
