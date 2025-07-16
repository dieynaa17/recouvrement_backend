package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.dto.ParametreGeneralDTO;
import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.repository.ParametreGeneralRepository;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

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
        return repository.findById(id).orElse(null);
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
    public boolean existsById(Long id) { // Implémentation ajoutée
        return repository.existsById(id);
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

    @Override
    public ParametreGeneral findLatestSettings() {
        return repository.findAll(
                PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "idParametre"))
        ).getContent().stream().findFirst().orElse(null);
    }
}