
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "usuario.cpjStringMask": {
                    required: "Favor preencher esse campo"
                },
                "usuario.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválidado"
                },
                "usuario.senha": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();