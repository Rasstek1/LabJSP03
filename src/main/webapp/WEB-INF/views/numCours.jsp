<td><a href="${pageContext.request.contextPath}/numCours" target="_blank">Voir le Plan</a></td>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Plan du Cours</title>
</head>
<body>

<h1>Plan du Cours</h1>

<!-- Intégration du fichier Docx -->
<iframe src="${pageContext.request.contextPath}/files/NumCours.docx" style="width:600px; height:500px;" frameborder="0"></iframe>

<!-- Bouton pour retourner à la liste des cours -->
<a href="${pageContext.request.contextPath}/cours/liste">Retour à la liste des cours</a>

</body>
</html>
