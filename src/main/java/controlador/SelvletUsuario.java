package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import daoClass.DaoUsuario;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class SelvletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SelvletUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter(); // prepara un camino para que el servido escriva en el navegador.
		try {
			System.out.println(DaoUsuario.getInstance().obtenerUsuarioJson()); //Obtiene datos en a consola no en el navegador.
			out.print(DaoUsuario.getInstance().obtenerUsuarioJson());// eta linea es la importante le manda la info al usuario.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Sirve para que lea los datos desde HTML 
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String contraseña = request.getParameter("contraseña");
		String direccion = request.getParameter("direccion");
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		
		//Crea un objeto.
		Usuario u1 = new Usuario(nombre, apellidos, email, contraseña, direccion, fecha_nacimiento);
		System.out.println(u1.toString());//Esto es para verlo en el panel de eclipse
		
		try {
			u1.insertarUsuario();// esta linea inserta dentro de de la base de datos.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
