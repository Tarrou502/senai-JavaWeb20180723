<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="br.com.senai.models.Usuario" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    < src="/.js"></>
    <title>Bem-vindo(a) ao Facebug!</title>
</head>

<body>
    <section id="main">
        <%@ include file="../WEB-INF/header.jsp" %>

        <h2>
        <% 
        	String op = (String) request.getAttribute("operacao");
        	out.append(op);
        	if ("login".equalsIgnoreCase(op)) {
        		if ((Boolean) request.getAttribute("estaLogado")) {
        			out.append(" foi realizado com sucesso!");
        			Usuario u = (Usuario) request.getAttribute("usuario");
        			if (u.getGenero() <= 50) {
        				out.append("Bem-vindo " + u.getNome() + "!");
        			} else {
        				out.append("Bem-vinda " + u.getNome() + "!");
        			}
        		}
        		
        	} else if ("cadastro".equalsIgnoreCase(op)) {
        		out.append(" realizado com sucesso!");
        	}
        	out.println();
        %>
        </h2>
        <footer><strong>Acesso feito em</strong>: <%=LocalDateTime.now() %></footer>
    </section>
</body>

</html>