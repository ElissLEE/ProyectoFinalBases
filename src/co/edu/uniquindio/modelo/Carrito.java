package co.edu.uniquindio.modelo;

import java.util.Date;

public class Carrito {

	private int numeroCarrito;
	private Date fechaCreacion;
	private int costoTotal;
	private int cedulaCliente;

	public Carrito(int numeroCarrito, Date fechaCreacion, int costoTotal, int cedulaCliente) {
		this.numeroCarrito = numeroCarrito;
		this.fechaCreacion = fechaCreacion;
		this.costoTotal = costoTotal;
		this.cedulaCliente = cedulaCliente;
	}

	public Carrito() {
		super();
	}

	public int getNumeroCarrito() {
		return numeroCarrito;
	}

	public void setNumeroCarrito(int numeroCarrito) {
		this.numeroCarrito = numeroCarrito;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	@Override
	public String toString() {
		return "Carrito [numeroCarrito=" + numeroCarrito + ", fechaCreacion=" + fechaCreacion + ", costoTotal="
				+ costoTotal + ", cedulaCliente=" + cedulaCliente + "]";
	}

}
