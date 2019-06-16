package modelo.entidades;

public class Filme {
	
	private int codigo;
	private String titulo;
	private String diretor;
	private String genero;
	private double preco;
	private int qtdEstoque;
	
	public Filme() {
		this.codigo = 0;
		this.titulo = "Não informado";
		this.diretor = "Não informado";
		this.genero = "Não informado";
		this.preco = 0;
		this.qtdEstoque = 0;
	}
	
	public Filme(int codigo, String titulo, String diretor, String genero, double preco, int qtdEstoque) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.diretor = diretor;
		this.genero = genero;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
	}

	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDiretor() {
		return this.diretor;
	}
	public String getGenero() {
		return this.genero;
	}
	public double getPreco() {
		return this.preco;
	}
	public int getQtdEstoque() {
		return this.qtdEstoque;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return this.codigo + " - " + this.titulo + " por " + this.diretor + " (" + this.genero 
				+ "); R$ " + String.format("%.2f", this.preco) + " [" + this.qtdEstoque + ']';
	}
	
}
