<%@page import="modelo.entidades.Filme"%>

<html>

<head>
<title>Sistema Locadora</title>
</head>
<body>

	<%
		Filme objFilme = (Filme) request.getAttribute("objFilme");
	%>


	<div id="login">
		<!--formulario de login-->

		<form action="login" method="get">
			<h1>Bem-vindo</h1>
			<p>
				<label for="matricula">Matricula </label> <input id="matricula"
					required="required" type="number" placeholder="Ex. 12345" />
			</p>

			<p>
				<label for="senha">Senha</label> <input type="password" id="senha"
					required="required" placeholder="Senha" />
			</p>

			<p>
				<input type="submit" value="ACESSAR"
					onclick="window.location.href= 'file:///C:/Users/Talia/eclipse-workspace/SistemaLocadora/src/main/webapp/menu.html';">
			</p>

		</form>
	</div>
</body>
</html>