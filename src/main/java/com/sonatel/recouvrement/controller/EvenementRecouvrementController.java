package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.EvenementRecouvrement;
import com.sonatel.recouvrement.service.EvenementRecouvrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenements")
@CrossOrigin(origins = "*")
public class EvenementRecouvrementController {

    @Autowired
    private EvenementRecouvrementService service;

    @GetMapping
    public ResponseEntity<List<EvenementRecouvrement>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvenementRecouvrement> getById(@PathVariable Long id) {
        EvenementRecouvrement evenement = service.findById(id);
        return ResponseEntity.ok(evenement);
    }

    @PostMapping
    public ResponseEntity<EvenementRecouvrement> create(@RequestBody EvenementRecouvrement evenement) {
        EvenementRecouvrement saved = service.save(evenement);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvenementRecouvrement> update(@PathVariable Long id, @RequestBody EvenementRecouvrement evenement) {
        EvenementRecouvrement updated = service.update(id, evenement);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

