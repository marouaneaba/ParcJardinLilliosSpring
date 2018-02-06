package com.lille1.ParcsJardinsLillios.DAO;

import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

   // public Categorie findByNomCategorie(String Nom);
    public Categorie findById(Long id);
    public void deleteById(Long id);
    public Categorie findBynomcategorie(String nomCategorie);
    //@Query("select distinct c from Categorie c inner JOIN c.ParcJardinn p where p.id = :idParc ")
    //@Query("select c from Categorie c inner Join c.ParcJardinn p where p.id = :idParc")
    //public List<Categorie> findByParcJardinn(@Param("idParc") Long idParc);
    @Query("select c from Categorie c inner Join c.ParcJardinn p where p.id = :idParc")
    public List<Categorie> findByParcJardinnId(@Param("idParc") Long IdParc);


}
