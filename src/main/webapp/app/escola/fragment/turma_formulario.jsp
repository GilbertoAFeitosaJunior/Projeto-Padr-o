<%@taglib prefix="s" uri="/struts-tags"%>

<section class="panel">
    <header class="panel-heading">
        Adicionar Turmas
    </header>
    <s:form id="formTurma" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="" theme="simple" enctype="multipart/form-data" autocomplete="off">
        <div class="panel-body">

            <div class="row">
                <div class="col-lg-offset-1 col-lg-8">
                    <div class="form-group">
                        <label>Nome</label>
                        <s:textfield name="turma.nome" id="turmanome" cssClass="form-control" maxlength="100" required="true"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <button class="btn btn-primary " type="submit" onclick="" style="margin-top: 10%;"><i class="fa fa-plus"></i> Adicionar</button>
                </div>
            </div>
        </div>
    </s:form>
    <br/>
</section>             
<section class="panel">
    <header class="panel-heading">
        Turmas 
    </header>
    <div class="panel-body">
        <table class="table table-striped table-advance table-hover" id="tTurma">
            <thead>
                <tr>                      
                    <th>Nome</th>   
                    <th class="col-lg-1 text-right">A&ccedil;&otilde;es</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <div class="panel-body pull-right">
            <a class="btn btn-primary" href="listEscola" >
                <i class="fa fa-arrow-left"></i> 
                Voltar 
            </a>
        </div>
    </div>
</section>
