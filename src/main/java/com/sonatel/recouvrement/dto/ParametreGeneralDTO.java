package com.sonatel.recouvrement.dto;

public class ParametreGeneralDTO {
    private Long idParametre;
    private double seuilAlerte;

    private String marche;
    private String segment;
    private String offre;
    private String periodeAnalyse;
    private String uniteMonetaire;

    public ParametreGeneralDTO() {}

    public ParametreGeneralDTO(Long idParametre, double seuilAlerte, String marche, String segment, String offre, String periodeAnalyse, String uniteMonetaire) {
        this.idParametre = idParametre;
        this.seuilAlerte = seuilAlerte;
        this.marche = marche;
        this.segment = segment;
        this.offre = offre;
        this.periodeAnalyse = periodeAnalyse;
        this.uniteMonetaire = uniteMonetaire;
    }

    // Getters & Setters

    public Long getIdParametre() { return idParametre; }
    public void setIdParametre(Long idParametre) { this.idParametre = idParametre; }

    public double getSeuilAlerte() { return seuilAlerte; }
    public void setSeuilAlerte(double seuilAlerte) { this.seuilAlerte = seuilAlerte; }

    public String getMarche() { return marche; }
    public void setMarche(String marche) { this.marche = marche; }

    public String getSegment() { return segment; }
    public void setSegment(String segment) { this.segment = segment; }

    public String getOffre() { return offre; }
    public void setOffre(String offre) { this.offre = offre; }

    public String getPeriodeAnalyse() { return periodeAnalyse; }
    public void setPeriodeAnalyse(String periodeAnalyse) { this.periodeAnalyse = periodeAnalyse; }

    public String getUniteMonetaire() { return uniteMonetaire; }
    public void setUniteMonetaire(String uniteMonetaire) { this.uniteMonetaire = uniteMonetaire; }
}

