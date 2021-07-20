package co.edu.uniquindio.modelo;

public class Sede {

	private int codigoSede;
	private String direccion;
	private int ciudad_codigoPostal;

	public Sede(int codigoSede, String direccion, int ciudad_codigoPostal) {
		this.codigoSede = codigoSede;
		this.direccion = direccion;
		this.ciudad_codigoPostal = ciudad_codigoPostal;
	}

	public Sede() {
		super();

	}

	public int getCodigoSede() {
		return codigoSede;
	}

	public void setCodigoSede(int codigoSede) {
		this.codigoSede = codigoSede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCiudad_codigoPostal() {
		return ciudad_codigoPostal;
	}

	public void setCiudad_codigoPostal(int ciudad_codigoPostal) {
		this.ciudad_codigoPostal = ciudad_codigoPostal;
	}

	@Override
	public String toString() {
		return "Sede [codigoSede=" + codigoSede + ", direccion=" + direccion + ", ciudad_codigoPostal="
				+ ciudad_codigoPostal + "]";
	}

	
}
