package com.sonatel.recouvrement.dto;

import java.time.LocalDate;

public class AuthResponse {
    private String token;
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String role;
    private LocalDate dateCreation; // ✅ Ajouté

    // ✅ Constructeur complet
    public AuthResponse(String token, Long id, String email, String nom, String prenom, String role, LocalDate dateCreation) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.dateCreation = dateCreation;
    }

    // ✅ Getters
    public String getToken() { return token; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getRole() { return role; }
    public LocalDate getDateCreation() { return dateCreation; }
}

