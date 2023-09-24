package com.martin.labjsp03.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

@Controller
public class MainController {

    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String accueil(Model model) {
        model.addAttribute("pageContent", "accueil"); // accueil.jsp sera le contenu inclus
        return "layout"; // layout.jsp sera le layout global pour la vue
    }

    @RequestMapping("/administration")
    public String administration(Model model) {
        model.addAttribute("pageContent", "administration");  // administration.jsp sera le contenu inclus
        return "layout";  // layout.jsp sera le layout global pour la vue
    }

    @RestController
    @RequestMapping("/files")
    public class FileController {

        @GetMapping("/detailsNumcours")
        public StreamingResponseBody getDetailsNumcours() throws IOException {
            Resource resource = new ClassPathResource("static/files/NumCours.docx");
            InputStream inputStream = resource.getInputStream();

            return outputStream -> {
                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            };
        }
    }

    @RequestMapping("/numCours")
    public String showNumCours(Model model) {
        // Logique pour envoyer des données au fichier numCours.jsp si nécessaire
        return "numCours"; // retourne la vue numCours.jsp
    }

}
