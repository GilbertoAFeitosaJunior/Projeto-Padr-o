<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<s:if test="escola == null">
    <%@include file="fragment/escola_formulario.jsp" %>   
</s:if>
<s:else>
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a data-toggle="tab" href="#tab">Escola</a>
                </li>    
                <li  >
                    <a data-toggle="tab" href="#tab1">Turmas</a>
                </li>  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-pane active" >
                    <%@include file="../escola/fragment/escola_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-pane ">
                    <%@include file="../escola/fragment/turma_formulario.jsp" %>
                </div>  
            </div>           
        </div>
    </section>
</s:else>
    


<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../escola/js/escola_formulario.js"></script>
<script type="text/javascript" src="../escola/js/turma_formulario.js"></script>
<%@include file="../fragment/truend.jsp" %>

</compress:html>
