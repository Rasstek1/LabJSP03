<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Valider Étudiant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css">
</head>
<body>

<div class="background-img">
    <div>

        <div class="container mt-5">
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>

            <h1 class="text-center">Valider Étudiant</h1>
            <table class="table table-striped table-hover w-50"
                   style="border: 3px solid darkslategrey; background-color: white">
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
                            <c:choose>
                                <c:when test="${not etudiant.estInscrit}">
                                    <a href="<c:url value='/inscription/confirmer/${etudiant.nas}'/>"
                                       class="btn btn-success">
                                        <i class="fa fa-check"></i>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-secondary" disabled>
                                        <i class="fa fa-check"></i>
                                    </button>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="d-flex">

                <a href="${pageContext.request.contextPath}/cours/liste" class="btn btn-secondary">Retour à la liste</a>
            </div>

        </div>

    </div>
</div>
</body>
</html>
