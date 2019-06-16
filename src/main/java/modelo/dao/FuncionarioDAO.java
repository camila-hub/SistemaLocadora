package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Funcionario;

public class FuncionarioDAO implements CrudDAO<Funcionario> {

	private ConexaoJDBC conexaoJDBC;

	public FuncionarioDAO(ConexaoJDBC conexaoJDBC) {
		this.conexaoJDBC = conexaoJDBC;
	}

	@Override
	public boolean deletar(Funcionario obj) {

		String sql = "DELETE FROM tb_funcionario WHERE matricula = ?";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setInt(1, obj.getMatricula());

			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			try {
				declaracaoPrep.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return false;
		}

		try {
			declaracaoPrep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean insert(Funcionario obj) {

		String sql = "INSERT INTO tb_funcionario (matricula,nome,senha) " + "VALUES (?,?,?)";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {
			declaracaoPrep.setInt(1, obj.getMatricula());
			declaracaoPrep.setString(2, obj.getNome());
			declaracaoPrep.setString(3, obj.getSenha());

			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			try {
				declaracaoPrep.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return false;
		}

		try {
			declaracaoPrep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	private ResultSet query(String filtro) {

		String sql = "SELECT * FROM tb_funcionario ";

		if (filtro != null) {
			sql += "WHERE matricula = '" + filtro + "' ORDER BY matricula";
		}

		return this.conexaoJDBC.consulta(sql);
	}

	@Override
	public List<Funcionario> recuperar() {

		ResultSet dados = this.query(null);

		// se a consulta contiver erros
		if (dados == null) {
			return null;
		}

		try {

			if (!dados.first()) {
				dados.close();
				return null;
			}

			List<Funcionario> list = new ArrayList<Funcionario>();

			// inclui todos os registros provenientes do banco de dados
			// na lista
			do {
				Funcionario fun = new Funcionario();
				fun.setMatricula(dados.getInt("matricula"));
				fun.setNome(dados.getString("nome"));
				fun.setSenha(dados.getString("senha"));
				list.add(fun);

			} while (dados.next());

			dados.close();

			return list;

		} catch (SQLException e) {

			try {
				dados.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return null;
		}

	}

	@Override
	public Funcionario recuperar(String matricula) {

		ResultSet dados = this.query(matricula);

		Funcionario fun = new Funcionario();

		try {

			if (dados.first()) {
				fun.setMatricula(dados.getInt("matricula"));
				fun.setNome(dados.getString("nome"));
				fun.setSenha(dados.getString("senha"));
			}

			dados.close();

		} catch (SQLException e) {

			try {
				dados.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return null;
		}

		return fun;
	}

	@Override
	public boolean update(Funcionario obj) {
		String sql = "UPDATE tb_funcionario SET matricula = ?, nome = ?, senha = ? WHERE matricula = ?";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setInt(1, obj.getMatricula());
			declaracaoPrep.setString(2, obj.getNome());
			declaracaoPrep.setString(3, obj.getSenha());

			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			try {
				declaracaoPrep.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return false;
		}

		try {
			declaracaoPrep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
