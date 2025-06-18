package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {
}

