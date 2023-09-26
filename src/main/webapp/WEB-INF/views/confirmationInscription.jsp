<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation d'Inscription</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

    <h1 class="text-center">Félicitations !</h1>

    <h2>Informations de l'étudiant</h2>
    <table class="table table-striped table-hover" style="border: 3px solid darkslategrey">
        <thead class="thead-dark">
        <tr>
            <th>NAS</th>
            <th>Date d'inscription</th>
        </tr>
        </thead>
        <tbody>
        <tr class="bg-info">
            <td>${inscription.nas}</td>
            <td>${inscription.dateInscription}</td>
        </tr>
        </tbody>
    </table>

    <h2>Cours choisis :</h2>
    <table class="table table-striped table-hover" style="border: 3px solid darkslategrey">
        <thead class="thead-dark">
        <tr>
            <th>Numéro</th>
            <th>Intitulé</th>
            <th>Nombre de Crédits</th>
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
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Retour à l'accueil</a>
    </div>

</div>

</body>
</html>
