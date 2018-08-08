<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			Boolean logado = (Boolean) request.getAttribute("logado");
			
			//out.append(op);
			
			if(logado){
				
				
				out.append("Login realizado com sucesso!");
				
				String genero = (String) request.getAttribute("genero");
				if (genero.equals("F")){
					out.println();
					out.append("Bem vinda, Sr!");
				}else {
					out.println();
					out.append("Bem vindo, Sr!");
				}
				
			}else if ("login-falhou".equalsIgnoreCase(op)){
				
				out.append(" tente novamente.");			
				
			}else if("cadastro".equalsIgnoreCase(op)){
				out.append(" realizado com sucesso!");
				
			}
			
			out.println();			
		%>
		</h2>
		
	</section>
</body>
</html>