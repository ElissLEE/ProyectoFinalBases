package co.edu.uniquindio.modelo;

public class Producto {

	private int codigoProducto; 
	private String nombre;
	private int tipo_tipoProducto;
	private String descripcion;
	private int stock;
	private int precio;
	
	public Producto(int codigoProducto, String nombre, int tipo_tipoProducto, String descripcion, int stock, int precio) {
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.tipo_tipoProducto=tipo_tipoProducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}
	
	public Producto() {
		super();
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	

	public int getTipo_tipoProducto() {
		return tipo_tipoProducto;
	}

	public void setTipo_tipoProducto(int tipo_tipoProducto) {
		this.tipo_tipoProducto = tipo_tipoProducto;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", tipoProducto=" + tipo_tipoProducto
				+ ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio + "]";
	}
	
	
}
