package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;

public class CongNhan_GUI extends JPanel {
	private JTextField txtMaCN;
	private JTextField txtTenCN;
	private JTextField txtSoCccd;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	
	private JScrollPane scrCongNhan;
    private JTable tblCongNhan;

	public CongNhan_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
	    setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ CÔNG NHÂN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(530, 11, 368, 37);
	    add(lblTieuDe);
	    
	    JPanel panelCN = new JPanel();
	    panelCN.setLayout(null);
	    panelCN.setBackground(Color.WHITE);
	    panelCN.setBounds(71, 41, 1190, 353);
	    add(panelCN);
	    
	    JLabel lblAnhCN = new JLabel();
	    lblAnhCN.setIcon(new ImageIcon(CongNhan_GUI.class.getResource("/image/congNhan/congNhan1.png")));
	    lblAnhCN.setBounds(23, 85, 181, 179);
	    panelCN.add(lblAnhCN);
	    
	    JLabel lblMaCN = new JLabel();
	    lblMaCN.setText("Mã công nhân:");
	    lblMaCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblMaCN.setBounds(235, 35, 96, 30);
	    panelCN.add(lblMaCN);
	    
	    txtMaCN = new JTextField();
	    txtMaCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaCN.setBorder(null);
	    txtMaCN.setBounds(341, 21, 301, 36);
	    panelCN.add(txtMaCN);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(341, 57, 301, 10);
	    panelCN.add(jSeparator);
	    
	    JLabel lblTenNV = new JLabel();
	    lblTenNV.setText("Họ và tên:");
	    lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblTenNV.setBounds(235, 100, 102, 30);
	    panelCN.add(lblTenNV);
	    
	    txtTenCN = new JTextField();
	    txtTenCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenCN.setBorder(null);
	    txtTenCN.setBounds(341, 85, 301, 36);
	    panelCN.add(txtTenCN);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(341, 122, 301, 10);
	    panelCN.add(jSeparator1);
	    
	    JLabel lblSoCccd = new JLabel();
	    lblSoCccd.setText("Số CCCD:");
	    lblSoCccd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSoCccd.setBounds(235, 160, 133, 30);
	    panelCN.add(lblSoCccd);
	    
	    txtSoCccd = new JTextField();
	    txtSoCccd.setText("0");
	    txtSoCccd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoCccd.setBorder(null);
	    txtSoCccd.setBounds(341, 149, 301, 30);
	    panelCN.add(txtSoCccd);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(341, 180, 301, 10);
	    panelCN.add(jSeparator2);
	    
	    JLabel lblErrSoCccd = new JLabel();
	    lblErrSoCccd.setText("thông báo lỗi");
	    lblErrSoCccd.setForeground(new Color(204, 0, 0));
	    lblErrSoCccd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSoCccd.setBounds(341, 184, 200, 18);
	    panelCN.add(lblErrSoCccd);
	    
	    JLabel lblNgaySinh = new JLabel();
	    lblNgaySinh.setText("Ngày sinh:");
	    lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblNgaySinh.setBounds(764, 35, 96, 30);
	    panelCN.add(lblNgaySinh);
	    
	    JLabel lblGioiTinh = new JLabel();
	    lblGioiTinh.setText("Giới tính:");
	    lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblGioiTinh.setBounds(764, 97, 96, 30);
	    panelCN.add(lblGioiTinh);
	    
	    JLabel lblSdt = new JLabel();
	    lblSdt.setText("Số điện thoại:");
	    lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSdt.setBounds(235, 224, 133, 30);
	    panelCN.add(lblSdt);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(341, 244, 301, 10);
	    panelCN.add(jSeparator3);
	    
	    txtSdt = new JTextField();
	    txtSdt.setText("0");
	    txtSdt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSdt.setBorder(null);
	    txtSdt.setBounds(341, 214, 301, 30);
	    panelCN.add(txtSdt);
	    
	    JLabel lblErrSdt = new JLabel();
	    lblErrSdt.setText("thông báo lỗi");
	    lblErrSdt.setForeground(new Color(204, 0, 0));
	    lblErrSdt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSdt.setBounds(341, 248, 200, 18);
	    panelCN.add(lblErrSdt);
	    
