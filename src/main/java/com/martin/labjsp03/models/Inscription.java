package com.martin.labjsp03.models;
import java.util.Date;
import java.util.List;

public class Inscription {
    private String nas;

    private Date dateInscription;

    private List<Cours> listeCours;



    public Inscription() {
    }

    public Inscription(String nas, Date dateInscription, List<Cours> listeCours) {
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

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public void setListeCours(List<Cours> listeCours) {
        this.listeCours = listeCours;
    }


}
