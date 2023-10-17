package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Login frame = new Login();
	                frame.setVisible(true);
	                frame.setResizable(false);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("PACEPRO - Phầm mềm quản lý lương sản phẩm");
		setSize(1050, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(516, 0, 518, 511);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(148, 11, 263, 64);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hoang\\Videos\\Nhom05_QuanLyLuongSP_PTUD-main\\images\\logoTK.png"));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(57, 86, 197, 36);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField.setBounds(67, 133, 404, 54);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\hoang\\Videos\\Nhom05_QuanLyLuongSP_PTUD-main\\images\\logoDMK.png"));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(67, 210, 197, 36);
		panel.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		passwordField.setBounds(67, 246, 404, 54);
		panel.add(passwordField);
		
		JLabel lblNgonNgu = new JLabel("Chọn ngôn ngữ :");
		lblNgonNgu.setForeground(new Color(255, 255, 255));
		lblNgonNgu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNgonNgu.setBounds(76, 445, 115, 29);
		panel.add(lblNgonNgu);
		
		JButton btnNewButton = new JButton("ĐĂNG NHẬP");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(131, 365, 280, 48);
		panel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Remember password?");
		chckbxNewCheckBox_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxNewCheckBox_1.setBackground(new Color(0, 128, 128));
		chckbxNewCheckBox_1.setBounds(69, 328, 185, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quên mật khẩu?");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3_1.setBounds(345, 325, 115, 29);
		panel.add(lblNewLabel_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(224, 445, 187, 29);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hoang\\Videos\\Nhom05_QuanLyLuongSP_PTUD-main\\images\\background.png"));
		lblNewLabel.setBounds(-313, 0, 865, 511);
		getContentPane().add(lblNewLabel);
	}
}
