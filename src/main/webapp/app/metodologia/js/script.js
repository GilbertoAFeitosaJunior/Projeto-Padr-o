
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "metodologia.nome": {
                    required: "Favor preencher esse campo"
                }
                ,
                "metodologia.aplicabilidadeEnum": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.descricao": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.ativo": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.objetivo": {
                    required: "Favor preencher esse campo"
                },
                "metodologia.faixaEtariaEnum": {
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();

$(function () {
    escola.init();
});

var escola = {
    persist: function () {
        $.ajax({
            type: "POST",
            url: "persistMetodologiaJson",
            data: {
                "metodologia.id": $("[name='metodologia.id']").val(),
                "escola.id": $("[name='escola.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            if (json.jsonReturn.success){
                notify.success("Sucesso", json.jsonReturn.mensagem);
                escola.list();
            }else{
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
            url: "listMetodologiaEscola",
            data: {
                "metodologia.id": $("[name='metodologia.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            var html = "";
            $.each(json.metodologia.escolas, function (index, value) {
                html += "<tr>";
                html += "<td>" + value.nome + "</td>";
                html += "<td class='text-right'>";
                html += '<a class="btn btn-danger btn-xs" onclick="escola.remove(' + value.id + ');"><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });
            $("#tEscola tbody").html(html);

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
                url: "deleteMetodologiaEscola",
                data: {
                    "metodologia.id": $("[name='metodologia.id']").val(),
                    "escola.id": id
                },
                dataType: "json"
            })
                    .done(function (json) {

                        notify.success("Sucesso", "Registro deletado com sucesso    ");

                        escola.list();

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

