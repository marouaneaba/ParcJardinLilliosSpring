package com.lille1.parcsjardinslillios.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.service.interfaces.CategorieInterface;

@RestController
public class CategorieRestController {

	@Autowired
	private CategorieInterface mCategorieInterface;

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/api/Categorie")
	public List<Categorie> getCategorie() {
		return mCategorieInterface.consulterCategories();
	}

}
