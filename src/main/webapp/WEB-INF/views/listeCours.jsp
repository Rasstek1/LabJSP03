<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Cours</title>
    <script src="/gestionPanier.js"></script>
</head>
<body>
<div class="container mt-5">

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <div>Nombre de cours choisis: ${panier.getListe().size()}</div>

    <h1 class="text-center">Liste des Cours</h1>
    <div style="overflow-x:auto;">
        <table class="table table-striped table-hover" style="border: 3px solid darkslategrey">
            <thead class="thead-dark">
            <tr>
                <th>No.</th>
                <th>Cours</th>
                <th>Crédits</th>
                <th>Session</th>
                <th>Details</th>
                <th>Choisir</th>
                <th>Retirer</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cours" items="${listeCours}">
                <tr <c:if test="${panier.getListe().contains(cours)}">class="bg-info"</c:if>>
                    <td>${cours.numero}</td>
                    <td>${cours.intitule}</td>
                    <td>${cours.nbCredits}</td>
                    <td>${cours.session}</td>
                    <td>
                        <button type="button" class="btn btn-warning" onclick="downloadFile()">
                            <i class="fas fa-file-alt"></i>
                        </button>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/cours/ajouter/${cours.numero}" method="post">
                            <button type="submit" class="btn btn-success"
                                    <c:if test="${panier.getListe().contains(cours)}">disabled="disabled"</c:if>>
                                <i class="fas fa-check"></i>
                            </button>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/cours/supprimer/${cours.numero}" method="post">
                            <button type="submit" class="btn btn-danger"
                                    <c:if test="${!panier.getListe().contains(cours)}">disabled="disabled"</c:if>>
                                <i class="fas fa-times"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="d-flex">
        <a href="${pageContext.request.contextPath}/inscription/afficher" class="btn btn-primary me-2">Voir mes choix</a>
        <a href="/LabJSP03/accueil" class="btn btn-secondary">Retour à l'accueil</a>
    </div>
</div>
</body>
</html>


</body>
</html>
