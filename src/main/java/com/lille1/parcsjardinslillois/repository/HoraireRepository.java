package com.lille1.parcsjardinslillois.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lille1.parcsjardinslillois.entity.Horaire;
import com.lille1.parcsjardinslillois.entity.ParcJardin;
import java.util.List;

public interface HoraireRepository extends JpaRepository<Horaire, Long> {
	public void delete(Horaire horaire);

	public List<Horaire> findByParcJardin(ParcJardin parcJardin);

	public Horaire findById(Long id);
}
