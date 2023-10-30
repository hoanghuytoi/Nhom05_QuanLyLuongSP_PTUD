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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Component;
import Custom_UI.RoundedButton;
import java.awt.SystemColor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Hoàng Huy Tới
 */

public class SanPham_GUI extends JPanel {
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
	private JLabel lblAnhSanPhamOfPnl;
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

	public SanPham_GUI() {
		setBackground(new Color(255, 255, 255));
		initComponents();
	}

	private void initComponents() {
		scrTableSanPham = new javax.swing.JScrollPane();
		scrTableSanPham.setBounds(20, 471, 1235, 254);
		tblDanhSachSanPham = new javax.swing.JTable();

		setPreferredSize(new java.awt.Dimension(1290, 750));
		lblTieuDe = new JLabel("QUẢN LÝ SẢN PHẨM");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(533, 11, 296, 40);
		add(lblTieuDe);

		scrHopDong = new javax.swing.JScrollPane();
		scrHopDong.setBounds(20, 62, 410, 315);
		add(scrHopDong);
		tblHopDong = new javax.swing.JTable();

		scrHopDong.setBackground(new java.awt.Color(255, 255, 255));
		scrHopDong.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hợp đồng"));

		tblHopDong.setFont(new java.awt.Font("Tahoma", 0, 16));
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
		tblHopDong.setSelectionBackground(new java.awt.Color(232, 57, 95));
		tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//tblHopDongMouseClicked(evt);
			}
		});
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
		pnlThongTinSP.add(lblAnhSanPham);

		lblAnhSanPham.setBackground(new java.awt.Color(153, 0, 0));
		lblAnhSanPham.setForeground(new java.awt.Color(255, 0, 51));
		lblAnhSanPham.setIcon(new ImageIcon(SanPham_GUI.class.getResource("/image/sanPham/giay1.png")));
		lblAnhSanPhamOfPnl = new javax.swing.JLabel();
		lblAnhSanPhamOfPnl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAnhSanPhamOfPnl.setBounds(38, 195, 120, 40);
		pnlThongTinSP.add(lblAnhSanPhamOfPnl);

		lblAnhSanPhamOfPnl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblAnhSanPhamOfPnl.setText("Ảnh sản phẩm");

		lblMaHopDong = new JLabel();
		lblMaHopDong.setText("Mã hợp đồng:");
		lblMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaHopDong.setBounds(213, 31, 100, 40);
		pnlThongTinSP.add(lblMaHopDong);

		txtMaHopDong = new JTextField();
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
		lblDonGia.setBounds(213, 250, 92, 40);
		pnlThongTinSP.add(lblDonGia);

		lblDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDonGia.setText("Đơn giá:");
		lblSoLuong = new javax.swing.JLabel();
		lblSoLuong.setBounds(213, 171, 80, 40);
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
		lblChatLieu.setBounds(509, 176, 140, 30);
		pnlThongTinSP.add(lblChatLieu);
		txtTenSanPham = new javax.swing.JTextField();
		txtTenSanPham.setBounds(323, 90, 140, 40);
		pnlThongTinSP.add(txtTenSanPham);

		txtTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenSanPham.setBorder(null);
		txtChatLieu = new javax.swing.JTextField();
		txtChatLieu.setBounds(613, 156, 140, 40);
		pnlThongTinSP.add(txtChatLieu);

		txtChatLieu.setFont(new java.awt.Font("Tahoma", 0, 16));
		txtChatLieu.setBorder(null);
		txtKichThuoc = new javax.swing.JTextField();
		txtKichThuoc.setBounds(613, 82, 140, 40);
		pnlThongTinSP.add(txtKichThuoc);

		txtKichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtKichThuoc.setBorder(null);
		lblSoLuongCongDoan = new javax.swing.JLabel();
		lblSoLuongCongDoan.setBounds(509, 255, 100, 30);
		pnlThongTinSP.add(lblSoLuongCongDoan);

		lblSoLuongCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoLuongCongDoan.setText("Số công đoạn:");
		txtSoCongDoan = new javax.swing.JTextField();
		txtSoCongDoan.setBounds(613, 239, 140, 41);
		pnlThongTinSP.add(txtSoCongDoan);

		txtSoCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoCongDoan.setBorder(null);
		txtSoLuong = new javax.swing.JTextField();
		txtSoLuong.setBounds(323, 161, 140, 40);
		pnlThongTinSP.add(txtSoLuong);

		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuong.setBorder(null);

		txtDonGia = new JTextField();
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
				//txtSoLuongActionPerformed(evt);
			}
		});
		txtSoCongDoan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//txtSoCongDoanActionPerformed(evt);
			}
		});
		txtChatLieu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//txtChatLieuActionPerformed(evt);
			}
		});
		lblAnhSanPhamOfPnl.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//lblAnhSanPhamOfPnlMouseClicked(evt);
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
				//btnThemActionPerformed(evt);
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
				//btnXoaActionPerformed(evt);
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
				//btnCapNhatActionPerformed(evt);
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
				//btnLuuActionPerformed(evt);
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
				//btnHuyActionPerformed(evt);
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
				"STT", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u00F3 l\u01B0\u1EE3ng", "M\u00E0u s\u1EAFc", "Ch\u1EA5t li\u1EC7u", "K\u00EDch th\u01B0\u1EDBc", "\u1EA2nh s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng \u0111o\u1EA1n"
			}
		));
		tblDanhSachSanPham.setSelectionBackground(new Color(255, 215, 0));
		tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//tblDanhSachSanPhamMouseClicked(evt);
			}
		});
		setLayout(null);
		scrTableSanPham.setViewportView(tblDanhSachSanPham);
		add(scrTableSanPham);
		
	}
}