	    JLabel lblErrTenCN = new JLabel();
	    lblErrTenCN.setText("lblErrTenCN");
	    lblErrTenCN.setForeground(new Color(204, 0, 0));
	    lblErrTenCN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenCN.setBounds(341, 122, 200, 17);
	    panelCN.add(lblErrTenCN);
	    
	    RoundedButton btnAnhCN = new RoundedButton("Thêm", UIManager.getColor("Button.light"), (Color) null);
	    btnAnhCN.setText("Ảnh công nhân");
	    btnAnhCN.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnAnhCN.setBackground(UIManager.getColor("CheckBox.background"));
	    btnAnhCN.setBounds(48, 275, 133, 40);
	    panelCN.add(btnAnhCN);
	    
	    JLabel lblEmail = new JLabel();
	    lblEmail.setText("Email:");
	    lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblEmail.setBounds(235, 294, 102, 30);
	    panelCN.add(lblEmail);
	    
	    txtEmail = new JTextField();
	    txtEmail.setText("txtEmail");
	    txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtEmail.setBorder(null);
	    txtEmail.setBounds(341, 277, 301, 36);
	    panelCN.add(txtEmail);
	    
	    JSeparator jSeparator1_1 = new JSeparator();
	    jSeparator1_1.setForeground(Color.BLACK);
	    jSeparator1_1.setBounds(341, 314, 301, 10);
	    panelCN.add(jSeparator1_1);
	    
	    JLabel lblDiaChi = new JLabel();
	    lblDiaChi.setText("Địa chỉ:");
	    lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblDiaChi.setBounds(764, 160, 102, 30);
	    panelCN.add(lblDiaChi);
	    
	    txtDiaChi = new JTextField();
	    txtDiaChi.setText("txtDiaChi");
	    txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtDiaChi.setBorder(null);
	    txtDiaChi.setBounds(881, 138, 271, 36);
	    panelCN.add(txtDiaChi);
	    
	    JSeparator jSeparator1_1_1 = new JSeparator();
	    jSeparator1_1_1.setForeground(Color.BLACK);
	    jSeparator1_1_1.setBounds(876, 180, 289, 10);
	    panelCN.add(jSeparator1_1_1);
	    
	    JLabel lblErrEmail = new JLabel();
	    lblErrEmail.setText("thông báo lỗi");
	    lblErrEmail.setForeground(new Color(204, 0, 0));
	    lblErrEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrEmail.setBounds(341, 316, 200, 18);
	    panelCN.add(lblErrEmail);
	    
	    JLabel lblErrDiaChi = new JLabel();
	    lblErrDiaChi.setText("thông báo lỗi");
	    lblErrDiaChi.setForeground(new Color(204, 0, 0));
	    lblErrDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrDiaChi.setBounds(886, 180, 200, 22);
	    panelCN.add(lblErrDiaChi);
	    
	    JDateChooser dcsNgaySinh = new JDateChooser();
	    dcsNgaySinh.setDateFormatString("yyyy-MM-dd");
	    dcsNgaySinh.setBounds(881, 23, 284, 34);
	    panelCN.add(dcsNgaySinh);
	    
	    JRadioButton rdoNam = new JRadioButton();
	    rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    rdoNam.setBackground(new Color(255, 255, 255));
	    rdoNam.setText("Nam");
	    rdoNam.setSelected(true);
	    rdoNam.setBounds(880, 100, 60, 23);
	    panelCN.add(rdoNam);
	    
	    JRadioButton rdoNu = new JRadioButton();
	    rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    rdoNu.setBackground(new Color(255, 255, 255));
	    rdoNu.setText("Nữ");
	    rdoNu.setBounds(972, 100, 55, 23);
	    panelCN.add(rdoNu);
	    
	    JLabel lblNgayVaoLam = new JLabel();
	    lblNgayVaoLam.setText("Ngày vào làm:");
	    lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblNgayVaoLam.setBounds(765, 289, 140, 40);
	    panelCN.add(lblNgayVaoLam);
	    
