package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
