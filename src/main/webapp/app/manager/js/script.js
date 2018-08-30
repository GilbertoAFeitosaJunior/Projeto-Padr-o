
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            rules: {
                "usuario.email": {
                    email: true
                }
            },
            messages: {
                "usuario.manager.nome": {
                    required: "Favor preencher esse campo"
                },
                "usuario.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválidado"
                },
                "usuario.cpjStringMask": {
                    required: "Favor preencher esse campo"
                },
                "manager.celular": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();