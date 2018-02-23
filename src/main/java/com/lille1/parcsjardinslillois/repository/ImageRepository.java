package com.lille1.parcsjardinslillois.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lille1.parcsjardinslillois.entity.Image;
import com.lille1.parcsjardinslillois.entity.ParcJardin;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

	public List<Image> findByParcJardinn(ParcJardin parcJardin);

}
