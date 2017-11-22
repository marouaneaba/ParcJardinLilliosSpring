package com.lille1.ParcsJardinsLillios.Controller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lille1.ParcsJardinsLillios.Controller.Interface.InterfaceParcJardin;
import com.lille1.ParcsJardinsLillios.Entity.*;
import com.lille1.ParcsJardinsLillios.Repository.ParcJardinRepository;

@RestController
@RequestMapping("/jardinn")
public class RequestParcJardin  implements InterfaceParcJardin{

	@Autowired
	ParcJardinRepository mParcJardinnRepostory;
	
	
	/**
     * Permet de retourner la liste des Jardinns et Parcs enregistrés
     * via GET
     * url : http://localhost:8080/Jardinn
     * @return la liste des jardinns et des parc
     */
	@RequestMapping(method = RequestMethod.GET)
	 public Iterable<ParcJardin> ConsulterParcsJardin() {
		return mParcJardinnRepostory.findAll();
	 }
	
	@RequestMapping(method = RequestMethod.GET)
	 public void ChercherPJ() {
		
	 }
	
	/**
     * Permet d'enregistrer un nouvel Jardinn ou Parc
     * via POST
     * url : http://localhost:8080/Jardinn
     * @param name le nom de jardinn
     * @param description la description sur un jardinn
     */
	@RequestMapping(method = RequestMethod.POST)
	 public void JardinnSet(@RequestParam("name")String name,
				@RequestParam("description")String description,
				@RequestParam("parc")boolean parc,
				@RequestParam("l")double l,
				@RequestParam("g")double g) {
		mParcJardinnRepostory.save(new ParcJardin(name,description,parc,l,g,null,null,null));
	 }

	/**
     * Permet de rechercher Jardinn ou Parc
     * via POST
     * url : http://localhost:8080/Jardinn
     * @param name le nom de jardinn
     * @param description la description sur un jardinn
     */
	@Override
	public List<ParcJardin> ChercherPJ(String KeyWordJP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParcJardin ChercherPJ(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AjouterPJ(ParcJardin JP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SupprimerPJ(ParcJardin JP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModifierPJ(ParcJardin JP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> ConsulterCommentaire(boolean confirmer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConfirmerCommentaire(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCommentaire(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
