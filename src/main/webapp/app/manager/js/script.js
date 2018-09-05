
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

$(function () {
    consultor.init();

});


var consultor = {
    init: function () {
        uploadAjax();
        this.list();
    },
    clearModal: function () {
        var inputs = ["#consultorId", "#usuarioId", "#consultorNome", "#uploadConsultor", "#consultorEmail", "#consutlorSenha", "#consultorCPF"];
        for (var i in inputs) {
            $(inputs[i]).val("");
        }
        imageUtils.cleanUpload('uploadConsultor');
    },
    persist: function (event) {
        var data = new FormData();
        data.append("usuario.id", $("[name='usuario.id']").val());
        data.append("usuario.consultor.id", $("[name='usuario.consultor.id']").val());
        data.append("usuario.consultor.nome", $("#consultorNome").val());
        data.append("usuario.email", $("#consultorEmail").val());
        data.append("usuario.senha", $("#consutlorSenha").val());
        data.append("usuario.cpjStringMask", $("#consultorCPF").val());
        data.append("usuario.consultor.manager.id", $("[name='usuario.manager.id']").val());
        $.each(files, function (key, value) {
            data.append("upload", value);
        });
        try {
            $.ajax({
                url: 'persistConsultor',
                type: 'POST',
                data: data,
                cache: false,
                dataType: 'json',
                processData: false, // Don't process the files
                contentType: false, // Set content type to false as jQuery will tell the server its a query string request
                success: function (data, textStatus, jqXHR) {
                    if (typeof data.error === 'undefined') {
                        // Success so call function to process the form

                        var inputs = ["#consultorId", "#usuarioId", "#consultorNome", "#uploadConsultor", "#consultorEmail", "#consutlorSenha", "#consultorCPF"];
                        for (var i in inputs) {
                            $(inputs[i]).val("");
                        }
                        imageUtils.cleanUpload('uploadConsultor');
                        $("#novoConsultorModal").modal('hide');
                        notify.success("Sucesso", "Registro salvo com sucesso!");
                    } else {
                        // Handle errors here
                        console.log('ERRORS: ' + data.error);
                    }
                    $('#uploadConsultor').val("");
                    consultor.list();

                },
                error: function (jqXHR, textStatus, errorThrown) {
                    // Handle errors here
                    console.log('ERRORS: ' + textStatus);
                    // STOP LOADING SPINNER                    
                }
            });
        } catch (err) {
            httpSend("persistConsultor", "POST", data, "_blank");
        }
    },
    list: function () {
        $.ajax({
            type: "POST",
            url: "listConsultor",
            data: {
                "consultor.manager.id": $("[name='usuario.manager.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            var html = "";
            $.each(json.usuarios, function (index, value) {
                html += "<tr>";
                html += "<td> <img src=\"../../" + value.consultor.foto + "\" class=\"img-responsive img-thumbnail\" height=\"60\" width=\"60\" /> </td>";
                html += "<td>" + value.consultor.nome + "</td>";
                html += "<td>" + value.email + "</td>";
                html += "<td>" + value.cpjStringMask + "</td>";
                html += "<td class='text-right'>";
                html += '<a class="btn btn-primary btn-xs" onclick="consultor.edit(' + value.consultor.id + ');"><i class="fa fa-pencil"></i></a> ';
                html += '<a class="btn btn-danger btn-xs" onclick="consultor.remove(' + value.consultor.id + ');"><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });

            $("#tConsultor tbody").html(html);


        });
    },
    remove: function (id) {
        if (confirm("Deseja realmente excluir esse registro?")) {
            $.ajax({
                type: "POST",
                url: "deleteConsultor",
                data: {
                    "consultor.id": id
                },
                dataType: "json"
            }).done(function (json) {

                if (json.jsonReturn.success) {
                    consultor.list();
                    notify.success("Sucesso", "Registro excluído com sucesso!");
                } else {
                    notify.error("Erro", json.jsonReturn.mensagem);
                }

            }).fail(function () {
                notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
            }).always(function () {

            });
        }
    },
    edit: function (id) {
        $.ajax({
            type: "POST",
            url: "prepareConsultor",
            data: {
                "consultor.id": id
            },
            dataType: "json"
        }).done(function (json) {

            console.log(json.usuario.consultor.nome);
            $("[name='usuario.consultor.id']").val(json.usuario.consultor.id);
            $("[name='usuario.id']").val(json.usuario.id);
            $("[name='usuario.consultor.nome']").val(json.usuario.consultor.nome);
            $("[name='usuario.email']").val(json.usuario.email);
            $("[name='usuario.senha']").val(json.usuario.senha);
            $("[name='usuario.cpjStringMask']").val(json.usuario.cpjStringMask);
            $("[name='usuario.consultor.foto']").val(json.usuario.consultor.foto);


            $("#novoConsultorModal").modal('show');
        }).fail(function () {
            notify.error("Erro", "Erro ao abrir o formulário de edição. Favor tente novamente.");
        }).always(function () {
        });
    }
};

function uploadAjax() {
    $('#uploadConsultor').on('change', prepareUpload);
}

var files;
function prepareUpload(event) {
    files = event.target.files;
}
