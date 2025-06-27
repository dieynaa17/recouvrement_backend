package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Administrateur;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {

    private final UtilisateurRepository utilisateurRepository;

    public AdministrateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur admin) {
        return utilisateurRepository.save(admin);
    }

    @GetMapping
    public List<Administrateur> getAll() {
        return utilisateurRepository.findAll().stream()
                .filter(user -> user instanceof Administrateur)
                .map(user -> (Administrateur) user)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getById(@PathVariable Long id) {
        return utilisateurRepository.findById(id)
                .filter(user -> user instanceof Administrateur)
                .map(user -> ResponseEntity.ok((Administrateur) user))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return utilisateurRepository.findById(id)
                .filter(user -> user instanceof Administrateur)
                .map(user -> {
                    utilisateurRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
