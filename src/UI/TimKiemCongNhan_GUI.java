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

public class TimKiemCongNhan_GUI extends JPanel {
	
	private JScrollPane scrCongNhan;
    private JTable tblCongNhan;
    private JTextField txtMaCN;
    private JTextField txtTenCN;
    private JTextField txtSoCccd;
    private JTextField txtSdt;
    private JTextField txtEmail;

	
	public TimKiemCongNhan_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("TÌM KIẾM CÔNG NHÂN");
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
	    scrCongNhan.setBounds(31, 515, 1232, 224);
	    add(scrCongNhan);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        scrCongNhan.setVerticalScrollBar(scrollBar);
	    
	    JLabel lblDsCN = new JLabel("Danh sách công nhân:");
	    lblDsCN.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblDsCN.setBounds(42, 485, 186, 37);
	    add(lblDsCN);
	    
	    JPanel panelCN = new JPanel();
	    panelCN.setLayout(null);
	    panelCN.setBackground(Color.WHITE);
	    panelCN.setBounds(-34, 52, 1190, 353);
	    add(panelCN);
	    
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
	    
	    JLabel lblErrEmail = new JLabel();
	    lblErrEmail.setText("thông báo lỗi");
	    lblErrEmail.setForeground(new Color(204, 0, 0));
	    lblErrEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrEmail.setBounds(341, 316, 200, 18);
	    panelCN.add(lblErrEmail);
	    
	    JDateChooser dcsNgaySinh = new JDateChooser();
	    dcsNgaySinh.setDateFormatString("yyyy-MM-dd");
	    dcsNgaySinh.setBounds(881, 23, 284, 34);
	    panelCN.add(dcsNgaySinh);
	    
	    JRadioButton rdoNam = new JRadioButton();
	    rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    rdoNam.setBackground(new Color(255, 255, 255));
	    rdoNam.setText("Nam");
	    rdoNam.setSelected(true);
	    rdoNam.setBounds(880, 100, 58, 23);
	    panelCN.add(rdoNam);
	    
	    JRadioButton rdoNu = new JRadioButton();
	    rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    rdoNu.setBackground(new Color(255, 255, 255));
	    rdoNu.setText("Nữ");
	    rdoNu.setBounds(972, 100, 58, 23);
	    panelCN.add(rdoNu);
	    
	    JLabel lblNgayVaoLam = new JLabel();
	    lblNgayVaoLam.setText("Ngày vào làm:");
	    lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblNgayVaoLam.setBounds(764, 219, 140, 40);
	    panelCN.add(lblNgayVaoLam);
	    
	    JDateChooser dcsNgayVaoLam = new JDateChooser();
	    dcsNgayVaoLam.setDateFormatString("yyyy-MM-dd");
	    dcsNgayVaoLam.setBounds(881, 220, 284, 34);
	    panelCN.add(dcsNgayVaoLam);
	    
	    JLabel lblToNhom = new JLabel();
	    lblToNhom.setText("Tổ nhóm:");
	    lblToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblToNhom.setBounds(764, 155, 130, 40);
	    panelCN.add(lblToNhom);
	    
	    JComboBox<String> cboToNhom = new JComboBox<String>();
	    cboToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    cboToNhom.setBackground(Color.WHITE);
	    cboToNhom.setBounds(881, 146, 284, 40);
	    panelCN.add(cboToNhom);
	    
	    JLabel lblErrNgayVaoLam = new JLabel();
	    lblErrNgayVaoLam.setText("đây là dòng thông báo lỗi");
	    lblErrNgayVaoLam.setForeground(new Color(204, 0, 0));
	    lblErrNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayVaoLam.setBounds(881, 259, 271, 18);
	    panelCN.add(lblErrNgayVaoLam);
	    
	    JLabel lblErrNgaySinh = new JLabel();
	    lblErrNgaySinh.setText("đây là dòng thông báo lỗi");
	    lblErrNgaySinh.setForeground(new Color(204, 0, 0));
	    lblErrNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgaySinh.setBounds(880, 64, 254, 18);
	    panelCN.add(lblErrNgaySinh);
	
	}
}
