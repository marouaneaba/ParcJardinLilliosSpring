package com.lille1.ParcsJardinnsLillios.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinnsLillios.Entity.*;



public interface ParcJardinnRepository extends CrudRepository<ParcJardinn, Long>{
	
	public List<ParcJardinn> findByName(String Name);
}
