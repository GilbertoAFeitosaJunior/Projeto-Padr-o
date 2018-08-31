
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
    },
    clearModal: function () {
        var inputs = ["#id", "#consultorNome"];
        for (var i in inputs) {
            $(inputs[i]).val("");
        }
    },
    persist: function (event) {
        var data = new FormData();
        data.append("consultor.id", $("#id").val());
        data.append("consultor.nome", $("#consultorNome").val());
        data.append("consultor.manager.id", $("[name='usuario.manager.id']").val());
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
                        //preContrato.list();
                        var inputs = ["#id", "#consultorNome"];
                        for (var i in inputs) {
                            $(inputs[i]).val("");
                        }
                        $("#novoConsultorModal").modal('hide');
                        notify.success("Sucesso", "Registro salvo com sucesso!");                      
                    } else {
                        // Handle errors here
                        console.log('ERRORS: ' + data.error);
                    }
                    $('#uploadConsultor').val("");
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
    }
};

function uploadAjax() {
    $('#uploadConsultor').on('change', prepareUpload);
    //$("#formArquivo").on("submit", persist);
}

var files;
function prepareUpload(event) {
    files = event.target.files;
}
