package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Marche;
import com.sonatel.recouvrement.repository.MarcheRepository;
import com.sonatel.recouvrement.service.MarcheService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcheServiceImpl implements MarcheService {

    private final MarcheRepository marcheRepository;

    public MarcheServiceImpl(MarcheRepository marcheRepository) {
        this.marcheRepository = marcheRepository;
    }

    @Override
    public Marche create(Marche marche) {
        return marcheRepository.save(marche);
    }

    @Override
    public Marche update(Long id, Marche marche) {
        Marche existing = marcheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marche introuvable avec id: " + id));
        existing.setLibelle(marche.getLibelle());
        return marcheRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!marcheRepository.existsById(id)) {
            throw new ResourceNotFoundException("Marche introuvable avec id: " + id);
        }
        marcheRepository.deleteById(id);
    }

    @Override
    public Marche getById(Long id) {
        return marcheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marche introuvable avec id: " + id));
    }

    @Override
    public List<Marche> getAll() {
        return marcheRepository.findAll();
    }
}
