<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Tipo de Evento
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistTipoEvento" theme="simple" enctype="multipart/form-data">
                <s:hidden name="tipoEvento.id" />


                <div class="form-group">
                    <label>Nome:</label>
                    <div>
                        <s:textfield name="tipoEvento.nome" id="tipoEvento.nome" type="text" maxlength="100" cssClass="form-control" required="true"/>
                    </div>
                </div>

              

                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listTipoEvento'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../tipo_evento/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>