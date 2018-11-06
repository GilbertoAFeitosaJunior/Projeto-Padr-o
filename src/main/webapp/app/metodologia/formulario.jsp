<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<s:if test="metodologia == null">
    <%@include file="fragment/metodologia_formulario.jsp" %>   
</s:if>
<s:else>
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li >
                    <a data-toggle="tab" href="#tab">Metodologia</a>
                </li>    
                <li class="active" >
                    <a data-toggle="tab" href="#tab1">Escola</a>
                </li>  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-pane" >
                    <%@include file="../metodologia/fragment/metodologia_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-pane active">
                    <%@include file="../metodologia/fragment/escola_formulario.jsp" %>
                </div>  
            </div>           
        </div>
    </section>
</s:else>

<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../metodologia/js/script.js"></script>

<%@include file="../fragment/truend.jsp" %>

