$(function () {
    $(".money").maskMoney({
        thousands: "",
        allowZero: true
    });
});

var Script = function () {
    $().ready(function () {
        $("#form").validate({
            messages: {
                "evento.titulo": {
                    required: "Favor preencher esse campo"
                },
                "evento.tipoEvento.id": {
                    required: "Favor preencher esse campo"
                },
                "evento.valor": {
                    required: "Favor preencher esse campo"
                },
                "evento.palestrante": {
                    required: "Favor preencher esse campo"
                },
                "evento.descricao": {
                    required: "Favor preencher esse campo"
                },
                "evento.logradouro": {
                    required: "Favor preencher esse campo"
                },
                "evento.numero": {
                    required: "Favor preencher esse campo"
                },
                "evento.bairro": {
                    required: "Favor preencher esse campo"
                },
                "evento.cidade": {
                    required: "Favor preencher esse campo"
                },
                "evento.pais": {
                    required: "Favor preencher esse campo"
                },
                "evento.uf": {
                    required: "Favor preencher esse campo"
                },
                "evento.pontoReferencia": {
                    required: "Favor preencher esse campo"
                },
                "evento.dataLimiteCompra": {
                    required: "Favor preencher esse campo"
                },
                "evento.dataInicio": {
                    required: "Favor preencher esse campo"
                },
                "evento.dataFim": {
                    required: "Favor preencher esse campo"
                },
                "evento.diretorSala.id": {
                    required: "Favor preencher esse campo"
                }
               
            }
        });
    });
}();