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
            }else{
                if(!json.jsonReturn.sucess){
                    notify.error("Erro", json.jsonReturn.mensagem);
                }
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
            url: "listOficinaJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.atividade.id']").val()
            }
        }).done(function (json) {
            var html = "";
            $.each(json.oficina.atividades, function (index, value) {
                html += "<tr>";
                html += "<td>" + value.nome + "</td>";
                html += "<td class='text-right'>";
                html += '<a class="btn btn-danger btn-xs" onclick=""><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });
            $("#tA tbody").html(html);

        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {
        });
    }
 }


