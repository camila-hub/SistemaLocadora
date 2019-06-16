
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

	<h1>Atualizar Cadastro</h1>

	<div>

		<form action="atualizarcadastro" method="get">

		<br>Informe o código a ser atualizado<br> <input type="number" name="codigo"
				value=""><br> <br>
		
		
		<br>Título<br> <input type="text" name="titulo"
				value="<%=fil.getTitulo()%>">
		<br>Novo Título<br><input id="titulo" name="titulo" type="text"
				placeholder="<%=fil.getCodigo()%>" /><br>
				
		<br> Diretor<br><input type="text" name="diretor" value="<%=fil.getDiretor()%>">
		<br>Novo Diretor<br><input id="diretor" name="diretor" type="text" placeholder="<%=fil.getDiretor()%>"/><br>

		<br>Gênero<br> <input type="text" name="genero"
				value="<%=fil.getGenero()%>">
		<br>Novo Gênero<input id="genero" name="genero" type="text" placeholder="<%=fil.getGenero()%>"/><br>
				
		<br>Preço<br><input type="number" name="preco" value="<%=fil.getPreco()%>">
		<br>Novo Preço<input id="preco" name="preco" type="number" placeholder="<%=fil.getPreco()%>"/><br>
		
		<br> Qtd. em Estoque<br> <input type="number" name="qtdEstoque" value="<%=fil.getQtdEstoque()%>">
		<br>Nova qtd. em Estoque<input id="qtdEstoque" name="qtdEstoque" type="number" placeholder="<%=fil.getQtdEstoque()%>"/><br>
		<br>

		</form>


		<br> <br> <input type="submit" value="Atualizar"
			onclick="window.location.href= 'file:///C:/Users/Talia/eclipse-workspace/SistemaLocadora/src/main/webapp/menu.html';">

	</div>



</body>

</html>