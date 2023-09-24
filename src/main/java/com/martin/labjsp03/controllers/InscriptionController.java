package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.Etudiant;
import com.martin.labjsp03.models.Inscription;
import com.martin.labjsp03.models.Lab04DataContext;
import com.martin.labjsp03.models.Panier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

    private final Lab04DataContext dataContext = new Lab04DataContext();

    // a. La méthode "getPanier"
    private Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    // b. La méthode "afficher"
    @GetMapping("/afficher")
    public String afficher(Model model, HttpSession session) {
        Panier panier = getPanier(session);
        model.addAttribute("panier", panier);
        return "AfficherPanier"; // Nom de la vue JSP
    }

    // c. La méthode "supprimer"
    @GetMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        panier.supprimerCours(numero);
        return "redirect:/inscription/afficher";
    }

    // d. La méthode "valider"
    @GetMapping("/valider")
    public String valider(Model model) {
        List<Etudiant> listeEtudiants = dataContext.getListeEtudiants();
        model.addAttribute("listeEtudiants", listeEtudiants);
        return "ValiderEtudiant"; // Nom de la vue JSP
    }

    // e. La méthode "confirmer"
    @GetMapping("/confirmer/{nas}")
    public String confirmer(@PathVariable("nas") String nas, HttpSession session, Model model) {
        Panier panier = getPanier(session);
        Etudiant etudiant = dataContext.getEtudiant(nas);
        if (etudiant != null && panier != null) {
            Inscription nouvelleInscription = new Inscription(nas, new Date(), panier.getListe().toString());
            dataContext.inscrire(nouvelleInscription);
            model.addAttribute("inscription", nouvelleInscription);
            return "Confirmation"; // Nom de la vue JSP
        }
        return "Erreur"; // Nom d'une vue JSP pour afficher les erreurs
    }
}
