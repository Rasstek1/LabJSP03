// telechargement du fichier
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

