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

public class ChamCongNhanVien_GUI extends JPanel {

	private JScrollPane scrNhanVien;
    private JTable tblNhanVien;
    private JTextField txtMaNV;
    private JTextField txtTenNV;

    private JComboBox<String> cmbCaLam;
    private JComboBox<String> cmbGio;
    private JComboBox<String> cmbPhut;
    private JComboBox<String> cmbTinhTrang;
    
    private JScrollPane scrDSChamCongNV;
    private JTable tblDSChamCongNV;
    
	public ChamCongNhanVien_GUI() {
		setBackground(new Color(255, 255, 255));
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ CHẤM CÔNG NHÂN VIÊN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(413, 11, 490, 50);
	    add(lblTieuDe);
	    
	    JLabel lblDanhSachNV = new JLabel("Danh sách nhân viên cần chấm công:");
	    lblDanhSachNV.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/muiTen.png")));
	    lblDanhSachNV.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblDanhSachNV.setBounds(74, 84, 287, 41);
	    add(lblDanhSachNV);

	    tblNhanVien = new JTable();
	    tblNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    tblNhanVien.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    
	    tblNhanVien.setRowHeight(20);

	    tblNhanVien.setModel(new DefaultTableModel(
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
	    		{null, null, null, null, null, null}
	    	},
	    	new String[] {
	    		"STT", "Mã nhân viên", "Họ và tên", "SĐT", "Phòng ban", "Chức vụ"
	    	}
	    ));
	    tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(40);
	    tblNhanVien.getColumnModel().getColumn(0).setMinWidth(20);
	    tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(40);
	    tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(72);
	    tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(76);
	    tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(86);

	    scrNhanVien = new JScrollPane(tblNhanVien);
	    scrNhanVien.setBounds(74, 125, 598, 245);
	    add(scrNhanVien);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrNhanVien.setVerticalScrollBar(scrollBar);
        
        JLabel lblNgayChamCong = new JLabel();
        lblNgayChamCong.setText("Ngày chấm công:");
        lblNgayChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNgayChamCong.setBounds(74, 381, 115, 41);
        add(lblNgayChamCong);
        
        JDateChooser dcsNgayChamCong = new JDateChooser();
        dcsNgayChamCong.setDateFormatString("yyyy-MM-dd");
        dcsNgayChamCong.setBounds(198, 381, 177, 41);
        add(dcsNgayChamCong);
        
        RoundedButton btnLayDanhSach = new RoundedButton("Thêm", new Color(152, 251, 152), (Color) null);
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
        
        tblDSChamCongNV = new JTable();
        tblDSChamCongNV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tblDSChamCongNV.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    
        tblDSChamCongNV.setRowHeight(20);

        tblDSChamCongNV.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"STT", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "S\u0111t", "Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "Ca l\u00E0m", "Tr\u1EA1ng th\u00E1i", "Gi\u1EDD \u0111i l\u00E0m", "Gi\u1EDD t\u0103ng ca"
        	}
        ));
        tblDSChamCongNV.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblDSChamCongNV.getColumnModel().getColumn(0).setMinWidth(20);
        tblDSChamCongNV.getColumnModel().getColumn(0).setMaxWidth(40);
        tblDSChamCongNV.getColumnModel().getColumn(1).setPreferredWidth(72);
        tblDSChamCongNV.getColumnModel().getColumn(2).setPreferredWidth(76);
        tblDSChamCongNV.getColumnModel().getColumn(3).setPreferredWidth(86);

	    scrDSChamCongNV = new JScrollPane(tblDSChamCongNV);
	    scrDSChamCongNV.setBounds(74, 556, 1160, 183);
	    add(scrDSChamCongNV);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        scrDSChamCongNV.setVerticalScrollBar(scrollBar1);
        
        JPanel panelChamCongNV = new JPanel();
        panelChamCongNV.setBackground(new Color(255, 255, 255));
        panelChamCongNV.setBounds(757, 56, 477, 374);
        add(panelChamCongNV);
        panelChamCongNV.setLayout(null);
        
        JLabel lblMaNV = new JLabel();
        lblMaNV.setBounds(27, 33, 84, 20);
        panelChamCongNV.add(lblMaNV);
        lblMaNV.setText("Mã nhân viên:");
        lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        txtMaNV = new JTextField();
        txtMaNV.setBounds(149, 11, 301, 36);
        panelChamCongNV.add(txtMaNV);
        txtMaNV.setText("txtMaNV");
        txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaNV.setBorder(null);
        
        JSeparator jSeparator = new JSeparator();
        jSeparator.setBounds(149, 47, 301, 10);
        panelChamCongNV.add(jSeparator);
        jSeparator.setForeground(Color.BLACK);
        
        JLabel lblTenNV = new JLabel();
        lblTenNV.setBounds(29, 86, 102, 30);
        panelChamCongNV.add(lblTenNV);
        lblTenNV.setText("Họ và tên:");
        lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        txtTenNV = new JTextField();
        txtTenNV.setBounds(149, 68, 301, 36);
        panelChamCongNV.add(txtTenNV);
        txtTenNV.setText("txtTenNV");
        txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtTenNV.setBorder(null);
        
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(149, 106, 301, 10);
        panelChamCongNV.add(jSeparator1);
        jSeparator1.setForeground(Color.BLACK);
        
        JLabel lblErrTenNV = new JLabel();
        lblErrTenNV.setBounds(149, 112, 200, 20);
        panelChamCongNV.add(lblErrTenNV);
        lblErrTenNV.setText("lblErrTenNV");
        lblErrTenNV.setForeground(new Color(204, 0, 0));
        lblErrTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        
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
        
        JLabel lblGioTangCa = new JLabel();
        lblGioTangCa.setBounds(27, 339, 102, 30);
        panelChamCongNV.add(lblGioTangCa);
        lblGioTangCa.setText("Giờ tăng ca:");
        lblGioTangCa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        JComboBox<String> cmbGio_1 = new JComboBox<String>();
        cmbGio_1.setBounds(149, 319, 57, 40);
        panelChamCongNV.add(cmbGio_1);
        cmbGio_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbGio_1.setBackground(Color.WHITE);
        
        cmbGio_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "1", "2", "3", "4", "5", "6" }));
        
        JLabel lblPhut_1 = new JLabel();
        lblPhut_1.setBounds(216, 324, 57, 30);
        panelChamCongNV.add(lblPhut_1);
        lblPhut_1.setText("phút");
        lblPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        JComboBox<String> cmbPhut_1 = new JComboBox<String>();
        cmbPhut_1.setBounds(283, 319, 57, 38);
        panelChamCongNV.add(cmbPhut_1);
        cmbPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbPhut_1.setBackground(Color.WHITE);
        
        cmbPhut_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        cmbPhut_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbTrangThaiActionPerformed(evt);
            }
        });
        cmbGio_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbTrangThaiActionPerformed(evt);
            }
        });
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