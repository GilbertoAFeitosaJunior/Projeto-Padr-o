
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "escola.nome": {
                    required: "Favor preencher esse campo"
                },
                "escola.projeto.id": {
                    required: "Favor preencher esse campo"
                },
                "escola.cepStringMask": {
                    required: "Favor preencher esse campo"
                },
                "escola.logradouro": {
                    required: "Favor preencher esse campo"
                },
                "escola.numero": {
                    required: "Favor preencher esse campo"
                },
                "escola.bairro": {
                    required: "Favor preencher esse campo"
                },
                "escola.cidade": {
                    required: "Favor preencher esse campo"
                },
                "escola.uf": {
                    required: "Favor preencher esse campo"
                },
                "escola.nivelRelacionamentoEnum": {
                    required: "Favor preencher esse campo"
                },
                "escola.situacaoEnum": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();