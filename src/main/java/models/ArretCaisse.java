package models;

public class ArretCaisse {
    private int id;
    private Integer moment;
    private String commentaire;

    public ArretCaisse() {
    }

    public ArretCaisse(int id, Integer moment, String commentaire) {
        this.id = id;
        this.moment = moment;
        this.commentaire = commentaire;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setMoment(Integer moment) {
        this.moment = moment;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
