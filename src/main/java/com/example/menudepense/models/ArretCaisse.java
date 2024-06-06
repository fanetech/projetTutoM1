package com.example.menudepense.models;

import java.util.Date;

public class ArretCaisse {
    private int id;
    private Integer moment;
    private String commentaire;
    private Date createdAt;
    private int userId;
    private int decompteArretId;

    public ArretCaisse() {
    }

    public ArretCaisse(int id, Integer moment, String commentaire, Date createdAt, int userId, int decompteArretId) {
        this.id = id;
        this.moment = moment;
        this.commentaire = commentaire;
        this.createdAt = createdAt;
        this.userId = userId;
        this.decompteArretId = decompteArretId;
    }

    public int getId() {
        return id;
    }

    public Integer getMoment() {
        return moment;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public int getDecompteArretId() {
        return decompteArretId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoment(Integer moment) {
        this.moment = moment;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDecompteArretId(int decompteArretId) {
        this.decompteArretId = decompteArretId;
    }
}
