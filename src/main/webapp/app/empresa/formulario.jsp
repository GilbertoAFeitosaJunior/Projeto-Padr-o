<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Diretor de Sala
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEmpresa" theme="simple" enctype="multipart/form-data">
                <s:hidden name="empresa.id" />


                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Razao social</label>
                            <div>
                                <s:textfield name="empresa.razaoSocial" id="manager.razaoSocial" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Nome fantasia:</label>
                            <div>
                                <s:textfield name="empresa.nomeFantasia" id="empresa.nomeFantasia" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>CNPJ:</label>
                            <div>
                                <s:textfield name="empresa.cnpj" id="empresa.cnpj" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>DDD:</label>
                            <div>
                                <s:textfield name="empresa.ddd" id="empresa.ddd" maxlength="2" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>                
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Telefone:</label>
                            <div>
                                <s:textfield name="empresa.telefone" id="empresa.telefone"  maxlength="9" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div> 
                </div>
                <div class="row">
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>DDD:</label>
                            <div>
                                <s:textfield name="empresa.ddd" id="empresa.ddd" maxlength="2" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>                
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Celular:</label>
                            <div>
                                <s:textfield name="empresa.celular" id="empresa.celular"  maxlength="9" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div> 
                </div>

                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listManager'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../manager/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>