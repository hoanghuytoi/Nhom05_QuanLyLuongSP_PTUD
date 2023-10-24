package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;

public class HopDong_GUI extends JPanel {
	private JTextField txtMaHD;
	private JTextField txtTenHD;
	private JTextField txtGiaTriHD;
	private JTextField txtSoTienCoc;
	private JTextField txtTenKH;
	private JTextField txtNguoiDD;
	
	private JScrollPane scrHopDong;
    private JTable tblHopDong;
    

	public HopDong_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
	    setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ HỢP ĐỒNG ");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(501, 0, 368, 50);
	    add(lblTieuDe);
	    
	    JPanel panelHD = new JPanel();
	    panelHD.setBackground(Color.WHITE);
	    panelHD.setBounds(10, 23, 1280, 355);
	    add(panelHD);
	    panelHD.setLayout(null);
	    
	    JLabel lblAnhHD = new JLabel();
	    lblAnhHD.setBounds(34, 83, 200, 173);
	    panelHD.add(lblAnhHD);
	    lblAnhHD.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/hopDong.PNG")));
	    
	    JLabel lblMaHopDong = new JLabel();
	    lblMaHopDong.setBounds(272, 35, 111, 30);
	    panelHD.add(lblMaHopDong);
	    lblMaHopDong.setText("Mã hợp đồng:");
	    lblMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    
	    txtMaHD = new JTextField();
	    txtMaHD.setBounds(417, 21, 224, 36);
	    panelHD.add(txtMaHD);
	    txtMaHD.setText("txtMaHD");
	    txtMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaHD.setBorder(null);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(417, 57, 224, 10);
	    panelHD.add(jSeparator);
	    
	    JLabel lblTenHD = new JLabel();
	    lblTenHD.setText("Tên hợp đồng:");
	    lblTenHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenHD.setBounds(272, 100, 111, 30);
	    panelHD.add(lblTenHD);
	    
	    txtTenHD = new JTextField();
	    txtTenHD.setText("txtTenHD");
	    txtTenHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenHD.setBorder(null);
	    txtTenHD.setBounds(417, 85, 224, 36);
	    panelHD.add(txtTenHD);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(417, 122, 224, 10);
	    panelHD.add(jSeparator1);
	    
	    JLabel lblGiaTriHD = new JLabel();
	    lblGiaTriHD.setText("Giá trị hợp đồng:");
	    lblGiaTriHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblGiaTriHD.setBounds(272, 160, 135, 30);
	    panelHD.add(lblGiaTriHD);
	    
	    txtGiaTriHD = new JTextField();
	    txtGiaTriHD.setText("0");
	    txtGiaTriHD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtGiaTriHD.setBorder(null);
	    txtGiaTriHD.setBounds(417, 149, 224, 30);
	    panelHD.add(txtGiaTriHD);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(417, 180, 224, 10);
	    panelHD.add(jSeparator2);
	    
	    JLabel lblTienCoc = new JLabel();
	    lblTienCoc.setText("Số tiền cọc:");
	    lblTienCoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTienCoc.setBounds(272, 226, 111, 30);
	    panelHD.add(lblTienCoc);
	    
	    txtSoTienCoc = new JTextField();
	    txtSoTienCoc.setText("0");
	    txtSoTienCoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoTienCoc.setBorder(null);
	    txtSoTienCoc.setBounds(417, 213, 224, 30);
	    panelHD.add(txtSoTienCoc);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(417, 246, 224, 10);
	    panelHD.add(jSeparator3);
	    
	    JLabel lblTenKH = new JLabel();
	    lblTenKH.setText("Tên khách hàng:");
	    lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenKH.setBounds(785, 35, 146, 30);
	    panelHD.add(lblTenKH);
	    
	    JLabel lblNguoiDaiDien = new JLabel();
	    lblNguoiDaiDien.setText("Người đại diện:");
	    lblNguoiDaiDien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblNguoiDaiDien.setBounds(785, 100, 146, 30);
	    panelHD.add(lblNguoiDaiDien);
	    
