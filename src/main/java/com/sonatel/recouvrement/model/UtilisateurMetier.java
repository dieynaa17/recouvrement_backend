package com.sonatel.recouvrement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("UTILISATEUR_METIER")
public class UtilisateurMetier extends Utilisateur {

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Alerte> alertes;

    public UtilisateurMetier() {}

    public UtilisateurMetier(String nom, String email, String motDePasse, String prenom, LocalDate dateCreation) {
        super(nom, email, motDePasse, prenom, dateCreation);
    }

    public List<Alerte> getAlertes() {
        return alertes;
    }

    public void setAlertes(List<Alerte> alertes) {
        this.alertes = alertes;
    }
}
