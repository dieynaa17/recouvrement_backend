package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
