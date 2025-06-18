package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.UtilisateurMetier;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs-metier")
public class UtilisateurMetierController {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurMetierController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping
    public UtilisateurMetier createUtilisateurMetier(@RequestBody UtilisateurMetier utilisateurMetier) {
        return utilisateurRepository.save(utilisateurMetier);
    }

    @GetMapping
    public List<UtilisateurMetier> getAll() {
        return utilisateurRepository.findAll().stream()
                .filter(user -> user instanceof UtilisateurMetier)
                .map(user -> (UtilisateurMetier) user)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurMetier> getById(@PathVariable Long id) {
        return utilisateurRepository.findById(id)
                .filter(user -> user instanceof UtilisateurMetier)
                .map(user -> ResponseEntity.ok((UtilisateurMetier) user))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return utilisateurRepository.findById(id)
                .filter(user -> user instanceof UtilisateurMetier)
                .map(user -> {
                    utilisateurRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
