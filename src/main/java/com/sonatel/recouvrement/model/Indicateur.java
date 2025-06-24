package com.sonatel.recouvrement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Indicateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndicateur;

    private String type;       // tauxRecouvrement, chiffreAffaires, etc.
    private double valeur;     // Résultat calculé (ex. : 86.5)
    private String periode;    // Exemple : "Avril 2025"
    private String segment;    // Exemple : "Entreprise", "Particulier"
    private String marche;     // Exemple : "Mobile", "Fixe"
    private String offre;      // Exemple : "Forfait Pro", "Internet Fibre"

    public Indicateur() {}

    public Indicateur(String type, double valeur, String periode, String segment, String marche, String offre) {
        this.type = type;
        this.valeur = valeur;
        this.periode = periode;
        this.segment = segment;
        this.marche = marche;
        this.offre = offre;
    }

    public Long getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(Long idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getMarche() {
        return marche;
    }

    public void setMarche(String marche) {
        this.marche = marche;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }
}

