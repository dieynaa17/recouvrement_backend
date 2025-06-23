package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.TypeEvenement;
import com.sonatel.recouvrement.service.TypeEvenementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-evenements")
@CrossOrigin(origins = "*")
public class TypeEvenementController {

    private final TypeEvenementService service;

    public TypeEvenementController(TypeEvenementService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeEvenement> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEvenement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TypeEvenement> create(@RequestBody TypeEvenement typeEvenement) {
        return ResponseEntity.ok(service.save(typeEvenement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeEvenement> update(@PathVariable Long id, @RequestBody TypeEvenement typeEvenement) {
        typeEvenement.setId(id);
        return ResponseEntity.ok(service.save(typeEvenement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

