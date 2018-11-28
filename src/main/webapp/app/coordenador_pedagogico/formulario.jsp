<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<!--compress:html compressCss="true"-->

    <%@include file="../fragment/head.jsp" %>

    <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistCoordenadorPedagogico" theme="simple" enctype="multipart/form-data">
    <section class="panel">
        <header class="panel-heading">
            Salvar Coordenador Pedagógico
             <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
            </span>
        </header>
        <div class="panel-body">
                
                <s:hidden name="coordenadorPedagogico.id" />
                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Nome</label>
                                <s:textfield name="coordenadorPedagogico.nome" id="coordenadorPedagogico.nome" maxlength="100" cssClass="form-control" required="true" />
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
        <s:hidden name="coordenadorPedagogico.usuario.id" />
        <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Situacão</label>
                                <s:select name="coordenadorPedagogico.usuario.ativo" id="coordenadorPedagogico.usuario.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true" />
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="form-group">                      
                            <label>Nome de Usuário</label>
                                <s:textfield name="coordenadorPedagogico.usuario.nome" id="coordenadorPedagogico.usuario.nome" maxlength="100" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>E-mail</label>
                                <s:textfield name="coordenadorPedagogico.usuario.email" id="coordenadorPedagogico.usuario.email" type="email" placeholder="O Coordenador Pedagógico precisa ter um email" maxlength="100" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Senha</label>
                            <s:if test="coordenadorPedagogico == null" >
                                <s:password name="coordenadorPedagogico.usuario.senha" id="coordenadorPedagogico.usuario.senha" placeholder="" maxlength="32" cssClass="form-control" required="true"/>
                            </s:if>
                            <s:else>
                                <s:password name="coordenadorPedagogico.usuario.senha" id="coordenadorPedagogico.usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control" />
                            </s:else>
                        </div>
                    </div>
                </div>
                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listCoordenadorPedagogico'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </div>
    </section>
</s:form>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../coordenador_pedagogico/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

<!--/compress:html-->