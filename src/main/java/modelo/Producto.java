package modelo;

import java.sql.SQLException;

import daoClass.DaoProducto;

public class Producto {

	
	private int id_producto;
	private String nombre;
	private String peso;
	private String precio;
	private String descripcion;
	private String imagen_url;
	
	
	public Producto() {
		
	}


	public Producto(String nombre, String peso, String precio, String descripcion, String imagen_url) {
		
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen_url = imagen_url;
	}


	public Producto(int id_producto, String nombre, String peso, String precio, String descripcion, String imagen_url) {
		
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen_url = imagen_url;
	}
	
	


	public Producto(int id_producto, String nombre, String peso, String precio, String descripcion) {
		
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
		this.descripcion = descripcion;
	}


	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagen_url() {
		return imagen_url;
	}


	public void setImagen_url(String imagen_url) {
		this.imagen_url = imagen_url;
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void insertarProducto() throws SQLException {
		
		DaoProducto.getInstance().insertarProducto(this);
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", peso=" + peso + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", imagen_url=" + imagen_url + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
