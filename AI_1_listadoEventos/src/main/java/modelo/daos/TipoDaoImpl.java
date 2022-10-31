package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Evento;
import modelo.beans.Tipo;

public class TipoDaoImpl implements IntTipoDao{

private List<Tipo> lista;
	
	public TipoDaoImpl() {
		lista = new ArrayList<>();
		
		cargarDatos();
	}

	private void cargarDatos() {
		
		
		lista.add(new Tipo(1,"concierto","descripción 1"));
		lista.add(new Tipo(2,"despedida","descripción 2"));
		lista.add(new Tipo(3,"cumpleaños","descripción 3"));
		lista.add(new Tipo(4,"boda","descripción 4"));
		
	}

	@Override
	public Tipo buscarTipo(int idTipo) {
		Tipo aux = new Tipo();
		aux.setIdTipo(idTipo);
		
		int pos = lista.indexOf(aux);
		
		//Si la posición es -1 devuelvo 0 (por que no existe)
		if(pos==-1)
				return null;
		//si no, le buscamos por el index
		else
			return (lista.get(pos));
	}

	@Override
	public List<Tipo> mostrarTodos() {
		//Condición si es null mostramos mensaje
				if(lista == null) {
					System.out.println("lista vacía");
				}
				return lista;
	}

	@Override
	public int inserTipo(Tipo tipo) {
		//Condición si el evento existe devolvemos 0 y no se añade
				if(lista.contains(tipo))
					return 0;
				else
					//Añadimos evento, ponemos la expresión regular ?1:0 porque add(evento) devuelve boolean
					//En este caso devuelve 1 si se puede añadir y 0 en caso contrario
					return lista.add(tipo)?1:0;		
	}

	@Override
	//Método editar evento pasando el evento por parámetro
	public int editarTipo(Tipo tipo) {
		//sabemos la posición del evento buscado
		int pos = lista.indexOf(tipo);
		//Si es menor a 1 no existe
		if(pos==-1)
			return 0;
		//Accedemos a la posicion con pos y modificamos el evento
		else
			return(lista.set(pos, tipo)!=null)?1:0;
	}

	@Override
	public boolean eliminarTipo(Tipo tipo) {
		int pos = lista.indexOf(tipo);
		
		if(pos==-1)
			return false;
		else
			return(lista.remove(tipo));
	}

	
}
