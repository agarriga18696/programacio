package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.ControladorConfiguracion;
import controlador.ControladorPartida;
import controlador.ControladorRanking;
import controlador.ControladorUsuario;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import modelo.Partida;
import modelo.Sonido;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTable;

public class VentanaPortal extends JFrame {

	// Atributos
	private static final long serialVersionUID = 1L;
	private ControladorUsuario controladorUsuario;
	private ControladorPartida controladorPartida;
	private ControladorConfiguracion controladorConfiguracion;
	private ControladorRanking controladorRanking;
	private Usuario usuario;
	private JPanel contentPane;
	private JPanel panel_contenido;
	public int ancho_ventana;
	public int alto_ventana;
	private Tablero tablero;
	private JButton btnTirar;
	private JButton btnTerminar;
	private JButton btnJugar;
	private JButton btnTitulo;
	private JButton btnRanking;
	private JButton btnPerfil;
	private JButton btnOpciones;
	private JButton btnCerrarSesion;
	private JLabel lblIntentos;
	private JLabel lblPuntuacion;
	private JTable tableRanking;
	private JTextField textFieldPartidasGanadas;
	private JTextField textFieldPartidasPerdidas;

	// Constructor.
	public VentanaPortal(Usuario usuario, ControladorUsuario controladorUsuario) {
		this.usuario = usuario;
		this.controladorUsuario = controladorUsuario;
		this.controladorConfiguracion = new ControladorConfiguracion(this);
		this.controladorRanking = new ControladorRanking();
		controladorRanking.cargarRanking();

		ventana();
	}

	// Método para crear la ventana.
	private void ventana() {
		Sonido.reproducirSonido("resources/sound/sounds/UI/Fillup/Generic_Soft/Fillup_Generic_Soft_1.wav");

		// Frame
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);

		// Panel Menú Navegación
		menuNavegacion();

		// Panel contenido principal.
		panelContenedorPrincipal();

		// Panel de bienvenida.
		panelBienvenida();

		// Panel de opciones.
		panelOpciones();

		// Panel del juego.
		panelJuego();

		// Panel del ranking.
		panelRanking();

		// Panel del perfil.
		panelPerfil();

