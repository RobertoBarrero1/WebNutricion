package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import daoClass.DaoProducto;

/**
 * Servlet implementation class AltaProducto
 */
@WebServlet("/AltaProducto")
public class SelvletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SelvletProducto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		try {
			System.out.println(DaoProducto.getInstance().obtenerProductoJson());
			out.print(DaoProducto.getInstance().obtenerProductoJson());
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
		
		String nombre = request.getParameter("nombre");
		String peso = request.getParameter("peso");
		String precio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		String imagen_url = request.getParameter("imagen_url");
		
		Producto p1 = new Producto(nombre, peso, precio, descripcion, imagen_url);
		System.out.println(p1.toString());
		
		try {
			p1.insertarProducto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("error");
		
	}

}
