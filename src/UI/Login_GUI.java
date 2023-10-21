package UI;

import java.awt.EventQueue;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Login_GUI extends JFrame {

	private JButton btnDangNhap;
    private JCheckBox chkRemerberPassword;
    private JComboBox<String> cmbNgonNgu;
    private JLabel disable;
    private JLabel lblHello;
    private JPanel panelTieuDe;
    private JPanel panelThongTin;
    private JLabel imageUser;
    private JLabel textPassword;
    private JLabel textUserName;
    private JLabel imageExit;
    private JLabel lblLogo;
    private JLabel lblMatKhau;
    private JLabel lblNgonNgu;
    private JLabel lblQuenMatKhau;
    private JLabel lblTenDangNhap;
    private JLabel lblTietDe;
    private JLabel lblTieuDeDangNhap;
    private JLabel show;
    private JTextField txtDangNhap;
    private JPasswordField txtMatKhau;
    
	

	public Login_GUI() {
        panelTieuDe = new JPanel();
        panelTieuDe.setBounds(0, 0, 510, 500);
        
        lblLogo = new JLabel();
        lblLogo.setBounds(-27, 54, 634, 446);
        lblLogo.setIcon(new ImageIcon(Login_GUI.class.getResource("/image/icon/login.PNG")));
        
        lblTietDe = new JLabel();
        lblTietDe.setBounds(0, 0, 510, 60);
        
        panelThongTin = new javax.swing.JPanel();
        panelThongTin.setBounds(510, 0, 550, 500);
        lblTieuDeDangNhap = new JLabel();
        lblTieuDeDangNhap.setBounds(129, 16, 286, 43);
        
        lblHello = new JLabel();
        lblHello.setBounds(162, 70, 208, 18);
        
        imageExit = new JLabel();
        imageExit.setBounds(483, 10, 50, 53);
        
        lblTenDangNhap = new JLabel();
        lblTenDangNhap.setBounds(60, 130, 360, 24);
        
        imageUser = new JLabel();
        imageUser.setBounds(450, 159, 20, 36);
        
        lblMatKhau = new JLabel();
        lblMatKhau.setBounds(60, 220, 360, 24);
        
        textUserName = new JLabel();
        textUserName.setBounds(60, 183, 344, 16);
        
        disable = new JLabel();
        disable.setBounds(450, 264, 20, 20);
        
        show = new JLabel();
        show.setBounds(450, 264, 31, 20);
        
        chkRemerberPassword = new JCheckBox();
        chkRemerberPassword.setBounds(60, 320, 165, 27);
        chkRemerberPassword.setBackground(new Color(255, 182, 193));
        
        lblNgonNgu = new JLabel();
        lblNgonNgu.setBounds(70, 450, 170, 18);
        
        btnDangNhap = new JButton();
        btnDangNhap.setBounds(60, 370, 410, 47);
        
        btnDangNhap.setBackground(new Color(255, 160, 122));
        textPassword = new JLabel();
        textPassword.setBounds(60, 275, 344, 14);
        
        lblQuenMatKhau = new JLabel();
        lblQuenMatKhau.setBounds(364, 323, 106, 18);
        
        cmbNgonNgu = new JComboBox<>();
        cmbNgonNgu.setBounds(280, 439, 190, 40);
        cmbNgonNgu.setFont(new Font("Times New Roman", Font.BOLD, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        panelTieuDe.setBackground(new Color(255, 228, 225));
        panelTieuDe.setPreferredSize(new java.awt.Dimension(500, 500));
        panelTieuDe.setLayout(null);
        lblLogo.setPreferredSize(new java.awt.Dimension(400, 400));
        panelTieuDe.add(lblLogo);
        lblTietDe.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTietDe.setForeground(new Color(0, 0, 0));
        lblTietDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTietDe.setText("PHẦN MỀM QUẢN LÝ LƯƠNG SẢN PHẨM - PACEPRO");
        panelTieuDe.add(lblTietDe);

        getContentPane().add(panelTieuDe);

        panelThongTin.setBackground(new Color(255, 182, 193));
        panelThongTin.setLayout(null);

        lblTieuDeDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 36));
        lblTieuDeDangNhap.setForeground(new Color(0, 0, 0));
        lblTieuDeDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDeDangNhap.setText("ĐĂNG NHẬP");
        lblTieuDeDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelThongTin.add(lblTieuDeDangNhap);

        lblHello.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lblHello.setForeground(new Color(0, 0, 0));
        lblHello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHello.setText("Welcome to the system");
        panelThongTin.add(lblHello);

        imageExit.setIcon(new ImageIcon(getClass().getResource("/image/icon/close.png")));
        imageExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        panelThongTin.add(imageExit);

        lblTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblTenDangNhap.setForeground(new Color(0, 0, 0));
        lblTenDangNhap.setText("Tên đăng nhập");
        panelThongTin.add(lblTenDangNhap);

        imageUser.setForeground(new Color(255, 255, 255));
        imageUser.setIcon(new ImageIcon(getClass().getResource("/image/icon/iconUser.png")));
        imageUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelThongTin.add(imageUser);

        lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblMatKhau.setForeground(new Color(0, 0, 0));
        lblMatKhau.setText("Mật khẩu");
        panelThongTin.add(lblMatKhau);

        textUserName.setFont(new Font("Tahoma", 1, 13));
        textUserName.setForeground(new Color(0, 0, 0));
        textUserName.setText("_________________________________________");
        panelThongTin.add(textUserName);

        disable.setIcon(new ImageIcon(getClass().getResource("/image/icon/iconNoEyes.png")));
        disable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        disable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        panelThongTin.add(disable);

        show.setIcon(new ImageIcon(getClass().getResource("/image/icon/iconEyes.png")));
        show.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        panelThongTin.add(show);

        chkRemerberPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        chkRemerberPassword.setText("Remember password?");
        chkRemerberPassword.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        chkRemerberPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chkRemerberPasswordMouseClicked(evt);
            }
        });
        chkRemerberPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRemerberPasswordActionPerformed(evt);
            }
        });
        panelThongTin.add(chkRemerberPassword);

        lblNgonNgu.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNgonNgu.setForeground(new Color(0, 0, 0));
        lblNgonNgu.setText("Chọn ngôn ngữ:");
        lblNgonNgu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//        lblNgonNgu.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                lblNgonNguMouseClicked(evt);
