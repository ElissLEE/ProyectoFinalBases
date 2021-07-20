package co.edu.uniquindio.modelo;

public class Proveedor {

	private int codigoProveedor;
	private String cedula;
	private String nombre;
	private String apellido;

	public Proveedor(int codigoProveedor, String cedula, String nombre, String apellido) {
		this.codigoProveedor = codigoProveedor;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Proveedor() {
		super();

	}

	public int getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Proveedor [codigoProveedor=" + codigoProveedor + ", cedula=" + cedula + ", nombre=" + nombre
				+ ", apellido=" + apellido + "]";
	}

}
