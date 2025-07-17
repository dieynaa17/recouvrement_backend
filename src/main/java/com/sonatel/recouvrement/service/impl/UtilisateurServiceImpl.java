package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Utilisateur;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import com.sonatel.recouvrement.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec id " + id));
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        // Le mot de passe doit être déjà encodé avant d'arriver ici
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteById(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new ResourceNotFoundException("Utilisateur non trouvé avec id " + id);
        }
        utilisateurRepository.deleteById(id);
    }
}
