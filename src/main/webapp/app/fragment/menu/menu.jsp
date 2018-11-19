<%@taglib prefix="s" uri="/struts-tags"%>
<ul class="sidebar-menu" id="nav-accordion">
    <li>
        <a href="#"  class="active">
            <i class="fa fa-dashboard"></i>
            <span>Dashboard</span>
        </a>
    </li>

    <li>
        <a href="prepareUsuarioBotoes" <s:if test='menu == "Usuario" || menu =="CoordenadorPedagogico" || menu == "GestorDoTerritorio" || menu == "CoordenadorDeProjeto" || menu == "Educador" '> class="active"</s:if>>
            <i class="fa fa-user"></i>
            <span>Usu&aacute;rios</span>
        </a>
    </li>
    
    <li>
        <a href="listSecretaria" <s:if test='menu == "Secretaria"'> class="active"</s:if>>
            <i class="fa fa-address-book"></i>
            <span>Secretarias</span>
        </a>
    </li>
    
    <li>
        <a href="listProjeto" <s:if test='menu == "Projeto"'> class="active"</s:if>>
            <i class="fa fa-folder-open"></i>
            <span>Projetos</span>
        </a>
    </li>
    
    <li>
        <a href="listEscola" <s:if test='menu == "Escola"'> class="active"</s:if>>
            <i class="fa fa-book"></i>
            <span>Escolas</span>
        </a>
    </li>
    
    <li>
        <a href="listMetodologia" <s:if test='menu == "Metodologia"'> class="active"</s:if>>
            <i class="fa fa-commenting"></i>
            <span>Metodologias</span>
        </a>
    </li>
    
<!--    <li>
        <a href="listEducador" <s:if test='menu == "Educador"'> class="active"</s:if>>
            <i class="fa fa-pencil"></i>
            <span>Educadores</span>
        </a>
    </li>-->
     
    <li>
        <a href="listAtividade" <s:if test='menu == "Atividade"'> class="active"</s:if>>
            <i class="fa fa-pencil-square"></i>
            <span>Atividades</span>
        </a>
    </li>
    
    <li>
        <a href="listPessoa" <s:if test='menu == "Pessoa"'> class="active"</s:if>>
            <i class="fa fa-users"></i>
            <span>Pessoas</span>
         </a>
     </li>
     
    <li>
        <a href="listOficina" <s:if test='menu == "Oficina"'> class="active"</s:if>>
            <i class="fa fa-cogs"></i>
            <span>Oficinas</span>
         </a>
     </li>

    <li>
        <a href="logout">
            <i class="fa fa-remove"></i>
            <span>Sair</span>
        </a>
    </li>
</ul>


