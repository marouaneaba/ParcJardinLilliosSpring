package com.lille1.ParcsJardinnsLillios.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinnsLillios.Entity.Commentaire;

public interface CommentaireRepository extends CrudRepository<Commentaire, Long>{
	
	public List<Commentaire> findById(Long id_parcJardinn);
}
