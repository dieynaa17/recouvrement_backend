package com.sonatel.recouvrement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrateur extends Utilisateur {

    @OneToMany(mappedBy = "administrateur")
    @JsonIgnore
    private List<ParametreGeneral> parametres;

    public Administrateur() {}

    public Administrateur(String nom, String email, String motDePasse, String prenom, LocalDate dateCreation) {
        super(nom, email, motDePasse, prenom, dateCreation);
    }

    public List<ParametreGeneral> getParametres() {
        return parametres;
    }

    public void setParametres(List<ParametreGeneral> parametres) {
        this.parametres = parametres;
    }
}

