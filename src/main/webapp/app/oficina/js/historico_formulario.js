

var historico = {
    
    persist: function(){
          $.ajax({
            type: "POST",
            url: "persistOficinaHistoricoJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.id']").val(),
                "oficina.historico": $("[name='oficinaHistorico']").val()
            },
        }).done(function (json) {
                $("[name='oficina.historico']").val(json.oficina.historico);
                notify.success("Sucesso");
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    }
};