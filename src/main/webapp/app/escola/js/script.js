
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "escola.nome": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();