package com.sonatel.recouvrement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Alerte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerte;

    private String type;
    private String message;
    private LocalDateTime dateDetection;
    private boolean estConsultee;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonIgnore
    private UtilisateurMetier utilisateur;

    public Alerte() {}

    public Alerte(String type, String message, LocalDateTime dateDetection, boolean estConsultee) {
        this.type = type;
        this.message = message;
        this.dateDetection = dateDetection;
        this.estConsultee = estConsultee;
    }

    public Long getIdAlerte() {
        return idAlerte;
    }

    public void setIdAlerte(Long idAlerte) {
        this.idAlerte = idAlerte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateDetection() {
        return dateDetection;
    }

    public void setDateDetection(LocalDateTime dateDetection) {
        this.dateDetection = dateDetection;
    }

    public boolean isEstConsultee() {
        return estConsultee;
    }

    public void setEstConsultee(boolean estConsultee) {
        this.estConsultee = estConsultee;
    }

    public UtilisateurMetier getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurMetier utilisateur) {
        this.utilisateur = utilisateur;
    }
}

