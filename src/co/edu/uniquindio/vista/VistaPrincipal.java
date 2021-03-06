package co.edu.uniquindio.vista;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import co.edu.uniquindio.conexion.ConexionBase;
import co.edu.uniquindio.modelo.Carrito;
import co.edu.uniquindio.modelo.Cliente;
import co.edu.uniquindio.modelo.Producto;
import co.edu.uniquindio.modelo.Proveedor;
import co.edu.uniquindio.modelo.Sede;
import groovy.util.logging.Log4j;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import javax.swing.JList;
import java.awt.Panel;
import java.awt.ScrollPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.xml.JRXmlDigesterFactory;


public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int seleccionado;
	private int codigo;
	private int codigoProducto;
	private int cedulaCliente;
	private int codigoProveedor;
	private int numeroCarrito;

	ConexionBase conexionBase = new ConexionBase();

	private JTextField textoCodigoSede;
	private JTextField textoDireccionSede;
	private JTextField textoCodigoBusquedaSede;
	private JTable tablaSedes;

	private JTextField textoStockProducto;
	private JTextField textoDescProducto;
	private JTextField textoBusquedaProducto;
	private JTextField textoCodigoProducto;
	private JTextField textoNombreProducto;
	private JTextField textoPrecioProducto;
	private JTable tablaProductos;

	private JTextField textoApellidosProveedor;
	private JTextField textoCodigoProveedor;
	private JTextField textoBusquedaProveedor;
	private JTextField textoCedulaProveedor;
	private JTextField textoNombreProveedor;
	private JTable tablaProveedores;

	private JTextField textoApellidosCliente;
	private JTextField textoDireccionCliente;
	private JTextField textoBusquedaCliente;
	private JTextField textoCedulaCliente;
	private JTextField textoNombreCliente;
	private JTable tablaClientes;

	private JTextField textoFechaCarrito;
	private JTextField textoBusquedaCarrito;
	private JTable tablaCarritos;
	private JTextField textCedulaClienteCarrito;
	private JTextField textTelefonoProveedores;
	
	private JList<String> listaConsultas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Image imagenFondo;
	public URL fondo;
	private JTextField textoPrecioTotalCarrito;
	private JTextField textCodigoTramite;
	private JTextField textCodSedeAP;
	private JTextField textCodProveedorAP;
	private JTextField textCodProductoAP;
	private JTextField textCantidadAP;
	private JTextField textCostoUnitarioAP;
	private JTextField textPrecioTotalAP;
	private JTextField textFechaAP;
	private JTextField textCantidadVenta;
	private JTextField textCodigiCarritoVenta;
	private JTextField textCodigoTramiteVenta;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {

		fondo = this.getClass().getResource("/co/edu/uniquindio/inconos/fondo.png");
		imagenFondo = new ImageIcon(fondo).getImage();

		setResizable(false);
		setTitle("El Buen Precio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelInicio = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelInicio.setBackground(Color.WHITE);
		tabbedPane.addTab("Inicio", null, panelInicio, null);
		panelInicio.setLayout(null);

		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/icono.jpg")));
		lblNewLabel_18.setBounds(286, 67, 225, 180);
		panelInicio.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/facebook.png")));
		lblNewLabel_19.setBounds(79, 329, 50, 50);
		panelInicio.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("El Buen Precio");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_20.setBounds(139, 347, 182, 25);
		panelInicio.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/insta.png")));
		lblNewLabel_21.setBounds(499, 329, 50, 50);
		panelInicio.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("elbuenprecio_");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_22.setBounds(559, 347, 147, 25);
		panelInicio.add(lblNewLabel_22);

		JPanel panelSede = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelSede.setBackground(Color.WHITE);
		tabbedPane.addTab("Sede", null, panelSede, null);
		panelSede.setLayout(null);

		JLabel lblNewLabel = new JLabel("Informaci\u00F3n de la sede");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(65, 250, 268, 14);
		panelSede.add(lblNewLabel);

		textoCodigoSede = new JTextField();
		textoCodigoSede.setBounds(195, 118, 161, 20);
		panelSede.add(textoCodigoSede);
		textoCodigoSede.setColumns(10);

		textoDireccionSede = new JTextField();
		textoDireccionSede.setBounds(195, 154, 161, 20);
		panelSede.add(textoDireccionSede);
		textoDireccionSede.setColumns(10);

		JComboBox ComboBoxCiudadSede = new JComboBox();
		ComboBoxCiudadSede.setModel(new DefaultComboBoxModel(new String[] { "armenia", "medellin", "bogota" }));
		ComboBoxCiudadSede.setToolTipText("");
		ComboBoxCiudadSede.setBackground(Color.LIGHT_GRAY);
		ComboBoxCiudadSede.setBounds(195, 78, 161, 20);
		panelSede.add(ComboBoxCiudadSede);

		JLabel lblCodigoSede = new JLabel("Codigo postal:");
		lblCodigoSede.setBounds(51, 81, 104, 14);
		panelSede.add(lblCodigoSede);

		JLabel lblCorreoSede = new JLabel("Codigo sede:");
		lblCorreoSede.setBounds(51, 121, 104, 14);
		panelSede.add(lblCorreoSede);

		JLabel lblTelefonoSede = new JLabel("Direccion:");
		lblTelefonoSede.setBounds(51, 157, 104, 14);
		panelSede.add(lblTelefonoSede);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 289, 732, 90);
		panelSede.add(scrollPane);

		tablaSedes = new JTable();
		tablaSedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seleccionado = tablaSedes.rowAtPoint(e.getPoint());
				codigo = Integer.parseInt(String.valueOf(tablaSedes.getValueAt(seleccionado, 0)));
				textoCodigoSede.setText(String.valueOf(tablaSedes.getValueAt(seleccionado, 0)));
				textoDireccionSede.setText(String.valueOf(tablaSedes.getValueAt(seleccionado, 1)));
			}
		});
		tablaSedes
				.setModel(
						new DefaultTableModel(
								new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
										{ null, null, null }, },
								new String[] { "Codigo Sede", "Codigo Postal", "Direccion" }));
		scrollPane.setViewportView(tablaSedes);

		JLabel lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setBounds(440, 128, 71, 14);
		panelSede.add(lblNewLabel_2);

		textoCodigoBusquedaSede = new JTextField();
		textoCodigoBusquedaSede.setBounds(539, 125, 205, 20);
		panelSede.add(textoCodigoBusquedaSede);
		textoCodigoBusquedaSede.setColumns(10);

		JButton btnBuscarSede = new JButton("Buscar");
		btnBuscarSede.setBackground(Color.LIGHT_GRAY);
		btnBuscarSede.setBounds(539, 193, 104, 20);
		btnBuscarSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Sede sede = conexionBase.buscarSede(Integer.parseInt(textoCodigoBusquedaSede.getText()));

				String matriz[][] = new String[1][3];

				if (sede != null) {

					String ciudad = conexionBase.retornarNombreCiudad(sede.getCiudad_codigoPostal());

					matriz[0][0] = sede.getCodigoSede() + "";
					matriz[0][1] = sede.getDireccion() + "";
					matriz[0][2] = ciudad + "";
				}

				tablaSedes.setModel(
						new DefaultTableModel(matriz, new String[] { "Codigo Sede", "Codigo Postal", "Direccion" }));
				textoCodigoBusquedaSede.setText("");

			}
		});
		panelSede.add(btnBuscarSede);

		JButton btnActualizarsede = new JButton("Modificar");
		btnActualizarsede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean actualizado = conexionBase.modificarSede(codigo, textoDireccionSede.getText(),
						(String) ComboBoxCiudadSede.getSelectedItem(), Integer.parseInt(textoCodigoSede.getText()));

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Sede actualizada correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se puedo actualizar la sede");
				}

				textoCodigoSede.setText("");
				textoDireccionSede.setText("");

			}
		});
		btnActualizarsede.setBackground(Color.LIGHT_GRAY);
		btnActualizarsede.setBounds(659, 390, 104, 20);
		panelSede.add(btnActualizarsede);

		JButton btnCrearSede = new JButton("Crear");
		btnCrearSede.setBackground(Color.LIGHT_GRAY);
		btnCrearSede.setBounds(148, 193, 104, 20);
		btnCrearSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean agregado = conexionBase.crearSede(Integer.parseInt(textoCodigoSede.getText()),
						textoDireccionSede.getText(), (String) ComboBoxCiudadSede.getSelectedItem());

				if (agregado) {

					JOptionPane.showMessageDialog(null, "La Sede se agrego correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar la sede");
				}

				textoCodigoSede.setText("");
				textoDireccionSede.setText("");
			}
		});
		panelSede.add(btnCrearSede);

		JButton btnEliminarSede = new JButton("Eliminar");
		btnEliminarSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean verificado = conexionBase.eliminarSede(Integer.parseInt(textoCodigoBusquedaSede.getText()));

				if (verificado) {

					JOptionPane.showMessageDialog(null, "La sede se elimino correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar la sede");
				}
			}
		});
		btnEliminarSede.setBackground(Color.LIGHT_GRAY);
		btnEliminarSede.setBounds(506, 390, 104, 22);
		panelSede.add(btnEliminarSede);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(381, 57, 1, 167);
		panelSede.add(separator_3);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1.setBounds(419, 57, 1, 167);
		panelSede.add(separator_3_1);

		JLabel lblNewLabel_1 = new JLabel("Ingrese el codigo de la sede para realizar una busqueda");
		lblNewLabel_1.setBounds(428, 75, 317, 14);
		panelSede.add(lblNewLabel_1);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(31, 268, 732, 10);
		panelSede.add(separator_4);

		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_2.setBounds(31, 57, 1, 167);
		panelSede.add(separator_3_2);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(31, 224, 351, 2);
		panelSede.add(separator_1_2);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(31, 57, 351, 2);
		panelSede.add(separator_1_2_1);

		JSeparator separator_1_2_2_1 = new JSeparator();
		separator_1_2_2_1.setBounds(419, 57, 342, 2);
		panelSede.add(separator_1_2_2_1);

		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(31, 33, 732, 13);
		panelSede.add(separator_4_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(332, 0, 127, 33);
		panelSede.add(lblNewLabel_6);

		JSeparator separator_1_2_2_1_1 = new JSeparator();
		separator_1_2_2_1_1.setBounds(419, 224, 342, 2);
		panelSede.add(separator_1_2_2_1_1);

		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1.setBounds(759, 57, 1, 167);
		panelSede.add(separator_3_1_1);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/recargar.png")));
		lblNewLabel_7.setBounds(632, 390, 18, 18);
		panelSede.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/eliminar.png")));
		lblNewLabel_8.setBounds(478, 392, 18, 18);
		panelSede.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/lupa.png")));
		lblNewLabel_9.setBounds(511, 193, 18, 18);
		panelSede.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/agregar.png")));
		lblNewLabel_10.setBounds(128, 193, 18, 18);
		panelSede.add(lblNewLabel_10);

		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/tienda.png")));
		lblNewLabel_16.setBounds(35, 246, 20, 20);
		panelSede.add(lblNewLabel_16);

		JButton btnCargarSedes = new JButton("Cargar");
		btnCargarSedes.setBackground(Color.LIGHT_GRAY);
		btnCargarSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Sede> listaSedes = conexionBase.cargarSedes();

				String matriz[][] = new String[listaSedes.size()][3];

				for (int i = 0; i < listaSedes.size(); i++) {

					String ciudad = conexionBase.retornarNombreCiudad(listaSedes.get(i).getCiudad_codigoPostal());

					matriz[i][0] = listaSedes.get(i).getCodigoSede() + "";
					matriz[i][1] = listaSedes.get(i).getDireccion() + "";
					matriz[i][2] = ciudad + "";
				}

				tablaSedes.setModel(
						new DefaultTableModel(matriz, new String[] { "Codigo Sede", "Codigo Postal", "Direccion" }));

			}
		});
		btnCargarSedes.setBounds(353, 390, 104, 22);
		panelSede.add(btnCargarSedes);

		JPanel panelProducto = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelProducto.setLayout(null);
		panelProducto.setBackground(Color.WHITE);
		tabbedPane.addTab("Productos", null, panelProducto, null);

		JLabel lblNewLabel_11 = new JLabel("Informaci\u00F3n de los productos");
		lblNewLabel_11.setForeground(Color.DARK_GRAY);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(51, 250, 268, 14);
		panelProducto.add(lblNewLabel_11);

		textoStockProducto = new JTextField();
		textoStockProducto.setColumns(10);
		textoStockProducto.setBounds(195, 123, 161, 18);
		panelProducto.add(textoStockProducto);

		textoDescProducto = new JTextField();
		textoDescProducto.setColumns(10);
		textoDescProducto.setBounds(195, 154, 161, 18);
		panelProducto.add(textoDescProducto);

		JComboBox ComboBoxTipoProductos = new JComboBox();
		ComboBoxTipoProductos.setModel(
				new DefaultComboBoxModel(new String[] { "higiene", "hogar", "belleza", "mascota", "alimento" }));
		ComboBoxTipoProductos.setToolTipText("");
		ComboBoxTipoProductos.setBackground(Color.LIGHT_GRAY);
		ComboBoxTipoProductos.setBounds(195, 92, 161, 18);
		panelProducto.add(ComboBoxTipoProductos);

		JLabel lblCodigoSede_2 = new JLabel("Tipo:");
		lblCodigoSede_2.setBounds(51, 95, 104, 14);
		panelProducto.add(lblCodigoSede_2);

		JLabel lblCorreoSede_2 = new JLabel("Stock:");
		lblCorreoSede_2.setBounds(51, 128, 104, 14);
		panelProducto.add(lblCorreoSede_2);

		JLabel lblTelefonoSede_2 = new JLabel("Direccion:");
		lblTelefonoSede_2.setBounds(51, 157, 104, 14);
		panelProducto.add(lblTelefonoSede_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 289, 732, 90);
		panelProducto.add(scrollPane_2);

		tablaProductos = new JTable();
		tablaProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seleccionado = tablaProductos.rowAtPoint(e.getPoint());
				codigoProducto = Integer.parseInt(String.valueOf(tablaProductos.getValueAt(seleccionado, 0)));
				textoCodigoProducto.setText(String.valueOf(tablaProductos.getValueAt(seleccionado, 0)));
				textoNombreProducto.setText(String.valueOf(tablaProductos.getValueAt(seleccionado, 1)));
				textoDescProducto.setText(String.valueOf(tablaProductos.getValueAt(seleccionado, 3)));
				textoPrecioProducto.setText(String.valueOf(tablaProductos.getValueAt(seleccionado, 4)));
				textoStockProducto.setText(String.valueOf(tablaProductos.getValueAt(seleccionado, 5)));
			}
		});
		tablaProductos.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Codigo", "Nombre", "Tipo", "Descripcion", "Precio", "Stock" }));
		scrollPane_2.setViewportView(tablaProductos);

		JLabel lblNewLabel_2_2 = new JLabel("Codigo:");
		lblNewLabel_2_2.setBounds(430, 144, 71, 14);
		panelProducto.add(lblNewLabel_2_2);

		textoBusquedaProducto = new JTextField();
		textoBusquedaProducto.setColumns(10);
		textoBusquedaProducto.setBounds(539, 142, 205, 18);
		panelProducto.add(textoBusquedaProducto);

		JButton btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Producto producto = conexionBase.buscarProducto(Integer.parseInt(textoBusquedaProducto.getText()));

				String matriz[][] = new String[1][6];

				if (producto != null) {

					String tipo = conexionBase.retornarNombreTipo(producto.getTipo_tipoProducto());

					matriz[0][0] = producto.getCodigoProducto() + "";
					matriz[0][1] = producto.getNombre() + "";
					matriz[0][2] = tipo + "";
					matriz[0][3] = producto.getDescripcion() + "";
					matriz[0][4] = producto.getPrecio() + "";
					matriz[0][5] = producto.getStock() + "";
				}

				tablaProductos.setModel(new DefaultTableModel(matriz,
						new String[] { "Codigo", "Nombre", "Tipo", "Descripcion", "Precio", "Stock" }));
				textoBusquedaProducto.setText("");
			}
		});
		btnBuscarProducto.setBackground(Color.LIGHT_GRAY);
		btnBuscarProducto.setBounds(539, 193, 104, 20);
		panelProducto.add(btnBuscarProducto);

		JButton btnActualizarProducto = new JButton("Modificar");
		btnActualizarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean actualizado = conexionBase.modificarProducto(codigoProducto,
						Integer.parseInt(textoCodigoProducto.getText()), textoNombreProducto.getText(),
						textoDescProducto.getText(), Integer.parseInt(textoStockProducto.getText()),
						Integer.parseInt(textoPrecioProducto.getText()),
						(String) ComboBoxTipoProductos.getSelectedItem());

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Sede actualizada correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se puedo actualizar la sede");
				}

				textoCodigoProducto.setText("");
				textoNombreProducto.setText("");
				textoDescProducto.setText("");
				textoStockProducto.setText("");
				textoPrecioProducto.setText("");

			}
		});
		btnActualizarProducto.setBackground(Color.LIGHT_GRAY);
		btnActualizarProducto.setBounds(659, 390, 104, 20);
		panelProducto.add(btnActualizarProducto);

		JButton btnCrearProducto = new JButton("Crear");
		btnCrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean agregado = conexionBase.crearProducto(Integer.parseInt(textoCodigoProducto.getText()),
						textoNombreProducto.getText(), textoDescProducto.getText(),
						Integer.parseInt(textoStockProducto.getText()), Integer.parseInt(textoPrecioProducto.getText()),
						(String) ComboBoxTipoProductos.getSelectedItem());

				if (agregado) {

					JOptionPane.showMessageDialog(null, "El producto se agrego correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el producto");
				}

				textoCodigoProducto.setText("");
				textoNombreProducto.setText("");
				textoDescProducto.setText("");
				textoStockProducto.setText("");
				textoPrecioProducto.setText("");
			}
		});
		btnCrearProducto.setBackground(Color.LIGHT_GRAY);
		btnCrearProducto.setBounds(151, 212, 104, 20);
		panelProducto.add(btnCrearProducto);

		JButton btnEliminarProducto = new JButton("Eliminar");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean verificado = conexionBase.eliminarProducto(Integer.parseInt(textoBusquedaProducto.getText()));

				if (verificado) {

					JOptionPane.showMessageDialog(null, "El producto se elimino correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el producto");
				}

				textoBusquedaProducto.setText("");
			}
		});
		btnEliminarProducto.setBackground(Color.LIGHT_GRAY);
		btnEliminarProducto.setBounds(506, 390, 104, 22);
		panelProducto.add(btnEliminarProducto);

		JSeparator separator_3_3 = new JSeparator();
		separator_3_3.setOrientation(SwingConstants.VERTICAL);
		separator_3_3.setBounds(381, 22, 1, 218);
		panelProducto.add(separator_3_3);

		JSeparator separator_3_1_2 = new JSeparator();
		separator_3_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_2.setBounds(419, 22, 1, 218);
		panelProducto.add(separator_3_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Ingrese el codigo del producto para realizar una busqueda");
		lblNewLabel_1_2.setBounds(426, 94, 359, 14);
		panelProducto.add(lblNewLabel_1_2);

		JSeparator separator_4_2 = new JSeparator();
		separator_4_2.setBounds(31, 268, 732, 10);
		panelProducto.add(separator_4_2);

		JSeparator separator_3_2_1 = new JSeparator();
		separator_3_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_2_1.setBounds(31, 22, 1, 218);
		panelProducto.add(separator_3_2_1);

		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(31, 239, 351, 2);
		panelProducto.add(separator_1_2_2);

		JSeparator separator_1_2_1_1 = new JSeparator();
		separator_1_2_1_1.setBounds(31, 22, 351, 2);
		panelProducto.add(separator_1_2_1_1);

		JSeparator separator_1_2_2_1_2 = new JSeparator();
		separator_1_2_2_1_2.setBounds(421, 22, 342, 2);
		panelProducto.add(separator_1_2_2_1_2);

		JSeparator separator_1_2_2_1_1_1 = new JSeparator();
		separator_1_2_2_1_1_1.setBounds(419, 238, 342, 2);
		panelProducto.add(separator_1_2_2_1_1_1);

		JSeparator separator_3_1_1_1 = new JSeparator();
		separator_3_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1_1.setBounds(759, 22, 1, 218);
		panelProducto.add(separator_3_1_1_1);

		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/recargar.png")));
		lblNewLabel_7_1.setBounds(632, 390, 18, 18);
		panelProducto.add(lblNewLabel_7_1);

		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/eliminar.png")));
		lblNewLabel_8_1.setBounds(478, 392, 18, 18);
		panelProducto.add(lblNewLabel_8_1);

		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/lupa.png")));
		lblNewLabel_9_1.setBounds(511, 193, 18, 18);
		panelProducto.add(lblNewLabel_9_1);

		JLabel lblNewLabel_10_1 = new JLabel("");
		lblNewLabel_10_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/agregar.png")));
		lblNewLabel_10_1.setBounds(128, 212, 18, 18);
		panelProducto.add(lblNewLabel_10_1);

		JLabel lblNewLabel_3 = new JLabel("Codigo:");
		lblNewLabel_3.setBounds(51, 35, 46, 14);
		panelProducto.add(lblNewLabel_3);

		JLabel lblNewLabel_12 = new JLabel("Nombre:");
		lblNewLabel_12.setBounds(51, 66, 61, 14);
		panelProducto.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Precio:");
		lblNewLabel_13.setBounds(51, 184, 46, 14);
		panelProducto.add(lblNewLabel_13);

		textoCodigoProducto = new JTextField();
		textoCodigoProducto.setBounds(195, 33, 161, 18);
		panelProducto.add(textoCodigoProducto);
		textoCodigoProducto.setColumns(10);

		textoNombreProducto = new JTextField();
		textoNombreProducto.setBounds(195, 62, 161, 18);
		panelProducto.add(textoNombreProducto);
		textoNombreProducto.setColumns(10);

		textoPrecioProducto = new JTextField();
		textoPrecioProducto.setBounds(195, 183, 161, 18);
		panelProducto.add(textoPrecioProducto);
		textoPrecioProducto.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/pro.png")));
		lblNewLabel_14.setBounds(570, 33, 50, 50);
		panelProducto.add(lblNewLabel_14);

		JButton btnCargarSedes_1 = new JButton("Cargar");
		btnCargarSedes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Producto> listaProductos = conexionBase.cargarProductos();

				String matriz[][] = new String[listaProductos.size()][6];

				for (int i = 0; i < listaProductos.size(); i++) {

					String tipo = conexionBase.retornarNombreTipo(listaProductos.get(i).getTipo_tipoProducto());

					matriz[i][0] = listaProductos.get(i).getCodigoProducto() + "";
					matriz[i][1] = listaProductos.get(i).getNombre() + "";
					matriz[i][2] = tipo + "";
					matriz[i][3] = listaProductos.get(i).getDescripcion() + "";
					matriz[i][4] = listaProductos.get(i).getPrecio() + "";
					matriz[i][5] = listaProductos.get(i).getStock() + "";
				}

				tablaProductos.setModel(new DefaultTableModel(matriz,
						new String[] { "Codigo", "Nombre", "Tipo", "Descripcion", "Precio", "Stock" }));
			}
		});
		btnCargarSedes_1.setBackground(Color.LIGHT_GRAY);
		btnCargarSedes_1.setBounds(353, 390, 104, 22);
		panelProducto.add(btnCargarSedes_1);

		JPanel panelProveedor = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelProveedor.setLayout(null);
		panelProveedor.setBackground(Color.WHITE);
		tabbedPane.addTab("Proveedores", null, panelProveedor, null);

		JLabel lblNewLabel_4 = new JLabel("Informaci\u00F3n de los proveedores");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(51, 250, 268, 14);
		panelProveedor.add(lblNewLabel_4);

		textoApellidosProveedor = new JTextField();
		textoApellidosProveedor.setColumns(10);
		textoApellidosProveedor.setBounds(195, 91, 161, 18);
		panelProveedor.add(textoApellidosProveedor);

		textoCodigoProveedor = new JTextField();
		textoCodigoProveedor.setColumns(10);
		textoCodigoProveedor.setBounds(195, 172, 161, 18);
		panelProveedor.add(textoCodigoProveedor);

		JLabel lblCodigoSede_1 = new JLabel("Nombre:");
		lblCodigoSede_1.setBounds(51, 64, 104, 14);
		panelProveedor.add(lblCodigoSede_1);

		JLabel lblCorreoSede_1 = new JLabel("Apellidos:");
		lblCorreoSede_1.setBounds(51, 93, 104, 14);
		panelProveedor.add(lblCorreoSede_1);

		JLabel lblTelefonoSede_1 = new JLabel("Codigo:");
		lblTelefonoSede_1.setBounds(51, 175, 104, 14);
		panelProveedor.add(lblTelefonoSede_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 289, 732, 90);
		panelProveedor.add(scrollPane_1);

		tablaProveedores = new JTable();
		tablaProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seleccionado = tablaProveedores.rowAtPoint(e.getPoint());
				codigoProveedor = Integer.parseInt(String.valueOf(tablaProveedores.getValueAt(seleccionado, 0)));
				textoCedulaProveedor.setText(String.valueOf(tablaProveedores.getValueAt(seleccionado, 1)));
				textoNombreProveedor.setText(String.valueOf(tablaProveedores.getValueAt(seleccionado, 2)));
				textoApellidosProveedor.setText(String.valueOf(tablaProveedores.getValueAt(seleccionado, 3)));
				textTelefonoProveedores.setText(String.valueOf(tablaProveedores.getValueAt(seleccionado, 4)));

			}
		});
		tablaProveedores.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Codigo", "Cedula", "Nombre", "Apellidos", "Telefono" }));
		scrollPane_1.setViewportView(tablaProveedores);

		JLabel lblNewLabel_2_1 = new JLabel("Codigo:");
		lblNewLabel_2_1.setBounds(440, 145, 71, 14);
		panelProveedor.add(lblNewLabel_2_1);

		textoBusquedaProveedor = new JTextField();
		textoBusquedaProveedor.setColumns(10);
		textoBusquedaProveedor.setBounds(540, 145, 205, 20);
		panelProveedor.add(textoBusquedaProveedor);

		JButton btnBuscarProveedor = new JButton("Buscar");
		btnBuscarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Proveedor proveedor = conexionBase.buscarProveedor(Integer.parseInt(textoBusquedaProveedor.getText()));

				String matrizInfo[][] = new String[1][5];

				if (proveedor != null) {

					String telefono = conexionBase.buscarTelefonoProveedor(proveedor.getCodigoProveedor());

					matrizInfo[0][0] = proveedor.getCodigoProveedor() + "";
					matrizInfo[0][1] = proveedor.getCedula() + "";
					matrizInfo[0][2] = proveedor.getNombre() + "";
					matrizInfo[0][3] = proveedor.getApellido() + "";
					matrizInfo[0][4] = telefono + "";
				}

				tablaProveedores.setModel(new DefaultTableModel(matrizInfo,
						new String[] { "Codigo", "Cedula", "Nombre", "Apellidos", "Telefono" }));
				textoBusquedaProveedor.setText("");
			}
		});
		btnBuscarProveedor.setBackground(Color.LIGHT_GRAY);
		btnBuscarProveedor.setBounds(539, 193, 104, 20);
		panelProveedor.add(btnBuscarProveedor);

		JButton btnActualizarProveedor = new JButton("Modificar");
		btnActualizarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean actualizado = conexionBase.modificarProveedor(codigoProveedor, textoCedulaProveedor.getText(),
						textoNombreProveedor.getText(), textoApellidosProveedor.getText(),
						textTelefonoProveedores.getText());

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se puedo actualizar el proveedor");
				}

			}
		});
		btnActualizarProveedor.setBackground(Color.LIGHT_GRAY);
		btnActualizarProveedor.setBounds(659, 390, 104, 20);
		panelProveedor.add(btnActualizarProveedor);

		JButton btnCrearProveedor = new JButton("Crear");
		btnCrearProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean agregado = conexionBase.crearProveedor(Integer.parseInt(textoCodigoProveedor.getText()),
						textoCedulaProveedor.getText(), textoNombreProveedor.getText(),
						textoApellidosProveedor.getText(), textTelefonoProveedores.getText());

				if (agregado) {

					JOptionPane.showMessageDialog(null, "Proveedor agregado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el proveedor");
				}

				textoCodigoProveedor.setText("");
				textoCedulaProveedor.setText("");
				textoNombreProveedor.setText("");
				textoApellidosProveedor.setText("");
				textTelefonoProveedores.setText("");
			}
		});
		btnCrearProveedor.setBackground(Color.LIGHT_GRAY);
		btnCrearProveedor.setBounds(150, 203, 104, 20);
		panelProveedor.add(btnCrearProveedor);

		JButton btnEliminarProveedor = new JButton("Eliminar");
		btnEliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean eliminado = conexionBase.eliminarProveedor(Integer.parseInt(textoBusquedaProveedor.getText()));

				if (eliminado) {

					JOptionPane.showMessageDialog(null, "Proveedor eliminada correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el proveedor");
				}

				textoBusquedaProveedor.setText("");
			}
		});
		btnEliminarProveedor.setBackground(Color.LIGHT_GRAY);
		btnEliminarProveedor.setBounds(506, 390, 104, 22);
		panelProveedor.add(btnEliminarProveedor);

		JSeparator separator_3_4 = new JSeparator();
		separator_3_4.setOrientation(SwingConstants.VERTICAL);
		separator_3_4.setBounds(381, 48, 1, 184);
		panelProveedor.add(separator_3_4);

		JSeparator separator_3_1_3 = new JSeparator();
		separator_3_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_3.setBounds(419, 48, 1, 184);
		panelProveedor.add(separator_3_1_3);

		JLabel lblNewLabel_1_1 = new JLabel("Ingrese el codigo del proveedor para realizar una busqueda");
		lblNewLabel_1_1.setBounds(424, 110, 361, 14);
		panelProveedor.add(lblNewLabel_1_1);

		JSeparator separator_4_3 = new JSeparator();
		separator_4_3.setBounds(31, 268, 732, 10);
		panelProveedor.add(separator_4_3);

		JSeparator separator_3_2_2 = new JSeparator();
		separator_3_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_2_2.setBounds(31, 48, 1, 184);
		panelProveedor.add(separator_3_2_2);

		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(31, 232, 351, 2);
		panelProveedor.add(separator_1_2_3);

		JSeparator separator_1_2_1_2 = new JSeparator();
		separator_1_2_1_2.setBounds(31, 48, 351, 2);
		panelProveedor.add(separator_1_2_1_2);

		JSeparator separator_1_2_2_1_3 = new JSeparator();
		separator_1_2_2_1_3.setBounds(419, 48, 341, 2);
		panelProveedor.add(separator_1_2_2_1_3);

		JSeparator separator_4_1_1 = new JSeparator();
		separator_4_1_1.setBounds(31, 33, 732, 13);
		panelProveedor.add(separator_4_1_1);

		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(332, 0, 127, 40);
		panelProveedor.add(lblNewLabel_6_1);

		JSeparator separator_1_2_2_1_1_2 = new JSeparator();
		separator_1_2_2_1_1_2.setBounds(419, 232, 341, 2);
		panelProveedor.add(separator_1_2_2_1_1_2);

		JSeparator separator_3_1_1_2 = new JSeparator();
		separator_3_1_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1_2.setBounds(762, 48, 1, 184);
		panelProveedor.add(separator_3_1_1_2);

		JLabel lblNewLabel_7_2 = new JLabel("");
		lblNewLabel_7_2
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/recargar.png")));
		lblNewLabel_7_2.setBounds(632, 390, 18, 18);
		panelProveedor.add(lblNewLabel_7_2);

		JLabel lblNewLabel_8_2 = new JLabel("");
		lblNewLabel_8_2
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/eliminar.png")));
		lblNewLabel_8_2.setBounds(478, 392, 18, 18);
		panelProveedor.add(lblNewLabel_8_2);

		JLabel lblNewLabel_9_2 = new JLabel("");
		lblNewLabel_9_2.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/lupa.png")));
		lblNewLabel_9_2.setBounds(511, 193, 18, 18);
		panelProveedor.add(lblNewLabel_9_2);

		JLabel lblNewLabel_10_2 = new JLabel("");
		lblNewLabel_10_2
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/agregar.png")));
		lblNewLabel_10_2.setBounds(128, 203, 18, 18);
		panelProveedor.add(lblNewLabel_10_2);

		textoCedulaProveedor = new JTextField();
		textoCedulaProveedor.setBounds(195, 120, 161, 18);
		panelProveedor.add(textoCedulaProveedor);
		textoCedulaProveedor.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cedula:");
		lblNewLabel_5.setBounds(51, 121, 46, 14);
		panelProveedor.add(lblNewLabel_5);

		textoNombreProveedor = new JTextField();
		textoNombreProveedor.setBounds(195, 62, 161, 18);
		panelProveedor.add(textoNombreProveedor);
		textoNombreProveedor.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/proveedor.png")));
		lblNewLabel_15.setBounds(569, 63, 45, 45);
		panelProveedor.add(lblNewLabel_15);

		textTelefonoProveedores = new JTextField();
		textTelefonoProveedores.setColumns(10);
		textTelefonoProveedores.setBounds(195, 146, 161, 18);
		panelProveedor.add(textTelefonoProveedores);

		JLabel lblCorreoSede_1_2 = new JLabel("Telefono:");
		lblCorreoSede_1_2.setBounds(51, 148, 104, 14);
		panelProveedor.add(lblCorreoSede_1_2);

		JButton btnCargarSedes_1_1 = new JButton("Cargar");
		btnCargarSedes_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Proveedor> listaProveedores = conexionBase.cargarProveedores();

				String matrizInfo[][] = new String[listaProveedores.size()][5];

				for (int i = 0; i < listaProveedores.size(); i++) {

					String telefono = conexionBase
							.buscarTelefonoProveedor(listaProveedores.get(i).getCodigoProveedor());

					matrizInfo[i][0] = listaProveedores.get(i).getCodigoProveedor() + "";
					matrizInfo[i][1] = listaProveedores.get(i).getCedula() + "";
					matrizInfo[i][2] = listaProveedores.get(i).getNombre() + "";
					matrizInfo[i][3] = listaProveedores.get(i).getApellido() + "";
					matrizInfo[i][4] = telefono + "";
				}

				tablaProveedores.setModel(new DefaultTableModel(matrizInfo,
						new String[] { "Codigo", "Cedula", "Nombre", "Apellidos", "Telefono" }));
				textoBusquedaProveedor.setText("");
			}
		});
		btnCargarSedes_1_1.setBackground(Color.LIGHT_GRAY);
		btnCargarSedes_1_1.setBounds(353, 390, 104, 22);
		panelProveedor.add(btnCargarSedes_1_1);

		JPanel panelCliente = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelCliente.setLayout(null);
		panelCliente.setBackground(Color.WHITE);
		tabbedPane.addTab("Cliente", null, panelCliente, null);

		JLabel lblNewLabel_4_1 = new JLabel("Informaci\u00F3n de los clientes");
		lblNewLabel_4_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(51, 250, 268, 14);
		panelCliente.add(lblNewLabel_4_1);

		textoApellidosCliente = new JTextField();
		textoApellidosCliente.setColumns(10);
		textoApellidosCliente.setBounds(195, 107, 161, 18);
		panelCliente.add(textoApellidosCliente);

		textoDireccionCliente = new JTextField();
		textoDireccionCliente.setColumns(10);
		textoDireccionCliente.setBounds(195, 162, 161, 18);
		panelCliente.add(textoDireccionCliente);

		JLabel lblCodigoSede_1_1 = new JLabel("Nombre:");
		lblCodigoSede_1_1.setBounds(51, 81, 104, 14);
		panelCliente.add(lblCodigoSede_1_1);

		JLabel lblCorreoSede_1_1 = new JLabel("Apellidos:");
		lblCorreoSede_1_1.setBounds(51, 110, 104, 14);
		panelCliente.add(lblCorreoSede_1_1);

		JLabel lblTelefonoSede_1_1 = new JLabel("Direccion:");
		lblTelefonoSede_1_1.setBounds(51, 164, 104, 14);
		panelCliente.add(lblTelefonoSede_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(31, 289, 732, 90);
		panelCliente.add(scrollPane_1_1);

		tablaClientes = new JTable();
		tablaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seleccionado = tablaClientes.rowAtPoint(e.getPoint());
				cedulaCliente = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(seleccionado, 2)));
				textoCedulaCliente.setText(String.valueOf(tablaClientes.getValueAt(seleccionado, 2)));
				textoNombreCliente.setText(String.valueOf(tablaClientes.getValueAt(seleccionado, 0)));
				textoApellidosCliente.setText(String.valueOf(tablaClientes.getValueAt(seleccionado, 1)));
				textoDireccionCliente.setText(String.valueOf(tablaClientes.getValueAt(seleccionado, 3)));
			}
		});
		tablaClientes
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "Nombre", "Apellidos", "Cedula", "Direccion" }));
		scrollPane_1_1.setViewportView(tablaClientes);

		JLabel lblNewLabel_2_1_1 = new JLabel("Codigo:");
		lblNewLabel_2_1_1.setBounds(440, 145, 71, 14);
		panelCliente.add(lblNewLabel_2_1_1);

		textoBusquedaCliente = new JTextField();
		textoBusquedaCliente.setColumns(10);
		textoBusquedaCliente.setBounds(540, 145, 205, 20);
		panelCliente.add(textoBusquedaCliente);

		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cliente cliente = conexionBase.buscarCliente(Integer.parseInt(textoBusquedaCliente.getText()));

				String matriz[][] = new String[1][6];

				if (cliente != null) {

					matriz[0][0] = cliente.getNombre() + "";
					matriz[0][1] = cliente.getApellido() + "";
					matriz[0][2] = cliente.getCedula() + "";
					matriz[0][3] = cliente.getDireccion() + "";

				}

				tablaClientes.setModel(
						new DefaultTableModel(matriz, new String[] { "Nombre", "Apellidos", "Cedula", "Direccion" }));
				textoBusquedaCliente.setText("");
				;
			}
		});
		btnBuscarCliente.setBackground(Color.LIGHT_GRAY);
		btnBuscarCliente.setBounds(539, 193, 104, 20);
		panelCliente.add(btnBuscarCliente);

		JButton btnActualizarCliente = new JButton("Modificar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean actualizado = conexionBase.modificarCliente(cedulaCliente,
						Integer.parseInt(textoCedulaCliente.getText()), textoNombreCliente.getText(),
						textoApellidosCliente.getText(), textoDireccionCliente.getText());

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se puede actualizar el cliente");
				}

				textoCedulaCliente.setText("");
				textoNombreCliente.setText("");
				textoApellidosCliente.setText("");
				textoDireccionCliente.setText("");
			}
		});
		btnActualizarCliente.setBackground(Color.LIGHT_GRAY);
		btnActualizarCliente.setBounds(659, 390, 104, 20);
		panelCliente.add(btnActualizarCliente);

		JButton btnCrearCliente = new JButton("Crear");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean agregado = conexionBase.crearCliente(Integer.parseInt(textoCedulaCliente.getText()),
						textoNombreCliente.getText(), textoApellidosCliente.getText(), textoDireccionCliente.getText());

				if (agregado) {

					JOptionPane.showMessageDialog(null, "El cliente se agrego correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el cliente");
				}

				textoCedulaCliente.setText("");
				textoNombreCliente.setText("");
				textoApellidosCliente.setText("");
				textoDireccionCliente.setText("");
			}
		});
		btnCrearCliente.setBackground(Color.LIGHT_GRAY);
		btnCrearCliente.setBounds(148, 193, 104, 20);
		panelCliente.add(btnCrearCliente);

		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean verificado = conexionBase.eliminarCliente(Integer.parseInt(textoBusquedaCliente.getText()));

				if (verificado) {

					JOptionPane.showMessageDialog(null, "El cliente se elimino correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cliente");
				}

				textoBusquedaCliente.setText("");
			}
		});
		btnEliminarCliente.setBackground(Color.LIGHT_GRAY);
		btnEliminarCliente.setBounds(506, 390, 104, 22);
		panelCliente.add(btnEliminarCliente);

		JSeparator separator_3_4_1 = new JSeparator();
		separator_3_4_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_4_1.setBounds(381, 57, 1, 167);
		panelCliente.add(separator_3_4_1);

		JSeparator separator_3_1_3_1 = new JSeparator();
		separator_3_1_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_3_1.setBounds(419, 57, 1, 167);
		panelCliente.add(separator_3_1_3_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ingrese la cedula del cliente para realizar una busqueda");
		lblNewLabel_1_1_1.setBounds(428, 110, 317, 14);
		panelCliente.add(lblNewLabel_1_1_1);

		JSeparator separator_4_3_1 = new JSeparator();
		separator_4_3_1.setBounds(31, 268, 732, 10);
		panelCliente.add(separator_4_3_1);

		JSeparator separator_3_2_2_1 = new JSeparator();
		separator_3_2_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_2_2_1.setBounds(31, 57, 1, 167);
		panelCliente.add(separator_3_2_2_1);

		JSeparator separator_1_2_3_1 = new JSeparator();
		separator_1_2_3_1.setBounds(31, 224, 351, 2);
		panelCliente.add(separator_1_2_3_1);

		JSeparator separator_1_2_1_2_1 = new JSeparator();
		separator_1_2_1_2_1.setBounds(31, 57, 351, 2);
		panelCliente.add(separator_1_2_1_2_1);

		JSeparator separator_1_2_2_1_3_1 = new JSeparator();
		separator_1_2_2_1_3_1.setBounds(419, 57, 342, 2);
		panelCliente.add(separator_1_2_2_1_3_1);

		JSeparator separator_4_1_1_1 = new JSeparator();
		separator_4_1_1_1.setBounds(31, 33, 732, 13);
		panelCliente.add(separator_4_1_1_1);

		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1_1.setBounds(332, 0, 127, 34);
		panelCliente.add(lblNewLabel_6_1_1);

		JSeparator separator_1_2_2_1_1_2_1 = new JSeparator();
		separator_1_2_2_1_1_2_1.setBounds(419, 224, 342, 2);
		panelCliente.add(separator_1_2_2_1_1_2_1);

		JSeparator separator_3_1_1_2_1 = new JSeparator();
		separator_3_1_1_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1_2_1.setBounds(759, 57, 1, 167);
		panelCliente.add(separator_3_1_1_2_1);

		JLabel lblNewLabel_7_2_1 = new JLabel("");
		lblNewLabel_7_2_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/recargar.png")));
		lblNewLabel_7_2_1.setBounds(632, 390, 18, 18);
		panelCliente.add(lblNewLabel_7_2_1);

		JLabel lblNewLabel_8_2_1 = new JLabel("");
		lblNewLabel_8_2_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/eliminar.png")));
		lblNewLabel_8_2_1.setBounds(478, 392, 18, 18);
		panelCliente.add(lblNewLabel_8_2_1);

		JLabel lblNewLabel_9_2_1 = new JLabel("");
		lblNewLabel_9_2_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/lupa.png")));
		lblNewLabel_9_2_1.setBounds(511, 193, 18, 18);
		panelCliente.add(lblNewLabel_9_2_1);

		JLabel lblNewLabel_10_2_1 = new JLabel("");
		lblNewLabel_10_2_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/agregar.png")));
		lblNewLabel_10_2_1.setBounds(128, 193, 18, 18);
		panelCliente.add(lblNewLabel_10_2_1);

		textoCedulaCliente = new JTextField();
		textoCedulaCliente.setColumns(10);
		textoCedulaCliente.setBounds(195, 135, 161, 18);
		panelCliente.add(textoCedulaCliente);

		JLabel lblNewLabel_5_1 = new JLabel("Cedula:");
		lblNewLabel_5_1.setBounds(51, 135, 46, 14);
		panelCliente.add(lblNewLabel_5_1);

		textoNombreCliente = new JTextField();
		textoNombreCliente.setColumns(10);
		textoNombreCliente.setBounds(195, 77, 161, 18);
		panelCliente.add(textoNombreCliente);

		JLabel lblNewLabel_15_1 = new JLabel("");
		lblNewLabel_15_1
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/usuario.png")));
		lblNewLabel_15_1.setBounds(569, 63, 45, 45);
		panelCliente.add(lblNewLabel_15_1);

		JButton btnCargarSedes_1_2 = new JButton("Cargar");
		btnCargarSedes_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Cliente> listaClientes = conexionBase.cargarClientes();

				String matriz[][] = new String[listaClientes.size()][4];

				for (int i = 0; i < listaClientes.size(); i++) {

					matriz[i][0] = listaClientes.get(i).getNombre() + "";
					matriz[i][1] = listaClientes.get(i).getApellido() + "";
					matriz[i][2] = listaClientes.get(i).getCedula() + "";
					matriz[i][3] = listaClientes.get(i).getDireccion() + "";

				}

				tablaClientes.setModel(
						new DefaultTableModel(matriz, new String[] { "Nombre", "Apellidos", "Cedula", "Direccion" }));
				textoBusquedaCliente.setText("");
			}
		});
		btnCargarSedes_1_2.setBackground(Color.LIGHT_GRAY);
		btnCargarSedes_1_2.setBounds(353, 389, 104, 22);
		panelCliente.add(btnCargarSedes_1_2);

		JPanel panelCarrito = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelCarrito.setLayout(null);
		panelCarrito.setBackground(Color.WHITE);
		tabbedPane.addTab("Carrito", null, panelCarrito, null);

		JLabel lblInformacinDelCarrito = new JLabel("Informaci\u00F3n del carrito");
		lblInformacinDelCarrito.setForeground(Color.DARK_GRAY);
		lblInformacinDelCarrito.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformacinDelCarrito.setBounds(61, 250, 268, 14);
		panelCarrito.add(lblInformacinDelCarrito);

		textoFechaCarrito = new JTextField();
		textoFechaCarrito.setColumns(10);
		textoFechaCarrito.setBounds(195, 154, 161, 20);
		panelCarrito.add(textoFechaCarrito);

		JLabel lblCedulaCliente = new JLabel("Precio total:");
		lblCedulaCliente.setBounds(51, 121, 104, 14);
		panelCarrito.add(lblCedulaCliente);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(51, 157, 104, 14);
		panelCarrito.add(lblFecha);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(31, 289, 732, 90);
		panelCarrito.add(scrollPane_3);

		tablaCarritos = new JTable();
		tablaCarritos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seleccionado = tablaCarritos.rowAtPoint(e.getPoint());
				numeroCarrito = Integer.parseInt(String.valueOf(tablaCarritos.getValueAt(seleccionado, 0)));
				textoFechaCarrito.setText(String.valueOf(tablaCarritos.getValueAt(seleccionado, 2)));
				textoPrecioTotalCarrito.setText(String.valueOf(tablaCarritos.getValueAt(seleccionado, 3)));
			}
		});
		tablaCarritos.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "Num Carrito", "Cliente", "Fecha", "Costo Total" }));
		scrollPane_3.setViewportView(tablaCarritos);

		JLabel lblNewLabel_2_3 = new JLabel("Numero Carrito:");
		lblNewLabel_2_3.setBounds(430, 128, 127, 14);
		panelCarrito.add(lblNewLabel_2_3);

		textoBusquedaCarrito = new JTextField();
		textoBusquedaCarrito.setColumns(10);
		textoBusquedaCarrito.setBounds(539, 125, 205, 20);
		panelCarrito.add(textoBusquedaCarrito);

		JButton btnBuscarCarrito = new JButton("Buscar");
		btnBuscarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Carrito carrito = conexionBase.buscarCarrito(Integer.parseInt(textoBusquedaCarrito.getText()));

				String matrizInfo[][] = new String[1][4];

				if (carrito != null) {

					matrizInfo[0][0] = carrito.getNumeroCarrito() + "";
					matrizInfo[0][1] = carrito.getCedulaCliente() + "";
					matrizInfo[0][2] = carrito.getFechaCreacion() + "";
					matrizInfo[0][3] = carrito.getCostoTotal() + "";

				}

				tablaCarritos.setModel(new DefaultTableModel(matrizInfo,
						new String[] { "Num Carrito", "Cliente", "Fecha", "Costo Total" }));
				textoBusquedaCarrito.setText("");
			}
		});
		btnBuscarCarrito.setBackground(Color.LIGHT_GRAY);
		btnBuscarCarrito.setBounds(539, 193, 104, 20);
		panelCarrito.add(btnBuscarCarrito);

		JButton btnActualizarCarrito = new JButton("Modificar");
		btnActualizarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date fechaCarrito = Date.valueOf(textoFechaCarrito.getText());

				boolean actualizado = conexionBase.actualizarCarrito(numeroCarrito, fechaCarrito,
						Integer.parseInt(textoPrecioTotalCarrito.getText()));

				if (actualizado) {

					JOptionPane.showMessageDialog(null, "Carrito actualizado correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se puedo actualizar el carrito");
				}
				textoFechaCarrito.setText("");
				textCedulaClienteCarrito.setText("");
				textoPrecioTotalCarrito.setText("");
			}
		});
		btnActualizarCarrito.setBackground(Color.LIGHT_GRAY);
		btnActualizarCarrito.setBounds(659, 390, 104, 20);
		panelCarrito.add(btnActualizarCarrito);

		JButton btnCrearCarrito = new JButton("Crear");
		btnCrearCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date fechaCarrito = Date.valueOf(textoFechaCarrito.getText());

				boolean agregado = conexionBase.crearCarrito(fechaCarrito, textCedulaClienteCarrito.getText(),
						Integer.parseInt(textoPrecioTotalCarrito.getText()));

				if (agregado) {

					JOptionPane.showMessageDialog(null, "Carrito creado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de crear el carrito");
				}

				textoFechaCarrito.setText("");
				textCedulaClienteCarrito.setText("");
				textoPrecioTotalCarrito.setText("");
			}
		});
		btnCrearCarrito.setBackground(Color.LIGHT_GRAY);
		btnCrearCarrito.setBounds(148, 193, 104, 20);
		panelCarrito.add(btnCrearCarrito);

		JButton btnEliminarCarrito = new JButton("Eliminar");
		btnEliminarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean eliminado = conexionBase.eliminarCarrito(Integer.parseInt(textoBusquedaCarrito.getText()));

				if (eliminado) {

					JOptionPane.showMessageDialog(null, "Carrito eliminado correctamente");
				} else {

					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el carrito");
				}

				textoBusquedaCarrito.setText("");
			}
		});
		btnEliminarCarrito.setBackground(Color.LIGHT_GRAY);
		btnEliminarCarrito.setBounds(506, 390, 104, 22);
		panelCarrito.add(btnEliminarCarrito);

		JSeparator separator_3_5 = new JSeparator();
		separator_3_5.setOrientation(SwingConstants.VERTICAL);
		separator_3_5.setBounds(381, 57, 1, 167);
		panelCarrito.add(separator_3_5);

		JSeparator separator_3_1_4 = new JSeparator();
		separator_3_1_4.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_4.setBounds(419, 57, 1, 167);
		panelCarrito.add(separator_3_1_4);

		JLabel lblNewLabel_1_3 = new JLabel("Ingrese el numero del carrito para realizar una busqueda");
		lblNewLabel_1_3.setBounds(427, 75, 371, 14);
		panelCarrito.add(lblNewLabel_1_3);

		JSeparator separator_4_4 = new JSeparator();
		separator_4_4.setBounds(31, 268, 732, 10);
		panelCarrito.add(separator_4_4);

		JSeparator separator_3_2_3 = new JSeparator();
		separator_3_2_3.setOrientation(SwingConstants.VERTICAL);
		separator_3_2_3.setBounds(31, 57, 1, 167);
		panelCarrito.add(separator_3_2_3);

		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(31, 224, 351, 2);
		panelCarrito.add(separator_1_2_4);

		JSeparator separator_1_2_1_3 = new JSeparator();
		separator_1_2_1_3.setBounds(31, 57, 351, 2);
		panelCarrito.add(separator_1_2_1_3);

		JSeparator separator_1_2_2_1_4 = new JSeparator();
		separator_1_2_2_1_4.setBounds(419, 57, 342, 2);
		panelCarrito.add(separator_1_2_2_1_4);

		JSeparator separator_4_1_2 = new JSeparator();
		separator_4_1_2.setBounds(31, 33, 732, 13);
		panelCarrito.add(separator_4_1_2);

		JLabel lblNewLabel_6_2 = new JLabel("");
		lblNewLabel_6_2
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_2.setBounds(334, 0, 127, 34);
		panelCarrito.add(lblNewLabel_6_2);

		JSeparator separator_1_2_2_1_1_3 = new JSeparator();
		separator_1_2_2_1_1_3.setBounds(419, 224, 342, 2);
		panelCarrito.add(separator_1_2_2_1_1_3);

		JSeparator separator_3_1_1_3 = new JSeparator();
		separator_3_1_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_3_1_1_3.setBounds(759, 57, 1, 167);
		panelCarrito.add(separator_3_1_1_3);

		JLabel lblNewLabel_7_3 = new JLabel("");
		lblNewLabel_7_3
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/recargar.png")));
		lblNewLabel_7_3.setBounds(632, 390, 18, 18);
		panelCarrito.add(lblNewLabel_7_3);

		JLabel lblNewLabel_8_3 = new JLabel("");
		lblNewLabel_8_3
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/eliminar.png")));
		lblNewLabel_8_3.setBounds(478, 392, 18, 18);
		panelCarrito.add(lblNewLabel_8_3);

		JLabel lblNewLabel_9_3 = new JLabel("");
		lblNewLabel_9_3.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/lupa.png")));
		lblNewLabel_9_3.setBounds(511, 193, 18, 18);
		panelCarrito.add(lblNewLabel_9_3);

		JLabel lblNewLabel_10_3 = new JLabel("");
		lblNewLabel_10_3
				.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/agregar.png")));
		lblNewLabel_10_3.setBounds(128, 193, 18, 18);
		panelCarrito.add(lblNewLabel_10_3);

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(
				new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/carrito-de-compras.png")));
		lblNewLabel_17.setBounds(31, 246, 20, 20);
		panelCarrito.add(lblNewLabel_17);

		textCedulaClienteCarrito = new JTextField();
		textCedulaClienteCarrito.setColumns(10);
		textCedulaClienteCarrito.setBounds(195, 77, 161, 20);
		panelCarrito.add(textCedulaClienteCarrito);

		JButton btnCargarSedes_1_3 = new JButton("Cargar");
		btnCargarSedes_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Carrito> listaCarritos = conexionBase.cargarCarritos();

				String matrizInfo[][] = new String[listaCarritos.size()][4];

				for (int i = 0; i < listaCarritos.size(); i++) {

					matrizInfo[i][0] = listaCarritos.get(i).getNumeroCarrito() + "";
					matrizInfo[i][1] = listaCarritos.get(i).getCedulaCliente() + "";
					matrizInfo[i][2] = listaCarritos.get(i).getFechaCreacion() + "";
					matrizInfo[i][3] = listaCarritos.get(i).getCostoTotal() + "";
				}

				tablaCarritos.setModel(new DefaultTableModel(matrizInfo,
						new String[] { "Num Carrito", "Cliente", "Fecha", "Costo Total" }));
			}
		});
		btnCargarSedes_1_3.setBackground(Color.LIGHT_GRAY);
		btnCargarSedes_1_3.setBounds(353, 390, 104, 22);
		panelCarrito.add(btnCargarSedes_1_3);

		JLabel lblCedulaCliente_1 = new JLabel("Cedula Cliente:");
		lblCedulaCliente_1.setBounds(51, 80, 104, 14);
		panelCarrito.add(lblCedulaCliente_1);

		textoPrecioTotalCarrito = new JTextField();
		textoPrecioTotalCarrito.setBounds(195, 116, 161, 20);
		panelCarrito.add(textoPrecioTotalCarrito);
		textoPrecioTotalCarrito.setColumns(10);

		JPanel panelRelaciones = new JPanel() {

			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelRelaciones.setBackground(Color.WHITE);
		tabbedPane.addTab("Relaciones", null, panelRelaciones, null);
		panelRelaciones.setLayout(null);
		
		JSeparator separator_4_1_2_1 = new JSeparator();
		separator_4_1_2_1.setBounds(31, 33, 732, 13);
		panelRelaciones.add(separator_4_1_2_1);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("");
		lblNewLabel_6_2_1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6_2_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_2_1.setBounds(334, 0, 127, 34);
		panelRelaciones.add(lblNewLabel_6_2_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(395, 45, 1, 375);
		panelRelaciones.add(separator);
		
		JLabel lblNewLabel_23 = new JLabel("Adquisici?n de productos");
		lblNewLabel_23.setBounds(139, 45, 155, 14);
		panelRelaciones.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Tramite:");
		lblNewLabel_24.setBounds(31, 78, 160, 14);
		panelRelaciones.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Codigo Sede:");
		lblNewLabel_25.setBounds(31, 113, 160, 14);
		panelRelaciones.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Codigo producto:");
		lblNewLabel_26.setBounds(31, 182, 160, 14);
		panelRelaciones.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Codigo proveedor:");
		lblNewLabel_27.setBounds(31, 149, 160, 14);
		panelRelaciones.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Cantidad:");
		lblNewLabel_28.setBounds(31, 218, 160, 13);
		panelRelaciones.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Costo unitario:");
		lblNewLabel_29.setBounds(31, 254, 160, 14);
		panelRelaciones.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Precio total:");
		lblNewLabel_30.setBounds(31, 291, 160, 14);
		panelRelaciones.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Fecha:");
		lblNewLabel_31.setBounds(31, 329, 160, 14);
		panelRelaciones.add(lblNewLabel_31);
		
		textCodigoTramite = new JTextField();
		textCodigoTramite.setColumns(10);
		textCodigoTramite.setBounds(201, 75, 161, 20);
		panelRelaciones.add(textCodigoTramite);
		
		textCodSedeAP = new JTextField();
		textCodSedeAP.setColumns(10);
		textCodSedeAP.setBounds(201, 110, 161, 20);
		panelRelaciones.add(textCodSedeAP);
		
		textCodProveedorAP = new JTextField();
		textCodProveedorAP.setColumns(10);
		textCodProveedorAP.setBounds(201, 146, 161, 20);
		panelRelaciones.add(textCodProveedorAP);
		
		textCodProductoAP = new JTextField();
		textCodProductoAP.setColumns(10);
		textCodProductoAP.setBounds(201, 179, 161, 20);
		panelRelaciones.add(textCodProductoAP);
		
		textCantidadAP = new JTextField();
		textCantidadAP.setColumns(10);
		textCantidadAP.setBounds(201, 214, 161, 20);
		panelRelaciones.add(textCantidadAP);
		
		textCostoUnitarioAP = new JTextField();
		textCostoUnitarioAP.setColumns(10);
		textCostoUnitarioAP.setBounds(201, 251, 161, 20);
		panelRelaciones.add(textCostoUnitarioAP);
		
		textPrecioTotalAP = new JTextField();
		textPrecioTotalAP.setColumns(10);
		textPrecioTotalAP.setBounds(201, 288, 161, 20);
		panelRelaciones.add(textPrecioTotalAP);
		
		textFechaAP = new JTextField();
		textFechaAP.setColumns(10);
		textFechaAP.setBounds(201, 326, 161, 20);
		panelRelaciones.add(textFechaAP);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date fechaCreacion = Date.valueOf(textFechaAP.getText());
				
				boolean aux = conexionBase.crearTramite(Integer.parseInt(textCodigoTramite.getText()), Integer.parseInt(textCantidadAP.getText()), Integer.parseInt(textPrecioTotalAP.getText()), Integer.parseInt(textCostoUnitarioAP.getText()), Integer.parseInt(textCodSedeAP.getText()), Integer.parseInt(textCodProductoAP.getText()), Integer.parseInt(textCodProveedorAP.getText()), fechaCreacion);
			
				if(aux) {
					
					JOptionPane.showMessageDialog(null,"El tramite se realizo con exito");
					
				}else {
					
					JOptionPane.showMessageDialog(null,"El tramite no se puedo efectuar");
				}
				
				textCantidadAP.setText("");
				textFechaAP.setText("");
				textCodigoTramite.setText("");
				textCodSedeAP.setText("");
				textPrecioTotalAP.setText("");
				textCostoUnitarioAP.setText("");
				textCodProductoAP.setText("");
				textCodProveedorAP.setText("");
			}
		});
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(69, 380, 104, 20);
		panelRelaciones.add(btnGuardar);
		
		JLabel lblNewLabel_23_1 = new JLabel("Ventas");
		lblNewLabel_23_1.setBounds(573, 45, 53, 14);
		panelRelaciones.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_28_1 = new JLabel("Cantidad:");
		lblNewLabel_28_1.setBounds(444, 78, 92, 14);
		panelRelaciones.add(lblNewLabel_28_1);
		
		JLabel lblNewLabel_27_1 = new JLabel("Codigo carrito:");
		lblNewLabel_27_1.setBounds(444, 113, 92, 14);
		panelRelaciones.add(lblNewLabel_27_1);
		
		JLabel lblNewLabel_24_1 = new JLabel("Codigo Tramite:");
		lblNewLabel_24_1.setBounds(444, 149, 92, 14);
		panelRelaciones.add(lblNewLabel_24_1);
		
		textCantidadVenta = new JTextField();
		textCantidadVenta.setColumns(10);
		textCantidadVenta.setBounds(602, 75, 161, 20);
		panelRelaciones.add(textCantidadVenta);
		
		textCodigiCarritoVenta = new JTextField();
		textCodigiCarritoVenta.setColumns(10);
		textCodigiCarritoVenta.setBounds(602, 110, 161, 20);
		panelRelaciones.add(textCodigiCarritoVenta);
		
		textCodigoTramiteVenta = new JTextField();
		textCodigoTramiteVenta.setColumns(10);
		textCodigoTramiteVenta.setBounds(602, 146, 161, 20);
		panelRelaciones.add(textCodigoTramiteVenta);
		
		JButton btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean aux = conexionBase.crearVenta(Integer.parseInt(textCodigoTramiteVenta.getText()), Integer.parseInt(textCantidadVenta.getText()), Integer.parseInt(textCodigiCarritoVenta.getText()));
			
				
				if(aux) {
					JOptionPane.showMessageDialog(null, "La venta se realizo correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "La venta no se realizco correctamente");
				}
				
				textCodigiCarritoVenta.setText("");
				textCantidadVenta.setText("");
				textCodigoTramiteVenta.setText("");
			}
		});
		btnGuardar_1.setBackground(Color.LIGHT_GRAY);
		btnGuardar_1.setBounds(486, 380, 104, 20);
		panelRelaciones.add(btnGuardar_1);
		
		JButton btneliminarTramite = new JButton("Eliminar");
		btneliminarTramite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean aux = conexionBase.eliminarTramite(Integer.parseInt(textCodigoTramite.getText()));
				
				if(aux) {
					
					JOptionPane.showMessageDialog(null,"El tramite se elimino correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"El tramite no se pudo eliminar");
				}
			
				textCodigoTramite.setText("");
			}
		});
		btneliminarTramite.setBackground(Color.LIGHT_GRAY);
		btneliminarTramite.setBounds(201, 380, 104, 20);
		panelRelaciones.add(btneliminarTramite);
		
		JButton btnEliminarVenta = new JButton("Eliminar");
		btnEliminarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean aux = conexionBase.eliminarVenta(Integer.parseInt(textCodigoTramiteVenta.getText()));
				
				if(aux) {
					JOptionPane.showMessageDialog(null,"La venta se elimino correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"La venta no se pudo eliminar");
				}
				textCodigoTramiteVenta.setText("");
			}
		});
		btnEliminarVenta.setBackground(Color.LIGHT_GRAY);
		btnEliminarVenta.setBounds(612, 380, 104, 20);
		panelRelaciones.add(btnEliminarVenta);
		
		JPanel panelConsultas = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		panelConsultas.setBackground(Color.WHITE);
		tabbedPane.addTab("Consultas", null, panelConsultas, null);
		panelConsultas.setLayout(null);
	
		String [] consultas = {"Listar el cliente con el carrito m?s caro",
				"Listar el producto con m?s unidades en stock",
				"Listar la sede a la que han prove?do m?s veces", 
				"Listar los clientes que compraron en la sede de Armenia un producto de higiene, adem?s, "
						+ "los que compraron en la sede de Medell?n un producto de Hogar",
				"Listar los proveedores que proveyeron productos de Mascotas a la sede de Medell?n y a la sede de Bogot?",
				"Listar las sedes en orden descendente por ventas",
				"Listar los clientes que compraron un producto de tipo alimento con un precio superior a 10000, "
						+ "s?lo listar aquellos que hayan comprado en la misma sede que los que compraron productos de tipo Belleza",
				"Listar los proveedores que proveyeron a la sede de Medell?n. Tener en cuenta solo los proveedores que hayan prove?do en alguna de las fechas de los que proveyeron a la sede de Bogot?",
				"Listar por Sede las ventas totales que tiene. Tener en cuenta solo aquellos clientes que tengan un carrito con un precio superior "
						+ "al del carrito m?s caro de la sede de Armenia"};
		
		listaConsultas = new JList<String>(consultas);
		listaConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane panelLista = new JScrollPane(listaConsultas);
		panelLista.setBounds(40, 80, 350, 250);
		panelConsultas.add(panelLista);
		
		JSeparator separator_4_1_2_1_1 = new JSeparator();
		separator_4_1_2_1_1.setBounds(31, 33, 732, 13);
		panelConsultas.add(separator_4_1_2_1_1);
		
		JSeparator separator2 = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(400, 70, 50, 300);
		panelConsultas.add(separator);
		
		JLabel lblNewLabel_6_2_1_1 = new JLabel("");
		lblNewLabel_6_2_1_1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_6_2_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_6_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_2_1_1.setBounds(334, 0, 127, 34);
		panelConsultas.add(lblNewLabel_6_2_1_1);
		
		JLabel lblNewLabel_23_11 = new JLabel("Consultas");
		lblNewLabel_23_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_23_11.setBounds(370, 35, 127, 34);
		panelConsultas.add(lblNewLabel_23_11);
		
		JLabel lblNewLabel_23_12 = new JLabel("Consulta seleccionada: ");
		lblNewLabel_23_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_23_12.setBounds(420, 70, 200, 34);
		panelConsultas.add(lblNewLabel_23_12);
		
		Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JTextPane textPane= new JTextPane();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		textPane.setBounds(420, 100, 350, 230);
		textPane.setBackground(Color.WHITE);
		SimpleAttributeSet align= new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_JUSTIFIED);
		textPane.setBorder(line);
		textPane.setFont(new Font("Arial", Font.BOLD, 14));
		textPane.setEditable(false);
		panelConsultas.add(textPane);
		
		JButton bGenerarPDF = new JButton("Generar PDF");
		bGenerarPDF.setBackground(Color.LIGHT_GRAY);
		bGenerarPDF.setBounds(642, 350, 128, 28);
		bGenerarPDF.setEnabled(false);
		panelConsultas.add(bGenerarPDF);
		bGenerarPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List<String> consulta2 = listaConsultas.getSelectedValuesList();
				
				String aux2 = "";
				
				for (String aux : consulta2) {
					
					aux2 = aux;
					
				}
				
				try {
					
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buenPrecio", "root", "1234567890");
					
					String sql = "";
					String arch = "";
					
					if (aux2.equalsIgnoreCase(consultas[0])) {
						
						sql = "SELECT * FROM cliente INNER JOIN carrito ON cliente.cedula = carrito.cedulaCliente ORDER BY carrito.costoTotal DESC LIMIT 1";
						arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte1.jrxml";
						
					} else {
						
						if (aux2.equalsIgnoreCase(consultas[1])) {
							
							sql = "SELECT * FROM producto INNER JOIN tipo_producto ON producto.tipo_tipoProducto = tipo_producto.codigoTipo ORDER BY producto.stock DESC LIMIT 1";
							arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte2.jrxml";
							
						} else {
							
							if (aux2.equalsIgnoreCase(consultas[2])) {
								
								sql = "SELECT sede.codigoSede, Count(sedeP.sede_codigoSede) AS codS_count FROM sede_proveedor sedeP INNER JOIN sede "
										+ "ON sedeP.sede_codigoSede = sede.codigoSede GROUP BY sede.codigoSede "
										+ "ORDER BY codS_count DESC LIMIT 1";
								arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte3.jrxml";
								
							} else {
								
								if (aux2.equalsIgnoreCase(consultas[3])) {
									
									sql = "SELECT * FROM cliente clienteP INNER JOIN carrito carP"
											+ " ON clienteP.cedula = carP.cedulaCliente"
											+ "	INNER JOIN  carrito_sede_proveedor principalCSP"
											+ "	ON carP.numeroCarrito = principalCSP.carrito_numeroCarrito"
											+ "	INNER JOIN sede_Proveedor sedeProveP"
											+ "	ON principalCSP.codigoSP = sedeProveP.codigo"
											+ "	INNER JOIN sede sedeP"
											+ "	ON sedeProveP.sede_codigoSede = sedeP.codigoSede"
											+ "	INNER JOIN ciudad ciudadP"
											+ "	ON sedeP.ciudad_codigoPostal = ciudadP.codigoPostal"
											+ "	INNER JOIN  producto produP"
											+ "	ON sedeProveP.producto_codigoProducto = produP.codigoProducto"
											+ "	INNER JOIN tipo_producto tipoP"
											+ "	ON produP.tipo_tipoProducto = tipoP.codigoTipo"
											+ "	WHERE (tipoP.nombreTipo LIKE 'higiene'"
											+ "	AND ciudadP.nombre LIKE 'armenia')"
											+ " OR (tipoP.nombreTipo LIKE 'hogar'"
											+ " AND ciudadP.nombre LIKE 'medellin')";
									
									arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte4.jrxml";
									
								} else {
									
									if (aux2.equalsIgnoreCase(consultas[4])) {
										
										sql = "SELECT * FROM proveedor prov"
												+ "	INNER JOIN  sede_proveedor sedeProv"
												+ "	ON prov.codigoProveedor = sedeProv.proveedor_codigoProveedor"
												+ "	INNER JOIN producto produc"
												+ "	ON sedeProv.producto_codigoProducto = produc.codigoProducto"
												+ "	INNER JOIN tipo_producto tipoP"
												+ "	ON produc.tipo_tipoProducto = tipoP.codigoTipo"
												+ "	INNER JOIN sede sedeP"
												+ "	ON sedeProv.sede_codigoSede = sedeP.codigoSede"
												+ "	INNER JOIN ciudad ciuP"
												+ "	ON sedeP.ciudad_codigoPostal = ciuP.codigoPostal"
												+ "	WHERE tipoP.nombreTipo LIKE 'mascota'"
												+ "	AND ciuP.nombre LIKE 'medellin'"
												+ "	AND prov.codigoProveedor IN"
												+ "	(SELECT prov2.codigoProveedor FROM proveedor prov2"
												+ "	INNER JOIN sede_proveedor sedeProv2"
												+ "	ON prov2.codigoProveedor = sedeProv2.proveedor_codigoProveedor"
												+ "	INNER JOIN producto produc2"
												+ "	ON sedeProv2.producto_codigoProducto = produc2.codigoProducto"
												+ "	INNER JOIN tipo_producto tipoP2"
												+ "	ON produc2.tipo_tipoProducto = tipoP2.codigoTipo"
												+ "	INNER JOIN sede sedeP2"
												+ "	ON sedeProv2.sede_codigoSede = sedeP2.codigoSede"
												+ "	INNER JOIN ciudad ciuP2"
												+ "	ON sedeP2.ciudad_codigoPostal = ciuP2.codigoPostal"
												+ "	WHERE tipoP2.nombreTipo LIKE 'mascota'"
												+ "	AND ciuP2.nombre LIKE 'bogota')";
										
										arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte5.jrxml";
										
									} else {
										
										if (aux2.equalsIgnoreCase(consultas[5])) {
											
											sql = "SELECT sedeP.codigoSede, COUNT(sedeProv.sede_codigoSede) AS count_sede"
													+ "	FROM sede sedeP INNER JOIN sede_proveedor sedeProv"
													+ "	ON sedeP.codigoSede = sedeProv.sede_codigoSede"
													+ "	INNER JOIN carrito_sede_proveedor carSedeP"
													+ "	ON sedeProv.codigo = carSedeP.codigoSP"
													+ "	GROUP BY sedeP.codigoSede ORDER BY count_sede DESC";
											
											arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte6.jrxml";
											
										} else {
											
											if (aux2.equalsIgnoreCase(consultas[6])) {
												
												sql = "SELECT * FROM cliente clienteP INNER JOIN carrito carP"
														+ " ON clienteP.cedula = carP.cedulaCliente"
														+ " INNER JOIN carrito_sede_proveedor carSedeProv"
														+ " ON carP.numeroCarrito = carSedeProv.carrito_numeroCarrito"
														+ " INNER JOIN sede_proveedor sedeProv"
														+ " ON carSedeProv.codigoSP = sedeProv.codigo"
														+ " INNER JOIN producto produc"
														+ " ON sedeProv.producto_codigoProducto = produc.codigoProducto"
														+ " INNER JOIN tipo_producto tipoP"
														+ " ON produc.tipo_tipoProducto = tipoP.codigoTipo"
														+ " INNER JOIN sede sedeP"
														+ " ON sedeProv.sede_codigoSede = sedeP.codigoSede"
														+ " WHERE produc.precio > 10000"
														+ " AND sedeP.codigoSede"
														+ " IN (SELECT sedeP2.codigoSede FROM cliente clienteP2"
														+ " INNER JOIN carrito carP2"
														+ " ON clienteP2.cedula = carP2.cedulaCliente"
														+ " INNER JOIN carrito_sede_proveedor carSedeProv2"
														+ " ON carP2.numeroCarrito = carSedeProv2.carrito_numeroCarrito"
														+ " INNER JOIN sede_proveedor sedeProv2"
														+ " ON carSedeProv2.codigoSP = sedeProv2.codigo"
														+ " INNER JOIN producto produc2"
														+ " ON sedeProv2.producto_codigoProducto = produc2.codigoProducto"
														+ " INNER JOIN tipo_producto tipoP2"
														+ " ON produc2.tipo_tipoProducto = tipoP2.codigoTipo"
														+ " INNER JOIN sede sedeP2"
														+ " ON sedeProv2.sede_codigoSede = sedeP2.codigoSede"
														+ " WHERE tipoP2.nombreTipo LIKE 'belleza')";
												
												arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte7.jrxml";
												
											} else {
												
												if (aux2.equalsIgnoreCase(consultas[7])) {
													
													sql = "SELECT * FROM proveedor prov"
															+ "	INNER JOIN  sede_proveedor sedeProv"
															+ "	ON prov.codigoProveedor = sedeProv.proveedor_codigoProveedor"
															+ "	INNER JOIN sede sedeP"
															+ "	ON sedeProv.sede_codigoSede = sedeP.codigoSede"
															+ "	INNER JOIN ciudad ciuP"
															+ "	ON sedeP.ciudad_codigoPostal = ciuP.codigoPostal"
															+ "	WHERE ciuP.nombre LIKE 'medellin'"
															+ "	AND sedeProv.fecha IN"
															+ "	(SELECT sedeProv2.fecha FROM proveedor prov2"
															+ "	INNER JOIN  sede_proveedor sedeProv2"
															+ "	ON prov2.codigoProveedor = sedeProv2.proveedor_codigoProveedor"
															+ "	INNER JOIN sede sedeP2"
															+ "	ON sedeProv2.sede_codigoSede = sedeP2.codigoSede"
															+ "	INNER JOIN ciudad ciuP2"
															+ "	ON sedeP2.ciudad_codigoPostal = ciuP2.codigoPostal"
															+ "	WHERE ciuP2.nombre  LIKE 'bogota')";
													
													arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte8.jrxml";
													
												} else {
													
													if (aux2.equalsIgnoreCase(consultas[8])) {
														
														sql = "SELECT sedeP.codigoSede, SUM(carP.costoTotal) AS sum_sede"
																+ "	FROM sede sedeP INNER JOIN sede_proveedor sedeProv"
																+ "	ON sedeP.codigoSede = sedeProv.sede_codigoSede"
																+ "	INNER JOIN carrito_sede_proveedor carSedeP"
																+ "	ON sedeProv.codigo = carSedeP.codigoSP"
																+ "	INNER JOIN carrito carP"
																+ "	ON carSedeP.carrito_numeroCarrito = carP.numeroCarrito"
																+ "	WHERE costoTotal >"
																+ "	(SELECT MAX(costoTotal) FROM carrito carP2"
																+ "	INNER JOIN carrito_sede_proveedor carSedeProv2"
																+ "	ON carP2.numeroCarrito = carSedeProv2.carrito_numeroCarrito"
																+ "	INNER JOIN sede_proveedor sedeProv2"
																+ "	ON carSedeProv2.codigoSP = sedeProv2.codigo"
																+ "	INNER JOIN sede sedeP2"
																+ "	ON sedeProv2.sede_codigoSede = sedeP2.codigoSede"
																+ "	INNER JOIN ciudad ciuP2"
																+ "	ON sedeP2.ciudad_codigoPostal = ciuP2.codigoPostal"
																+ "	WHERE ciuP2.nombre LIKE 'armenia')"
																+ "	GROUP BY sedeP.codigoSede"
																+ "	ORDER BY Sum_sede DESC";
														
														arch = "C:\\Users\\TecnoMakro\\Desktop\\Trabajos\\Proyecto Final Bases\\ProyectoFinalBases\\src\\co\\edu\\uniquindio\\reportes\\Reporte9.jrxml";
														
													} else {
														
														System.out.println("Seleccione una opci?n v?lida");
														
													}
													
												}
												
											}
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
					JasperDesign jdesign = JRXmlLoader.load(arch);
					JRDesignQuery updateQuery = new JRDesignQuery();
					updateQuery.setText(sql);
					
					jdesign.setQuery(updateQuery);
					
					JasperReport jReport = JasperCompileManager.compileReport(jdesign);
					JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
					
					JasperViewer.viewReport(jPrint, false);
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		
		listaConsultas.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				List<String> consulta = listaConsultas.getSelectedValuesList();
				
				StringBuilder texto = new StringBuilder();
				
				if(listaConsultas.isSelectionEmpty()){
					
					bGenerarPDF.setEnabled(false);
					
				} else {
					
					bGenerarPDF.setEnabled(true);
					
				}
				
				for (String aux : consulta) {
					
					String aux2 = aux;
					
					texto.append(aux2);
					
					texto.append(" ");
					
					textPane.setText(texto.toString());
					
				}
				
			}
			
		});
		
		
		
	}
}
