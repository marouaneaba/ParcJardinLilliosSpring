package com.lille1.ParcsJardinsLillios.DAO;

import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

   // public Categorie findByNomCategorie(String Nom);
    public Categorie findById(Long id);
    public void deleteById(Long id);
    public Categorie findBynomcategorie(String nomCategorie);
    //public List<Categorie> findByParcJardinn(ParcJardin ParcJardinn);



}
