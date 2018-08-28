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
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistUsuario" theme="simple" enctype="multipart/form-data">
                <s:hidden name="usuario.id" />

                <div class="form-group">
                    <label>CPF:</label>
                    <div>
                        <s:textfield name="usuario.cpjStringMask" id="usuario.cpjStringMask" data-mask="999.999.999-99" maxlength="100" cssClass="form-control" required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label>E-mail:</label>
                    <div>
                        <s:textfield name="usuario.email" id="usuario.email" type="email" placeholder="O usuário precisa ser um email" maxlength="100" cssClass="form-control" required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label>Senha:</label>
                    <div>
                        <s:password name="usuario.senha" id="usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control" required="true"/>
                    </div>
                </div>


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listUsuario'">Cancelar</button>
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