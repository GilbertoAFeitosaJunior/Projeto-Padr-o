
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "metodologia.nome": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.aplicabilidadeEnum": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.descricao": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.ativo": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();