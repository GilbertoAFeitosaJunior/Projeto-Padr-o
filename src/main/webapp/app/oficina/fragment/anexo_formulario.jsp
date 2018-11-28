<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
        Adicionar Anexos
    </header>

       <div class="panel-body">
        <s:form id="formArquivo" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="javascript: void(0);" theme="simple">
            <!--s:hidden name="produto.id" /-->

            <div class="form-group">
                <label>Descrição do Anexo:</label>
                <div>
                    <s:textarea name="anexo.descricao" id="anexo.descricao" cssClass="form-control" />
                </div>
            </div>


            <div class="row">
                <div class="col-lg-5">
                    <div class="form-group">
                        <label>Anexo:</label>
                            <div class="fileupload fileupload-new" data-provides="fileupload">
                                <span class="btn btn-white btn-file">
                                    <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Selecione um arquivo</span>
                                    <span class="fileupload-exists"><i class="fa fa-undo"></i> Mudar</span>
                                    <input type="file" name="upload" id="upload" class="default" required="true" />
                                </span>
                                <span class="fileupload-preview" id="teste" style="margin-left:5px;"></span>
                                <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none; margin-left:5px;"></a>
                            </div>
                    </div>
                </div>
                <div class="col-lg-4 pull-left">
                        <div class="form-group">
                            <br/>
                            <p class="text-center" id="spinner" style="display:none; font-size: 12pt;">
                                <i class="fa fa-spinner"></i> <span></span>Enviando arquivo, favor aguarde...
                            </p>
                            <p class="text-center" id="spinner2" style="display:none; font-size: 12pt;">
                                <i class="fa fa-check"></i> <span></span>Enviado com Sucesso!
                            </p>
                        </div>
                    </div>
                 <div class="panel-body pull-right">               
                    <button type="submit" class="btn btn-success btn-lg"><i class="fa fa-cloud-upload" ></i> Enviar</button>
                </div>
            </div>
                <div class="row">
                    <div class="col-lg-5">
                        <div class="form-group">
                            <p>
                                <strong>Arquivos permitidos:</strong><br/>
                            <ol>
                                <li>Imagens;</li>   
                                <li>Microsoft Office ( Word, Excel e PowerPoint );</li>    
                                <li>PDF;</li>    
                                <li>Multimídia (.mp3, .mp4, .wma, .wmv, .3gp, .mppeg);</li>    
                                <li>Executáveis (.exe, .apk).</li>   
                            </ol>
                            </p>
                        </div>
                    </div>
                    
                </div>
        </s:form>
    </div>
</section>


<section class="panel">
    <header class="panel-heading">Arquivos</header>
    
    <div class="">
    <div class="panel-body">
        <div class="table-responsive-lg">
        <table class="table table-striped table-advance table-hover" id="tArquivo">
            <thead>
                <tr>
                    <th>Descrição</th>
                    <th class="col-lg-2 col-sm-2 col-xs-2 ">Arquivo</th>
                    <th class="col-lg-1 col-sm-1 col-xs-1">Tipo</th>
                    <th class="col-lg-1 col-sm-1 col-xs-1 text-center">Baixado</th>                  
                    <th class="col-lg-1 col-sm-1 col-xs-1 text-right">A&ccedil;&otilde;es</th>
                </tr>
            </thead>
            <tbody >
            </tbody>
            <!--tfoot>
                <tr>
                    <th>T&iacute;tulo</th>
                    <th>Arquivo</th>
                    <th>Tipo do Arquivo</th>
                    <th>quantidade de downloads</th>
                    <th class="col-lg-1 text-right">A&ccedil;&otilde;es</th>
                </tr>
            </tfoot-->
        </table>
            </div>
    </div>
</div>
    <!--div class="panel-body pull-right">
        <button type="button" class="btn btn-danger" onclick="window.location = 'listOficina'">Cancelar</button>
    </div-->
</section>