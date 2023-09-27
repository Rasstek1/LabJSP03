
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