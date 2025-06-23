
package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.UniteMonetaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteMonetaireRepository extends JpaRepository<UniteMonetaire, Long> {
}
