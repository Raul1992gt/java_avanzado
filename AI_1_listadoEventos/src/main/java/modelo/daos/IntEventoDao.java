package modelo.daos;

import java.util.List;
import modelo.beans.Evento;
import modelo.beans.Tipo;

public interface IntEventoDao {
	
	Evento buscarEvento(int idEvento);
	List<Evento> buscarEventos();
	int nuevoEvento(Evento evento);
	int eliminarEvento(int idEvento);
	int editarEvento(Evento evento);
	boolean eliminarEvento(Evento evento);
	int cancelarEvento(Evento evento);
	List<Evento> mostrarActivos();
	
	
}
