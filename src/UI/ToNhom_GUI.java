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

public class ToNhom_GUI extends JPanel {
	private JTextField txtToNhom;
	private JTextField txtTenToNhom;
	private JTextField txtSoLuongCN;
	
	private JScrollPane scrToNhom;
    private JTable tblHopDong;
	
	
	public ToNhom_GUI() {
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
	    lblAnhPB.setIcon(new ImageIcon(ToNhom_GUI.class.getResource("/image/toNhom.png")));
	    lblAnhPB.setBounds(39, 11, 420, 272);
	    panelPB.add(lblAnhPB);
	    
	    JLabel lblMaToNhom = new JLabel();
	    lblMaToNhom.setText("Mã tổ nhóm:");
	    lblMaToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblMaToNhom.setBounds(554, 69, 111, 30);
	    panelPB.add(lblMaToNhom);
	    
	    txtToNhom = new JTextField();
	    txtToNhom.setText("txtMaTN");
	    txtToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtToNhom.setBorder(null);
	    txtToNhom.setBounds(783, 53, 224, 36);
	    panelPB.add(txtToNhom);
	    
	    JLabel lblTenToNhom = new JLabel();
	    lblTenToNhom.setText("Tên tổ nhóm:");
	    lblTenToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenToNhom.setBounds(554, 151, 162, 30);
	    panelPB.add(lblTenToNhom);
	    
	    txtTenToNhom = new JTextField();
	    txtTenToNhom.setText("txtTenTN");
	    txtTenToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenToNhom.setBorder(null);
	    txtTenToNhom.setBounds(783, 131, 224, 36);
	    panelPB.add(txtTenToNhom);
	    
	    JLabel lblSLngCng = new JLabel();
	    lblSLngCng.setText("Số lượng công nhân:");
	    lblSLngCng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblSLngCng.setBounds(554, 233, 189, 30);
	    panelPB.add(lblSLngCng);
	    
	    txtSoLuongCN = new JTextField();
	    txtSoLuongCN.setText("0");
	    txtSoLuongCN.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtSoLuongCN.setBorder(null);
	    txtSoLuongCN.setBounds(783, 221, 224, 30);
	    panelPB.add(txtSoLuongCN);
	    
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
	    
	    JLabel lblErrTenToNhom = new JLabel();
	    lblErrTenToNhom.setText("lblErrTenTN");
	    lblErrTenToNhom.setForeground(new Color(204, 0, 0));
	    lblErrTenToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenToNhom.setBounds(783, 178, 200, 17);
	    panelPB.add(lblErrTenToNhom);
	    
	    JLabel lblErrSoLuongCN = new JLabel();
	    lblErrSoLuongCN.setText("thông báo lỗi");
	    lblErrSoLuongCN.setForeground(new Color(204, 0, 0));
	    lblErrSoLuongCN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrSoLuongCN.setBounds(783, 260, 200, 18);
	    panelPB.add(lblErrSoLuongCN);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ TỔ NHÓM");
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
	    
	    JLabel lblDanhSachToNhom = new JLabel("Danh sách phòng ban:");
	    lblDanhSachToNhom.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblDanhSachToNhom.setBounds(81, 456, 186, 28);
	    add(lblDanhSachToNhom);
	    
	    
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
	    				"STT", "Mã tổ nhóm", "Tên tổ nhóm", "Số lượng công nhân"
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
    				"STT", "Mã tổ nhóm", "Tên tổ nhóm", "Số lượng công nhân"
    		}
	    )); 

	    scrToNhom = new JScrollPane(tblHopDong);
	    scrToNhom.setBounds(81, 495, 1092, 233);
	    add(scrToNhom);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrToNhom.setVerticalScrollBar(scrollBar1);
	}
}

