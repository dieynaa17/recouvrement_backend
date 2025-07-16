package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.model.Administrateur;
import com.sonatel.recouvrement.repository.AdministrateurRepository;
import com.sonatel.recouvrement.service.AdministrateurService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

    private final AdministrateurRepository repository;

    public AdministrateurServiceImpl(AdministrateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Administrateur> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Administrateur> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Administrateur> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Administrateur save(Administrateur administrateur) {
        return repository.save(administrateur);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}