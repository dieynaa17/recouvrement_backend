package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Alerte;
import com.sonatel.recouvrement.repository.AlerteRepository;
import com.sonatel.recouvrement.service.AlerteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlerteServiceImpl implements AlerteService {

    private final AlerteRepository alerteRepository;

    public AlerteServiceImpl(AlerteRepository alerteRepository) {
        this.alerteRepository = alerteRepository;
    }

    @Override
    public List<Alerte> findAll() {
        return alerteRepository.findAll();
    }

    @Override


    public Alerte findById(Long id) {
        return alerteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerte introuvable avec l'id: " + id));
    }


    @Override
    public Alerte save(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    @Override
    public void deleteById(Long id) {
        alerteRepository.deleteById(id);
    }
}

