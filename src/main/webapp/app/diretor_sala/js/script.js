
var Script = function () {
    $().ready(function () {

        $("#form").validate({
            rules: {
                "diretorSala.email": {
                    email: true
                }
            },
            messages: {
                "diretorSala.nome": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();