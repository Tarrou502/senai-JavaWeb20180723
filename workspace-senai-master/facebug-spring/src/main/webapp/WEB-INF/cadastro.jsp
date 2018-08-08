<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8"/>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script src="script/script.js"></script>
        <title>Cadastre-se no Facebug</title>
    </head>
    <body>
    
   <%@ include file="../WEB-INF/header.jsp" %> 
   
        <form name="form_cadastro" action="cadastro" onsubmit="return validateForm()" method="post">
            
            <input type="text" id="nome" name="nome" placeholder="Nome"/>
            <input type="text" id="sobrenome" name="sobrenome" placeholder="Sobrenome"/>
            <input type="email" id="email" name="email" placeholder="Email">
            <input type="text"  id="telefone" name="telefone" placeholder="Telefone"/>
            <input type="password" id="senha" name="senha" placeholder="Senha">
            <input type="password" placeholder="Confirme a senha"/>

            <section id="genero">
                Masculino
                <input type="range" id="genero" name="genero"/>
                Feminino
            </section>
            <!-- <section id="genero">
                <input type="radio" id="masculino" name="genero"/>
                <label for="masculino">Masculino</label>
                <input type="radio" id="feminino" name="genero"/>
                <label for="feminino">Feminino</label>
            </section> -->
            
            <input type="date" id="data-nascimento" name="data-nascimento">

            <section id="termos">
                <input id="cb-termos" type="checkbox"/>
                <label for="cb-termos">Eu concordo com os termos</label>
            </section>

            <input type="submit" value="Cadastrar"/>
            
        </form>
    </body>
</html>