		// Configurar Ventana
		configurarVentana();
	}

	// Getters y setters.
	public JButton getBtnTirar() {
		return btnTirar;
	}

	public int getAncho_ventana() {
		return ancho_ventana;
	}

	public void setAncho_ventana(int ancho_ventana) {
		this.ancho_ventana = ancho_ventana;
	}

	public int getAlto_ventana() {
		return alto_ventana;
	}

	public void setAlto_ventana(int alto_ventana) {
		this.alto_ventana = alto_ventana;
	}

	public JButton getBtnTerminar() {
		return btnTerminar;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public JLabel getLblIntentos() {
		return lblIntentos;
	}

	public JLabel getLblPuntuacion() {
		return lblPuntuacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public ControladorRanking getControladorRanking() {
		return controladorRanking;
	}

	// Método para configurar la venta.a
	private void configurarVentana() {
		this.setTitle("Mastermind - Portal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(getAncho_ventana(), getAlto_ventana()));
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// Asignar el icono de la aplicación.
		try {
			InputStream iconStream = getClass().getResourceAsStream("/icon/icono.png");
			if(iconStream == null) {
				throw new RuntimeException("Icono no encontrado");
			}
			BufferedImage icon = ImageIO.read(iconStream);
			setIconImage(icon);
			//this.setIconImage(ImageIO.read(new File("resources/icon/icono.png")));
		} catch (IOException e) {
			Mensaje.error(this, "Error al intentar asignar el icono de la aplicación:\n" + e);
		} 
	}

	// Método para configurar los botones.
	private void configurarBoton(JButton boton, Color colorFondo, Color colorTexto, int tamFuente, int estiloFuente, Integer ancho, Integer alto) {
		if(ancho != null && alto != null) {
			boton.setPreferredSize(new Dimension(ancho, alto));

		} else if(ancho == null && alto != null) {
			boton.setPreferredSize(new Dimension((int) boton.getPreferredSize().getWidth(), alto));

		} else if(ancho != null && alto == null) {
			boton.setPreferredSize(new Dimension(ancho, 50));
		}

		boton.setBackground(colorFondo);
		boton.setForeground(colorTexto);
		boton.setBorder(null);
		boton.setFont(Fuente.personalizada(Fuente.TITULO.getFontName(), estiloFuente, tamFuente));
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);
		boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// Método para configurar el efecto de hover sobre el botón.
	private void aplicarEfectoHoverBoton(Color colorInicial, Color colorHover, JButton... botones) {
		for(JButton boton : botones) {
			boton.setContentAreaFilled(false);

			boton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					boton.setForeground(colorHover);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					boton.setForeground(colorInicial);
				}
			});
		}
	}

	// Método para configurar el efecto de sonido al hacer click sobre un objeto.
	private void aplicarEfectoSonido(String sonido, Object... objetos) {
		for(Object objeto : objetos) {
			try {
				if (objeto instanceof AbstractButton) {
					((AbstractButton) objeto).addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Sonido.reproducirSonido("resources/sound/sounds/" + sonido + ".wav");
						}
					});
				} else if (objeto instanceof JComboBox) {
					((JComboBox<?>) objeto).addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Sonido.reproducirSonido("resources/sound/sounds/" + sonido + ".wav");
						}
					});
				} else if (objeto instanceof JSlider) {
					((JSlider) objeto).addChangeListener(new ChangeListener() {
						@Override
						public void stateChanged(ChangeEvent e) {
							Sonido.reproducirSonido("resources/sound/sounds/" + sonido + ".wav");
						}
					});
				} else if (objeto instanceof JLabel) {
					((JLabel) objeto).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							Sonido.reproducirSonido("resources/sound/sounds/" + sonido + ".wav");
						}
					});
				} else {
					Method addMouseListener = objeto.getClass().getMethod("addMouseListener", MouseListener.class);
					addMouseListener.invoke(objeto, new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							Sonido.reproducirSonido("resources/sound/sounds/" + sonido + ".wav");
						}
					});
				}
			} catch (Exception e) {
				Mensaje.error(VentanaPortal.this, "Ha ocurrido un error:\n" + e);
			}
		}
	}

	// Menú de navegación.
	private void menuNavegacion() {
		JPanel panel_menuNav = new JPanel();
		panel_menuNav.setPreferredSize(new Dimension(ancho_ventana, 85));
		panel_menuNav.setBackground(GUIColor.SECUNDARIO);
		contentPane.add(panel_menuNav, BorderLayout.NORTH);
		panel_menuNav.setLayout(new GridLayout(1, 3, 0, 0));

		// Panel izquierda
		JPanel panel_menuNav_izquierda = new JPanel(new GridBagLayout());
		panel_menuNav_izquierda.setBorder(new EmptyBorder(0, 20, 0, 0));
		panel_menuNav_izquierda.setBackground(null);
		panel_menuNav.add(panel_menuNav_izquierda);

		btnTerminar = new JButton("");
		configurarBoton(btnTerminar, GUIColor.NEGATIVO, GUIColor.SECUNDARIO, 18, Font.PLAIN, null, 35);
		btnTerminar.setEnabled(false);
		btnTerminar.setVisible(false);
		GridBagConstraints gbc_btnTerminar = new GridBagConstraints();
		gbc_btnTerminar.gridx = 0;
		gbc_btnTerminar.gridy = 0;
		gbc_btnTerminar.weightx = 1.0;
		gbc_btnTerminar.fill = GridBagConstraints.HORIZONTAL;
		panel_menuNav_izquierda.add(btnTerminar, gbc_btnTerminar);

		btnPerfil = new JButton("VER PERFIL");
		configurarBoton(btnPerfil, null, GUIColor.PRIMARIO, 18, Font.PLAIN, null, 35);
		GridBagConstraints gbc_btnPerfil = new GridBagConstraints();
		gbc_btnPerfil.gridx = 0;
		gbc_btnPerfil.gridy = 0;
		gbc_btnPerfil.weightx = 1.0;
		gbc_btnPerfil.fill = GridBagConstraints.HORIZONTAL;
		panel_menuNav_izquierda.add(btnPerfil, gbc_btnPerfil);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón PERFIL.
				setTitle("Mastermind - Perfil de " + usuario.getNombre().toLowerCase());
				CardLayout cl = (CardLayout) panel_contenido.getLayout();
				cl.show(panel_contenido, "panelPerfil");
			}
		});

		btnRanking = new JButton("RANKING");
		configurarBoton(btnRanking, null, GUIColor.PRIMARIO, 18, Font.PLAIN, null, 35);
		GridBagConstraints gbc_btnRanking = new GridBagConstraints();
		gbc_btnRanking.gridx = 1;
		gbc_btnRanking.gridy = 0;
		gbc_btnRanking.weightx = 1.0;
		gbc_btnRanking.fill = GridBagConstraints.HORIZONTAL;
		panel_menuNav_izquierda.add(btnRanking, gbc_btnRanking);
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón RANKING.
				setTitle("Mastermind - Ranking");
				CardLayout cl = (CardLayout) panel_contenido.getLayout();
				cl.show(panel_contenido, "panelRanking");
			}
		});

		// Panel central
		JPanel panel_menuNav_central = new JPanel(new GridBagLayout());
		panel_menuNav_central.setBackground(null);
		panel_menuNav.add(panel_menuNav_central);

		btnTitulo = new JButton("MASTERMIND");
		configurarBoton(btnTitulo, null, GUIColor.PRIMARIO, 46, Font.BOLD, 300, 35);
		btnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_btnTitulo = new GridBagConstraints();
		gbc_btnTitulo.fill = GridBagConstraints.BOTH;
		gbc_btnTitulo.insets = new Insets(10, 0, 10, 0);
		gbc_btnTitulo.gridx = 0;
		gbc_btnTitulo.gridy = 0;
		panel_menuNav_central.add(btnTitulo, gbc_btnTitulo);
		btnTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón MASTERMIND.
				setTitle("Mastermind - Portal");
				CardLayout cl = (CardLayout) panel_contenido.getLayout();
				cl.show(panel_contenido, "panelBienvenida");
			}
		});

		// Panel derecha
		JPanel panel_menuNav_derecha = new JPanel(new GridBagLayout());
		panel_menuNav_derecha.setBorder(new EmptyBorder(0, 0, 0, 20));
		panel_menuNav_derecha.setBackground(null);
		panel_menuNav.add(panel_menuNav_derecha);

		btnOpciones = new JButton("OPCIONES");
		configurarBoton(btnOpciones, null, GUIColor.PRIMARIO, 18, Font.PLAIN, null, 35);
		GridBagConstraints gbc_btnOpciones = new GridBagConstraints();
		gbc_btnOpciones.gridx = 0;
		gbc_btnOpciones.gridy = 0;
		gbc_btnOpciones.weightx = 1.0;
		gbc_btnOpciones.fill = GridBagConstraints.HORIZONTAL;
		panel_menuNav_derecha.add(btnOpciones, gbc_btnOpciones);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón OPCIONES.
				setTitle("Mastermind - Opciones");
				CardLayout cl = (CardLayout) panel_contenido.getLayout();
				cl.show(panel_contenido, "panelOpciones");
			}
		});

		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		configurarBoton(btnCerrarSesion, null, GUIColor.PRIMARIO, 18, Font.PLAIN, null, 35);
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.gridx = 1;
		gbc_btnCerrarSesion.gridy = 0;
		gbc_btnCerrarSesion.weightx = 1.0;
		gbc_btnCerrarSesion.fill = GridBagConstraints.HORIZONTAL;
		panel_menuNav_derecha.add(btnCerrarSesion, gbc_btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = Mensaje.opciones(VentanaPortal.this, "Cerrar sesión", "¿Deseas cerrar la sesión?", JOptionPane.QUESTION_MESSAGE);

				if (opcion == JOptionPane.YES_OPTION) {
					setVisible(false);
					dispose();

					new VentanaLogin(new ControladorUsuario()).setVisible(true);
				}
			}
		});

		// Cambiar aspecto del botón al pasar el ratón por encima.
		aplicarEfectoHoverBoton(GUIColor.PRIMARIO, GUIColor.DESTACADO, btnPerfil, btnRanking, btnTitulo, btnOpciones);
		aplicarEfectoHoverBoton(GUIColor.PRIMARIO, GUIColor.NEGATIVO, btnCerrarSesion);

		// Aplicar efectos de sonido a los botones del menú.
		aplicarEfectoSonido("UI/Click/Generic/GenericClick_2", btnTerminar, btnPerfil, btnRanking, btnTitulo, btnOpciones, btnCerrarSesion);
	}

	// Panel contenedor principal.
	private void panelContenedorPrincipal() {
		panel_contenido = new JPanel();
		panel_contenido.setBackground(GUIColor.PRIMARIO);
		contentPane.add(panel_contenido, BorderLayout.CENTER);
		panel_contenido.setLayout(new CardLayout(0, 0));
	}

	// Panel de bienvenida.
	private void panelBienvenida() {
		JPanel panel_bienvenida = new JPanel();
		panel_bienvenida.setBackground(null);
		panel_contenido.add(panel_bienvenida, "panelBienvenida");
		panel_bienvenida.setLayout(new BorderLayout(0, 0));

		JPanel panel_bienvenida_central = new JPanel();
		panel_bienvenida_central.setBackground(null);
		panel_bienvenida.add(panel_bienvenida_central, BorderLayout.CENTER);
		panel_bienvenida_central.setLayout(new BoxLayout(panel_bienvenida_central, BoxLayout.Y_AXIS));

		// Componente de relleno para centrar verticalmente.
		panel_bienvenida_central.add(Box.createVerticalGlue());

		JLabel lblBienvenida = new JLabel("¡Hola, " + usuario.getNombre() + "!");
		lblBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBienvenida.setForeground(GUIColor.SECUNDARIO);
		lblBienvenida.setFont(Fuente.SUBTITULO);
		panel_bienvenida_central.add(lblBienvenida);

		// Componente de relleno para añadir espacio entre los labels.
		panel_bienvenida_central.add(Box.createVerticalStrut(20));

		JLabel lblMensaje = new JLabel("Para iniciar una nueva partida pulsa el botón de NUEVA PARTIDA");
		lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMensaje.setForeground(GUIColor.SECUNDARIO);
		lblMensaje.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_bienvenida_central.add(lblMensaje);

		// Componente de relleno para añadir espacio entre los labels.
		panel_bienvenida_central.add(Box.createVerticalStrut(50));

		btnJugar = new JButton("NUEVA PARTIDA");
		configurarBoton(btnJugar, GUIColor.POSITIVO, GUIColor.SECUNDARIO, 18, Font.PLAIN, 200, 50);
		btnJugar.setMaximumSize(new Dimension(240, 50));
		btnJugar.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_bienvenida_central.add(btnJugar);

		// Componente de relleno para centrar verticalmente.
		panel_bienvenida_central.add(Box.createVerticalGlue());
	}

	// Panel de opciones.
	private void panelOpciones() {
		JPanel panel_opciones = new JPanel(new GridBagLayout());
		panel_opciones.setBackground(null);
		panel_contenido.add(panel_opciones, "panelOpciones");

		JPanel panel_opciones_contenedor = new JPanel(new GridBagLayout());
		panel_opciones_contenedor.setBackground(null);
		GridBagConstraints gbc_panel_opciones_contenedor = new GridBagConstraints();
		gbc_panel_opciones_contenedor.gridx = 0;
		gbc_panel_opciones_contenedor.gridy = 0;
		gbc_panel_opciones_contenedor.weightx = 1.0;
		gbc_panel_opciones_contenedor.weighty = 1.0;
		gbc_panel_opciones_contenedor.fill = GridBagConstraints.BOTH;
		panel_opciones.add(panel_opciones_contenedor, gbc_panel_opciones_contenedor);

		JPanel panel_opciones_configuracion = new JPanel();
		panel_opciones_configuracion.setBackground(null);
		panel_opciones_configuracion.setLayout(new GridLayout(2, 0, 0, 50));
		panel_opciones_configuracion.setPreferredSize(new Dimension(800, 400));

		GridBagConstraints gbc_panel_opciones_configuracion = new GridBagConstraints();
		gbc_panel_opciones_configuracion.gridx = 0;
		gbc_panel_opciones_configuracion.gridy = 0;
		gbc_panel_opciones_configuracion.insets = new Insets(100, 0, 0, 0);
		panel_opciones_contenedor.add(panel_opciones_configuracion, gbc_panel_opciones_configuracion);

		// Opciones de pantalla.
		JPanel panel_pantalla = new JPanel();
		panel_pantalla.setBackground(null);
		panel_opciones_configuracion.add(panel_pantalla);
		panel_pantalla.setLayout(new GridLayout(4, 1, 0, 5));

		JLabel lblOpcionesPantalla = new JLabel("PANTALLA");
		lblOpcionesPantalla.setVerticalAlignment(SwingConstants.TOP);
		lblOpcionesPantalla.setForeground(GUIColor.DESTACADO);
		lblOpcionesPantalla.setFont(Fuente.SUBTITULO);
		panel_pantalla.add(lblOpcionesPantalla);

		JPanel panel_resolucion = new JPanel();
		panel_resolucion.setBackground(null);
		panel_pantalla.add(panel_resolucion);
		panel_resolucion.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblResolucion = new JLabel("Resolución");
		lblResolucion.setForeground(GUIColor.SECUNDARIO);
		lblResolucion.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_resolucion.add(lblResolucion);

		// Lista de opciones para elegir la resolución de la ventana.
		JComboBox<String> comboBoxResoluciones = new JComboBox<>(controladorConfiguracion.resoluciones);
		comboBoxResoluciones.setBackground(GUIColor.PRIMARIO);
		comboBoxResoluciones.setForeground(GUIColor.SECUNDARIO);
		comboBoxResoluciones.setFocusable(false);
		comboBoxResoluciones.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		comboBoxResoluciones.setSelectedItem(controladorConfiguracion.getResolucionActual());
		if(controladorConfiguracion.getModoVentanaActual().equals(controladorConfiguracion.modosPantalla[1])) {
			comboBoxResoluciones.setEnabled(false);
		} else {
			comboBoxResoluciones.setEnabled(true);
		}
		comboBoxResoluciones.setUI(new CustomComboBoxUI());
		panel_resolucion.add(comboBoxResoluciones);

		JPanel panel_modoPantalla = new JPanel();
		panel_modoPantalla.setBackground(null);
		panel_pantalla.add(panel_modoPantalla);
		panel_modoPantalla.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblModoPantalla = new JLabel("Modo de pantalla");
		lblModoPantalla.setForeground(GUIColor.SECUNDARIO);
		lblModoPantalla.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_modoPantalla.add(lblModoPantalla);

		// Lista de opciones para elegir el modo de ventana.
		JComboBox<String> comboBoxModosPantalla = new JComboBox<>(controladorConfiguracion.modosPantalla);
		comboBoxModosPantalla.setBackground(GUIColor.PRIMARIO);
		comboBoxModosPantalla.setForeground(GUIColor.SECUNDARIO);
		comboBoxModosPantalla.setFocusable(false);
		comboBoxModosPantalla.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		comboBoxModosPantalla.setSelectedItem(controladorConfiguracion.getModoVentanaActual());
		comboBoxModosPantalla.setUI(new CustomComboBoxUI());
		panel_modoPantalla.add(comboBoxModosPantalla);
		// Si se selecciona un modo de pantalla completa debe desactivar el ComboBox de resoluciones.
		comboBoxModosPantalla.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// Verifica si se ha seleccionado un modo de pantalla que implica pantalla completa.
				if (comboBoxModosPantalla.getSelectedIndex() == 1) {
					// Si es así, deshabilita el ComboBox de resolución.
					comboBoxResoluciones.setEnabled(false);
				} else {
					// Si no, habilita el ComboBox de resolución.
					comboBoxResoluciones.setEnabled(true);
				}
			}
		});


		// Opciones de sonido.
		JPanel panel_sonido = new JPanel();
		panel_sonido.setBackground(null);
		panel_opciones_configuracion.add(panel_sonido);
		panel_sonido.setLayout(new GridLayout(4, 1, 0, 5));

		JLabel lblOpcionesSonido = new JLabel("SONIDO");
		lblOpcionesSonido.setVerticalAlignment(SwingConstants.TOP);
		lblOpcionesSonido.setForeground(GUIColor.DESTACADO);
		lblOpcionesSonido.setFont(Fuente.SUBTITULO);
		panel_sonido.add(lblOpcionesSonido);

		JPanel panel_volumenMusica = new JPanel();
		panel_volumenMusica.setBackground(null);
		panel_sonido.add(panel_volumenMusica);
		panel_volumenMusica.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblVolumenMusica = new JLabel("Volumen de la música");
		lblVolumenMusica.setForeground(GUIColor.SECUNDARIO);
		lblVolumenMusica.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_volumenMusica.add(lblVolumenMusica);

		JSlider sliderVolumenMusica = new JSlider();
		sliderVolumenMusica.setPaintTicks(true);
		sliderVolumenMusica.setMajorTickSpacing(5);
		sliderVolumenMusica.setMinorTickSpacing(1);
		sliderVolumenMusica.setSnapToTicks(true);
		sliderVolumenMusica.setMaximum(10);
		sliderVolumenMusica.setValue((int) controladorConfiguracion.getVolumenMusicaActual());
		sliderVolumenMusica.setBackground(GUIColor.PRIMARIO);
		sliderVolumenMusica.setUI(new CustomSliderUI(sliderVolumenMusica));
		panel_volumenMusica.add(sliderVolumenMusica);

		JPanel panel_volumenSonidos = new JPanel();
		panel_volumenSonidos.setBackground(null);
		panel_sonido.add(panel_volumenSonidos);
		panel_volumenSonidos.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblVolumenSonidos = new JLabel("Volumen de los efectos");
		lblVolumenSonidos.setForeground(GUIColor.SECUNDARIO);
		lblVolumenSonidos.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_volumenSonidos.add(lblVolumenSonidos);

		JSlider sliderVolumenSonidos = new JSlider();
		sliderVolumenSonidos.setPaintTicks(true);
		sliderVolumenSonidos.setSnapToTicks(true);
		sliderVolumenSonidos.setMajorTickSpacing(5);
		sliderVolumenSonidos.setMinorTickSpacing(1);
		sliderVolumenSonidos.setMaximum(10);
		sliderVolumenSonidos.setValue((int) controladorConfiguracion.getVolumenEfectosActual());
		sliderVolumenSonidos.setBackground(GUIColor.PRIMARIO);
		sliderVolumenSonidos.setUI(new CustomSliderUI(sliderVolumenSonidos));
		panel_volumenSonidos.add(sliderVolumenSonidos);

		// Panel del botón.
		JPanel panel_opciones_inferior = new JPanel();
		panel_opciones_inferior.setBackground(null);
		GridBagConstraints gbc_panel_opciones_inferior = new GridBagConstraints();
		gbc_panel_opciones_inferior.anchor = GridBagConstraints.NORTH;
		gbc_panel_opciones_inferior.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_opciones_inferior.gridx = 0;
		gbc_panel_opciones_inferior.gridy = 1;
		gbc_panel_opciones_inferior.weighty = 0.3;
		gbc_panel_opciones_inferior.insets = new Insets(20, 0, 0, 0);
		panel_opciones_contenedor.add(panel_opciones_inferior, gbc_panel_opciones_inferior);
		panel_opciones_inferior.setLayout(new BoxLayout(panel_opciones_inferior, BoxLayout.Y_AXIS));

		// Componente de relleno para añadir espacio entre los labels.
		panel_opciones_inferior.add(Box.createVerticalStrut(40));

		JButton btnOpcionesGuardar = new JButton("APLICAR Y GUARDAR");
		btnOpcionesGuardar.setMinimumSize(new Dimension(240, 50));
		btnOpcionesGuardar.setMaximumSize(new Dimension(240, 50));
		btnOpcionesGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
		configurarBoton(btnOpcionesGuardar, GUIColor.DESTACADO, GUIColor.SECUNDARIO, 18, Font.PLAIN, 240, 50);
		panel_opciones_inferior.add(btnOpcionesGuardar);

		// Componente de relleno para añadir espacio entre los labels.
		panel_opciones_inferior.add(Box.createVerticalStrut(40));

		// Crear y configurar el JTextField.
		JTextField textFieldMensajes = new JTextField();
		textFieldMensajes.setHorizontalAlignment(JTextField.CENTER);
		textFieldMensajes.setAlignmentX(Component.CENTER_ALIGNMENT);
		textFieldMensajes.setBorder(new EmptyBorder(0, 5, 0, 5));
		textFieldMensajes.setBackground(null);
		textFieldMensajes.setForeground(GUIColor.POSITIVO);
		textFieldMensajes.setFont(Fuente.TEXTO);
		textFieldMensajes.setEditable(false);
		textFieldMensajes.setFocusable(false);
		panel_opciones_inferior.add(textFieldMensajes);

		btnOpcionesGuardar.addActionListener(e -> {
			// Obtener los valores seleccionados de los componentes JComboBox y JSlider.
			String resolucionSeleccionada = comboBoxResoluciones.isEnabled() ? (String) comboBoxResoluciones.getSelectedItem() : null;
			String modoVentanaSeleccionado = (String) comboBoxModosPantalla.getSelectedItem();
			// Normalizar valores entre 0 y 1 ya que en la clase Sonido el volumen se especifica así.
			float volumenMusicaSeleccionado = sliderVolumenMusica.getValue() / 10.0f;
			float volumenSonidosSeleccionado = sliderVolumenSonidos.getValue() / 10.0f;

			// Aplicar los cambios de la configuración.
			controladorConfiguracion.aplicarCambiosConfiguracion(resolucionSeleccionada, modoVentanaSeleccionado, volumenMusicaSeleccionado, volumenSonidosSeleccionado);

			// Guardar la configuración en el fichero de configuración.
			controladorConfiguracion.guardarConfiguracionFichero();

			// Mostrar mensaje de confirmación.
			new Thread(() -> {
				try {
					textFieldMensajes.setText("Los cambios se han aplicado y guardado correctamente.");
					Thread.sleep(3000);
					textFieldMensajes.setText("");

				} catch (Exception ex) {
					Mensaje.error(VentanaPortal.this, "Ha ocurrido un error:\n" + ex);
				}
			}).start();

		});

		aplicarEfectoSonido("UI/Click/Generic/GenericClick_2", comboBoxResoluciones, comboBoxModosPantalla, sliderVolumenMusica, sliderVolumenSonidos, btnOpcionesGuardar);
	}

	// Panel del ranking.
	private void panelRanking() {
		// Panel principal
		JPanel panel_ranking = new JPanel(new GridBagLayout());
		panel_ranking.setBackground(null);
		panel_contenido.add(panel_ranking, "panelRanking");

		// Panel contenedor
		JPanel panel_ranking_contenedor = new JPanel(new GridBagLayout());
		panel_ranking_contenedor.setBackground(null);
		GridBagConstraints gbc_panel_ranking_contenedor = new GridBagConstraints();
		gbc_panel_ranking_contenedor.gridx = 0;
		gbc_panel_ranking_contenedor.gridy = 0;
		gbc_panel_ranking_contenedor.weightx = 1.0;
		gbc_panel_ranking_contenedor.weighty = 1.0;
		gbc_panel_ranking_contenedor.fill = GridBagConstraints.BOTH;
		panel_ranking.add(panel_ranking_contenedor, gbc_panel_ranking_contenedor);

		// Panel para la tabla
		JPanel panel_ranking_tabla = new JPanel();
		panel_ranking_tabla.setBackground(null);
		panel_ranking_tabla.setLayout(new GridLayout(1, 1, 0, 0));
		panel_ranking_tabla.setPreferredSize(new Dimension(800, 600));
		GridBagConstraints gbc_panel_ranking_tabla = new GridBagConstraints();
		gbc_panel_ranking_tabla.gridx = 0;
		gbc_panel_ranking_tabla.gridy = 0;
		gbc_panel_ranking_contenedor.weightx = 1.0;
		gbc_panel_ranking_contenedor.weighty = 1.0;
		gbc_panel_ranking_tabla.fill = GridBagConstraints.BOTH;
		gbc_panel_ranking_tabla.insets = new Insets(100, 0, 0, 0);
		panel_ranking_contenedor.add(panel_ranking_tabla, gbc_panel_ranking_tabla);

		// Crear y agregar la tabla al panel
		tableRanking = crearTablaRanking();
		JScrollPane scrollPane = new JScrollPane(tableRanking, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(null);
		scrollPane.getViewport().setBackground(null);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getHorizontalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		panel_ranking_tabla.add(scrollPane);

		// Panel inferior de relleno
		JPanel panel_ranking_inferior = new JPanel();
		panel_ranking_inferior.setBackground(null);
		GridBagConstraints gbc_panel_ranking_inferior = new GridBagConstraints();
		gbc_panel_ranking_inferior.anchor = GridBagConstraints.NORTH;
		gbc_panel_ranking_inferior.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_ranking_inferior.gridx = 0;
		gbc_panel_ranking_inferior.gridy = 1;
		gbc_panel_ranking_inferior.weighty = 0.1;
		panel_ranking_contenedor.add(panel_ranking_inferior, gbc_panel_ranking_inferior);
	}


	// Método para crear la tabla del ranking.
	private JTable crearTablaRanking() {
		String[] nombresColumnas = {"POSICIÓN", "JUGADOR", "PUNTUACIÓN"};
		Object[][] datos = obtenerDatosRanking();

		DefaultTableModel modelo = new DefaultTableModel(datos, nombresColumnas);
		JTable table = new JTable(modelo);

		// Aplicar el estilo de la tabla.
		aplicarEstiloTabla(table);

		return table;
	}

	// Método para aplicar el estilo a la tabla.
	private void aplicarEstiloTabla(JTable table) {
		// Personalizar el encabezado de la tabla.
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setDefaultRenderer(new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(GUIColor.PRIMARIO);
				setForeground(GUIColor.DESTACADO);
				setFont(Fuente.SUBTITULO);
				setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, GUIColor.SECUNDARIO), new EmptyBorder(0, 0, 10, 0)));	
				setHorizontalAlignment(SwingConstants.LEFT);
				setVerticalAlignment(SwingConstants.TOP);
				return this;
			}
		});

		// Personalizar el renderizador de las celdas de la tabla.
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBorder(new CompoundBorder(new LineBorder(GUIColor.SECUNDARIO, 1), new EmptyBorder(10, 10, 10, 10)));
				setHorizontalAlignment(SwingConstants.LEFT);
				setVerticalAlignment(SwingConstants.CENTER);

				// Aplicar color de texto a las tres primeras filas.
				// Colores del podio:
				// Fila 0: oro
				// Fila 1: plata
				// Fila 2: bronce
				if (row == 0) {
					setForeground(GUIColor.ORO);
				} else if (row == 1) {
					setForeground(GUIColor.PLATA);
				} else if (row == 2) {
					setForeground(GUIColor.BRONCE);
				} else {
					setForeground(table.getForeground());
				}

				return this;
			}
		};

		// Aplicar el renderizador personalizado a todas las celdas.
		TableColumnModel columnModel = table.getColumnModel();

		// Definir la anchura de cada columna.
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(150);

		// Aplicar el formato de las celdas.
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(cellRenderer);
		}

		table.setBackground(GUIColor.PRIMARIO);
		table.setForeground(GUIColor.SECUNDARIO);
		table.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		table.setRowHeight(50);
		table.setEnabled(false);
		table.setFocusable(false);
		table.setBorder(null);
		table.setShowGrid(true);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setRowHeight(60);
		table.setIntercellSpacing(new Dimension(new Dimension(0, 20)));

		// Desactivar el redimensionamiento de las columnas
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}

		// Redibujar la tabla.
		table.repaint();
	}

	// Método para obtener los datos del ranking.
	private Object[][] obtenerDatosRanking() {
		return controladorRanking.obtenerDatosRanking();
	}

	// Método para actualizar la tabla del ranking.
	public void actualizarRanking(Partida partida) {
		controladorRanking.agregarPartida(partida);
		Object[][] nuevosDatos = obtenerDatosRanking();
		DefaultTableModel modelo = (DefaultTableModel) tableRanking.getModel();
		modelo.setDataVector(nuevosDatos, new String[]{"POSICIÓN", "JUGADOR", "PUNTUACIÓN"});

		// Aplicar el estilo de la tabla.
		aplicarEstiloTabla(tableRanking);
	}

	// Panel del perfil.
	private void panelPerfil() {
		JPanel panel_perfil = new JPanel(new GridBagLayout());
		panel_perfil.setBackground(null);
		panel_contenido.add(panel_perfil, "panelPerfil");

		JPanel panel_perfil_contenedor = new JPanel(new GridBagLayout());
		panel_perfil_contenedor.setBackground(null);
		GridBagConstraints gbc_panel_perfil_contenedor = new GridBagConstraints();
		gbc_panel_perfil_contenedor.gridx = 0;
		gbc_panel_perfil_contenedor.gridy = 0;
		gbc_panel_perfil_contenedor.weightx = 1.0;
		gbc_panel_perfil_contenedor.weighty = 1.0;
		gbc_panel_perfil_contenedor.fill = GridBagConstraints.BOTH;
		panel_perfil.add(panel_perfil_contenedor, gbc_panel_perfil_contenedor);

		JPanel panel_perfil_informacion = new JPanel();
		panel_perfil_informacion.setBackground(null);
		panel_perfil_informacion.setLayout(new GridLayout(2, 0, 0, 50));
		panel_perfil_informacion.setPreferredSize(new Dimension(800, 400));

		GridBagConstraints gbc_panel_perfil_informacion = new GridBagConstraints();
		gbc_panel_perfil_informacion.gridx = 0;
		gbc_panel_perfil_informacion.gridy = 0;
		gbc_panel_perfil_informacion.insets = new Insets(100, 0, 0, 0);
		panel_perfil_contenedor.add(panel_perfil_informacion, gbc_panel_perfil_informacion);

		// Información del usuario.
		JPanel panel_usuario = new JPanel();
		panel_usuario.setBackground(null);
		panel_perfil_informacion.add(panel_usuario);
		panel_usuario.setLayout(new GridLayout(4, 1, 0, 5));

		JLabel lblInfoUsuario = new JLabel("USUARIO");
		lblInfoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblInfoUsuario.setForeground(GUIColor.DESTACADO);
		lblInfoUsuario.setFont(Fuente.SUBTITULO);
		panel_usuario.add(lblInfoUsuario);

		JPanel panel_usuario_nombre = new JPanel();
		panel_usuario_nombre.setBackground(null);
		panel_usuario.add(panel_usuario_nombre);
		panel_usuario_nombre.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblUsuarioNombre = new JLabel("Nombre de usuario");
		lblUsuarioNombre.setForeground(GUIColor.SECUNDARIO);
		lblUsuarioNombre.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_usuario_nombre.add(lblUsuarioNombre);

		JTextField textFieldUsuarioNombre = crearTextField(usuario.getNombre());
		panel_usuario_nombre.add(textFieldUsuarioNombre);

		JPanel panel_usuario_id = new JPanel();
		panel_usuario_id.setBackground(null);
		panel_usuario.add(panel_usuario_id);
		panel_usuario_id.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblUsuarioId = new JLabel("ID de usuario");
		lblUsuarioId.setForeground(GUIColor.SECUNDARIO);
		lblUsuarioId.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_usuario_id.add(lblUsuarioId);

		JTextField textFieldUsuarioId = crearTextField(usuario.getId().toString());
		panel_usuario_id.add(textFieldUsuarioId);

		// Panel de estadísticas de las partidas.
		JPanel panel_partidas = new JPanel();
		panel_partidas.setBackground(null);
		panel_perfil_informacion.add(panel_partidas);
		panel_partidas.setLayout(new GridLayout(4, 1, 0, 5));

		JLabel lblOpcionesSonido = new JLabel("ESTADÍSTICAS");
		lblOpcionesSonido.setVerticalAlignment(SwingConstants.TOP);
		lblOpcionesSonido.setForeground(GUIColor.DESTACADO);
		lblOpcionesSonido.setFont(Fuente.SUBTITULO);
		panel_partidas.add(lblOpcionesSonido);

		JPanel panel_partidasGanadas = new JPanel();
		panel_partidasGanadas.setBackground(null);
		panel_partidas.add(panel_partidasGanadas);
		panel_partidasGanadas.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPartidasGanadas = new JLabel("Partidas ganadas");
		lblPartidasGanadas.setForeground(GUIColor.SECUNDARIO);
		lblPartidasGanadas.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_partidasGanadas.add(lblPartidasGanadas);

		// Recuento de partidas ganadas.
		textFieldPartidasGanadas = crearTextField(Integer.toString(usuario.getPartidasGanadas()));
		panel_partidasGanadas.add(textFieldPartidasGanadas);

		JPanel panel_partidasPerdidas = new JPanel();
		panel_partidasPerdidas.setBackground(null);
		panel_partidas.add(panel_partidasPerdidas);
		panel_partidasPerdidas.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPartidasPerdidas = new JLabel("Partidas perdidas");
		lblPartidasPerdidas.setForeground(GUIColor.SECUNDARIO);
		lblPartidasPerdidas.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		panel_partidasPerdidas.add(lblPartidasPerdidas);

		// Recuento de partidas perdidas.
		textFieldPartidasPerdidas = crearTextField(Integer.toString(usuario.getPartidasPerdidas()));
		panel_partidasPerdidas.add(textFieldPartidasPerdidas);

		// Panel del botón.
		JPanel panel_perfil_inferior = new JPanel();
		panel_perfil_inferior.setBackground(null);
		GridBagConstraints gbc_panel_perfil_inferior = new GridBagConstraints();
		gbc_panel_perfil_inferior.anchor = GridBagConstraints.NORTH;
		gbc_panel_perfil_inferior.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_perfil_inferior.gridx = 0;
		gbc_panel_perfil_inferior.gridy = 1;
		gbc_panel_perfil_inferior.weighty = 0.3;
		gbc_panel_perfil_inferior.insets = new Insets(20, 0, 0, 0);
		panel_perfil_contenedor.add(panel_perfil_inferior, gbc_panel_perfil_inferior);
		panel_perfil_inferior.setLayout(new BoxLayout(panel_perfil_inferior, BoxLayout.Y_AXIS));

		// Componente de relleno para añadir espacio.
		panel_perfil_inferior.add(Box.createVerticalStrut(40));

		JButton btnEliminarUsuario = new JButton("ELIMINAR CUENTA");
		btnEliminarUsuario.setMinimumSize(new Dimension(240, 50));
		btnEliminarUsuario.setMaximumSize(new Dimension(240, 50));
		btnEliminarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		configurarBoton(btnEliminarUsuario, GUIColor.NEGATIVO, GUIColor.SECUNDARIO, 18, Font.PLAIN, 240, 50);
		panel_perfil_inferior.add(btnEliminarUsuario);

		// Componente de relleno para añadir espacio.
		panel_perfil_inferior.add(Box.createVerticalStrut(40));

		btnEliminarUsuario.addActionListener(e -> {
			// Eliminar el usuario.
			int opcionSeleccionada = Mensaje.opciones(VentanaPortal.this, "Eliminar cuenta", "¿Quieres eliminar tu cuenta? Esto no se puede deshacer.", JOptionPane.QUESTION_MESSAGE);

			if(opcionSeleccionada == JOptionPane.YES_OPTION) {
				controladorUsuario.eliminarUsuario(usuario);

				// Mostrar mensaje de confirmación.
				Mensaje.personalizado(VentanaPortal.this, "Cuenta eliminada", "La cuenta ha sido eliminada con éxito.");

				// Cerrar esta ventana y abrir el Login.
				setVisible(false);
				dispose();
				new VentanaLogin(new ControladorUsuario()).setVisible(true);
			}
		});
	}

	// Método para configuar el JTextField.
	private JTextField crearTextField(String texto) {
		JTextField textField = new JTextField(texto);
		textField.setBackground(null);
		textField.setForeground(GUIColor.SECUNDARIO);
		textField.setBorder(new CompoundBorder(new LineBorder(GUIColor.SECUNDARIO, 1), new EmptyBorder(0, 5, 0, 5)));
		textField.setFont(Fuente.personalizada(Fuente.TEXTO.getFontName(), Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setFocusable(false);

		return textField;
	}

	// Método para actualizar las estadísticas del perfil.
	public void actualizarEstadisticasPerfil() {
		int partidasGanadas = usuario.getPartidasGanadas();
		int partidasPerdidas = usuario.getPartidasPerdidas();

		// Actualizar los textField.
		textFieldPartidasGanadas.setText(String.valueOf(partidasGanadas));
		textFieldPartidasPerdidas.setText(String.valueOf(partidasPerdidas));
	}

	// Panel del juego.
	private void panelJuego() {
		JPanel panel_juego = new JPanel(new BorderLayout());
		panel_juego.setBackground(null);
		panel_contenido.add(panel_juego, "panelTablero");

		// Panel contenedor del juego.
		JPanel panel_juego_contenedor = new JPanel();
		panel_juego_contenedor.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel_juego_contenedor.setBackground(null);
		panel_juego.add(panel_juego_contenedor, BorderLayout.CENTER);
		panel_juego_contenedor.setLayout(new GridLayout(1, 1, 0, 0));
		// El tablero irá en la columna del medio.
		// col 1: -> agregar el panel izquierdo de puntuación.
		// col 2: -> agregar el tablero.
		// col 3: -> agregar un panel derecho vacío.

		// Panel inferior
		JPanel panel_juego_inferior = new JPanel();
		panel_juego_inferior.setBorder(null);
		panel_juego_inferior.setBackground(null);
		panel_juego.add(panel_juego_inferior, BorderLayout.SOUTH);
		panel_juego_inferior.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

		// Acción botón Comprobar Tirada.
		btnTirar = new JButton("COMPROBAR TIRADA");
		configurarBoton(btnTirar, GUIColor.DESTACADO, GUIColor.SECUNDARIO, 18, Font.PLAIN, 240, 50);
		panel_juego_inferior.add(btnTirar);

		btnTirar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controladorPartida.esCombinacionValida()) {
					Sonido.reproducirSonido("resources/sound/sounds/tirada.wav");

					controladorPartida.nuevaTirada();

				} else {
					Mensaje.personalizado(VentanaPortal.this, "Combinación no válida", "Por favor, introduce una combinación válida.");
				}
			}
		});

		// Acción botón Jugar.
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Mastermind - Partida");
				CardLayout cl = (CardLayout) panel_contenido.getLayout();
				cl.show(panel_contenido, "panelTablero");

				// Actualizar el estado de los botones.
				actualizarBotones(false);

				Sonido.reproducirSonido("resources/sound/sounds/inicio_partida.wav");

				// Reproducir música.
				new Thread(() -> {
					try {
						// Esperar unos milisegundos antes de empezar la canción para que no se solape
						// con el efecto de sonido cuando se inicia el tablero. 
						Thread.sleep(500);
						Sonido.reproducirMusicaAleatoria();
					} catch (Exception ex) {
						Mensaje.error(VentanaPortal.this, "Ha ocurrido un error:\n" + e);
					}
				}).start();

				btnTerminar.setBackground(GUIColor.NEGATIVO);
				btnTerminar.setText("TERMINAR SIN GUARDAR");
				btnTirar.setBackground(GUIColor.DESTACADO);

				// Crear tablero e iniciar una nueva partida.
				crearContenedorJuego(panel_juego_contenedor);
				controladorPartida = new ControladorPartida(VentanaPortal.this);
				Mensaje.personalizado(VentanaPortal.this, "Nueva partida", "¡Nueva partida iniciada!");

				controladorPartida.nuevaPartida();
			}
		});

		// Acción botón Terminar.
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controladorPartida.isPartidaFinalizada()) {
					finalizarPartida();

				} else {
					int opcion = Mensaje.opciones(
							VentanaPortal.this,
							"Abandonar partida",
							"La partida está sin terminar. Se perderá el progreso no guardado hasta ahora, ¿quieres continuar?",
							JOptionPane.WARNING_MESSAGE
							);

					if (opcion == JOptionPane.YES_OPTION) {
						abandonarPartida();
					}
				}
			}
		});
	}

	// Método para crear el contenedor del juego.
	private void crearContenedorJuego(JPanel panel_juego_tablero) {
		JPanel panel_contenedor = new JPanel(new GridLayout(1, 3));
		panel_contenedor.setBackground(null);

		// Eliminar el tablero anterior si existe.
		if(tablero != null) {
			panel_juego_tablero.remove(tablero);
		}

		// Crear un nuevo tablero.
		tablero = new Tablero();

		// Panel izquierdo.
		JPanel panel_izquierda = new JPanel();
		panel_izquierda.setBackground(null);
		panel_izquierda.setBorder(new EmptyBorder(20, 0, 0, 50));
		panel_izquierda.setLayout(new BoxLayout(panel_izquierda, BoxLayout.Y_AXIS)); 

		lblIntentos = new JLabel("Intentos:   0");
		lblIntentos.setForeground(GUIColor.SECUNDARIO);
		lblIntentos.setFont(Fuente.personalizada(Fuente.TITULO.getFontName(), Font.PLAIN, 24));
		lblIntentos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_izquierda.add(lblIntentos);

		panel_izquierda.add(Box.createVerticalStrut(30));

		lblPuntuacion = new JLabel("Puntos:   0");
		lblPuntuacion.setForeground(GUIColor.SECUNDARIO);
		lblPuntuacion.setFont(Fuente.personalizada(Fuente.TITULO.getFontName(), Font.PLAIN, 24));
		lblPuntuacion.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_izquierda.add(lblPuntuacion);

		// Panel central con el tablero.
		JPanel panel_central = new JPanel(new GridLayout(1, 1, 0, 0));
		panel_central.setBackground(null);
		panel_central.add(tablero);
		// Activar los botones de las fichas del jugador.
		tablero.fichasJugadorActivadas(true);

		// Panel derecho.
		JPanel panel_derecha = new JPanel();
		panel_derecha.setBackground(null);

		// Agregar los tres paneles al panel contenedor.
		panel_contenedor.add(panel_izquierda);
		panel_contenedor.add(panel_central);
		panel_contenedor.add(panel_derecha);

		// Agregar el panel contenedor al panel_juego_tablero.
		panel_juego_tablero.removeAll(); // Eliminar todos los componentes existentes.
		panel_juego_tablero.add(panel_contenedor); // Agregar el nuevo panel contenedor.

		// Actualizar la interfaz.
		revalidate();
		repaint();
	}

	private void finalizarPartida() {
		controladorPartida.guardarPartidaFichero();
		mostrarPanelBienvenida();
		actualizarBotones(true);

		Sonido.pararMusica();
		Sonido.reproducirSonido("resources/sound/sounds/UI/Click/Generic/GenericClick_2.wav");
	}

	private void abandonarPartida() {
		mostrarPanelBienvenida();
		actualizarBotones(true);

		Sonido.pararMusica();
		Sonido.reproducirSonido("resources/sound/sounds/UI/Click/Negative/Negative_Click_1.wav");
	}

	private void mostrarPanelBienvenida() {
		CardLayout cl = (CardLayout) panel_contenido.getLayout();
		cl.show(panel_contenido, "panelBienvenida");
		setTitle("Mastermind - Portal");
	}

	// Estado de los botones del menú de navegación y de las fichas del jugador.
	private void actualizarBotones(boolean partidaTerminada) {
		btnJugar.setEnabled(partidaTerminada);
		btnJugar.setVisible(partidaTerminada);
		btnTitulo.setEnabled(partidaTerminada);
		btnRanking.setEnabled(partidaTerminada);
		btnPerfil.setEnabled(partidaTerminada);
		btnOpciones.setEnabled(partidaTerminada);
		btnCerrarSesion.setEnabled(partidaTerminada);
		btnTerminar.setEnabled(!partidaTerminada);
		btnTerminar.setVisible(!partidaTerminada);
	}

}