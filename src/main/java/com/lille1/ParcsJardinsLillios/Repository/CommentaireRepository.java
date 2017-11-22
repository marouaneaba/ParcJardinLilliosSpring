package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
	
	public List<Commentaire> findById(Long id_parcJardinn);
}
