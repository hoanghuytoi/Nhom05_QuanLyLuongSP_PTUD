package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Custom_UI.ScrollBarCustom;
import Dao.HopDong_Dao;
import Dao.NhanVien_Dao;
import Entity.HopDong;
import Entity.NhanVien;
import XuatFile.ThongTinHD;
import XuatFile.Relatorio;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;

/**
 * Hoàng Huy Tới
 */

public class HopDong_GUI extends JPanel {
	private JTextField txtMaHopDong;
	private JTextField txtTenHopDong;
	private JTextField txtTenKhachHang;
	private JTextField txtTienDatCoc;
	private JTextField txtTriGiaHD;
	private JTextArea txtAreaYeuCau;
	private JDateChooser dcsNgayKyKetHD;
	private JDateChooser dcsNgayKetThucHD;
	private JLabel lblAnh;
	private JScrollPane srcYeuCau;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	private JSeparator jSeparator3;
	private JSeparator jSeparator4;
	private JSeparator jSeparator5;
	private JLabel lblErrNgayKetThucHD;
	private JLabel lblErrNgayKiKetHD;
	private JLabel lblErrTenHopDong;
	private JLabel lblErrTenKhachHang;
	private JLabel lblErrTienDatCoc;
	private JLabel lblErrTriGiaHD;

	private JLabel lblTieuDe;
	private JLabel lblMaHopDong;
	private JLabel lblTenHopDong;
	private JLabel lbltenKhachHang;
	private JLabel lblNgayKyKetHD;
	private JLabel lblNgayKetThucHD;
	private JLabel lblTienDatCoc;
	private JLabel lblTriGiaHD;
	private JLabel lblYeuCau;
	private JPanel pnlHopDong;
	private JComboBox<String> cboNhanVien;

	private JButton btnThem;
	private JButton btnThemNhieu;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnInHopDong;
	private JScrollPane scrHopDong;
	private JTable tblHopDong;

	private DefaultTableModel model;
	private HopDong_Dao hopDongDao;
	private NhanVien_Dao nhanVienDao;
	private HopDong hopDongEntity;
	private boolean isThem = false;
	private String stErrKhongDeTrong;
	private String stErrTenKhachHangKhongHopLe;
	private String stErrTien;
	private String stErrTongTien;
	private String stErrNgayKyKet;
	private String stErrHanHopDong;
	private String stThongbao;
	private String stBanXacNhanXoa;
	private String stXoaThanhCong;
	private String stXoaThatBai;
	private String stThemThanhCong;
	private String stThemThatBai;
	private String stTren;
	private String stHopDong;
	private String stKhongTimThayFile;
	private String stKhongDocDuocFile;
	private String stCapNhatThanhCong;
	private String stCapNhatThatBai;
	private String stErrTienKhongHopLe;
	private DecimalFormat dcf = new DecimalFormat("###.00");
	private NhanVien nhanVienDangNhap;
	private String fileName;
	
	List<ThongTinHD> listFileHD = new ArrayList<ThongTinHD>();

	public HopDong_GUI() throws ParseException, IOException {
		setBackground(new Color(255, 255, 255));
		initComponents();
		//        caiDatNgonNguChoView(fileName);
		excute();
		taiDuLieuLenBang();
	}

