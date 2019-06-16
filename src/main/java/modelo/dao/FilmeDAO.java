package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Filme;

public class FilmeDAO implements CrudDAO<Filme> {

	private ConexaoJDBC conexaoJDBC;

	public FilmeDAO(ConexaoJDBC conexaoJDBC) {
		this.conexaoJDBC = conexaoJDBC;
	}

	@Override
	public boolean deletar(Filme obj) {

		String sql = "DELETE FROM tb_filme WHERE codigo = ?";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setInt(1, obj.getCodigo());

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
	public boolean insert(Filme obj) {

		String sql = "INSERT INTO tb_filme (codigo,titulo,diretor,genero,preco,qtdEstoque) " + "VALUES (?,?,?,?,?,?)";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {
			declaracaoPrep.setInt(1, obj.getCodigo());
			declaracaoPrep.setString(2, obj.getTitulo());
			declaracaoPrep.setString(3, obj.getDiretor());
			declaracaoPrep.setString(4, obj.getGenero());
			declaracaoPrep.setDouble(5, obj.getPreco());
			declaracaoPrep.setInt(6, obj.getQtdEstoque());

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

		String sql = "SELECT * FROM tb_filme ";

		if (filtro != null) {
			sql += "WHERE codigo = '" + filtro + "' ORDER BY codigo";
		}

		return this.conexaoJDBC.consulta(sql);
	}

	@Override
	public List<Filme> recuperar() {

		ResultSet dados = this.query(null);

		// se a consulta contiver erros
		if (dados == null)
			return null;

		try {

			if (!dados.first()) {
				dados.close();
				return null;
			}

			List<Filme> list = new ArrayList<Filme>();

			// inclui todos os registros provenientes do banco de dados
			// na lista
			do {
				Filme fil = new Filme();
				fil.setCodigo(dados.getInt("codigo"));
				fil.setTitulo(dados.getString("titulo"));
				fil.setDiretor(dados.getString("diretor"));
				fil.setGenero(dados.getString("genero"));
				fil.setPreco(dados.getDouble("preco"));
				fil.setQtdEstoque(dados.getInt("qtdEstoque"));
				list.add(fil);

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
	public Filme recuperar(String codigo) {

		ResultSet dados = this.query(codigo);

		Filme fil = new Filme();

		try {
			if (dados.first()) {

				fil.setCodigo(dados.getInt("codigo"));
				fil.setTitulo(dados.getString("titulo"));
				fil.setDiretor(dados.getString("diretor"));
				fil.setGenero(dados.getString("genero"));
				fil.setPreco(dados.getDouble("preco"));
				fil.setQtdEstoque(dados.getInt("qtdEstoque"));

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

		return fil;
	}

	@Override
	public boolean update(Filme obj) {
		String sql = "UPDATE tb_filme SET codigo = ?, titulo = ?, maticula = ?, genero = ?, "
				+ "preco = ?, qtdEstoque = ? WHERE codigo = ?";

		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setInt(1, obj.getCodigo());
			declaracaoPrep.setString(2, obj.getTitulo());
			declaracaoPrep.setString(3, obj.getDiretor());
			declaracaoPrep.setString(4, obj.getGenero());
			declaracaoPrep.setDouble(5, obj.getPreco());
			declaracaoPrep.setInt(6, obj.getQtdEstoque());

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
