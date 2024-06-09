package vista;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import java.awt.*;

public class CustomComboBoxUI extends BasicComboBoxUI {
	
	// Clase para personalizar la apariencia del JComboBox.

	@Override
	protected void installDefaults() {
		super.installDefaults();
		comboBox.setBorder(new CompoundBorder(new LineBorder(GUIColor.SECUNDARIO, 1), new EmptyBorder(0, 5, 0, 0)));
	}

	@Override
	protected JButton createArrowButton() {
		BasicArrowButton arrowButton = new BasicArrowButton(SwingConstants.SOUTH, null, null, GUIColor.SECUNDARIO, null);
		//arrowButton.setArrowSize(10);
		arrowButton.setBorder(BorderFactory.createEmptyBorder());
		arrowButton.setOpaque(true);
		arrowButton.setContentAreaFilled(false);

		return arrowButton;
	}

	@Override
	public void configureArrowButton() {
		super.configureArrowButton();
		arrowButton.setBorder(BorderFactory.createEmptyBorder());
	}

	@Override
	protected ListCellRenderer<Object> createRenderer() {
		return new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if(isSelected) {
					c.setBackground(GUIColor.SECUNDARIO);
					c.setForeground(GUIColor.PRIMARIO);

				} else {
					c.setBackground(GUIColor.PRIMARIO);
					c.setForeground(GUIColor.SECUNDARIO);
				}

				return c;
			}
		};
	}

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {

	}
	
	@Override
	protected ComboPopup createPopup() {
	    BasicComboPopup popup = (BasicComboPopup) super.createPopup();
	    popup.setBackground(GUIColor.PRIMARIO);
	    popup.setOpaque(true);
	    popup.setBorder(new CompoundBorder(new LineBorder(GUIColor.SECUNDARIO, 1), new EmptyBorder(5, 5, 5, 5)));
	    
	    return popup;
	}

	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		if(comboBox.isEnabled()) {
			super.paintCurrentValue(g, bounds, hasFocus);

		} else {
			ListCellRenderer<? super Object> renderer = comboBox.getRenderer();
			Component c = renderer.getListCellRendererComponent(
					listBox, comboBox.getSelectedItem(), -1, false, false);
			c.setFont(comboBox.getFont());

			if(comboBox.getComponentOrientation().isLeftToRight()) {
				c.setBounds(0, 0, comboBox.getWidth(), comboBox.getHeight());

			} else {
				c.setBounds(0, 0, comboBox.getWidth(), comboBox.getHeight());
			}

			c.setForeground(GUIColor.NEUTRAL);
			((JLabel) c).setHorizontalAlignment(SwingConstants.LEFT);

			// Dibujar el componente en el JComboBox.
			SwingUtilities.paintComponent(g, c, comboBox, bounds);
		}
	}

}
