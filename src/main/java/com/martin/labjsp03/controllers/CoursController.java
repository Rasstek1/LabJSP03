package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.Cours;
import com.martin.labjsp03.models.Lab04DataContext;
import com.martin.labjsp03.models.Panier;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Contrôleur pour gérer les opérations liées aux cours.
 */
@Controller
@RequestMapping("/cours")
public class CoursController {


    private final Lab04DataContext dataContext = new Lab04DataContext();  // Instance du contexte de données pour accéder aux informations sur les étudiants, cours, etc.

    /**
     * Récupère ou crée un nouveau Panier stocké dans la session HTTP.
     *
     * @param session La session HTTP en cours.
     * @return Le Panier associé à la session.
     */
    private Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    /**
     * Affiche la liste des cours disponibles.
     *
     * @param session La session HTTP en cours.
     * @return Un ModelAndView contenant les attributs à afficher.
     */
    // Methode liste
    @RequestMapping("/liste")
    public ModelAndView liste(HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");

        Panier panier = getPanier(session);
        mav.addObject("panier", panier);
        mav.addObject("listeCours", dataContext.getListeCours());
        mav.addObject("pageContent", "listeCours");

        return mav;
    }

    /**
     * Ajoute un cours au Panier.
     *
     * @param numero  Le numéro du cours à ajouter.
     * @param session La session HTTP en cours.
     * @return Un ModelAndView pour rediriger vers la liste des cours.
     */
    // Methode ajouter
    @RequestMapping(value = "/ajouter/{numero}", method = RequestMethod.POST)
    public ModelAndView ajouter(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        Cours cours = dataContext.getCours(numero);
        ModelAndView mav = new ModelAndView();

        if (cours != null) {
            panier.ajouterCours(cours);
        }

        mav.setViewName("redirect:/cours/liste");
        return mav;
    }

    /**
     * Supprime un cours du Panier.
     *
     * @param numero  Le numéro du cours à supprimer.
     * @param session La session HTTP en cours.
     * @return Un ModelAndView pour rediriger vers la liste des cours.
     */
    // Methode supprimer
    @RequestMapping(value = "/supprimer/{numero}", method = RequestMethod.POST)
    public ModelAndView supprimer(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        Cours cours = dataContext.getCours(numero);
        ModelAndView mav = new ModelAndView();

        if (cours != null) {
            panier.supprimerCours(cours);
        }

        mav.setViewName("redirect:/cours/liste");
        return mav;
    }
}

