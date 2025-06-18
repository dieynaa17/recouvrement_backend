package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.repository.ParametreGeneralRepository;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametreGeneralServiceImpl implements ParametreGeneralService {

    private final ParametreGeneralRepository parametreRepository;

    public ParametreGeneralServiceImpl(ParametreGeneralRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    @Override
    public List<ParametreGeneral> findAll() {
        return parametreRepository.findAll();
    }

    @Override
    public ParametreGeneral findById(Long id) {
        return parametreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paramètre introuvable avec l'id: " + id));
    }

    @Override
    public ParametreGeneral save(ParametreGeneral parametre) {
        return parametreRepository.save(parametre);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // vérifie existence avant suppression
        parametreRepository.deleteById(id);
    }
}

