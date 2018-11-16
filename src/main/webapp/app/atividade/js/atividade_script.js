
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "atividade.nome": {
                    required: "Favor preencher esse campo"
                }
                ,
                "atividade.descricao": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();

$(function () {
    metodologia.init();
});

var metodologia = {
    persist: function () {
        $.ajax({
            type: "POST",
            url: "persistAtividadeJson",
            data: {
                "atividade.id": $("[name='atividade.id']").val(),
                "metodologia.id": $("[name='metodologia.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            if (json.jsonReturn.success) {
                notify.success("Sucesso", json.jsonReturn.mensagem);
                metodologia.list();
            } else {
                notify.warning("Atenção!", json.jsonReturn.mensagem);
            }
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    },

    list: function () {
        $.ajax({
            type: "POST",
            url: "listAtividadeMetodologia",
            data: {
                "atividade.id": $("[name='atividade.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            var html = "";
            $.each(json.atividade.metodologias, function (index, value) {
                html += "<tr>";
                html += "<td>" + value.nome + "</td>";
                html += "<td class='text-right'>";
                html += '<a class="btn btn-danger btn-xs" onclick="metodologia.remove(' + value.id + ');"><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });
            $("#tMetodologia tbody").html(html);

        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {
        });
    },

    init: function () {
        this.list();
    },

    remove: function (id) {
        if (confirm("Deseja excluir esse registro?")) {
            $.ajax({
                type: "POST",
                url: "deleteAtividadeMetodologia",
                data: {
                    "atividade.id": $("[name='atividade.id']").val(),
                    "metodologia.id": id
                },
                dataType: "json"
            })
                    .done(function (json) {

                        notify.success("Sucesso", "Registro deletado com sucesso    ");

                        metodologia.list();

                    })
                    .fail(function () {
                        notify.error("Erro", "Impossível de estabelecer conexão servidor");
                    })
                    .always(function () {
                        //fill = "";
                    });
        }
    }





};

