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
                <s:hidden name="usuario.id" />
                <s:hidden name="usuario.empresa.id" />


                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Razao social</label>
                            <div>
                                <s:textfield name="usuario.empresa.razaoSocial" id="usuario.manager.razaoSocial" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Nome fantasia:</label>
                            <div>
                                <s:textfield name="usuario.empresa.nomeFantasia" id="usuario.empresa.nomeFantasia" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>CNPJ:</label>
                            <div>
                                <s:textfield name="usuario.empresa.cnpjStringMask" id="usuario.empresa.cnpjStringMask" type="text" data-mask="99.999.999/9999-99" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>DDD:</label>
                            <div>
                                <s:textfield name="usuario.empresa.dddTelefone" id="usuario.empresa.dddTelefone" maxlength="2" cssClass="form-control" />
                            </div>
                        </div>
                    </div>                
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Telefone:</label>
                            <div>
                                <s:textfield name="usuario.empresa.telefone" id="usuario.empresa.telefone"  maxlength="9" cssClass="form-control" />
                            </div>
                        </div>
                    </div> 
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>DDD:</label>
                            <div>
                                <s:textfield name="usuario.empresa.dddCelular" id="usuario.empresa.dddCelular" maxlength="2" cssClass="form-control"/>
                            </div>
                        </div>
                    </div>                
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Celular:</label>
                            <div>
                                <s:textfield name="usuario.empresa.celular" id="usuario.empresa.celular"  maxlength="9" cssClass="form-control" />
                            </div>
                        </div>
                    </div> 
                </div>

                <div class="row">
                    <div class="col-lg-8">
                        <div class="form-group">
                            <label>E-mail:</label>
                            <div>
                                <s:textfield name="usuario.email" id="usuario.nome" type="email" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label>Senha:</label>
                            <div>
                                <s:password name="usuario.senha" id="usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listEmpresa'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../empresa/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>