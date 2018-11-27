
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "parceira.nome": {
                    required: "Favor preencher esse campo"
                },
                "parceira.situacaoParceiraEnum": {
                    required: "Favor preencher esse campo"
                },
                "parceira.cnpjStringMask": {
                    required: "Favor preencher esse campo"
                },
                "parceira.logradouro": {
                    required: "Favor preencher esse campo"
                },
                "parceira.numero": {
                    required: "Favor preencher esse campo"
                },
                "parceira.complemento": {
                    required: "Favor preencher esse campo"
                },
                "parceira.bairro": {
                    required: "Favor preencher esse campo"
                },
                "parceira.cidade": {
                    required: "Favor preencher esse campo"
                },
                "parceira.uf": {
                    required: "Favor preencher esse campo"
                },
                "parceira.responsavelLegal": {
                    required: "Favor preencher esse campo"
                },
                "parceira.responsavelLegalContatoStringMask": {
                    required: "Favor preencher esse campo"
                },
                "parceira.responsavelPrincipal": {
                    required: "Favor preencher esse campo"
                },
                "parceira.responsavelPrincipalContatoStringMask": {
                    required: "Favor preencher esse campo"
                }
                
            }
        });
    });
}();