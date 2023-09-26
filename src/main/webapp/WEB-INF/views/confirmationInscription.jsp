<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation d'Inscription</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1, h2 {
            color: #333366;
        }
        p {
            font-size: 18px;
        }
        .cours-list {
            font-size: 16px;
            line-height: 1.6;
        }
    </style>
</head>
<body>

<h1>Félicitations !</h1>

<p>Votre inscription a été confirmée avec succès.</p>

<h2>Informations de l'étudiant</h2>
<p>NAS: <strong>${inscription.nas}</strong></p>
<p>Date d'inscription: <strong>${inscription.dateInscription}</strong></p>

<h2>Cours choisis :</h2>
<pre class="cours-list">${inscription.listeCours}</pre>

<a href="${pageContext.request.contextPath}/">Retour à l'accueil</a>

</body>
</html>