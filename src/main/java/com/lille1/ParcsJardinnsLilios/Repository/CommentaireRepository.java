package com.lille1.ParcsJardinnsLilios.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lille1.ParcsJardinnsLilios.Entity.CommentaireEntity;

public interface CommentaireRepository extends CrudRepository<CommentaireEntity, Long>{
	
	public List<CommentaireEntity> findById(Long id_parcJardinn);
}
