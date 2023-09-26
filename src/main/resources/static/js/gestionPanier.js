
$(document).ready(function() {
    function ajouterAuPanier(numero) {
        $.ajax({
            url: '/cours/ajouter/' + numero,
            type: 'POST',
            success: function(response) {
                alert("Cours ajouté au panier");
            },
            error: function(error) {
                alert("Erreur lors de l'ajout au panier");
            }
        });
    }
});