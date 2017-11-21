package com.lille1.ParcsJardinnsLilios.JardinnParc.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinnsLilios.JardinnParc.Entity.ParcJardinn;



public interface ParcJardinnRepostory extends CrudRepository<ParcJardinn, Long>{
	
	public List<ParcJardinn> findByName(String Name);
}
