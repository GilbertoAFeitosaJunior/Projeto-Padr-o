<%-- 
    Document   : formulario
    Created on : 27/11/2018, 12:06:30
    Author     : Rafael Bloise
--%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Parceira
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistParceira" theme="simple" enctype="multipart/form-data">
                <s:hidden name="parceira.id" />




                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <div>
                                <s:textfield name="parceira.nome" id="parceira.nome" maxlength="255" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Situação Parceira</label>
                            <div>
                                <s:select name="parceira.situacaoParceiraEnum" id="parceira.situacaoParceiraEnum" cssClass="form-control"    list="situacaoParceiraEnums" listValue="name" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>CNPJ</label>
                            <div>
                                <s:textfield type="text" name="parceira.cnpjStringMask" id="parceira.cnpjStringMask" cssClass="form-control" maxlength="100" data-mask="99.999.999/9999-99" required="true" />
                            </div>
                        </div>
                    </div>

                </div>



                <div class="row">
                    <div class="col-lg-10">
                        <div class="form-group">
                            <label>Logradouro</label>
                            <s:textfield name="parceira.logradouro" id="parceira.logradouro" cssClass="form-control" required="true" maxlength="100"/> 
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>Número</label>
                            <s:textfield name="parceira.numero" id="parceira.numero" cssClass="form-control" required="true" maxlength="10"/>
                        </div>
                    </div>
                </div>
                <div class="row" >
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>Complemento</label>
                            <s:textfield type="text" name="parceira.complemento" id="parceira.complemento" cssClass="form-control" maxlength="100" required="true" />
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label>Bairro</label>
                            <s:textfield type="text" name="parceira.bairro" id="parceira.bairro" cssClass="form-control" required="true" maxlength="50" />
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>Cidade</label>
                            <s:textfield type="text" name="parceira.cidade" id="parceira.cidade" cssClass="form-control" required="true" maxlength="50" />
                        </div>
                    </div>
                    <div class="col-lg-1">
                        <div class="form-group">
                            <label>UF</label>
                            <s:textfield type="text" name="parceira.uf" id="parceira.uf" cssClass="form-control" required="true" maxlength="2"/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Responsável Legal</label>
                            <div>
                                <s:textfield name="parceira.responsavelLegal" id="parceira.responsavelLegal" maxlength="100" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Responsável Legal Contato</label>
                            <div>
                                <s:textfield type="text" name="parceira.responsavelLegalContatoStringMask" id="parceira.responsavelLegalContatoStringMask" data-mask="99999-9999" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>



                <div class="row">

                    <div class="col-lg-6">
                        <div class="form-group">                      
                            <label>Responsável Principal</label>
                            <div>
                                <s:textfield name="parceira.responsavelPrincipal" id="parceira.responsavelPrincipal" maxlength="100" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Responsável Principal Contato</label>
                            <div>
                                <s:textfield type="text" name="parceira.responsavelPrincipalContatoStringMask" id="parceira.responsavelPrincipalContatoStringMask" data-mask="99999-9999" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>

            </div>  


            <div class="row">


            </div>

            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listParceira'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>

    </div>
</section>

<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../parceira/js/script.js"></script>
<%@include file="../fragment/truend.jsp" %>

</compress:html>
