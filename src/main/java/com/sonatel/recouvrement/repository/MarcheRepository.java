package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Marche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcheRepository extends JpaRepository<Marche, Long> {
    boolean existsByLibelleIgnoreCase(String libelle);
}
