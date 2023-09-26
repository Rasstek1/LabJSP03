package com.martin.labjsp03.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier {

    // a) Une propriété privée nommée "liste" de type List<Cours>
    private List<Cours> liste;

    public Panier() {
        this.liste = new ArrayList<>();
    }

    // b) Une méthode d'accès pour la propriété "liste"
    public List<Cours> getListe() {
        return liste;
    }

    // c) La méthode nommée "ajouterCours"
    public void ajouterCours(Cours cours) {
        if (!contains(cours)) {
            liste.add(cours);
        }
    }
    public boolean contains(Cours cours) {
        return liste.contains(cours);
    }



    // d) La méthode nommée "supprimerCours"
    public void supprimerCours(int numero) {
        Iterator<Cours> iterator = liste.iterator();
        while (iterator.hasNext()) {
            Cours cours = iterator.next();
            if (cours.getNumero() == numero) {  // Ici, on utilise '==' parce que le numéro est de type int
                iterator.remove();
                break;
            }
        }
    }

    // e) La méthode nommée "viderPanier"
    public void viderPanier() {
        liste.clear();
    }
}
