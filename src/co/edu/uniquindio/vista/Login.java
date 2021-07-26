package co.edu.uniquindio.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frmElBuenPrecio;
	private JTextField textoUsuario;
	private JTextField textoContrasenia;

	VistaPrincipal ventana;
	String usario1 = "brandon";
	String contrasenia1 = "brandon123";
	String usuario2 = "melissa";
	String contrasenia2 = "maya";
	String usuario3 = "esteban";
	String contrasenia3 = "esteban000";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmElBuenPrecio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElBuenPrecio = new JFrame();
		frmElBuenPrecio.setBackground(Color.WHITE);
		frmElBuenPrecio.setTitle("El Buen Precio");
		frmElBuenPrecio.getContentPane().setBackground(Color.WHITE);
		frmElBuenPrecio.setBounds(100, 100, 332, 271);
		frmElBuenPrecio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElBuenPrecio.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(55, 94, 54, 14);
		frmElBuenPrecio.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(55, 141, 76, 14);
		frmElBuenPrecio.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textoUsuario.getText().equalsIgnoreCase("brandon")
						&& textoContrasenia.getText().equalsIgnoreCase("brandon123")
						|| textoUsuario.getText().equalsIgnoreCase("melissa")
								&& textoContrasenia.getText().equalsIgnoreCase("maya")
						|| textoUsuario.getText().equalsIgnoreCase("esteban")
								&& textoContrasenia.getText().equalsIgnoreCase("esteban000")) {

					ventana = new VistaPrincipal();
					ventana.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Datos incorrectos, ingrese sus datos de administrador");
				}
			}
		});
		btnNewButton.setBounds(113, 181, 89, 23);
		frmElBuenPrecio.getContentPane().add(btnNewButton);

		textoUsuario = new JTextField();
		textoUsuario.setBounds(157, 91, 101, 20);
		frmElBuenPrecio.getContentPane().add(textoUsuario);
		textoUsuario.setColumns(10);

		textoContrasenia = new JTextField();
		textoContrasenia.setBounds(157, 138, 101, 20);
		frmElBuenPrecio.getContentPane().add(textoContrasenia);
		textoContrasenia.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/co/edu/uniquindio/inconos/Titulo.png")));
		lblNewLabel_2.setBounds(92, 27, 127, 34);
		frmElBuenPrecio.getContentPane().add(lblNewLabel_2);
	}
}
