package modelo.business;

import java.util.List;

import modelo.dao.ConexaoJDBC;
import modelo.dao.FilmeDAO;
import modelo.entidades.Filme;

public class FilmeBusiness {

	private ConexaoJDBC conexao;
	
	public FilmeBusiness(ConexaoJDBC conexao) {
		this.conexao = conexao;
	}


	// cadastra um novo filme no BD
    public boolean cadastrar(Filme fil) {
    	
    	FilmeDAO filmeDAO = new FilmeDAO(this.conexao);
    	
    	if (filmeDAO.insert(fil)) {    		
            return true;
    	}
    	
    	return false;
    }

		
	
	//Retorna a lista completa de todos os filmes do BD, apenas os objetos
	public List<Filme> listar() {
		
		FilmeDAO filmeDAO = new FilmeDAO(this.conexao);
		return filmeDAO.recuperar();
	  	
	}
	
	/*
	//Retorna para o main uma String com os dados dos filmes cadastrados na listFilmes
    public String listar() {
    	
        String info = "-----------Detalhes dos Filmes-----------\n\n";
        
        List<Filme> listFilmes = listarSimples();
        
        for(Filme fil : listFilmes){ 
        	
            info += fil +"\n";
        }
        
        return info; 
    }
	*/
	
	
    // remove um filme do BD
	public void remover(Filme fil) {
			
		FilmeDAO filmeDAO = new FilmeDAO(this.conexao);
    	
	  	filmeDAO.deletar(fil);   

	}
    

}
