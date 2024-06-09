package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorUsuario;
import modelo.ExcepcionUsuario;
import modelo.Usuario;

public class VentanaLogin extends JFrame {

	// Atributos.
	private static final long serialVersionUID = 1L;
	private ControladorUsuario controladorUsuario;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JTextArea textAreaMensajes;
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;

	// Constructor.
	public VentanaLogin(ControladorUsuario controladorUsuario) {
		this.controladorUsuario = controladorUsuario;
		ventana();
	}

	// Método para crear la ventana.
	private void ventana() {
		// Frame.
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(null);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		// Panel oeste.
		panelOeste();

		// Panel este.
		panelEste();

		// Configurar Ventana
		configurarVentana();
	}

	// Método para configurar la ventana.
	private void configurarVentana() {
		setTitle("Mastermind - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		// Asignar el icono de la aplicación.
		try {
			this.setIconImage(ImageIO.read(new File("resources/icon/icono.png")));
		} catch (IOException e) {
			Mensaje.error(this, "Error al intentar asignar el icono de la aplicación:\n" + e);
		}
	}

	// Panel oeste.
	private void panelOeste() {
		JPanel panel_login = new JPanel();
		panel_login.setBackground(GUIColor.SECUNDARIO);
		contentPane.add(panel_login);
		panel_login.setLayout(null);

		JPanel panel_login_superior = new JPanel();
		panel_login_superior.setBounds(0, 0, 395, 109);
		panel_login.add(panel_login_superior);
		panel_login_superior.setBackground(null);
		panel_login_superior.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblTitulo = new JLabel("MASTERMIND");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(Fuente.TITULO);
		lblTitulo.setForeground(GUIColor.PRIMARIO);
		panel_login_superior.add(lblTitulo);

		JPanel panel_login_inferior = new JPanel();
		panel_login_inferior.setBounds(0, 500, 395, 70);
		panel_login.add(panel_login_inferior);
		panel_login_inferior.setBackground(null);
		panel_login_inferior.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblAutor = new JLabel("Andreu Garriga © 2024");
		lblAutor.setVerticalAlignment(SwingConstants.TOP);
		lblAutor.setFont(Fuente.TEXTO);
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(GUIColor.NEUTRAL);
		panel_login_inferior.add(lblAutor);

		JPanel panel_login_central = new JPanel();
		panel_login_central.setLayout(null);
		panel_login_central.setBounds(0, 108, 395, 395);
		panel_login_central.setBackground(null);
		panel_login.add(panel_login_central);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(46, 35, 298, 70);
		textFieldUsuario.setFont(Fuente.TEXTO);
		textFieldUsuario.setBorder(bordeConTitulo("Usuario"));
		textFieldUsuario.setBackground(null);
		textFieldUsuario.setOpaque(false);
		textFieldUsuario.setForeground(GUIColor.PRIMARIO);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setCaretColor(GUIColor.NEUTRAL);
		// FocusListener para eliminar el mensaje de error.
		textFieldUsuario.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textAreaMensajes.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				textAreaMensajes.setText("");
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(46, 115, 298, 70);
		passwordField.setFont(Fuente.TEXTO);
		passwordField.setBorder(bordeConTitulo("Clave"));
		passwordField.setBackground(null);
		passwordField.setOpaque(false);
		passwordField.setForeground(GUIColor.PRIMARIO);
		passwordField.setCaretColor(GUIColor.NEUTRAL);
		// FocusListener para eliminar el mensaje de error.
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textAreaMensajes.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				textAreaMensajes.setText("");
			}
		});

		panel_login_central.add(textFieldUsuario);
		panel_login_central.add(passwordField);

		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBounds(48, 245, 140, 40);
		btnIniciarSesion.setFont(Fuente.BOTON);
		btnIniciarSesion.setBackground(GUIColor.DESTACADO);
		btnIniciarSesion.setForeground(GUIColor.SECUNDARIO);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});

		btnRegistrarse = new JButton("Nuevo usuario");
		btnRegistrarse.setBounds(201, 245, 140, 40);
		btnRegistrarse.setFont(Fuente.BOTON);
		//btnRegistrarse.setBackground(GUIColor.PRIMARIO);
		//btnRegistrarse.setForeground(GUIColor.SECUNDARIO);
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();
			}
		});

		// Desactivar el botón Iniciar Sesión si no hay ningún usuario registrado.
		actualizarEstadoBotonIniciarSesion(btnIniciarSesion, btnRegistrarse);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(48, 300, 294, 40);
		btnSalir.setBackground(GUIColor.PRIMARIO);
		btnSalir.setForeground(GUIColor.SECUNDARIO);
		btnSalir.setFont(Fuente.BOTON);
		btnSalir.setBorder(null);
		btnSalir.setFocusPainted(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});

		panel_login_central.add(btnIniciarSesion);
		panel_login_central.add(btnRegistrarse);
		panel_login_central.add(btnSalir);

		textAreaMensajes = new JTextArea();
		textAreaMensajes.setBounds(46, 190, 295, 46);
		textAreaMensajes.setLineWrap(true);
		textAreaMensajes.setWrapStyleWord(true);
		textAreaMensajes.setBorder(new EmptyBorder(0, 5, 0, 5));
		textAreaMensajes.setBackground(null);
		textAreaMensajes.setForeground(GUIColor.NEGATIVO);
		textAreaMensajes.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 12));
		textAreaMensajes.setEditable(false);
		textAreaMensajes.setFocusable(false);
		panel_login_central.add(textAreaMensajes);
	}

	// Panel este.
	private void panelEste() {
		JPanel panel_info = new JPanel();
		panel_info.setBackground(GUIColor.PRIMARIO);
		contentPane.add(panel_info);
		panel_info.setLayout(null);

		JPanel panel_info_central = new JPanel();
		panel_info_central.setBounds(0, 108, 395, 462);
		panel_info_central.setBackground(null);
		panel_info.add(panel_info_central);
		panel_info_central.setLayout(null);

		JPanel panel_info_superior = new JPanel();
		panel_info_superior.setBorder(new EmptyBorder(0, 0, 2, 0));
		panel_info_superior.setBounds(0, 0, 395, 109);
		panel_info_superior.setBackground(null);
		panel_info.add(panel_info_superior);
		panel_info_superior.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNotasVersion = new JLabel("NOTAS DE LA VERSIÓN");
		lblNotasVersion.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_info_superior.add(lblNotasVersion);
		lblNotasVersion.setFont(Fuente.SUBTITULO);
		lblNotasVersion.setForeground(GUIColor.SECUNDARIO);
		lblNotasVersion.setHorizontalAlignment(SwingConstants.CENTER);

		JTextArea txtrNotasVersion = new JTextArea();
		txtrNotasVersion.setLineWrap(true);
		txtrNotasVersion.setWrapStyleWord(true);
		txtrNotasVersion.setEditable(false);
		txtrNotasVersion.setBounds(57, 35, 284, 353);
		txtrNotasVersion.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtrNotasVersion.setBackground(GUIColor.PRIMARIO);
		txtrNotasVersion.setForeground(GUIColor.SECUNDARIO);
		txtrNotasVersion.setFont(Fuente.TEXTO);
		txtrNotasVersion.setText("Versión actual: 1.0b - Lanzamiento\n\n- Interfaz gráfica de usuario\n- Autenticación de usuario\n- Registro de usuario\n- Sistema de guardado de partidas\n- Sistema de ranking global\n- Nuevos efectos de sonido y música");
		panel_info_central.add(txtrNotasVersion);
	}

	// Método para iniciar la sesión.
	private void iniciarSesion() {
		String nombreUsuario = textFieldUsuario.getText();
		String claveUsuario = new String(passwordField.getPassword());

		try {
			Usuario usuarioAutenticado = controladorUsuario.autenticarUsuario(nombreUsuario, claveUsuario);

			if(usuarioAutenticado != null) {			
				setVisible(false);
				dispose();
				new VentanaPortal(usuarioAutenticado, controladorUsuario).setVisible(true);

			} else {
				textAreaMensajes.setForeground(GUIColor.NEGATIVO);
				textAreaMensajes.setText("Usuario o clave incorrectos.");
			}

		} catch (ExcepcionUsuario e) {
			textAreaMensajes.setForeground(GUIColor.NEGATIVO);
			textAreaMensajes.setText(e.getMessage());
		}
	}

	// Método para registrar un nuevo usuario.
	private void registrarUsuario() {
		String nombreUsuario = textFieldUsuario.getText();
		String claveUsuario = new String(passwordField.getPassword());

		try {
			controladorUsuario.registrarUsuario(nombreUsuario, claveUsuario);
			textFieldUsuario.setText("");
			passwordField.setText("");
			textAreaMensajes.setForeground(GUIColor.POSITIVO);
			textAreaMensajes.setText("¡Usuario registrado correctamente!");

		} catch (ExcepcionUsuario e) {
			textAreaMensajes.setForeground(GUIColor.NEGATIVO);
			textAreaMensajes.setText(e.getMessage());

		} finally {
			// Actualizar el estado del botón de iniciar sesión.
			actualizarEstadoBotonIniciarSesion(btnIniciarSesion, btnRegistrarse);
		}
	}

	// Método para activar el botón de iniciar sesión una vez haya usuarios registrados.
	private void actualizarEstadoBotonIniciarSesion(JButton btnIniciarSesion, JButton btnRegistrarse) {
		boolean hayUsuariosRegistrados = controladorUsuario.hayUsuariosRegistrados();
		btnIniciarSesion.setEnabled(hayUsuariosRegistrados);

		if (!hayUsuariosRegistrados) {
			btnIniciarSesion.setBackground(GUIColor.NEUTRAL);
			btnIniciarSesion.setForeground(GUIColor.SECUNDARIO);
			btnRegistrarse.setBackground(GUIColor.DESTACADO);
			btnRegistrarse.setForeground(GUIColor.SECUNDARIO);

		} else {
			btnIniciarSesion.setBackground(GUIColor.DESTACADO);
			btnIniciarSesion.setForeground(GUIColor.SECUNDARIO);
			btnRegistrarse.setBackground(GUIColor.PRIMARIO);
			btnRegistrarse.setForeground(GUIColor.SECUNDARIO);
		}
	}

	// Método para crear un borde personalizado para los inputs.
	private Border bordeConTitulo(String titulo) {
		return new CompoundBorder(
				new TitledBorder(
						new LineBorder(GUIColor.NEUTRAL, 2, false),
						titulo,
						TitledBorder.LEADING,
						TitledBorder.ABOVE_TOP,
						Fuente.TEXTO.deriveFont((float) Fuente.TAM_TEXTO),
						GUIColor.NEUTRAL
						),
				new EmptyBorder(0, 5, 0, 5)
				);
	}
}
