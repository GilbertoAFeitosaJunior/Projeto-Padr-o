var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "oficina.educador.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.atividade.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.escola.id": {
                    required: "Favor preencher esse campo"
                },
                "oficina.situacaoEnum": {
                    required: "Favor preencher esse campo"
                },
                "oficina.turnoEnum": {
                    required: "Favor preencher esse campo"
                },
                "oficina.dataPlanejada": {
                    required: "Favor preencher esse campo"
                }
            },
            submitHandler: function(form){
                oficina.persistSomenteOficina();
                $('#tab-atividade').popover('disable');
                $('#tab-historico').popover('disable');
                $('#tab-anexo').popover('disable');
                oficina.desbloquear('tab-atividade-link');
                oficina.desbloquear('tab-historico-link');
                oficina.desbloquear('tab-anexo-link');
                oficina.passo('tab-oficina','tab-atividade');
            }
        });
    });
}();

var oficina = {
    
    desbloquear: function(IdDaAba){
        var jVelha = "#";
        $(jVelha.concat(IdDaAba)).attr({"data-toggle":"tab"});
    },
    
    passo: function( ClasseDaAbaAtual , ClasseDaProximaAba){
        var ponto = ".";
        $(ponto.concat(ClasseDaAbaAtual)).removeClass("active");
        $(ponto.concat(ClasseDaProximaAba)).addClass("active");
    },
    
    persistSomenteOficina: function () {
        $.ajax({
            type: "POST",
            url: "persistOficinaJson",
            dataType: "json",
            data: {
                "oficina.id": $("[name='oficina.id']").val(),
                "oficina.escola.id": $("[name='oficina.escola.id']").val(),
                "oficina.turnoEnum":$("[name='oficina.turnoEnum']").val(),
                "oficina.situacaoEnum":$("[name='oficina.situacaoEnum']").val(),
                "oficina.dataPlanejada":$("[name='oficina.dataPlanejada']").val(),
                "oficina.dataRealizada":$("[name='oficina.dataRealizada']").val()
            },
        }).done(function (json) {
            if (json.jsonReturn.success){
                $("[name='oficina.id']").val(json.id);
                notify.success("Sucesso", json.jsonReturn.mensagem);
            }else{
                if(!json.jsonReturn.sucess){
                    notify.error("Erro", json.jsonReturn.mensagem);
                }
            }
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    }
    
};