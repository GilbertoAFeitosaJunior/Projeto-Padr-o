<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html compressCss="true">

    <%@include file="../fragment/head.jsp" %>

    <section class="panel">
        <header class="panel-heading">
            Salvar Tipo de Evento
        </header>

        <div class="panel-body">
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistPodcast" theme="simple" enctype="multipart/form-data">
                <s:hidden name="podcast.id" />



                <div class="row">
                    <div class="col-lg-8">
                        <div class="form-group">
                            <label>Título:</label>
                            <div>
                                <s:textfield name="podcast.titulo" id="podcast.titulo" type="text" maxlength="100" cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>     
                    <div class="col-lg-4">                      
                        <div class="form-group">
                            <label>Data para exibição:</label>
                            <div class="input-group m-bot15 right date default-datetime-picker">
                                <s:textfield name="podcast.dataExibicao" id="podcast.dataExibicao"  required="true" cssClass="form-control" value="%{getText('format.dateLong', {podcast.dataExibicao})}" />
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-danger date-set"><i class="fa fa-calendar"></i></button>
                                </span>
                            </div> 
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Descrição:</label>
                            <div>
                                <s:textarea name="podcast.descricao" id="podcast.descricao" type="text"  cssClass="form-control" required="true"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">              
                    <div class="col-lg-12">
                        <div class="form-group">
                            <label>Arquivo:</label>
                            <div>
                                <s:file type="file" id="upload" name="upload" />
                            </div>
                        </div>
                    </div>
                </div> 


                <div class="panel-body pull-right">
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listPodcast'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap-fileupload/bootstrap-fileupload.css" />
    <link rel="stylesheet" type="text/css" href="../assets/bootstrap-datetimepicker/css/datetimepicker.css" />

    <script type="text/javascript" src="../podcast/js/script.js"></script>

    <script type="text/javascript" src="../assets/jquery-maskmoney/dist/jquery.maskMoney.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="../assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

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

</compress:html>