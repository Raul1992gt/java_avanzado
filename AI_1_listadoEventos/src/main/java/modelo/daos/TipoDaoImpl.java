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
		
		
		lista.add(new Tipo(1,"concierto","descripci�n 1"));
		lista.add(new Tipo(2,"despedida","descripci�n 2"));
		lista.add(new Tipo(3,"cumplea�os","descripci�n 3"));
		lista.add(new Tipo(4,"boda","descripci�n 4"));
		
	}

	@Override
	public Tipo buscarTipo(int idTipo) {
		Tipo aux = new Tipo();
		aux.setIdTipo(idTipo);
		
		int pos = lista.indexOf(aux);
		
		//Si la posici�n es -1 devuelvo 0 (por que no existe)
		if(pos==-1)
				return null;
		//si no, le buscamos por el index
		else
			return (lista.get(pos));
	}

	@Override
	public List<Tipo> mostrarTodos() {
		//Condici�n si es null mostramos mensaje
				if(lista == null) {
					System.out.println("lista vac�a");
				}
				return lista;
	}

	@Override
	public int inserTipo(Tipo tipo) {
		//Condici�n si el evento existe devolvemos 0 y no se a�ade
				if(lista.contains(tipo))
					return 0;
				else
					//A�adimos evento, ponemos la expresi�n regular ?1:0 porque add(evento) devuelve boolean
					//En este caso devuelve 1 si se puede a�adir y 0 en caso contrario
					return lista.add(tipo)?1:0;		
	}

	@Override
	//M�todo editar evento pasando el evento por par�metro
	public int editarTipo(Tipo tipo) {
		//sabemos la posici�n del evento buscado
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
