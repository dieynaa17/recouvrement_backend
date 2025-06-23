package com.sonatel.recouvrement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EvenementRecouvrement")
public class EvenementRecouvrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    private LocalDate dateEvenement;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "type_evenement_id")
    private TypeEvenement typeEvenement;

    @ManyToOne
    @JoinColumn(name = "statut_evenement_id")
    private StatutEvenement statutEvenement;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public EvenementRecouvrement() {
    }

    public EvenementRecouvrement(TypeEvenement typeEvenement, LocalDate dateEvenement, StatutEvenement statutEvenement, String commentaire) {
        this.typeEvenement = typeEvenement;
        this.dateEvenement = dateEvenement;
        this.statutEvenement = statutEvenement;
        this.commentaire = commentaire;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public LocalDate getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDate dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public TypeEvenement getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public StatutEvenement getStatutEvenement() {
        return statutEvenement;
    }

    public void setStatutEvenement(StatutEvenement statutEvenement) {
        this.statutEvenement = statutEvenement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

