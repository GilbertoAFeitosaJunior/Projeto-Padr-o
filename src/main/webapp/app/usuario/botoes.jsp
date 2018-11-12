<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>

<section class="panel">
    <header class="panel-heading">
        Usuários
        <span class="tools pull-right">
            <a href="javascript:;" class="fa fa-chevron-down"></a>
        </span>
    </header>

    <div class="panel-body">     

        <div class="col-lg-3 m-bot15">
            <a href="listGestorDoTerritorio" class="btn btn-primary btn-block">
                Gestor do Território
            </a>
        </div>     
        <div class="col-lg-3 m-bot15">
            <a href="" class="btn btn-primary btn-block">
                Coordenador de Projeto
            </a>
        </div>     
        <div class="col-lg-3 m-bot15">
            <a href="" class="btn btn-primary btn-block">
                Coordenador Pedagógico
            </a>
        </div>     
    </div>  
</section>

<%@include file="../fragment/endpage.jsp" %>
<%@include file="../fragment/truend.jsp" %>