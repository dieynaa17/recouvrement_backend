package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.ParametreGeneral;
import java.util.List;

public interface ParametreGeneralService {
    List<ParametreGeneral> findAll();
    ParametreGeneral findById(Long id); // suppression de Optional
    ParametreGeneral save(ParametreGeneral parametre);
    void deleteById(Long id);
}

