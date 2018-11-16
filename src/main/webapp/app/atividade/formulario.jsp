<%-- 
    Document   : formulario
    Created on : 16/11/2018, 14:35:47
    Author     : Rafael Bloise
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<s:if test="atividade == null">
    <%@include file="fragment/atividade_formulario.jsp" %>   
</s:if>
<s:else>
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li >
                    <a data-toggle="tab" href="#tab">Atividade</a>
                </li>    
                <li class="active" >
                    <a data-toggle="tab" href="#tab1">Metodologia</a>
                </li>  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-pane" >
                    <%@include file="../atividade/fragment/atividade_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-pane active">
                    <%@include file="../atividade/fragment/atividade_metodologia_formulario.jsp" %>
                </div>  
            </div>           
        </div>
    </section>
</s:else>

<%@include file="../fragment/endpage.jsp" %>
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../atividade/js/atividade_script.js"></script>

<%@include file="../fragment/truend.jsp" %>