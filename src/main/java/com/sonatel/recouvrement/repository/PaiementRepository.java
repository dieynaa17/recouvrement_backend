package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    @Query("SELECT SUM(p.montantPaye) FROM Paiement p " +
            "WHERE (:segment IS NULL OR p.client.segment.libelle = :segment) " +
            "AND (:marche IS NULL OR p.client.marche.libelle = :marche) " +
            "AND (:offre IS NULL OR p.client.offre.libelle = :offre) " +
            "AND (:periode IS NULL OR p.facture.periode.libelle = :periode)")
    Double getTotalPaiementsByFiltre(
            @Param("segment") String segment,
            @Param("marche") String marche,
            @Param("offre") String offre,
            @Param("periode") String periode
    );
}
