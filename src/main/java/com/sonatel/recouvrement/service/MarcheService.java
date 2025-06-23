package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Marche;

import java.util.List;

public interface MarcheService {
    Marche create(Marche marche);
    Marche update(Long id, Marche marche);
    void delete(Long id);
    Marche getById(Long id);
    List<Marche> getAll();
}
