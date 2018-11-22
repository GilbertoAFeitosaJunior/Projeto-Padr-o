
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "secretaria.nome": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.nivelSecretariaEnum": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.uf": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.municipio": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.responsavel": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.responsavelContato": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.gestorDoTerritorio": {
                    required: "Favor preencher esse campo"
                },
                "secretaria.coordenadorPedagogico": {
                    required: "Favor preencher esse campo"
                }
                
            }
        });
    });
}();