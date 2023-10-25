package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import Custom_UI.ScrollBarCustom;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Component;
import Custom_UI.RoundedButton;
import java.awt.SystemColor;

/**
 * Hoàng Huy Tới
 */

public class SanPham_GUI extends JPanel {
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	
	private JScrollPane scrHopDong;
    private JTable tblHopDong;
    private JTextField txtChatLieu;
    private JTextField txtKichThuoc;
    private JTextField txtSoCD;
    private JTextField txtYeuCau;
    private JTextField txtDonGia;
    
    private JScrollPane scrSanPham;
    private JTable tblSanPham;

	
	public SanPham_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ SẢN PHẨM");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(505, 11, 368, 50);
	    add(lblTieuDe);
	    
	    JPanel panelSP = new JPanel();
	    panelSP.setLayout(null);
	    panelSP.setBackground(Color.WHITE);
	    panelSP.setBounds(413, 72, 877, 307);
	    add(panelSP);
	    
	    JLabel lblAnhHD = new JLabel();
	    lblAnhHD.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/sanPham/giay1.png")));
	    lblAnhHD.setBounds(10, 35, 200, 179);
	    panelSP.add(lblAnhHD);
	    
	    JLabel lblMaSanPham = new JLabel();
	    lblMaSanPham.setText("Mã sản phẩm:");
	    lblMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblMaSanPham.setBounds(235, 35, 96, 30);
	    panelSP.add(lblMaSanPham);
	    
	    txtMaSP = new JTextField();
	    txtMaSP.setText("txtMaSP");
	    txtMaSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaSP.setBorder(null);
	    txtMaSP.setBounds(341, 21, 193, 36);
	    panelSP.add(txtMaSP);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(341, 57, 193, 10);
	    panelSP.add(jSeparator);
	    
	    JLabel lblTenSP = new JLabel();
	    lblTenSP.setText("Tên sản phẩm:");
	    lblTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblTenSP.setBounds(235, 100, 102, 30);
	    panelSP.add(lblTenSP);
	    
	    txtTenSP = new JTextField();
	    txtTenSP.setText("txtTenSP");
	    txtTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenSP.setBorder(null);
	    txtTenSP.setBounds(341, 85, 193, 36);
	    panelSP.add(txtTenSP);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(341, 122, 193, 10);
	    panelSP.add(jSeparator1);
	    
	    JLabel lblSoLuongSP = new JLabel();
	    lblSoLuongSP.setText("Số lượng:");
	    lblSoLuongSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSoLuongSP.setBounds(235, 160, 133, 30);
	    panelSP.add(lblSoLuongSP);
	    
	    txtSoLuong = new JTextField();
	    txtSoLuong.setText("0");
	    txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoLuong.setBorder(null);
	    txtSoLuong.setBounds(341, 149, 193, 30);
	    panelSP.add(txtSoLuong);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(341, 180, 193, 10);
	    panelSP.add(jSeparator2);
	    
	    JLabel lblErrGiaTriHD = new JLabel();
	    lblErrGiaTriHD.setText("thông báo lỗi");
	    lblErrGiaTriHD.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD.setBounds(341, 184, 200, 18);
	    panelSP.add(lblErrGiaTriHD);
	    
	    JLabel lblChatLieu = new JLabel();
	    lblChatLieu.setText("Chất liệu:");
	    lblChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblChatLieu.setBounds(580, 35, 89, 30);
	    panelSP.add(lblChatLieu);
	    
	    txtChatLieu = new JTextField();
	    txtChatLieu.setText("txtChatLieu");
	    txtChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtChatLieu.setBorder(null);
	    txtChatLieu.setBounds(685, 21, 162, 30);
	    panelSP.add(txtChatLieu);
	    
	    JSeparator jSeparator4 = new JSeparator();
	    jSeparator4.setForeground(Color.BLACK);
	    jSeparator4.setBounds(679, 55, 168, 10);
	    panelSP.add(jSeparator4);
	    
	    JLabel lblKichThuoc = new JLabel();
	    lblKichThuoc.setText("Kích thước:");
	    lblKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblKichThuoc.setBounds(580, 97, 98, 30);
	    panelSP.add(lblKichThuoc);
	    
