package com.example.menudepense.models;

import java.util.Date;

public class MvmtCaisse {
    private int id;
    private Integer montant;
    private String commentaire;
    private String libelle;
    private String beneficiaire;
    private  String type;
    private  String receveur;
    private Date createdAt;

    public MvmtCaisse() {
    }

    public MvmtCaisse(int id, Integer moment, String commentaire, String libelle, String beneficiaire, String type, String receveur, Date createdAt) {
        this.id = id;
        this.montant = moment;
        this.commentaire = commentaire;
        this.libelle = libelle;
        this.beneficiaire = beneficiaire;
        this.type = type;
        this.receveur = receveur;
        this.createdAt = createdAt;
    }


    public int getId() {
        return id;
    }
    public Integer getMontant() {
        return montant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public String getType() {
        return type;
    }

    public String getReceveur() {
        return receveur;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReceveur(String receveur) {
        this.receveur = receveur;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}