package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Dao.CongNhan_Dao;
import Dao.NhanVien_Dao;
import Entity.NhanVien;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.prefs.Preferences;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

/**
*
* @author HoangHuyToi
*/

public class Login_GUI extends JFrame implements MouseListener,ActionListener{

	private JTextField txtTaiKhoan;
	private JButton btnDangNhap;
	private JPasswordField txtPassword;
    private JLabel lblQuenMatKhau,lblNgonNgu;
    private JCheckBox chkRemerberPassword;
    private NhanVien_Dao nhanVien_DAO;
    private CongNhan_Dao congNhan_DAO;


	public Login_GUI() {
        try {
            ConnectionDB.ConnectDB.getInstance().connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        congNhan_DAO = new CongNhan_Dao();
        nhanVien_DAO = new NhanVien_Dao();
        Component();
        txtTaiKhoan.setText("NV100001");
        txtPassword.setText("111111");

        if (pref.get("userName", "").equals("") || pref.get("userName", "") == null) {
            txtTaiKhoan.setText("NV100001");
            NhanVien nhanVienDangNhap = nhanVien_DAO.layMotNhanVienTheoMaNhanVien(txtTaiKhoan.getText());
            txtPassword.setText(nhanVienDangNhap.getMatKhau());
        } else {
            getDataRemember();
        }
    }
	
	public void getDataRemember() {
        String userName = "";
        userName = pref.get("userName", userName);
        String passWord = "";
        passWord = pref.get("password", passWord);
        this.txtTaiKhoan.setText(userName);
        this.txtPassword.setText(passWord);
    }
	
    private void Component(){
		setTitle("PACEPRO - Hệ thống quản lý lương sản phẩm");
		setSize(1050, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\salary.png"));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(516, 0, 518, 511);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("ĐĂNG NHẬP");
		lblTieuDe.setForeground(new Color(255, 255, 255));
		lblTieuDe.setBackground(new Color(255, 255, 255));
		lblTieuDe.setBounds(148, 11, 263, 64);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel.add(lblTieuDe);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setIcon(new ImageIcon("images\\logoTK.png"));
		lblTenDangNhap.setForeground(new Color(255, 255, 255));
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTenDangNhap.setBounds(57, 86, 197, 36);
		panel.add(lblTenDangNhap);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtTaiKhoan.setBounds(67, 133, 404, 54);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setIcon(new ImageIcon("images\\logoDMK.png"));
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMatKhau.setBounds(67, 210, 197, 36);
		panel.add(lblMatKhau);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 25));
		txtPassword.setBounds(67, 246, 404, 54);
		panel.add(txtPassword);
		
		chkRemerberPassword = new JCheckBox("Remember password?");
		chkRemerberPassword.setBackground(new Color(0, 128, 128));
		chkRemerberPassword.setForeground(new Color(255, 255, 255));
		chkRemerberPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chkRemerberPassword.setBounds(69, 328, 185, 23);
		panel.add(chkRemerberPassword);
		
		chkRemerberPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chkRemerberPasswordMouseClicked(evt);
            }
        });

		
		lblQuenMatKhau = new JLabel("Quên mật khẩu?");
		lblQuenMatKhau.setForeground(new Color(255, 255, 255));
		lblQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuenMatKhau.setBounds(345, 325, 115, 29);
		panel.add(lblQuenMatKhau);
		
		lblQuenMatKhau.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });
		
		JLabel lblNgonNgu = new JLabel("Chọn ngôn ngữ :");
		lblNgonNgu.setForeground(new Color(255, 255, 255));
		lblNgonNgu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNgonNgu.setBounds(76, 445, 115, 29);
		panel.add(lblNgonNgu);
		
		lblNgonNgu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNgonNguMouseClicked(evt);
            }
        });
		
		JComboBox cmbNgonNgu = new JComboBox();
		cmbNgonNgu.setBounds(224, 445, 187, 29);
		panel.add(cmbNgonNgu);
		
		cmbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VietNam", "English" }));
        cmbNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNgonNguActionPerformed(evt);
            }
        });
        
		btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setForeground(new Color(0, 0, 255));
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBounds(131, 365, 280, 48);
		panel.add(btnDangNhap);
		
		btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("images\\background.png"));
		lblNewLabel.setBounds(-313, 0, 865, 511);
		getContentPane().add(lblNewLabel);
		
	}
    
    private void btnDangNhapActionPerformed(ActionEvent evt) {

        String userName = txtTaiKhoan.getText();
        String password = new String(txtPassword.getPassword());
        if (userName.length() != 8 || password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc Mật khẩu không chính xác!", "Thông Báo Đăng nhập", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String loai = userName.substring(0, 2);
        if (loai.equals("NV")) {
            NhanVien nhanVien = nhanVien_DAO.layMotNhanVienTheoMaNhanVien(userName);
            if (nhanVien != null && nhanVien.getMatKhau().equals(password)) {
                try {
                    new Main_GUI().setVisible(true);
                } catch (Exception e1) {
                	e1.printStackTrace();
                }
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc Mật khẩu không chính xác!", "Thông Báo Đăng nhập", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "chính xác!", "Thông Báo Đăng nhập", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
    
    public Preferences pref = Preferences.userRoot().node("Remember");

    public void saveAccount(String userName, String password) {
        if (userName != null || password != null) {
            pref.put("userName", userName);
            pref.put("password", password);
        }
    }
    private void chkRemerberPasswordMouseClicked(MouseEvent evt) {
        if (chkRemerberPassword.isSelected()) {
            saveAccount(this.txtTaiKhoan.getText(), new String(this.txtPassword.getPassword()));
        }
    }
    
    private void lblQuenMatKhauMouseClicked(MouseEvent evt) {
        new QuenMatKhau_GUI().setVisible(true);
    }
	
    private void lblNgonNguMouseClicked(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(this, "Ngôn ngữ!)");
    }
    
    private void cmbNgonNguActionPerformed(java.awt.event.ActionEvent evt) {
//        try {
//            caiDatNgonNguChoView(ngonNguList.get(cmbNgonNgu.getSelectedIndex()));
//        } catch (IOException ex) {
//            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Login_GUI frame = new Login_GUI();
	                frame.setVisible(true);
	                frame.setResizable(false);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}