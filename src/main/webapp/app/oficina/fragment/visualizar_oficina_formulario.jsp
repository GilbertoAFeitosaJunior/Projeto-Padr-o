<%@taglib prefix="s" uri="/struts-tags" %>


<section class="panel">
    <header class="panel-heading">
        Visualizar Oficina
    </header>

    <div class="panel-body">

                <s:hidden name="oficina.id"/>
                <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label>Escola</label>
                        <s:textfield name="oficina.escola.nome" id="oficina.escola.id" cssClass="form-control" readonly="true"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Turno</label>
                        <s:textfield name="oficina.turnoEnum.name" id="oficina.turnoEnum" cssClass="form-control" readonly="true"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Situação</label>
                        <s:textfield name="oficina.situacaoEnum.name" id="oficina.situacaoEnum" cssClass="form-control" readonly="true"/>
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Data de Planejamento</label>
                        <div class="input-group m-bot15 right date " >
                            <s:textfield name="oficina.dataPlanejada" id="oficina.dataPlanejada" cssClass="form-control" value="%{getText('format.dateShort', {oficina.dataPlanejada})}" readonly="true" />
                            <span class="input-group-btn" >
                                <button type="button" class="btn btn-danger date-set" >
                                    <i class="fa fa-calendar" ></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
                            
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Data da Realização</label>
                        <div class="input-group m-bot15 right date " >
                            <s:textfield name="oficina.dataRealizada" id="oficina.dataRealizada" cssClass="form-control" value="%{getText('format.dateShort', {oficina.dataRealizada})}" readonly="true"/>
                            <span class="input-group-btn" >
                                <button type="" class="btn btn-danger date-set" >
                                    <i class="fa fa-calendar" ></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            </div>

</section>
