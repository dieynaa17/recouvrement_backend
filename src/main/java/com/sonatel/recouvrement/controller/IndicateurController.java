package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Indicateur;
import com.sonatel.recouvrement.service.IndicateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indicateurs")
@CrossOrigin(origins = "*")
public class IndicateurController {

    private final IndicateurService indicateurService;

    public IndicateurController(IndicateurService indicateurService) {
        this.indicateurService = indicateurService;
    }

    @GetMapping
    public ResponseEntity<List<Indicateur>> getAllIndicateurs() {
        return ResponseEntity.ok(indicateurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Indicateur> getIndicateurById(@PathVariable Long id) {
        return ResponseEntity.ok(indicateurService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Indicateur> createIndicateur(@RequestBody Indicateur indicateur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(indicateurService.save(indicateur));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indicateur> updateIndicateur(@PathVariable Long id, @RequestBody Indicateur indicateurDetails) {
        Indicateur indicateur = indicateurService.findById(id); // lève exception si absent

        indicateur.setValeur(indicateurDetails.getValeur());
        indicateur.setType(indicateurDetails.getType());
        indicateur.setOffre(indicateurDetails.getOffre());
        indicateur.setPeriode(indicateurDetails.getPeriode());

        return ResponseEntity.ok(indicateurService.save(indicateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndicateur(@PathVariable Long id) {
        indicateurService.deleteById(id); // exception si inexistant
        return ResponseEntity.noContent().build();
    }
}

