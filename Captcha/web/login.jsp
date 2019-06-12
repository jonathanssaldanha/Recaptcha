<%-- 
    Document   : login
    Created on : 05/06/2019, 20:06:57
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
        <h1>Resultado da autenticação</h1>
        <%
            String login = request.getParameter("login");
            String pass = request.getParameter("senha");
            String captcha = request.getParameter("captcha");
            String sessCaptcha = session.getAttribute("CODE").toString();
            
            if(login.equals("admin") && pass.equals("12345")){
                out.print("Usuario e senha correro ! Bem vindo, ");
                if(sessCaptcha.equals(captcha)){
                    out.print("captcha correto");
                    session.setAttribute("ATT", "OK");
                    
                }else{
                    out.print("Erro no Captcha");
                }
            }else{
                out.print("Erro na autenticacao: usuario ou senha errados.");
            }
            
        %>
    </body>
</html>
