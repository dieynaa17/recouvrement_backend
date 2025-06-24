package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Alerte;

import java.util.List;

public interface AlerteService {
    List<Alerte> findAll();
    Alerte findById(Long id);
    Alerte save(Alerte alerte);
    void deleteById(Long id);
}
