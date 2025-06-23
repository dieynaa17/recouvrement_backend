package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.PeriodeAnalyse;

import java.util.List;

public interface PeriodeAnalyseService {
    PeriodeAnalyse create(PeriodeAnalyse periode);
    List<PeriodeAnalyse> findAll(); // <-- cette méthode doit être là
    PeriodeAnalyse findById(Long id);
    PeriodeAnalyse update(Long id, PeriodeAnalyse updated);
    void delete(Long id);
}

