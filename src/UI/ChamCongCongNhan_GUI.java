package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Custom_UI.ScrollBarCustom;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import Custom_UI.RoundedButton;
import java.awt.SystemColor;

public class ChamCongCongNhan_GUI extends JPanel {

	private JScrollPane scrCongNhan;
    private JTable tblCongNhan;
    private JTextField txtMaCN;
    private JTextField txtTenCN;

    private JComboBox<String> cmbCaLam;
    private JComboBox<String> cmbGio;
    private JComboBox<String> cmbPhut;
    private JComboBox<String> cmbTinhTrang;
    
    private JScrollPane scrDSChamCongCN;
    private JTable tblDSChamCongCN;
    private JTextField txtSoLuongLam;
    
	public ChamCongCongNhan_GUI() {
		setBackground(new Color(255, 255, 255));
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ CHẤM CÔNG CÔNG NHÂN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(413, 11, 490, 50);
	    add(lblTieuDe);
	    
	    JLabel lblDanhSachCN = new JLabel("Danh sách phân công công nhân:");
	    lblDanhSachCN.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/muiTen.png")));
	    lblDanhSachCN.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblDanhSachCN.setBounds(74, 84, 287, 41);
	    add(lblDanhSachCN);

	    tblCongNhan = new JTable();
	    tblCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    tblCongNhan.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    tblCongNhan.setRowHeight(18);

	    tblCongNhan.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null},
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
	    		"STT", "M\u00E3 ph\u00E2n c\u00F4ng", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "M\u00E3 c\u00F4ng \u0111o\u1EA1n", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "T\u1ED5 Nh\u00F3m", "S\u1ED1 l\u01B0\u1EE3ng c\u1EA7n"
	    	}
	    ));
	    tblCongNhan.getColumnModel().getColumn(0).setPreferredWidth(40);
	    tblCongNhan.getColumnModel().getColumn(0).setMinWidth(20);
	    tblCongNhan.getColumnModel().getColumn(0).setMaxWidth(40);
	    tblCongNhan.getColumnModel().getColumn(1).setPreferredWidth(79);
	    tblCongNhan.getColumnModel().getColumn(2).setPreferredWidth(76);
	    tblCongNhan.getColumnModel().getColumn(3).setPreferredWidth(86);
	    tblCongNhan.getColumnModel().getColumn(5).setPreferredWidth(78);
	    tblCongNhan.getColumnModel().getColumn(6).setPreferredWidth(78);
	    tblCongNhan.getColumnModel().getColumn(7).setPreferredWidth(82);

	    scrCongNhan = new JScrollPane(tblCongNhan);
	    scrCongNhan.setBounds(10, 125, 684, 245);
	    add(scrCongNhan);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrCongNhan.setVerticalScrollBar(scrollBar);
        
        JLabel lblNgayChamCong = new JLabel();
        lblNgayChamCong.setText("Ngày chấm công:");
        lblNgayChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNgayChamCong.setBounds(74, 381, 115, 41);
        add(lblNgayChamCong);
        
        JDateChooser dcsNgayChamCong = new JDateChooser();
        dcsNgayChamCong.setDateFormatString("yyyy-MM-dd");
        dcsNgayChamCong.setBounds(198, 381, 177, 41);
        add(dcsNgayChamCong);
        
        RoundedButton btnLayDanhSach = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
        btnLayDanhSach.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
        btnLayDanhSach.setText("Lấy danh sách");
        btnLayDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnLayDanhSach.setBounds(463, 381, 209, 40);
        add(btnLayDanhSach);
        
        JPanel panelButton = new JPanel();
        panelButton.setLayout(null);
        panelButton.setBackground(Color.WHITE);
        panelButton.setBounds(0, 432, 1280, 62);
        add(panelButton);
        
        RoundedButton btnChamCongTatCa = new RoundedButton("Thêm", SystemColor.inactiveCaption, (Color) null);
        btnChamCongTatCa.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
        btnChamCongTatCa.setText("Chấm công tất cả");
        btnChamCongTatCa.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnChamCongTatCa.setBounds(75, 14, 184, 40);
        panelButton.add(btnChamCongTatCa);
        
        RoundedButton btnChamCong = new RoundedButton("Xóa", new Color(222, 184, 135), (Color) null);
        btnChamCong.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
        btnChamCong.setText("Chấm công");
        btnChamCong.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnChamCong.setBounds(346, 14, 150, 40);
        panelButton.add(btnChamCong);
        
        RoundedButton btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), (Color) null);
        btnCapNhat.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/capNhat.png")));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCapNhat.setBounds(583, 14, 150, 40);
        panelButton.add(btnCapNhat);
        
        RoundedButton btnLuu = new RoundedButton("Lưu", Color.LIGHT_GRAY, (Color) null);
        btnLuu.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/luu.png")));
        btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnLuu.setBounds(823, 14, 150, 40);
        panelButton.add(btnLuu);
        
        RoundedButton btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), (Color) null);
        btnHuy.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/huy.png")));
        btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnHuy.setBounds(1060, 14, 150, 40);
        panelButton.add(btnHuy);
        
        JLabel lblDanhSachChamCongNV = new JLabel("Danh sách chấm công nhân viên:");
        lblDanhSachChamCongNV.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblDanhSachChamCongNV.setBounds(74, 519, 229, 37);
        add(lblDanhSachChamCongNV);
        
        JLabel lblMuiTen = new JLabel();
        lblMuiTen.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/muitenNgang.png")));
        lblMuiTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblMuiTen.setBounds(704, 240, 57, 30);
        add(lblMuiTen);
        
        tblDSChamCongCN = new JTable();
        tblDSChamCongCN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tblDSChamCongCN.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
        tblDSChamCongCN.setRowHeight(18);

        tblDSChamCongCN.setModel(new DefaultTableModel(
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
        		"STT", "M\u00E3 Ph\u00E2n c\u00F4ng", "M\u00E3 c\u00F4ng nh\u00E2n", "H\u1ECD v\u00E0 t\u00EAn", "T\u1ED5/Nh\u00F3m", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "Ca l\u00E0m", "Tr\u1EA1ng th\u00E1i", "Gi\u1EDD \u0111i l\u00E0m", "M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1EA3n ph\u1EA9m", "M\u00E3 c\u00F4ng \u0111o\u1EA1n", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng l\u00E0m"
        	}
        ));
        tblDSChamCongCN.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblDSChamCongCN.getColumnModel().getColumn(0).setMinWidth(20);
        tblDSChamCongCN.getColumnModel().getColumn(0).setMaxWidth(40);
        tblDSChamCongCN.getColumnModel().getColumn(1).setPreferredWidth(78);
        tblDSChamCongCN.getColumnModel().getColumn(2).setPreferredWidth(84);
        tblDSChamCongCN.getColumnModel().getColumn(3).setPreferredWidth(86);
        tblDSChamCongCN.getColumnModel().getColumn(5).setPreferredWidth(97);
        tblDSChamCongCN.getColumnModel().getColumn(5).setMinWidth(29);
        tblDSChamCongCN.getColumnModel().getColumn(11).setPreferredWidth(77);

	    scrDSChamCongCN = new JScrollPane(tblDSChamCongCN);
	    scrDSChamCongCN.setBounds(10, 556, 1254, 183);
	    add(scrDSChamCongCN);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        scrDSChamCongCN.setVerticalScrollBar(scrollBar1);
        
        JPanel panelChamCongNV = new JPanel();
        panelChamCongNV.setBackground(new Color(255, 255, 255));
        panelChamCongNV.setBounds(757, 56, 477, 374);
        add(panelChamCongNV);
        panelChamCongNV.setLayout(null);
        
        JLabel lblMaCN = new JLabel();
        lblMaCN.setBounds(27, 33, 102, 20);
        panelChamCongNV.add(lblMaCN);
        lblMaCN.setText("Mã công nhân:");
        lblMaCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        txtMaCN = new JTextField();
        txtMaCN.setBounds(149, 11, 301, 36);
        panelChamCongNV.add(txtMaCN);
        txtMaCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaCN.setBorder(null);
        
        JSeparator jSeparator = new JSeparator();
        jSeparator.setBounds(149, 47, 301, 10);
        panelChamCongNV.add(jSeparator);
        jSeparator.setForeground(Color.BLACK);
        
        JLabel lblTenNV = new JLabel();
        lblTenNV.setBounds(29, 86, 102, 30);
        panelChamCongNV.add(lblTenNV);
        lblTenNV.setText("Họ và tên:");
        lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        txtTenCN = new JTextField();
        txtTenCN.setBounds(149, 68, 301, 36);
        panelChamCongNV.add(txtTenCN);
        txtTenCN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtTenCN.setBorder(null);
        
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(149, 106, 301, 10);
        panelChamCongNV.add(jSeparator1);
        jSeparator1.setForeground(Color.BLACK);
        
        JLabel lblErrTenCN = new JLabel();
        lblErrTenCN.setBounds(149, 112, 200, 20);
        panelChamCongNV.add(lblErrTenCN);
        lblErrTenCN.setText("lblErrTenCN");
        lblErrTenCN.setForeground(new Color(204, 0, 0));
        lblErrTenCN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        
        JLabel lblTrangThai = new JLabel();
        lblTrangThai.setBounds(27, 150, 102, 30);
        panelChamCongNV.add(lblTrangThai);
        lblTrangThai.setText("Tình trạng:");
        lblTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        cmbTinhTrang = new JComboBox<String>();
        cmbTinhTrang.setBounds(149, 139, 301, 36);
        panelChamCongNV.add(cmbTinhTrang);
        cmbTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbTinhTrang.setBackground(Color.WHITE);
        
        cmbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi Làm", "Đi Trễ", "Nghỉ Có Phép", "Nghỉ Không Phép" }));
        
        JLabel lblGioDiLam = new JLabel();
        lblGioDiLam.setBounds(27, 210, 102, 30);
        panelChamCongNV.add(lblGioDiLam);
        lblGioDiLam.setText("Giờ đi làm:");
        lblGioDiLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        cmbGio = new JComboBox<String>();
        cmbGio.setBounds(149, 189, 57, 43);
        panelChamCongNV.add(cmbGio);
        cmbGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbGio.setBackground(Color.WHITE);
        
        cmbGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "1", "2", "3", "4", "5", "6" }));
        
        JLabel lblPhut = new JLabel();
        lblPhut.setBounds(216, 195, 57, 30);
        panelChamCongNV.add(lblPhut);
        lblPhut.setText("phút");
        lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        cmbPhut = new JComboBox<String>();
        cmbPhut.setBounds(283, 189, 57, 43);
        panelChamCongNV.add(cmbPhut);
        cmbPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbPhut.setBackground(Color.WHITE);
        
        cmbPhut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        
        JLabel lblCaLam = new JLabel();
        lblCaLam.setBounds(27, 277, 102, 30);
        panelChamCongNV.add(lblCaLam);
        lblCaLam.setText("Ca làm:");
        lblCaLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        cmbCaLam = new JComboBox<String>();
        cmbCaLam.setBounds(149, 255, 301, 41);
        panelChamCongNV.add(cmbCaLam);
        cmbCaLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbCaLam.setBackground(Color.WHITE);
        
        cmbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng ", "Chiều", "Đêm" }));
        
        JLabel lblSoLuongLam = new JLabel();
        lblSoLuongLam.setBounds(27, 330, 102, 30);
        panelChamCongNV.add(lblSoLuongLam);
        lblSoLuongLam.setText("Số lượng làm:");
        lblSoLuongLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        txtSoLuongLam = new JTextField();
        txtSoLuongLam.setText("0");
        txtSoLuongLam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSoLuongLam.setBorder(null);
        txtSoLuongLam.setBounds(149, 317, 301, 36);
        panelChamCongNV.add(txtSoLuongLam);
        
        JSeparator jSeparator3 = new JSeparator();
        jSeparator3.setForeground(Color.BLACK);
        jSeparator3.setBounds(149, 353, 301, 10);
        panelChamCongNV.add(jSeparator3);
        
        JLabel lblErrSoLuong = new JLabel();
        lblErrSoLuong.setText("thông báo lỗi");
        lblErrSoLuong.setForeground(new Color(204, 0, 0));
        lblErrSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrSoLuong.setBounds(149, 356, 301, 18);
        panelChamCongNV.add(lblErrSoLuong);
        cmbCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbCaLamActionPerformed(evt);
            }
        });
        cmbPhut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbTrangThaiActionPerformed(evt);
            }
        });
        cmbGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbTrangThaiActionPerformed(evt);
            }
        });
        cmbTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbTrangThaiActionPerformed(evt);
            }
        });
	}
}
