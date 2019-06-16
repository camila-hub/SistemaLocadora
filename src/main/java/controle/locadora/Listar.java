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

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/listar")
public class Listar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Listar() {
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

		ConexaoJDBC conexao = new ConexaoJDBC();
		if (!conexao.conecta()) {
			return;
		}
			
		FilmeBusiness filmeBus = new FilmeBusiness(conexao);

		request.setAttribute("listaFilmes", filmeBus.listar());

		// Prepara a VIEW (processa as tags jsp <% %>, fazendo bind com o modelo)
		RequestDispatcher rd = request.getRequestDispatcher("/listar.jsp");

		// Encaminha a VIEW como Resposta (Response)
		rd.forward(request, response);

		return;
	}

}
