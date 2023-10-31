package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Custom_UI.ScrollBarCustom;
import Dao.HopDong_Dao;
import Dao.SanPham_Dao;
import Entity.HopDong;
import Entity.SanPham;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;

/**
 * Hoàng Huy Tới
 */

public class SanPham_GUI extends JPanel implements ActionListener, MouseListener{
	private JTextField txtMaSanPham;
	private JTextField txtTenSanPham;
	private JTextField txtChatLieu;
	private JTextField txtKichThuoc;
	private JTextField txtSoCongDoan;
	private JTextField txtSoLuong;
	private JTextField txtMaHopDong;
	private JTextField txtDonGia;

	private JLabel lblTieuDe;
	private JLabel lblMaHopDong;
	private JLabel lblMaSanPham;
	private JLabel lblTenSanPham;
	private JLabel lblDonGia;
	private JLabel lblSoLuong;
	private JLabel lblSoLuongCongDoan;
	private JLabel lblKichThuoc;
	private JLabel lblChatLieu;
	private JPanel pnlThongTinSP;

	private JLabel lblAnhSanPham;
	private JLabel lblErrChatLieu;
	private JLabel lblErrKichThuoc;
	private JLabel lblErrSoLuong;
	private JLabel lblErrTenSanPham;
	private JLabel lblErrDonGia;
	private JScrollPane scrHopDong;
	private JScrollPane scrTableSanPham;
	private JTable tblDanhSachSanPham;
	private JTable tblHopDong;
	private JSeparator jSeparator5;
	private JSeparator jSeparator5_1;
	private JSeparator jSeparator5_2;
	private JSeparator jSeparator5_3;
	private JSeparator jSeparator5_4;
	private JSeparator jSeparator5_5;
	private JSeparator jSeparator5_6;
	private JSeparator jSeparator5_7;

	private JButton btnThem;
	private JButton btnThemNhieu;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnLuu;
	private JButton btnHuy;

	private SanPham_Dao sanPham_DAO;
	private HopDong_Dao hopDong_DAO;
	private DefaultTableModel modelSanPham;
	private DefaultTableModel modelHopDong;
	private Object oFlag;
	private DecimalFormat dcf = new DecimalFormat("###.00");
	private JPanel pnlAnhSanPham;
	private JLabel lblAnhSanPhamOfPnl;
	
	private String stErrKhongDeTrong;
    private String stErrSoLuong;
    private String stThongbao;
    private String stBanXacNhanXoa;
    private String stXoaThanhCong;
    private String stXoaThatBai;
    private String stThemThanhCong;
    private String stThemThatBai;
    private String stTren;
    private String stSanPham;
    private String stKhongTimThayFile;
    private String stKhongDocDuocFile;
    private String stCapNhatThanhCong;
    private String stCapNhatThatBai;
    private String stChonMauSacChoSanPham;


