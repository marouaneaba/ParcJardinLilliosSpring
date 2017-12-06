package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lille1.ParcsJardinsLillios.Entity.*;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	@Query("select a from Admin a where a.Name like :n and a.password like :p")
	public Admin findByNameAndPassword(@Param("n")String name,@Param("p")String password);

}
