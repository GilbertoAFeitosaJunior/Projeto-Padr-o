var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "pessoa.nome": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.sexoEnum": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.generoEnum": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.bairro": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.cidade": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.uf": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();
