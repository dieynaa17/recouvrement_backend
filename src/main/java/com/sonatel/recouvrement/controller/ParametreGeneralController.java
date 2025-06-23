package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.dto.ParametreGeneralDTO;
import com.sonatel.recouvrement.model.ParametreGeneral;
import com.sonatel.recouvrement.service.ParametreGeneralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parametres")
public class ParametreGeneralController {

    private final ParametreGeneralService service;

    public ParametreGeneralController(ParametreGeneralService service) {
        this.service = service;
    }

    @GetMapping
    public List<ParametreGeneralDTO> getAll() {
        return service.findAll().stream()
                .map(service::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParametreGeneralDTO> getById(@PathVariable Long id) {
        ParametreGeneral parametre = service.findById(id);
        if (parametre == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.convertToDTO(parametre));
    }

    // Pour simplifier : on reçoit l'entité complète, à adapter si tu veux DTO en entrée
    @PostMapping
    public ResponseEntity<ParametreGeneralDTO> create(@RequestBody ParametreGeneral parametre) {
        ParametreGeneral saved = service.save(parametre);
        return ResponseEntity.ok(service.convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParametreGeneralDTO> update(@PathVariable Long id, @RequestBody ParametreGeneral parametre) {
        ParametreGeneral existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        parametre.setIdParametre(id);
        ParametreGeneral updated = service.save(parametre);
        return ResponseEntity.ok(service.convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ParametreGeneral existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
