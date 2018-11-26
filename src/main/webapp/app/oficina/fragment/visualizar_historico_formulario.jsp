
<%@taglib prefix="s" uri="/struts-tags"%>
<section class="panel">
    <header class="panel-heading">
        Visualizar Histórico
    </header>
    <div class="panel-body">

        <div class="row" style="overflow: auto; height: 300px;">
            <div class="col-lg-12">
                <div class="form-group">
                    <s:property value="oficina.historico" escapeHtml="false"/>
                    <!--s:textarea name="oficina.historico" id="oficina.historico" cssClass="form-control" readonly="true" rows="20"/-->
                </div>
            </div>

        </div>
    </div>
</section>