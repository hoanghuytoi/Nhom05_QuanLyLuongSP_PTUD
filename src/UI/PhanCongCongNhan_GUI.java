package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;
import javax.swing.JComboBox;

public class PhanCongCongNhan_GUI extends JPanel {

	private JScrollPane scrSanPham;
    private JTable tblSanPham;
    private JScrollPane scrCDCongNhan;
    private JTable tblCDCongNhan;
    
    private JTextField txtMaPhanCong;
    private JTextField txtTenCD;
    private JTextField txtSoLuongCan;
    private JTextField txtMaCD;
    
	
	public PhanCongCongNhan_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("PHÂN CÔNG CÔNG NHÂN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(344, 22, 490, 50);
	    add(lblTieuDe);
	    
	    JLabel lblDsSP = new JLabel("Danh sách sản phẩm:");
	    lblDsSP.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/muiTen.png")));
	    lblDsSP.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblDsSP.setBounds(73, 98, 206, 41);
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
	    scrSanPham.setBounds(73, 140, 677, 227);
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
        
        RoundedButton btnPhanCong = new RoundedButton("Thêm nhiều", new Color(50, 206, 50), (Color) null);
        btnPhanCong.setText("Phân công");
        btnPhanCong.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/them.png")));
        btnPhanCong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnPhanCong.setBounds(53, 14, 150, 40);
        panelButton.add(btnPhanCong);
        
        RoundedButton btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
        btnXoa.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/xoa.png")));
        btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnXoa.setBounds(292, 14, 150, 40);
        panelButton.add(btnXoa);
        
        RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
        btnCapNhat.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/capNhat.png")));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCapNhat.setBounds(528, 14, 150, 40);
        panelButton.add(btnCapNhat);
        
        RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
        btnLuu.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/luu.png")));
        btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnLuu.setBounds(773, 14, 150, 40);
        panelButton.add(btnLuu);
        
        RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
        btnHuy.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/huy.png")));
        btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnHuy.setBounds(1008, 14, 150, 40);
        panelButton.add(btnHuy);
        
        JPanel panelCDCongNhan = new JPanel();
        panelCDCongNhan.setBackground(Color.WHITE);
        panelCDCongNhan.setBounds(854, 81, 387, 358);
        add(panelCDCongNhan);
        panelCDCongNhan.setLayout(null);
        
        JLabel lblMaPhanCong = new JLabel();
        lblMaPhanCong.setBounds(24, 33, 100, 20);
        lblMaPhanCong.setText("Mã phân công:");
        lblMaPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        panelCDCongNhan.add(lblMaPhanCong);
        
        txtMaPhanCong = new JTextField();
        txtMaPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaPhanCong.setBorder(null);
        txtMaPhanCong.setBounds(134, 11, 224, 36);
        panelCDCongNhan.add(txtMaPhanCong);
        
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.BLACK);
        jSeparator.setBounds(134, 50, 224, 10);
        panelCDCongNhan.add(jSeparator);
        
        JLabel lblTenCD = new JLabel();
        lblTenCD.setText("Tên công đoạn:");
        lblTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblTenCD.setBounds(22, 164, 102, 30);
        panelCDCongNhan.add(lblTenCD);
        
        txtTenCD = new JTextField();
        txtTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtTenCD.setBorder(null);
        txtTenCD.setBounds(134, 147, 224, 36);
        panelCDCongNhan.add(txtTenCD);
        
        JLabel lblErrTenCD = new JLabel();
        lblErrTenCD.setText("lblErrTenCD");
        lblErrTenCD.setForeground(new Color(204, 0, 0));
        lblErrTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrTenCD.setBounds(134, 191, 200, 20);
        panelCDCongNhan.add(lblErrTenCD);
        
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setForeground(Color.BLACK);
        jSeparator1.setBounds(134, 110, 224, 10);
        panelCDCongNhan.add(jSeparator1);
        
        JLabel lblSoLuongCan = new JLabel();
        lblSoLuongCan.setText("Số lượng cần:");
        lblSoLuongCan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblSoLuongCan.setBounds(24, 234, 100, 30);
        panelCDCongNhan.add(lblSoLuongCan);
        
        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setForeground(Color.BLACK);
        jSeparator2.setBounds(134, 184, 224, 10);
        panelCDCongNhan.add(jSeparator2);
        
