package com.sonatel.recouvrement.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import com.sonatel.recouvrement.model.enums.TypeEvenement;
import com.sonatel.recouvrement.model.enums.StatutEvenement;

@Entity
@Table(name="EvenementRecouvrement")
public class EvenementRecouvrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    @Enumerated(EnumType.STRING)
    private TypeEvenement type;

    private LocalDate dateEvenement;

    @Enumerated(EnumType.STRING)
    private StatutEvenement statut;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    public EvenementRecouvrement() {}

    public EvenementRecouvrement(TypeEvenement type, LocalDate dateEvenement, StatutEvenement statut, String commentaire) {
        this.type = type;
        this.dateEvenement = dateEvenement;
        this.statut = statut;
        this.commentaire = commentaire;
    }

    public Long getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Long idEvenement) {
        this.idEvenement = idEvenement;
    }

    public TypeEvenement getType() {
        return type;
    }

    public void setType(TypeEvenement type) {
        this.type = type;
    }

    public LocalDate getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDate dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public StatutEvenement getStatut() {
        return statut;
    }

    public void setStatut(StatutEvenement statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
