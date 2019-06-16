package controle.locadora;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ConexaoJDBC;
import modelo.dao.FilmeDAO;
import modelo.entidades.Filme;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/atualizarcadastro")
public class AtualizarCadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarCadastro() {
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
		
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String diretor = request.getParameter("diretor");
		String genero = request.getParameter("diretor");
		double preco = Double.parseDouble(request.getParameter("preco"));
		int qtdEstoque = Integer.parseInt(request.getParameter("qtdEstoque"));
		
		Filme filme = null;

		if (codigo == null) {
			return;
		}

		ConexaoJDBC conexao = new ConexaoJDBC();
		if (!conexao.conecta()) {
			return;
		}

		FilmeDAO filDAO = new FilmeDAO(conexao);
		filme = filDAO.recuperar(codigo);
		
		filme.setTitulo(titulo);
		filme.setDiretor(diretor);
		filme.setGenero(genero);
		filme.setPreco(preco);
		filme.setQtdEstoque(qtdEstoque);
		
		filDAO.update(filme);
		
		request.setAttribute("objFilme", filme);

		// Prepara a VIEW (processa as tags jsp <% %>, fazendo bind com o modelo)
		RequestDispatcher rd = request.getRequestDispatcher("/atualizarcadastro.jsp");

		// Encaminha a VIEW como Resposta (Response)
		rd.forward(request, response);

		return;
		
	}
	
}
