package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.TypeEvenement;

import java.util.List;

public interface TypeEvenementService {
    List<TypeEvenement> findAll();
    TypeEvenement findById(Long id);
    TypeEvenement save(TypeEvenement typeEvenement);
    void deleteById(Long id);
}
