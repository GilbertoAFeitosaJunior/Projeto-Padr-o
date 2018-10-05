<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../fragment/head.jsp" %>

<section class="panel">
    <header class="panel-heading">
        Salvar Evento
    </header>

    <div class="panel-body">
        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEvento" theme="simple" enctype="multipart/form-data">
            <s:hidden name="evento.id" />
            <s:hidden name="evento.situacaoFechamentoEnum" />

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
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Tipo de evento:</label>
                                <div>
                                    <s:select name="evento.tipoEvento.id" id="evento.tipoEvento.id" cssClass="form-control" list="tipoEventos" listKey="id" listValue="nome" emptyOption="true" required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Data do Evento:</label>
                                <div class="input-group m-bot15 right date default-datetime-picker">
                                    <s:textfield name="evento.dataDoEvento" id="evento.dataDoEvento" readonly="true" required="true" cssClass="form-control" value="%{getText('format.dateLong', {evento.dataLimiteCompra})}" />
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-danger date-set"><i class="fa fa-calendar"></i></button>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label>Data limite de compra:</label>
                                <div class="input-group m-bot15 right date default-datetime-picker">
                                    <s:textfield name="evento.dataLimiteCompra" id="evento.dataLimiteCompra" readonly="true" required="true" cssClass="form-control" value="%{getText('format.dateLong', {evento.dataLimiteCompra})}" />
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
                                    <s:textfield name="evento.valor" id="evento.valor" cssClass="form-control money" value="%{getText('format.money', {evento.valor})}" required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>palestrante:</label>
                                <div>
                                    <s:textfield name="evento.palestrante" id="evento.palestrante" type="text" maxlength="100" cssClass="form-control" required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">                 
                    <div class="form-group">
                        <label>Foto:</label>
                        <div>
                            <div class="fileupload fileupload-new" data-provides="fileupload">
                                <div class="fileupload-new thumbnail" style="max-width: 200px;">
                                    <s:if test='evento.foto != ""'>
                                        <img src="../../<s:property value="evento.foto"/>" style="max-width: 200px" id="preview" />
                                    </s:if>
                                    <s:else>
                                        <img src="https://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=sem+imagem" alt="" id="preview" />
                                    </s:else>
                                </div>
                                <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                <div>
                                    <span class="btn btn-white btn-file">
                                        <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Selecione a image</span>
                                        <span class="fileupload-exists"><i class="fa fa-undo"></i> Troque</span>
                                        <input type="file" class="default" id="upload" name="upload" accept="image/*" />
                                    </span>
                                    <a href="javascript: imageUtils.cleanUpload('uploadCapa')" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">
                                        <i class="fa fa-trash"></i> Remova
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label>Descricao:</label>
                        <div>
                            <s:textarea name="evento.descricao" id="evento.descricao"  rows="5" cssClass="form-control" required="true"/>
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


            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listEvento'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>

    </div>
</section>

<%@include file="../fragment/endpage.jsp" %>   
<link rel="stylesheet" type="text/css" href="../assets/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css" href="../assets/bootstrap-fileupload/bootstrap-fileupload.css" />
<link rel="stylesheet" type="text/css" href="../assets/bootstrap-datetimepicker/css/datetimepicker.css" />

 <script type="text/javascript" src="../evento/js/script.js"></script>
<script type="text/javascript" src="../assets/jquery-maskmoney/dist/jquery.maskMoney.min.js"></script>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="../assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" type="text/css" href="../assets/bootstrap-datetimepicker/css/datetimepicker.css" />

<script type="text/javascript">
                    $(function () {
                        $("html").niceScroll().remove();

                        $(".default-datetime-picker").datetimepicker({
                            format: 'dd/mm/yyyy hh:ii',
                            autoclose: true,
                            todayBtn: true,
                            pickerPosition: "bottom-left"
                        });

                        $('.default-date-picker').datepicker({
                            format: 'dd/mm/yyyy',
                            autoclose: true
                        });
                    });
</script>
<%@include file="../fragment/truend.jsp" %>
