<%@taglib prefix="s" uri="/struts-tags"%>
<ul class="sidebar-menu" id="nav-accordion">
    <li>
        <a href="dashboard" <s:if test='menu == "#"'> class="active"</s:if>>
                <i class="fa fa-dashboard"></i>
                <span>Dashboard</span>
            </a>
        </li>

        <li class="sub-menu">
            <a href="javascript:;" <s:if test='menu == "TipoEvento" || 
              menu == "Evento"'>class="active"</s:if>>
               <i class="fa fa-check-square-o"></i>
               <span>Evento</span>
           </a>
           <ul class="sub">
               <li <s:if test='menu == "TipoEvento"'>class="active"</s:if>>
                   <a href="listTipoEvento">
                       <span>Tipo do Evento</span>
                   </a>
               </li>  
               <li <s:if test='menu == "Evento"'>class="active"</s:if>>
                   <a href="listAbastecimento">
                       <span>Evento</span>
                   </a>
               </li>  
           </ul>
        </li>



        <li>
            <a href="listUsuario" <s:if test='menu == "Usuario"'> class="active"</s:if>>
            <i class="fa fa-user"></i>
            <span>Usu&aacute;rios do painel</span>
        </a>
    </li>

    <li>
        <a href="logout">
            <i class="fa fa-remove"></i>
            <span>Sair</span>
        </a>
    </li>
</ul>


