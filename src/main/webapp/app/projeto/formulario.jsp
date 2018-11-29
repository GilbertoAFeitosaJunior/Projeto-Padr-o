<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Projeto
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistProjeto" theme="simple" enctype="multipart/form-data">
                <s:hidden name="projeto.id" />


                <div class="row">

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Secretaria</label>
                            <div>
                                <s:select name="projeto.secretaria.id" id="projeto.secretaria.id" cssClass="form-control" list="secretarias" listKey="id" listValue="nome" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>        




                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Coordenador de Projeto</label>
                            <div>
                                <s:select name="projeto.coordenadorDeProjeto.id" id="projeto.coordenadorDeProjeto.id" cssClass="form-control"    list="coordenadorDeProjetos" listKey="id" listValue="nome" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>     



                </div>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Situação do Projeto</label>
                            <div>
                                <s:select name="projeto.situacaoProjetoEnum" id="projeto.situacaoProjetoEnum" cssClass="form-control" list="situacaoProjetoEnums" listValue="name" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Modo de Implementação</label>
                            <div>
                                <s:select name="projeto.modoDeImplementacaoEnum" id="projeto.modoDeImplementacaoEnum" cssClass="form-control"    list="modoDeImplementacaoEnums" listValue="name" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>            

                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Nome</label>
                            <div>
                                <s:textfield name="projeto.nome" id="projeto.nome" maxlength="255" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">        
                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Reponsável</label>
                            <div>
                                <s:textfield name="projeto.responsavel" id="projeto.responsavel" maxlength="100" cssClass="form-control" />
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Parceira</label>
                            <div>
                                <s:select name="projeto.parceira.id" id="projeto.parceira.id" cssClass="form-control" list="parceiras" listKey="id" listValue="nome" emptyOption="true" />
                            </div>
                        </div>
                    </div>        

                </div>        

                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Dados Contato</label>
                            <div>
                                <s:textarea name="projeto.dadosContato" id="projeto.dadosContato" cssClass="form-control" />
                            </div>
                        </div>
                    </div>
                </div>            


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listProjeto'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>



    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../projeto/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>