<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">

    <header class="panel-heading">
        Histórico - Adicionar Registro
    </header>

    <div class="panel-body">
        

        <div class="row">
            <div class="col-lg-12">
                <div class="form-group">
                    <s:textarea name="oficinaHistorico" id="oficina.historico" cssClass="form-control oficinahistorico" rows="5" />
                </div>
            </div>

            <div class="panel-body pull-right">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="form-group ">

                            <button id="botaoAdicionarHistorico" class="btn btn-primary " data-toggle="modal" href="#confirmarAdicionar"><i class="fa fa-plus"></i> Adicionar</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <header class="panel-heading" style="margin-top: -50px;">
        Histórico Atual
    </header>
    <div class="panel-body">  
        <div class="row" style="overflow: auto; height: 300px;">
            <div class="col-lg-12">
                <div class="form-group">
                     <p id="historicoAtual">
                        <s:property value="oficina.historico" escapeHtml="false" />
                    </p>
                    </div>
                </div>
            </div>

        </div>
                    
<div class="modal fade" id="confirmarAdicionar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirmação</h4>
                </div>
                <div class="modal-body">
                    Deseja realmente adicionar o seguinte texto ao Histórico Atual?<br/>
                    <s:textarea id="confirmacao" cssClass="form-control" readonly="true" rows="10"/>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-danger" type="button">Não</button>
                    <button class="btn btn-success" type="button" onclick="historico.persist()">Sim</button>
                </div>
            </div>
        </div>
    </div>
                    
</section>