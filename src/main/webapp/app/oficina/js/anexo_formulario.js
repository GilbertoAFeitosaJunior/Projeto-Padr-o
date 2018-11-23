$(function () {
    uploadAjax();
    anexo.list();
});

function uploadAjax() {
    $('#upload').on('change', prepareUpload);
    $("#formArquivo").on("submit", uploadFiles);
}

var files;

function prepareUpload(event) {
    files = event.target.files;
}

function uploadFiles(event) {
// Create a formdata object and add the files
    var data = new FormData();
    data.append("oficina.id", $("[name='oficina.id']").val());
    data.append("anexo.descricao", $("[name='anexo.descricao']").val());
    $.each(files, function (key, value) {
        data.append("upload", value);
    });
    try {
        event.stopPropagation(); // Stop stuff happening
        event.preventDefault(); // Totally stop stuff happening

        // START A LOADING SPINNER HERE   
        $('#spinner').show();
        $.ajax({
            url: 'persistAnexo',
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, // Don't process the files
            contentType: false, // Set content type to false as jQuery will tell the server its a query string request
            success: function (data, textStatus, jqXHR) {
                if (typeof data.error === 'undefined') {
                    // Success so call function to process the form
                    anexo.list();
                    //  $("#uploadDocumento").val("");
                } else {
                    // Handle errors here
                    console.log('ERRORS: ' + data.error);
                }
                
                setTimeout(function(){
                    $("#spinner").hide();
                    $("#spinner2").show();
                        setTimeout(function(){ 
                         $("#spinner2").hide();
                         }, 2000);
                },2000);
                 
                $("[name='anexo.descricao']").val("");
                $('#upload').innerHTML = $('upload').innerHTML;

            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Handle errors here
                console.log('ERRORS: ' + textStatus);
                // STOP LOADING SPINNER 
                $("#spinner").hide();
            }
        });
    } catch (err) {
        httpSend("persistDocumento", "POST", data, "_blank");

    }
}
    var anexo = {
        list: function () {
            $.ajax({
                type: "POST",
                url: "listAnexo",
                data: {
                    "anexo.oficina.id": $("[name='oficina.id']").val()
                },
                dataType: "json",
                beforeSend: function () {
                    $("table#tArquivo tbody").html("<tr><td colspan=\"3\" class=\"text-center\"><img src=\"../img/ajax-loader.gif\" /></td></tr>");
                },
                success: function (json) {
                    if (json.jsonReturn.success) {
                        var HTML = "";
                        $.each(json.anexos, function (key, value) {
                            HTML += "<tr>";
                            HTML += "<td>" + value.descricao + "</td>";
                            HTML += "<td class=\"col-lg-2 col-sm2 col-xs-2\"><a class='btn btn-primary btn-xs' href='../../" + value.arquivo + "' download onclick=\"anexo.atualizarQtdDownload(" + value.id + ")\"><i class=\"fa fa-cloud-download \"></i> Baixe uma cópia</a></td>";
                            HTML += "</a></td>";
                            HTML += "<td class=\"col-lg-2 col-sm-2 col-xs-2\">" + value.tipoMine + "</td>";
                            HTML += "<td class=\"col-lg-1 col-sm-1 col-xs-1 text-center\">" + value.download + "</td>";
                            HTML += "<td class=\"col-lg-1 col-sm-1 col-xs-1 text-right\"><a class=\"btn btn-danger btn-xs\" href=\"javascript: anexo.remover(" + value.id + ")\"><i class=\"fa fa-trash-o \"></i></a></td>";
                            HTML += "</tr>";
                        });
                        $("table#tArquivo tbody").html(HTML);
                    }
                },
                error: function () {
                    notify.error("Erro ao tentar enviar os dados para o servidor. Tente novamente!");
                }
            });
        },
        remover: function (id) {
            if (confirm("Deseja excluir esse registro?")) {
                $.ajax({
                    type: "POST",
                    url: "deleteAnexo",
                    data: {
                        "anexo.id": id
                    },
                    dataType: "json",
                    beforeSend: function () {

                    },
                    complete: function () {
                        anexo.list();
                    },
                    success: function (json) {
                        if (json.jsonReturn.success) {
                            notify.success("Sucesso", "Registro excluído com sucesso");
                        } else {
                            notify.error("Erro", "Erro ao tentar excluir o registro.");
                        }
                    },
                    error: function () {
                        notify.error("Falha na comunicação", "Erro ao tentar enviar os dados para o servidor. Tente novamente!");
                    }
                });
            }
        },
        atualizarQtdDownload: function (id) {
            $.ajax({
                method: "POST",
                url: "updateAnexo",
                data: {
                    "anexo.id": id
                },
                dataType: "json"
            })
            .always(function () {
                anexo.list();
            });
            }
        
    };



