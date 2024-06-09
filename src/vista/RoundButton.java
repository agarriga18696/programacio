package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundButton extends JButton {
	
	// Clase para crear un botón redondo personalizado.
	// Lo uso para crear las fichas del juego que son redondas.
	
	// Atributos.
	private static final long serialVersionUID = 1L;
	private Color labelColor;

	// Constructor.
	public RoundButton(String label) {
		super(label);

		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		setContentAreaFilled(false);
		setFocusPainted(false);
		labelColor = getForeground();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Dibuja el fondo
		if (getModel().isArmed()) {
			g2.setColor(Color.lightGray);
		} else {
			g2.setColor(getBackground());
		}
		g2.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		// Dibuja el texto
		g2.setColor(labelColor);
		FontMetrics fm = g2.getFontMetrics();
		Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());
		Rectangle textRect = fm.getStringBounds(getText(), g2).getBounds();
		int textX = (rect.width - textRect.width) / 2;
		int textY = (rect.height - textRect.height) / 2 + fm.getAscent();
		g2.drawString(getText(), textX, textY);

		g2.dispose();
	}

	@Override
	protected void paintBorder(Graphics g) {
		// No dibujar el borde.
	}

	Shape shape;

	@Override
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

	public void setLabelColor(Color color) {
		this.labelColor = color;
		repaint();
	}
}