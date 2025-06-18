package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Utilisateur;
import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> findAll();
    Utilisateur findById(Long id) throws ResourceNotFoundException; // lance exception si non trouvé
    Utilisateur save(Utilisateur utilisateur);
    void deleteById(Long id) throws ResourceNotFoundException; // optionnel : lancer exception si id inexistant
}
