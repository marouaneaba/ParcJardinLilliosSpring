package com.lille1.parcsjardinslillios.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

/**
 *
 */
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	public Commentaire findById(Long id);

	public List<Commentaire> findByConfirmer(Boolean confirmer);

	public List<Commentaire> findByParcJardinn(ParcJardin parcJardinn);

	public void delete(Commentaire commentaire);

	public List<Commentaire> findByConfirmerAndParcJardinn(boolean confirmer, ParcJardin parcJardinn);

}
