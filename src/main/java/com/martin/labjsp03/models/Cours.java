package com.martin.labjsp03.models;

import java.util.Objects;

public class Cours {

    private int numero;
    private String intitule;
    private int nbCredits;

    private String session;
    private String planFichier;


    public Cours() {
    }

    public Cours(int numero, String intitule, int nbCredits, String session, String planFichier) {
        this.numero = numero;
        this.intitule = intitule;
        this.nbCredits = nbCredits;
        this.session = session;
        this.planFichier = planFichier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return numero == cours.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNbCredits() {
        return nbCredits;
    }

    public void setNbCredits(int nbCredits) {
        this.nbCredits = nbCredits;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPlanFichier() {
        return planFichier;
    }

    public void setPlanFichier(String planFichier) {
        this.planFichier = planFichier;
    }


}
