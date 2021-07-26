package co.edu.uniquindio.conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.edu.uniquindio.modelo.*;

public class ConexionBase {

	private static String url = "jdbc:mysql://localhost:3306/buenPrecio";
	private static String usuario = "root";
	private static String password = "1234567890";
	private static Connection conexion = null;

	public ConexionBase() {

	}

	public static void conectar() {

		try {

			conexion = DriverManager.getConnection(url, usuario, password);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos " + e.getMessage());
		}
	}

	// --------------------------- CIUDAD --------------------------//

	public int retornarCodigoPostal(String ciudad) {

		switch (ciudad) {

		case "armenia":
			return 1;

		case "medellin":
			return 2;

		case "bogota":
			return 3;

		}

		return -1;
	}

	public String retornarNombreCiudad(int codigo) {

		switch (codigo) {

		case 1:
			return "armenia";

		case 2:
			return "medellin";

		case 3:
			return "bogota";

		}

		return "No se encontro la ciudad";

	}

	// --------------------------- TIPO_PRODUCTO --------------------------//

	public int retornarTipoProducto(String tipo) {

		switch (tipo) {

		case "higiene":
			return 1;

		case "hogar":
			return 2;

		case "belleza":
			return 3;

		case "mascota":
			return 4;

		case "alimento":
			return 5;
		}
		return -1;
	}

	public String retornarNombreTipo(int codigoTipo) {

		switch (codigoTipo) {

		case 1:
			return "higiene";

		case 2:
			return "hogar";

		case 3:
			return "belleza";

		case 4:
			return "mascota";

		case 5:
			return "alimento";

		}

		return "No se encontro el tipo";
	}

	// --------------------------- SEDE --------------------------//

