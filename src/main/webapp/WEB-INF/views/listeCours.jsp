<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Cours</title>
    <script src="${pageContext.request.contextPath}/js/gestionPanier.js"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/liste.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">


</head>
<body>

<div class="container mt-3">
    <div class="row">
        <!-- Colonne de gauche pour le tableau -->
        <div class="col-lg-6 col-md-12 align-items-end">

                <div class="container mt-3">

                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger">${errorMessage}</div>
                    </c:if>

                    <h6>Nombre de cours choisis: <span style="background-color: mediumseagreen; color: white; padding: 10px;" >${panier.getListe().size()}</span></h6>


                    <h3 class="text-center">Liste des Cours</h3>
                    <div style="overflow-x:auto;">
                        <table class="table table-striped table-hover"
                               style="border: 3px solid darkslategrey; background-color: white">
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
                                        <button type="button" class="btn btn-warning" onclick="downloadFile()"><!--Fonction javascript pour le telechargement du fichier-->
                                            <i class="fas fa-file-alt"></i>
                                        </button>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cours/ajouter/${cours.numero}"
                                              method="post">
                                            <button type="submit" class="btn btn-success"
                                                    <c:if test="${panier.getListe().contains(cours)}">disabled="disabled"</c:if>>
                                                <i class="fas fa-check"></i>
                                            </button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/cours/supprimer/${cours.numero}"
                                              method="post">
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
                        <a href="${pageContext.request.contextPath}/inscription/afficher" class="btn btn-primary me-2">Voir
                            mes
                            choix</a>
                        <a href="/LabJSP03/accueil" class="btn btn-secondary">Retour à l'accueil</a>
                    </div>
                </div>
            </div>


        <!-- Colonne de droite images et texte -->
        <div class="col-lg-6 col-md-12">
            <div class="container-fluid mt-5" style="padding-top: 35px;">

                <div class="d-flex flex-column align-items-center">
                    <!-- Premiere image et texte -->
                    <div class="image-container" style="margin-left: 0;">
                        <img src="${pageContext.request.contextPath}/img/Liste_Image.jpg" alt="Image 1" class="img-fluid" style="box-shadow: 5px 2px 5px rgba(0, 0, 0, 0.8);">
                        <h2 class="image-title">Personnalisation du Parcours</h2>
                    </div>
                    <p class="text-container" style="background-color: #fcc33d">Dans notre collège, nous comprenons l'importance de fournir un enseignement en informatique qui s'adapte aux besoins individuels de chaque étudiant.
                        Grâce à une large gamme de cours électifs, vous pouvez personnaliser votre parcours académique pour correspondre à vos intérêts et vos objectifs de carrière.</p>

                    <!-- Deuxieme image et texte -->
                    <div class="image-container ml-3" >
                        <img src="${pageContext.request.contextPath}/img/Liste_Image2.jpg" alt="Image 2" class="img-fluid" style="box-shadow: 5px 2px 5px rgba(0, 0, 0, 0.8);">
                        <h2 class="image-title">Apprentissage Pratique</h2>
                    </div>
                    <p class="text-container" style="background-color: #44b4cd">Quoi de mieux pour apprendre la programmation que de mettre la main à la pâte? Nos cours sont conçus pour offrir une expérience d'apprentissage pratique.
                        Vous aurez de nombreuses occasions de travailler sur des projets réels et de collaborer avec vos pairs, tout en étant guidé par nos instructeurs expérimentés.</p>

                    <!-- Troisieme image et texte -->
                    <div class="image-container" style="margin-left: 0;">
                        <img src="${pageContext.request.contextPath}/img/Liste_Image3.jpg" alt="Image 3" class="img-fluid" style="box-shadow: 5px 2px 5px rgba(0, 0, 0, 0.8);">
                        <h2 class="image-title">Soutien Continu</h2>
                    </div>
                    <p class="text-container" style="background-color: orange">Votre réussite est notre priorité. C'est pourquoi nous offrons divers services de soutien, tels que des séances de tutorat, des ateliers de préparation à la carrière,
                        et une orientation académique personnalisée. De la salle de classe jusqu'à l'obtention de votre diplôme, nous sommes là pour vous aider à chaque étape.</p>
                </div>
            </div>
        </div>


    </div>
</div>
</div>
</div>

</body>
</html>

