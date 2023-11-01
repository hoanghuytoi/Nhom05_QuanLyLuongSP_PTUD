package UI;

/**
 * Hoàng Huy Tới
 */

import javax.swing.*;
import java.awt.*;

public class TrangChu_GUI extends JPanel {
    public TrangChu_GUI() {
    	setBackground(new Color(255, 255, 255));
        setLayout(null);
        setSize(1290, 750);

        JLabel lblHinhAnh = new JLabel();
        lblHinhAnh.setBackground(new Color(255, 255, 255));
		lblHinhAnh.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/trangChu.png")));
        lblHinhAnh.setBounds(0, 0, 1290, 750);
        add(lblHinhAnh);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NhanVien_GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TrangChu_GUI());
        frame.setSize(1290, 750);
        frame.setVisible(true);
    }
}
