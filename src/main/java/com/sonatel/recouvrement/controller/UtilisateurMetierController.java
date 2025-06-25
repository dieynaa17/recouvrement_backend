package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.UtilisateurMetier;
import com.sonatel.recouvrement.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs-metier")
@PreAuthorize("hasRole('ADMIN')") // ⛔ accès global réservé aux ADMIN
public class UtilisateurMetierController {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurMetierController(UtilisateurRepository utilisateurRepository,
                                       PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public UtilisateurMetier createUtilisateurMetier(@RequestBody UtilisateurMetier utilisateurMetier) {
        String rawPassword = utilisateurMetier.getMotDePasse();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        utilisateurMetier.setMotDePasse(encodedPassword);

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

