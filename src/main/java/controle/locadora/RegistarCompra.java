package controle.locadora;

import java.io.IOException;

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
@WebServlet("/registarcompra")
public class RegistarCompra extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistarCompra() {
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
		
	}
	
}
