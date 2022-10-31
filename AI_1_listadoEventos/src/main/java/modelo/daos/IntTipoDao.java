package modelo.daos;

import java.util.List;

import modelo.beans.Tipo;

public interface IntTipoDao {
	
	
	Tipo buscarTipo(int idTipo);
	List<Tipo> mostrarTodos();
	int inserTipo(Tipo tipo);
	int editarTipo(Tipo tipo);
	boolean eliminarTipo(Tipo tipo);

}
