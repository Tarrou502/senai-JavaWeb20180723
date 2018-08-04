<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime"%>>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="script/script.js"></script>
<title>Bem-vindo(a) ao Facebug!</title>
</head>

<body>
	<section id="main">
		<%@ include file="../WEB-INF/header.jsp"%>
		<h2>
			<%
				String op = (String) request.getAttribute("op");
				out.append(op);
				if ("login".equalsIgnoreCase(op)) {
					Boolean logado = (Boolean) request.getAttribute("logado");

					if (logado) {
						Integer genero = Integer.parseInt((String) request.getAttribute("genero"));
						String nome = (String) request.getAttribute("nome");

						if (genero > 51) {
							out.append(" autenticado, Bem vinda, " + nome + ".");
						} else
							out.append(" autenticado, Bem vindo, " + nome + ".");

					} else
						out.append(" não autenticado.");

				} else if ("cadastro".equalsIgnoreCase(op)) {
					out.append(" realizado com sucesso");
				}
				out.println();
			%>
		</h2>
	</section>
</body>
</html>