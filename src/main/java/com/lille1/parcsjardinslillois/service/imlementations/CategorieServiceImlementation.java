package com.lille1.parcsjardinslillois.service.imlementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lille1.parcsjardinslillois.entity.Categorie;
import com.lille1.parcsjardinslillois.repository.CategorieRepository;
import com.lille1.parcsjardinslillois.service.interfaces.CategorieInterface;

import java.util.List;

@Service
@Transactional
public class CategorieServiceImlementation implements CategorieInterface {
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie colsulterCategorieId(Long id) {
		return categorieRepository.findById(id);
	}

	@Override
	public boolean ajouterCategoriePJ(Categorie categorie) {
		Categorie cat = categorieRepository.save(categorie);
		return cat == null ? false : true;
	}

	@Override
	public List<Categorie> consulterCategories() {

		return categorieRepository.findAll();
	}

	@Override
	public Categorie consulterCategorieParNom(String nomCategorie) {
		return categorieRepository.findByNomcategorie(nomCategorie);
	}

}
