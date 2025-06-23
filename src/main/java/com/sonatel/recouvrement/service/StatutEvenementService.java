package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.StatutEvenement;

import java.util.List;

public interface StatutEvenementService {
    StatutEvenement save(StatutEvenement statut);
    List<StatutEvenement> findAll();
    StatutEvenement findById(Long id);
    void deleteById(Long id);
}
