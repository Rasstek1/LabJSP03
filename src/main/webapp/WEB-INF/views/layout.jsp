<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Mon site</title>
    <!-- Inclure Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/script.js"></script>

    <style>
        /* Ajouter un effet de flou à une boîte */
        .boite-blurry {
            backdrop-filter: blur(10px); /* Ajustez la valeur selon l'effet désiré */
            /*background-color: rgba(255, 255, 255, 0.5); /* Ajustez les valeurs RGBA pour obtenir l'effet désiré */
        }
    </style>
</head>
<body>

<header>
    <!-- Barre de navigation -->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="/LabJSP03/accueil">
                <img src="${pageContext.request.contextPath}/img/Logo.png" alt="Logo" class="logo-img"/>
            </a>
            <h2>Collège <span style="color: #fcc33d;">Informatique</span></h2>


            <!-- Bouton hamburger -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto pe-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP03/accueil">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/administration">Administration</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link"href="${pageContext.request.contextPath}/cours/liste">Liste des Cours</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LabJSP03/Accueil/contact">Nous contacter</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>



<!-- Corps de la page -->
<div class="content">
    <div class="container">
        <jsp:include page="${pageContent}.jsp"/>
    </div>
</div>



<!-- Pied de page -->
<footer class="text-center ">
    <p>© 2023 CollegeInformatique.com</p>
</footer>

<!-- Inclure Bootstrap JS et Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Inclusion du jQuery (nécessaire pour les fonctionnalités JavaScript de Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Inclusion du Popper.js (nécessaire pour certaines fonctionnalités JavaScript de Bootstrap) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<!-- Inclusion du JavaScript de Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
