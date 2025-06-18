package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.EvenementRecouvrement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRecouvrementRepository extends JpaRepository<EvenementRecouvrement, Long> {
}
