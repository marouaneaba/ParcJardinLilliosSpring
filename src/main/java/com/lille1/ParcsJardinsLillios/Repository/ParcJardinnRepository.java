package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lille1.ParcsJardinsLillios.Entity.*;



public interface ParcJardinnRepository extends JpaRepository<ParcJardinn, Long>{
	
	public List<ParcJardinn> findByName(String Name);
}
