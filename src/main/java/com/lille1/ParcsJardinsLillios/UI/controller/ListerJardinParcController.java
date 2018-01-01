package com.lille1.ParcsJardinsLillios.UI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;

@Controller
@RequestMapping("/ListerJardinsParcs")
public class ListerJardinParcController {

	
	@Autowired
	private ParcJardinRepository mParcJardinRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listerJardinParc(){
		
		return "ListerJardinParc";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String PostJardinParc(@RequestParam("nom")String nom,@RequestParam("horaire")String horaire,
			@RequestParam("address")String address,@RequestParam("gategorie")String gategori,
			@RequestParam("service")String service,@RequestParam("description")String desciption,
			@RequestParam("type")String type){
		
			
		
		return "ListerJardinParc";
	}
}
