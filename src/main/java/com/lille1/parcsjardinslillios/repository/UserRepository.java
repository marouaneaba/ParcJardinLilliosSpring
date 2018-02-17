package com.lille1.parcsjardinslillios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.lille1.parcsjardinslillios.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select a from User a where a.Name like :n and a.password like :p")
	public User findByNameAndPassword(@Param("n") String name, @Param("p") String password);

	public User findByEmail(String email);

	public User findByPassword(String password);

}
