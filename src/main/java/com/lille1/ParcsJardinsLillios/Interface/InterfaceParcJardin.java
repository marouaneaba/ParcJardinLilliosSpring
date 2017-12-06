package com.lille1.ParcsJardinsLillios.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lille1.ParcsJardinsLillios.Entity.*;
import com.lille1.ParcsJardinsLillios.Repository.ParcJardinRepository;


public interface InterfaceParcJardin {

	
	 public Iterable<ParcJardin> ConsulterParcsJardin();
	
	 public void JardinnSet(String name,String description,boolean parc,double l,double g);
	 //public List<ParcJardin> ChercherPJ(String KeyWordJP);
	
	 //public ParcJardin ChercherPJ(Long id);
	 
	 //public void AjouterPJ(ParcJardin JP);
	 
	 //public void SupprimerPJ(ParcJardin JP);
	 
	 //public void ModifierPJ(ParcJardin JP);
	 
	 //public List<Commentaire> ConsulterCommentaire(boolean confirmer);
	 
	 //public void ConfirmerCommentaire(Long id);
	 
	 //public void supprimerCommentaire(Long id);
	 
	 
	 

}
