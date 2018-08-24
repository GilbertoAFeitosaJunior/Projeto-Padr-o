<%

    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("logged") == null) {
        response.sendRedirect("../home/login.jsp");
    }

%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="author" content="S'tos App" />
        <title>YouHub</title>

        <link rel="apple-touch-icon" sizes="57x57" href="../img/icon/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="../img/icon/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="../img/icon/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="../img/icon/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="../img/icon/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="../img/icon/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="../img/icon/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="../img/icon/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="../img/icon/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="../img/icon/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../img/icon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="../img/icon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../img/icon/favicon-16x16.png">
        <link rel="icon" href="../img/icon/favicon.ico" />
        <link rel="manifest" href="../img/icon/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="../img/icon/ms-icon-144x144.png">
        <meta name="theme-color" content="#fa2698">


        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="../css/bootstrap-reset.css" />
        <!--external css-->
        <link href="../assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
        <!--  right slidebar -->
        <link rel="stylesheet" type="text/css" href="../css/slidebars.css" />
        <!-- Custom styles for this template -->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
        <link rel="stylesheet" type="text/css" href="../css/style-responsive.css"/>
        <link rel="stylesheet" type="text/css" href="../assets/toastr-master/toastr.css" />
        <link rel="stylesheet" type="text/css" href="../assets/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="../assets/bootstrap-fileupload/bootstrap-fileupload.css" />
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
        <!--[if lt IE 9]>
          <script src="../js/html5shiv.js"></script>
          <script src="../js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>


        <section id="container" class="">
            <!--header start-->
            <header class="header white-bg">
                <div class="sidebar-toggle-box">
                    <div data-original-title="Alternar Navegação" data-placement="right" class="fa fa-bars tooltips"></div>
                </div>
                <!--logo start-->
                <a href="dashboard" class="logo">youhub</a>
                <!--logo end-->
                <div class="top-nav ">
                    <ul class="nav pull-right top-menu">
                        <!-- user login dropdown start-->
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="username"><s:property value="#session.logged.login"/></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </header>
            <!--header end-->
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <%@include file="menu/menu.jsp" %>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">