package com.martin.labjsp03.models;

import java.util.ArrayList;
import java.util.List;

public class Lab04DataContext {

    private List<Cours> listeCours;
    private List<Etudiant> listeEtudiants;
    private List<Inscription> listeInscriptions;

    public Lab04DataContext() {
        listeCours = new ArrayList<>();
        listeEtudiants = new ArrayList<>();
        listeInscriptions = new ArrayList<>();

        // Initialisation de la liste des cours avec des données fictives
        listeCours.add(new Cours(101, "Programmation Java", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(102, "Web Développement", 3, "Printemps", "NumCours.docx"));
        listeCours.add(new Cours(103, "Réseaux Informatiques", 2, "Eté", "NumCours.docx"));
        listeCours.add(new Cours(104, "Systèmes d'exploitation", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(105, "Bases de données", 3, "Printemps", "NumCours.docx"));
        listeCours.add(new Cours(106, "Programmation Web", 3, "Eté", "NumCours.docx"));
        listeCours.add(new Cours(107, "Programmation C#", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(108, "Programmation C++", 3, "Printemps", "NumCours.docx"));

        // Initialisation de la liste des étudiants avec des données fictives
        listeEtudiants.add(new Etudiant("123-45-6789", "Dupont", "Jean", "0123456789", "123 Rue A", "A1B2C3", "jean@email.com", "M"));
        listeEtudiants.add(new Etudiant("987-65-4321", "Martin", "Sophie", "9876543210", "321 Rue B", "B2C3D4", "sophie@email.com", "F"));
    }

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }
    public Etudiant getEtudiant(String nas) {
        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant.getNas().equals(nas)) {
                return etudiant;
            }
        }
        return null;
    }

    public List<Inscription> getListeInscriptions() {
        return listeInscriptions;
    }

    public void inscrire(Inscription inscription) {
        listeInscriptions.add(inscription);
    }

    public Cours getCours(int numero) {
        for (Cours cours : listeCours) {
            if (cours.getNumero() == numero) {
                return cours;
            }
        }
        return null;
    }
}
