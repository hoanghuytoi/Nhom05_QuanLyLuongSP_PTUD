package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class QuenMatKhau_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMatKhau_GUI frame = new QuenMatKhau_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuenMatKhau_GUI() {
		setTitle("PACEPRO - Hệ thống quản lý lương sản phẩm");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/image/icon/salary.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 681);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 772, 642);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(QuenMatKhau_GUI.class.getResource("/image/icon/logo.png")));
		lblLogo.setFont(new Font("Stencil Std", Font.BOLD, 35));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setBounds(329, 11, 143, 74);
		panel.add(lblLogo);
		
		JLabel lblTieuDe = new JLabel("Đặt lại mật khẩu của bạn");
		lblTieuDe.setForeground(Color.WHITE);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTieuDe.setBounds(213, 88, 347, 47);
		panel.add(lblTieuDe);
		
		JLabel lblGioiThieu = new JLabel("Bạn không thể nhớ mật khẩu của mình? Nhập tên người dùng và mật khẩu của bạn");
		lblGioiThieu.setForeground(Color.WHITE);
		lblGioiThieu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblGioiThieu.setBounds(132, 146, 564, 36);
		panel.add(lblGioiThieu);
		
		JLabel lblGioiThieu1 = new JLabel("chúng tôi sẽ gửi cho bạn một mã ngẫu nhiên để tạo mật khẩu mới.");
		lblGioiThieu1.setForeground(Color.WHITE);
		lblGioiThieu1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblGioiThieu1.setBounds(180, 172, 450, 36);
		panel.add(lblGioiThieu1);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblUserName.setBounds(132, 231, 175, 47);
		panel.add(lblUserName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField.setBounds(132, 276, 512, 52);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelContact = new JLabel("Tel contact");
		lblTelContact.setForeground(Color.WHITE);
		lblTelContact.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTelContact.setBounds(132, 354, 175, 47);
		panel.add(lblTelContact);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(132, 396, 512, 52);
		panel.add(textField_1);
		
		JButton btnGuiMa = new JButton("GỬI MÃ ĐẶT LẠI");
		btnGuiMa.setBackground(Color.RED);
		btnGuiMa.setForeground(Color.WHITE);
		btnGuiMa.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnGuiMa.setBounds(246, 502, 295, 57);
		panel.add(btnGuiMa);
	}
}
