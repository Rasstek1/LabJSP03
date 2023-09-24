package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.Cours;
import com.martin.labjsp03.models.Lab04DataContext;
import com.martin.labjsp03.models.Panier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cours")
public class CoursController {

    // a. Une propriété nommée "dataContext" de type "Lab04DataContext"
    private final Lab04DataContext dataContext = new Lab04DataContext();

    // b. La méthode privée "getPanier"
    private Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    // c. La méthode "liste"
    @RequestMapping("/liste")
    public String liste(Model model) {
        model.addAttribute("listeCours", dataContext.getListeCours());
        model.addAttribute("pageContent", "listeCours"); // attribut pour le layout
        return "layout"; // Retourne le layout comme vue principale
    }

    // d. La méthode "ajouter"
    @RequestMapping("/ajouter/{numero}")
    public String ajouter(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        Cours cours = dataContext.getCours(numero);
        if (cours != null) {
            panier.ajouterCours(cours);
        }
        return "redirect:/cours/liste";
    }
}
