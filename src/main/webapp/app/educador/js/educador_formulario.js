var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "educador.nome":{
                    required: "Favor preencher esse campo"
                },
                "educador.usuario.id":{
                    required: "Favor preencher esse campo"
                },
                "educador.ddd":{
                  required: "Favor preencher esse campo",
                  maxlength: "Favor preencher esse campo com no máximo 2 dígitos"
                },
                "educador.celular":{
                  required: "Favor preencher esse campo",
                  maxlength: "Favor preencher esse campo com no máximo 9 dígitos"
                },
                "educador.senha":{
                  required: "Favor preencher esse campo" 
                },
                "educador.logradouro":{
                  required: "Favor preencher esse campo"
                },
                "educador.numero":{
                  required: "Favor preencher esse campo",
                },
                "educador.complemento":{
                  required: "Favor preencher esse campo"
                },
                "educador.bairro":{
                  required: "Favor preencher esse campo"
                },
                "educador.cidade":{
                  required: "Favor preencher esse campo"
                },
                "educador.uf":{
                  required: "Favor preencher esse campo"
                },
                "educador.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválidado"
                }
            }
        });
    });
}();

