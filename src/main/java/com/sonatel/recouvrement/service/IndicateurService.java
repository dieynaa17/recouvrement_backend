package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Indicateur;

import java.util.List;

public interface IndicateurService {
    List<Indicateur> findAll();
    Indicateur findById(Long id); // plus de Optional
    Indicateur save(Indicateur indicateur);
    void deleteById(Long id);
}


