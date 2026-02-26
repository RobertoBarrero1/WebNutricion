package daoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

public class DaoUsuario {

	public Connection conexion = null;// Variable para guardar la conexion co la base de datos.
	public static DaoUsuario instance = null;// Variable que guarda un DaoUsuario 
	

	/**
	 * Costructor para crear conexion a la base de datos.
	 * @throws SQLException
	 */
	public DaoUsuario() throws SQLException {
		
		conexion = DbConnection.getConnection();
	}
	
	/**
	 * metodo incia la conexion con la base de datos y si ya esta creada la mantiene.
	 * @return
	 * @throws SQLException 
	 */
	public static DaoUsuario getInstance() throws SQLException {
		
		if(instance == null) {
			instance = new DaoUsuario();
		}
		return instance;
	}
	
	
	/**
	 * Metodo para insertar datos en la tabla correcta de la base de dados.
	 * @param u
	 * @throws SQLException
	 */
	public void insertarUsuario(Usuario u) throws SQLException {
		
		String consulta = "INSERT INTO usuario(nombre, apellidos, email, contraseña, direccion, fecha_nacimiento) VALUE(?, ?, ?, ?, ?, ?)";
		
	  PreparedStatement ps = conexion.prepareStatement(consulta);// Significa que esta lisa para la consulta.
	  
	  ps.setString(1, u.getNombre());
	  ps.setString(2, u.getApellidos());
	  ps.setString(3, u.getEmail());
	  ps.setString(4, u.getContraseña());
	  ps.setString(5, u.getDireccion());
	  ps.setString(6, u.getFecha_nacimiento());
	  
	  ps.executeUpdate();
	  
	}

	/**
	 * Metodo para listar usuarios desde la base de datos
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Usuario> obtenerUsuario() throws SQLException{
		
		String sql = "SELECT * FROM usuario";  //Le decimos de donde va a ser la lista.
		
		PreparedStatement ps = conexion.prepareStatement(sql);  // Significa que esta lisa para la consulta.
		
		ResultSet res = ps.executeQuery();   //Con esto envia una consulta, la base de datos responde con una tabla que se guarda en res.
		
		ArrayList<Usuario> list = null;  // Variable que guarda usuarios.
		
		while(res.next()) {  //A res le añadimos next para que empieze por el primero en la lista y no en null.
			
			if(list == null) {
				list = new ArrayList<Usuario>();  //Si la lista no existe, creala.
			}
			
			list.add(new Usuario(res.getInt("id_usuario"), res.getString("nombre"), res.getString("apellidos"), res.getString("email"), res.getString("contraseña"), res.getString("direccion"), res.getString("fecha_nacimiento")) );
			//Esta linea lo que le dice a la base de dato que cosas me tiene que listar.
		}
		return list;
	}
	
	
	/**
	 * Metodo que convierte la una lista de la base de datos en JSON.
	 * @return
	 * @throws SQLException
	 */
	public String obtenerUsuarioJson() throws SQLException {
		
		String json = "";  // variable para guardar el resultado.
		
		Gson gson = new Gson(); // objeto que sirve para crear ubjetos de java a json.
		
		json = gson.toJson(this.obtenerUsuario()); //toJson trasforma obtenerUsuario a formato Json.
		
		return json;
		
	}

	
	
	
}
