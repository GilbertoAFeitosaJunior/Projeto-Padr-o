var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "oficina.educador.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.atividade.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.escola.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.situacaoEnum": {
                    required: "Favor preencher esse campo"
                },
                "oficina.turnoEnum": {
                    required: "Favor preencher esse campo"
                },
                "oficina.dataPlanejada": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();