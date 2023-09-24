<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Afficher Panier</title>
</head>
<body>
<h1>Contenu du Panier</h1>
<table border="1">
    <thead>
    <tr>
        <th>Numéro</th>
        <th>Intitulé</th>
        <th>Nombre de Crédits</th>
        <th>Session</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cours" items="${panier.liste}">
        <tr>
            <td>${cours.numero}</td>
            <td>${cours.intitule}</td>
            <td>${cours.nbCredits}</td>
            <td>${cours.session}</td>
            <td>
                <a href="${pageContext.request.contextPath}/inscription/supprimer/${cours.numero}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/inscription/valider">Valider mes choix</a>
</body>
</html>
