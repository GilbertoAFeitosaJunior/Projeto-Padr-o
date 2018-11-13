var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "coordenadorPedagogico.nome": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorPedagogico.usuario.nome": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorPedagogico.usuario.ativo": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorPedagogico.usuario.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválido"
                },
                "coordenadorPedagogico.usuario.senha": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();