	    JLabel lblNgayBatDau = new JLabel();
	    lblNgayBatDau.setText("Ngày bắt đầu:");
	    lblNgayBatDau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblNgayBatDau.setBounds(785, 160, 170, 30);
	    panelHD.add(lblNgayBatDau);
	    
	    JLabel lblNgayKT = new JLabel();
	    lblNgayKT.setText("Ngày kết thúc:");
	    lblNgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblNgayKT.setBounds(785, 226, 110, 30);
	    panelHD.add(lblNgayKT);
	    
	    txtTenKH = new JTextField();
	    txtTenKH.setText("txtTenKH");
	    txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenKH.setBorder(null);
	    txtTenKH.setBounds(956, 21, 224, 36);
	    panelHD.add(txtTenKH);
	    
	    JSeparator jSeparator4 = new JSeparator();
	    jSeparator4.setForeground(Color.BLACK);
	    jSeparator4.setBounds(956, 57, 224, 17);
	    panelHD.add(jSeparator4);
	    
	    txtNguoiDD = new JTextField();
	    txtNguoiDD.setText("txtNguoiDD");
	    txtNguoiDD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtNguoiDD.setBorder(null);
	    txtNguoiDD.setBounds(956, 85, 224, 36);
	    panelHD.add(txtNguoiDD);
	    
	    JSeparator jSeparator5 = new JSeparator();
	    jSeparator5.setForeground(Color.BLACK);
	    jSeparator5.setBounds(956, 122, 224, 10);
	    panelHD.add(jSeparator5);
	    
	    JDateChooser dcsNgayBD = new JDateChooser();
	    dcsNgayBD.setDateFormatString("yyyy-MM-dd");
	    dcsNgayBD.setBounds(956, 149, 224, 30);
	    panelHD.add(dcsNgayBD);
	    
	    JDateChooser dcsNgayKT = new JDateChooser();
	    dcsNgayKT.setDateFormatString("yyyy-MM-dd");
	    dcsNgayKT.setBounds(956, 213, 224, 30);
	    panelHD.add(dcsNgayKT);
	    
	    JLabel lblErrTenKhachHang = new JLabel();
	    lblErrTenKhachHang.setText("lblErrTenKhachHang");
	    lblErrTenKhachHang.setForeground(new Color(204, 0, 0));
	    lblErrTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenKhachHang.setBounds(956, 64, 200, 17);
	    panelHD.add(lblErrTenKhachHang);
	    
	    JLabel lblErrGiaTriHD = new JLabel();
	    lblErrGiaTriHD.setText("thông báo lỗi");
	    lblErrGiaTriHD.setForeground(new Color(204, 0, 0));
	    lblErrGiaTriHD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrGiaTriHD.setBounds(417, 184, 200, 18);
	    panelHD.add(lblErrGiaTriHD);
	    
	    JLabel lblErrNgayBD = new JLabel();
	    lblErrNgayBD.setText("thông báo lỗi");
	    lblErrNgayBD.setForeground(new Color(204, 0, 0));
	    lblErrNgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayBD.setBounds(956, 185, 200, 17);
	    panelHD.add(lblErrNgayBD);
	    
	    JLabel lblErrNgayKT = new JLabel();
	    lblErrNgayKT.setText("thông báo lỗi");
	    lblErrNgayKT.setForeground(new Color(204, 0, 0));
	    lblErrNgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayKT.setBounds(956, 251, 200, 18);
	    panelHD.add(lblErrNgayKT);
	    
	    JLabel lblThoaThuan = new JLabel();
	    lblThoaThuan.setText("Thỏa thuận:");
	    lblThoaThuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblThoaThuan.setBounds(272, 284, 135, 30);
	    panelHD.add(lblThoaThuan);
	    
