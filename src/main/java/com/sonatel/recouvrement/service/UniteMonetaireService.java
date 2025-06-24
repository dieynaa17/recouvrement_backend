package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.UniteMonetaire;

import java.util.List;

public interface UniteMonetaireService {
    List<UniteMonetaire> findAll();
    UniteMonetaire findById(Long id);
    UniteMonetaire save(UniteMonetaire uniteMonetaire);
    void deleteById(Long id);
}
