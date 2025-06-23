package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.model.StatutEvenement;
import com.sonatel.recouvrement.repository.StatutEvenementRepository;
import com.sonatel.recouvrement.service.StatutEvenementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutEvenementServiceImpl implements StatutEvenementService {

    private final StatutEvenementRepository repository;

    public StatutEvenementServiceImpl(StatutEvenementRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatutEvenement save(StatutEvenement statut) {
        return repository.save(statut);
    }

    @Override
    public List<StatutEvenement> findAll() {
        return repository.findAll();
    }

    @Override
    public StatutEvenement findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Statut introuvable"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

