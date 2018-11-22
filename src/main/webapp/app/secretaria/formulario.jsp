<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Secretaria
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistSecretaria" theme="simple" enctype="multipart/form-data">
                <s:hidden name="secretaria.id" />




                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <div>
                                <s:textfield name="secretaria.nome" id="secretaria.nome" maxlength="100" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Gestor do Território</label>
                            <div>
                                <s:select name="secretaria.gestorDoTerritorio.id" id="secretaria.gestorDoTerritorio.id" list="gestorDoTerritorios" listKey="id" listValue="nome" emptyOption="true" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Coordenador Pedagógico</label>
                            <div>
                                <s:select name="secretaria.coordenadorPedagogico.id" id="secretaria.coordenadorPedagogico.id" list="coordenadorPedagogicos" listKey="id" listValue="nome" emptyOption="true" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>        

                    <div class="col-lg-1">
                        <div class="form-group">                      
                            <label>UF</label>
                            <div>
                                <s:textfield name="secretaria.uf" id="secretaria.uf" maxlength="2" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                            
                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Nível da Secretaria</label>
                            <div>
                                <s:select name="secretaria.nivelSecretariaEnum" id="secretaria.nivelSecretariaEnum" cssClass="form-control"    list="nivelSecretariaEnums" listValue="name" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>   
                            
                </div>

                <div class="row">


                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Município</label>
                            <div>
                                <s:textfield name="secretaria.municipio" id="secretaria.municipio" maxlength="255" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                            
                    <div class="col-lg-5">
                    <div class="form-group">                      
                        <label>Responsável</label>
                        <div>
                            <s:textfield name="secretaria.responsavel" id="secretaria.responsavel" maxlength="100" cssClass="form-control" required="true" />
                        </div>
                    </div>
                    </div>
                            
                    <div class="col-lg-3">
                        <div class="form-group">                      
                            <label>Contato do Responsável</label>
                            <div>
                                <s:textfield type="text" name="secretaria.responsavelContatoStringMask" id="secretaria.responsavelContatoStringMask" cssClass="form-control" required="true" data-mask="99999-9999" /> 
                            </div>
                        </div>
                    </div>
                            
                </div>  


                <div class="row">
                        
                        
                </div>

                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listSecretaria'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../secretaria/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>