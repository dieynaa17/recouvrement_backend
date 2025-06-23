package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Offre;
import com.sonatel.recouvrement.repository.OffreRepository;
import com.sonatel.recouvrement.service.OffreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImpl implements OffreService {

    private final OffreRepository offreRepository;

    public OffreServiceImpl(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public List<Offre> findAll() {
        return offreRepository.findAll();
    }

    @Override
    public Offre findById(Long id) {
        return offreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offre introuvable avec l'id : " + id));
    }

    @Override
    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // vérifie existence
        offreRepository.deleteById(id);
    }
}