	    txtKichThuoc = new JTextField();
	    txtKichThuoc.setText("txtKichThuoc");
	    txtKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtKichThuoc.setBorder(null);
	    txtKichThuoc.setBounds(685, 91, 162, 30);
	    panelSP.add(txtKichThuoc);
	    
	    JSeparator jSeparator5 = new JSeparator();
	    jSeparator5.setForeground(Color.BLACK);
	    jSeparator5.setBounds(685, 122, 162, 10);
	    panelSP.add(jSeparator5);
	    
	    JLabel lblSoCD = new JLabel();
	    lblSoCD.setText("Số công đoạn:");
	    lblSoCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblSoCD.setBounds(580, 160, 113, 30);
	    panelSP.add(lblSoCD);
	    
	    txtSoCD = new JTextField();
	    txtSoCD.setText("txtSoCD");
	    txtSoCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtSoCD.setBorder(null);
	    txtSoCD.setBounds(686, 149, 149, 30);
	    panelSP.add(txtSoCD);
	    
	    JSeparator jSeparator6 = new JSeparator();
	    jSeparator6.setForeground(Color.BLACK);
	    jSeparator6.setBounds(686, 180, 162, 10);
	    panelSP.add(jSeparator6);
	    
	    JLabel lblYeuCau = new JLabel();
	    lblYeuCau.setText("Yêu cầu:");
	    lblYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblYeuCau.setBounds(580, 224, 113, 30);
	    panelSP.add(lblYeuCau);
	    
	    JLabel lblDonGia = new JLabel();
	    lblDonGia.setText("Đơn giá:");
	    lblDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblDonGia.setBounds(235, 224, 133, 30);
	    panelSP.add(lblDonGia);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(341, 244, 193, 10);
	    panelSP.add(jSeparator3);
	    
	    txtYeuCau = new JTextField();
	    txtYeuCau.setText("txtYeuCau");
	    txtYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtYeuCau.setBorder(null);
	    txtYeuCau.setBounds(685, 214, 162, 30);
	    panelSP.add(txtYeuCau);
	    
	    JSeparator jSeparator7 = new JSeparator();
	    jSeparator7.setForeground(Color.BLACK);
	    jSeparator7.setBounds(685, 244, 162, 10);
	    panelSP.add(jSeparator7);
	    
	    txtDonGia = new JTextField();
	    txtDonGia.setText("0");
	    txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtDonGia.setBorder(null);
	    txtDonGia.setBounds(341, 214, 193, 30);
	    panelSP.add(txtDonGia);
	    
	    JLabel lblErrGiaTriHD_1 = new JLabel();
	    lblErrGiaTriHD_1.setText("thông báo lỗi");
	    lblErrGiaTriHD_1.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_1.setBounds(341, 252, 200, 18);
	    panelSP.add(lblErrGiaTriHD_1);
	    
	    JLabel lblErrTenSP = new JLabel();
	    lblErrTenSP.setText("lblErrTenSP");
	    lblErrTenSP.setForeground(new Color(204, 0, 0));
	    lblErrTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenSP.setBounds(341, 122, 200, 17);
	    panelSP.add(lblErrTenSP);
	    
	    RoundedButton btnAnhSP = new RoundedButton("Thêm", Color.GRAY, (Color) null);
	    btnAnhSP.setBackground(Color.GRAY);
	    btnAnhSP.setText("Ảnh sản phẩm");
	    btnAnhSP.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnAnhSP.setBounds(39, 209, 133, 40);
	    panelSP.add(btnAnhSP);
	    
	    JLabel lblErrGiaTriHD_2 = new JLabel();
	    lblErrGiaTriHD_2.setText("thông báo lỗi");
	    lblErrGiaTriHD_2.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_2.setBounds(685, 122, 181, 24);
	    panelSP.add(lblErrGiaTriHD_2);
	    
	    JLabel lblErrGiaTriHD_3 = new JLabel();
	    lblErrGiaTriHD_3.setText("thông báo lỗi");
	    lblErrGiaTriHD_3.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_3.setBounds(685, 180, 181, 24);
	    panelSP.add(lblErrGiaTriHD_3);
	    
