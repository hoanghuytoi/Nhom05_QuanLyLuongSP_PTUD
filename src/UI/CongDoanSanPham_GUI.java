package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Hoàng Huy Tới
 */

public class CongDoanSanPham_GUI extends JPanel {

	
	public CongDoanSanPham_GUI() {
		initComponents();
	}

	private void initComponents() {
	    setSize(1290, 750);
	    setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(1280, 111, -1279, -105);
	    add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ CÔNG ĐOẠN SẢN PHẨM ");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    lblTieuDe.setBounds(454, 11, 538, 66);
	    add(lblTieuDe);
	    
	}

}
