package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinsLillios.Entity.*;



public interface ParcJardinnRepository extends CrudRepository<ParcJardinn, Long>{
	
	public List<ParcJardinn> findByName(String Name);
}
