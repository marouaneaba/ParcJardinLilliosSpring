package com.lille1.ParcsJardinsLillios.DAO;

import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Notre Repository permet l accee a la base de donne de categorie pour faire les traitement
 * dans notre cas on a deux methode findByNomcategorie qui retourne la categorie de nomcategorie Nom
 * findById retourne la categorie qui a id egale a id
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

   	public Categorie findByNomcategorie(String Nom);
    public Categorie findById(Long id);




}
