var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "coordenadorDeProjeto.nome": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorDeProjeto.usuario.nome": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorDeProjeto.usuario.ativo": {
                    required: "Favor preencher esse campo"
                },
                "coordenadorDeProjeto.usuario.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválido"
                },
                "coordenadorDeProjeto.usuario.senha": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();

