package daoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Producto;

public class DaoProducto {

	public Connection conexion = null;
	private static DaoProducto instance = null;
	
	/*
	 * Constructor para la conexion con la base de datos 
	 */
	public DaoProducto() throws SQLException {
		
		conexion = DbConnection.getConnection();
	}
	
	/**
	 * Metodo para crear un DaoProducto si no existe y si ya existe usara el mismo.
	 * @return un Dao
	 * @throws SQLException
	 */
	public static DaoProducto getInstance() throws SQLException {
		
		if(instance == null) {
			
			instance = new DaoProducto();
		}
		
		return instance;
	}
	
	
	/**
	 * Metodo que se conecta con la base de datos e inserta informacion en la misma.
	 * @param p
	 * @throws SQLException
	 */
	public void insertarProducto(Producto p) throws SQLException {
		
		String consulta = "INSERT INTO productos(nombre, peso, precio, descripcion, imagen_url) Value(?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conexion.prepareStatement(consulta);
		
		ps.setString(1, p.getNombre());
		ps.setString(2, p.getPeso());
		ps.setString(3, p.getPrecio());
		ps.setString(4, p.getDescripcion());
		ps.setString(4, p.getImagen_url());
		
		ps.executeUpdate();
	}
	/**
	 * Metodo para listar desde la base de datos.
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Producto> obtenerProducto() throws SQLException{
		
		String sql = "SELECT * FROM productos";
		
		PreparedStatement ps = conexion.prepareStatement(sql);
		
		ResultSet res = ps.executeQuery();
		
		ArrayList<Producto> list = null;
		
		while(res.next()) {
			
			if(list == null) {
				list = new ArrayList<Producto>();
			}
			
			list.add(new Producto(res.getInt("id_producto"), res.getString("nombre"), res.getString("peso"), res.getString("precio"), res.getString("descripcion"), res.getString("imagen_url")));
		}
		return list;
	}
	
	/**
	 * Metodo para trasformar la lista de la base de datos a JSON.
	 * @return
	 * @throws SQLException
	 */
	public String obtenerProductoJson() throws SQLException {
		
		String json = "";
		
		Gson gson = new Gson();
		
		json = gson.toJson(this.obtenerProducto());
		
		return json;
	}
}
