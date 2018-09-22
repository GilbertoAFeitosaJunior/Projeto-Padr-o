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
            <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistDiretorSala" theme="simple" enctype="multipart/form-data">
                <s:hidden name="usuario.id" />
                <s:hidden name="usuario.diretorSala.id" />


                <div class="row">
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>Esse registro será um assistente de diretor de sala ?</label> 
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <div>
                                                <s:select name="usuario.diretorSala.assistente" id="usuario.diretorSala.noassistenteme"  cssClass="form-control" list="booleanConditionEnum" listKey="key" listValue="value" required="true"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>                        
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label>Nome:</label>
                                    <div>
                                        <s:textfield name="usuario.diretorSala.nome" id="usuario.diretorSala.nome" type="text" maxlength="100" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-8">
                                <div class="form-group">
                                    <label>E-mail:</label>
                                    <div>
                                        <s:textfield name="usuario.email" id="usuario.email" type="email" maxlength="100" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label>Senha:</label>
                                    <div>
                                        <s:password name="usuario.senha" id="usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4">         
                                <div class="form-group">
                                    <label>CPF:</label>
                                    <div>
                                        <s:textfield name="usuario.cpjStringMask" id="usuario.cpjStringMask" data-mask="999.999.999-99" maxlength="100" cssClass="form-control" required="true"/>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-lg-2">
                                <div class="form-group">
                                    <label>DDD:</label>
                                    <div>
                                        <s:textfield name="usuario.diretorSala.ddd" id="usuario.diretorSala.ddd" maxlength="2" cssClass="form-control" />
                                    </div>
                                </div>
                            </div>                
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label>Telefone:</label>
                                    <div>
                                        <s:textfield name="usuario.diretorSala.celular" id="usuario.diretorSala.celular"  maxlength="9" cssClass="form-control" />
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
                                        <s:if test='usuario.diretorSala.foto != ""'>
                                            <img src="../../<s:property value="usuario.diretorSala.foto"/>" style="max-width: 200px" id="preview" />
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
                    <button type="button" class="btn btn-danger" onclick="window.location = 'listDiretorSala'">Cancelar</button>
                    &nbsp;
                    <button type="submit" class="btn btn-success">Salvar Registro</button>
                </div>
            </s:form>

        </div>
    </section>

    <%@include file="../fragment/endpage.jsp" %>
    <script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
    <script type="text/javascript" src="../diretor_sala/js/script.js"></script>
    <%@include file="../fragment/truend.jsp" %>

</compress:html>