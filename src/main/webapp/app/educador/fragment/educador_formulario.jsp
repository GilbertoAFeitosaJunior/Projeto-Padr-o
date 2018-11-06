<%@taglib prefix="s" uri="/struts-tags" %>

<section class="panel">
    <header class="panel-heading">
        Salvar Educador
    </header>

    <div class="panel-body">

        <s:form id="form" acceptcharset="UTF-8" method="post" cssClass="cmxform" action="persistEducador" theme="simple" enctype="multipart/form-data">
            <s:hidden name="educador.id"/>

            <div class="row">
                <div class="col-lg-8">
                    <div class="form-group">                      
                        <label>Nome</label>
                        <s:textfield name="educador.nome" id="educador.nome" cssClass="form-control" required="true"/>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="form-group">
                        <label>Usuário</label>
                        <s:select name="educador.usuario.id" id="educador.usuario.id" cssClass="form-control" required="true" list="usuarios" listValue="nome" listKey="id" emptyOption="true"/>
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
                        <label>Numero</label>
                        <s:textfield type="text" name="educador.numero" id="educador.numero" cssClass="form-control" required="true" maxlength="10" />
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
                        <s:textfield type="text" name="educador.uf" id="educador.uf" cssClass="form-control" required="true" maxlength="2" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-1">
                    <div class="form-group">
                        <label>DDD</label>
                        <s:textfield name="educador.ddd" id="educador.ddd" cssClass="form-control" required="true" maxlength="2" /> 
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="form-group">
                        <label>Celular</label>
                        <s:textfield name="educador.celular" id="educador.celular" cssClass="form-control" required="true" maxlength="9"/> 
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="form-group">
                        <label>Email</label>
                        <s:textfield type="email" name="educador.email" id="educador.email" cssClass="form-control" required="true" />
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>Senha</label>
                        <s:password name="educador.senha" id="educador.senha" cssClass="form-control" required="true" />
                    </div>
                </div>
            </div>


            <div class="panel-body pull-right">
                <button type="button" class="btn btn-danger" onclick="window.location = 'listEducador'">Cancelar</button>
                &nbsp;
                <button type="submit" class="btn btn-success">Salvar Registro</button>
            </div>
        </s:form>

</section>
