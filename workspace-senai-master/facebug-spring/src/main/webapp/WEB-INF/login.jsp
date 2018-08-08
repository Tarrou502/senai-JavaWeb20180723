<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script src="script/script.js"></script>
        <title>Entrar no Facebug</title>
    </head>
    <body>
        <%@ include file="/WEB-INF/header.jsp" %> 
        <form name="login_form" action="login" onsubmit="" method="post">
            
            <input type="email" id="email" name="email" placeholder="Digite seu e-mail"/>
            <input type="password" id="senha" name="senha" placeholder="Digite sua senha"/>

            <input type="submit" value="Vai disgra&ccedil;aaaaaa"/>
            
        </form>
    </body>
</html>