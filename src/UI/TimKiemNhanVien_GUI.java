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

import com.toedter.calendar.JDateChooser;
import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

/**
 * Hoàng Huy Tới
 */

public class TimKiemNhanVien_GUI extends JPanel {
	
	private JScrollPane scrNhanVien;
    private JTable tblNhanVien;
    
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtSoCccd;
    private JTextField txtSdt;
    private JTextField txtEmail;

	
	public TimKiemNhanVien_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("TÌM KIẾM NHÂN VIÊN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(411, 11, 490, 50);
	    add(lblTieuDe);
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setLayout(null);
	    panelButton.setBackground(Color.WHITE);
	    panelButton.setBounds(229, 405, 814, 65);
	    add(panelButton);
	    
	    RoundedButton rndbtnXaRng = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
	    rndbtnXaRng.setIcon(new ImageIcon(TimKiemSanPham_GUI.class.getResource("/image/icon/xoaRong.png")));
	    rndbtnXaRng.setText("Xóa rỗng");
	    rndbtnXaRng.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    rndbtnXaRng.setBounds(219, 14, 170, 40);
	    panelButton.add(rndbtnXaRng);
	    
	    RoundedButton rndbtnTmKim = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
	    rndbtnTmKim.setIcon(new ImageIcon(TimKiemSanPham_GUI.class.getResource("/image/icon/timKiem.png")));
	    rndbtnTmKim.setText("Tìm kiếm");
	    rndbtnTmKim.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    rndbtnTmKim.setBounds(439, 14, 170, 40);
	    panelButton.add(rndbtnTmKim);
	    
	    JPanel panelNV = new JPanel();
	    panelNV.setLayout(null);
	    panelNV.setBackground(Color.WHITE);
	    panelNV.setBounds(0, 42, 1254, 350);
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
	    
	    txtTenNV = new JTextField();
	    txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenNV.setBorder(null);
	    txtTenNV.setBounds(341, 85, 301, 36);
	    panelNV.add(txtTenNV);
	    
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
	    txtSoCccd.setText("0");
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
	    
	    JLabel lblNgaySinh = new JLabel();
	    lblNgaySinh.setText("Ngày sinh:");
	    lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblNgaySinh.setBounds(764, 35, 96, 30);
	    panelNV.add(lblNgaySinh);
	    
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
	    
	    txtSdt = new JTextField();
	    txtSdt.setText("0");
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
	    txtEmail.setText("txtEmail");
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
	    
	    JDateChooser dcsNgaySinh = new JDateChooser();
	    dcsNgaySinh.setDateFormatString("yyyy-MM-dd");
	    dcsNgaySinh.setBounds(881, 23, 254, 34);
	    panelNV.add(dcsNgaySinh);
	    
	    JRadioButton rdoNam = new JRadioButton();
	    rdoNam.setBackground(new Color(255, 255, 255));
	    rdoNam.setText("Nam");
	    rdoNam.setSelected(true);
	    rdoNam.setBounds(880, 93, 64, 30);
	    panelNV.add(rdoNam);
	    
	    JRadioButton rdoNu = new JRadioButton();
	    rdoNu.setBackground(new Color(255, 255, 255));
	    rdoNu.setText("Nữ");
	    rdoNu.setBounds(972, 93, 52, 30);
	    panelNV.add(rdoNu);
	    
	    JLabel lblNgayVaoLam = new JLabel();
	    lblNgayVaoLam.setText("Ngày vào làm:");
	    lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblNgayVaoLam.setBounds(764, 150, 140, 40);
	    panelNV.add(lblNgayVaoLam);
	    
	    JDateChooser dcsNgayVaoLam = new JDateChooser();
	    dcsNgayVaoLam.setDateFormatString("yyyy-MM-dd");
	    dcsNgayVaoLam.setBounds(881, 149, 254, 34);
	    panelNV.add(dcsNgayVaoLam);
	    
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
	    
	    JLabel lblErrNgayVaoLam = new JLabel();
	    lblErrNgayVaoLam.setText("đây là dòng thông báo lỗi");
	    lblErrNgayVaoLam.setForeground(new Color(204, 0, 0));
	    lblErrNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayVaoLam.setBounds(881, 184, 273, 18);
	    panelNV.add(lblErrNgayVaoLam);
	    
	    JLabel lblErrNgaySinh = new JLabel();
	    lblErrNgaySinh.setText("đây là dòng thông báo lỗi");
	    lblErrNgaySinh.setForeground(new Color(204, 0, 0));
	    lblErrNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgaySinh.setBounds(880, 64, 254, 18);
	    panelNV.add(lblErrNgaySinh);
	    
	    tblNhanVien = new JTable();
	    tblNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    tblNhanVien.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
	    tblNhanVien.setRowHeight(22);

	    tblNhanVien.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 CCCD", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "\u1EA2nh \u0111\u1EA1i di\u1EC7n", "Email", "Ph\u00F2ng Ban", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m", "L\u01B0\u01A1ng c\u01A1 b\u1EA3n"
	    	}
	    ));
	    tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(33);
	    tblNhanVien.getColumnModel().getColumn(0).setMinWidth(33);
	    

	    scrNhanVien = new JScrollPane(tblNhanVien);
	    scrNhanVien.setBounds(10, 515, 1259, 236);
	    add(scrNhanVien);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        scrNhanVien.setVerticalScrollBar(scrollBar);
	    
	    JLabel lblDsNV = new JLabel("Danh sách nhân viên:");
	    lblDsNV.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblDsNV.setBounds(10, 473, 186, 37);
	    add(lblDsNV);
	
	}
}
