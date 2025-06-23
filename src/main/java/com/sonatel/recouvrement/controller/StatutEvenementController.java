package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.StatutEvenement;
import com.sonatel.recouvrement.service.StatutEvenementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuts-evenement")
@CrossOrigin("*")
public class StatutEvenementController {

    private final StatutEvenementService service;

    public StatutEvenementController(StatutEvenementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StatutEvenement> create(@RequestBody StatutEvenement statut) {
        return ResponseEntity.ok(service.save(statut));
    }

    @GetMapping
    public ResponseEntity<List<StatutEvenement>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatutEvenement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatutEvenement> update(@PathVariable Long id, @RequestBody StatutEvenement statut) {
        statut.setId(id);
        return ResponseEntity.ok(service.save(statut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

