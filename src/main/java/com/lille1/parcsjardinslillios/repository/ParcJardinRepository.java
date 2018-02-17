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

	public ParcJardin findByName(String PJ);

	public ParcJardin findById(Long id);

	public List<ParcJardin> findByCategories(Categorie categorie);

	public List<ParcJardin> findByType(String type);

	@Query("select distinct P from ParcJardin P where P.L=:l and P.G=:g")
	public ParcJardin trouverPJparLG(@Param("l") String L, @Param("g") String G);

}
