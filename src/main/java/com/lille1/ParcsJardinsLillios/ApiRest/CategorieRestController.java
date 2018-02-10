package com.lille1.ParcsJardinsLillios.ApiRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;

@RestController
public class CategorieRestController {

	@Autowired
	private CategorieInterface mCategorieInterface;
	
	
	@GetMapping(value = "/api/Categorie")
	public List<Categorie> GetCategorie() {
		return mCategorieInterface.consulterCategories();
	}
	
	
	
}
