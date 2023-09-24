<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Valider Étudiant</title>
</head>
<body>

<h1>Valider Étudiant</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID Étudiant</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <!-- Utilisation de JSTL pour itérer sur la liste des étudiants -->
    <c:forEach var="etudiant" items="${listeEtudiants}">
        <tr>
            <td>${etudiant.id}</td>
            <td>${etudiant.nom}</td>
            <td>${etudiant.prenom}</td>
            <td>
                <!-- Lien pour confirmer l'étudiant par son NAS (Numéro d'Assurance Sociale ou autre identifiant) -->
                <a href="<c:url value='/inscription/confirmer/${etudiant.nas}'/>">Confirmer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
