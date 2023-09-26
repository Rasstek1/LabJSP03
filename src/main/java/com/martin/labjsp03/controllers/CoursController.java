package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.Cours;
import com.martin.labjsp03.models.Lab04DataContext;
import com.martin.labjsp03.models.Panier;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

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
    public String liste(Model model, HttpSession session) {
        Panier panier = getPanier(session);
        model.addAttribute("panier", panier);
        model.addAttribute("listeCours", dataContext.getListeCours());
        model.addAttribute("pageContent", "listeCours"); // attribut pour le layout
        return "layout"; // Retourne le layout comme vue principale
    }


    // d. La méthode "ajouter"
    @RequestMapping(value = "/ajouter/{numero}", method = RequestMethod.POST)
    public String ajouter(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        Cours cours = dataContext.getCours(numero);
        if (cours != null) {
            panier.ajouterCours(cours);
        }
        return "redirect:/cours/liste";   // Assurez-vous que ce chemin redirige vers la page actuelle
    }



}
