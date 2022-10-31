package test;

import java.util.Date;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

public class testEventoDao {
	public static void main(String[] args) {
		IntEventoDao edao = new EventoDaoImpl();
		
		Evento even1 = new Evento(10,"Evento prueba","Descripción prueba",new Date(),100,"Calle prueba2","Activo","Destacado",40,10,200,new Tipo());
		edao.nuevoEvento(even1);
		
		edao.cancelarEvento(even1);
		
		for(Evento ele: edao.mostrarActivos()){
			System.out.println(ele);
		}
		
		System.out.println("aqui borro el 3");
		
		edao.eliminarEvento(3);
		
		System.out.println("");
		
		for(Evento ele: edao.buscarEventos()){
			System.out.println(ele);
		}
		
		
		System.out.println("");
		
		System.out.println(edao.buscarEvento(7));
		
		System.out.println("");
		
		
		System.out.println( "muestro evento id = 2 : " + edao.buscarEvento(4));
		
		edao.buscarEvento(4);
		
		System.out.println("Mostramos activos");
		
		System.out.println(edao.mostrarActivos());
		
		
		System.out.println("muestro de nuevo activos");
		
		System.out.println(edao.mostrarActivos());
		
		System.out.println("listar Todos");
		
		for(Evento ele: edao.mostrarActivos()){
			System.out.println(ele);
		}
		
		System.out.println("");
		
		for(Evento ele: edao.buscarEventos()){
			System.out.println(ele);
		}
		
		System.out.println("muestro activos");
	
		System.out.println(edao.mostrarActivos());
			
		
	
	System.out.println(edao.mostrarActivos());
		
	}
}
