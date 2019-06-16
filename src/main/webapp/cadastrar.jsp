
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>

<link rel="stylesheet" type="text/css" href="css/styles.css">
<script charset="UTF-8" src="js/aprendendo.js"></script>
<title>Sistema Locadora</title>

</head>

<body>

	<!--formulario de cadastro-->
	<div id="cadastrarfilme">
		<form method="get" action="cadastrarfilme">
			<h1>Cadastrar Filme</h1>

			<p>
				<label for="codigo"> Código </label> <input id="codigo"
					name="codigo" required="required" type="number" />
			</p>


			<p>
				<label for="titulo"> Titulo </label> <input id="titulo"
					name="titulo" required="required" type="text" />
			</p>

			<p>
				<label for="diretor"> Diretor </label> <input id="diretor"
					name="diretor" required="required" type="text" />
			</p>

			<p>
				<label for="genero"> Gênero </label> <input id="genero"
					name="genero" required="required" type="text" />
			</p>

			<p>
				<label for="preco"> Preço </label> <input id="preco" name="preco"
					required="required" type="number" />
			</p>

			<p>
				<label for="qtdEstoque"> Qtd. em estoque </label> <input
					id="qtdEstoque" name="qtdEstoque" required="required" type="number" />
			</p>

			<p>
				<button
					onclick="window.location.href= 'file:///C:/Users/Talia/eclipse-workspace/SistemaLocadora/src/main/webapp/menu.html';">Finalizar
					Cadastro</button>
			</p>
		</form>
	</div>
</body>
</html>