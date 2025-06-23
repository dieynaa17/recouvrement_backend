package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.PeriodeAnalyse;
import com.sonatel.recouvrement.repository.PeriodeAnalyseRepository;
import com.sonatel.recouvrement.service.PeriodeAnalyseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodeAnalyseServiceImpl implements PeriodeAnalyseService {

    private final PeriodeAnalyseRepository repository;

    public PeriodeAnalyseServiceImpl(PeriodeAnalyseRepository repository) {
        this.repository = repository;
    }

    @Override
    public PeriodeAnalyse create(PeriodeAnalyse periode) {
        return repository.save(periode);
    }

    @Override
    public List<PeriodeAnalyse> findAll() {
        return repository.findAll();
    }

    @Override
    public PeriodeAnalyse findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Période non trouvée avec l'ID : " + id));
    }

    @Override
    public PeriodeAnalyse update(Long id, PeriodeAnalyse updated) {
        PeriodeAnalyse existing = findById(id);
        existing.setLibelle(updated.getLibelle());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

