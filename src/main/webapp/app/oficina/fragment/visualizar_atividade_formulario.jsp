<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
       Visualizar Atividade
    </header>

    <div class="panel-body">
       
        <table class="table table-striped table-advance table-hover" >
            <thead>
                <tr>                      
                    <th>Nome</th>   
                </tr>
                <tbody>
                <s:iterator value="oficina.atividades">
                    <tr>
                        <td class="col-lg-8"><s:property value="nome"/></td>
                    </tr>
                </s:iterator>
            </tbody>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</section>


