package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Utilisateur;
import com.sonatel.recouvrement.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@PreAuthorize("hasRole('ADMIN')") // ✅ Ajout important
public class UtilisateurController {

    private final UtilisateurService service;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurController(UtilisateurService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable Long id) {
        try {
            Utilisateur utilisateur = service.findById(id);
            return ResponseEntity.ok(utilisateur);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse())); // encodage
        return service.save(utilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> update(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        try {
            Utilisateur utilisateur = service.findById(id);

            utilisateur.setNom(utilisateurDetails.getNom());
            utilisateur.setPrenom(utilisateurDetails.getPrenom());
            utilisateur.setEmail(utilisateurDetails.getEmail());

            if (utilisateurDetails.getMotDePasse() != null && !utilisateurDetails.getMotDePasse().isBlank()) {
                utilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDetails.getMotDePasse()));
            }

            Utilisateur updated = service.save(utilisateur);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

