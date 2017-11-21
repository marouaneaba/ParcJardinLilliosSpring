package com.lille1.ParcsJardinnsLilios.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinnsLilios.Entity.*;



public interface ParcJardinnRepository extends CrudRepository<ParcJardinnEntity, Long>{
	
	public List<ParcJardinnEntity> findByName(String Name);
}
