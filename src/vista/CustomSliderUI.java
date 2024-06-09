package vista;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CustomSliderUI extends BasicSliderUI {
	
	// Clase para personalizar la apariencia del JSlider.

	public CustomSliderUI(JSlider slider) {
		super(slider);
		slider.setFocusable(false);
	}

	@Override
	protected Dimension getThumbSize() {
		return new Dimension(20, 20);
	}

	@Override
	public void paintTrack(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    int trackHeight = 6;
	    int centerY = trackRect.y + (trackRect.height - trackHeight) / 2;
	    g2d.setColor(GUIColor.SECUNDARIO);
	    g2d.fillRect(trackRect.x, centerY, trackRect.width, trackHeight);
	}

	@Override
	public void paintThumb(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.translate(thumbRect.x, thumbRect.y);
		g2d.setColor(GUIColor.DESTACADO);
		g2d.fill(new Ellipse2D.Double(0, 0, thumbRect.width, thumbRect.height));
		//g2d.fillRect(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
		g2d.dispose();
	}
	
	@Override
	public void paintTicks(Graphics g) {
		super.paintTicks(new Graphics2DProxy((Graphics2D) g){
			@Override
			public void setColor(Color c) {
				super.setColor(GUIColor.SECUNDARIO);
			}
		});
	}

}
