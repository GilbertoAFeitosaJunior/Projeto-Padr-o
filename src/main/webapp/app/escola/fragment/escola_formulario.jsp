<%@taglib prefix="s" uri="/struts-tags"%>
        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEscola" theme="simple" enctype="multipart/form-data">

<section class="panel">
    <header class="panel-heading">
        Salvar Escola
    </header>

    <div class="panel-body"> 
            <s:hidden name="escola.id" />

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">                      
                        <label>Nome</label>
                        <s:textfield name="escola.nome" id="escola.nome" maxlength="100" cssClass="form-control" required="true" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Tipo Atuação</label>
                        <s:select name="escola.tipoDeAtuacaoEnum" id="tipoDeAtuacaoEnum" list="tipoDeAtuacaoEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Rede</label>
                        <s:select name="escola.redeEnum" id="redeEnum" list="redeEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Dependência Administrativa</label>
                        <s:select name="escola.depedenciaAdministrativaEnum" id="depedenciaAdministrativaEnum" list="dependenciaAdministrativaEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Inep</label>
                        <s:textfield name="escola.inep" id="escola.inep" maxlength="50" cssClass="form-control" />
                    </div>
                </div>


                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Projeto</label>
                        <s:select name="escola.projeto.id" id="escola.projeto.id" list="projetos" emptyOption="true" listKey="id" listValue="nome" cssClass="form-control" required="true" />
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Situação</label>
                        <s:select name="escola.situacaoEnum" id="situacaoEnum" list="situacaoEnums" emptyOption="true" listValue="name" cssClass="form-control" required="true" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Responsável</label>
                        <s:textfield name="escola.responsavel" id="escola.responsavel" cssClass="form-control" maxlength="100" />
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Tefone Responsável</label>
                        <s:textfield type="text" name="escola.responsavelTelefoneStringMask" id="escola.responsavelTelefoneStringMask" cssClass="form-control" required="true" data-mask="99999-9999" /> 
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Contato</label>
                        <s:textarea type="text" name="escola.responsavelContato" id="escola.responsavelContato" cssClass="form-control" required="true" /> 
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="panel">

         <header class="panel-heading">
           Endereço da Escola
            <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
            </span>
        </header>

        <div class="panel-body">    

            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Logradouro</label>
                        <s:textfield type="text" name="escola.logradouro" id="escola.logradouro" cssClass="form-control" required="true" maxlength="100"/>
                    </div>
                </div>
                
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Número</label>
                        <s:textfield type="text" name="escola.numero" id="escola.numero" cssClass="form-control" required="true" maxlength="10" />
                    </div>
                </div>
                    
            </div>

            <div class="row">
                
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Complemento</label>
                        <s:textfield type="text" name="escola.complemento" id="escola.complemento" cssClass="form-control" maxlength="100"/>
                    </div>
                </div>
                    
                    <div class="col-lg-4">
                    <div class="form-group">
                        <label>CEP</label>
                        <s:textfield type="text" name="escola.cepStringMask" id="escola.cepStringMask" cssClass="form-control" data-mask="99999-999" required="true" />
                    </div>
                </div>
                    
                
            </div>
                    
                    
                    <div class="row">
                    
                        <div class="col-lg-1">
                    <div class="form-group">
                        <label>UF</label>
                        <s:textfield type="text" name="escola.uf" id="escola.uf" cssClass="form-control" required="true" maxlength="2" />
                    </div>
                </div>
                
                <div class="col-lg-7">
                    <div class="form-group">
                        <label>Cidade</label>
                        <s:textfield type="text" name="escola.cidade" id="escola.cidade" cssClass="form-control" required="true" maxlength="50" />
                    </div>
                </div>
                        
                        <div class="col-lg-4">  
                    <div class="form-group">
                        <label>Bairro</label>
                        <s:textfield type="text" name="escola.bairro" id="escola.bairro" cssClass="form-control" required="true" maxlength="50" />
                    </div>
                </div>
                        
                    </div>       

        </div>
    </section>

    <section class="panel">

         <header class="panel-heading">
            Dados do Diretor da Escola
            <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
            </span>
        </header>

        <div class="panel-body">

            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">
                        <label>Diretor Responsável</label>
                        <s:textfield type="text" name="escola.diretorResponsavel" id="escola.diretorResponsavel" cssClass="form-control" required="true" />

                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Contato Diretor</label>
                        <s:textfield type="text" name="escola.diretorContatoStringMask" id="escola.diretorContatoStringMask" cssClass="form-control" required="true" data-mask="99999-9999" /> 
                    </div>
                </div>
            </div>   

            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listEscola'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </div>
    </s:form>
</section>                 

