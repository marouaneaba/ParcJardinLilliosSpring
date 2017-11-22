package com.lille1.ParcsJardinsLillios.Repository;

import java.util.List;

import org.springframework.data.repository.*;

import com.lille1.ParcsJardinsLillios.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
