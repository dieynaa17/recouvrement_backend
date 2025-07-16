package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.dto.UtilisateurDTO;
import com.sonatel.recouvrement.model.Administrateur;
import com.sonatel.recouvrement.model.UtilisateurMetier;
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
@PreAuthorize("hasAnyRole('ADMIN', 'UTILISATEUR_METIER')")
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
    public Utilisateur create(@RequestBody UtilisateurDTO dto) {
        Utilisateur utilisateur;
        if ("ADMIN".equals(dto.getRole())) {
            utilisateur = new Administrateur(dto.getNom(), dto.getEmail(), passwordEncoder.encode(dto.getMotDePasse()), dto.getPrenom(), java.time.LocalDate.now());
        } else {
            utilisateur = new UtilisateurMetier(dto.getNom(), dto.getEmail(), passwordEncoder.encode(dto.getMotDePasse()), dto.getPrenom(), java.time.LocalDate.now());
        }
        return service.save(utilisateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> update(@PathVariable Long id, @RequestBody UtilisateurDTO dto) {
        System.out.println("===> UPDATE DTO reçu : nom=" + dto.getNom()
                + ", prenom=" + dto.getPrenom()
                + ", email=" + dto.getEmail()
                + ", mdp=" + dto.getMotDePasse()
                + ", role=" + dto.getRole()
                + ", id=" + dto.getId()
                + ", dateCreation=" + dto.getDateCreation());
        try {
            Utilisateur utilisateur = service.findById(id);

            if ("ADMIN".equals(dto.getRole()) && !(utilisateur instanceof Administrateur)) {
                service.deleteById(id);
                utilisateur = new Administrateur(dto.getNom(), dto.getEmail(), utilisateur.getMotDePasse(), dto.getPrenom(), utilisateur.getDateCreation());
            } else if ("UTILISATEUR_METIER".equals(dto.getRole()) && !(utilisateur instanceof UtilisateurMetier)) {
                service.deleteById(id);
                utilisateur = new UtilisateurMetier(dto.getNom(), dto.getEmail(), utilisateur.getMotDePasse(), dto.getPrenom(), utilisateur.getDateCreation());
            } else {
                utilisateur.setNom(dto.getNom());
                utilisateur.setPrenom(dto.getPrenom());
                utilisateur.setEmail(dto.getEmail());
                if (dto.getMotDePasse() != null && !dto.getMotDePasse().isBlank()) {
                    utilisateur.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
                }
                return ResponseEntity.ok(service.save(utilisateur));
            }

            // si on a fait un delete + nouvel objet, on sauvegarde
            Utilisateur created = service.save(utilisateur);
            return ResponseEntity.ok(created);

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
