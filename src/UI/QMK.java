package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class QMK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QMK frame = new QMK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QMK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 630);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 772, 591);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hoang\\Videos\\Nhom05_QuanLyLuongSP_PTUD-main\\images\\logoApp.png"));
		lblNewLabel.setFont(new Font("Stencil Std", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(319, 0, 149, 84);
		panel.add(lblNewLabel);
		
		JLabel lblD = new JLabel("Đặt lại mật khẩu của bạn");
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblD.setBounds(213, 88, 347, 47);
		panel.add(lblD);
		
		JLabel lblBnKhngNh = new JLabel("Bạn không thể nhớ mật khẩu của mình? Nhập tên người dùng và mật khẩu của bạn");
		lblBnKhngNh.setForeground(Color.WHITE);
		lblBnKhngNh.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblBnKhngNh.setBounds(132, 146, 564, 36);
		panel.add(lblBnKhngNh);
		
		JLabel lblVChngTi = new JLabel("chúng tôi sẽ gửi cho bạn một mã ngẫu nhiên để tạo mật khẩu mới.");
		lblVChngTi.setForeground(Color.WHITE);
		lblVChngTi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblVChngTi.setBounds(180, 172, 450, 36);
		panel.add(lblVChngTi);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblUserName.setBounds(132, 231, 175, 47);
		panel.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(132, 276, 512, 52);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelContact = new JLabel("Tel contact");
		lblTelContact.setForeground(Color.WHITE);
		lblTelContact.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblTelContact.setBounds(132, 354, 175, 47);
		panel.add(lblTelContact);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 396, 512, 52);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("GỬI MÃ ĐẶT LẠI");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setBounds(252, 489, 295, 57);
		panel.add(btnNewButton);
	}
}
