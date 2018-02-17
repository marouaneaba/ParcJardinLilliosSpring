package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Categorie;

public interface CategorieInterface {

	public boolean AjouterCategoriePJ(Categorie Categorie);

	public List<Categorie> consulterCategories();

	public Categorie ConsulterCategorieParNom(String nomCategorie);

	public Categorie ColsulterCategorieId(Long id);

}
