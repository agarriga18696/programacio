package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Colores;
import modelo.Partida;
import modelo.Sonido;

import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Tablero extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] colores = Colores.LISTA_COLORES.toArray(new String[0]);
	private JButton[][] fichasIntentoJugador = new JButton[Partida.NUM_INTENTOS][Partida.NUM_FICHAS];
	private JButton[][] fichasResultadoJugador = new JButton[Partida.NUM_INTENTOS][Partida.NUM_FICHAS];
	private List<JButton> fichasCombinacionSecreta = new ArrayList<>();
	private List<JButton> fichasCombinacionJugador = new ArrayList<>();
	private String[] combinacionIntentada = new String[Partida.NUM_FICHAS];

	// Atributos.
	private JPanel panel_central_tiradas;
	private JPanel panel_central_resultados;
	private JPanel panel_combSecreta_fichas;
	private JPanel panel_combJugador_fichas;

	private int[] tamFichas = new int[] {40, 30, 13};

	// Constructor.
	public Tablero() {
		configurarTablero();
	}

	// Getters y setters.
	public JButton[][] getFichasIntentoJugador() {
		return fichasIntentoJugador;
	}

	public void setFichasIntentoJugador(JButton[][] fichasIntentoJugador) {
		this.fichasIntentoJugador = fichasIntentoJugador;
	}

	public JButton[][] getFichasResultadoJugador() {
		return fichasResultadoJugador;
	}

	public void setFichasResultadoJugador(JButton[][] fichasResultadoJugador) {
		this.fichasResultadoJugador = fichasResultadoJugador;
	}

	public List<JButton> getFichasCombinacionSecreta() {
		return fichasCombinacionSecreta;
	}

	public void setFichasCombinacionSecreta(List<JButton> fichasCombinacionSecreta) {
		this.fichasCombinacionSecreta = fichasCombinacionSecreta;
	}

	public List<JButton> getFichasCombinacionJugador() {
		return fichasCombinacionJugador;
	}

	public String[] getCombinacionIntentada() {
		return combinacionIntentada;
	}

	// Método para configurar el tablero.
	private void configurarTablero() {
		setBorder(new LineBorder(GUIColor.TABLERO_BORDE, 10, true));
		setBackground(GUIColor.TABLERO_FONDO);
		setLayout(new BorderLayout());

		// Panel superior para la combinación secreta
		JPanel panel_combSecreta = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_combSecreta.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_combSecreta.setBackground(null);
		add(panel_combSecreta, BorderLayout.NORTH);

		// Aqui se mostrarán las fichas de color de la combinación secreta.
		panel_combSecreta_fichas = new JPanel();
		panel_combSecreta_fichas.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel_combSecreta_fichas.setBackground(null);
		panel_combSecreta.add(panel_combSecreta_fichas);
		panel_combSecreta.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, (Color) GUIColor.TABLERO_BORDE), new EmptyBorder(20, 0, 0, 0)));
		panel_combSecreta_fichas.setLayout(new GridLayout(0, Partida.NUM_FICHAS, 20, 0));

		// Crear los botones para las fichas de colores de la combinación secreta.
		crearBotonesCombinacionSecreta();

		// Panel central dividido en dos partes: tiradas del jugador y resultados
		JPanel panel_central = new JPanel(new GridBagLayout());
		panel_central.setBackground(null);
		add(panel_central, BorderLayout.CENTER);

		// Panel para mostrar los resultados de las tiradas.
		panel_central_resultados = new JPanel(new GridLayout(Partida.NUM_INTENTOS, 1, 0, 0));

		panel_central_resultados.setBackground(null);
		GridBagConstraints gbc_resultados = new GridBagConstraints();
		gbc_resultados.gridx = 0;
		gbc_resultados.gridy = 0;
		gbc_resultados.weightx = 0.2;
		gbc_resultados.weighty = 1.0;
		gbc_resultados.fill = GridBagConstraints.BOTH;
		panel_central.add(panel_central_resultados, gbc_resultados);

		// Añadir las filas de resultados.
		crearFilasResultados();

		// Panel para las tiradas del jugador.
		panel_central_tiradas = new JPanel(new GridLayout(Partida.NUM_INTENTOS, 1, 0, 0));
		panel_central_tiradas.setBackground(null);
		GridBagConstraints gbc_tiradas = new GridBagConstraints();
		gbc_tiradas.gridx = 1;
		gbc_tiradas.gridy = 0;
		gbc_tiradas.weightx = 0.8;
		gbc_tiradas.weighty = 1.0;
		gbc_tiradas.fill = GridBagConstraints.BOTH;
		panel_central.add(panel_central_tiradas, gbc_tiradas);

		// Añadir las filas de intentos.
		crearFilasIntentos();

		// Panel inferior para que el jugador introduzca su combinación
		JPanel panel_combJugador = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_combJugador.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panel_combJugador.setBackground(null);
		add(panel_combJugador, BorderLayout.SOUTH);

		// Aqui se mostrarán las fichas de color del jugador.
		panel_combJugador_fichas = new JPanel();
		panel_combJugador_fichas.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel_combJugador_fichas.setBackground(null);
		panel_combJugador.add(panel_combJugador_fichas);
		panel_combJugador.setBorder(new CompoundBorder(new MatteBorder(2, 0, 0, 0, (Color) GUIColor.TABLERO_BORDE), new EmptyBorder(0, 0, 20, 0)));
		panel_combJugador_fichas.setLayout(new GridLayout(0, Partida.NUM_FICHAS, 20, 0));

		// Crear los botones para las fichas de colores del Jugador.
		crearBotonesJugador();
	}

	// Método para activar o desactivar los botones de las fichas del jugador.
	public void fichasJugadorActivadas(boolean estado) {
		for(JButton ficha : getFichasCombinacionJugador()) {
			ficha.setEnabled(estado);
		}
	}

	// Método para crear las fichas de colores.
	private RoundButton configurarFicha(String texto, int tamFicha) {
		RoundButton ficha = new RoundButton(texto);
		ficha.setPreferredSize(new Dimension(tamFicha, tamFicha));
		ficha.setMinimumSize(new Dimension(tamFicha, tamFicha));
		ficha.setMaximumSize(new Dimension(tamFicha, tamFicha));
		ficha.setBorderPainted(false);
		ficha.setFocusPainted(false);
		ficha.setBorder(null);
		ficha.setBackground(GUIColor.FICHA_NEUTRAL);
		ficha.setLabelColor(GUIColor.SECUNDARIO);
		ficha.setFont(Fuente.personalizada(Fuente.BOTON.getFontName(), Font.BOLD, 22));
		ficha.setCursor(new Cursor(Cursor.HAND_CURSOR));

		return ficha;
	}

	// Método para obtener el Color correspondiente al nombre del color
	private Color obtenerColorPorNombre(String nombreColor) {
		switch(nombreColor.toLowerCase()) {
		case "rojo":
			return GUIColor.FICHA_ROJO;
		case "azul":
			return GUIColor.FICHA_AZUL;
		case "verde":
			return GUIColor.FICHA_VERDE;
		case "magenta":
			return GUIColor.FICHA_MAGENTA;
		case "amarillo":
			return GUIColor.FICHA_AMARILLO;
		case "cian":
			return GUIColor.FICHA_CIAN;
		case "blanco":
			return GUIColor.FICHA_BLANCO;
		case "negro":
			return GUIColor.FICHA_NEGRO;
		default:
			return GUIColor.FICHA_NEUTRAL;
		}
	}

	// Método para crear las filas con las fichas de intentos.
	private void crearFilasIntentos() {
		for(int i = 0; i < Partida.NUM_INTENTOS; i++) {
			JPanel fila = new JPanel(new GridBagLayout());
			fila.setBackground(null);

			for(int j = 0; j < Partida.NUM_FICHAS; j++) {
				RoundButton btnFicha = configurarFicha("", tamFichas[1]);
				btnFicha.setEnabled(false);

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = j;
				gbc.gridy = i;
				gbc.weightx = 1.0;
				gbc.weighty = 1.0;
				gbc.fill = GridBagConstraints.NONE;
				gbc.anchor = GridBagConstraints.CENTER;
				fila.add(btnFicha, gbc);

				// Almacenar los botones en el array.
				fichasIntentoJugador[i][j] = btnFicha;
			}

			panel_central_tiradas.add(fila);
		}
	}

	// Método para crear las fichas de la combinación secreta.
	private void crearBotonesCombinacionSecreta() {
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			RoundButton btnFicha = configurarFicha("?", tamFichas[0]);
			btnFicha.setEnabled(false);
			panel_combSecreta_fichas.add(btnFicha);
			fichasCombinacionSecreta.add(btnFicha);
		}
	}

	// Método para crear los botones de las fichas del jugador.
	private void crearBotonesJugador() {
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			RoundButton btnFicha = configurarFicha("", tamFichas[0]);
			btnFicha.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Crear y mostrar un JComboBox con la lista de colores
					JComboBox<String> comboBox = new JComboBox<>(colores);
					String[] opciones = {"Hecho", "Cancelar"};

					int opcionSeleccionada = JOptionPane.showOptionDialog(Tablero.this, comboBox, "Selecciona un color",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					// Obtener el color seleccionado del JComboBox y actualizar el botón de la ficha
					if(opcionSeleccionada == JOptionPane.OK_OPTION) {
						String colorSeleccionado = (String) comboBox.getSelectedItem();
						btnFicha.setBackground(obtenerColorPorNombre(colorSeleccionado));

						int indiceBoton = fichasCombinacionJugador.indexOf(btnFicha);    
						combinacionIntentada[indiceBoton] = colorSeleccionado;

						Sonido.reproducirSonidoFichaAleatorio();
					}
				}
			});

			fichasCombinacionJugador.add(btnFicha);
			panel_combJugador_fichas.add(btnFicha);
		}
	}

	// Método para crear las filas con las fichas de resultado.
	private void crearFilasResultados() {
		for(int i = 0; i < Partida.NUM_INTENTOS; i++) {
			JPanel fila = new JPanel(new GridBagLayout());
			fila.setBackground(null);

			// Crear el contenedor con 2 filas.
			JPanel contenedorFilas = new JPanel(new GridLayout(2, 1, 0, 3)); // 2 filas, 1 columna, espacio vertical de 3 entre filas.
			contenedorFilas.setBackground(null);

			// Agregar las fichas a las 2 filas del contenedor.
			for(int j = 0; j < 2; j++) {
				JPanel panelFila = new JPanel(new GridLayout(1, 2, 3, 0)); // 1 fila, 2 columnas, espacio horizontal de 3 entre columnas.
				panelFila.setBackground(null);

				// Agregar dos fichas a cada fila.
				for(int k = 0; k < 2; k++) {
					RoundButton btnFicha = configurarFicha("", tamFichas[2]);
					btnFicha.setEnabled(false);
					panelFila.add(btnFicha);
					// Almacenar los botones en el array.
					fichasResultadoJugador[i][j * 2 + k] = btnFicha;
				}

				// Agregar la fila al contenedor.
				contenedorFilas.add(panelFila);
			}

			// Agregar el contenedor al panel principal.
			GridBagConstraints gbcContenedor = new GridBagConstraints();
			gbcContenedor.gridx = 0;
			gbcContenedor.gridy = 0;
			gbcContenedor.weightx = 1.0;
			gbcContenedor.weighty = 1.0;
			gbcContenedor.fill = GridBagConstraints.NONE;
			gbcContenedor.anchor = GridBagConstraints.CENTER;
			fila.add(contenedorFilas, gbcContenedor);

			panel_central_resultados.add(fila);
		}
	}

	// Método para mostrar la combinación secreta.
	public void mostrarCombinacionSecreta() {
		for(int i = 0; i < Partida.NUM_FICHAS; i++) {
			JButton ficha = fichasCombinacionSecreta.get(i);
			ficha.setText("");
			switch (Partida.combinacionColoresSecreta[i]) {
			case 0:
				ficha.setBackground(GUIColor.FICHA_ROJO);
				break;
			case 1:
				ficha.setBackground(GUIColor.FICHA_AZUL);
				break;
			case 2:
				ficha.setBackground(GUIColor.FICHA_VERDE);
				break;
			case 3:
				ficha.setBackground(GUIColor.FICHA_MAGENTA);
				break;
			case 4:
				ficha.setBackground(GUIColor.FICHA_AMARILLO);
				break;
			case 5:
				ficha.setBackground(GUIColor.FICHA_CIAN);
				break;
			case 6:
				ficha.setBackground(GUIColor.FICHA_BLANCO);
				break;
			case 7:
				ficha.setBackground(GUIColor.FICHA_NEGRO);
				break;
			default:
				ficha.setBackground(GUIColor.FICHA_NEUTRAL);
				Mensaje.error(null, "Color no encontrado");
				break;
			}
		}
	}
}
