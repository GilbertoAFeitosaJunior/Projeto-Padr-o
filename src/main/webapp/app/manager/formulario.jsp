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
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistManager" theme="simple" enctype="multipart/form-data">
                <s:hidden name="manager.id" />


                <div class="row">

                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label>Nome:</label>
                                    <div>
                                        <s:textfield name="manager.nome" id="manager.nome" type="text" maxlength="100" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label>E-mail:</label>
                                    <div>
                                        <s:textfield name="manager.email" id="manager.nome" type="email" maxlength="100" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label>DDD:</label>
                                    <div>
                                        <s:textfield name="manager.ddd" id="manager.ddd" maxlength="2" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>                
                            <div class="col-lg-8">
                                <div class="form-group">
                                    <label>Telefone:</label>
                                    <div>
                                        <s:textfield name="manager.celular" id="manager.celular"  maxlength="9" cssClass="form-control" required="true"/>
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
                                        <s:if test='manager.foto != ""'>
                                            <img src="../../<s:property value="manager.foto"/>" style="max-width: 200px" id="preview" />
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