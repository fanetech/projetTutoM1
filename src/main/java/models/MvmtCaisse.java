package models;

public class MvmtCaisse {
    private Integer moment;
    private String commentaire;
    private String libelle;
    private Integer beneficiaire;
    private  String type;
    private  String receveur;

    public MvmtCaisse() {
    }

    public MvmtCaisse(Integer moment, String commentaire, String libelle, Integer beneficiaire, String type, String receveur) {
        this.moment = moment;
        this.commentaire = commentaire;
        this.libelle = libelle;
        this.beneficiaire = beneficiaire;
        this.type = type;
        this.receveur = receveur;
    }

    public Integer getMoment() {
        return moment;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public Integer getBeneficiaire() {
        return beneficiaire;
    }

    public String getType() {
        return type;
    }

    public String getReceveur() {
        return receveur;
    }

    public void setMoment(Integer moment) {
        this.moment = moment;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setBeneficiaire(Integer beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReceveur(String receveur) {
        this.receveur = receveur;
    }
}