//            }
//        });
        panelThongTin.add(lblNgonNgu);

        btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnDangNhap.setForeground(new Color(0, 0, 0));
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        panelThongTin.add(btnDangNhap);

        textPassword.setForeground(new Color(0, 0, 0));
        textPassword.setText("_______________________________________________");
        panelThongTin.add(textPassword);

        lblQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblQuenMatKhau.setForeground(new Color(0, 0, 0));
        lblQuenMatKhau.setText("Quên mật khẩu?");
        lblQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	QuenMatKhau_GUI quenMatKhau = new QuenMatKhau_GUI();
                quenMatKhau.setVisible(true);
                quenMatKhau.setResizable(false);
                quenMatKhau.setLocationRelativeTo(null);
            }
        });
        panelThongTin.add(lblQuenMatKhau);

        cmbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VietNam", "English" }));
        cmbNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cmbNgonNguActionPerformed(evt);
            }
        });
        panelThongTin.add(cmbNgonNgu);

        getContentPane().add(panelThongTin);
        
        txtDangNhap = new JTextField();
        txtDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtDangNhap.setBackground(new Color(255, 182, 193));
        txtDangNhap.setBounds(60, 159, 344, 36);
        panelThongTin.add(txtDangNhap);
        txtDangNhap.setColumns(10);
        
        txtMatKhau = new JPasswordField();
        txtMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtMatKhau.setBackground(new Color(255, 182, 193));
        txtMatKhau.setBounds(60, 248, 344, 36);
        panelThongTin.add(txtMatKhau);

        setSize(new java.awt.Dimension(1058, 496));
        // Ẩn viền của textField
        txtDangNhap.setBorder(null); 
        txtMatKhau.setBorder(null);
        
        setLocationRelativeTo(null);
	}
	
	private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }
	
	private void showMouseClicked(java.awt.event.MouseEvent evt) {
        this.txtMatKhau.setEchoChar((char) 8226);
        this.disable.setVisible(true);
        this.disable.setEnabled(true);
        this.show.setVisible(false);
        this.show.setEnabled(false);
    }

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {
        this.txtMatKhau.setEchoChar((char) 0);
        this.disable.setVisible(false);
        this.disable.setEnabled(false);
        this.show.setVisible(true);
        this.show.setEnabled(true);
    }
    
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }
    
    private void chkRemerberPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    public Preferences pref = Preferences.userRoot().node("Remember");

    public void saveAccount(String userName, String password) {
        if (userName != null || password != null) {
            pref.put("userName", userName);
            pref.put("password", password);
        }
    }
    
    private void chkRemerberPasswordMouseClicked(java.awt.event.MouseEvent evt) {
        if (chkRemerberPassword.isSelected()) {
            saveAccount(this.txtDangNhap.getText(), new String(this.txtMatKhau.getPassword()));
        }
    }
    
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_GUI frame = new Login_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
