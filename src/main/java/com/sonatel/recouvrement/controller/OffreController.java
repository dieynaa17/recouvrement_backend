package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Offre;
import com.sonatel.recouvrement.service.OffreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offres")
@CrossOrigin(origins = "*")
public class OffreController {

    private final OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @GetMapping
    public ResponseEntity<List<Offre>> getAllOffres() {
        return ResponseEntity.ok(offreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable Long id) {
        return ResponseEntity.ok(offreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Offre> createOffre(@RequestBody Offre offre) {
        return ResponseEntity.status(201).body(offreService.save(offre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offre> updateOffre(@PathVariable Long id, @RequestBody Offre offre) {
        offre.setId(id);
        return ResponseEntity.ok(offreService.save(offre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        offreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
