package co.edu.uniquindio.modelo;

public class Carrito_Sede_Proveedor {

	private int cantidad;
	private int carrito_numeroCarrito;
	private int codigoSP;

	public Carrito_Sede_Proveedor(int cantidad, int carrito_numeroCarrito, int codigoSP) {
		this.cantidad = cantidad;
		this.carrito_numeroCarrito = carrito_numeroCarrito;
		this.codigoSP = codigoSP;
	}

	public Carrito_Sede_Proveedor() {
		super();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCarrito_numeroCarrito() {
		return carrito_numeroCarrito;
	}

	public void setCarrito_numeroCarrito(int carrito_numeroCarrito) {
		this.carrito_numeroCarrito = carrito_numeroCarrito;
	}

	public int getCodigoSP() {
		return codigoSP;
	}

	public void setCodigoSP(int codigoSP) {
		this.codigoSP = codigoSP;
	}

	@Override
	public String toString() {
		return "Carrito_Sede_Proveedor [cantidad=" + cantidad + ", carrito_numeroCarrito=" + carrito_numeroCarrito
				+ ", codigoSP=" + codigoSP + "]";
	}

}
