
package com.martin.labjsp03.models;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Panier {

    // Liste de cours dans le panier
    private List<Cours> liste;

    // Constructeur du Panier
    public Panier() {
        // Initialisation de la liste a un ArrayList vide
        this.liste = new ArrayList<>();
    }

    // Obtenir la liste des cours dans le panier
    public List<Cours> getListe() {
        return liste;
    }

    // Ajouter un cours au panier
    public void ajouterCours(Cours cours) {
        // Verifie si le cours est deja dans le panier
        if (!contains(cours)) {
            // Ajoute le cours à la liste
            liste.add(cours);
        }
    }

    // Verifie si le panier contient deja ce cours
    public boolean contains(Cours cours) {
        return liste.contains(cours);
    }

    // Supprimer un cours du panier avec son numero
    public void supprimerCours(int numero) {
        // Utilisation d'un iterateur pour parcourir la liste-> Un iterateur permet de supprimer un element d'une liste pendant qu'on la parcourt
        Iterator<Cours> iterator = liste.iterator();
        // Parcours de la liste de cours
        while (iterator.hasNext()) {
            Cours cours = iterator.next();
            // Si le numero du cours correspond au numero du cours a supprimer
            if (cours.getNumero() == numero) {
                // Suppression du cours
                iterator.remove();
                break;
            }
        }
    }

    // Pour Vide le panier
    public void viderPanier() {
        liste.clear();
    }

    // Supprime un cours specifique du panier
    public void supprimerCours(Cours cours) {
        liste.remove(cours);
    }
}
