package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;

public class PhanCongCongNhan_GUI extends JPanel {

	private JScrollPane scrSanPham;
    private JTable tblSanPham;
    private JScrollPane scrCDCongNhan;
    private JTable tblCDCongNhan;
    
    private JTextField txtMaPhanCong;
    private JTextField txtTenCD;
    private JTextField txtSoLuongCan;
    private JTextField txtMaCD;
	private JLabel lblTieuDe;
	private JPanel panelCDCongNhan;
	private JLabel lblMaPhanCong;
	private JLabel lblTenCD;
	private JLabel lblSoLuongCan;
	private JLabel lblErrSoLuongCan;
	private JLabel lblMaCD;
	private JLabel lblToNhom;
    private JComboBox<String> cmbToNhom;
	private JLabel lblNgayPhanCong;
	private JDateChooser dcsNgayPhanCong;
	private JButton btnPhanCong;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnLuu;
	private JButton btnHuy;
    
	
	public PhanCongCongNhan_GUI() {
		setBackground(Color.WHITE);
		initComponents();
	}

	private void initComponents() {
		setSize(1290, 750);
	    setLayout(null);
	    
	    lblTieuDe = new JLabel("PHÂN CÔNG CÔNG NHÂN");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lblTieuDe.setBounds(344, 22, 490, 50);
	    add(lblTieuDe);
	    
	    tblSanPham = new JTable();
        tblSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tblSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
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
	    
	    tblSanPham.getTableHeader().setBackground(new Color(128, 200, 255));
	    tblSanPham.setSelectionBackground(new Color(255, 215, 0));
	    tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
	    scrSanPham = new JScrollPane(tblSanPham);
	    LineBorder blackLineBorder = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(blackLineBorder, "Danh sách sản phẩm");
		scrSanPham.setBorder(titledBorder);
		scrSanPham.setBackground(Color.WHITE);
	    scrSanPham.setBounds(42, 140, 708, 227);
	    add(scrSanPham);
	    
        ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.RED);
        scrSanPham.setVerticalScrollBar(scrollBar);
        
        panelCDCongNhan = new JPanel();
        LineBorder blackLineBorder1 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Thông tin phân công công nhân");
		panelCDCongNhan.setBorder(titledBorder1);
        panelCDCongNhan.setBackground(Color.WHITE);
        panelCDCongNhan.setBounds(854, 70, 387, 369);
        add(panelCDCongNhan);
        panelCDCongNhan.setLayout(null);
        
        lblMaPhanCong = new JLabel();
        lblMaPhanCong.setBounds(24, 33, 100, 20);
        lblMaPhanCong.setText("Mã phân công:");
        lblMaPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        panelCDCongNhan.add(lblMaPhanCong);
        
