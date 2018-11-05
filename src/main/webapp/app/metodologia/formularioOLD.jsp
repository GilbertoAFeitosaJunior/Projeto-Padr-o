<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Metodologia
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistMetodologia" theme="simple" enctype="multipart/form-data">
                <s:hidden name="metodologia.id" />



                <div class="row">

                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <div>
                                <s:textfield name="metodologia.nome" id="metodologia.nome" cssClass="form-control" list="secretarias" listKey="id" listValue="nome" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>        


                    <div class="col-lg-4">
                        <div class="form-group">                      
                            <label>Aplicabilidade da Metodologia:   </label>
                            <div>
                                <s:select name="metodologia.aplicabilidadeEnum" id="metodologia.aplicabilidadeEnum" cssClass="form-control"    list="aplicabilidadeEnums" listValue="name" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>          

                </div>

                <div class="row">
<!--                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Nome:</label>
                            <div>
                                <s:textfield name="metodologia.nome" id="metodologia.nome" maxlength="255" cssClass="form-control" required="true" />
                            </div>
                        </div>
                    </div>
                </div>-->


                <div class="row">        
                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Descrição:</label>
                            <div>
                                <s:textfield name="metodologia.descricao" id="metodologia.descricao" cssClass="form-control" />
                            </div>
                        </div>
                    </div>
                </div>        

                <div class="row">
                    <div class="col-lg-8">
                        <div class="form-group">                      
                            <label>Situação:</label>
                            <div>
                                <s:select name="metodologia.ativo" id="metodologia.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>            


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listMetodologia'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../metodologia/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>