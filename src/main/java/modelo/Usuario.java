package modelo;

import java.sql.SQLException;

import daoClass.DaoUsuario;

public class Usuario {

	public final int ROL_ADMIN = 9;
	public final int ROL_USUARIO = 2;
	
	
	private int id_usuario;
	private String nombre;
	private String apellidos;
	private String email;
	private String contraseña;
	private String direccion;
	private int rol;
	private String fecha_nacimiento;
	
	
	public Usuario() {
		
	}


	public Usuario(String nombre, String apellidos, String email, String contraseña, String direccion, int rol, String fecha_nacimiento) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.rol = rol;
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public Usuario(int id_usuario, String nombre, String apellidos, String email, String contraseña, String direccion,
			int rol, String fecha_nacimiento) {
	
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.rol = rol;
		this.fecha_nacimiento = fecha_nacimiento;
		
	}
	
	


	public Usuario(String nombre, String apellidos, String email, String contraseña, String direccion,String fecha_nacimiento) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	


	public Usuario(int id_usuario, String nombre, String apellidos, String email, String contraseña, String direccion, String fecha_nacimiento) {
		
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}

	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public void insertarUsuario() throws SQLException {
		
		DaoUsuario.getInstance().insertarUsuario(this);
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", contraseña=" + contraseña + ", direccion=" + direccion + ", rol=" + rol
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
	
	
	
	
	
	
	
}
