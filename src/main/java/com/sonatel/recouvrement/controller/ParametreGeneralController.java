package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parametres")
@CrossOrigin(origins = "*")
public class ParametreGeneralController {

    private final ParametreGeneralService service;

    public ParametreGeneralController(ParametreGeneralService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ParametreGeneral>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParametreGeneral> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ParametreGeneral> create(@RequestBody ParametreGeneral parametre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parametre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParametreGeneral> update(@PathVariable Long id, @RequestBody ParametreGeneral parametre) {
        service.findById(id); // vérifie existence
        parametre.setIdParametre(id);
        return ResponseEntity.ok(service.save(parametre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

