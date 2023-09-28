package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux inscriptions.
 */
@Controller
@RequestMapping("/inscription")

public class InscriptionController {

    private final Lab04DataContext dataContext = new Lab04DataContext();//Initialisation de la variable membre dataContext

    /**
     * Récupère l'objet Panier à partir de la session.
     * Crée un nouveau Panier si aucun n'est trouvé.
     *
     * @param session La session HTTP actuelle.
     * @return Le Panier à utiliser.
     */
    public Panier getPanier(HttpSession session) {
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    /**
     * Ajoute un cours au panier.
     *
     * @param numero  Le numéro du cours à ajouter.
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    @RequestMapping(value = "/ajouter/{numero}", method = RequestMethod.POST)
    public ModelAndView ajouter(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        Cours cours = dataContext.getCours(numero);
        ModelAndView mav = new ModelAndView();

        if (cours != null) {
            panier.ajouterCours(cours);
        }

        mav.setViewName("redirect:listeCours");
        return mav;
    }


    /**
     * Affiche le contenu du panier.
     *
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode afficher
    @RequestMapping("/afficher")
    public ModelAndView afficher(HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");
        Panier panier = getPanier(session);
        mav.addObject("panier", panier);
        mav.addObject("pageContent", "afficherPanier");
        return mav;
    }

    /**
     * Supprime un cours du panier.
     *
     * @param numero  Le numéro du cours à supprimer.
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode supprimer
    @RequestMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable("numero") int numero, HttpSession session) {
        Panier panier = getPanier(session);
        panier.supprimerCours(numero);
        return "redirect:/inscription/afficher";
    }

    /**
     * Valide l'etudiant.
     *
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode valider
    @RequestMapping("/valider")
    public ModelAndView valider(HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");
        Panier panier = getPanier(session);

        if (panier.getListe().isEmpty()) {
            mav.addObject("errorMessage", "Vous devez choisir au moins un cours avant de valider.");
            mav.addObject("pageContent", "validerEtudiant"); // attribut pour le layout
            return mav; // Retourne le même ModelAndView
        }

        List<Etudiant> listeEtudiants = dataContext.getListeEtudiants();
        mav.addObject("listeEtudiants", listeEtudiants);
        mav.addObject("pageContent", "validerEtudiant");
        return mav;
    }


    /**
     * Affiche le formulaire d'inscription.
     *
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode confirmer
    @RequestMapping("/confirmer/{nas}")
    public ModelAndView confirmer(@PathVariable("nas") String nas, HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");
        Panier panier = getPanier(session);
        Etudiant etudiant = dataContext.getEtudiant(nas);

        if (etudiant != null && panier != null) {
            // Recuperer la liste des cours du panier
            List<Cours> listCoursSession = panier.getListe();

            // Marquer l'etudiant comme inscrit
            etudiant.setEstInscrit(true);

            // Creer une nouvelle inscription
            Inscription inscription = new Inscription(nas, new Date(), listCoursSession, etudiant);

            // Logging pour debogage
            System.out.println("NAS de l'étudiant : " + etudiant.getNas());
            System.out.println("Est inscrit ? " + etudiant.isEstInscrit());

            // Ajouter l'inscription dans le contexte de données
            dataContext.inscrire(inscription);


            // Ajouter l'inscription au modele pour la vue
            mav.addObject("inscription", inscription);
            mav.addObject("etudiant", etudiant);

            // Ajouter l'inscription à la liste des inscriptions dans la session
            List<Inscription> listeInscriptions = (List<Inscription>) session.getAttribute("listeInscriptions");
            if (listeInscriptions == null) {
                listeInscriptions = new ArrayList<>();
                session.setAttribute("listeInscriptions", listeInscriptions);
            }
            listeInscriptions.add(inscription);

            panier = new Panier();
            session.setAttribute("panier", panier);//Vider le panier pour ne pas refiler les cours de la derniere inscription a tout les inscrits

            // Definir le contenu de la page
            mav.addObject("pageContent", "confirmationInscription");

            return mav;
        }

        mav.setViewName("Erreur"); // Nom d'une vue JSP pour afficher les erreurs(Pas encore cree)
        return mav;
    }

    /**
     * Affiche la liste des inscriptions.
     *
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode afficherInscriptions
    @RequestMapping("/afficherInscriptions")
    public ModelAndView afficherInscriptions(HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");

        List<Inscription> listeInscriptions = (List<Inscription>) session.getAttribute("listeInscriptions");

        if (listeInscriptions == null) {
            mav.addObject("errorMessage", "Aucune inscription n'a été effectuée.");
        } else {
            mav.addObject("listeInscriptions", listeInscriptions);
        }

        mav.addObject("pageContent", "afficherInscriptions");

        return mav;
    }

    /**
     * Affiche la liste des inscriptions.
     *
     * @param session La session HTTP actuelle.
     * @return Le ModelAndView à afficher.
     */
    //Methode inscription
    @RequestMapping("/inscription")
    public ModelAndView inscription(HttpSession session) {
        ModelAndView mav = new ModelAndView("layout");

        List<Inscription> listeInscriptions = (List<Inscription>) session.getAttribute("listeInscriptions");

        if (listeInscriptions == null) {
            listeInscriptions = new ArrayList<>();
            session.setAttribute("listeInscriptions", listeInscriptions);
        }

        mav.addObject("listeInscriptions", listeInscriptions);
        mav.addObject("pageContent", "inscription");

        return mav;
    }


}








