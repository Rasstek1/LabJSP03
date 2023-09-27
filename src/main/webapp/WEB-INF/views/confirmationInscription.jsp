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
            <th>Nom</th>  <!-- Ajouté -->
            <th>Prénom</th>  <!-- Ajouté -->
            <th>Date d'inscription</th>
        </tr>
        </thead>
        <tbody>
        <tr class="bg-info">
            <td>${inscription.nas}</td>
            <td>${etudiant.nom}</td>  <!-- Ajouté -->
            <td>${etudiant.prenom}</td>  <!-- Ajouté -->
            <td>${inscription.dateInscription}</td>
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
