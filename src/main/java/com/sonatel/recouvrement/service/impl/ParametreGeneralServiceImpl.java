package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.dto.ParametreGeneralDTO;
import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.repository.ParametreGeneralRepository;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParametreGeneralServiceImpl implements ParametreGeneralService {

    private final ParametreGeneralRepository repository;

    public ParametreGeneralServiceImpl(ParametreGeneralRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ParametreGeneral> findAll() {
        return repository.findAll();
    }

    @Override
    public ParametreGeneral findById(Long id) {
        Optional<ParametreGeneral> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public ParametreGeneral save(ParametreGeneral parametre) {
        return repository.save(parametre);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ParametreGeneralDTO convertToDTO(ParametreGeneral parametre) {
        if (parametre == null) return null;

        return new ParametreGeneralDTO(
                parametre.getIdParametre(),
                parametre.getSeuilAlerte(),
                parametre.getMarche() != null ? parametre.getMarche().getLibelle() : null,
                parametre.getSegment() != null ? parametre.getSegment().getLibelle() : null,
                parametre.getOffre() != null ? parametre.getOffre().getLibelle() : null,
                parametre.getPeriodeAnalyse() != null ? parametre.getPeriodeAnalyse().getLibelle() : null,
                parametre.getUniteMonetaire() != null ? parametre.getUniteMonetaire().getLibelle() : null
        );
    }
}

