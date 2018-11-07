$(function () {
    escola.init();
});

var escola = {
    persist: function () {
        $.ajax({
            type: "POST",
            url: "persistEducadorEscolaJson",
            dataType: "json",
            data: {
                "educador.id": $("[name='educador.id']").val(),
                "escola.id": $("[name='escola.id']").val()
            },
        }).done(function (json) {
            if(json.jsonReturn.success){
                notify.success("Sucesso", json.jsonReturn.mensagem );
                escola.list();
            }else{
                notify.warning("Atenção!", json.jsonReturn.mensagem );
            }
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    },
    list: function () {
        $.ajax({
            type: "POST",
            url: "listEducadorEscolaJson",
            dataType: "json",
            data: {
                "educador.id": $("[name='educador.id']").val()
            },
        }).done(function (json) {
            var html = "";
            $.each(json.educador.escolas, function (index, value) {
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
                url: "deleteEducadorEscolaJson",
                dataType: "json",
                data: {
                    "educador.id": $("[name='educador.id']").val(),
                    "escola.id": id
                },
            }).done(function (json) {
                notify.success("Sucesso", "Registro excluído com sucesso.");
                escola.list();

            }).fail(function () {
                notify.error("Erro", "Impossível de estabelecer conexão servidor.");
            }).always(function () {
            });
        }
    }
};



