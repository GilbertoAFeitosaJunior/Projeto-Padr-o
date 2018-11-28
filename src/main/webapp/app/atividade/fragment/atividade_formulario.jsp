<%-- 
    Document   : atividade_formulario
    Created on : 16/11/2018, 14:09:30
    Author     : Rafael Bloise
--%>
<%@taglib prefix="s" uri="/struts-tags" %>

<section class="panel">
    <header class="panel-heading">
        Salvar Atividade
    </header>

    <div class="panel-body">

        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistAtividade" theme="simple" enctype="multipart/form-data">
            <s:hidden name="atividade.id"/>

            <div class="row">

                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Nome</label>
                        <div>
                            <s:textfield name="atividade.nome" id="atividade.nome" cssClass="form-control" required="true"/>
                        </div>
                    </div>
                </div>        
            </div>


            <div class="row">        
                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Descrição</label>
                        <div>
                            <s:textarea name="atividade.descricao" id="atividade.descricao" cssClass="form-control" />
                        </div>
                    </div>
                </div>
            </div>        

            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listAtividade'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>


    </div>

</section>

