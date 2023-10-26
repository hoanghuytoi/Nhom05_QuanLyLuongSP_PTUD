package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;

import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class BangLuongNhanVien_GUI extends JPanel {
	private JTextField txtMaNV;
	private JTextField txtHoTenNV;
	private JTextField txtSoCccd;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtLuongCoBan;
	private JTextField txtMaBangLuong;
	
	private JScrollPane scrLuongNV;
    private JTable tblLuongNV;

	public BangLuongNhanVien_GUI() {
		setBackground(new Color(255, 255, 255));
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("BẢNG LƯƠNG NHÂN VIÊN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(440, 11, 490, 32);
	    add(lblTieuDe);
	    
	    JPanel panelNV = new JPanel();
	    panelNV.setLayout(null);
	    panelNV.setBackground(Color.WHITE);
	    panelNV.setBounds(20, 92, 1280, 342);
	    add(panelNV);
	    
	    JLabel lblMaNV = new JLabel();
	    lblMaNV.setText("Mã nhân viên:");
	    lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblMaNV.setBounds(235, 35, 96, 30);
	    panelNV.add(lblMaNV);
	    
	    txtMaNV = new JTextField();
	    txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaNV.setBorder(null);
	    txtMaNV.setBounds(341, 21, 301, 36);
	    panelNV.add(txtMaNV);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(341, 57, 301, 10);
	    panelNV.add(jSeparator);
	    
	    JLabel lblTenNV = new JLabel();
	    lblTenNV.setText("Họ và tên:");
	    lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblTenNV.setBounds(235, 100, 102, 30);
	    panelNV.add(lblTenNV);
	    
	    txtHoTenNV = new JTextField();
	    txtHoTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtHoTenNV.setBorder(null);
	    txtHoTenNV.setBounds(341, 85, 301, 36);
	    panelNV.add(txtHoTenNV);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(341, 122, 301, 10);
	    panelNV.add(jSeparator1);
	    
	    JLabel lblSoCccd = new JLabel();
	    lblSoCccd.setText("Số CCCD:");
	    lblSoCccd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSoCccd.setBounds(235, 160, 133, 30);
	    panelNV.add(lblSoCccd);
	    
	    txtSoCccd = new JTextField();
	    txtSoCccd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoCccd.setBorder(null);
	    txtSoCccd.setBounds(341, 149, 301, 30);
	    panelNV.add(txtSoCccd);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(341, 180, 301, 10);
	    panelNV.add(jSeparator2);
	    
	    JLabel lblErrSoCccd = new JLabel();
	    lblErrSoCccd.setText("thông báo lỗi");
	    lblErrSoCccd.setForeground(new Color(204, 0, 0));
	    lblErrSoCccd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSoCccd.setBounds(341, 184, 200, 18);
	    panelNV.add(lblErrSoCccd);
	    
	    JLabel lblGioiTinh = new JLabel();
	    lblGioiTinh.setText("Giới tính:");
	    lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblGioiTinh.setBounds(764, 97, 96, 30);
	    panelNV.add(lblGioiTinh);
	    
	    JLabel lblSdt = new JLabel();
	    lblSdt.setText("Số điện thoại:");
	    lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSdt.setBounds(235, 224, 133, 30);
	    panelNV.add(lblSdt);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(341, 244, 301, 10);
	    panelNV.add(jSeparator3);
	    
	    JSeparator jSeparator7 = new JSeparator();
	    jSeparator7.setForeground(Color.BLACK);
	    jSeparator7.setBounds(880, 180, 254, 10);
	    panelNV.add(jSeparator7);
	    
	    txtSdt = new JTextField();
	    txtSdt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSdt.setBorder(null);
	    txtSdt.setBounds(341, 214, 301, 30);
	    panelNV.add(txtSdt);
	    
	    JLabel lblErrSdt = new JLabel();
	    lblErrSdt.setText("thông báo lỗi");
	    lblErrSdt.setForeground(new Color(204, 0, 0));
	    lblErrSdt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSdt.setBounds(341, 248, 200, 18);
	    panelNV.add(lblErrSdt);
	    
	    JLabel lblErrTenNV = new JLabel();
	    lblErrTenNV.setText("lblErrTenNV");
	    lblErrTenNV.setForeground(new Color(204, 0, 0));
	    lblErrTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenNV.setBounds(341, 122, 200, 17);
	    panelNV.add(lblErrTenNV);
	    
	    JLabel lblEmail = new JLabel();
	    lblEmail.setText("Email:");
	    lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblEmail.setBounds(235, 294, 102, 30);
	    panelNV.add(lblEmail);
	    
	    txtEmail = new JTextField();
	    txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtEmail.setBorder(null);
	    txtEmail.setBounds(341, 277, 301, 36);
	    panelNV.add(txtEmail);
	    
	    JSeparator jSeparator1_1 = new JSeparator();
	    jSeparator1_1.setForeground(Color.BLACK);
	    jSeparator1_1.setBounds(341, 314, 301, 10);
	    panelNV.add(jSeparator1_1);
	    
	    JLabel lblErrEmail = new JLabel();
	    lblErrEmail.setText("thông báo lỗi");
	    lblErrEmail.setForeground(new Color(204, 0, 0));
	    lblErrEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrEmail.setBounds(341, 316, 200, 18);
	    panelNV.add(lblErrEmail);
	    
	    JRadioButton rdoNam = new JRadioButton();
	    rdoNam.setText("Nam");
	    rdoNam.setSelected(true);
	    rdoNam.setBackground(Color.WHITE);
	    rdoNam.setBounds(880, 93, 59, 30);
	    panelNV.add(rdoNam);
	    
	    JRadioButton rdoNu = new JRadioButton();
	    rdoNu.setText("Nữ");
	    rdoNu.setBackground(Color.WHITE);
	    rdoNu.setBounds(972, 93, 47, 30);
	    panelNV.add(rdoNu);
	    
	    JLabel lblPhongBan = new JLabel();
	    lblPhongBan.setText("Phòng ban:");
	    lblPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblPhongBan.setBounds(764, 219, 130, 40);
	    panelNV.add(lblPhongBan);
	    
	    JComboBox<String> cboPhongBan = new JComboBox<String>();
	    cboPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    cboPhongBan.setBackground(Color.WHITE);
	    cboPhongBan.setBounds(881, 219, 254, 40);
	    panelNV.add(cboPhongBan);
	    
	    JLabel lblChucVu = new JLabel();
	    lblChucVu.setText("Chức vụ:");
	    lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblChucVu.setBounds(764, 289, 96, 40);
	    panelNV.add(lblChucVu);
	    
	    JComboBox<String> cboChucVu = new JComboBox<String>();
	    cboChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    cboChucVu.setBackground(Color.WHITE);
	    cboChucVu.setBounds(881, 290, 254, 40);
	    panelNV.add(cboChucVu);
	    
	    JLabel lblLuongCoBan = new JLabel();
	    lblLuongCoBan.setText("Lương cơ bản:");
	    lblLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblLuongCoBan.setBounds(764, 146, 107, 40);
	    panelNV.add(lblLuongCoBan);
	    
	    txtLuongCoBan = new JTextField();
	    txtLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtLuongCoBan.setBorder(null);
	    txtLuongCoBan.setBounds(881, 143, 254, 36);
	    panelNV.add(txtLuongCoBan);
	    
	    JLabel lblErrLuongCoBan = new JLabel();
	    lblErrLuongCoBan.setText("đây là dòng thông báo lỗi");
	    lblErrLuongCoBan.setForeground(new Color(204, 0, 0));
	    lblErrLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrLuongCoBan.setBounds(880, 184, 254, 18);
	    panelNV.add(lblErrLuongCoBan);
	    
	    JLabel lblMaBangLuong = new JLabel();
	    lblMaBangLuong.setText("Mã bảng lương:");
	    lblMaBangLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblMaBangLuong.setBounds(764, 35, 96, 30);
	    panelNV.add(lblMaBangLuong);
	    
	    txtMaBangLuong = new JTextField();
	    txtMaBangLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaBangLuong.setBorder(null);
	    txtMaBangLuong.setBounds(880, 21, 254, 36);
	    panelNV.add(txtMaBangLuong);
	    
	    JSeparator jSeparator_1 = new JSeparator();
	    jSeparator_1.setForeground(Color.BLACK);
	    jSeparator_1.setBounds(880, 57, 254, 10);
	    panelNV.add(jSeparator_1);
	    
	    JLabel lblDsPhanCD = new JLabel("Bảng lương nhân viên:");
        lblDsPhanCD.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDsPhanCD.setBounds(28, 491, 262, 41);
	    add(lblDsPhanCD);
	    
	    tblLuongNV = new JTable();
	    tblLuongNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    tblLuongNV.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    
	    tblLuongNV.setRowHeight(20);

	    tblLuongNV.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 l\u01B0\u01A1ng", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "L\u01B0\u01A1ng th\u00E1ng", "S\u1ED1 ng\u00E0y \u0111i l\u00E0m", "S\u1ED1 ng\u00E0y ngh\u1EC9", "S\u1ED1 ph\u00E9p ngh\u1EC9", "T\u1ED5ng l\u01B0\u01A1ng", "\u0110\u01A1n v\u1ECB ti\u00EAn", "Ng\u00E0y t\u00EDnh l\u01B0\u01A1ng"
	    	}
	    ));
	    tblLuongNV.getColumnModel().getColumn(0).setPreferredWidth(40);
	    tblLuongNV.getColumnModel().getColumn(0).setMinWidth(20);
	    tblLuongNV.getColumnModel().getColumn(0).setMaxWidth(40);
	    tblLuongNV.getColumnModel().getColumn(1).setPreferredWidth(72);
	    tblLuongNV.getColumnModel().getColumn(2).setPreferredWidth(76);
	    tblLuongNV.getColumnModel().getColumn(3).setPreferredWidth(86);

	    scrLuongNV = new JScrollPane(tblLuongNV);
	    scrLuongNV.setBounds(28, 532, 1252, 207);
	    add(scrLuongNV);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        scrLuongNV.setVerticalScrollBar(scrollBar);
        
        JPanel panelButton = new JPanel();
        panelButton.setBounds(20, 432, 1280, 62);
        add(panelButton);
        panelButton.setLayout(null);
        panelButton.setBackground(Color.WHITE);
        
        RoundedButton btnTinhLuong = new RoundedButton("Thêm", new Color(0, 206, 209), (Color) null);
        btnTinhLuong.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/tinhLuong.png")));
        btnTinhLuong.setText("Tính lương");
        btnTinhLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnTinhLuong.setBounds(60, 14, 184, 40);
        panelButton.add(btnTinhLuong);
        
        RoundedButton btnInBangLuong = new RoundedButton("Xóa", new Color(238, 232, 170), (Color) null);
        btnInBangLuong.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/in.png")));
        btnInBangLuong.setText("In bảng lương");
        btnInBangLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnInBangLuong.setBounds(322, 14, 184, 40);
        panelButton.add(btnInBangLuong);
        
        RoundedButton btnTimKiem = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
        btnTimKiem.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/timKiem.png")));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnTimKiem.setBounds(582, 14, 150, 40);
        panelButton.add(btnTimKiem);
        
        RoundedButton btnXoaRong = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
        btnXoaRong.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/xoaRong.png")));
        btnXoaRong.setText("Xóa rỗng");
        btnXoaRong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnXoaRong.setBounds(796, 14, 150, 40);
        panelButton.add(btnXoaRong);
        
        RoundedButton btnXemChiTiet = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
        btnXemChiTiet.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/xemChiTiet.png")));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnXemChiTiet.setBounds(1015, 14, 150, 40);
        panelButton.add(btnXemChiTiet);
        
        JLabel lblThang = new JLabel();
        lblThang.setBounds(455, 56, 66, 41);
        add(lblThang);
        lblThang.setText("Tháng");
        lblThang.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        JComboBox<String> cmbThang = new JComboBox<String>();
        cmbThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbThang.setBackground(Color.WHITE);
        cmbThang.setBounds(531, 57, 57, 32);
        add(cmbThang);
        
        cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbThangActionPerformed(evt);
            }
        });
        
        JLabel lblNam = new JLabel();
        lblNam.setText("Năm");
        lblNam.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNam.setBounds(680, 56, 66, 41);
        add(lblNam);
        
        JComboBox<String> cmbNam = new JComboBox<String>();
        cmbNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbNam.setBackground(Color.WHITE);
        cmbNam.setBounds(742, 58, 78, 32);
        add(cmbNam);
	 
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000" }));
        cmbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbNamActionPerformed(evt);
            }
        });
	}
}
