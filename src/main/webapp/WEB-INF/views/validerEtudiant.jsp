<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Valider Étudiant</title>
</head>
<body>

<div class="container mt-5">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <h1 class="text-center">Valider Étudiant</h1>
    <table class="table table-striped table-hover w-50" style="border: 3px solid darkslategrey">
        <thead class="thead-dark">
        <tr>
            <th>NAS Étudiant</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="etudiant" items="${listeEtudiants}">
            <tr>
                <td>${etudiant.nas}</td>
                <td>${etudiant.nom}</td>
                <td>${etudiant.prenom}</td>
                <td>
                    <a href="<c:url value='/inscription/confirmer/${etudiant.nas}'/>" class="btn btn-success">
                        <i class="fa fa-check"></i>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex">
        <!-- Ajouter les autres boutons ou liens de navigation ici -->
        <a href="${pageContext.request.contextPath}/accueil" class="btn btn-secondary">Retour à l'accueil</a>
    </div>

</div>

</body>
</html>
