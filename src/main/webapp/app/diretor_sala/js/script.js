
var Script = function () {
    $().ready(function () {

        $("#form").validate({
            rules: {
                "diretorSala.email": {
                    email: true
                }
            },
            messages: {
                "usuario.diretorSala.nome": {
                    required: "Favor preencher esse campo"
                },
                "usuario.email": {
                    required: "Favor preencher esse campo"
                },
                "usuario.cpjStringMask": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();