<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


<!--s:if test="oficina == null">
    <!%@include file="fragment/oficina_formulario.jsp" %>   
<!/s:if->
<!s:else-->
    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li id="tab-oficina" class="tab-oficina active">
                    <a data-toggle="tab" href="#tab">Oficina</a>
                </li>    
                <li class="tab-atividade" >
                    <a data-toggle="tab" href="#tab1">Atividade</a>
                </li>  
                <li id="tab-historico" >
                    <a data-toggle="tab" href="#tab2">Histórico</a>
                </li>  
                <!--li id="tab-anexo" >
                    <a data-toggle="tab" href="#tab3">Anexo</a>
                </li>  
                <li id="tab-relatorio" >
                    <a data-toggle="tab" href="#tab4">Relatório</a>
                </li-->  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-oficina tab-pane active" >
                    <%@include file="../oficina/fragment/visualizar_oficina_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-atividade tab-pane " >
                    <%@include file="../oficina/fragment/visualizar_atividade_formulario.jsp" %>
                </div>   
                <div id="tab2" class="tab-pane " >
                    <%@include file="../oficina/fragment/visualizar_historico_formulario.jsp" %>
                </div>   
                <div id="tab3" class="tab-pane">
                    <!--%@include file="../oficina/fragment/visualizar_anexo_formulario.jsp" %-->
                </div>  
                <div id="tab4" class="tab-pane">
                    <!--%@include file="../oficina/fragment/visualizar_relatorio_formulario.jsp" %-->
                </div>  
            </div>           
        </div>
    </section>
<!--/s:else-->

<%@include file="../fragment/endpage.jsp" %>
<link rel="stylesheet" type="text/css" href="../assets/bootstrap-datepicker/css/datepicker.css" />
<script type="text/javascript" src="../assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
<script type="text/javascript" src="../oficina/js/oficina_formulario.js"></script>
<script type="text/javascript" src="../oficina/js/atividade_formulario.js"></script>
<script type="text/javascript" src="../oficina/js/historico_formulario.js"></script>
<script type="text/javascript">
                        $(function () {
                            $("html").niceScroll().remove();

                            $('.default-date-picker').datepicker({
                                format: 'dd/mm/yyyy',
                                autoclose: true
                            });
                        });
</script>
<%@include file="../fragment/truend.jsp" %>
