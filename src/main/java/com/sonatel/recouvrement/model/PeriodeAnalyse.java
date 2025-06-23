package com.sonatel.recouvrement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "periode_analyse")
public class PeriodeAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String libelle;

    // --- Constructeurs ---
    public PeriodeAnalyse() {
    }

    public PeriodeAnalyse(String libelle) {
        this.libelle = libelle;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
