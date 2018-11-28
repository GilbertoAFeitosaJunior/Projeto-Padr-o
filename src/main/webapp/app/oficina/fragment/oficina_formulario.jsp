<%@taglib prefix="s" uri="/struts-tags" %>


<section class="panel">
    <header class="panel-heading">
        Salvar Oficina
    </header>

    <div class="panel-body">

        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="" theme="simple" enctype="multipart/form-data" autocomplete="off">

                <s:hidden name="oficina.id"/>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="form-group">
                            <label>Nome:</label>
                            <s:textfield name="oficina.nome" id="oficina.nome" cssClass="form-control" required="true" />
                        </div>
                    </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label>Escola:</label>
                        <s:select name="oficina.escola.id" id="oficina.escola.id" cssClass="form-control" required="true" list="escolas" listValue="nome" listKey="id" emptyOption="true"/>
                    </div>
                </div>
          
            </div>

            <div class="row">
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Turno:</label>
                        <s:select name="oficina.turnoEnum" id="oficina.turnoEnum" cssClass="form-control" list="TurnoEnums" listValue="name" emptyOption="true" required="true"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Situação:</label>
                        <s:select name="oficina.situacaoEnum" id="oficina.situacaoEnum" cssClass="form-control" list="SituacaoOficinaEnums" listValue="name" emptyOption="true" required="true"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Data de Planejamento:</label>
                        <div class="input-group m-bot15 right date default-date-picker" >
                            <s:textfield name="oficina.dataPlanejada" id="oficina.dataPlanejada" required="true" cssClass="form-control" value="%{getText('format.dateShort', {oficina.dataPlanejada})}" />
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
                        <label>Data da Realização:</label>
                        <div class="input-group m-bot15 right date default-date-picker" >
                            <s:textfield name="oficina.dataRealizada" id="oficina.dataRealizada" cssClass="form-control" value="%{getText('format.dateShort', {oficina.dataRealizada})}" />
                            <span class="input-group-btn" >
                                <button type="button" class="btn btn-danger date-set" >
                                    <i class="fa fa-calendar" ></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listOficina'">Cancelar</button>
                &nbsp;
                <button type="submit" onclick="" class="btn btn-success">Salvar Registro</button>
        </s:form>
            </div>
            
</section>