        txtSoLuongCan = new JTextField();
        txtSoLuongCan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSoLuongCan.setBorder(null);
        txtSoLuongCan.setBounds(134, 223, 224, 30);
        panelCDCongNhan.add(txtSoLuongCan);
        
        JSeparator jSeparator2_1 = new JSeparator();
        jSeparator2_1.setForeground(Color.BLACK);
        jSeparator2_1.setBounds(134, 254, 224, 10);
        panelCDCongNhan.add(jSeparator2_1);
        
        JLabel lblErrSoLuongCan = new JLabel();
        lblErrSoLuongCan.setText("thông báo lỗi");
        lblErrSoLuongCan.setForeground(new Color(204, 0, 0));
        lblErrSoLuongCan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrSoLuongCan.setBounds(134, 254, 200, 30);
        panelCDCongNhan.add(lblErrSoLuongCan);
        
        JLabel lblErrThoiHan = new JLabel();
        lblErrThoiHan.setText("thông báo lỗi");
        lblErrThoiHan.setForeground(new Color(204, 0, 0));
        lblErrThoiHan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrThoiHan.setBounds(134, 328, 200, 30);
        panelCDCongNhan.add(lblErrThoiHan);
        
        txtMaCD = new JTextField();
        txtMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaCD.setBorder(null);
        txtMaCD.setBounds(134, 72, 224, 36);
        panelCDCongNhan.add(txtMaCD);
        
        JLabel lblMaCD = new JLabel();
        lblMaCD.setText("Mã công đoạn:");
        lblMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblMaCD.setBounds(24, 84, 100, 36);
        panelCDCongNhan.add(lblMaCD);
        
        JLabel lblToNhom = new JLabel();
        lblToNhom.setText("Tổ nhóm:");
        lblToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblToNhom.setBounds(24, 295, 130, 40);
        panelCDCongNhan.add(lblToNhom);
        
        JComboBox<String> cboToNhom = new JComboBox<String>();
        cboToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cboToNhom.setBackground(Color.WHITE);
        cboToNhom.setBounds(134, 289, 224, 36);
        panelCDCongNhan.add(cboToNhom);
        
        JLabel lblPhanCongCN = new JLabel("Phân công đoạn cho công nhân");
        lblPhanCongCN.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPhanCongCN.setBounds(940, 56, 214, 29);
        add(lblPhanCongCN);
        
        JLabel lblDsPhanCongCN = new JLabel("Danh sách phân công công nhân:");
        lblDsPhanCongCN.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDsPhanCongCN.setBounds(77, 500, 262, 41);
	    add(lblDsPhanCongCN);
	    
	    tblCDCongNhan = new JTable();
        tblCDCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tblCDCongNhan.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    tblCDCongNhan.setRowHeight(30);

	    tblCDCongNhan.setModel(new DefaultTableModel(
	    		new Object[][]{
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                    {null, null, null, null, null, null, null, null,null},
                },
                new String[]{
                    "STT","Mã phân công", "Mã sản phẩm", "Tên sản phẩm", "Mã công đoạn", "Tên  công đoạn", "Tổ Nhóm", "Số lượng cần", "Ngày phân công"
                }
	    ));
	    tblCDCongNhan.getColumnModel().getColumn(0).setPreferredWidth(35);
	    tblCDCongNhan.getColumnModel().getColumn(1).setPreferredWidth(77);
	    tblCDCongNhan.getColumnModel().getColumn(2).setPreferredWidth(82);
	    tblCDCongNhan.getColumnModel().getColumn(3).setPreferredWidth(55);
	    tblCDCongNhan.getColumnModel().getColumn(4).setPreferredWidth(77);

	    scrCDCongNhan = new JScrollPane(tblCDCongNhan);
	    scrCDCongNhan.setBounds(77, 537, 1164, 202);
	    add(scrCDCongNhan);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrCDCongNhan.setVerticalScrollBar(scrollBar1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/muitenNgang.png")));
        lblNewLabel.setBounds(783, 243, 50, 41);
        add(lblNewLabel);
        
        JLabel lblNgayChamCong = new JLabel();
        lblNgayChamCong.setText("Ngày chấm công:");
        lblNgayChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNgayChamCong.setBounds(73, 377, 115, 41);
        add(lblNgayChamCong);
        
        JDateChooser dcsNgayChamCong = new JDateChooser();
        dcsNgayChamCong.setDateFormatString("yyyy-MM-dd");
        dcsNgayChamCong.setBounds(198, 377, 177, 41);
        add(dcsNgayChamCong);
	    
	}
}
