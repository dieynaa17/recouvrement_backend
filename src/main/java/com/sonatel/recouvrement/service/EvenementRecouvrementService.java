package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.EvenementRecouvrement;

import java.util.List;

public interface EvenementRecouvrementService {
    List<EvenementRecouvrement> findAll();
    EvenementRecouvrement findById(Long id);
    EvenementRecouvrement save(EvenementRecouvrement evenement);
    EvenementRecouvrement update(Long id, EvenementRecouvrement evenement);  // ajout update
    void deleteById(Long id);
}
