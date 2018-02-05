package com.lille1.ParcsJardinsLillios.ApiRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;

@RestController
public class CategorieRestController {

	
	
	@RequestMapping(value = "/api/Categorie", method = RequestMethod.GET)
	public List<Categorie> GetCategorie() {
		
		Commentaire commentaire1 = new Commentaire("anonyme",4,"commentaire 1 ", true);
		Commentaire commentaire2 = new Commentaire("mathois",3,"commentaire 2 ", false);
		
		Categorie categorie1 = new Categorie("categorie 1 ");
		
		ParcJardin PJ1 = new ParcJardin("parc ","parc de lille créer par marouane","parcType",1.5,4.5,"rue paul langevin");
		List<Commentaire> commentaires = new ArrayList<>();
		commentaires.add(commentaire1);
		commentaires.add(commentaire2);
		PJ1.setCommentaires(commentaires);
		
		List<ParcJardin> ParcJardins = new ArrayList<>();
		ParcJardins.add(PJ1);
		categorie1.setParcJardinn(ParcJardins);
		
		Categorie categorie2 = new Categorie("categorie 2 ");
		ParcJardin PJ2 = new ParcJardin("jardinn ","jardinne de lille !!!!","JardinnType",7.5,19.005,"rue 2 paul langevin");
		PJ2.setCommentaires(commentaires);
		ParcJardins.clear();
		ParcJardins.add(PJ2);
		categorie2.setParcJardinn(ParcJardins);
		
		List<Categorie> categories = new ArrayList<>();
		categories.add(categorie1);
		categories.add(categorie2);
		
		return categories;
	}
	
	
	@RequestMapping(value = "/api/Categorie", method = RequestMethod.POST)
	public String POSTCategorie(@RequestParam("name")String name) {
		
		if(name == null || name.isEmpty()){
			return "Failed";
		}
		return "Succeess";
	}
	
}
