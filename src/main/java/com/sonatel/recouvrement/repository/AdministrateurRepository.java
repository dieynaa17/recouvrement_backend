package com.sonatel.recouvrement.repository;

import com.sonatel.recouvrement.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    /**
     * Trouve un administrateur par son email (hérité de Utilisateur)
     * @param email L'email à rechercher
     * @return Optional contenant l'administrateur
     */
    Optional<Administrateur> findByEmail(String email);

    /**
     * Vérifie l'existence d'un email (hérité de Utilisateur)
     * @param email L'email à vérifier
     * @return true si l'email existe
     */
    boolean existsByEmail(String email);

    /**
     * Recherche spécifique avec jointure sur les paramètres généraux
     * @param parametreId ID du paramètre général
     * @return L'administrateur associé
     */
    @Query("SELECT a FROM Administrateur a JOIN a.parametres p WHERE p.id = :parametreId")
    Optional<Administrateur> findByParametreId(@Param("parametreId") Long parametreId);
}