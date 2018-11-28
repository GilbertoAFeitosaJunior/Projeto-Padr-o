<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Usu&aacute;rio
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistUsuarioGeral" theme="simple" enctype="multipart/form-data">
                <s:hidden name="usuario.id" />

                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Situacão:</label>
                                <s:select name="usuario.ativo" id="usuario.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true"/>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="form-group">                      
                            <label>Nome:</label>
                                <s:textfield name="usuario.nome" id="usuario.nome" maxlength="100" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>E-mail:</label>
                            <div>
                                <s:textfield name="usuario.email" id="usuario.email" type="email" placeholder="O usuário precisa ter um email" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Senha:</label>
                            <div>
                                <s:password name="usuario.senha" id="usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listUsuarioGeral'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../usuario/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>
