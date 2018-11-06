
var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "metodologia.nome": {
                    required: "Favor preencher esse campo"
                }
//                ,
//                "metodologia.aplicabilidadeEnum": {
//                    required: "Favor preencher esse campo"
//                },
//                "metodologia.descricao": {
//                    required: "Favor preencher esse campo"
//                },
//                "metodologia.ativo": {
//                    required: "Favor preencher esse campo"
//                }
            }
        });
    });
}();

 var escola = {
     
     persist: function (){
          $.ajax({
            type: "POST",
            url: "persistMetodologiaJson",
            data: {
                "metodologia.id": $("[name='metodologia.id']").val(),
                "escola.id": $("[name='escola.id']").val()
            },
            dataType: "json"
        }).done(function (json) {
        escola.list();        
        notify.success("Sucesso", "Salvo com sucesso");
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
            "escola.id": $("[name='escola.id']").val()
            },
            dataType: "json"
        }).done(function (json) {

            var html = "";
            $.each(json.escolas, function (index, value) {
                html += "<tr>";   
                html += "<td>" + escola.nome + "</td>"
                html += "<td>" + escola.projeto.nome + "</td>"
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
    }
     
     
 };

