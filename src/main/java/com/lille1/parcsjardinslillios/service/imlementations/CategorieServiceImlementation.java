package com.lille1.parcsjardinslillios.service.imlementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.repository.CategorieRepository;
import com.lille1.parcsjardinslillios.service.interfaces.CategorieInterface;

import java.util.List;

@Service
@Transactional
public class CategorieServiceImlementation implements CategorieInterface {
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie ColsulterCategorieId(Long id) {
		return categorieRepository.findById(id);
	}

	@Override
	public boolean AjouterCategoriePJ(Categorie categorie) {
		Categorie cat = categorieRepository.save(categorie);
		if (cat != null)
			return true;
		else
			return false;
	}

	@Override
	public List<Categorie> consulterCategories() {

		return categorieRepository.findAll();
	}

	@Override
	public Categorie ConsulterCategorieParNom(String nomCategorie) {
		return categorieRepository.findByNomcategorie(nomCategorie);
	}

	@Override
	public List<ParcJardin> ConsulterParcJardinParCategorie(Categorie categorie) {
		return null;

	}

}