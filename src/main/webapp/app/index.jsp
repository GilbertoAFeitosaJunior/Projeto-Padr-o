<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("logged") != null) {
        response.sendRedirect("home/");
    } else {
        Cookie cookie = null;
        Cookie biscoitos[] = request.getCookies();
        if (biscoitos != null) {
            for (int x = 0; x < biscoitos.length; x++) {
                biscoitos[x].setPath("/");
                if (biscoitos[x].getName().equals("uid")) {
                    cookie = biscoitos[x];
                    break;
                }
            }
        }
        if (cookie != null) {
            response.sendRedirect("home/resurrectLogin");
        } else {
            response.sendRedirect("home/login.jsp");
        }
    }

%>