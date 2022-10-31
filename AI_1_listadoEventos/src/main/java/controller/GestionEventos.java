package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "Para las tareas de Eventos", urlPatterns = { "/eventos" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IntEventoDao edao = new EventoDaoImpl();
	List<Evento> listaEvento = edao.mostrarActivos();
	String mensaje = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Entrando en init eventos");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "eliminar":				
			procedicimentoElminarEvento(request, response);						
			break;
		case "editar":
			procedicimentoEditarEvento(request, response);
			break;
		case "alta":
			procedicimentoAltaEvento(request, response);
			break;
		case "cancelar":
			procedimientoCancelarEvento(request,response);
			break;
		default:
			System.out.println("Opci�n err�nea: "+ opcion);
			
		}
		
		
		
	}
	protected void procedicimentoElminarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos un evento auxiliar que ser� el "evento" que hemos pasado por parametro
		Evento eventoAux = edao.buscarEvento(Integer.parseInt(request.getParameter("id")));
		//Si eliminar evento puede hacerse, devuelve true
		if(edao.eliminarEvento(eventoAux)==true) {
			listaEvento.remove(eventoAux);
			//Mostramos el mensaje
			mensaje="Evento "+ eventoAux.getNombre() + " ha sido eliminado";
		} else {
			mensaje = "Evento no se ha podido eliminar";
		}
		//A�adimos el atributo mensaje con el contenido mensaje para poder mostrarlo en el jsp
		request.setAttribute("mensaje", mensaje);
		//A�adimos el atributo listaEvento que mostrr� los ventos activos
		request.setAttribute("listaEventos", listaEvento);
		//Le pasamos la informaci�n al jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void procedicimentoAltaEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos un evento auxiliar sin par�metros
		Evento eventoAux = new Evento();
		//Le introducimos los par�metros necesarios
		eventoAux.setIdEvento(Integer.parseInt(request.getParameter("id")));
		eventoAux.setNombre(request.getParameter("nombre"));
		eventoAux.setPrecio(Integer.parseInt(request.getParameter("precio")));
		//Si creamos el nuevo evento devuelve 1 y por lo tanto le podemos a�adir a la lista y mostramos un mensaje
		if(edao.nuevoEvento(eventoAux)==1) {
			listaEvento.add(eventoAux);
			mensaje = "Alta realizado";
		} else {
			mensaje = "Alta no ha sido realizada";
		}
		//A�adimos atributo mensaje con su contenido y le enviamos al servlet home
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("home").forward(request, response);
		
	}
	
	protected void procedicimentoEditarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Introducimos el atributo evento siendo buscado directamente por el id pasado por par�metro		
		request.setAttribute("evento", edao.buscarEvento(Integer.parseInt(request.getParameter("id"))));
		//Le pasamos la informaci�n necesaria al jsp y lo mostramos
		request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
	}
	
	protected void procedimientoCancelarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos un evento auxiliar con buscarEvento y el id pasado por par�metro
		 Evento eventoAux = edao.buscarEvento(Integer.parseInt(request.getParameter("id")));
		 //Si cancelar se puede realizar devuelve 1 y su respectivo mensaje
		 if(edao.cancelarEvento(eventoAux)== 1) {
			 mensaje = "El estado del evento : "+eventoAux.getNombre() +" ahora es cancelado";
		 } else {
			 mensaje = "El evento : "+eventoAux.getNombre() +" no ha podido ser cancelado, ya que ya lo est�";
		 }
		 //A�adimos los atributos para poder llevar acabo la funci�n 
		 request.setAttribute("mensaje", mensaje);
		 request.setAttribute("listaEventos", listaEvento);
		 //Pasamos la informaci�n al jsp correspondiente
	     request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
