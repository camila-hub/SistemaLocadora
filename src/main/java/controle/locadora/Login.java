package controle.locadora;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ConexaoJDBC;
import modelo.dao.FuncionarioDAO;
import modelo.entidades.Funcionario;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");

		Funcionario fun = null;

		if (matricula == null || matricula.equals("") || senha == null || senha.equals("")) {
			return;
		}

		ConexaoJDBC conexao = new ConexaoJDBC();
		if (!conexao.conecta()) {
			return;
		}

		FuncionarioDAO funDAO = new FuncionarioDAO(conexao);

		try {
			fun = funDAO.recuperar(matricula);
		} catch (Exception e) {
			System.out.println("Matricula não encontrada!");
			return;
		}

		if (!fun.getSenha().equals(senha)) {
			return;
		}

		request.setAttribute("objFuncionario", fun);

		// Prepara a VIEW (processa as tags jsp <% %>, fazendo bind com o modelo)
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

		// Encaminha a VIEW como Resposta (Response)
		rd.forward(request, response);

		return;

	}

}