	public SanPham_GUI() {
		initComponents();
		
		txtMaSanPham.setText("");

        try {
            ConnectionDB.ConnectDB.getInstance().connect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sanPham_DAO = new SanPham_Dao();
        hopDong_DAO = new HopDong_Dao();
        modelSanPham = (DefaultTableModel) tblDanhSachSanPham.getModel();
        modelHopDong = (DefaultTableModel) tblHopDong.getModel();
        oFlag = null;
        
		// Gắn sự kiện
        btnCapNhat.addActionListener(this);
        btnHuy.addActionListener(this);
        btnLuu.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoa.addActionListener(this);
        tblDanhSachSanPham.addMouseListener(this);
        tblHopDong.addMouseListener(this);

        xoaTrangField();
        btnLuu.setEnabled(false);
        btnHuy.setEnabled(false);
        lblAnhSanPhamOfPnl.setEnabled(false);
        
        excute();
        moKhoaTextField(false);
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		scrTableSanPham = new JScrollPane();
		scrTableSanPham.setBounds(20, 471, 1235, 254);
		tblDanhSachSanPham = new JTable();

		setPreferredSize(new Dimension(1290, 750));
		lblTieuDe = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(533, 11, 296, 40);
		add(lblTieuDe);

		scrHopDong = new JScrollPane();
		scrHopDong.setBounds(20, 62, 410, 315);
		add(scrHopDong);
		tblHopDong = new javax.swing.JTable();

		scrHopDong.setBackground(new java.awt.Color(255, 255, 255));
		scrHopDong.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hợp đồng"));

		tblHopDong.setFont(new java.awt.Font("Times New Roman", 0, 16));
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
						"STT", "M\u00E3 h\u1EE3p \u0111\u1ED3ng", "T\u00EAn h\u1EE3p \u0111\u1ED3ng", "T\u00EAn kh\u00E1ch h\u00E0ng"
				}
				));
		tblHopDong.getTableHeader().setOpaque(false);
		tblHopDong.setRowHeight(24);
		tblHopDong.setSelectionBackground(new java.awt.Color(232, 57, 95));
		tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblHopDongMouseClicked(evt);
			}
		});
		ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.RED);
		scrHopDong.setVerticalScrollBar(scrollBar);
		scrHopDong.setViewportView(tblHopDong);


		pnlThongTinSP = new JPanel();
		pnlThongTinSP.setBackground(new Color(255, 255, 255));
		LineBorder blackLineBorder = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(blackLineBorder, "Thông tin sản phẩm");
		pnlThongTinSP.setBorder(titledBorder);
		pnlThongTinSP.setBounds(482, 62, 773, 317);
		add(pnlThongTinSP);
		pnlThongTinSP.setLayout(null);

		lblAnhSanPham = new javax.swing.JLabel();
		lblAnhSanPham.setBounds(10, 31, 180, 180);
		lblAnhSanPham.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/sanPham/giay1.png")));
		pnlThongTinSP.add(lblAnhSanPham);

		pnlAnhSanPham = new JPanel();
		pnlAnhSanPham.setBackground(new Color(255, 192, 203));
		pnlAnhSanPham.setEnabled(false);
		pnlAnhSanPham.setBounds(46, 193, 120, 40);
		pnlThongTinSP.add(pnlAnhSanPham);

		lblAnhSanPhamOfPnl = new JLabel();
		lblAnhSanPhamOfPnl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAnhSanPhamOfPnl.setText("Ảnh sản phẩm");
		lblAnhSanPhamOfPnl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhSanPhamOfPnl.setEnabled(false);

		lblAnhSanPhamOfPnl.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblAnhSanPhamOfPnlMouseClicked(evt);
			}
		});

		GroupLayout gl_pnlAnhSanPham = new GroupLayout(pnlAnhSanPham);
		gl_pnlAnhSanPham.setHorizontalGroup(
				gl_pnlAnhSanPham.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblAnhSanPhamOfPnl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
				);
		gl_pnlAnhSanPham.setVerticalGroup(
				gl_pnlAnhSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAnhSanPham.createSequentialGroup()
						.addComponent(lblAnhSanPhamOfPnl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		pnlAnhSanPham.setLayout(gl_pnlAnhSanPham);

		lblMaHopDong = new JLabel();
		lblMaHopDong.setText("Mã hợp đồng:");
		lblMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaHopDong.setBounds(213, 31, 100, 40);
		pnlThongTinSP.add(lblMaHopDong);

		txtMaHopDong = new JTextField();
		txtMaHopDong.setBackground(new Color(255, 255, 255));
		txtMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaHopDong.setBorder(null);
		txtMaHopDong.setBounds(323, 21, 140, 40);
		pnlThongTinSP.add(txtMaHopDong);
		lblMaSanPham = new javax.swing.JLabel();
		lblMaSanPham.setBounds(509, 31, 140, 40);
		pnlThongTinSP.add(lblMaSanPham);

		lblMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaSanPham.setText("Mã sản phẩm:");
		txtMaSanPham = new javax.swing.JTextField();
		txtMaSanPham.setBackground(new Color(255, 255, 255));
		txtMaSanPham.setBounds(613, 21, 140, 40);
		pnlThongTinSP.add(txtMaSanPham);

		txtMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaSanPham.setBorder(null);
		lblTenSanPham = new javax.swing.JLabel();
		lblTenSanPham.setBounds(213, 100, 110, 40);
		pnlThongTinSP.add(lblTenSanPham);

		lblTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenSanPham.setText("Tên sản phẩm:");
		lblDonGia = new javax.swing.JLabel();
		lblDonGia.setBounds(213, 260, 92, 30);
		pnlThongTinSP.add(lblDonGia);

		lblDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDonGia.setText("Đơn giá SP:");
		lblSoLuong = new javax.swing.JLabel();
		lblSoLuong.setBounds(213, 181, 80, 30);
		pnlThongTinSP.add(lblSoLuong);

		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoLuong.setText("Số lượng:");
		lblKichThuoc = new javax.swing.JLabel();
		lblKichThuoc.setBounds(509, 100, 110, 40);
		pnlThongTinSP.add(lblKichThuoc);

		lblKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKichThuoc.setText("Kích thước:");

		lblChatLieu = new JLabel();
		lblChatLieu.setText("Chất liệu:");
		lblChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChatLieu.setBounds(509, 181, 140, 25);
		pnlThongTinSP.add(lblChatLieu);
		txtTenSanPham = new javax.swing.JTextField();
		txtTenSanPham.setBackground(new Color(255, 255, 255));
		txtTenSanPham.setBounds(323, 90, 140, 40);
		pnlThongTinSP.add(txtTenSanPham);

		txtTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenSanPham.setBorder(null);
		txtChatLieu = new javax.swing.JTextField();
		txtChatLieu.setBackground(new Color(255, 255, 255));
		txtChatLieu.setBounds(613, 156, 140, 40);
		pnlThongTinSP.add(txtChatLieu);

		txtChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChatLieu.setBorder(null);
		txtKichThuoc = new javax.swing.JTextField();
		txtKichThuoc.setBackground(new Color(255, 255, 255));
		txtKichThuoc.setBounds(613, 82, 140, 40);
		pnlThongTinSP.add(txtKichThuoc);

		txtKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtKichThuoc.setBorder(null);
		lblSoLuongCongDoan = new javax.swing.JLabel();
		lblSoLuongCongDoan.setBounds(509, 260, 100, 25);
		pnlThongTinSP.add(lblSoLuongCongDoan);

		lblSoLuongCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoLuongCongDoan.setText("Số công đoạn:");
		txtSoCongDoan = new javax.swing.JTextField();
		txtSoCongDoan.setBackground(new Color(255, 255, 255));
		txtSoCongDoan.setBounds(613, 239, 140, 41);
		pnlThongTinSP.add(txtSoCongDoan);

		txtSoCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoCongDoan.setBorder(null);
		txtSoLuong = new javax.swing.JTextField();
		txtSoLuong.setBackground(new Color(255, 255, 255));
		txtSoLuong.setBounds(323, 161, 140, 40);
		pnlThongTinSP.add(txtSoLuong);

		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuong.setBorder(null);

		txtDonGia = new JTextField();
		txtDonGia.setBackground(new Color(255, 255, 255));
		txtDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDonGia.setBorder(null);
		txtDonGia.setBounds(323, 239, 140, 40);
		pnlThongTinSP.add(txtDonGia);

		jSeparator5 = new JSeparator();
		jSeparator5.setForeground(Color.BLACK);
		jSeparator5.setBounds(323, 61, 140, 10);
		pnlThongTinSP.add(jSeparator5);

		jSeparator5_1 = new JSeparator();
		jSeparator5_1.setForeground(Color.BLACK);
		jSeparator5_1.setBounds(323, 130, 140, 10);
		pnlThongTinSP.add(jSeparator5_1);

		jSeparator5_2 = new JSeparator();
		jSeparator5_2.setForeground(Color.BLACK);
		jSeparator5_2.setBounds(323, 202, 140, 10);
		pnlThongTinSP.add(jSeparator5_2);

		jSeparator5_3 = new JSeparator();
		jSeparator5_3.setForeground(Color.BLACK);
		jSeparator5_3.setBounds(323, 280, 140, 10);
		pnlThongTinSP.add(jSeparator5_3);
		lblErrTenSanPham = new javax.swing.JLabel();
		lblErrTenSanPham.setBounds(323, 132, 153, 18);
		pnlThongTinSP.add(lblErrTenSanPham);

		lblErrTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrTenSanPham.setForeground(new java.awt.Color(204, 0, 0));
		lblErrTenSanPham.setText("đây là dòng thông báo lỗi");
		lblErrChatLieu = new javax.swing.JLabel();
		lblErrChatLieu.setBounds(613, 193, 140, 30);
		pnlThongTinSP.add(lblErrChatLieu);

		lblErrChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrChatLieu.setForeground(new java.awt.Color(204, 0, 0));
		lblErrChatLieu.setText("đây là dòng thông báo lỗi");
		lblErrKichThuoc = new javax.swing.JLabel();
		lblErrKichThuoc.setBounds(613, 122, 170, 28);
		pnlThongTinSP.add(lblErrKichThuoc);

		lblErrKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrKichThuoc.setForeground(new java.awt.Color(204, 0, 0));
		lblErrKichThuoc.setText("đây là dòng thông báo lỗi");

		jSeparator5_4 = new JSeparator();
		jSeparator5_4.setForeground(Color.BLACK);
		jSeparator5_4.setBounds(613, 61, 140, 10);
		pnlThongTinSP.add(jSeparator5_4);

		jSeparator5_5 = new JSeparator();
		jSeparator5_5.setForeground(Color.BLACK);
		jSeparator5_5.setBounds(613, 122, 140, 18);
		pnlThongTinSP.add(jSeparator5_5);

		jSeparator5_6 = new JSeparator();
		jSeparator5_6.setForeground(Color.BLACK);
		jSeparator5_6.setBounds(613, 199, 140, 2);
		pnlThongTinSP.add(jSeparator5_6);

		lblErrSoLuong = new javax.swing.JLabel();
		lblErrSoLuong.setBounds(323, 201, 170, 30);
		pnlThongTinSP.add(lblErrSoLuong);

		lblErrSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrSoLuong.setForeground(new java.awt.Color(204, 0, 0));
		lblErrSoLuong.setText("đây là dòng thông báo lỗi");

		jSeparator5_7 = new JSeparator();
		jSeparator5_7.setForeground(Color.BLACK);
		jSeparator5_7.setBounds(613, 280, 140, 10);
		pnlThongTinSP.add(jSeparator5_7);

		lblErrDonGia = new JLabel();
		lblErrDonGia.setText("đây là dòng thông báo lỗi");
		lblErrDonGia.setForeground(new Color(204, 0, 0));
		lblErrDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblErrDonGia.setBounds(323, 280, 170, 30);
		pnlThongTinSP.add(lblErrDonGia);


		txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSoLuongActionPerformed(evt);
			}
		});
		txtSoCongDoan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSoCongDoanActionPerformed(evt);
			}
		});
		txtChatLieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtChatLieuActionPerformed(evt);
			}
		});
		
		
		btnThemNhieu = new JButton();
		btnThemNhieu.setBounds(72, 403, 140, 40);
		add(btnThemNhieu);
		btnThemNhieu.setBackground(new Color(255, 215, 0));
		btnThemNhieu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThemNhieu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
		btnThemNhieu.setText("Thêm nhiều");
		btnThemNhieu.setBorder(null);
		btnThemNhieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//btnThemNhieuActionPerformed(evt);
			}
		});

		btnThem = new JButton();
		btnThem.setBounds(269, 403, 140, 40);
		add(btnThem);
		btnThem.setBackground(new Color(255, 215, 0));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThem.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
		btnThem.setText("Thêm");
		btnThem.setBorder(null);
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});

		btnXoa = new JButton();
		btnXoa.setBounds(474, 403, 140, 40);
		add(btnXoa);
		btnXoa.setBackground(new Color(255, 215, 0));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/xoa.png")));
		btnXoa.setText("Xóa");
		btnXoa.setBorder(null);
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		btnCapNhat = new JButton();
		btnCapNhat.setBounds(670, 403, 140, 40);
		add(btnCapNhat);
		btnCapNhat.setBackground(new Color(255, 215, 0));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCapNhat.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/capNhat.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBorder(null);
		btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCapNhatActionPerformed(evt);
			}
		});
		btnLuu = new JButton();
		btnLuu.setBounds(882, 403, 140, 40);
		add(btnLuu);
		btnLuu.setBackground(new Color(255, 0, 255));
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLuu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/luu.png")));
		btnLuu.setText("Lưu");
		btnLuu.setBorder(null);
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLuuActionPerformed(evt);
			}
		});

		btnHuy = new JButton();
		btnHuy.setBounds(1075, 403, 140, 40);
		add(btnHuy);
		btnHuy.setBackground(new Color(255, 0, 255));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHuy.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/huy.png")));
		btnHuy.setText("Hủy");
		btnHuy.setBorder(null);
		btnHuy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});

		LineBorder blackLineBorder1 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Danh sách sản phẩm");
		scrTableSanPham.setBorder(titledBorder1);

		scrTableSanPham.setBackground(Color.WHITE);
		tblDanhSachSanPham.getTableHeader().setBackground(new Color(128, 200, 255));

		scrTableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 10));
		tblDanhSachSanPham.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null},
				},
				new String[] {
						"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Số lượng", "Đơn giá", "Ch\u1EA5t li\u1EC7u", "K\u00EDch th\u01B0\u1EDBc", "\u1EA2nh s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng \u0111o\u1EA1n"
				}
				));
		tblDanhSachSanPham.setRowHeight(28);
		tblDanhSachSanPham.setSelectionBackground(new Color(255, 215, 0));
		tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblDanhSachSanPhamMouseClicked(evt);
			}
		});
		setLayout(null);
		scrTableSanPham.setViewportView(tblDanhSachSanPham);
		ScrollBarCustom scrollBar1 = new ScrollBarCustom();
		scrollBar1.setForeground(Color.RED);
		scrTableSanPham.setVerticalScrollBar(scrollBar1);
		add(scrTableSanPham);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/icon/muitenNgang.png")));
		lblNewLabel.setBounds(432, 201, 40, 27);
		add(lblNewLabel);

	}

	protected void tblHopDongMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void tblDanhSachSanPhamMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
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

	private void btnThemActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void txtChatLieuActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void txtSoCongDoanActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void txtSoLuongActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void lblAnhSanPhamOfPnlMouseClicked(java.awt.event.MouseEvent evt) {
		JFileChooser fileChooser = new JFileChooser("d:");
		fileChooser.setCurrentDirectory(new File(".\\src\\image\\sanPham"));
		int respone = fileChooser.showSaveDialog(null);
		if (respone == JFileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			String path = file.toString().split("src")[1].replace('\\', '/');
			this.lblAnhSanPham.setIcon(new ImageIcon(this.getClass().getResource(path)));
		}
	}

	public void xoaTrangField() {
		txtTenSanPham.requestFocus();;
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtTenSanPham.setText("");
		txtChatLieu.setText("");
		txtKichThuoc.setText("");
		lblAnhSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sanPham/giay1.png")));
	}

	public void excute() {
		tblDanhSachSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
		tblDanhSachSanPham.getTableHeader().setOpaque(false);
		((DefaultTableCellRenderer) tblDanhSachSanPham.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(JLabel.CENTER);
		
		lblErrChatLieu.setText("");
		lblErrSoLuong.setText("");
		lblErrDonGia.setText("");
		lblErrTenSanPham.setText("");
		lblErrKichThuoc.setText("");
		taiDuLieuLenBangHopDong();
	}

	public void taiDuLieuLenBangHopDong() {
		while (tblHopDong.getRowCount() != 0) {
			modelHopDong.removeRow(0);
		}
		ArrayList<HopDong> dsHopDong = hopDong_DAO.layDanhSachHopDong();
		for (HopDong hopDong : dsHopDong) {
			String data[] = {(modelHopDong.getRowCount() + 1) + "", hopDong.getMaHopDong(), hopDong.getTenHopDong(), hopDong.getTenKhachHang()};
			modelHopDong.addRow(data);
		}
		if (tblHopDong.getRowCount() != 0) {
			tblHopDong.setRowSelectionInterval(0, 0);
			taiDuLieuLenBangSanPham(tblHopDong.getValueAt(0,1).toString());
		} else {
			txtMaSanPham.setText("");
			txtTenSanPham.setText("");
			txtMaHopDong.setText("");
			txtChatLieu.setText("");
			txtKichThuoc.setText("");
			txtSoLuong.setText("");
			txtSoCongDoan.setText("");
		}

	}
	public void taiDuLieuLenBangSanPham(String maHopDong) {
		while (tblDanhSachSanPham.getRowCount() != 0) {
			modelSanPham.removeRow(0);
		}
		ArrayList<SanPham> dsSanPham = sanPham_DAO.layDanhSachSanPhamTheoMaHopDong(maHopDong);
		for (SanPham sanPham : dsSanPham) {
			String data[] = {(modelSanPham.getRowCount() + 1) + "", sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getSoLuongSanPham() + "",
					dcf.format(sanPham.getDonGia()).replaceAll("\\,", "."), sanPham.getChatLieu(), sanPham.getKichThuoc() + "", sanPham.getAnhSanPham(), sanPham.getSoLuongCongDoan() + ""};
			modelSanPham.addRow(data);
		}
		if (tblDanhSachSanPham.getRowCount() != 0) {
			hienThiLenTxt(0);
			tblDanhSachSanPham.setRowSelectionInterval(0, 0);
			btnCapNhat.setEnabled(true);
			btnXoa.setEnabled(true);
		} 
		else {
			txtMaSanPham.setText("");
			txtTenSanPham.setText("");
			txtChatLieu.setText("");
			txtKichThuoc.setText("");
			txtSoLuong.setText("");
			txtSoCongDoan.setText("");
			lblAnhSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sanPham/giay1.png")));
			btnCapNhat.setEnabled(false);
			btnXoa.setEnabled(false);
		}
	}
	public void hienThiLenTxt(int row) {
		txtMaHopDong.setText(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
		txtMaSanPham.setText(tblDanhSachSanPham.getValueAt(row, 1).toString());
		txtTenSanPham.setText(tblDanhSachSanPham.getValueAt(row, 2).toString());
		txtSoLuong.setText(tblDanhSachSanPham.getValueAt(row, 3).toString());
		txtDonGia.setText(tblDanhSachSanPham.getValueAt(row, 4).toString().split(" ")[0].replaceAll("\\,", "."));
		txtChatLieu.setText(tblDanhSachSanPham.getValueAt(row, 5).toString());
		txtKichThuoc.setText(tblDanhSachSanPham.getValueAt(row, 6).toString());
		System.out.println("/image/sanPham/" + tblDanhSachSanPham.getValueAt(row, 7).toString());
		lblAnhSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sanPham/" + tblDanhSachSanPham.getValueAt(row, 7).toString())));
		txtSoCongDoan.setText(tblDanhSachSanPham.getValueAt(row, 8).toString());
	}
	
	public void moKhoaTextField(Boolean b) {
        txtMaHopDong.setEditable(false);
        txtMaSanPham.setEditable(false);
        txtSoCongDoan.setEditable(b);
        txtTenSanPham.setEditable(b);
        txtSoLuong.setEditable(b);
        txtDonGia.setEditable(b);
        txtChatLieu.setEditable(b);
        txtKichThuoc.setEditable(b);
        pnlAnhSanPham.setEnabled(b);
    }
	
	@Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            oFlag = e.getSource();
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnCapNhat.setEnabled(false);
            btnLuu.setEnabled(true);
            btnHuy.setEnabled(true);
            btnThemNhieu.setEnabled(false);
            lblAnhSanPhamOfPnl.setEnabled(true);
            xoaTrangField();
            txtMaSanPham.setText(sanPham_DAO.layMaSanPhamDeThem());
            moKhoaTextField(true);
        } else if (o.equals(btnCapNhat)) {
            oFlag = e.getSource();
            btnThem.setEnabled(false);
            btnThemNhieu.setEnabled(false);
            btnXoa.setEnabled(false);
            btnCapNhat.setEnabled(false);
            btnLuu.setEnabled(true);
            btnHuy.setEnabled(true);
            lblAnhSanPhamOfPnl.setEnabled(true);
            txtTenSanPham.requestFocus();
            moKhoaTextField(true);
        }
        else if (o.equals(btnXoa)) {
            int rowSelected = tblDanhSachSanPham.getSelectedRow();
            if (rowSelected != -1) {
                int coXacNhanXoa = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không", stThongbao, JOptionPane.ERROR_MESSAGE);
                if (coXacNhanXoa == 0) {
                    boolean coXoaDuoc = sanPham_DAO.xoaMotSanPhamTheoMa(tblDanhSachSanPham.getValueAt(tblDanhSachSanPham.getSelectedRow(), 1).toString());
                    if (coXoaDuoc) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công", stThongbao, JOptionPane.INFORMATION_MESSAGE);
                        taiDuLieuLenBangSanPham(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại", stThongbao, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } 
            else if (o.equals(btnLuu)) {
            if (oFlag.equals(btnThem)) {
                //boolean hopLe = validateForm();
                int soLuongSanPham = 0, soCongDoan = 0;
//                if (!hopLe) {
//                    return;
//                }
                String maSanPham = txtMaSanPham.getText().trim();
                String tenSanPham = txtTenSanPham.getText().trim();
                String kichThuocStr = txtKichThuoc.getText().toString();
                int kichThuoc = 0;
                try {
                    soLuongSanPham = Integer.parseInt(txtSoLuong.getText().trim());
                    soCongDoan = Integer.parseInt(txtSoCongDoan.getText().trim());
                    kichThuoc = Integer.parseInt(kichThuocStr);
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
                String chatLieu = txtChatLieu.getText();
                Double donGia =  Double.parseDouble(txtDonGia.getText());
                String iconfilename = lblAnhSanPham.getIcon().toString();
                String anhSanPham = iconfilename.substring(iconfilename.lastIndexOf("/") + 1);
                
                HopDong hd = new HopDong(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
                boolean coThemDuoc = sanPham_DAO.themMotSanPham(new SanPham(maSanPham, tenSanPham, soLuongSanPham, donGia, chatLieu, kichThuoc, anhSanPham, soCongDoan, hd));
                if (coThemDuoc) {
                    taiDuLieuLenBangSanPham(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
                    btnThem.setEnabled(true);
                    btnThemNhieu.setEnabled(true);
                    btnXoa.setEnabled(true);
                    btnCapNhat.setEnabled(true);
                    btnLuu.setEnabled(false);
                    btnHuy.setEnabled(false);
                    moKhoaTextField(false);
                    lblAnhSanPhamOfPnl.setEnabled(false);
                    JOptionPane.showMessageDialog(null, stThemThanhCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
                    oFlag = null;
                } else {
                    JOptionPane.showMessageDialog(null, stThemThatBai, stThongbao, JOptionPane.INFORMATION_MESSAGE);
                }

            } 
            else if (oFlag.equals(btnCapNhat)) {
                //boolean hopLe = validateForm();
                int soLuongSanPham = 0, soCongDoan = 0;
//                if (!hopLe) {
//                    return;
//                }
                String maSanPham = txtMaSanPham.getText().trim();
                String tenSanPham = txtTenSanPham.getText().trim();
                String kichThuocStr = txtKichThuoc.getText().toString();
                int kichThuoc = 0;
                try {
                    soLuongSanPham = Integer.parseInt(txtSoLuong.getText().trim());
                    soCongDoan = Integer.parseInt(txtSoCongDoan.getText().trim());
                    kichThuoc = Integer.parseInt(kichThuocStr);
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
                String chatLieu = txtChatLieu.getText();
                Double donGia =  Double.parseDouble(txtDonGia.getText());
                String iconfilename = lblAnhSanPham.getIcon().toString();
                String anhSanPham = iconfilename.substring(iconfilename.lastIndexOf("/") + 1);
                
                HopDong hd = new HopDong(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
                boolean coSuaDuoc = sanPham_DAO.suaMotSanPham(new SanPham(maSanPham, tenSanPham, soLuongSanPham, donGia, chatLieu, kichThuoc, anhSanPham, soCongDoan, hd));
                if (coSuaDuoc) {
                    taiDuLieuLenBangSanPham(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
                    btnThem.setEnabled(true);
                    btnThemNhieu.setEnabled(true);
                    btnXoa.setEnabled(true);
                    btnCapNhat.setEnabled(true);
                    btnLuu.setEnabled(false);
                    btnHuy.setEnabled(false);
                    moKhoaTextField(false);
                    lblAnhSanPhamOfPnl.setEnabled(false);
                    oFlag = null;
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công", stThongbao, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, stCapNhatThatBai, stThongbao, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (o.equals(btnHuy)) {
            moKhoaTextField(false);
            lblErrSoLuong.setText("");
            lblErrDonGia.setText("");
            lblErrKichThuoc.setText("");
            lblErrChatLieu.setText("");
            lblErrTenSanPham.setText("");
            if (tblDanhSachSanPham.getRowCount() != 0) {
                hienThiLenTxt(0);
                tblDanhSachSanPham.setRowSelectionInterval(0, 0);
            }
            btnThem.setEnabled(true);
            btnThemNhieu.setEnabled(true);
            btnXoa.setEnabled(true);
            btnCapNhat.setEnabled(true);
            btnLuu.setEnabled(false);
            btnHuy.setEnabled(false);
            lblAnhSanPhamOfPnl.setEnabled(false);
            if (tblDanhSachSanPham.getRowCount() == 0) {
                btnCapNhat.setEnabled(false);
                btnXoa.setEnabled(false);
            }
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
        if (o.equals(tblDanhSachSanPham)) {
            int row = tblDanhSachSanPham.getSelectedRow();
            if (row != -1) {
                hienThiLenTxt(row);
                moKhoaTextField(false);
                btnThem.setEnabled(true);
                btnCapNhat.setEnabled(true);
                btnXoa.setEnabled(true);
                btnThemNhieu.setEnabled(true);
                btnHuy.setEnabled(false);
                btnLuu.setEnabled(false);
                lblErrSoLuong.setText("");
                lblErrChatLieu.setText("");
                lblErrTenSanPham.setText("");
                lblAnhSanPhamOfPnl.setEnabled(false);
            }
        } else if (o.equals(tblHopDong)) {
            int rowSelect = tblHopDong.getSelectedRow();
            if (rowSelect != -1) {
                taiDuLieuLenBangSanPham(tblHopDong.getValueAt(rowSelect, 1).toString());
                txtMaHopDong.setText(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString());
            }
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