	private void initComponents() {
		pnlHopDong = new JPanel();
		pnlHopDong.setBounds(40, 46, 1208, 377);
		txtTenHopDong = new JTextField();
		txtTenHopDong.setBackground(new Color(255, 255, 255));
		txtTenHopDong.setBounds(490, 90, 200, 30);
		jSeparator1 = new JSeparator();
		jSeparator1.setForeground(new Color(0, 0, 0));
		jSeparator1.setBounds(490, 120, 200, 10);
		lbltenKhachHang = new JLabel();
		lbltenKhachHang.setBounds(760, 50, 170, 20);
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBackground(new Color(255, 255, 255));
		txtTenKhachHang.setBounds(930, 40, 200, 30);
		jSeparator2 = new JSeparator();
		jSeparator2.setForeground(new Color(0, 0, 0));
		jSeparator2.setBounds(930, 70, 200, 10);
		lblAnh = new JLabel();
		lblAnh.setBounds(57, 82, 200, 200);
		lblErrTriGiaHD = new JLabel();
		lblErrTriGiaHD.setBounds(490, 241, 210, 29);
		lblMaHopDong = new JLabel();
		lblMaHopDong.setBounds(330, 50, 170, 29);
		lblYeuCau = new JLabel();
		lblYeuCau.setBounds(330, 279, 170, 30);
		txtTienDatCoc = new JTextField();
		txtTienDatCoc.setBackground(new Color(255, 255, 255));
		txtTienDatCoc.setBounds(490, 150, 200, 30);
		jSeparator3 = new JSeparator();
		jSeparator3.setForeground(new Color(0, 0, 0));
		jSeparator3.setBounds(490, 180, 200, 10);
		lblTriGiaHD = new JLabel();
		lblTriGiaHD.setBounds(330, 219, 170, 30);
		txtTriGiaHD = new JTextField();
		txtTriGiaHD.setBackground(new Color(255, 255, 255));
		txtTriGiaHD.setBounds(490, 200, 200, 30);
		jSeparator4 = new JSeparator();
		jSeparator4.setForeground(new Color(0, 0, 0));
		jSeparator4.setBounds(490, 239, 200, 10);
		lblTienDatCoc = new JLabel();
		lblTienDatCoc.setBounds(330, 158, 170, 40);
		dcsNgayKyKetHD = new JDateChooser();
		dcsNgayKyKetHD.setBounds(930, 99, 200, 30);
		lblErrTenKhachHang = new JLabel();
		lblErrTenKhachHang.setBounds(930, 70, 290, 30);
		lblErrNgayKiKetHD = new JLabel();
		lblErrNgayKiKetHD.setBounds(930, 128, 210, 30);
		lblNgayKetThucHD = new JLabel();
		lblNgayKetThucHD.setBounds(760, 168, 170, 30);
		dcsNgayKetThucHD = new JDateChooser();
		dcsNgayKetThucHD.setBounds(930, 168, 200, 30);
		srcYeuCau = new JScrollPane();
		srcYeuCau.setBounds(490, 283, 640, 67);
		txtAreaYeuCau = new JTextArea();
		lblNgayKyKetHD = new JLabel();
		lblNgayKyKetHD.setBounds(760, 99, 170, 30);
		lblErrNgayKetThucHD = new JLabel();
		lblErrNgayKetThucHD.setBounds(930, 200, 210, 24);
		lblErrTienDatCoc = new JLabel();
		lblErrTienDatCoc.setBounds(490, 180, 210, 30);
		lblTenHopDong = new JLabel();
		lblTenHopDong.setBounds(330, 100, 170, 30);
		txtMaHopDong = new JTextField();
		txtMaHopDong.setBackground(new Color(255, 255, 255));
		txtMaHopDong.setBounds(490, 40, 200, 30);
		jSeparator5 = new JSeparator();
		jSeparator5.setForeground(new Color(0, 0, 0));
		jSeparator5.setBounds(490, 70, 200, 10);
		lblErrTenHopDong = new JLabel();
		lblErrTenHopDong.setBounds(490, 120, 210, 30);
		scrHopDong = new JScrollPane();
		scrHopDong.setBounds(40, 503, 1208, 236);
		tblHopDong = new JTable();

		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1290, 750));
		lblTieuDe = new JLabel("QUẢN LÝ HỢP ĐỒNG");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(543, 11, 296, 40);
		add(lblTieuDe);

		LineBorder blackLineBorder = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(blackLineBorder, "Thông tin hợp đồng");
		pnlHopDong.setBorder(titledBorder);
		pnlHopDong.setBackground(new Color(255, 255, 255));
		pnlHopDong.setPreferredSize(new Dimension(1250, 450));

		txtTenHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenHopDong.setBorder(null);
		txtTenHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtTenHopDongActionPerformed(evt);
			}
		});
		pnlHopDong.setLayout(null);
		pnlHopDong.add(txtTenHopDong);
		pnlHopDong.add(jSeparator1);

		lbltenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltenKhachHang.setText("Tên khách hàng:");
		pnlHopDong.add(lbltenKhachHang);

		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtTenKhachHangActionPerformed(evt);
			}
		});
		pnlHopDong.add(txtTenKhachHang);
		pnlHopDong.add(jSeparator2);

		lblAnh.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/hopDong.PNG")));
		pnlHopDong.add(lblAnh);



		lblErrTriGiaHD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblErrTriGiaHD.setForeground(new Color(204, 0, 0));
		lblErrTriGiaHD.setText("đây là dòng thông báo lỗi");
		pnlHopDong.add(lblErrTriGiaHD);

		lblMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaHopDong.setText("Mã hợp đồng:");
		pnlHopDong.add(lblMaHopDong);

		lblYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblYeuCau.setText("Yêu cầu:");
		pnlHopDong.add(lblYeuCau);

		txtTienDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTienDatCoc.setBorder(null);
		txtTienDatCoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtTienDatCocActionPerformed(evt);
			}
		});
		pnlHopDong.add(txtTienDatCoc);
		pnlHopDong.add(jSeparator3);

		lblTriGiaHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTriGiaHD.setText("Trị giá hợp đồng:");
		pnlHopDong.add(lblTriGiaHD);

		txtTriGiaHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTriGiaHD.setBorder(null);
		txtTriGiaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtTriGiaHDActionPerformed(evt);
			}
		});
		pnlHopDong.add(txtTriGiaHD);
		pnlHopDong.add(jSeparator4);

		lblTienDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTienDatCoc.setText("Tiền đặt cọc:");
		pnlHopDong.add(lblTienDatCoc);

		dcsNgayKyKetHD.setDateFormatString("yyyy-MM-dd");
		pnlHopDong.add(dcsNgayKyKetHD);

		lblErrTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblErrTenKhachHang.setForeground(new Color(204, 0, 0));
		lblErrTenKhachHang.setText("lblErrTenKhachHang");
		pnlHopDong.add(lblErrTenKhachHang);

		lblErrNgayKiKetHD.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
		lblErrNgayKiKetHD.setForeground(new java.awt.Color(204, 0, 0));
		lblErrNgayKiKetHD.setText("đây là dòng thông báo lỗi");
		pnlHopDong.add(lblErrNgayKiKetHD);

		lblNgayKetThucHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgayKetThucHD.setText("Ngày kết thúc HĐ:");
		pnlHopDong.add(lblNgayKetThucHD);

		dcsNgayKetThucHD.setDateFormatString("yyyy-MM-dd");
		pnlHopDong.add(dcsNgayKetThucHD);

		srcYeuCau.setAutoscrolls(true);
		ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.BLUE);
		srcYeuCau.setVerticalScrollBar(scrollBar);
		
		txtAreaYeuCau.setLineWrap(true);
		txtAreaYeuCau.setWrapStyleWord(true);
		txtAreaYeuCau.setColumns(20);
		txtAreaYeuCau.setRows(5);
		txtAreaYeuCau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txtAreaYeuCau.setForeground(Color.BLACK);
		txtAreaYeuCau.setCaretPosition(0);
		txtAreaYeuCau.setBackground(new Color(255, 255, 240));
		txtAreaYeuCau.setBorder(new LineBorder(new Color(245, 245, 245), 3));
		srcYeuCau.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 255, 255), new Color(220, 20, 60), new Color(255, 0, 255), new Color(50, 205, 50)));
		srcYeuCau.setViewportView(txtAreaYeuCau);
		srcYeuCau.getVerticalScrollBar().setValue(0);
		srcYeuCau.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		pnlHopDong.add(srcYeuCau);

		lblNgayKyKetHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgayKyKetHD.setText("Ngày ký kết HĐ:");
		pnlHopDong.add(lblNgayKyKetHD);

		lblErrNgayKetThucHD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblErrNgayKetThucHD.setForeground(new Color(204, 0, 0));
		lblErrNgayKetThucHD.setText("đây là dòng thông báo lỗi");
		pnlHopDong.add(lblErrNgayKetThucHD);

		lblErrTienDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblErrTienDatCoc.setForeground(new java.awt.Color(204, 0, 0));
		lblErrTienDatCoc.setText("đây là dòng thông báo lỗi");
		pnlHopDong.add(lblErrTienDatCoc);

		lblTenHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18)); 
		lblTenHopDong.setText("Tên hợp đồng:");
		pnlHopDong.add(lblTenHopDong);

		txtMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaHopDong.setBorder(null);
		txtMaHopDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtMaHopDongActionPerformed(evt);
			}
		});
		setLayout(null);
		pnlHopDong.add(txtMaHopDong);
		pnlHopDong.add(jSeparator5);

		lblErrTenHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
		lblErrTenHopDong.setForeground(new Color(204, 0, 0));
		lblErrTenHopDong.setText("đây là dòng thông báo lỗi");
		pnlHopDong.add(lblErrTenHopDong);

		add(pnlHopDong);

		JLabel lblNguoiKyKet = new JLabel();
		lblNguoiKyKet.setText("Người ký kết:");
		lblNguoiKyKet.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNguoiKyKet.setBounds(760, 229, 130, 30);
		pnlHopDong.add(lblNguoiKyKet);

		cboNhanVien = new JComboBox<String>();
		cboNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboNhanVien.setBackground(Color.WHITE);
		cboNhanVien.setBounds(930, 225, 200, 40);
		cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoàng Huy Tới",}));
		cboNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		pnlHopDong.add(cboNhanVien);

		btnThemNhieu = new JButton();
		btnThemNhieu.setBounds(62, 434, 140, 40);
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
		btnThem.setBounds(235, 434, 140, 40);
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
		btnXoa.setBounds(406, 434, 140, 40);
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
		btnCapNhat.setBounds(576, 434, 140, 40);
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

		btnInHopDong = new JButton();
		btnInHopDong.setBounds(742, 434, 140, 40);
		add(btnInHopDong);
		btnInHopDong.setBackground(new Color(255, 218, 185));
		btnInHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnInHopDong.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/in.png")));
		btnInHopDong.setText("In hợp đồng");
		btnInHopDong.setBorder(null);
		btnInHopDong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInHopDongActionPerformed(evt);
			}
		});

		btnLuu = new JButton();
		btnLuu.setBounds(909, 434, 140, 40);
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
		btnHuy.setBounds(1083, 434, 140, 40);
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
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Danh sách hợp đồng");
		scrHopDong.setBorder(titledBorder1);

		scrHopDong.setBackground(Color.WHITE);
		tblHopDong.getTableHeader().setBackground(new Color(128, 200, 255));

		tblHopDong.setModel(new DefaultTableModel(
				new Object[][] {
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
						"STT", "M\u00E3 h\u1EE3p \u0111\u1ED3ng", "T\u00EAn h\u1EE3p \u0111\u1ED3ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ti\u1EC1n \u0111\u1EB7t c\u1ECDc", "Tr\u1ECB gi\u00E1 h\u1EE3p \u0111\u1ED3ng", "Ng\u00E0y k\u00FD k\u1EBFt H\u0110", "Ng\u00E0y k\u1EBFt th\u00FAc H\u0110", "M\u00E3 ng\u01B0\u1EDDi k\u00FD k\u1EBFt"
				}
				));
		tblHopDong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblHopDong.getTableHeader().setOpaque(false);
		((DefaultTableCellRenderer) tblHopDong.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(JLabel.CENTER);
		tblHopDong.setRowHeight(25);
		tblHopDong.setSelectionBackground(new Color(255, 215, 0));
		tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblHopDongMouseClicked(evt);
			}
		});
		scrHopDong.setViewportView(tblHopDong);
		add(scrHopDong);
		ScrollBarCustom scrollBar1 = new ScrollBarCustom();
		scrollBar1.setForeground(Color.RED);
		scrHopDong.setVerticalScrollBar(scrollBar1);

	}

	public void excute() {
		model = (DefaultTableModel) tblHopDong.getModel();

		this.txtTenHopDong.setText("");
		this.txtMaHopDong.setText("");
		this.txtTenKhachHang.setText("");
		txtTienDatCoc.setText("");
		txtTriGiaHD.setText("");
		dcsNgayKyKetHD.setDate(new Date());
		dcsNgayKetThucHD.setDate(new Date());
		txtAreaYeuCau.setText("");
		lblErrTenKhachHang.setText("");
		lblErrTenHopDong.setText("");
		lblErrTienDatCoc.setText("");
		lblErrTriGiaHD.setText("");
		lblErrNgayKiKetHD.setText("");
		lblErrNgayKetThucHD.setText("");

		btnLuu.setEnabled(false);
		btnHuy.setEnabled(false);
	}

	private void tblHopDongMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			int rowSelect = tblHopDong.getSelectedRow();
			if (rowSelect != -1) {
				hienThiDuLieuLenTxt(tblHopDong.getSelectedRow());
				setEnableForSelected(false);
				setShow(btnThem, btnCapNhat, btnXoa, btnThemNhieu);
				setHidden(btnHuy, btnLuu);
				lblErrTenKhachHang.setText("");
				lblErrTenHopDong.setText("");
				lblErrTriGiaHD.setText("");
				lblErrTienDatCoc.setText("");
				lblErrNgayKetThucHD.setText("");
				lblErrNgayKiKetHD.setText("");
			}
		} catch (ParseException ex) {
			Logger.getLogger(HopDong_GUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void taiDuLieuLenBang() throws ParseException {
		while (tblHopDong.getRowCount() != 0) {
			model.removeRow(0);
		}
		cboNhanVien.removeAllItems();
		nhanVienDao = new NhanVien_Dao();
		ArrayList<NhanVien> nhanVien = nhanVienDao.layDanhSachNhanVien();
		if (nhanVien.size() > 0) {
			for (NhanVien nv : nhanVien) {
				cboNhanVien.addItem(nv.getHoTen());
			}
			hopDongDao = new HopDong_Dao();
			ArrayList<HopDong> danhSachHopDong = hopDongDao.layDanhSachHopDong();
			for (HopDong hd : danhSachHopDong) {
				if (hd.getNguoiKyKet() != null) {
					String data[] = {(model.getRowCount() + 1) + "", hd.getMaHopDong(), hd.getTenHopDong(), hd.getTenKhachHang(), dcf.format(hd.getTienDatCoc()).replaceAll("\\,", "."),
							dcf.format(hd.getTriGiaHD()).replaceAll("\\,", "."), hd.getNgayKyKetHD().toString(), hd.getNgayKetThucHD().toString(), hd.getNguoiKyKet().getHoTen()};
					model.addRow(data);
				}
			}
			if (tblHopDong.getRowCount() != 0) {
				tblHopDong.setRowSelectionInterval(0, 0);
				hienThiDuLieuLenTxt(0);
			}
		}
	}

	public void hienThiDuLieuLenTxt(int dong) throws ParseException {
		hopDongDao = new HopDong_Dao();
		HopDong hd = hopDongDao.layRaMotHopDongTheoMaHopDong(tblHopDong.getValueAt(dong, 1).toString());

		txtMaHopDong.setText(tblHopDong.getValueAt(dong, 1).toString());
		txtTenHopDong.setText(tblHopDong.getValueAt(dong, 2).toString());
		txtTenKhachHang.setText(tblHopDong.getValueAt(dong, 3).toString());
		txtTienDatCoc.setText(tblHopDong.getValueAt(dong, 4).toString().split(" ")[0].replaceAll("\\,", "."));
		txtTriGiaHD.setText(tblHopDong.getValueAt(dong, 5).toString().split(" ")[0].replaceAll("\\,", "."));
		dcsNgayKyKetHD.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblHopDong.getValueAt(dong, 6).toString()));
		dcsNgayKetThucHD.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblHopDong.getValueAt(dong, 7).toString()));
		cboNhanVien.setSelectedItem(tblHopDong.getValueAt(dong, 8).toString());
		txtAreaYeuCau.setText(hd.getYeuCau());
		setEnableForSelected(false);
	}

	public void setEnableForSelected(boolean check) {
		txtTenKhachHang.setEditable(check);

		txtMaHopDong.setEditable(false);
		txtTenHopDong.setEditable(check);
		txtTienDatCoc.setEditable(check);
		txtTriGiaHD.setEditable(check);
		dcsNgayKyKetHD.setEnabled(check);
		dcsNgayKetThucHD.setEnabled(check);
		txtAreaYeuCau.setEditable(check);
	}

	public void setShow(JButton... btn) {
		for (JButton jButton : btn) {
			jButton.setEnabled(true);
		}
	}

	public void setHidden(JButton... btn) {
		for (JButton jButton : btn) {
			jButton.setEnabled(false);
		}
	}

	public void xoaTrangTextField() {
		txtMaHopDong.setText("");
		txtTenHopDong.setText("");
		txtTenKhachHang.setText("");
		txtTienDatCoc.setText("");
		txtTriGiaHD.setText("");
		dcsNgayKyKetHD.setDate(new Date());
		dcsNgayKetThucHD.setDate(new Date());
		txtAreaYeuCau.setText("");
		txtTenHopDong.requestFocus();

	}

	public void setEditTextDateChooser() {        
		JTextFieldDateEditor ngayKyKet = (JTextFieldDateEditor) dcsNgayKyKetHD.getDateEditor();
		JTextFieldDateEditor ngayKetThuc = (JTextFieldDateEditor) dcsNgayKetThucHD.getDateEditor();
		ngayKyKet.setEnabled(false);
		ngayKetThuc.setEnabled(false);
	}

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
		setShow(btnThem, btnXoa, btnCapNhat, btnThemNhieu);
		setHidden(btnHuy, btnLuu);
		isThem = false;
		setEnableForSelected(false);
		lblErrNgayKetThucHD.setText("");
		lblErrNgayKiKetHD.setText("");
		lblErrTenHopDong.setText("");
		lblErrTenKhachHang.setText("");
		lblErrTienDatCoc.setText("");
		lblErrTriGiaHD.setText("");
		if (tblHopDong.getRowCount() != 0) {
			try {
				hienThiDuLieuLenTxt(tblHopDong.getSelectedRow());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		setEditTextDateChooser();
	}

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {
		isThem = false;
		setEnableForSelected(true);
		setShow(btnLuu, btnHuy);
		setHidden(btnThem, btnCapNhat, btnXoa, btnThemNhieu);
		txtTienDatCoc.setText(txtTienDatCoc.getText().replaceAll(",", "").trim());
		txtTriGiaHD.setText(txtTriGiaHD.getText().replaceAll(",", "").trim());
		setEditTextDateChooser();
	}
	
	private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			nhanVienDao = new NhanVien_Dao();
			NhanVien nv = nhanVienDao.layMotNhanVienTheoTen(cboNhanVien.getSelectedItem().toString());
			System.out.println(nv.getMaNhanVien());

			String maHopDong = txtMaHopDong.getText().trim();
			String tenHopDong = txtTenHopDong.getText().trim();
			String tenKhachHang = txtTenKhachHang.getText().trim();
			double tienCoc = 0, triGiaHD = 0;
			try {
				tienCoc = Double.parseDouble(txtTienDatCoc.getText().trim());
				triGiaHD = Double.parseDouble(txtTriGiaHD.getText().trim());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Date ngayKyKet = dcsNgayKyKetHD.getDate();
			Date ngayKetThuc = dcsNgayKetThucHD.getDate();
			String yeuCau = txtAreaYeuCau.getText().trim();
			hopDongEntity = new HopDong(maHopDong, tenHopDong, tenKhachHang, tienCoc, triGiaHD, ngayKyKet, ngayKetThuc, yeuCau, nv);
			hopDongEntity.toString();
			if (isThem) {
				if (this.hopDongDao.themMotHopDong(hopDongEntity)) {
					taiDuLieuLenBang();
					JOptionPane.showMessageDialog(this,"Thêm hợp đồng thành công");
					setHidden(btnLuu, btnHuy);
					setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
					setEnableForSelected(false);
					isThem = false;
				} else {
					JOptionPane.showMessageDialog(null, "Thêm hợp đồng thất bại");
					setHidden(btnLuu, btnHuy);
					setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
					setEnableForSelected(false);
				}
			}else {
				if (this.hopDongDao.suaMotHopDong(hopDongEntity)) {
					taiDuLieuLenBang();
					JOptionPane.showMessageDialog(this, "Cập nhật hợp đồng thành công", stThongbao, JOptionPane.INFORMATION_MESSAGE);
					setHidden(btnLuu, btnHuy);
					setShow(btnThem, btnThemNhieu, btnCapNhat, btnXoa);
					setEnableForSelected(false);
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật thất bại", stThongbao, JOptionPane.INFORMATION_MESSAGE);
					setHidden(btnLuu, btnHuy);
					setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
					setEnableForSelected(false);
				}
			}
		}catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), stThongbao, JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
		setShow(btnHuy, btnLuu);
		setHidden(btnThem, btnXoa, btnCapNhat, btnThemNhieu);

		this.isThem = true;
		xoaTrangTextField();
		setEnableForSelected(true);
		if (tblHopDong.getRowHeight() > 0) {
			String maHopDong = hopDongDao.layRaMaHopDongDeThem();
			this.txtMaHopDong.setText(maHopDong);
		} else {
			txtMaHopDong.setText("PPHD100001");
		}
		setEditTextDateChooser();
	}
	
	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hợp đồng", stThongbao, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            hopDongDao = new HopDong_Dao();
            if (hopDongDao.xoaMotHopDong(tblHopDong.getValueAt(tblHopDong.getSelectedRow(), 1).toString())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công", stThongbao, JOptionPane.INFORMATION_MESSAGE);
                try {
                    taiDuLieuLenBang();
                } catch (ParseException ex) {
                    Logger.getLogger(HopDong_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, stXoaThatBai, stThongbao, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

	protected void btnInHopDongActionPerformed(ActionEvent evt) {
		Relatorio r = new Relatorio();
//		int selectedRow = tblHopDong.getSelectedRow();
//	    if (selectedRow >= 0) {
//	        // Lấy ra hợp đồng được chọn từ bảng
//	        HopDong selectedHopDong = hopDongDao.layRaMotHopDongTheoMaHopDong(tblHopDong.getValueAt(selectedRow, 1).toString());
//
//	        ThongTinHD thongTinHD = new ThongTinHD();
//	        thongTinHD.setMaHopDong(selectedHopDong.getMaHopDong());
//	        thongTinHD.setTenHopDong(selectedHopDong.getTenHopDong());
//	        thongTinHD.setTenKhachHang(selectedHopDong.getTenKhachHang());
//	        thongTinHD.setTienDatCoc((long) selectedHopDong.getTienDatCoc());
//	        thongTinHD.setTriGiaHD((long) selectedHopDong.getTriGiaHD());
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	        thongTinHD.setNgayBatDau(dateFormat.format(selectedHopDong.getNgayKyKetHD()));
//	        thongTinHD.setNgayKetThuc(dateFormat.format(selectedHopDong.getNgayKetThucHD()));
//	        thongTinHD.setYeuCau(selectedHopDong.getYeuCau());
//	    }
		try {
			r.gerarRelatorio();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void txtTenHopDongActionPerformed(ActionEvent evt) {
	}

	private void txtTenKhachHangActionPerformed(ActionEvent evt) {
	}

	private void txtTienDatCocActionPerformed(ActionEvent evt) {
	}

	private void txtTriGiaHDActionPerformed(ActionEvent evt) {
	}

	private void tblHopDongMousePressed(MouseEvent evt) {
	}

	private void btnThemNhieuActionPerformed(ActionEvent evt) {
	}

	private void txtMaHopDongActionPerformed(java.awt.event.ActionEvent evt) {
	}
}
