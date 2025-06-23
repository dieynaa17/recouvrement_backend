package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.UniteMonetaire;
import com.sonatel.recouvrement.service.UniteMonetaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unites-monetaire")
@CrossOrigin(origins = "*")
public class UniteMonetaireController {

    private final UniteMonetaireService uniteMonetaireService;

    public UniteMonetaireController(UniteMonetaireService uniteMonetaireService) {
        this.uniteMonetaireService = uniteMonetaireService;
    }

    @GetMapping
    public ResponseEntity<List<UniteMonetaire>> getAllUnites() {
        return ResponseEntity.ok(uniteMonetaireService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniteMonetaire> getUniteById(@PathVariable Long id) {
        UniteMonetaire unite = uniteMonetaireService.findById(id);
        return ResponseEntity.ok(unite);
    }

    @PostMapping
    public ResponseEntity<UniteMonetaire> createUnite(@RequestBody UniteMonetaire unite) {
        UniteMonetaire saved = uniteMonetaireService.save(unite);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniteMonetaire> updateUnite(@PathVariable Long id, @RequestBody UniteMonetaire updatedUnite) {
        updatedUnite.setId(id);
        UniteMonetaire updated = uniteMonetaireService.save(updatedUnite);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnite(@PathVariable Long id) {
        uniteMonetaireService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
