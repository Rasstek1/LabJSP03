package com.martin.labjsp03.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        public ResponseEntity<Resource> getFile() throws IOException {
            Resource resource = new ClassPathResource("static/files/NumCours.docx");

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        }

}
