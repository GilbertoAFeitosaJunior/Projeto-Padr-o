
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "tipoEvento.nome": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();