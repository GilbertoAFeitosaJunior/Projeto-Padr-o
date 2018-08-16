<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<s:if test="hasFieldErrors()">
    <div class="alert alert-warning fade in">
        <h4>
            <i class="fa fa-ok-sign"></i>
            Erro!
        </h4>
        <s:fielderror />
    </div>
</s:if>

<s:if test="hasActionErrors()">
    <div class="alert alert-block alert-danger fade in">
        <h4>
            <i class="fa fa-ok-sign"></i>
            Erro!
        </h4>
        <s:actionerror />
    </div>
</s:if>

<s:if test="hasActionMessages()">
    <div class="alert alert-success alert-block fade in">
        <h4>
            <i class="fa fa-ok-sign"></i>
            Sucesso!
        </h4>
        <s:actionmessage />
    </div>
</s:if>


<s:if test="#session.logged != null">
    <s:if test='redirectURL != null && redirectURL != ""'>
        <a class="btn btn-success" style="float: right" href="<s:property value="redirectURL"/>">Voltar</a>
    </s:if>
    <s:else>
        <a class="btn btn-success" style="float: right" href="javascript:history.back();">Voltar</a>
    </s:else>
</s:if>
<s:else>
    <a class="btn btn-danger" style="float: right" href="../home/login.jsp">Fazer Login</a>
</s:else>

<s:if test="html != \"\" && html != null">
    <h2>Log do processo</h2>
    <div class="retorno">
        <s:property value="html" escapeHtml="false" />
    </div>        
</s:if>


<%@include file="../fragment/endpage.jsp" %>
<style type="text/css">
    .retorno {
        overflow: auto;
        width: calc(100% - 20px);
        height: 350px;
        margin-top: 20px;
        border: 1px solid #ccc;
        padding: 10px;
        background-color: white;
    }

    span {
        padding-left: 10px;
    }
</style>
<%@include file="../fragment/truend.jsp" %>