	    JLabel lblErrTienCoc = new JLabel();
	    lblErrTienCoc.setText("thông báo lỗi");
	    lblErrTienCoc.setForeground(new Color(204, 0, 0));
	    lblErrTienCoc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTienCoc.setBounds(417, 253, 200, 18);
	    panelHD.add(lblErrTienCoc);
	    
	    ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.BLACK);
        
	    JScrollPane jScrollPane = new JScrollPane();
	    jScrollPane.setAutoscrolls(true);
	    jScrollPane.setBounds(417, 280, 763, 52);
	    jScrollPane.setVerticalScrollBar(scrollBar);
	    panelHD.add(jScrollPane);
	    
	    JTextArea txtAreaThoaThuan = new JTextArea();
	    jScrollPane.setViewportView(txtAreaThoaThuan);
	    txtAreaThoaThuan.setBackground(Color.WHITE);
	    txtAreaThoaThuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtAreaThoaThuan.setRows(5);
	    txtAreaThoaThuan.setColumns(20);
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setBackground(Color.WHITE);
	    panelButton.setBounds(10, 376, 1280, 65);
	    add(panelButton);
	    panelButton.setLayout(null);

	    // Tạo một RoundedButton thay vì JButton
	    RoundedButton btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, null);
	    btnThem.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/them.png")));
	    btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnThem.setBounds(10, 14, 170, 40);
	    panelButton.add(btnThem);

	    // Tạo và thêm nút Xóa
	    RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), null);
	    btnXoa.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/xoa.png")));
	    btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnXoa.setBounds(219, 14, 170, 40);
	    panelButton.add(btnXoa);

	    // Tạo và thêm nút Cập nhật
	    RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), null);
	    btnCapNhat.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/capNhat.png")));
	    btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnCapNhat.setBounds(439, 14, 170, 40);
	    panelButton.add(btnCapNhat);

	    // Tạo và thêm nút Lưu
	    RoundedButton btnLuu = new RoundedButton("Lưu", new Color(192, 192, 192), null);
	    btnLuu.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/luu.png")));
	    btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnLuu.setBounds(662, 14, 170, 40);
	    panelButton.add(btnLuu);

	    // Tạo và thêm nút Hủy
	    RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), null);
	    btnHuy.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/huy.png")));
	    btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnHuy.setBounds(880, 14, 170, 40);
	    panelButton.add(btnHuy);

	    // Tạo và thêm nút In hợp đồng
	    RoundedButton btnInHD = new RoundedButton("In hợp đồng", new Color(211, 211, 211), null);
	    btnInHD.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/in.png")));
	    btnInHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnInHD.setBounds(1100, 14, 150, 40);
	    panelButton.add(btnInHD);
	    
	    tblHopDong = new JTable();
	    tblHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    tblHopDong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    
	    tblHopDong.setRowHeight(30);
	    
	    DefaultTableModel tableModel = new DefaultTableModel(
	    		new Object[][] {
	    			{null, null, null, null, null, null, null, null},
	    			{null, null, null, null, null, null, null, null},
	    			{null, null, null, null, null, null, null, null},
	    			{null, null, null, null, null, null, null, null}
	    		},
	    		new String[] {
	    				"STT", "Mã hợp đồng", "Tên hợp đồng", "Tên khách hàng", "Giá trị hợp đồng", "Số tiền cọc", "Ngày bắt đầu", "Ngày kết thúc"
	    		}
	    		);

	    tblHopDong.setModel(new DefaultTableModel(
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
	    		"STT", "M\u00E3 h\u1EE3p \u0111\u1ED3ng", "T\u00EAn h\u1EE3p \u0111\u1ED3ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "Gi\u00E1 tr\u1ECB h\u1EE3p \u0111\u1ED3ng", "S\u1ED1 ti\u1EC1n c\u1ECDc", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc"
	    	}
	    )); 
	    

	    scrHopDong = new JScrollPane(tblHopDong);
	    scrHopDong.setBounds(39, 523, 1225, 194);
	    add(scrHopDong);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrHopDong.setVerticalScrollBar(scrollBar1);
	    
	    JLabel lblDsHD = new JLabel("Danh sách hợp đồng:");
	    lblDsHD.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblDsHD.setBounds(39, 475, 243, 37);
	    add(lblDsHD);
	    
	    
	}
}
