<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../fragment/head.jsp" %>


    <section class="panel">
        <header class="panel-heading tab-bg-dark-navy-blue ">
            <ul class="nav nav-tabs">
                <li id="tab-oficina" class="tab-oficina active ">
                    <a data-toggle="tab" href="#tab">Oficina</a>
                </li>    
                <li data-original-title="Desativado" data-content="Cadastre uma oficina para ter acesso a esta aba." data-placement="bottom" data-trigger="hover" id="tab-atividade" class="tab-atividade info popovers" >
                    <a id="tab-atividade-link" data-toggle="" href="#tab1">Atividade</a>
                </li>  
               
                <li data-original-title="Desativado" data-content="Cadastre uma oficina para ter acesso a esta aba." data-placement="bottom" data-trigger="hover" id="tab-historico" class="tab-historico info popovers" >
                    <a id="tab-historico-link" data-toggle="" href="#tab2">Histórico</a>
                </li>  
                <li id="tab-anexo" data-original-title="Desativado" data-content="Cadastre uma oficina para ter acesso a esta aba." data-placement="bottom" data-trigger="hover" class="tab-anexo info popovers"  >
                    <a id="tab-anexo-link" data-toggle="" href="#tab3">Anexo</a>
                </li>  
                <!--li id="tab-relatorio"  >
                    <a data-toggle="tab" href="#tab4">Relatório</a>
                </li-->  
            </ul>            
        </header>

        <div class="panel-body">
            <div class="tab-content">
                <div id="tab" class="tab-oficina tab-pane active" >
                    <%@include file="../oficina/fragment/oficina_formulario.jsp" %>
                </div>   
                <div id="tab1" class="tab-atividade tab-pane " >
                    <%@include file="../oficina/fragment/atividade_formulario.jsp" %>
                </div>   
                <div id="tab2" class="tab-historico tab-pane " >
                    <%@include file="../oficina/fragment/historico_formulario.jsp" %>
                </div>   
                <div id="tab3" class="tab-anexo tab-pane">
                    <%@include file="../oficina/fragment/anexo_formulario.jsp" %>
                </div>  
                <!--div id="tab4" class="tab-pane">
                    <!%@include file="../oficina/fragment/relatorio_formulario.jsp" %>
                </div-->  
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
<script type="text/javascript" src="../oficina/js/anexo_formulario.js"></script>
<script type="text/javascript" src="../assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
                    <s:if test="oficina != null">
                        $('#tab-atividade').popover('disable');
                        $('#tab-historico').popover('disable');
                        $('#tab-anexo').popover('disable');
                        oficina.desbloquear('tab-atividade-link');
                        oficina.desbloquear('tab-historico-link');
                        oficina.desbloquear('tab-anexo-link');
                    </s:if>
                        $(function () {
                            $("html").niceScroll().remove();

                            $('.default-date-picker').datepicker({
                                format: 'dd/mm/yyyy',
                                autoclose: true
                            });
                        });
                      $(document).ready(function(){
                        $("#botaoAdicionarHistorico").on("click", function(){
                            historico.confirmacaoModal(); 
                        });
                      } ); 
                        
                        
</script>
<%@include file="../fragment/truend.jsp" %>

