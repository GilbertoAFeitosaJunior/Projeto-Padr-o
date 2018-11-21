 
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
    }
 }


