<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<s:if test="educador == null">
    <%@include file="fragment/educador_formulario.jsp" %>   
</s:if>
<s:else>
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li >
                    <a data-toggle="tab" href="#tab">Educador</a>
                </li>    
                <li class="active" >
                    <a data-toggle="tab" href="#tab1">Escola</a>
                </li>  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-pane" >
                    <%@include file="../educador/fragment/educador_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-pane active">
                    <%@include file="../educador/fragment/escola_formulario.jsp" %>
                </div>  
            </div>           
        </div>
    </section>
</s:else>

<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../educador/js/educador_formulario.js"></script>

<%@include file="../fragment/truend.jsp" %>

