package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.plaf.basic.BasicArrowButton;

public class CustomArrowButton extends BasicArrowButton {

	// Clase para crear un botón con flecha personalizada para las listas desplegables, etc.
	
	private static final long serialVersionUID = 1L;
	private int arrowSize = 8;

    public CustomArrowButton(int direction) {
        super(direction);
    }

    @Override
    public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRect(x, y, size, size);
        g2.dispose();

        super.paintTriangle(g, x, y, arrowSize, direction, isEnabled);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(arrowSize, arrowSize);
    }

    public void setArrowSize(int size) {
        arrowSize = size;
        repaint();
    }
}

