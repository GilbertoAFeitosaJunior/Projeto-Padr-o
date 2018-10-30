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
        <link rel="shortcut icon" href="../img/favicon.png" />
        <title>Educador</title>
        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet" />
        <link href="../css/bootstrap-reset.css" rel="stylesheet" />
        <!--external css-->
        <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <!--  right slidebar -->
        <link href="../css/slidebars.css" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="../css/style.css" rel="stylesheet" />
        <link href="../css/style-responsive.css" rel="stylesheet" />
        <link href="../assets/toastr-master/toastr.css" rel="stylesheet" type="text/css" />
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
        <!--[if lt IE 9]>
          <script src="../js/html5shiv.js"></script>
          <script src="../js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="full-width">

        <section id="container" class="">
            <!--header start-->
            <header class="header white-bg">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="fa fa-bars"></span>
                </button>
                <!--logo start-->
                <a href="#" class="logo">Be Pro<span>App</span></a>
                <!--logo end-->
                <div class="top-nav ">
                    <ul class="nav pull-right top-menu">
                        <!-- user login dropdown start-->
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <img alt="" src="<s:property value="#session.logged.foto"/>" style="height: 29px" >
                                <span class="username"><s:property value="#session.logged.nome"/></span>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu extended logout">
                                <div class="log-arrow-up"></div>
                                <li><a href="logout"><i class="fa fa-key"></i> Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </header>
            <!--header end-->
            <!--sidebar start-->

            <!--sidebar end-->

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">