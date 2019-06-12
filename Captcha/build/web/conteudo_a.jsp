<%-- 
    Document   : conteudo_a
    Created on : 05/06/2019, 21:45:51
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Conteudo A</h1>
        <%
            if(session.getAttribute("ATT")==null){
                response.sendRedirect("error.html");
            }
        %>
        
    </body>
</html>
