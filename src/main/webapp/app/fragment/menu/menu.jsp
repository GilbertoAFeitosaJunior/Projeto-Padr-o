<%@taglib prefix="s" uri="/struts-tags"%>
<ul class="sidebar-menu" id="nav-accordion">
    <li>
        <a href="dashboard" <s:if test='menu == "Dashboard"'> class="active"</s:if>>
                <i class="fa fa-dashboard"></i>
                <span>Dashboard</span>
            </a>
        </li>

        <li class="sub-menu">
            <a href="#" 
            <s:if test='menu == "Cor" || 
                  menu == "Modelo" || 
                  menu == "Montadora"'> 
                class="active"
            </s:if>>
            <i class="fa fa-gears"></i><span>Configuração</span>
        </a>
        <ul class="sub">
            <li <s:if test='menu == "Cor"'> class="active"</s:if>>
                    <a href="listCor">Cores do ve&iacute;culo</a>
                </li>
                <li <s:if test='menu == "Montadora"'> class="active"</s:if>>
                    <a href="listMontadora">Montadoras</a>
                </li>
                <li <s:if test='menu == "Modelo"'> class="active"</s:if>>
                    <a href="listModelo">Modelos</a>
                </li>
            </ul>
        </li>

        <li>
            <a href="listDistrito" <s:if test='menu == "Distrito"'> class="active"</s:if>>
                <i class="fa fa-building-o"></i>
                <span>Distrito</span>
            </a>
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


