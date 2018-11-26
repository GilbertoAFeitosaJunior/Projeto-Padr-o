var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "gestorDoTerritorio.nome": {
                    required: "Favor preencher esse campo"
                },
                "gestorDoTerritorio.usuario.nome": {
                    required: "Favor preencher esse campo"
                },
                "gestorDoTerritorio.usuario.ativo": {
                    required: "Favor preencher esse campo"
                },
                "gestorDoTerritorio.usuario.email": {
                    required: "Favor preencher esse campo"
                },
                "gestorDoTerritorio.usuario.senha": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();