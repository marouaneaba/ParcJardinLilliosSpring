package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lille1.ParcsJardinsLillios.Entity.*;



public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long>{
	
	public List<ParcJardin> findByName(String Name);
}
