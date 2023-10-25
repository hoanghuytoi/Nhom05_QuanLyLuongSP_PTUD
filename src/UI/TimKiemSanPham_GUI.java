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

/**
 * Hoàng Huy Tới
 */

public class TimKiemSanPham_GUI extends JPanel {
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtChatLieu;
	private JTextField txtKichThuoc;
	private JTextField txtSoCD;
	private JTextField txtYeuCau;
	private JTextField txtDonGia;
	
	private JScrollPane scrSanPham;
    private JTable tblSanPham;

	
	public TimKiemSanPham_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("TÌM KIẾM SẢN PHẨM");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(344, 22, 490, 50);
	    add(lblTieuDe);
	    
	    JPanel panelSP = new JPanel();
	    panelSP.setLayout(null);
	    panelSP.setBackground(Color.WHITE);
	    panelSP.setBounds(46, 92, 1164, 282);
	    add(panelSP);
	    
	    JLabel lblMaSanPham = new JLabel();
	    lblMaSanPham.setText("Mã sản phẩm:");
	    lblMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblMaSanPham.setBounds(81, 35, 125, 30);
	    panelSP.add(lblMaSanPham);
	    
	    txtMaSP = new JTextField();
	    txtMaSP.setText("txtMaSP");
	    txtMaSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaSP.setBorder(null);
	    txtMaSP.setBounds(216, 21, 318, 36);
	    panelSP.add(txtMaSP);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(216, 57, 318, 10);
	    panelSP.add(jSeparator);
	    
	    JLabel lblTenSP = new JLabel();
	    lblTenSP.setText("Tên sản phẩm:");
	    lblTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenSP.setBounds(81, 100, 125, 30);
	    panelSP.add(lblTenSP);
	    
	    txtTenSP = new JTextField();
	    txtTenSP.setText("txtTenSP");
	    txtTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenSP.setBorder(null);
	    txtTenSP.setBounds(216, 85, 318, 36);
	    panelSP.add(txtTenSP);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(216, 122, 318, 10);
	    panelSP.add(jSeparator1);
	    
	    JLabel lblSoLuongSP = new JLabel();
	    lblSoLuongSP.setText("Số lượng:");
	    lblSoLuongSP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblSoLuongSP.setBounds(81, 160, 125, 30);
	    panelSP.add(lblSoLuongSP);
	    
	    txtSoLuong = new JTextField();
	    txtSoLuong.setText("0");
	    txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoLuong.setBorder(null);
	    txtSoLuong.setBounds(216, 149, 318, 30);
	    panelSP.add(txtSoLuong);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(216, 180, 318, 10);
	    panelSP.add(jSeparator2);
	    
	    JLabel lblErrGiaTriHD = new JLabel();
	    lblErrGiaTriHD.setText("thông báo lỗi");
	    lblErrGiaTriHD.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD.setBounds(216, 184, 325, 18);
	    panelSP.add(lblErrGiaTriHD);
	    
	    JLabel lblChatLieu = new JLabel();
	    lblChatLieu.setText("Chất liệu:");
	    lblChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblChatLieu.setBounds(624, 35, 91, 30);
	    panelSP.add(lblChatLieu);
	    
	    txtChatLieu = new JTextField();
	    txtChatLieu.setText("txtChatLieu");
	    txtChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtChatLieu.setBorder(null);
	    txtChatLieu.setBounds(746, 21, 341, 30);
	    panelSP.add(txtChatLieu);
	    
	    JSeparator jSeparator4 = new JSeparator();
	    jSeparator4.setForeground(Color.BLACK);
	    jSeparator4.setBounds(746, 55, 341, 10);
	    panelSP.add(jSeparator4);
	    
	    JLabel lblKichThuoc = new JLabel();
	    lblKichThuoc.setText("Kích thước:");
	    lblKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblKichThuoc.setBounds(624, 97, 91, 30);
	    panelSP.add(lblKichThuoc);
	    
	    txtKichThuoc = new JTextField();
	    txtKichThuoc.setText("txtKichThuoc");
	    txtKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtKichThuoc.setBorder(null);
	    txtKichThuoc.setBounds(746, 91, 341, 30);
	    panelSP.add(txtKichThuoc);
	    
