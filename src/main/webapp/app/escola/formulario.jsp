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
                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Nome:</label>
                                <s:textfield name="escola.nome" id="escola.nome" maxlength="100" cssClass="form-control" required="true" />
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Projeto</label>
                            <s:select name="escola.projeto.id" id="escola.projeto.id" list="projetos" listKey="id" listValue="nome" required="true" cssClass="form-control" emptyOption="true"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-2">
                        <div class="form-group">
                        <label>CEP</label>
                        <s:textfield type="text" name="escola.cepStringMask" id="escola.cepStringMask" cssClass="form-control" data-mask="999999-999" required="true" />
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <label>Logradouro</label>
                            <s:textfield type="text" name="escola.logradouro" id="escola.logradouro" cssClass="form-control" required="true" maxlength="100"/>
                        </div>
                    </div>
                        <div class="col-lg-2">
                            <div class="form-group">
                                <label>Numero</label>
                                <s:textfield type="text" name="escola.numero" id="escola.numero" cssClass="form-control" required="true" maxlength="10" />
                            </div>
                        </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                        <label>Complemento</label>
                        <s:textfield type="text" name="escola.complemento" id="escola.complemento" cssClass="form-control" maxlength="100"/>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label>Bairro</label>
                            <s:textfield type="text" name="escola.bairro" id="escola.bairro" cssClass="form-control" required="true" maxlength="50" />
                        </div>
                    </div>
                        <div class="col-lg-2">
                            <div class="form-group">
                                <label>Cidade</label>
                                <s:textfield type="text" name="escola.cidade" id="escola.cidade" cssClass="form-control" required="true" maxlength="50" />
                            </div>
                        </div>
                        <div class="col-lg-1">
                            <div class="form-group">
                                <label>UF</label>
                                <s:textfield type="text" name="escola.uf" id="escola.uf" cssClass="form-control" required="true" maxlength="2" />
                            </div>
                        </div>
                </div>
                            <div class="row">
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <label>Nivel de Relacionamento</label>
                                        <s:select name="escola.nivelRelacionamentoEnum" id="escola.nivelRelacionamentoEnum" list="nivelRelacionamentoEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <label>Situação</label>
                                        <s:select name="escola.situacaoEnum" id="situacaoEnum" list="situacaoEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                                    </div>
                                </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>Inep</label>
                                            <s:textfield name="escola.inep" id="escola.inep" maxlength="50" cssClass="form-control" />
                                        </div>
                                    </div>
                            </div>
                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="form-group">
                                            <label>Responsável</label>
                                            <s:textfield name="escola.responsavel" id="escola.responsavel" cssClass="form-control" maxlength="100" />
                                        </div>
                                    </div>
                                        <div class="col-lg-8">
                                            <div class="form-group">
                                                <label>Contato</label>
                                                <s:textarea name="escola.responsavelContato" id="escola.responsavelContato" cssClass="form-control" />
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