	    JLabel lblErrGiaTriHD_4 = new JLabel();
	    lblErrGiaTriHD_4.setText("thông báo lỗi");
	    lblErrGiaTriHD_4.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_4.setBounds(679, 57, 187, 18);
	    panelSP.add(lblErrGiaTriHD_4);
	    
	    tblHopDong = new JTable();
	    tblHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    tblHopDong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    
	    tblHopDong.setRowHeight(20);
	    
	    tblHopDong.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    		{null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 h\u1EE3p \u0111\u1ED3ng", "T\u00EAn h\u1EE3p \u0111\u1ED3ng", "T\u00EAn kh\u00E1ch h\u00E0ng"
	    	}
	    ));
	    tblHopDong.getColumnModel().getColumn(0).setPreferredWidth(40);
	    tblHopDong.getColumnModel().getColumn(0).setMinWidth(20);
	    tblHopDong.getColumnModel().getColumn(0).setMaxWidth(40);
	    tblHopDong.getColumnModel().getColumn(1).setPreferredWidth(72);
	    tblHopDong.getColumnModel().getColumn(2).setPreferredWidth(76);
	    tblHopDong.getColumnModel().getColumn(3).setPreferredWidth(86);

	    scrHopDong = new JScrollPane(tblHopDong);
	    scrHopDong.setBounds(10, 124, 394, 206);
	    add(scrHopDong);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrHopDong.setVerticalScrollBar(scrollBar);
        
        JLabel lblDsHD = new JLabel("Danh sách hợp đồng:");
        lblDsHD.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/icon/muiTen.png")));
        lblDsHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDsHD.setBounds(29, 72, 206, 41);
        add(lblDsHD);
        
        JPanel panelButton = new JPanel();
        panelButton.setLayout(null);
        panelButton.setBackground(Color.WHITE);
        panelButton.setBounds(10, 382, 1280, 65);
        add(panelButton);
        
        RoundedButton btnThemNhieu = new RoundedButton("Thêm nhiều", new Color(50, 206, 50), (Color) null);
        btnThemNhieu.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/icon/them.png")));
        btnThemNhieu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThemNhieu.setBounds(10, 14, 150, 40);
        panelButton.add(btnThemNhieu);
        
        RoundedButton btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
        btnThem.setBackground(new Color(64, 224, 208));
        btnThem.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/icon/them.png")));
        btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThem.setBounds(221, 14, 150, 40);
        panelButton.add(btnThem);
        
        RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
        btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnXoa.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/xoa.png")));
        btnXoa.setBounds(430, 14, 150, 40);
        panelButton.add(btnXoa);
        
        RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnCapNhat.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/capNhat.png")));
        btnCapNhat.setBounds(653, 14, 150, 40);
        panelButton.add(btnCapNhat);
        
        RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
        btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnLuu.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/luu.png")));
        btnLuu.setBounds(867, 14, 150, 40);
        panelButton.add(btnLuu);
        
        RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
	    btnHuy.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/huy.png")));
        btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnHuy.setBounds(1080, 14, 150, 40);
        panelButton.add(btnHuy);
        
        tblSanPham = new JTable();
        tblSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tblSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        tblSanPham.setRowHeight(30);

	    tblSanPham.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m", "Ch\u1EA5t li\u1EC7u", "K\u00EDch th\u01B0\u1EDBc", "S\u1ED1 c\u00F4ng \u0111o\u1EA1n", "\u0110\u01A1n gi\u00E1"
	    	}
	    ));
	    tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(40);
	    tblSanPham.getColumnModel().getColumn(0).setMinWidth(40);
	    

	    scrSanPham = new JScrollPane(tblSanPham);
	    scrSanPham.setBounds(39, 523, 1225, 194);
	    add(scrSanPham);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrSanPham.setVerticalScrollBar(scrollBar1);
	    
	    JLabel lblDsSP = new JLabel("Danh sách sản phẩm:");
	    lblDsSP.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblDsSP.setBounds(39, 471, 186, 28);
	    add(lblDsSP);
        
        
	    
	}
}
