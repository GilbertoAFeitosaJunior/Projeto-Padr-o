<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
        Consultor
    </header>

    <div class="panel-body">

        <div class="row">
            <div class="col-lg-offset-10 col-lg-2">               
                <a class="btn btn-primary" data-toggle="modal" href="#novoConsultorModal" onclick="consultor.clearModal()">
                    <i class="fa fa-plus"></i>
                    Adicionar Novo
                </a>
            </div>
        </div>

        <br />

        <table class="table table-striped table-advance table-hover" id="tConsultor">
            <thead>
                <tr>                      
                    <th>Foto</th>    
                    <th>Nome</th>    
                    <th>E-mail</th>    
                    <th>CPF</th>    
                    <th class="col-lg-1 text-right">A&ccedil;&otilde;es</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</section>




<div class="modal fade" id="novoConsultorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Novo Consultor</h4>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" name="usuario.consultor.id" id="consultorId" />
                    <input type="hidden" name="usuario.id" id="usuarioId"/>


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Nome:</label>
                                <div>
                                    <s:textfield name="usuario.consultor.nome" id="consultorNome" type="text" maxlength="100" cssClass="form-control" required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-8">
                            <div class="form-group">
                                <label>E-mail:</label>
                                <div>
                                    <s:textfield name="usuario.email" id="consultorEmail" type="email" maxlength="100" cssClass="form-control" required="true"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <div class="form-group">
                                <label>CPF:</label>
                                <div>
                                    <s:textfield name="usuario.cpjStringMask" id="consultorCPF"  maxlength="100" data-mask="999.999.999-99" cssClass="form-control" required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label>Senha:</label>
                                <div>
                                    <s:password name="usuario.senha" id="consutlorSenha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">           
                        <div class="col-lg-4">
                            <div class="form-group">
                                <label>Foto:</label>
                                <div>
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
                                        <div class="fileupload-new thumbnail" style="max-width: 200px;">                                       

                                            <img src="https://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=sem+imagem" alt="" id="preview" />

                                        </div>
                                        <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                        <div>
                                            <span class="btn btn-white btn-file">
                                                <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Selecione a image</span>
                                                <span class="fileupload-exists"><i class="fa fa-undo"></i> Troque</span>
                                                <input type="file" class="default" id="uploadConsultor" name="uploadConsultor" accept="image/*" />
                                            </span>
                                            <a href="javascript: imageUtils.cleanUpload('uploadConsultor')" class="btn btn-danger fileupload-exists" data-dismiss="fileupload">
                                                <i class="fa fa-trash"></i> Remova
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                  
                </form>
            </div>   
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-danger" type="button">Cancelar</button>
                <button class="btn btn-success" type="button" onclick="consultor.persist()">Salvar</button>
            </div>
        </div>      
    </div>
</div>