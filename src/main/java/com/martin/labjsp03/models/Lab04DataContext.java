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

        // Initialisation de la liste des cours
        listeCours.add(new Cours(101, "Programmation Java", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(102, "Web Développement", 3, "Printemps", "NumCours.docx"));
        listeCours.add(new Cours(103, "Réseaux Informatiques", 2, "Eté", "NumCours.docx"));
        listeCours.add(new Cours(104, "Systèmes d'exploitation", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(105, "Bases de données", 3, "Printemps", "NumCours.docx"));
        listeCours.add(new Cours(106, "Programmation Web", 3, "Eté", "NumCours.docx"));
        listeCours.add(new Cours(107, "Programmation C#", 3, "Automne", "NumCours.docx"));
        listeCours.add(new Cours(108, "Programmation C++", 3, "Printemps", "NumCours.docx"));

        // Initialisation de la liste des étudiants
        listeEtudiants.add(new Etudiant("123-45-6789", "Dupont", "Jean", "0123456789", "123 Rue A", "A1B2C3", "jean@email.com", "M"));
        listeEtudiants.add(new Etudiant("987-65-4321", "Martin", "Sophie", "9876543210", "321 Rue B", "B2C3D4", "sophie@email.com", "F"));
        listeEtudiants.add(new Etudiant("111-22-3333", "Tremblay", "Pierre", "1112223333", "333 Rue C", "C3D4E5", "pierre@email.com", "M"));
        listeEtudiants.add(new Etudiant("444-55-6666", "Leroy", "Julie", "4445556666", "456 Rue D", "D4E5F6", "julie@email.com", "F"));
        listeEtudiants.add(new Etudiant("777-88-9999", "Smith", "John", "7778889999", "789 Rue E", "E5F6G7", "john@email.com", "M"));
        listeEtudiants.add(new Etudiant("222-33-4444", "Brown", "Alice", "2223334444", "246 Rue F", "F6G7H8", "alice@email.com", "F"));
        listeEtudiants.add(new Etudiant("555-66-7777", "Wang", "Li", "5556667777", "369 Rue G", "G7H8I9", "li@email.com", "M"));
        listeEtudiants.add(new Etudiant("888-99-0000", "Garcia", "Maria", "888990000", "481 Rue H", "H8I9J0", "maria@email.com", "F"));
    }



    // Retourne la liste des cours
    public List<Cours> getListeCours() {
        return listeCours;
    }

    // Retourne la liste des etudiants
    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    // Trouver et retourner un etudiant par son NAS
    public Etudiant getEtudiant(String nas) {
        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant.getNas().equals(nas)) {
                return etudiant;
            }
        }
        return null;
    }

    // Retourne la liste des inscription
    public List<Inscription> getListeInscriptions() {//Methode pas encore utilisee
        return listeInscriptions;
    }

    // Ajouter une nouvelle inscription a la liste
    public void inscrire(Inscription inscription) {
        listeInscriptions.add(inscription);
    }

    // Trouver et retourner un cours par son numero
    public Cours getCours(int numero) {
        // Debugage affiche le numero du cours cherche
        System.out.println("Methode getCours appelee avec le numero : " + numero);

        Cours foundCours = null;
        // Parcours de la liste de cours
        for (Cours cours : listeCours) {
            if (cours.getNumero() == numero) {
                foundCours = cours;
                break;
            }
        }

        // Debogage affiche les informations du cours trouve ou non
        if (foundCours != null) {
            System.out.println("Cours trouve : " + foundCours.toString());
        } else {
            System.out.println("Cours avec numero " + numero + " non trouve");
        }

        return foundCours;
    }
}