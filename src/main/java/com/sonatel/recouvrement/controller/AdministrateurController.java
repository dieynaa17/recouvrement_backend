package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Administrateur;
import com.sonatel.recouvrement.service.AdministrateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.sonatel.recouvrement.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrateurs")
@PreAuthorize("hasRole('ADMIN')")
public class AdministrateurController {

    private final AdministrateurService service;

    public AdministrateurController(AdministrateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Administrateur> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrateur non trouvé")));
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<Administrateur> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Administrateur non trouvé")));
    }

    @PostMapping
    public ResponseEntity<Administrateur> create(@RequestBody Administrateur administrateur) {
        return ResponseEntity.ok(service.save(administrateur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> update(
            @PathVariable Long id,
            @RequestBody Administrateur administrateur) {

        if (!service.existsById(id)) {
            throw new ResourceNotFoundException("Administrateur non trouvé");
        }
        administrateur.setId(id);
        return ResponseEntity.ok(service.save(administrateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}