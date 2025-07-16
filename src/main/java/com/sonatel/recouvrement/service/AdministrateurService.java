package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Administrateur;
import java.util.List;
import java.util.Optional;

public interface AdministrateurService {
    List<Administrateur> findAll();
    Optional<Administrateur> findById(Long id);
    Optional<Administrateur> findByEmail(String email);
    boolean existsById(Long id);
    Administrateur save(Administrateur administrateur);
    void deleteById(Long id);
}