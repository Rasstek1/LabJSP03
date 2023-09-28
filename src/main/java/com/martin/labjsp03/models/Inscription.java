package com.martin.labjsp03.models;
import jakarta.websocket.Session;

import java.util.Date;
import java.util.List;

public class Inscription {
    private String nas;

    private Date dateInscription;

    private List<Cours> listeCours;

    private Etudiant etudiant;//Rajoute dans cette classe pour utiliser la methode inscription du controlleur Inscrption et la vue inscription.jsp

    public Inscription() {
    }

    public Inscription(String nas, Date dateInscription, List<Cours> listeCours, Etudiant etudiant) {
        this.nas = nas;
        this.dateInscription = dateInscription;
        this.listeCours = listeCours;
        this.etudiant = etudiant;
    }



    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

}
