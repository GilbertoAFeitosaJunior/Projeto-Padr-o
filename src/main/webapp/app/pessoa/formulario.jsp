<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Pessoa
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistPessoa" theme="simple" enctype="multipart/form-data">
                <s:hidden name="pessoa.id" />

                <div class="row">
                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <s:textfield name="pessoa.nome" id="pessoa.nome" cssClass="form-control" required="true"/>
                        </div>
                    </div>        

                    <div class="col-lg-2">
                        <div class="form-group">                      
                            <label>Sexo:</label>
                            <s:select name="pessoa.sexoEnum" id="pessoa.sexoEnum" cssClass="form-control"    list="sexoEnums" listValue="name" emptyOption="true" required="true"/>
                        </div>
                    </div> 
                    <div class="col-lg-2">
                        <div class="form-group">                      
                            <label>Gênero:</label>
                            <s:select name="pessoa.generoEnum" id="pessoa.generoEnum" cssClass="form-control" list="generoEnums" listValue="name" emptyOption="true" required="true" />
                        </div>
                    </div>      
                </div>

                <div class="row">        
                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Nome do Pai:</label>
                            <s:textfield name="pessoa.pai" id="pessoa.pai" maxlength="100" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Nome da Mãe:</label>
                            <s:textfield name="pessoa.mae" id="pessoa.mae" maxlength="100" cssClass="form-control" />
                        </div>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-lg-1">
                        <div class="form-group">
                            <label>UF</label>
                            <s:textfield name="pessoa.uf" id="pessoa.uf" maxlength="2" cssClass="form-control" required="true" />
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>Cidade</label>
                            <s:textfield name="pessoa.cidade" id="pessoa.cidade" maxlength="50" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="form-group">
                            <label>Bairro</label>
                            <s:textfield name="pessoa.bairro" id="pessoa.bairro" maxlength="50" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>Escola</label>
                            <s:select name="escola.id" id="escolaid" list="escolas" listValue="nome" listKey="id" cssClass="form-control" emptyOption="true" required="true"/>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div id="select" class="form-group">
                            <label>Turma</label>
                            <s:if test="pessoa == null">
                                <select name="pessoa.turma.id" id="turmaid" class="form-control" required="true">
                                    <option value="">Selecione uma Escola pra carregar as Turmas</option>
                                </select>
                            </s:if><s:else>
                                <s:select name="pessoa.turma.id" id="turmaid" list="turmas" class="form-control"  listValue="nome" required="true"/>
                            </s:else>
                        </div>
                    </div>

                </div>


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listPessoa'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../pessoa/js/script.js"></script>
    <script>
        $().ready(function(){
           $("#escolaid").on("change", function(){
               pessoa.carregarTurma();
           }); 
        });
    </script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>