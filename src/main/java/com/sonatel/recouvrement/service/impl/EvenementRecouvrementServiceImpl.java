package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.EvenementRecouvrement;
import com.sonatel.recouvrement.repository.EvenementRecouvrementRepository;
import com.sonatel.recouvrement.service.EvenementRecouvrementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementRecouvrementServiceImpl implements EvenementRecouvrementService {

    private final EvenementRecouvrementRepository evenementRepository;

    public EvenementRecouvrementServiceImpl(EvenementRecouvrementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    @Override
    public List<EvenementRecouvrement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public EvenementRecouvrement findById(Long id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Événement introuvable avec l'id: " + id));
    }

    @Override
    public EvenementRecouvrement save(EvenementRecouvrement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public EvenementRecouvrement update(Long id, EvenementRecouvrement evenement) {
        EvenementRecouvrement existant = findById(id);

        existant.setTypeEvenement(evenement.getTypeEvenement());
        existant.setDateEvenement(evenement.getDateEvenement());
        existant.setStatutEvenement(evenement.getStatutEvenement());
        existant.setCommentaire(evenement.getCommentaire());
        existant.setClient(evenement.getClient());

        return evenementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // vérifie existence
        evenementRepository.deleteById(id);
    }
}

