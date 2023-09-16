package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterActivity extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	
	public RegisterActivity() {
		setTitle("PACEPRO - Phầm mềm quản lý lương sản phẩm");
		setSize(1500, 830);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 102));
		panel.setBounds(0, 0, 437, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome Back!");
		lblNewLabel_3.setBounds(79, 91, 277, 59);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel lblNewLabel_4 = new JLabel("To keep connected with us piease login");
		lblNewLabel_4.setBounds(57, 161, 321, 34);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 18));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("with your personal into");
		lblNewLabel_4_1.setBounds(113, 200, 191, 34);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		panel.add(lblNewLabel_4_1);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.setBounds(157, 262, 101, 43);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignIn.setBackground(new Color(255, 0, 153));
		panel.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActivity frame = new LoginActivity();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
			}
		});
		
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(new Color(255, 255, 255));
		lblCreateAccount.setFont(new Font("Stencil", Font.BOLD, 32));
		lblCreateAccount.setBounds(530, 50, 294, 50);
		contentPane.add(lblCreateAccount);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(493, 111, 172, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(493, 141, 331, 43);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("EMAIL");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(493, 195, 172, 34);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(493, 230, 331, 43);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(493, 284, 172, 34);
		contentPane.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordField.setBounds(493, 313, 331, 43);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(255, 0, 102));
		btnNewButton_1.setBounds(611, 382, 108, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/bg Register.jpg"));
		lblNewLabel.setBounds(435, 0, 449, 461);
		contentPane.add(lblNewLabel);
	}

	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                RegisterActivity frame = new RegisterActivity();
	                frame.setVisible(true);
	                frame.setResizable(false);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}
