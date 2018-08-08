<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>    

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="script/script.js"></script>
    <title>Bem-vindo(a) ao Facebug!</title>
</head>

<body>
    <section id="main">

	<%@ include file="WEB-INF/header.jsp" %>       

        <div id="banner">
            <img alt="pessoas" src="img/people.jpg" />
        </div>
        <footer><strong>Acesso feito em: </strong><%=LocalDateTime.now() %></footer>
    </section>
</body>

</html>