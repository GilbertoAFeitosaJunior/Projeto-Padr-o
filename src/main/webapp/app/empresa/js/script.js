
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            rules: {
                "manager.email": {
                    email: true
                }
            },
            messages: {
                "manager.nome": {
                    required: "Favor preencher esse campo"
                },
                "manager.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválidado"
                },
                "manager.ddd": {
                    required: "Favor preencher esse campo"
                },
                "manager.celular": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();