	public boolean crearSede(int codigoSede, String direccion, String codigoPostal) {

		boolean centinela = false;

		int codigoCiudad = retornarCodigoPostal(codigoPostal);
		PreparedStatement preparedStatement = null;

		if (codigoCiudad != -1) {

			conectar();

			try {
				preparedStatement = conexion
						.prepareStatement("insert into sede(codigoSede, direccion, ciudad_codigoPostal) values(?,?,?)");
				preparedStatement.setInt(1, codigoSede);
				preparedStatement.setString(2, direccion);
				preparedStatement.setInt(3, codigoCiudad);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;

				} else {
					return centinela;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return centinela;
	}

	public boolean eliminarSede(int codigoSede) {

		boolean centinela = false;

		PreparedStatement preparedStatement = null;
		conectar();

		try {

			preparedStatement = conexion.prepareStatement("delete from sede where codigoSede=?");
			preparedStatement.setInt(1, codigoSede);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;
			} else {

				return centinela;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public Sede buscarSede(int codigoSede) {

		Sede sede = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		conectar();

		try {

			preparedStatement = conexion
					.prepareStatement("select codigoSede, direccion, ciudad_codigoPostal from sede where codigoSede=?");
			preparedStatement.setInt(1, codigoSede);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				sede = new Sede();
				sede.setCodigoSede(resultado.getInt("codigoSede"));
				sede.setDireccion(resultado.getString("direccion"));
				sede.setCiudad_codigoPostal(resultado.getInt("ciudad_codigoPostal"));

			}

			conexion.close();

			if (sede == null) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado la sede");
			} else {
				return sede;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return sede;
	}

	public boolean modificarSede(int codigoSedeBusqueda, String direccion, String nombreCiudad, int codigoSedeNuevo) {

		boolean centinela = false;
		int codigoCiudad = retornarCodigoPostal(nombreCiudad);

		PreparedStatement preparedStatement = null;

		if (codigoCiudad != -1) {

			conectar();

			try {
				preparedStatement = conexion.prepareStatement(
						"update sede set codigoSede=?, direccion=?, ciudad_codigoPostal=? where codigoSede=?");
				preparedStatement.setInt(1, codigoSedeNuevo);
				preparedStatement.setString(2, direccion);
				preparedStatement.setInt(3, codigoCiudad);
				preparedStatement.setInt(4, codigoSedeBusqueda);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {

					conexion.close();

					return centinela = true;
				} else {
					return centinela;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return centinela;
	}

	public ArrayList<Sede> cargarSedes() {

		ArrayList<Sede> listaSedes = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		Sede sede = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from sede");
			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				sede = new Sede();
				sede.setCodigoSede(resultado.getInt("codigoSede"));
				sede.setDireccion(resultado.getString("direccion"));
				sede.setCiudad_codigoPostal(resultado.getInt("ciudad_codigoPostal"));

				listaSedes.add(sede);
			}

			preparedStatement.close();
			resultado.close();
			conexion.close();

			return listaSedes;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	// --------------------------- PRODUCTO--------------------------//

	public boolean crearProducto(int codigoProducto, String nombre, String descripcion, int stock, int precio,
			String tipo) {

		boolean centinela = false;

		int codigoTipo = retornarTipoProducto(tipo);
		PreparedStatement preparedStatement = null;

		if (codigoTipo != -1) {

			conectar();

			try {
				preparedStatement = conexion.prepareStatement(
						"insert into producto(codigoProducto, nombre, descripcion,stock,precio,tipo_tipoProducto) values(?,?,?,?,?,?)");
				preparedStatement.setInt(1, codigoProducto);
				preparedStatement.setString(2, nombre);
				preparedStatement.setString(3, descripcion);
				preparedStatement.setInt(4, stock);
				preparedStatement.setInt(5, precio);
				preparedStatement.setInt(6, codigoTipo);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;

				} else {
					return centinela;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return centinela;
	}

	public boolean eliminarProducto(int codigoProducto) {

		boolean centinela = false;

		PreparedStatement preparedStatement = null;
		conectar();

		try {

			preparedStatement = conexion.prepareStatement("delete from producto where codigoProducto=?");
			preparedStatement.setInt(1, codigoProducto);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;
			} else {

				return centinela;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public boolean modificarProducto(int codigoProductoBusqueda, int codigoProductoN, String nombreN,
			String descripcionN, int stockN, int precioN, String tipoN) {

		boolean centinela = false;
		int codigoTipo = retornarTipoProducto(tipoN);

		PreparedStatement preparedStatement = null;

		if (codigoTipo != -1) {

			conectar();

			try {
				preparedStatement = conexion.prepareStatement(
						"update producto set codigoProducto=?, nombre=? ,descripcion=?, stock=?,precio=?,tipo_tipoProducto=? where codigoProducto=?");
				preparedStatement.setInt(1, codigoProductoN);
				preparedStatement.setString(2, nombreN);
				preparedStatement.setString(3, descripcionN);
				preparedStatement.setInt(4, stockN);
				preparedStatement.setInt(5, precioN);
				preparedStatement.setInt(6, codigoTipo);
				preparedStatement.setInt(7, codigoProductoBusqueda);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {

					conexion.close();

					return centinela = true;
				} else {
					return centinela;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return centinela;
	}

	public Producto buscarProducto(int codigoProducto) {

		Producto producto = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		conectar();

		try {

			preparedStatement = conexion.prepareStatement(
					"select codigoProducto, nombre, tipo_tipoProducto,descripcion,precio,stock from producto where codigoProducto=?");
			preparedStatement.setInt(1, codigoProducto);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				producto = new Producto();
				producto.setCodigoProducto(resultado.getInt("codigoProducto"));
				producto.setTipo_tipoProducto(resultado.getInt("tipo_tipoProducto"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getInt("precio"));
				producto.setStock(resultado.getInt("stock"));

			}

			conexion.close();

			if (producto == null) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el producto");
			} else {
				return producto;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return producto;
	}

	public ArrayList<Producto> cargarProductos() {

		ArrayList<Producto> listaProductos = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		Producto producto = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from producto");
			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				producto = new Producto();
				producto.setCodigoProducto(resultado.getInt("codigoProducto"));
				producto.setTipo_tipoProducto(resultado.getInt("tipo_tipoProducto"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getInt("precio"));
				producto.setStock(resultado.getInt("stock"));

				listaProductos.add(producto);
			}

			preparedStatement.close();
			resultado.close();
			conexion.close();

			return listaProductos;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	// --------------------------- CLIENTE--------------------------//

	public boolean crearCliente(int cedula, String nombre, String apellido, String direccion) {

		boolean centinela = false;

		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("insert into cliente(cedula, nombre, apellido,direccion) values(?,?,?,?)");
			preparedStatement.setInt(1, cedula);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, apellido);
			preparedStatement.setString(4, direccion);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;

			} else {
				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return centinela;
	}

	public boolean eliminarCliente(int cedulaCliente) {

		boolean centinela = false;

		PreparedStatement preparedStatement = null;
		conectar();

		try {

			preparedStatement = conexion.prepareStatement("delete from cliente where cedula=?");
			preparedStatement.setInt(1, cedulaCliente);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;
			} else {

				return centinela;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public boolean modificarCliente(int cedulaBusqueda, int cedulaN, String nombreN, String apellidoN,
			String direccionN) {

		boolean centinela = false;

		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("update cliente set cedula=?, nombre=? ,apellido=?, direccion=? where cedula=?");
			preparedStatement.setInt(1, cedulaN);
			preparedStatement.setString(2, nombreN);
			preparedStatement.setString(3, apellidoN);
			preparedStatement.setString(4, direccionN);
			preparedStatement.setInt(5, cedulaBusqueda);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {

				conexion.close();

				return centinela = true;
			} else {
				return centinela;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public Cliente buscarCliente(int cedulaCliente) {

		Cliente cliente = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		conectar();

		try {

			preparedStatement = conexion
					.prepareStatement("select nombre, apellido, cedula, direccion from cliente where cedula=?");
			preparedStatement.setInt(1, cedulaCliente);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				cliente = new Cliente();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setCedula(resultado.getInt("cedula"));
				cliente.setDireccion(resultado.getString("direccion"));

			}

			conexion.close();

			if (cliente == null) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente");
			} else {
				return cliente;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return cliente;
	}

	public ArrayList<Cliente> cargarClientes() {

		ArrayList<Cliente> listaClientes = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultado = null;
		Cliente cliente = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from cliente");
			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {

				cliente = new Cliente();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setCedula(resultado.getInt("cedula"));
				cliente.setDireccion(resultado.getString("direccion"));

				listaClientes.add(cliente);
			}

			preparedStatement.close();
			resultado.close();
			conexion.close();

			return listaClientes;

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	// --------------------------- PROVEEDOR --------------------------//

	public boolean crearProveedor(int codigoProveedor, String cedula, String nombre, String apellido, String telefono) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("insert into proveedor(codigoProveedor,cedula,nombre,apellido) values(?,?,?,?)");
			preparedStatement.setInt(1, codigoProveedor);
			preparedStatement.setString(2, cedula);
			preparedStatement.setString(3, nombre);
			preparedStatement.setString(4, apellido);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();
				agregarTelefonoProveedor(codigoProveedor, telefono);

				return centinela = true;

			} else {
				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return centinela;

	}

	public void agregarTelefonoProveedor(int codigoProveedor, String telefono) {

		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("insert into telefonoProveedor(numero,proveedor_codigoProveedor) values(?,?)");
			preparedStatement.setString(1, telefono);
			preparedStatement.setInt(2, codigoProveedor);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean eliminarProveedor(int codigoProveedor) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;
		int telefonoBorrado = borrarTelefonosProveedor(codigoProveedor);

		conectar();

		if (telefonoBorrado == 1) {

			try {
				preparedStatement = conexion.prepareStatement("delete from proveedor where codigoProveedor=?");
				preparedStatement.setInt(1, codigoProveedor);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;
				} else {

					return centinela;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return centinela;

	}

	public int borrarTelefonosProveedor(int codigoProveedor) {

		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("delete from telefonoProveedor where proveedor_codigoProveedor=?");
			preparedStatement.setInt(1, codigoProveedor);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {

				conexion.close();

				return 1;
			} else {

				return -1;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return -1;
	}

	public boolean modificarProveedor(int codigoProveedor, String cedula, String nombre, String apellido,
			String telefono) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("update proveedor set cedula=?,nombre=?,apellido=? where codigoProveedor=?");
			preparedStatement.setString(1, cedula);
			preparedStatement.setString(2, nombre);
			preparedStatement.setString(3, apellido);
			preparedStatement.setInt(4, codigoProveedor);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {

				conexion.close();
				actualizarTelefonoProveedor(codigoProveedor, telefono);

				return centinela = true;
			} else {
				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return centinela;
	}

	public void actualizarTelefonoProveedor(int codigoProveedor, String telefono) {

		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("update telefonoProveedor set numero=? where proveedor_codigoProveedor=?");
			preparedStatement.setString(1, telefono);
			preparedStatement.setInt(2, codigoProveedor);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Proveedor buscarProveedor(int codigoProveedor) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Proveedor proveedor = null;

		conectar();

		try {
			preparedStatement = conexion.prepareStatement(
					"select codigoProveedor,nombre,apellido,cedula from proveedor where codigoProveedor=?");
			preparedStatement.setInt(1, codigoProveedor);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				proveedor = new Proveedor();
				proveedor.setCodigoProveedor(resultSet.getInt("codigoProveedor"));
				proveedor.setNombre(resultSet.getString("nombre"));
				proveedor.setApellido(resultSet.getString("apellido"));
				proveedor.setCedula(resultSet.getString("cedula"));

			}

			conexion.close();

			if (proveedor == null) {
				JOptionPane.showMessageDialog(null, "El proveedor buscado no se encontro");
			} else {
				return proveedor;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return proveedor;

	}

	public String buscarTelefonoProveedor(int codigoProveedor) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String telefono = "";

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("select numero from telefonoProveedor where proveedor_codigoProveedor=?");
			preparedStatement.setInt(1, codigoProveedor);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				telefono = resultSet.getString("numero");

			}

			conexion.close();
			return telefono;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return telefono;

	}

	public ArrayList<Proveedor> cargarProveedores() {

		ArrayList<Proveedor> listaProveedores = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Proveedor proveedor = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from proveedor");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				proveedor = new Proveedor();
				proveedor.setCodigoProveedor(resultSet.getInt("codigoProveedor"));
				proveedor.setNombre(resultSet.getString("nombre"));
				proveedor.setApellido(resultSet.getString("apellido"));
				proveedor.setCedula(resultSet.getString("cedula"));

				listaProveedores.add(proveedor);
			}

			conexion.close();
			return listaProveedores;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// --------------------------- CARRITO --------------------------//

	public boolean crearCarrito(Date fechaCreacion, String cedulaCliente, int precioTotal) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("insert into carrito(fechaCreacion, cedulaCliente,costoTotal) values(?,?,?)");
			preparedStatement.setDate(1, fechaCreacion);
			preparedStatement.setString(2, cedulaCliente);
			preparedStatement.setInt(3, precioTotal);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;

			} else {
				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return centinela;
	}

	public boolean eliminarCarrito(int numeroCarrito) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion.prepareStatement("delete from carrito where numeroCarrito=?");
			preparedStatement.setInt(1, numeroCarrito);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {
				conexion.close();

				return centinela = true;
			} else {

				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return centinela;
	}

	public Carrito buscarCarrito(int numeroCarrito) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Carrito carrito = null;

		conectar();

		try {
			preparedStatement = conexion.prepareStatement(
					"select numeroCarrito,fechaCreacion,costoTotal,cedulaCliente from carrito where numeroCarrito=?");
			preparedStatement.setInt(1, numeroCarrito);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				carrito = new Carrito();
				carrito.setNumeroCarrito(resultSet.getInt("numeroCarrito"));
				carrito.setFechaCreacion(resultSet.getDate("fechaCreacion"));
				carrito.setCostoTotal(resultSet.getInt("costoTotal"));
				carrito.setCedulaCliente(resultSet.getInt("cedulaCliente"));

			}

			conexion.close();

			if (carrito == null) {
				JOptionPane.showMessageDialog(null, "El carrito buscado no se encontro");
			} else {
				return carrito;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return carrito;
	}

	public boolean actualizarCarrito(int numeroCarrito, Date fechaCarritoN, int precioTotal) {

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		try {
			preparedStatement = conexion
					.prepareStatement("update carrito set fechaCreacion=?, costoTotal=? where numeroCarrito=?");
			preparedStatement.setDate(1, fechaCarritoN);
			preparedStatement.setInt(2, precioTotal);
			preparedStatement.setInt(3, numeroCarrito);

			int aux = preparedStatement.executeUpdate();

			if (aux > 0) {

				conexion.close();

				return centinela = true;
			} else {
				return centinela;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return centinela;
	}

	public ArrayList<Carrito> cargarCarritos() {

		ArrayList<Carrito> listaCarritos = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Carrito carrito = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from carrito");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				carrito = new Carrito();
				carrito.setNumeroCarrito(resultSet.getInt("numeroCarrito"));
				carrito.setFechaCreacion(resultSet.getDate("fechaCreacion"));
				carrito.setCostoTotal(resultSet.getInt("costoTotal"));
				carrito.setCedulaCliente(resultSet.getInt("cedulaCliente"));

				listaCarritos.add(carrito);
			}

			conexion.close();
			return listaCarritos;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// --------------------------------- TRAMITE ---------------------------- //

	public boolean crearTramite(int codigoTramite, int cantidad, int precioTotal, int costoUnitario, int codigoSede,
			int codigoProducto, int codigoProveedor, Date fechaCreacion) {

		Sede sede = buscarSede(codigoSede);
		Producto producto = buscarProducto(codigoProducto);
		Proveedor proveedor = buscarProveedor(codigoProveedor);

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		if (sede != null && producto != null && proveedor != null) {

			try {
				preparedStatement = conexion.prepareStatement(
						"insert into sede_proveedor(codigo,cantidad,precioTotal,costoUnitario,sede_codigoSede,producto_codigoProducto,proveedor_codigoProveedor,fecha) values(?,?,?,?,?,?,?,?)");

				preparedStatement.setInt(1, codigoTramite);
				preparedStatement.setInt(2, cantidad);
				preparedStatement.setInt(3, precioTotal);
				preparedStatement.setInt(4, costoUnitario);
				preparedStatement.setInt(5, codigoSede);
				preparedStatement.setInt(6, codigoProducto);
				preparedStatement.setInt(7, codigoProveedor);
				preparedStatement.setDate(8, fechaCreacion);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;

				} else {
					return centinela;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return centinela;
		}

		return centinela;

	}

	public boolean buscarTramite(int codigoTramite) {

		Sede_Proveedor tramite = null;
		boolean centinela = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from sede_proveedor where codigo=?");
			preparedStatement.setInt(1, codigoTramite);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				tramite = new Sede_Proveedor();
				tramite.setCodigo(resultSet.getInt("codigo"));
				tramite.setCantidad(resultSet.getInt("cantidad"));
				tramite.setPrecioTotal(resultSet.getInt("precioTotal"));
				tramite.setCostoUnitario(resultSet.getInt("costoUnitario"));
				tramite.setSede_codigoSede(resultSet.getInt("sede_codigoSede"));
				tramite.setProducto_codigoProducto(resultSet.getInt("producto_codigoProducto"));
				tramite.setProveedor_codigoProveedor(resultSet.getInt("proveedor_codigoProveedor"));
				tramite.setFecha(resultSet.getDate("fecha"));

			}

			conexion.close();

			if (tramite != null) {
				return centinela = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public boolean eliminarTramite(int codigoTramite) {

		boolean centinela = false;
		boolean encontrado = buscarTramite(codigoTramite);
		PreparedStatement preparedStatement = null;
		conectar();

		if (encontrado) {

			try {

				preparedStatement = conexion.prepareStatement("delete from sede_proveedor where codigo=?");
				preparedStatement.setInt(1, codigoTramite);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;
				} else {

					return centinela;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return centinela;
	}

	// --------------------------------- VENTA ---------------------------- //

	public boolean crearVenta(int codigoTramite, int cantidad, int codigoCarrito) {

		boolean tramite = buscarTramite(codigoTramite);
		Carrito carrito = buscarCarrito(codigoCarrito);

		boolean centinela = false;
		PreparedStatement preparedStatement = null;

		conectar();

		if (carrito != null && tramite == true) {

			try {
				preparedStatement = conexion.prepareStatement(
						"insert into carrito_sede_proveedor(cantidad,carrito_numeroCarrito,codigoSP) values(?,?,?)");

				preparedStatement.setInt(1, cantidad);
				preparedStatement.setInt(2, codigoCarrito);
				preparedStatement.setInt(3, codigoTramite);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;

				} else {
					return centinela;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return centinela;
		}

		return centinela;

	}

	public boolean buscarVenta(int codigoTramite) {

		Carrito_Sede_Proveedor venta = null;
		boolean centinela = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		conectar();

		try {

			preparedStatement = conexion.prepareStatement("select * from carrito_sede_proveedor where codigoSP=?");
			preparedStatement.setInt(1, codigoTramite);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				venta = new Carrito_Sede_Proveedor();
				venta.setCantidad(resultSet.getInt("cantidad"));
				venta.setCarrito_numeroCarrito(resultSet.getInt("carrito_numeroCarrito"));
				venta.setCodigoSP(resultSet.getInt("codigoSP"));

			}

			conexion.close();

			if (venta != null) {
				return centinela = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return centinela;
	}

	public boolean eliminarVenta(int codigoTramite) {

		boolean centinela = false;
		boolean encontrado = buscarVenta(codigoTramite);
		PreparedStatement preparedStatement = null;
		conectar();

		if (encontrado) {

			try {

				preparedStatement = conexion.prepareStatement("delete from carrito_sede_proveedor where codigoSP=?");
				preparedStatement.setInt(1, codigoTramite);

				int aux = preparedStatement.executeUpdate();

				if (aux > 0) {
					conexion.close();

					return centinela = true;
				} else {

					return centinela;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return centinela;
	}

}
