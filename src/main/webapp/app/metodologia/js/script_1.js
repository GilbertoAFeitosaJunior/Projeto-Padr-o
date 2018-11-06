var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "motorista.nome": {
                    required: "Favor preencher esse campo"
                },
                "motorista.cnh": {
                    required: "Favor preencher esse campo"
                },
                "motorista.email": {
                    required: "Favor preencher esse campo",
                    email: "E-mail inválido"
                },
                "motorista.dataNascimento": {
                    required: "Favor preencher esse campo"
                },
                "motorista.firebaseld": {
                    required: "Favor preencher esse campo"
                },
                "motorista.push": {
                    required: "Favor preencher esse campo"
                },
                "motorista.senha": {
                    required: "Favor preencher esse campo"
                }

            }
        });
    });
}();

$(function () {
    veiculo.init();
});

veiculo = {
    
    init: function () {
        this.list();
    },
    persist: function () {
        $.ajax({
            type: "POST",
            url: "persistVeiculo",
            data: {
                "veiculo.id": $("#id").val(),
                "veiculo.placa": $("#placa").val(),
                "veiculo.anoFabricacao": $("#anoFabricacao").val(),
                "veiculo.documentoVeiculo": $("#documentoVeiculo").val(),
                "veiculo.anoModelo": $("#anoModelo").val(),
                "veiculo.modelo.id": $("#modelo").val(),
                "veiculo.cor.id": $("#cor").val()
            },
            dataType: "json"
        }).done(function (json) {
            $("#novoVeiculoModal").modal('hide');
            veiculo.list();
            notify.success("Sucesso", "O veiculo foi salvo com sucesso!");
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar salvar o registro, favor tente novamente.");
        }).always(function () {
            this.list();
        });
    },
    list: function () {
        $.ajax({
            type: "POST",
            url: "listarTeste",
            data: {
            },
            dataType: "json"
        }).done(function (json) {

            var html = "";
            $.each(json.veiculos, function (index, value) {
                html += "<tr>";   
                html += "<td>" + value.placa + "</td>"
                html += "<td class='text-right'>";
                html += '<a class="btn btn-primary btn-xs" onclick="veiculo.edit(' + value.id + ');"><i class="fa fa-pencil"></i></a> ';
                html += '<a class="btn btn-danger btn-xs" onclick="veiculo.remove(' + value.id + ');"><i class="fa fa-trash-o "></i></a>';
                html += "</td>";
                html += "</tr>";
            });
            $("#tVeiculo tbody").html(html);

        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {

        });
    },
    edit: function (id) {
        $.ajax({
            type: "POST",
            url: "prepareVeiculo",
            data: {
                "veiculo.id": id
            },
            dataType: "json"
        }).done(function (json) {

            //console.log(json.veiculo);
            //["#veiculoId", "#placa", "#anoFabricacao", "#documentoVeiculo", "#anoModelo"];
            //["#veiculoId", "#modeloId", "#corId", "#consultorNome", "#uploadConsultor", "#consultorEmail", "#consutlorSenha", "#consultorCPF"];
            $("#id").val(json.veiculo.id);
            $("#placa").val(json.veiculo.placa);
            $("#anoFabricacao").val(json.veiculo.anoFabricacao);
            $("#documentoVeiculo").val(json.veiculo.documentoVeiculo);
            $("#anoModelo").val(json.veiculo.anoModelo);

            $("#novoVeiculoModal").modal('show');
        }).fail(function () {
            notify.error("Erro", "Erro ao abrir o formulário de edição. Favor tente novamente.");
        }).always(function () {
        });
    },
    remove: function (id) {
        $.ajax({
            type: "POST",
            url: "deleteVeiculo",
            data: {
                "veiculo.id": id          
            },
            dataType: "json"
        }).done(function (json) {
            veiculo.list();
            notify.success("Sucesso", "Registro excluído com sucesso!");
        }).fail(function () {
            notify.error("Erro", "Erro ao tentar excluir o registro, favor tente novamente.");
        }).always(function () {
        });
    }
}

