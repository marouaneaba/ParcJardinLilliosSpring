package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import com.lille1.ParcsJardinsLillios.Entity.*;


public interface ParcJardInInterface {

	
	 public Iterable<ParcJardin> ConsulterParcsJardin();
	
	 public void JardinnSet(String name, String description, boolean parc, double l, double g);
	 //public List<ParcJardin> ChercherPJ(String KeyWordJP);
	
	 //public ParcJardin ChercherPJ(Long id);
	 
	 //public void AjouterPJ(ParcJardin JP);
	 
	 //public void SupprimerPJ(ParcJardin JP);
	 
	 //public void ModifierPJ(ParcJardin JP);
	 
	 //public List<Commentaire> ConsulterCommentaire(boolean confirmer);
	 
	 //public void ConfirmerCommentaire(Long id);
	 
	 //public void supprimerCommentaire(Long id);
	 
	 
	 

}
