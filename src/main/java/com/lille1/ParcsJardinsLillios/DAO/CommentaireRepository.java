package com.lille1.ParcsJardinsLillios.DAO;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
	//commentqires pqr PJ
	public List<Commentaire> findById(Long id_parcJardinn);




}
