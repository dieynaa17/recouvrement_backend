package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.TypeEvenement;
import com.sonatel.recouvrement.repository.TypeEvenementRepository;
import com.sonatel.recouvrement.service.TypeEvenementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEvenementServiceImpl implements TypeEvenementService {

    private final TypeEvenementRepository repository;

    public TypeEvenementServiceImpl(TypeEvenementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TypeEvenement> findAll() {
        return repository.findAll();
    }

    @Override
    public TypeEvenement findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Type d'événement introuvable avec l'id : " + id));
    }

    @Override
    public TypeEvenement save(TypeEvenement typeEvenement) {
        return repository.save(typeEvenement);
    }

    @Override
    public void deleteById(Long id) {
        findById(id); // pour lever l'exception si non trouvé
        repository.deleteById(id);
    }
}

