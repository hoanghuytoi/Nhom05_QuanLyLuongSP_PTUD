package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Custom_UI.Session;
import Custom_UI.XEmail;
import Dao.NhanVien_Dao;
import Entity.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
public class QuenMatKhau_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JLabel lblErrUserName;
	private JLabel lblErrEmail;
	private JButton btnGuiMa;
	
	private Session ss = Session.getInstance();
    private NhanVien_Dao dao = new NhanVien_Dao();
    private XEmail email = new XEmail();
	public QuenMatKhau_GUI() {
        initComponents();
        try {
            ConnectionDB.ConnectDB.getInstance().connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        new NhanVien_Dao();
        lblErrEmail.setText("");
        lblErrUserName.setText("");
    }

	public void initComponents() {
		setTitle("PACEPRO - Hệ thống quản lý lương sản phẩm");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_GUI.class.getResource("/image/icon/salary.png")));
		
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
		
		JLabel lblUserName = new JLabel("User name:");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblUserName.setBounds(132, 231, 175, 47);
		panel.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtUserName.setBounds(132, 276, 512, 52);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblEmail.setBounds(132, 354, 175, 47);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtEmail.setColumns(10);
		txtEmail.setBounds(132, 396, 512, 52);
		panel.add(txtEmail);
		
		btnGuiMa = new JButton("GỬI MÃ ĐẶT LẠI");
		btnGuiMa.setBackground(Color.RED);
		btnGuiMa.setForeground(Color.WHITE);
		btnGuiMa.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnGuiMa.setBounds(246, 502, 295, 57);
		btnGuiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaActionPerformed(evt);
            }
        });
		panel.add(btnGuiMa);
		
		lblErrUserName = new JLabel();
		lblErrUserName.setForeground(Color.RED);
		lblErrUserName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblErrUserName.setBounds(132, 329, 290, 29);
		panel.add(lblErrUserName);
		
		lblErrEmail = new JLabel();
		lblErrEmail.setForeground(Color.RED);
		lblErrEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblErrEmail.setBounds(132, 448, 290, 29);
		panel.add(lblErrEmail);
		
	}
	
	private void btnGuiMaActionPerformed(java.awt.event.ActionEvent evt) {
	    String userName = txtUserName.getText().trim();
	    String emailValue = txtEmail.getText().trim();
	    
	    if (userName.isEmpty() || emailValue.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
	        return;
	    }

	    // Kiểm tra xem UserName có tồn tại trong cơ sở dữ liệu không
	    NhanVien nv = dao.layMotNhanVienTheoMaNhanVien(userName);

	    if (nv == null) {
	        // Nếu UserName không tồn tại, hiển thị thông báo lỗi
	        lblErrUserName.setText("Tài khoản không tồn tại. Vui lòng kiểm tra lại.");
	        lblErrEmail.setText("");
	    } else {
	        // Kiểm tra xem email có trùng khớp với email trong tài khoản không
	        if (!nv.getEmail().equalsIgnoreCase(emailValue)) {
	            // Nếu email không trùng khớp, hiển thị thông báo lỗi
	            lblErrEmail.setText("Email không khớp với tài khoản. Vui lòng kiểm tra lại.");
	            lblErrUserName.setText("");
	        } else {
	        	lblErrEmail.setText("");
	            // Nếu UserName và email đều hợp lệ, tiếp tục gửi mã đặt lại và chuyển đến giao diện xác thực
	            int leftLimit = 97; // letter 'a'
	            int rightLimit = 122; // letter 'z'
	            int len = 10;
	            Random random = new Random();
	            StringBuilder buffer = new StringBuilder(len);
	            for (int i = 0; i < len; i++) {
	                int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
	                buffer.append((char) randomLimitedInt);
	            }
	            String generatedString = buffer.toString();
	            
	            // Gửi email với mã đặt lại
	            email.sendEmail(nv.getEmail(), generatedString);
	            
	            // Lưu thông tin cho việc kiểm tra ở giao diện xác thực
	            ss.set("content", generatedString);
	            ss.set("email", nv.getEmail());
	            
	            // Chuyển đến giao diện xác thực
	            XacThuc_GUI o = new XacThuc_GUI();
	            o.setVisible(true);
	            this.dispose();
	        }
	    }
	}

}
