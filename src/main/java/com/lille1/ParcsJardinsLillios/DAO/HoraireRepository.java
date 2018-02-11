package com.lille1.ParcsJardinsLillios.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lille1.ParcsJardinsLillios.Entity.*;

import java.util.List;

public interface HoraireRepository extends JpaRepository<Horaire, Long>{
public void delete(Horaire horaire);
public List<Horaire> findByParcJardin(ParcJardin parcJardin);
}
