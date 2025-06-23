package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.dto.ParametreGeneralDTO;
import com.sonatel.recouvrement.model.ParametreGeneral;

import java.util.List;

public interface ParametreGeneralService {
    List<ParametreGeneral> findAll();
    ParametreGeneral findById(Long id);
    ParametreGeneral save(ParametreGeneral parametre);
    void deleteById(Long id);

    // Déclaration simple, sans corps
    ParametreGeneralDTO convertToDTO(ParametreGeneral parametre);
}


