package com.martin.labjsp03.models;

public class Etudiant {

    private String nas;
    private String nom;
    private String prenom;

    private String telephone;

    private String adresse;

    private String codePostal;

    private String courriel;

    private String genre;


    public Etudiant() {
    }

    public Etudiant(String nas, String nom, String prenom, String telephone, String adresse, String codePostal, String courriel, String genre) {
        this.nas = nas;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.courriel = courriel;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nas='" + nas + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", courriel='" + courriel + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
