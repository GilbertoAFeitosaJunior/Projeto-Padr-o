var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "pessoa.nome": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.sexoEnum": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.generoEnum": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.bairro": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.cidade": {
                    required: "Favor preencher esse campo"
                },
                "pessoa.uf": {
                    required: "Favor preencher esse campo"
                },
                "escola.id":{
                    required: "Favor preencher esse campo"
                },
                "pessoa.turma.id":{
                    required: "Favor preencher esse campo"
                }
            }
        });
    });
}();

var pessoa = {
    carregarTurma: function(){
        $.ajax({
            type: "POST",
            url: "listPessoaTurmaJson",
            dataType: "json",
            data: {
                "escola.id": $("[name='escola.id']").val()
            }
        }).done(function (json) {
            var opcoes =  ""; 
            $.each(json.turmas, function(index, value){
                opcoes += '<option value="'+value.id+'">'+value.nome+'</option>'; 
            });
            $("#turmaid").html(opcoes);
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
        });
    }
};
