package Custom_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private Shape shape;
    private Color backgroundColor;
    private Color borderColor;

    public RoundedButton(String text, Color backgroundColor, Color borderColor) {
        super(text);
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(backgroundColor.darker());
        } else {
            g.setColor(backgroundColor);
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(borderColor);
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
    }
}