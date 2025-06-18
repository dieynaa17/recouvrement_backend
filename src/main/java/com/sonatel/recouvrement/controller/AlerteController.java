package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Alerte;
import com.sonatel.recouvrement.service.AlerteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertes")
@CrossOrigin(origins = "*")
public class AlerteController {

    private final AlerteService alerteService;

    // Injection via constructeur (recommandé)
    public AlerteController(AlerteService alerteService) {
        this.alerteService = alerteService;
    }

    @GetMapping
    public ResponseEntity<List<Alerte>> getAllAlertes() {
        List<Alerte> alertes = alerteService.findAll();
        return ResponseEntity.ok(alertes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerteById(@PathVariable Long id) {
        Alerte alerte = alerteService.findById(id); // ici findById lance ResourceNotFoundException si pas trouvé
        return ResponseEntity.ok(alerte);
    }

    @PostMapping
    public ResponseEntity<Alerte> createAlerte(@RequestBody Alerte alerte) {
        Alerte saved = alerteService.save(alerte);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerte> updateAlerte(@PathVariable Long id, @RequestBody Alerte alerte) {
        // On vérifie que l’alerte existe, sinon exception sera lancée
        alerteService.findById(id);

        alerte.setIdAlerte(id);
        Alerte updated = alerteService.save(alerte);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerte(@PathVariable Long id) {
        // On vérifie que l’alerte existe
        alerteService.findById(id);

        alerteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

