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
                }
            }
        });
    });
}();