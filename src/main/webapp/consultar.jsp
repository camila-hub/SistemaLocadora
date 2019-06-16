
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="modelo.entidades.Filme"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

<link rel="stylesheet" type="text/css" href="css/styles.css">
<script charset="UTF-8" src="js/aprendendo.js"></script>
<title>Sistema Locadora</title>

</head>

<body>


	<%
		// ACESSANDO DADOS DO RESPONSE  
		//String subtitulo = request.getAttribute("subtitulo").toString();
		Filme fil = (Filme) request.getAttribute("objFilme");
	%>

	<h1>Dados do Filme</h1>

	<div>
		
	
		<form action="consultar" method="get">

			C�digo:<br> <input type="number" name="codigo"
				value="<%=fil.getCodigo()%>"><br>
			<br> T�tulo:<br> <input type="text" name="titulo"
				value="<%=fil.getTitulo()%>"><br>
			<br> Diretor:<br> <input type="text" name="diretor"
				value="<%=fil.getDiretor()%>"><br>
			<br> G�nero:<br> <input type="text" name="genero"
				value="<%=fil.getGenero()%>"><br>
			<br> Pre�o:<br> <input type="number" name="preco"
				value="<%=fil.getPreco()%>"><br>
			<br> Qtd. em Estoque:<br> <input type="number"
				name="qtdEstoque" value="<%=fil.getQtdEstoque()%>"><br>
			<br>

		</form>


		<br>
		
		<br> <input type="button" value="Deletar"
			onclick="window.location.href= 'file:///C:/Users/Talia/eclipse-workspace/SistemaLocadora/src/main/webapp/menu.html';">
		
		<br> <input type="button" value="Sair"
			onclick="window.location.href= 'file:///C:/Users/Talia/eclipse-workspace/SistemaLocadora/src/main/webapp/menu.html';">

	</div>



</body>

</html>