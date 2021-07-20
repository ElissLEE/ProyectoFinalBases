package co.edu.uniquindio.modelo;

public class TelefonoProveedor {

	private String numero;
	private int proveedor_codigoProveedor;

	public TelefonoProveedor(String numero, int proveedor_codigoProveedor) {
		this.numero = numero;
		this.proveedor_codigoProveedor = proveedor_codigoProveedor;
	}

	public TelefonoProveedor() {
		super();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getProveedor_codigoProveedor() {
		return proveedor_codigoProveedor;
	}

	public void setProveedor_codigoProveedor(int proveedor_codigoProveedor) {
		this.proveedor_codigoProveedor = proveedor_codigoProveedor;
	}

	@Override
	public String toString() {
		return "TelefonoProveedor [numero=" + numero + ", proveedor_codigoProveedor=" + proveedor_codigoProveedor + "]";
	}

}
