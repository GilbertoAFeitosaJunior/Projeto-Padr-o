
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "podcast.titulo": {
                    required: "Favor preencher esse campo"
                },
                "podcast.dataExibicao": {
                    required: "Favor preencher esse campo"
                },
                "podcast.descricao": {
                    required: "Favor preencher esse campo"
                },
                "upload": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();