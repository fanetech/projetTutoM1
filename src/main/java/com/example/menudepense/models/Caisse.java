package com.example.menudepense.models;

import java.util.Date;

public class Caisse {
    private int id;
    private Integer moment;
    private String libelle;
    private Date createdAt;

    public Caisse() {
    }

    public Caisse(int id, Integer moment, String libelle, Date createdAt) {
        this.id = id;
        this.moment = moment;
        this.libelle = libelle;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public Integer getMoment() {
        return moment;
    }

    public String getLibelle() {
        return libelle;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoment(Integer moment) {
        this.moment = moment;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
