package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinsLillios.Entity.*;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	//public Admin findByNameAndPassword(String name,String password);
}
