package com.lille1.ParcsJardinsLillios.DAO;

import com.lille1.ParcsJardinsLillios.Entity.Image;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    public List<Image> findByParcJardinn(ParcJardin parcJardin);


}
