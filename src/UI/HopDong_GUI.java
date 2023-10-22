package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

/**
 * Hoàng Huy Tới
 */

public class HopDong_GUI extends JPanel {
	private JTextField txtMaHD;
	private JTextField txtTenHD;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;

	
	public HopDong_GUI() {
		initComponents();
	}

	private void initComponents() {
	    setSize(1290, 750);
	    setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(1280, 111, -1279, -105);
	    add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ HỢP ĐỒNG ");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    lblTieuDe.setBounds(454, 11, 368, 66);
	    add(lblTieuDe);
	    
	    JLabel lblAnhHD = new JLabel("");
	    lblAnhHD.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/hopDong/HopDong.PNG")));
	    lblAnhHD.setBounds(10, 101, 200, 168);
	    add(lblAnhHD);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBounds(220, 101, 345, 168);
	    add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lblMaHD = new JLabel("Mã hợp đồng:");
	    lblMaHD.setBounds(0, 24, 91, 18);
	    panel_1.add(lblMaHD);
	    lblMaHD.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    
	    txtMaHD = new JTextField();
	    txtMaHD.setBounds(122, 7, 223, 35);
	    panel_1.add(txtMaHD);
	    txtMaHD.setColumns(10);
	    
	    JLabel lblTenHD = new JLabel("Tên hợp đồng:");
	    lblTenHD.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblTenHD.setBounds(0, 83, 101, 18);
	    panel_1.add(lblTenHD);
	    
	    txtTenHD = new JTextField();
	    txtTenHD.setColumns(10);
	    txtTenHD.setBounds(122, 66, 223, 35);
	    panel_1.add(txtTenHD);
	    
	    JLabel lblNewLabel_2_2_1 = new JLabel("Giá trị Hợp Đồng:");
	    lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_2_1.setBounds(0, 150, 117, 18);
	    panel_1.add(lblNewLabel_2_2_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(122, 133, 223, 35);
	    panel_1.add(textField_2);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setLayout(null);
	    panel_1_1.setBounds(575, 101, 335, 168);
	    add(panel_1_1);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Tên khách hàng:");
	    lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_1.setBounds(0, 24, 109, 18);
	    panel_1_1.add(lblNewLabel_2_1);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(112, 11, 223, 35);
	    panel_1_1.add(textField_3);
	    
	    JLabel lblNewLabel_2_2_2 = new JLabel("Địa chỉ:");
	    lblNewLabel_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_2_2.setBounds(0, 84, 91, 18);
	    panel_1_1.add(lblNewLabel_2_2_2);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(112, 77, 223, 35);
	    panel_1_1.add(textField_4);
	    
	    JLabel lblNewLabel_2_2_1_1 = new JLabel("Số tiền cọc:");
	    lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_2_1_1.setBounds(0, 149, 91, 18);
	    panel_1_1.add(lblNewLabel_2_2_1_1);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(112, 132, 223, 35);
	    panel_1_1.add(textField_5);
	    
	    JPanel panel_1_2 = new JPanel();
	    panel_1_2.setLayout(null);
	    panel_1_2.setBounds(931, 101, 335, 168);
	    add(panel_1_2);
	    
	    JLabel lblNewLabel_2_3 = new JLabel("Ngày bắt đầu:");
	    lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_3.setBounds(0, 24, 91, 18);
	    panel_1_2.add(lblNewLabel_2_3);
	    
	    JLabel lblNewLabel_2_2_3 = new JLabel("Ngày kết thúc:");
	    lblNewLabel_2_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_2_3.setBounds(0, 84, 102, 18);
	    panel_1_2.add(lblNewLabel_2_2_3);
	    
	    JLabel lblNewLabel_2_2_1_2 = new JLabel("Thỏa thuận:");
	    lblNewLabel_2_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel_2_2_1_2.setBounds(0, 149, 91, 18);
	    panel_1_2.add(lblNewLabel_2_2_1_2);
	    
	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    textField_8.setBounds(112, 132, 223, 35);
	    panel_1_2.add(textField_8);
	    
	}
}
