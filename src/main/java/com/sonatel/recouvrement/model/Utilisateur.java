package com.sonatel.recouvrement.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.time.LocalDate;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "role"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Administrateur.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = UtilisateurMetier.class, name = "UTILISATEUR_METIER")
})
@Entity
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nom;
    protected String prenom;
    protected String email;

    @Column(name = "mot_de_passe")
    protected String motDePasse;

    protected LocalDate dateCreation;

    @Column(name = "role", insertable = false, updatable = false)
    protected String role;

    public Utilisateur() {}

    public Utilisateur(String nom, String email, String motDePasse, String prenom, LocalDate dateCreation) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.prenom = prenom;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getRole() {
        return role;
    }
}


