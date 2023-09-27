<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Afficher Panier</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css">
</head>
<body>
<div class="background-img">
    <div>
<div class="container mt-5">

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <h6>Nombre de cours sélectionnés: ${panier.liste.size()}</h6>

    <h1 class="text-center">Cours sélectionnés</h1>
    <div style="overflow-x:auto;">
        <table class="table table-striped table-hover" style="border: 3px solid darkslategrey; background-color: white;">
            <thead class="thead-dark">
            <tr>
                <th>No.</th>
                <th>Cours</th>
                <th>Crédits</th>
                <th>Session</th>
                <th>Retirer</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${empty panier.liste}">
                    <tr>
                        <td colspan="5">Aucun cours.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="cours" items="${panier.liste}">
                        <tr class="bg-info">
                            <td>${cours.numero}</td>
                            <td>${cours.intitule}</td>
                            <td>${cours.nbCredits}</td>
                            <td>${cours.session}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/inscription/supprimer/${cours.numero}" method="post">
                                    <button type="submit" class="btn btn-danger"><i class="fas fa-times"></i></button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>

    <div class="d-flex">
        <a href="${pageContext.request.contextPath}/inscription/valider" class="btn btn-primary me-2">Valider mes choix</a>
        <a href="${pageContext.request.contextPath}/cours/liste" class="btn btn-secondary">Retour à la liste</a>
    </div>
</div>
</body>
</html>
