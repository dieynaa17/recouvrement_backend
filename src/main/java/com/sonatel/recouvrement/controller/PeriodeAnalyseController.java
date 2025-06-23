package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.PeriodeAnalyse;
import com.sonatel.recouvrement.service.PeriodeAnalyseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodes")
@CrossOrigin(origins = "*")
public class PeriodeAnalyseController {

    private final PeriodeAnalyseService service;

    public PeriodeAnalyseController(PeriodeAnalyseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PeriodeAnalyse> create(@RequestBody PeriodeAnalyse periode) {
        return ResponseEntity.ok(service.create(periode));
    }

    @GetMapping
    public ResponseEntity<List<PeriodeAnalyse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodeAnalyse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodeAnalyse> update(@PathVariable Long id, @RequestBody PeriodeAnalyse updated) {
        return ResponseEntity.ok(service.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
