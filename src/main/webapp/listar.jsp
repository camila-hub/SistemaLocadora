
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="modelo.entidades.Filme"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/exemplo_table.css">
<script charset="UTF-8" src="js/aprendendo.js"></script>
<title>Sistema Locadora</title>

</head>


<body>

	<%
		// ACESSANDO DADOS DO RESPONSE
		List<Filme> listaFilmes = (List<Filme>) request.getAttribute("listaFilmes");
	%>


	<h2>Relatório de Filmes</h2>

	<table>
		<tr>
			<th>Código</th>
			<th>Título</th>
			<th>Diretor</th>
			<th>Gênero</th>
			<th>Preço</th>
			<th>Qtd. em Estoque</th>
		</tr>

		<%
			for (Filme fil : listaFilmes) {
		%>
		<tr>
			<td><a href="consultar?codigo=<%=fil.getCodigo()%> "><%=fil.getCodigo()%></a></td>
			<td><%=fil.getTitulo()%></td>
			<td><%=fil.getDiretor()%></td>
			<td><%=fil.getGenero()%></td>
			<td><%=fil.getPreco()%></td>
			<td><%=fil.getQtdEstoque()%></td>
		</tr>
		<%
			}
		%>


	</table>

</body>

</html>