package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Paiement;
import java.util.List;

public interface PaiementService {
    List<Paiement> findAll();
    Paiement findById(Long id); // plus de Optional
    Paiement save(Paiement paiement);
    void deleteById(Long id);
}
