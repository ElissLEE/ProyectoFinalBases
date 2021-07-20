package co.edu.uniquindio.modelo;

public class Ciudad {

	private int codigoPostal;
	private String nombre;

	public Ciudad(int codigoPostal, String nombre) {
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
	}

	public Ciudad() {
		super();
	}
	
	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad [codigoPostal=" + codigoPostal + ", nombre=" + nombre + "]";
	}
}
