package com.martin.labjsp03.models;
import java.util.Date;

public class Inscription {
    private String nas;

    private Date dateInscription;

    private String listeCours;


    public Inscription() {
    }

    public Inscription(String nas, Date dateInscription, String listeCours) {
        this.nas = nas;
        this.dateInscription = dateInscription;
        this.listeCours = listeCours;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "nas='" + nas + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", listeCours='" + listeCours + '\'' +
                '}';
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

    public String getListeCours() {
        return listeCours;
    }

    public void setListeCours(String listeCours) {
        this.listeCours = listeCours;
    }


}
