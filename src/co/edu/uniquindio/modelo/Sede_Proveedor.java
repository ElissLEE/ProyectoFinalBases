package co.edu.uniquindio.modelo;

import java.util.Date;

public class Sede_Proveedor {

	private int codigo;
	private int cantidad;
	private int precioTotal;
	private int costoUnitario;
	private int sede_codigoSede;
	private int producto_codigoProducto;
	private int proveedor_codigoProveedor;
	private Date fecha;

	public Sede_Proveedor(int codigo, int cantidad, int precioTotal, int costoUnitario, int sede_codigoSede,
			int producto_codigoProducto, int proveedor_codigoProveedor, Date fecha) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.costoUnitario = costoUnitario;
		this.sede_codigoSede = sede_codigoSede;
		this.producto_codigoProducto = producto_codigoProducto;
		this.proveedor_codigoProveedor = proveedor_codigoProveedor;
		this.fecha = fecha;
	}

	public Sede_Proveedor() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(int costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public int getSede_codigoSede() {
		return sede_codigoSede;
	}

	public void setSede_codigoSede(int sede_codigoSede) {
		this.sede_codigoSede = sede_codigoSede;
	}

	public int getProducto_codigoProducto() {
		return producto_codigoProducto;
	}

	public void setProducto_codigoProducto(int producto_codigoProducto) {
		this.producto_codigoProducto = producto_codigoProducto;
	}

	public int getProveedor_codigoProveedor() {
		return proveedor_codigoProveedor;
	}

	public void setProveedor_codigoProveedor(int proveedor_codigoProveedor) {
		this.proveedor_codigoProveedor = proveedor_codigoProveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Sede_Proveedor [codigo=" + codigo + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal
				+ ", costoUnitario=" + costoUnitario + ", sede_codigoSede=" + sede_codigoSede
				+ ", producto_codigoProducto=" + producto_codigoProducto + ", proveedor_codigoProveedor="
				+ proveedor_codigoProveedor + ", fecha=" + fecha + "]";
	}

}
