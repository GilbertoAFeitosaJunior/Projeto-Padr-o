<%@taglib prefix="s" uri="/struts-tags"%>
<s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEducador" theme="simple" enctype="multipart/form-data">


    <section class="panel">
        <header class="panel-heading">
            Salvar Educador
            <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
            </span>
        </header>

        <div class="panel-body">
            <s:hidden name="educador.id" />

            <div class="row">
                <div class="col-lg-10">
                    <div class="form-group">                      
                        <label>Nome do Educador</label>
                        <s:textfield name="educador.nome" id="educador.nome" cssClass="form-control" required="true"/>
                    </div>
                </div>

                <div class="col-lg-2">
                    <div class="form-group">                      
                        <label>Parceira</label>
                        <s:select name="educador.parceira.id" id="educador.parceira.id" cssClass="form-control" listKey="id" list="parceiras" listValue="nome" emptyOption="true" required="true" />
                    </div>
                </div>

            </div>
                    
                    <div class="row">
                        <div class="col-lg-10">
                            <div class="form-group">
                                <label>Formação do Educador</label>
                                    <s:textarea name="educador.formacao" id="educador.formacao" cssClass="form-control" required="true" />
                            </div>
                        </div>
                            
                            
                <div class="col-lg-2">
                    <div class="form-group">                      
                        <label>Nível Educacional</label>
                                <s:select name="educador.nivelEducacionalEnum" id="educador.nivelEducacionalEnum" cssClass="form-control"  list="nivelEducacionalEnums" listValue="name" emptyOption="true" required="true"/>
                    </div>
                </div>
                            
                            
                    </div>      
                    
            <div class="row">
                
                <div class="col-lg-10">
                    <div class="form-group">
                        <label>Logradouro</label>
                        <s:textfield name="educador.logradouro" id="educador.logradouro" cssClass="form-control" required="true" maxlength="100"/> 
                    </div>
                </div>
                    
                <div class="col-lg-2">
                    <div class="form-group">
                        <label>Número</label>
                        <s:textfield type="text" name="educador.numero" id="educador.numero" cssClass="form-control" required="true" maxlength="10"/>
                    </div>
                </div>
                    
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label>Complemento</label>
                        <s:textfield type="text" name="educador.complemento" id="educador.complemento" cssClass="form-control" maxlength="100"/>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Bairro</label>
                        <s:textfield type="text" name="educador.bairro" id="educador.bairro" cssClass="form-control" required="true" maxlength="50" />
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="form-group">
                        <label>Cidade</label>
                        <s:textfield type="text" name="educador.cidade" id="educador.cidade" cssClass="form-control" required="true" maxlength="50" />
                    </div>
                </div>
                <div class="col-lg-1">
                    <div class="form-group">
                        <label>UF</label>
                        <s:textfield type="text" name="educador.uf" id="educador.uf" cssClass="form-control" required="true" maxlength="2"/>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-1">
                    <div class="form-group">
                        <label>DDD</label>
                        <s:textfield type="text" name="educador.ddd" id="educador.ddd" cssClass="form-control" required="true" data-mask="99" /> 
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="form-group">
                        <label>Celular</label>
                        <s:textfield type="text" name="educador.celularStringMask" id="educador.celularStringMask" cssClass="form-control" required="true" data-mask="99999-9999" /> 
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>E-mail de Contato</label>
                        <s:textfield type="email" name="educador.email" id="educador.email" cssClass="form-control" required="true" autocomplete="off" />
                    </div>
                </div>


            </div>
        </div>

    </section>

    <section class="panel">
        <header class="panel-heading">
            Dados para o Login
            <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
            </span>
        </header>
        <div class="panel-body">
            <s:hidden name="educador.usuario.id" />
            <div class="row">
                <div class="col-lg-3">
                    <div class="form-group">                      
                        <label>Situacão:</label>
                        <s:select name="educador.usuario.ativo" id="educador.usuario.ativo" cssClass="form-control" listKey="key" list="booleanConditionEnum" listValue="value" emptyOption="true" required="true"/>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="form-group">                      
                        <label>Nome de Usuário:</label>
                        <s:textfield name="educador.usuario.nome" id="educador.usuario.nome" maxlength="100" cssClass="form-control" required="true" />
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="col-lg-6">
                    <div class="form-group">
                        <label>E-mail:</label>
                        <s:textfield name="educador.usuario.email" id="educador.usuario.email" type="email" placeholder="O usuário precisa ter um email" maxlength="100" cssClass="form-control" required="true"/>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="form-group">                      
                        <label>Senha:</label>
                        <s:if test="educador == null">
                            <s:password name="educador.usuario.senha" id="educador.usuario.senha"  maxlength="32" cssClass="form-control" required="true"/>
                        </s:if>
                        <s:else>
                            <s:password name="educador.usuario.senha" id="educador.usuario.senha" placeholder="Deixe em branco se quiser manter a senha atual" maxlength="32" cssClass="form-control" />
                        </s:else>

                    </div>
                </div>
            </div>
            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listEducador'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>
    </div>
</section>





