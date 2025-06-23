package com.sonatel.recouvrement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "parametre_general")
public class ParametreGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParametre;

    private double seuilAlerte;

    // Relation ManyToOne vers l'entité PeriodeAnalyse (remplace enum)
    @ManyToOne
    @JoinColumn(name = "periode_analyse_id")
    private PeriodeAnalyse periodeAnalyse;

    // Relation ManyToOne vers Segment (déjà entité)
    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;

    // Relation ManyToOne vers Marche (remplace enum)
    @ManyToOne
    @JoinColumn(name = "marche_id")
    private Marche marche;

    // Relation ManyToOne vers Offre
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;


    // Relation ManyToOne vers UniteMonetaire (remplace enum)
    @ManyToOne
    @JoinColumn(name = "unite_monetaire_id")
    private UniteMonetaire uniteMonetaire;

    // Admin créateur/modificateur
    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Administrateur administrateur;

    public ParametreGeneral() {}

    public ParametreGeneral(double seuilAlerte, PeriodeAnalyse periodeAnalyse, Segment segment,
                            Marche marche, Offre offre, UniteMonetaire uniteMonetaire) {
        this.seuilAlerte = seuilAlerte;
        this.periodeAnalyse = periodeAnalyse;
        this.segment = segment;
        this.marche = marche;
        this.offre = offre;
        this.uniteMonetaire = uniteMonetaire;
    }

    // --- Getters & Setters ---

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

    public PeriodeAnalyse getPeriodeAnalyse() {
        return periodeAnalyse;
    }

    public void setPeriodeAnalyse(PeriodeAnalyse periodeAnalyse) {
        this.periodeAnalyse = periodeAnalyse;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Marche getMarche() {
        return marche;
    }

    public void setMarche(Marche marche) {
        this.marche = marche;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public UniteMonetaire getUniteMonetaire() {
        return uniteMonetaire;
    }

    public void setUniteMonetaire(UniteMonetaire uniteMonetaire) {
        this.uniteMonetaire = uniteMonetaire;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}

