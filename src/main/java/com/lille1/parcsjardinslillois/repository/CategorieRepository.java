package com.lille1.parcsjardinslillois.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lille1.parcsjardinslillois.entity.Categorie;

/**
 * Notre Repository permet l accee a la base de donne de categorie pour faire
 * les traitement dans notre cas on a deux methode findByNomcategorie qui
 * retourne la categorie de nomcategorie Nom findById retourne la categorie qui
 * a id egale a id
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	public Categorie findByNomcategorie(String nom);

	public Categorie findById(Long id);

}
