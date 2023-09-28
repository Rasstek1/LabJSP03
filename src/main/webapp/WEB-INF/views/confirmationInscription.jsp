<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation d'Inscription</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css">
</head>
<body>

<div class="background-img">
    <div>

<div class="container mt-5">

    <h1 class="text-center" style="color: #fcc33d">Félicitations !</h1>

    <h2 style="color: black">Informations de l'étudiant</h2>
    <table class="table table-striped table-hover w-50" style="border: 3px solid darkslategrey; background-color: white">
        <thead class="thead-dark">
        <tr>
            <th>NAS</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Date d'inscription</th>
        </tr>
        </thead>
        <tbody>
        <!-- Premiere ligne avec NAS, Nom, Prenom, et Date d'inscription -->
        <tr class="bg-info">
            <td>${inscription.nas}</td>
            <td>${etudiant.nom}</td>
            <td>${etudiant.prenom}</td>
            <td>${inscription.dateInscription}</td>
        </tr>
        <thead class="thead-light">
        <tr>
            <th>Téléphone</th>
            <th>Adresse</th>
            <th>Code Postal</th>
            <th>Courriel</th>
        </tr>
        </thead>
        <tr class="bg-info">
            <td>${etudiant.telephone}</td>
            <td>${etudiant.adresse}</td>
            <td>${etudiant.codePostal}</td>
            <td>${etudiant.courriel}</td>
        </tr>
        </tbody>
    </table>



    <h2 class="mt-5" style="color: black">Cours choisis</h2>
    <table class="table table-striped table-hover w-50" style="border: 3px solid darkslategrey; background-color: white">
        <thead class="thead-dark">
        <tr>
            <th>No.</th>
            <th>Cours</th>
            <th>Crédits</th>
            <th>Session</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${inscription.listeCours}">
            <tr class="bg-info">
                <td>${cours.numero}</td>
                <td>${cours.intitule}</td>
                <td>${cours.nbCredits}</td>
                <td>${cours.session}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex">
        <a href="/LabJSP03/accueil" class="btn btn-secondary">Retour à l'accueil</a>
    </div>


</div>

</body>
</html>
