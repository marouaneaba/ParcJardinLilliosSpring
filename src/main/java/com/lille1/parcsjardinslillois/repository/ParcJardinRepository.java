package com.lille1.parcsjardinslillois.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.lille1.parcsjardinslillois.entity.Categorie;
import com.lille1.parcsjardinslillois.entity.ParcJardin;

public interface ParcJardinRepository extends JpaRepository<ParcJardin, Long> {

	public List<ParcJardin> findByNameContaining(String name);


	public ParcJardin findByName(String pj);

	public ParcJardin findById(Long id);

	public List<ParcJardin> findByCategories(Categorie categorie);

	public List<ParcJardin> findByType(String type);

	@Query("select distinct P from ParcJardin P where P.latitude=:latitude and P.longitude=:logitude")
	public ParcJardin trouverPJparLG(@Param("latitude") String latitude, @Param("logitude") String logitude);

}
