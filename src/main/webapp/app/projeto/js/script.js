var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "projeto.nome": {
                    required: "Favor preencher esse campo"
                },
                "projeto.situacaoProjetoEnum": {
                    required: "Favor preencher esse campo"
                },
                "projeto.secretaria.id": {
                    required: "Favor preencher esse campo"
                },
                "projeto.coordenadorDeProjeto.id": {
                    required: "Favor preencher esse campo"
                },
                "projeto.modoDeImplementacaoEnum": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();