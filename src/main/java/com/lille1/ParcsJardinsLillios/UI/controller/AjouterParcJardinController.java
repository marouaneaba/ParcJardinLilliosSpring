package com.lille1.ParcsJardinsLillios.UI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lille1.ParcsJardinsLillios.Repository.ParcJardinRepository;

@Controller
@RequestMapping("/ajouterParcJardin")
public class AjouterParcJardinController {

	
	@Autowired
	private ParcJardinRepository mParcJardinRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAjoutJardinParc(){
		
		return "ajouterParcJardin";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String setAjoutJardinParc(@RequestParam("nom")String nom,@RequestParam("horaire")String horaire,
			@RequestParam("address")String address,@RequestParam("gategorie")String gategori,
			@RequestParam("service")String service,@RequestParam("description")String desciption,
			@RequestParam("type")String type){
		
			
		
		return "ajouterParcJardin";
	}
	
}
