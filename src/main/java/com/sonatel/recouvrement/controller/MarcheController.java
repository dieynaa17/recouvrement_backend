package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Marche;
import com.sonatel.recouvrement.service.MarcheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marches")
@CrossOrigin(origins = "*")
public class MarcheController {

    private final MarcheService marcheService;

    public MarcheController(MarcheService marcheService) {
        this.marcheService = marcheService;
    }

    @PostMapping
    public ResponseEntity<Marche> create(@RequestBody Marche marche) {
        return ResponseEntity.ok(marcheService.create(marche));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marche> update(@PathVariable Long id, @RequestBody Marche marche) {
        return ResponseEntity.ok(marcheService.update(id, marche));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        marcheService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Marche>> getAll() {
        return ResponseEntity.ok(marcheService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marche> getById(@PathVariable Long id) {
        return ResponseEntity.ok(marcheService.getById(id));
    }
}

