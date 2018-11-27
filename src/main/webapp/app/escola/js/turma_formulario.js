$().ready(function () {
    turma.list();
    $("#formTurma").validate({
        messages: {
            "turma.nome": {
                required: "Favor preencher esse campo"
            }
        },
        submitHandler: function(form){
            turma.persist();
        }
    });
});

var turma = {
  
  persist: function(){
         $.ajax({
            type: "POST",
            url: "persistTurmaJson",
            dataType: "json",
            data: {
                "turma.nome": $("[name='turma.nome']").val(),
                "escola.id": $("[name='escola.id']").val()
            }
        }).done(function (json) {
            if (json.jsonReturn.success){
                notify.success("Sucesso", json.jsonReturn.mensagem);
                turma.list();
            }
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    },
    list: function () {
        $.ajax({
            type: "POST",
            url: "listTurmaJson",
            data: {
                "escola.id": $("[name='escola.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
            if(json.turmas !== null){
                var html = "";
                $.each(json.turmas, function (index, value) {
                    html += "<tr>";
                    html += "<td>" + value.nome + "</td>";
                    html += "<td class='text-right'>";
                    html += '<a class="btn btn-danger btn-xs" onclick="turma.remove(' + value.id + ');"><i class="fa fa-trash-o "></i></a>';
                    html += "</td>";
                    html += "</tr>";
                });
                $("#tTurma tbody").html(html);
            }

        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {
        });
    },
    remove: function (id) {
        if (confirm("Deseja excluir esse registro?")) {
            $.ajax({
                type: "POST",
                url: "deleteTurmaJson",
                dataType: "json",
                data: {
                    "turma.id": id
                }
            }).done(function (json) {
                notify.success("Sucesso", "Registro deletado com sucesso    ");
                turma.list();
            }).fail(function () {
                notify.error("Erro", "Impossível de estabelecer conexão servidor");
            }).always(function () {
            });
        }
    }
    
};

