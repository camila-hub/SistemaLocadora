package modelo.entidades;

public class Funcionario {

	private int matricula;
	private String nome;
	private String senha;

	public int getMatricula() {
		return this.matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
