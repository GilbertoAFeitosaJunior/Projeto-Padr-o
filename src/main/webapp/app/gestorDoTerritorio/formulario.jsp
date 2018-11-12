<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistGestorDoTerritorio" theme="simple" enctype="multipart/form-data">
        <s:hidden name="gestorDoTerritorio.usuario.id" />

        <section class="panel">
            <header class="panel-heading">
                Salvar Gestor Do Territorio
                <span class="tools pull-right">
                    <a href="javascript:;" class="fa fa-chevron-down"></a>
                </span>
            </header>

            <div class="panel-body">
                <s:hidden name="gestorDoTerritorio.id" />
                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <div>
                                <s:textfield name="gestorDoTerritorio.nome" id="gestorDoTerritorio.nome" maxlength="100" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </section>

        <section class="panel">
            <header class="panel-heading">
                Dados para o Login
                <span class="tools pull-right">
                    <a href="javascript:;" class="fa fa-chevron-down"></a>
                </span>
            </header>
            <div class="panel-body">
                <s:hidden name="usuario.id" />
                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Situacão:</label>
                            <s:select name="gestorDoTerritorio.usuario.ativo" id="gestorDoTerritorio.usuario.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true"/>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="form-group">                      
                            <label>Nome de Usuário:</label>
                            <s:textfield name="gestorDoTerritorio.usuario.nome" id="gestorDoTerritorio.usuario.nome" maxlength="100" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>E-mail:</label>
                            <s:textfield name="gestorDoTerritorio.usuario.email" id="gestorDoTerritorio.usuario.email" type="email" placeholder="O usuário precisa ser um email" maxlength="100" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Senha:</label>
                            <s:password name="gestorDoTerritorio.usuario.senha" id="gestorDoTerritorio.usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listGestorDoTerritorio'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>
    </section>



    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../gestorDoTerritorio/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>