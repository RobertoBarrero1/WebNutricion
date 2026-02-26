package daoClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection instance = null;
	
	
	public DbConnection() {
		
	}
	
	/**
	 * este metodo crea la conexion entre esta capa y base de datos.
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		if(instance == null) {
			String url = "jdbc:mysql://localhost:3307/WebNutricion2"; //En el caso de que el puerto cambie o la base de datos estos datos tienen que ser modificados.
			String usuario = "root";
			String password = "";
			
			instance = DriverManager.getConnection(url,usuario,password);
		}
		return instance;
	}
}
