package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("SELECT SUM(f.montant) FROM Facture f " +
            "WHERE (:segment IS NULL OR f.client.segment.libelle = :segment) " +
            "AND (:marche IS NULL OR f.client.marche.libelle = :marche) " +
            "AND (:offre IS NULL OR f.client.offre.libelle = :offre) " +
            "AND (:periode IS NULL OR f.periode = :periode)")
    Double getTotalFacturesByFiltre(
            @Param("segment") String segment,
            @Param("marche") String marche,
            @Param("offre") String offre,
            @Param("periode") String periode
    );
}

