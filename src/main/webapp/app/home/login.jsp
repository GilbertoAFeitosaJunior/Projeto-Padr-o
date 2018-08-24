<%
    HttpSession s = request.getSession();
    if (s.getAttribute("logged") != null) {
        response.sendRedirect("../home/");
    }
%>

<%@page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@page import="java.util.Properties"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head_login.jsp" %>
<script src='https://www.google.com/recaptcha/api.js?hl=pt-BR'></script>

<div class="container">

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

    <s:property value="#session.logged" />

    <s:form theme="simple" cssClass="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <div class="login-wrap">
            <s:textfield type="email" cssClass="form-control" placeholder="Usuário" autofocus="true" name="usuario.login" autocomplete="off" required="true" />
            <s:password cssClass="form-control" placeholder="Senha" name="usuario.senha" required="true" />
            <%
                HttpSession sessao = request.getSession();
                if (sessao.getAttribute("tentativa") != null && ((Integer) sessao.getAttribute("tentativa") >= 3)) {
                    Properties properties = new Properties();
                    properties.load(this.getClass().getClassLoader().getResourceAsStream("system.properties"));

                    out.print("<div class=\"g-recaptcha\" data-sitekey=\"" + properties.getProperty("captcha.publickey") + "\"></div>");
                }
            %>
            <label class="checkbox">
                <input type="checkbox" name="keepConnect" value="true"> Manter conectado
            </label>
            <button class="btn btn-lg btn-login btn-block">Acessar</button>

            <span class="pull-right">
                <a href="../web/"> 
                    <i class="fa fa-globe"></i>
                    Ir para o site
                </a>
            </span>
            <br />
        </div>
    </s:form>

    <!-- modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Esqueceu sua senha?</h4>
                </div>
                <div class="modal-body">
                    <p>Insira seu e-mail abaixo para resetar sua senha.</p>
                    <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
                    <button class="btn btn-success" type="button">Enviar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- modal -->
</div>

<%@include file="../fragment/endpage_login.jsp" %>