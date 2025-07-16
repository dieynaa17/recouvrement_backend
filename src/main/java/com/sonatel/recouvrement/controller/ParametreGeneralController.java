package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.dto.ParametreGeneralDTO;
import com.sonatel.recouvrement.model.Administrateur;
import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.service.AdministrateurService;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.sonatel.recouvrement.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parametres") // URL plus explicite
@PreAuthorize("hasRole('ADMIN')")
public class ParametreGeneralController {

    private final ParametreGeneralService parametreService;
    private final AdministrateurService adminService;

    // Injection des dépendances
    public ParametreGeneralController(
            ParametreGeneralService parametreService,
            AdministrateurService adminService
    ) {
        this.parametreService = parametreService;
        this.adminService = adminService;
    }

    @GetMapping
    public List<ParametreGeneralDTO> getAllParametres() {
        return parametreService.findAll().stream()
                .map(parametreService::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParametreGeneralDTO> getParametreById(@PathVariable Long id) {
        ParametreGeneral parametre = parametreService.findById(id);
        return parametre != null
                ? ResponseEntity.ok(parametreService.convertToDTO(parametre))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ParametreGeneralDTO> createParametre(
            @RequestBody ParametreGeneral parametre,
            @AuthenticationPrincipal UserDetails userDetails) {

        Administrateur admin = adminService.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Administrateur introuvable"));

        parametre.setAdministrateur(admin);
        ParametreGeneral saved = parametreService.save(parametre);
        return ResponseEntity.ok(parametreService.convertToDTO(saved));
    }

    // Méthode update simplifiée
    @PutMapping("/{id}")
    public ResponseEntity<ParametreGeneralDTO> updateParametre(
            @PathVariable Long id,
            @RequestBody ParametreGeneral parametre) {

        if (!parametreService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        parametre.setIdParametre(id);
        ParametreGeneral updated = parametreService.save(parametre);
        return ResponseEntity.ok(parametreService.convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable Long id) {
        if (!parametreService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        parametreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}