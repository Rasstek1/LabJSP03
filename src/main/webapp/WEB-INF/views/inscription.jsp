<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container mt-5">
    <h1 class="text-center">Liste des inscriptions</h1>

    <c:forEach var="inscription" items="${listeInscriptions}">
        <!-- Espace entre les inscriptions -->
        <div style="padding-bottom: 40px;">
            <div style="overflow-x:auto;">
                <!-- Tableau pour les informations sur les etudiants -->
                <table class="table table-striped table-hover" style="border: 3px solid darkslategrey; background-color: white;">
                    <thead class="thead-dark">
                    <tr>
                        <th>NAS Étudiant</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Date d'inscription</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="bg-info">
                        <td>${inscription.nas}</td>
                        <td>${inscription.etudiant.nom}</td>
                        <td>${inscription.etudiant.prenom}</td>
                        <td>${inscription.dateInscription}</td>
                    </tr>
                    </tbody>
                </table>
                <!-- Tableau pour la liste des cours -->
                <table class="table table-striped table-hover" style="border: 3px solid darkslategrey; background-color: white;">
                    <thead class="thead-dark">
                    <tr>
                        <th>Numéro du cours</th>
                        <th>Cours</th>
                        <th>Nombre de crédits</th>
                        <th>Session</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cours" items="${inscription.listeCours}">
                        <tr class="bg-info">
                            <td>${cours.numero}</td>
                            <td>${cours.intitule}</td>
                            <td>${cours.nbCredits}</td>
                            <td>${cours.session}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>
</div>
