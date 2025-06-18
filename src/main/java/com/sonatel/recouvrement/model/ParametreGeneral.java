package com.sonatel.recouvrement.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ParametreGeneral")
public class ParametreGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParametre;

    private double seuilAlerte;
    private String periodeAnalyse;
    private String segment;
    private String marche;
    private String uniteMonetaire;
    private String offre;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Administrateur administrateur;

    public ParametreGeneral() {}

    public ParametreGeneral(double seuilAlerte, String periodeAnalyse, String segment, String marche, String offre, String uniteMonetaire) {
        this.seuilAlerte = seuilAlerte;
        this.periodeAnalyse = periodeAnalyse;
        this.segment = segment;
        this.marche = marche;
        this.offre= offre;
        this.uniteMonetaire = uniteMonetaire;
    }

    public Long getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(Long idParametre) {
        this.idParametre = idParametre;
    }

    public double getSeuilAlerte() {
        return seuilAlerte;
    }

    public void setSeuilAlerte(double seuilAlerte) {
        this.seuilAlerte = seuilAlerte;
    }

    public String getPeriodeAnalyse() {
        return periodeAnalyse;
    }

    public void setPeriodeAnalyse(String periodeAnalyse) {
        this.periodeAnalyse = periodeAnalyse;
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

    public String getUniteMonetaire() {
        return uniteMonetaire;
    }

    public void setUniteMonetaire(String uniteMonetaire) {
        this.uniteMonetaire = uniteMonetaire;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}