	    JSeparator jSeparator5 = new JSeparator();
	    jSeparator5.setForeground(Color.BLACK);
	    jSeparator5.setBounds(746, 122, 341, 10);
	    panelSP.add(jSeparator5);
	    
	    JLabel lblSoCD = new JLabel();
	    lblSoCD.setText("Số công đoạn:");
	    lblSoCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblSoCD.setBounds(624, 160, 102, 30);
	    panelSP.add(lblSoCD);
	    
	    txtSoCD = new JTextField();
	    txtSoCD.setText("txtSoCD");
	    txtSoCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtSoCD.setBorder(null);
	    txtSoCD.setBounds(746, 149, 341, 30);
	    panelSP.add(txtSoCD);
	    
	    JSeparator jSeparator6 = new JSeparator();
	    jSeparator6.setForeground(Color.BLACK);
	    jSeparator6.setBounds(745, 180, 342, 10);
	    panelSP.add(jSeparator6);
	    
	    JLabel lblYeuCau = new JLabel();
	    lblYeuCau.setText("Yêu cầu:");
	    lblYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblYeuCau.setBounds(624, 224, 69, 30);
	    panelSP.add(lblYeuCau);
	    
	    JLabel lblDonGia = new JLabel();
	    lblDonGia.setText("Đơn giá:");
	    lblDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblDonGia.setBounds(81, 224, 125, 30);
	    panelSP.add(lblDonGia);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(216, 244, 318, 10);
	    panelSP.add(jSeparator3);
	    
	    txtYeuCau = new JTextField();
	    txtYeuCau.setText("txtYeuCau");
	    txtYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtYeuCau.setBorder(null);
	    txtYeuCau.setBounds(746, 214, 341, 30);
	    panelSP.add(txtYeuCau);
	    
	    JSeparator jSeparator7 = new JSeparator();
	    jSeparator7.setForeground(Color.BLACK);
	    jSeparator7.setBounds(746, 244, 341, 10);
	    panelSP.add(jSeparator7);
	    
	    txtDonGia = new JTextField();
	    txtDonGia.setText("0");
	    txtDonGia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtDonGia.setBorder(null);
	    txtDonGia.setBounds(216, 214, 318, 30);
	    panelSP.add(txtDonGia);
	    
	    JLabel lblErrGiaTriHD_1 = new JLabel();
	    lblErrGiaTriHD_1.setText("thông báo lỗi");
	    lblErrGiaTriHD_1.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_1.setBounds(216, 252, 325, 18);
	    panelSP.add(lblErrGiaTriHD_1);
	    
	    JLabel lblErrTenSP = new JLabel();
	    lblErrTenSP.setText("lblErrTenSP");
	    lblErrTenSP.setForeground(new Color(204, 0, 0));
	    lblErrTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenSP.setBounds(216, 122, 325, 17);
	    panelSP.add(lblErrTenSP);
	    
	    JLabel lblErrGiaTriHD_2 = new JLabel();
	    lblErrGiaTriHD_2.setText("thông báo lỗi");
	    lblErrGiaTriHD_2.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_2.setBounds(746, 122, 284, 24);
	    panelSP.add(lblErrGiaTriHD_2);
	    
	    JLabel lblErrGiaTriHD_3 = new JLabel();
	    lblErrGiaTriHD_3.setText("thông báo lỗi");
	    lblErrGiaTriHD_3.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_3.setBounds(745, 180, 188, 24);
	    panelSP.add(lblErrGiaTriHD_3);
	    
	    JLabel lblErrGiaTriHD_4 = new JLabel();
	    lblErrGiaTriHD_4.setText("thông báo lỗi");
	    lblErrGiaTriHD_4.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD_4.setBounds(746, 57, 284, 18);
	    panelSP.add(lblErrGiaTriHD_4);
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setLayout(null);
	    panelButton.setBackground(Color.WHITE);
	    panelButton.setBounds(222, 372, 814, 65);
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
	    scrSanPham.setBounds(46, 500, 1225, 205);
	    add(scrSanPham);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        scrSanPham.setVerticalScrollBar(scrollBar);
	    
	    JLabel lblDsSP = new JLabel("Danh sách sản phẩm:");
	    lblDsSP.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblDsSP.setBounds(46, 461, 186, 28);
	    add(lblDsSP);
	
	}
}
