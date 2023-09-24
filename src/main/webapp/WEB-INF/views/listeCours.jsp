<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Cours</title>
    <!-- Ajout des CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Liste des Cours</h1>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
        <tr>
            <th>Numéro</th>
            <th>Intitulé</th>
            <th>Nombre de Crédits</th>
            <th>Session</th>
            <th>Fichier de Plan</th>
            <th>Choisir</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${listeCours}">
            <tr>
                <td>${cours.numero}</td>
                <td>${cours.intitule}</td>
                <td>${cours.nbCredits}</td>
                <td>${cours.session}</td>
                <td><a href="${pageContext.request.contextPath}/numCours" target="_blank" class="btn btn-info">Voir le Plan</a></td>
                <!-- Bouton Bootstrap -->
                <td><button type="button" class="btn btn-success">Choisir</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Boutons Bootstrap -->
    <a href="${pageContext.request.contextPath}/choix" class="btn btn-primary">Voir mes choix</a>
    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Retour à l'accueil</a>
</div>


</body>
</html>
