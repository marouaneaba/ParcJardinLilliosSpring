package com.lille1.ParcsJardinsLillios.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lille1.ParcsJardinsLillios.Entity.*;



public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long>{
	
	public ParcJardin findByName(String PJ);
	public Long findById(Long idPJ);
}
