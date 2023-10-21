
package Custom_UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JLayeredPane;

/**
 *
 * @author December
 */
public class RoundedBorder extends JLayeredPane{
	
    public RoundedBorder() {
    	
    }

    // bo đường viền cho label
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        // Tạo một GradientPaint có màu xanh và đỏ cho đường viền
        GradientPaint gradient = new GradientPaint(0, 0, Color.RED, getWidth(), 0, Color.BLUE);
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
    }
}
