package com.lille1.ParcsJardinsLillios.Controller.Interface;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.*;

public interface InterfaceCategorie {

	
	public void AjouterCategoriePJ(Categorie Categorie);
	public void ColsulterCategorie();
	public void SupprimerCategorie(Long idPJ);
	public void ModifierCategorie(Categorie categorie,Long idCat);
	public List<Categorie> listerCategoriePJ(Long idJP);
	public List<Categorie> listerCategoriePJ();
	
}
