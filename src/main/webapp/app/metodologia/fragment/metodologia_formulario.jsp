<%@taglib prefix="s" uri="/struts-tags" %>

<section class="panel">
    <header class="panel-heading">
        Salvar Metodologia
    </header>

    <div class="panel-body">

        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistMetodologia" theme="simple" enctype="multipart/form-data">
            <s:hidden name="metodologia.id"/>

            <div class="row">

                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Nome</label>
                        <div>
                            <s:textfield name="metodologia.nome" id="metodologia.nome" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>        
            </div>

            <div class="row">        
                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Descrição</label>
                        <div>
                            <s:textarea name="metodologia.descricao" id="metodologia.descricao" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>
            </div>        

            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">                      
                        <label>Situação</label>
                        <div>
                            <s:select name="metodologia.ativo" id="metodologia.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true"/>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">                      
                        <label>Aplicabilidade da Metodologia</label>
                        <div>
                            <s:select name="metodologia.aplicabilidadeEnum" id="metodologia.aplicabilidadeEnum" cssClass="form-control"    list="aplicabilidadeEnums" listValue="name" emptyOption="true" required="true"/>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">                      
                        <label>Faixa Etária</label>
                        <div>
                            <s:select name="metodologia.faixaEtariaEnum" id="metodologia.faixaEtariaEnum" cssClass="form-control"    list="faixaEtariaEnums" listValue="name" emptyOption="true" required="true"/>
                        </div>
                    </div>
                </div> 
            </div>         


            <div class="row">        
                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Objetivo</label>
                        <div>
                            <s:textarea name="metodologia.objetivo" id="metodologia.objetivo" cssClass="form-control" required="true" />
                        </div>
                    </div>
                </div>
            </div>    


            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listMetodologia'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>


    </div>

</section>