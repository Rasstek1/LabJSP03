package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

//need to replace all imports starting with javax.servlet with javax replaced by jakarta
//Ne pas mettre de import javax.servlet.http.HttpSession; car il y a un conflit avec jakarta.servlet.http.HttpSession
//Choisir Jakarta
//https://stackoverflow.com/questions/75573948/fix-no-primary-or-single-unique-constructor-found-for-interface-javax-servlet-h
@Controller
@RequestMapping("/inscription")
public class InscriptionController {

    private final Lab04DataContext dataContext = new Lab04DataContext();

    // a. La méthode "getPanier"
    public Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }
    @RequestMapping(value = "/ajouter/{numero}", method = RequestMethod.POST)
    public String ajouter(@PathVariable("numero") int numero, HttpSession session) {
        System.out.println("Trying to add course with numero: " + numero);

        Panier panier = getPanier(session);

        System.out.println("Fetched/created cart: " + panier);

        Cours cours = dataContext.getCours(numero);
        if (cours != null) {
            System.out.println("Course found, adding to cart");
            panier.ajouterCours(cours);
        } else {
            System.out.println("Course not found");
        }

        System.out.println("Redirecting back to list");
        return "redirect: listeCours";  // Remplacez par le chemin correct
    }


    // b. La méthode "afficher"
    @RequestMapping("/afficher")
    public String afficher(Model model, HttpSession session) {
        Panier panier = getPanier(session);
        model.addAttribute("panier", panier);
        model.addAttribute("pageContent", "afficherPanier"); // attribut pour le layout
        return "layout"; // Retourne le layout comme vue principale
    }

    // c. La méthode "supprimer"
    @RequestMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        panier.supprimerCours(numero);
        return "redirect:/inscription/afficher";
    }

    // d. La méthode "valider"
    @RequestMapping("/valider")
    public String valider(Model model) {
        List<Etudiant> listeEtudiants = dataContext.getListeEtudiants();
        model.addAttribute("listeEtudiants", listeEtudiants); // Corrigé ici
        model.addAttribute("pageContent", "validerEtudiant"); // attribut pour le layout
        return "layout"; // Retourne le layout comme vue principale
    }


    // e. La méthode "confirmer"
    @RequestMapping("/confirmer/{nas}")
    public String confirmer(@PathVariable("nas") String nas, HttpSession session, Model model) {
        Panier panier = getPanier(session);
        Etudiant etudiant = dataContext.getEtudiant(nas);
        if (etudiant != null && panier != null) {
            Inscription nouvelleInscription = new Inscription(nas, new Date(), panier.getListe().toString());
            dataContext.inscrire(nouvelleInscription);
            model.addAttribute("inscription", nouvelleInscription);
            model.addAttribute("pageContent", "confirmationInscription"); // Corrigé ici
            return "layout"; // Retourne le layout comme vue principale
        }
        return "Erreur"; // Nom d'une vue JSP pour afficher les erreurs
    }

}