        txtMaPhanCong = new JTextField();
        txtMaPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaPhanCong.setBorder(null);
        txtMaPhanCong.setBounds(134, 17, 224, 30);
        panelCDCongNhan.add(txtMaPhanCong);
        
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.BLACK);
        jSeparator.setBounds(134, 50, 224, 10);
        panelCDCongNhan.add(jSeparator);
        
        lblTenCD = new JLabel();
        lblTenCD.setText("Tên công đoạn:");
        lblTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblTenCD.setBounds(22, 164, 102, 30);
        panelCDCongNhan.add(lblTenCD);
        
        txtTenCD = new JTextField();
        txtTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtTenCD.setBorder(null);
        txtTenCD.setBounds(134, 147, 224, 36);
        panelCDCongNhan.add(txtTenCD);
        
        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setForeground(Color.BLACK);
        jSeparator1.setBounds(134, 110, 224, 10);
        panelCDCongNhan.add(jSeparator1);
        
        lblSoLuongCan = new JLabel();
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
        
        lblErrSoLuongCan = new JLabel();
        lblErrSoLuongCan.setText("thông báo lỗi");
        lblErrSoLuongCan.setForeground(new Color(204, 0, 0));
        lblErrSoLuongCan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        lblErrSoLuongCan.setBounds(134, 254, 200, 30);
        panelCDCongNhan.add(lblErrSoLuongCan);
        
        txtMaCD = new JTextField();
        txtMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtMaCD.setBorder(null);
        txtMaCD.setBounds(134, 72, 224, 36);
        panelCDCongNhan.add(txtMaCD);
        
        lblMaCD = new JLabel();
        lblMaCD.setText("Mã công đoạn:");
        lblMaCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblMaCD.setBounds(24, 84, 100, 36);
        panelCDCongNhan.add(lblMaCD);
        
        lblToNhom = new JLabel();
        lblToNhom.setText("Tổ nhóm:");
        lblToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblToNhom.setBounds(24, 295, 130, 40);
        panelCDCongNhan.add(lblToNhom);
        
        cmbToNhom = new JComboBox<String>();
        cmbToNhom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cmbToNhom.setBackground(Color.WHITE);
        cmbToNhom.setBounds(134, 289, 224, 36);
        cmbToNhom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cboToNhomActionPerformed(evt);
            }
        });
        panelCDCongNhan.add(cmbToNhom);
	    
	    tblCDCongNhan = new JTable();
        tblCDCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tblCDCongNhan.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
	    tblCDCongNhan.setRowHeight(25);

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

	    tblCDCongNhan.getTableHeader().setBackground(new Color(128, 200, 255));
	    tblCDCongNhan.setSelectionBackground(new Color(255, 215, 0));
	    
	    scrCDCongNhan = new JScrollPane(tblCDCongNhan);
	    LineBorder blackLineBorder2 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(blackLineBorder2, "Danh sách phân công công nhân");
		scrCDCongNhan.setBorder(titledBorder2);
		scrCDCongNhan.setBackground(Color.WHITE);
	    scrCDCongNhan.setBounds(42, 525, 1195, 202);
	    add(scrCDCongNhan);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);
        scrCDCongNhan.setVerticalScrollBar(scrollBar1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(CongDoanSanPham_GUI.class.getResource("/image/icon/muitenNgang.png")));
        lblNewLabel.setBounds(783, 243, 50, 41);
        add(lblNewLabel);
        
        lblNgayPhanCong = new JLabel();
        lblNgayPhanCong.setText("Ngày chấm công:");
        lblNgayPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNgayPhanCong.setBounds(52, 389, 115, 29);
        add(lblNgayPhanCong);
        
        dcsNgayPhanCong = new JDateChooser();
        dcsNgayPhanCong.setDateFormatString("yyyy-MM-dd");
        dcsNgayPhanCong.setBounds(198, 377, 177, 41);
        add(dcsNgayPhanCong);
        
        btnPhanCong = new JButton();
        btnPhanCong.setIcon(new ImageIcon(PhanCongCongNhan_GUI.class.getResource("/image/icon/phancong.png")));
        btnPhanCong.setText("Phân công");
        btnPhanCong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnPhanCong.setBorder(null);
        btnPhanCong.setBackground(new Color(255, 215, 0));
        btnPhanCong.setBounds(117, 456, 170, 40);
        btnPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanCongActionPerformed(evt);
            }
        });
        add(btnPhanCong);
        
        btnXoa = new JButton();
        btnXoa.setIcon(new ImageIcon(PhanCongCongNhan_GUI.class.getResource("/image/icon/xoa.png")));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnXoa.setBorder(null);
        btnXoa.setBackground(new Color(255, 215, 0));
        btnXoa.setBounds(340, 456, 170, 40);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa);
        
        btnCapNhat = new JButton();
        btnCapNhat.setIcon(new ImageIcon(PhanCongCongNhan_GUI.class.getResource("/image/icon/capNhat.png")));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnCapNhat.setBorder(null);
        btnCapNhat.setBackground(new Color(255, 215, 0));
        btnCapNhat.setBounds(561, 456, 170, 40);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        add(btnCapNhat);
        
        btnLuu = new JButton();
        btnLuu.setIcon(new ImageIcon(PhanCongCongNhan_GUI.class.getResource("/image/icon/luu.png")));
        btnLuu.setText("Lưu");
        btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnLuu.setBorder(null);
        btnLuu.setBackground(new Color(255, 215, 0));
        btnLuu.setBounds(777, 456, 170, 40);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        add(btnLuu);
        
        btnHuy = new JButton();
        btnHuy.setIcon(new ImageIcon(PhanCongCongNhan_GUI.class.getResource("/image/icon/huy.png")));
        btnHuy.setText("Hủy");
        btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnHuy.setBorder(null);
        btnHuy.setBackground(new Color(255, 215, 0));
        btnHuy.setBounds(986, 456, 170, 40);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        add(btnHuy);
	    
	}

	private void btnHuyActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void btnLuuActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void btnCapNhatActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void btnXoaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void btnPhanCongActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void cboToNhomActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void tblSanPhamMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
