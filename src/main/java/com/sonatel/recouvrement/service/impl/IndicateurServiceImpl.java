package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Indicateur;
import com.sonatel.recouvrement.repository.IndicateurRepository;
import com.sonatel.recouvrement.service.IndicateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicateurServiceImpl implements IndicateurService {

    private final IndicateurRepository indicateurRepository;

    public IndicateurServiceImpl(IndicateurRepository indicateurRepository) {
        this.indicateurRepository = indicateurRepository;
    }

    @Override
    public List<Indicateur> findAll() {
        return indicateurRepository.findAll();
    }

    @Override
    public Indicateur findById(Long id) {
        return indicateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Indicateur introuvable avec l'id: " + id));
    }

    @Override
    public Indicateur save(Indicateur indicateur) {
        return indicateurRepository.save(indicateur);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // vérifie existence avant suppression
        indicateurRepository.deleteById(id);
    }
}
