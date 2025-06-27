package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Indicateur;

import java.util.List;

public interface IndicateurService {

    List<Indicateur> findAll();
    Indicateur findById(Long id);
    Indicateur save(Indicateur indicateur);
    void deleteById(Long id);

    // Méthodes métier ajoutées
    Indicateur calculerTauxRecouvrement(String segment, String marche, String offre, String periode);
    Indicateur calculerChiffreAffaires(String segment, String marche, String offre, String periode);
}
