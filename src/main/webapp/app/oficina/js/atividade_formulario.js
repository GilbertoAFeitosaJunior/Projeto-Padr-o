 $(function(){
    atividades.list(); 
 });
 
 var atividades = {
 
 persistOficinaAtividade: function(){
        $.ajax({
            type: "POST",
            url: "persistOficinaAtividadeJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.id']").val(),
                "atividade.id": $("[name='oficina.atividade.id']").val()
            },
        }).done(function (json) {
            if (json.jsonReturn.success){
                notify.success("Sucesso", json.jsonReturn.mensagem);
                atividades.list();
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
            url: "listOficinaAtividadeJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.id']").val()
            }
        }).done(function (json) {
            var html = "";
            $.each(json.oficina.atividades, function (index, value) {
                console.log(json.oficina.atividades.nome);
                html += "<tr>";
                html += "<td>" + value.nome + "</td>";
                html += "<td class='text-right'>";
                html += '<a class="btn btn-danger btn-xs" onclick="atividades.remove(' + value.id + ');"><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });
            $("#tAtividades tbody").html(html);

        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {
        });
    },
    
    remove: function (id) {
        if (confirm("Deseja excluir esse registro?")) {
            $.ajax({
                type: "POST",
                url: "deleteOficinaAtividadeJson",
                dataType: "json",
                data: {
                    "oficina.id": $("[name='oficina.id']").val(),
                    "atividade.id": id
                }
            }).done(function (json) {
                notify.success("Sucesso", "Registro deletado com sucesso    ");
                atividades.list();
            }).fail(function () {
                notify.error("Erro", "Impossível de estabelecer conexão servidor");
            }).always(function () {
            });
        }
    }
 }


