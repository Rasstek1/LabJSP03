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
    <table class="table table-striped table-hover" style="border: 3px solid darkslategrey">
        <thead class="thead-dark">
        <tr>
            <th>Numéro</th>
            <th>Intitulé</th>
            <th>Nombre de Crédits</th>
            <th>Session</th>
            <th>Details</th>
            <th>Choisir</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cours" items="${listeCours}">
            <tr class="bg-info">
                <td>${cours.numero}</td>
                <td>${cours.intitule}</td>
                <td>${cours.nbCredits}</td>
                <td>${cours.session}</td>
                <td><button type="button" class="btn btn-warning"href="#" onclick="downloadFile()">Voir le Plan</button></td>

                <!-- Bouton Bootstrap -->
                <td><button type="button" class="btn btn-success">Choisir</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Boutons Bootstrap -->
    <a href="${pageContext.request.contextPath}/choix" class="btn btn-primary">Voir mes choix</a>
    <a class="btn btn-secondary" href="/LabJSP03/accueil">Retour à l'accueil</a>
</div>

<script>
    function downloadFile() {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '${pageContext.request.contextPath}/numCours', true);
        xhr.responseType = 'blob';
        xhr.onload = function() {
            var blob = xhr.response;
            var link = document.createElement('a');
            link.href = window.URL.createObjectURL(blob);
            link.download = 'NumCours.docx';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        };
        xhr.send();
    }
</script>

</body>
</html>
