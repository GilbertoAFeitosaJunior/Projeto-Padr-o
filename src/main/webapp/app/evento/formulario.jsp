<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>


<%@include file="../fragment/head.jsp" %>

<section class="panel">
    <header class="panel-heading">
        Salvar Evento
    </header>

    <div class="panel-body">
        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEvento" theme="simple" enctype="multipart/form-data">
            <s:hidden name="evento.id" />


            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label>Título:</label>
                        <div>
                            <s:textfield name="evento.titulo" id="evento.titulo" type="text" maxlength="100" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Tipo de evento:</label>
                        <div>
                            <s:select name="evento.tipoEvento" id="evento.tipoEvento" cssClass="form-control" list="tipoEventos" listKey="id" listValue="nome" emptyOption="true" required="true"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Início do Evento:</label>
                        <div class="input-group m-bot15 right date default-datetime-picker">
                            <s:textfield name="evento.inicioEvento" id="evento.inicioEvento" readonly="true" required="true" cssClass="form-control" value="%{getText('format.dateLong', {evento.inicioEvento})}" />
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-danger date-set"><i class="fa fa-calendar"></i></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Início do fim:</label>
                        <div class="input-group m-bot15 right date default-datetime-picker">
                            <s:textfield name="evento.inicioEvento" id="evento.inicioEvento" readonly="true" required="true" cssClass="form-control" value="%{getText('format.dateLong', {evento.inicioEvento})}" />
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-danger date-set"><i class="fa fa-calendar"></i></button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Valor:</label>
                        <div>
                            <s:textfield name="evento.valor" id="evento.valor" type="text" maxlength="100" cssClass="form-control money text-right" required="true"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>palestrante:</label>
                        <div>
                            <s:textfield name="evento.palestrante" id="evento.palestrante" type="text" maxlength="100" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label>Descricao:</label>
                        <div>
                            <s:textarea name="evento.palestrante" id="evento.palestrante"  rows="5" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-9">
                    <div class="form-group">
                        <label>Logradouro:</label>
                        <div>
                            <s:textfield name="evento.logradouro" id="evento.logradouro"  cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Número:</label>
                        <div>
                            <s:textfield name="evento.numero" id="cliente.numero" cssClass="form-control"  required="true" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Bairro:</label>
                        <div>
                            <s:textfield name="evento.bairro" id="cliente.bairro"  cssClass="form-control"  required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Cidade:</label>
                        <div>
                            <s:textfield name="evento.cidade" id="cliente.cidade"  cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label>País:</label>
                            <div>
                                <s:textfield name="evento.pais" id="cliente.pais" cssClass="form-control"  />
                            </div>
                        </div>
                    </div>             
                </div>
                <div class="col-lg-2">
                    <div class="form-group">
                        <label>UF:</label>
                        <div>
                            <s:textfield name="evento.uf" id="cliente.uf"  cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label>Complemento:</label>
                        <div>
                            <s:textfield name="evento.complemento" id="cliente.complemento" cssClass="form-control"  />
                        </div>
                    </div>
                </div>             
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label>Ponto  de Referência:</label>
                        <div>
                            <s:textarea name="evento.pontoReferencia" id="evento.pontoReferencia"  rows="5" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Data limite de compra:</label>
                        <div class="input-group m-bot15 right date default-datetime-picker">
                            <s:textfield name="evento.dataLimiteCompra" id="evento.dataLimiteCompra" readonly="true" required="true" cssClass="form-control" value="%{getText('format.dateLong', {evento.inicioEvento})}" />
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-danger date-set"><i class="fa fa-calendar"></i></button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listEvento'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>

    </div>
</section>

<%@include file="../fragment/endpage.jsp" %>
<link rel="stylesheet" type="text/css" href="../assets/bootstrap-datetimepicker/css/datetimepicker.css" />


<script type="text/javascript" src="../assets/jquery-maskmoney/dist/jquery.maskMoney.min.js"></script>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../evento/js/script.js"></script>
<script type="text/javascript">
                    $(function () {
                        $("html").niceScroll().remove();

                        $(".default-datetime-picker").datetimepicker({
                            format: 'dd/mm/yyyy hh:ii',
                            autoclose: true,
                            todayBtn: true,
                            pickerPosition: "bottom-left"
                        });
                    });
</script>
<%@include file="../fragment/truend.jsp" %>
