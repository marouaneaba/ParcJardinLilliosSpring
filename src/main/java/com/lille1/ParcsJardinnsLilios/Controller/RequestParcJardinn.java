package com.lille1.ParcsJardinnsLilios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lille1.ParcsJardinnsLilios.Entity.*;
import com.lille1.ParcsJardinnsLilios.Repository.ParcJardinnRepository;

@RestController
@RequestMapping("/jardinn")
public class RequestParcJardinn {

	@Autowired
	ParcJardinnRepository mParcJardinnRepostory;
	
	
	/**
     * Permet de retourner la liste des Jardinns et Parcs enregistrés
     * via GET
     * url : http://localhost:8080/Jardinn
     * @return la liste des jardinns et des parc
     */
	@RequestMapping(method = RequestMethod.GET)
	 public Iterable<ParcJardinnEntity> JardinnGet() {
		return mParcJardinnRepostory.findAll();
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
				@RequestParam("parc")boolean parc) {
		mParcJardinnRepostory.save(new ParcJardinnEntity(name,description,parc));
	 }
	
}
