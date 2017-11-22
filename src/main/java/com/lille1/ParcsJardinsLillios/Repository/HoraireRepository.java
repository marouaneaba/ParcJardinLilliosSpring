package com.lille1.ParcsJardinsLillios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

import com.lille1.ParcsJardinsLillios.Entity.*;

public interface HoraireRepository extends JpaRepository<Horaire, Long>{

}
