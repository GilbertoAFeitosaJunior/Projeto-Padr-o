<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
       Adicionar Escola
    </header>

    <div class="panel-body">

        
        <div class="row">
            <div class="col-lg-offset-1 col-lg-8 form-group">
                <s:select name="escola.id" id="escola.id" cssClass="form-control" list="escolas" listValue="nome" listKey="id" required="true" />
            </div>
        
            <div class="col-lg-3 form-group">
             <button class="btn btn-primary " type="button" onclick="escola.persist()"><i class="fa fa-plus"></i> Adicionar</button>
            </div>
        </div>
        <br/>
        <table class="table table-striped table-advance table-hover" id="tEscola">
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
            <a class="btn btn-primary" href="listMetodologia" >
                <i class="fa fa-arrow-left"></i> 
                Voltar 
            </a>
        </div>
    </div>
</section>
