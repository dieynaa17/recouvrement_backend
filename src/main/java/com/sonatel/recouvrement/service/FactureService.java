package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> findAll();
    Facture findById(Long id); // changé ici
    Facture save(Facture facture);
    void deleteById(Long id);
}



