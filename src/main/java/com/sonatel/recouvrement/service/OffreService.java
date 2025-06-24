package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Offre;

import java.util.List;

public interface OffreService {
    List<Offre> findAll();
    Offre findById(Long id);
    Offre save(Offre offre);
    void deleteById(Long id);
}
