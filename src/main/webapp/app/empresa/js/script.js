
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            rules: {
                "manager.email": {
                    email: true
                }
            },
            messages: {
                "usuario.empresa.razaoSocial": {
                    required: "Favor preencher esse campo"
                },
                "usuario.empresa.nomeFantasia": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválidado"
                },
                "usuario.empresa.cnpjStringMask": {
                    required: "Favor preencher esse campo"
                },
                "usuario.email": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();