<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
        Histórico
    </header>
    <div class="painel-body">

        <div class="row">
            <div class="col-lg-12">
                <div class="form-group">
                    <s:textarea name="oficinaHistorico" id="oficina.historico" cssClass="form-control" rows="5" />
                </div>
            </div>

            <div class="panel-body pull-right">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="form-group ">

                           <button class="btn btn-primary " onclick="historico.persist();"><i class="fa fa-plus"></i> Adicionar</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="form-group">
                    <s:textarea name="oficina.historico" id="oficina.historico" cssClass="form-control" readonly="true" rows="20"/>
                </div>
            </div>

        </div>
    </div>
</section>