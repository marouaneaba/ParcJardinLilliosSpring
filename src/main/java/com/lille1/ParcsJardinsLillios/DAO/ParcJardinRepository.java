package com.lille1.ParcsJardinsLillios.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lille1.ParcsJardinsLillios.Entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long>{
	public List<ParcJardin> findAll();
	public ParcJardin findByName(String PJ);
	public ParcJardin findById(Long id);
	
	public List<ParcJardin> findByType(String type);
	@Query("select P from ParcJardin P where P.L=:l and P.G=:g")
	public ParcJardin trouverPJparLG(@Param("l") double L, @Param("g") double G);
	//public ParcJardin findByLAndG(double l,double g);
	public List<ParcJardin> findByNameContaining(String name);


}
