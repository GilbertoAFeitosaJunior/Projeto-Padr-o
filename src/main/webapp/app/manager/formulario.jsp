<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>

<s:if test="usuario == null">
    <%@include file="fragment/manager_formulario.jsp" %>   
</s:if>
<s:else>
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a data-toggle="tab" href="#tab">Manager</a>
                </li>    
                <li>
                    <a data-toggle="tab" href="#tab1">Consultor</a>
                </li>  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-pane active">
                    <%@include file="../manager/fragment/manager_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-pane">
                    <%@include file="../manager/fragment/consultor_formulario.jsp" %> 
                </div>  
            </div>           
        </div>
    </section>
</s:else>


<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../manager/js/script.js"></script>
<%@include file="../fragment/truend.jsp" %>
