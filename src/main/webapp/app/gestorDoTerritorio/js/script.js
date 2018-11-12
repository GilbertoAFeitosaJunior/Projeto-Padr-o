var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "gestorDoTerritorio.nome": {
                    required: "Favor preencher esse campo"
                },
                "gestorDoTerritorio.usuario.id  ": {
                    required: "Favor preencher esse campo"
                }                
            }
        });
    });
}();