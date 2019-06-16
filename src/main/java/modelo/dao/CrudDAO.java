package modelo.dao;

import java.util.List;

//Toda classe DAO deverá implementar esta interface
public interface CrudDAO<T> {

	public boolean deletar(T obj); // (DELETE)

	public boolean insert(T obj); // (INSERT/CREATE)

	public List<T> recuperar(); // (RECUPERA CONJUNTO)

	public T recuperar(String chave); // (RECUPERA UM ELEMENTO)

	public boolean update(T obj); // (UPDATE)

}
