package com.martin.labjsp03.controllers;

import com.martin.labjsp03.models.Cours;
import com.martin.labjsp03.models.Etudiant;
import com.martin.labjsp03.models.Lab04DataContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Lab04DataContext dataContext = new Lab04DataContext();

    @GetMapping("/")
    public String adminDashboard(Model model) {
        // Code pour préparer le tableau de bord de l'admin
        model.addAttribute("pageContent", "adminDashboard");
        return "layout";
    }

    @GetMapping("/addCourse")
    public String addCourseForm(Model model) {
        // Code pour afficher le formulaire d'ajout de cours
        return "AddCourseForm";
    }

   /* @PostMapping("/addCourse")
    public String addCourse(Cours cours) {
        // Code pour ajouter un nouveau cours à la base de données
        dataContext.ajouterCours(cours);
        return "redirect:/admin/";
    }*/

    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        // Code pour afficher le formulaire d'ajout d'étudiant
        return "AddStudentForm";
    }

    /*@PostMapping("/addStudent")
    public String addStudent(Etudiant etudiant) {
        // Code pour ajouter un nouvel étudiant à la base de données
        dataContext.ajouterEtudiant(etudiant);
        return "redirect:/admin/";
    }*/


}
