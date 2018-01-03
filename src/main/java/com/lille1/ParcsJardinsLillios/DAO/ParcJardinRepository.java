package com.lille1.ParcsJardinsLillios.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lille1.ParcsJardinsLillios.Entity.*;



public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long>{
	public List<ParcJardin> findAll();
	public ParcJardin findByName(String PJ);
	public ParcJardin findById(Long id);
	public List<ParcJardin> findByCategories(Categorie categorie);
	public List<ParcJardin> findByType(String type);

}
