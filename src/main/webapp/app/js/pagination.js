/**
 *  Funçao cria paginação a partir de parametros em um array.
 *  JSON
 *  @param parametros JSON Object
 */
var paginate = {
    create: function (parametros) {
//    setCookie("lastSearch", JSON.stringify(parametros));

        var self = parametros.url;

        var HTML = "";
        var paginas = parseInt(parametros.paginas, 10);
        var atual = parseInt(parametros.atual, 10);

        var params = "";
        params += "&consulta.limiteResultados=" + parametros.limite;
        params += "&consulta.operador=" + parametros.operador;
        params += "&consulta.campo=" + parametros.campo;
        params += "&consulta.valor=" + escape(parametros.valor);

        if (parametros.dataIniciar !== undefined && parametros.dataInicial !== null) {
            params += "&consulta.dataInicial=" + parametros.dataInicial;
            params += "&consulta.dataFinal=" + parametros.dataFinal;
        }

        if (parametros.filtro !== undefined && parametros.filtro !== null) {
            params += parametros.filtro;
        }

        if (parametros.conversao !== undefined && parametros.conversao !== null) {
            params += "&consulta.conversao=" + parametros.conversao;
        }

        if (parametros.ordem !== undefined && parametros.ordem !== null) {
            params += "&consulta.ordem=" + parametros.ordem;
        }

        if (atual > 1) {
            var menos = atual - 1;
            var url = self + "?consulta.paginaAtual=" + menos + params;
            var url1 = self + "?consulta.paginaAtual=1" + params;
            HTML += "<li><a href=\"" + url1 + "\">Primeira</a></li><li><a href=\"" + url + "\">Anterior</a></li>";
        }
        if (atual < 9) {
            ini = 1;
            fim = 10;
        } else {
            ini = atual - 4;
            fim = atual + 4;
        }
        for (var i = 1; i <= paginas; i++) {

            if (i !== atual) {
                if ((i >= ini) && (i <= fim)) {
                    url = self + "?consulta.paginaAtual=" + i + params;
                    HTML += " <li><a  href=\"" + url + "\">" + i + "</a></li> ";
                }

            } else {
                HTML += " <li class=\"active\"><a href=\"javascript:void(0);\">" + i + "</a></li>";
            }
        }
        if (atual < paginas) {
            mais = atual + 1;
            url = self + "?consulta.paginaAtual=" + mais + params;
            url2 = self + "?consulta.paginaAtual=" + paginas + params;
            HTML += " <li><a href=\"" + url + "\">Pr&oacute;xima</a></li><li><a href=\"" + url2 + "\">&Uacute;ltima</a></li>";
        }

        $("ul#pagination").html(HTML);
    },
    simple: function (parametros) {
        var self = parametros.url;

        var HTML = "";
        var paginas = parseInt(parametros.paginas, 10);
        var atual = parseInt(parametros.atual, 10);

        var params = "";
        if (atual > 1) {
            var menos = atual - 1;
            var url = self + "?page=" + menos + params;
            var url1 = self + "?page=1" + params;
            HTML += "<li><a href=\"" + url1 + "\">Primeira</a></li><li><a href=\"" + url + "\">Anterior</a></li>";
        }
        if (atual < 9) {
            ini = 1;
            fim = 10;
        } else {
            ini = atual - 4;
            fim = atual + 4;
        }
        for (var i = 1; i <= paginas; i++) {

            if (i !== atual) {
                if ((i >= ini) && (i <= fim)) {
                    url = self + "?page=" + i + params;
                    HTML += " <li><a  href=\"" + url + "\">" + i + "</a></li> ";
                }

            } else {
                HTML += " <li class=\"active\"><a href=\"javascript:void(0);\">" + i + "</a></li>";
            }
        }
        if (atual < paginas) {
            mais = atual + 1;
            url = self + "?page=" + mais + params;
            url2 = self + "?page=" + paginas + params;
            HTML += " <li><a href=\"" + url + "\">Pr&oacute;xima</a></li><li><a href=\"" + url2 + "\">&Uacute;ltima</a></li>";
        }
        
        $("ul#pagination").html(HTML);
    }
};