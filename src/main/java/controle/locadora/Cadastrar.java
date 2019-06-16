package controle.locadora;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.business.FilmeBusiness;
import modelo.dao.ConexaoJDBC;
import modelo.entidades.Filme;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cadastrar() {
		System.out.println("Iniciado...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Iniciou!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// o Servlet é o CONTROLE
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// parametros da URL
		System.out.println("Parametros recebidos: " + request.getQueryString());

		// Instancia o MODELO, com os parâmetros passados no Request
		Filme fil = new Filme();
		fil.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		fil.setTitulo(request.getParameter("titulo"));
		fil.setDiretor(request.getParameter("diretor"));
		fil.setGenero(request.getParameter("genero"));
		fil.setPreco(Double.parseDouble(request.getParameter("preco")));
		fil.setQtdEstoque(Integer.parseInt(request.getParameter("qtdEstoque")));

		ConexaoJDBC conexao = new ConexaoJDBC();
		if (!conexao.conecta()) {
			return;
		}

		FilmeBusiness filBus = new FilmeBusiness(conexao);
		filBus.cadastrar(fil);

		// Prepara a VIEW (processa as tags jsp <% %>, fazendo bind com o modelo)
		RequestDispatcher rd = request.getRequestDispatcher("/cadastrar.jsp");

		// Encaminha a VIEW como Resposta (Response)
		rd.forward(request, response);

		return;

	}

}