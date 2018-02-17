package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Categorie;

public interface CategorieInterface {

	public boolean ajouterCategoriePJ(Categorie categorie);

	public List<Categorie> consulterCategories();

	public Categorie consulterCategorieParNom(String nomCategorie);

	public Categorie colsulterCategorieId(Long id);

}
