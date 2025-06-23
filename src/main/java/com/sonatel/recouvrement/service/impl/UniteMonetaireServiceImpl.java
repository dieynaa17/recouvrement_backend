package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.UniteMonetaire;
import com.sonatel.recouvrement.repository.UniteMonetaireRepository;
import com.sonatel.recouvrement.service.UniteMonetaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteMonetaireServiceImpl implements UniteMonetaireService {

    private final UniteMonetaireRepository uniteMonetaireRepository;

    public UniteMonetaireServiceImpl(UniteMonetaireRepository uniteMonetaireRepository) {
        this.uniteMonetaireRepository = uniteMonetaireRepository;
    }

    @Override
    public List<UniteMonetaire> findAll() {
        return uniteMonetaireRepository.findAll();
    }

    @Override
    public UniteMonetaire findById(Long id) {
        return uniteMonetaireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unité monétaire introuvable avec l'id : " + id));
    }

    @Override
    public UniteMonetaire save(UniteMonetaire uniteMonetaire) {
        return uniteMonetaireRepository.save(uniteMonetaire);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        uniteMonetaireRepository.deleteById(id);
    }
}
