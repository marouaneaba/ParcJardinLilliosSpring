package com.lille1.parcsjardinslillios.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long> {

	public List<ParcJardin> findByNameContaining(String name);

	public List<ParcJardin> findAll();

	public ParcJardin findByName(String pj);

	public ParcJardin findById(Long id);

	public List<ParcJardin> findByCategories(Categorie categorie);

	public List<ParcJardin> findByType(String type);

	@Query("select distinct P from ParcJardin P where P.L=:latitude and P.G=:logitude")
	public ParcJardin trouverPJparLG(@Param("latitude") String latitude, @Param("logitude") String logitude);

}
