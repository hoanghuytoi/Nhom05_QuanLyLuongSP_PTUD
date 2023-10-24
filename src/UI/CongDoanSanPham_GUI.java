package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Custom_UI.ScrollBarCustom;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import Custom_UI.RoundedButton;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

/**
 * Hoàng Huy Tới
 */

public class CongDoanSanPham_GUI extends JPanel {
	private JScrollPane scrSanPham;
    private JTable tblSanPham;
    private JScrollPane scrCDSanPham;
    private JTable tblCDSanPham;
    
    private JTextField txtMaCD;
    private JTextField txtTenCD;
    private JTextField txtThuTu;
    private JTextField txtSoLuongCan;
    
	
	public CongDoanSanPham_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ CÔNG ĐOẠN SẢN PHẨM");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(344, 22, 490, 50);
	    add(lblTieuDe);
	    
	    JLabel lblDsSP = new JLabel("Danh sách sản phẩm:");
	    lblDsSP.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/muiTen.png")));
	    lblDsSP.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblDsSP.setBounds(77, 126, 206, 41);
	    add(lblDsSP);
	    
	    tblSanPham = new JTable();
        tblSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tblSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    tblSanPham.setRowHeight(25);

	    tblSanPham.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    		{null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "S\u1ED1 c\u00F4ng \u0111o\u1EA1n", "\u0110\u01A1n gi\u00E1"
	    	}
	    ));
	    tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(35);
	    tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(77);
	    tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(82);
	    tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(55);
	    tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(77);

	    scrSanPham = new JScrollPane(tblSanPham);
	    scrSanPham.setBounds(77, 178, 677, 227);
	    add(scrSanPham);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrSanPham.setVerticalScrollBar(scrollBar);
        
        JPanel panelButton = new JPanel();
        panelButton.setLayout(null);
        panelButton.setBackground(Color.WHITE);
        panelButton.setBounds(22, 440, 1258, 60);
        add(panelButton);
        
        RoundedButton btnThemNhieu = new RoundedButton("Thêm nhiều", new Color(50, 206, 50), (Color) null);
        btnThemNhieu.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/them.png")));
        btnThemNhieu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThemNhieu.setBounds(10, 14, 150, 40);
        panelButton.add(btnThemNhieu);
        
        RoundedButton btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
        btnThem.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/them.png")));
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThem.setBounds(221, 14, 150, 40);
        panelButton.add(btnThem);
        
        RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
        btnXoa.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/xoa.png")));
        btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnXoa.setBounds(430, 14, 150, 40);
        panelButton.add(btnXoa);
        
        RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
        btnCapNhat.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/capNhat.png")));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCapNhat.setBounds(653, 14, 150, 40);
        panelButton.add(btnCapNhat);
        
        RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
        btnLuu.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/luu.png")));
        btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnLuu.setBounds(867, 14, 150, 40);
        panelButton.add(btnLuu);
        
        RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
        btnHuy.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/huy.png")));
        btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnHuy.setBounds(1080, 14, 150, 40);
        panelButton.add(btnHuy);
        
        JPanel panelCDSP = new JPanel();
        panelCDSP.setBackground(Color.WHITE);
        panelCDSP.setBounds(854, 81, 387, 358);
        add(panelCDSP);
        panelCDSP.setLayout(null);
        
        JLabel lblMaCD = new JLabel();
        lblMaCD.setBounds(24, 33, 100, 20);
        lblMaCD.setText("Mã công đoạn:");
        lblMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        panelCDSP.add(lblMaCD);
        
        txtMaCD = new JTextField();
        txtMaCD.setText("txtMaCD");
        txtMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaCD.setBorder(null);
        txtMaCD.setBounds(134, 11, 224, 36);
        panelCDSP.add(txtMaCD);
        
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.BLACK);
        jSeparator.setBounds(134, 50, 224, 10);
        panelCDSP.add(jSeparator);
        
        JLabel lblTenCD = new JLabel();
        lblTenCD.setText("Tên công đoạn:");
        lblTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblTenCD.setBounds(22, 90, 102, 30);
        panelCDSP.add(lblTenCD);
        
        txtTenCD = new JTextField();
        txtTenCD.setText("txtTenCD");
        txtTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtTenCD.setBorder(null);
        txtTenCD.setBounds(134, 71, 224, 36);
        panelCDSP.add(txtTenCD);
        
        JLabel lblErrTenCD = new JLabel();
        lblErrTenCD.setText("lblErrTenCD");
        lblErrTenCD.setForeground(new Color(204, 0, 0));
        lblErrTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrTenCD.setBounds(134, 119, 200, 17);
        panelCDSP.add(lblErrTenCD);
        
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setForeground(Color.BLACK);
        jSeparator1.setBounds(134, 110, 224, 10);
        panelCDSP.add(jSeparator1);
        
        JLabel lblSoLuongCan = new JLabel();
        lblSoLuongCan.setText("Số lượng cần:");
        lblSoLuongCan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblSoLuongCan.setBounds(24, 234, 100, 30);
        panelCDSP.add(lblSoLuongCan);
        
        txtThuTu = new JTextField();
        txtThuTu.setText("0");
        txtThuTu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtThuTu.setBorder(null);
        txtThuTu.setBounds(134, 147, 224, 36);
        panelCDSP.add(txtThuTu);
        
        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setForeground(Color.BLACK);
        jSeparator2.setBounds(134, 184, 224, 10);
        panelCDSP.add(jSeparator2);
        
        JLabel lblErrThuTu = new JLabel();
        lblErrThuTu.setText("thông báo lỗi");
        lblErrThuTu.setForeground(new Color(204, 0, 0));
        lblErrThuTu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrThuTu.setBounds(134, 188, 200, 24);
        panelCDSP.add(lblErrThuTu);
        
        JLabel lblThuTu = new JLabel();
        lblThuTu.setText("Thứ tự:");
        lblThuTu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblThuTu.setBounds(24, 164, 100, 30);
        panelCDSP.add(lblThuTu);
        
        txtSoLuongCan = new JTextField();
        txtSoLuongCan.setText("0");
        txtSoLuongCan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSoLuongCan.setBorder(null);
        txtSoLuongCan.setBounds(134, 223, 224, 30);
        panelCDSP.add(txtSoLuongCan);
        
        JSeparator jSeparator2_1 = new JSeparator();
        jSeparator2_1.setForeground(Color.BLACK);
        jSeparator2_1.setBounds(134, 254, 224, 10);
        panelCDSP.add(jSeparator2_1);
        
        JDateChooser dcsThoiHan = new JDateChooser();
        dcsThoiHan.setDateFormatString("yyyy-MM-dd");
        dcsThoiHan.setBounds(134, 299, 224, 30);
        panelCDSP.add(dcsThoiHan);
        
        JLabel lblErrSoLuongCan = new JLabel();
        lblErrSoLuongCan.setText("thông báo lỗi");
        lblErrSoLuongCan.setForeground(new Color(204, 0, 0));
        lblErrSoLuongCan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrSoLuongCan.setBounds(134, 254, 200, 30);
        panelCDSP.add(lblErrSoLuongCan);
        
        JLabel lblThoiHan = new JLabel();
        lblThoiHan.setText("Thời hạn:");
        lblThoiHan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblThoiHan.setBounds(22, 299, 100, 30);
        panelCDSP.add(lblThoiHan);
        
        JLabel lblErrThoiHan = new JLabel();
        lblErrThoiHan.setText("thông báo lỗi");
        lblErrThoiHan.setForeground(new Color(204, 0, 0));
        lblErrThoiHan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrThoiHan.setBounds(134, 328, 200, 30);
        panelCDSP.add(lblErrThoiHan);
        
        JLabel lblThongTinCD = new JLabel("Thông tin công đoạn sản phẩm");
        lblThongTinCD.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblThongTinCD.setBounds(940, 56, 214, 29);
        add(lblThongTinCD);
        
        JLabel lblDsCDSP = new JLabel("Danh sách công đoạn sản phẩm:");
        lblDsCDSP.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDsCDSP.setBounds(77, 500, 262, 41);
	    add(lblDsCDSP);
	    
	    tblCDSanPham = new JTable();
        tblCDSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tblCDSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    tblCDSanPham.setRowHeight(30);

	    tblCDSanPham.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "Mã công đoạn", "Tên công đoạn", "Thứ tự công đoạn", "Số lượng cần", "Thời hạn", "Mức độ hoàn thành"
	    	}
	    ));
	    tblCDSanPham.getColumnModel().getColumn(0).setPreferredWidth(35);
	    tblCDSanPham.getColumnModel().getColumn(1).setPreferredWidth(77);
	    tblCDSanPham.getColumnModel().getColumn(2).setPreferredWidth(82);
	    tblCDSanPham.getColumnModel().getColumn(3).setPreferredWidth(55);
	    tblCDSanPham.getColumnModel().getColumn(4).setPreferredWidth(77);

	    scrCDSanPham = new JScrollPane(tblCDSanPham);
	    scrCDSanPham.setBounds(77, 537, 1124, 202);
	    add(scrCDSanPham);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrCDSanPham.setVerticalScrollBar(scrollBar1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/muitenNgang.png")));
        lblNewLabel.setBounds(783, 270, 50, 41);
        add(lblNewLabel);
	    
	}
}
