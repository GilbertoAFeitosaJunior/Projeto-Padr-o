
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "secretaria.nome": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();