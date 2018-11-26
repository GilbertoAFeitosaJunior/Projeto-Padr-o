

var historico = {
    
     confirmacaoModal : function(){
      var textoHistoricoAdicionado = $('.oficinahistorico').val();
        console.log(textoHistoricoAdicionado);
        $('#confirmacao.historico').val(textoHistoricoAdicionado);
     },
    persist: function(){
          $.ajax({
            type: "POST",
            url: "persistOficinaHistoricoJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.id']").val(),
                "oficina.historico": $("[name='oficinaHistorico']").val()
            }
        }).done(function (json) {
                var html = "";
                html += "<s:property escapeHtml='false'>"+json.oficina.historico+"</s:property>";
                $("#historicoAtual").html(html);
                notify.success("Sucesso", "Registro adicionado com sucesso.");
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    }
};