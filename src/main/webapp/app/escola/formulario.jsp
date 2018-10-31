<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Escola
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEscola" theme="simple" enctype="multipart/form-data">
                <s:hidden name="escola.id" />

                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Projeto</label>
                            <s:select name="escola.projeto.id" id="escola.projeto.id" list="projetos" listKey="id" listValue="nome" required="true" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Nome:</label>
                                <s:textfield name="escola.nome" id="escola.nome" maxlength="255" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>

                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listEscola'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../escola/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>