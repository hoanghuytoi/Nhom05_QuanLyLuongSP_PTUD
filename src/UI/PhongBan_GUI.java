package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;

import java.awt.SystemColor;

public class PhongBan_GUI extends JPanel {
	private JTextField txtPhongBan;
	private JTextField txtTenPhongBan;
	private JTextField txtSoLuongNV;
	
	private JScrollPane scrHopDong;
    private JTable tblHopDong;
	
	
	public PhongBan_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JPanel panelPB = new JPanel();
	    panelPB.setBackground(Color.WHITE);
	    panelPB.setBounds(10, 46, 1280, 294);
	    add(panelPB);
	    panelPB.setLayout(null);
	    
	    JLabel lblAnhPB = new JLabel();
	    lblAnhPB.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/phongBan.PNG")));
	    lblAnhPB.setBounds(39, 38, 418, 225);
	    panelPB.add(lblAnhPB);
	    
	    JLabel lblMaPhongBan = new JLabel();
	    lblMaPhongBan.setText("Mã phòng ban:");
	    lblMaPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblMaPhongBan.setBounds(554, 69, 111, 30);
	    panelPB.add(lblMaPhongBan);
	    
	    txtPhongBan = new JTextField();
	    txtPhongBan.setText("txtMaPB");
	    txtPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtPhongBan.setBorder(null);
	    txtPhongBan.setBounds(783, 53, 224, 36);
	    panelPB.add(txtPhongBan);
	    
	    JLabel lblTenPhongBan = new JLabel();
	    lblTenPhongBan.setText("Tên phòng ban:");
	    lblTenPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenPhongBan.setBounds(554, 151, 162, 30);
	    panelPB.add(lblTenPhongBan);
	    
	    txtTenPhongBan = new JTextField();
	    txtTenPhongBan.setText("txtTenPB");
	    txtTenPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenPhongBan.setBorder(null);
	    txtTenPhongBan.setBounds(783, 131, 224, 36);
	    panelPB.add(txtTenPhongBan);
	    
	    JLabel lblSoLuongNV = new JLabel();
	    lblSoLuongNV.setText("Số lượng nhân viên:");
	    lblSoLuongNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblSoLuongNV.setBounds(554, 233, 189, 30);
	    panelPB.add(lblSoLuongNV);
	    
	    txtSoLuongNV = new JTextField();
	    txtSoLuongNV.setText("0");
	    txtSoLuongNV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoLuongNV.setBorder(null);
	    txtSoLuongNV.setBounds(783, 221, 224, 30);
	    panelPB.add(txtSoLuongNV);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(783, 89, 299, 10);
	    panelPB.add(jSeparator);
	    
	    JSeparator jSeparator_1 = new JSeparator();
	    jSeparator_1.setForeground(Color.BLACK);
	    jSeparator_1.setBounds(783, 171, 299, 10);
	    panelPB.add(jSeparator_1);
	    
	    JSeparator jSeparator_2 = new JSeparator();
	    jSeparator_2.setForeground(Color.BLACK);
	    jSeparator_2.setBounds(783, 253, 299, 10);
	    panelPB.add(jSeparator_2);
	    
	    JLabel lblErrTenPhongBan = new JLabel();
	    lblErrTenPhongBan.setText("lblErrTenPB");
	    lblErrTenPhongBan.setForeground(new Color(204, 0, 0));
	    lblErrTenPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenPhongBan.setBounds(783, 178, 200, 17);
	    panelPB.add(lblErrTenPhongBan);
	    
	    JLabel lblErrSoLuongNV = new JLabel();
	    lblErrSoLuongNV.setText("thông báo lỗi");
	    lblErrSoLuongNV.setForeground(new Color(204, 0, 0));
	    lblErrSoLuongNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSoLuongNV.setBounds(783, 260, 200, 18);
	    panelPB.add(lblErrSoLuongNV);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ PHÒNG BAN ");
	    lblTieuDe.setBounds(448, 11, 368, 43);
	    add(lblTieuDe);
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setLayout(null);
	    panelButton.setBackground(Color.WHITE);
	    panelButton.setBounds(10, 351, 1280, 65);
	    add(panelButton);
	    
	    RoundedButton btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
	    btnThem.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/them.png")));
	    btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnThem.setBounds(69, 14, 170, 40);
	    panelButton.add(btnThem);
	    
	    RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
	    btnXoa.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/xoa.png")));
	    btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnXoa.setBounds(292, 14, 170, 40);
	    panelButton.add(btnXoa);
	    
	    RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
	    btnCapNhat.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/capNhat.png")));
	    btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnCapNhat.setBounds(519, 14, 170, 40);
	    panelButton.add(btnCapNhat);
	    
	    RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
	    btnLuu.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/luu.png")));
	    btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnLuu.setBounds(753, 14, 170, 40);
	    panelButton.add(btnLuu);
	    
	    RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
	    btnHuy.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/huy.png")));
	    btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnHuy.setBounds(991, 14, 170, 40);
	    panelButton.add(btnHuy);
	    
	    JLabel lblDanhSchPhng = new JLabel("Danh sách phòng ban:");
	    lblDanhSchPhng.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblDanhSchPhng.setBounds(81, 456, 186, 28);
	    add(lblDanhSchPhng);
	    
	    
	    tblHopDong = new JTable();
	    tblHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    tblHopDong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    
	    tblHopDong.setRowHeight(30);
	    
	    DefaultTableModel tableModel = new DefaultTableModel(
	    		new Object[][] {
	    			{null, null, null, null},
	    			{null, null, null, null},
	    			{null, null, null, null},
	    			{null, null, null, null}
	    		},
	    		new String[] {
	    				"STT", "Mã phòng ban", "Tên phòng ban", "Số lượng nhân viên"
	    		}
	    		);

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
	    	},
	    	new String[] {
	    		"STT", "M\u00E3 ph\u00F2ng ban", "T\u00EAn ph\u00F2ng ban", "S\u1ED1 l\u01B0\u1EE3ng nh\u00E2n vi\u00EAn"
	    	}
	    )); 

	    scrHopDong = new JScrollPane(tblHopDong);
	    scrHopDong.setBounds(81, 495, 1092, 233);
	    add(scrHopDong);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrHopDong.setVerticalScrollBar(scrollBar1);
	}
}