	    JDateChooser dcsNgayVaoLam = new JDateChooser();
	    dcsNgayVaoLam.setDateFormatString("yyyy-MM-dd");
	    dcsNgayVaoLam.setBounds(881, 290, 284, 34);
	    panelCN.add(dcsNgayVaoLam);
	    
	    JLabel lblToNhom = new JLabel();
	    lblToNhom.setText("Tổ nhóm:");
	    lblToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblToNhom.setBounds(764, 219, 130, 40);
	    panelCN.add(lblToNhom);
	    
	    JComboBox<String> cboToNhom = new JComboBox<String>();
	    cboToNhom.setBackground(Color.WHITE);
	    cboToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    cboToNhom.setBounds(881, 219, 284, 40);
	    panelCN.add(cboToNhom);
	    
	    JLabel lblErrNgayVaoLam = new JLabel();
	    lblErrNgayVaoLam.setText("đây là dòng thông báo lỗi");
	    lblErrNgayVaoLam.setForeground(new Color(204, 0, 0));
	    lblErrNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayVaoLam.setBounds(879, 326, 273, 18);
	    panelCN.add(lblErrNgayVaoLam);
	    
	    JLabel lblErrNgaySinh = new JLabel();
	    lblErrNgaySinh.setText("đây là dòng thông báo lỗi");
	    lblErrNgaySinh.setForeground(new Color(204, 0, 0));
	    lblErrNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgaySinh.setBounds(880, 64, 254, 18);
	    panelCN.add(lblErrNgaySinh);
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setBounds(21, 409, 1259, 65);
	    add(panelButton);
	    panelButton.setLayout(null);
	    panelButton.setBackground(Color.WHITE);
	    
	    RoundedButton btnThemNhieu = new RoundedButton("Thêm nhiều", new Color(50, 206, 50), (Color) null);
	    btnThemNhieu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
	    btnThemNhieu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnThemNhieu.setBounds(10, 14, 150, 40);
	    panelButton.add(btnThemNhieu);
	    
	    RoundedButton btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
	    btnThem.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
	    btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnThem.setBackground(new Color(64, 224, 208));
	    btnThem.setBounds(221, 14, 150, 40);
	    panelButton.add(btnThem);
	    
	    RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
	    btnXoa.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/xoa.png")));
	    btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnXoa.setBounds(430, 14, 150, 40);
	    panelButton.add(btnXoa);
	    
	    RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
	    btnCapNhat.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/capNhat.png")));
	    btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnCapNhat.setBounds(653, 14, 150, 40);
	    panelButton.add(btnCapNhat);
	    
	    RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
	    btnLuu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/luu.png")));
	    btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnLuu.setBounds(867, 14, 150, 40);
	    panelButton.add(btnLuu);
	    
	    RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
	    btnHuy.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/huy.png")));
	    btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnHuy.setBounds(1080, 14, 150, 40);
	    panelButton.add(btnHuy);
	    
	    tblCongNhan = new JTable();
	    tblCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    tblCongNhan.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    tblCongNhan.setRowHeight(20);

	    tblCongNhan.setModel(new DefaultTableModel(
	    		new Object [][] {
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null},
	                {null, null, null, null, null, null, null, null, null, null, null, null}
	            },
	            new String [] {
	                "STT", "Mã công nhân", "Họ và tên", "Số CCCD", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Ảnh đại diện", "Email", "Tổ/Nhóm", "Ngày vào làm"
	            }
	    ));
	    tblCongNhan.getColumnModel().getColumn(0).setPreferredWidth(33);
	    tblCongNhan.getColumnModel().getColumn(0).setMinWidth(33);
	    

	    scrCongNhan = new JScrollPane(tblCongNhan);
	    scrCongNhan.setBounds(10, 557, 1259, 194);
	    add(scrCongNhan);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        scrCongNhan.setVerticalScrollBar(scrollBar);
	    
	    JLabel lblDsCN = new JLabel("Danh sách công nhân:");
	    lblDsCN.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblDsCN.setBounds(42, 485, 186, 37);
	    add(lblDsCN);
	}
}
