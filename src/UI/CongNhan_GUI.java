//package UI;
//
//import java.awt.Color;
//import java.awt.Font;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JTextField;
//import javax.swing.JSeparator;
//import javax.swing.JTable;
//
//import Custom_UI.ScrollBarCustom;
//import Dao.NhanVien_Dao;
//import Dao.PhongBan_Dao;
//import Entity.NhanVien;
//import Entity.PhongBan;
//
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JTextFieldDateEditor;
//
//import javax.swing.JRadioButton;
//import javax.swing.JScrollPane;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.text.DateFormat;
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.swing.JButton;
//import java.awt.Dimension;
//
//public class CongNhan_GUI extends JPanel {
//	private JPanel btnAnhCongNhan;
//	private JButton btnCapNhat;
//	private JButton btnHuy;
//	private JButton btnLuu;
//	private JButton btnThem;
//	private JButton btnThemNhieu;
//	private JButton btnXoa;
//	private JComboBox<String> cboPhongBan;
//	private JDateChooser dcsNgaySinh;
//	private JDateChooser dcsNgayVaoLam;
//	private JPanel panelCongNhan;
//
//	private JLabel lblAnhDaiDien;
//	private JLabel lblDiaChi;
//	private JLabel lblEmail;
//	private JLabel lblErrDiaChi;
//	private JLabel lblErrEmail;
//	private JLabel lblErrHoVaTen;
//	private JLabel lblErrNgaySinh;
//	private JLabel lblErrNgayVaoLam;
//	private JLabel lblErrSoCCCD;
//	private JLabel lblErrSoDienThoai;
//	private JLabel lblGioiTinh;
//	private JLabel lblHinhAnh;
//	private JLabel lblHoVaTen;
//	private JLabel lblLuongThoaThuan;
//	private JLabel lblMaNhanVien;
//	private JLabel lblNgaySinh;
//	private JLabel lblNgayVaoLam;
//	private JLabel lblPhongBan;
//	private JLabel lblSoCCCD;
//	private JLabel lblSoDienThoai;
//	private JRadioButton rdoNam;
//	private JRadioButton rdoNu;
//	private JScrollPane srcNhanVien;
//	private JTable tblNhanVien;
//	private JTextField txtDiaChi;
//	private JTextField txtEmail;
//	private JTextField txtHoVaTen;
//	private JTextField txtLuongThoaThuan;
//	private JTextField txtMaNhanVien;
//	private JTextField txtSoCCCD;
//	private JTextField txtSoDienThoai;
//
//	private NhanVien_Dao daoNhanVien = new NhanVien_Dao();
//	private NhanVien nhanvienEntity;
//	private DefaultTableModel model;
//	private DateFormat df = new SimpleDateFormat("yyy-MM-dd");
//	private DecimalFormat dcf = new DecimalFormat("###.00");
//	private Date date;
//	private boolean isThem = false;
//	private boolean isCapNhat = false;
//
//	private String stThongbao;
//	private String stBanXacNhanXoa;
//	private String stXoaThanhCong;
//	private String stXoaThatBai;
//	private String stThemThanhCong;
//	private String stThemThatBai;
//	private String stCapNhatThatBai;
//
//	private JSeparator jSeparator1_2;
//	private JSeparator jSeparator1_3;
//	private JSeparator jSeparator1_4;
//	private JSeparator jSeparator1_5;
//	private JSeparator jSeparator1_6;
//	private JLabel lblTieuDe;
//
//
//	public CongNhan_GUI() throws Exception {
//		setBackground(new Color(255, 255, 255));
//		initComponents();
//		//caiDatNgonNguChoView(fileName);
//		excute();
//		taiDuLieuLenBang();
//		this.txtMaNhanVien.setEditable(false);
//
//	}
//
//	public void excute() throws Exception {
//		model = (DefaultTableModel) tblNhanVien.getModel();
//		tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//		tblNhanVien.getTableHeader().setOpaque(false);
//		((DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer())
//		.setHorizontalAlignment(JLabel.CENTER);
//		tblNhanVien.setRowHeight(25);
//		ButtonGroup btnGroup = new ButtonGroup();
//		btnGroup.add(rdoNam);
//		btnGroup.add(rdoNu);
//		btnLuu.setEnabled(false);
//		btnHuy.setEnabled(false);
//		ConnectionDB.ConnectDB.getInstance().connect();
//		setInit();
//	}
//
//	private void initComponents() {
//		panelNhanVien = new JPanel();
//		panelNhanVien.setBounds(26, 50, 1231, 422);
//		lblHinhAnh = new JLabel();
//		lblHinhAnh.setBounds(40, 100, 128, 128);
//		btnAnhNhanVien = new JPanel();
//		btnAnhNhanVien.setBounds(40, 260, 120, 40);
//		btnAnhNhanVien.setBackground(Color.PINK);
//		lblAnhDaiDien = new JLabel();
//		lblAnhDaiDien.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		lblErrHoVaTen = new JLabel();
//		lblErrHoVaTen.setBounds(930, 70, 290, 29);
//		txtHoVaTen = new JTextField();
//		txtHoVaTen.setBackground(Color.WHITE);
//		txtHoVaTen.setBounds(930, 30, 290, 40);
//		lblHoVaTen = new JLabel();
//		lblHoVaTen.setBounds(780, 40, 140, 40);
//		txtEmail = new JTextField();
//		txtEmail.setBackground(Color.WHITE);
//		txtEmail.setBounds(930, 100, 290, 40);
//		lblErrEmail = new JLabel();
//		lblErrEmail.setBounds(930, 140, 290, 29);
//		lblEmail = new JLabel();
//		lblEmail.setBounds(780, 100, 140, 40);
//		txtSoCCCD = new JTextField();
//		txtSoCCCD.setBackground(Color.WHITE);
//		txtSoCCCD.setBounds(420, 81, 280, 38);
//		lblErrSoCCCD = new JLabel();
//		lblErrSoCCCD.setBounds(420, 130, 290, 18);
//		lblSoCCCD = new JLabel();
//		lblSoCCCD.setBounds(270, 100, 140, 40);
//		txtMaNhanVien = new JTextField();
//		txtMaNhanVien.setBackground(Color.WHITE);
//		txtMaNhanVien.setBounds(420, 30, 280, 40);
//		lblMaNhanVien = new JLabel();
//		lblMaNhanVien.setBounds(270, 40, 140, 40);
//		txtSoDienThoai = new JTextField();
//		txtSoDienThoai.setBackground(Color.WHITE);
//		txtSoDienThoai.setBounds(420, 150, 280, 38);
//		lblErrNgaySinh = new JLabel();
//		lblErrNgaySinh.setBounds(420, 260, 300, 18);
//		lblChucVu = new JLabel();
//		lblChucVu.setBounds(780, 290, 130, 40);
//		lblErrDiaChi = new JLabel();
//		lblErrDiaChi.setBounds(930, 200, 280, 28);
//		txtDiaChi = new JTextField();
//		txtDiaChi.setBackground(Color.WHITE);
//		txtDiaChi.setBounds(930, 160, 290, 40);
//		lblGioiTinh = new JLabel();
//		lblGioiTinh.setBounds(780, 220, 140, 40);
//		lblErrLuongThoaThuan = new JLabel();
//		lblErrLuongThoaThuan.setBounds(930, 390, 280, 29);
//		txtLuongThoaThuan = new JTextField();
//		txtLuongThoaThuan.setBackground(Color.WHITE);
//		txtLuongThoaThuan.setBounds(930, 350, 290, 40);
//		lblLuongThoaThuan = new JLabel();
//		lblLuongThoaThuan.setBounds(780, 361, 140, 40);
//		lblDiaChi = new JLabel();
//		lblDiaChi.setBounds(780, 160, 140, 40);
//		rdoNam = new JRadioButton();
//		rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		rdoNam.setBackground(Color.WHITE);
//		rdoNam.setBounds(930, 230, 71, 30);
//		rdoNu = new JRadioButton();
//		rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		rdoNu.setBackground(Color.WHITE);
//		rdoNu.setBounds(1020, 230, 64, 30);
//		dcsNgaySinh = new JDateChooser();
//		dcsNgaySinh.setBackground(Color.WHITE);
//		dcsNgaySinh.setBounds(420, 220, 280, 40);
//		cboPhongBan = new JComboBox<>();
//		cboPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		cboPhongBan.setBackground(Color.WHITE);
//		cboPhongBan.setBounds(420, 290, 280, 40);
//		cboChucVu = new JComboBox<>();
//		cboChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		cboChucVu.setBackground(Color.WHITE);
//		cboChucVu.setBounds(930, 290, 290, 40);
//		lblSoDienThoai = new JLabel();
//		lblSoDienThoai.setBounds(270, 160, 140, 40);
//		lblNgaySinh = new JLabel();
//		lblNgaySinh.setBounds(270, 220, 140, 40);
//		lblErrSoDienThoai = new JLabel();
//		lblErrSoDienThoai.setBounds(420, 190, 300, 18);
//		lblPhongBan = new JLabel();
//		lblPhongBan.setBounds(270, 290, 130, 40);
//		dcsNgayVaoLam = new JDateChooser();
//		dcsNgayVaoLam.setBackground(Color.WHITE);
//		dcsNgayVaoLam.setBounds(420, 350, 280, 40);
//		lblNgayVaoLam = new JLabel();
//		lblNgayVaoLam.setBounds(270, 350, 140, 40);
//		lblErrNgayVaoLam = new JLabel();
//		lblErrNgayVaoLam.setBounds(420, 390, 320, 18);
//		srcNhanVien = new JScrollPane();
//		srcNhanVien.setBounds(10, 548, 1257, 167);
//		tblNhanVien = new JTable();
//
//		setPreferredSize(new Dimension(1290, 750));
//
//		LineBorder blackLineBorder = new LineBorder(Color.BLACK, 2);
//		TitledBorder titledBorder = BorderFactory.createTitledBorder(blackLineBorder, "Thông tin nhân viên");
//		panelNhanVien.setBorder(titledBorder);
//		panelNhanVien.setBackground(new Color(255, 255, 255));
//		panelNhanVien.setPreferredSize(new Dimension(1250, 500));
//		panelNhanVien.setLayout(null);
//
//		lblHinhAnh.setBackground(new Color(153, 0, 0));
//		lblHinhAnh.setForeground(new Color(255, 0, 51));
//		lblHinhAnh.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/anhNhanVien/man.png")));
//		panelNhanVien.add(lblHinhAnh);
//
//		lblAnhDaiDien.setHorizontalAlignment(SwingConstants.CENTER);
//		lblAnhDaiDien.setText("Ảnh đại diện");
//		lblAnhDaiDien.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent evt) {
//				lblAnhDaiDienMouseClicked(evt);
//			}
//		});
//
//		javax.swing.GroupLayout btnAnhDaiDienLayout = new javax.swing.GroupLayout(btnAnhNhanVien);
//		btnAnhNhanVien.setLayout(btnAnhDaiDienLayout);
//		btnAnhDaiDienLayout.setHorizontalGroup(
//				btnAnhDaiDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAnhDaiDienLayout.createSequentialGroup()
//						.addGap(0, 0, Short.MAX_VALUE)
//						.addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
//				);
//		btnAnhDaiDienLayout.setVerticalGroup(
//				btnAnhDaiDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAnhDaiDienLayout.createSequentialGroup()
//						.addGap(0, 0, Short.MAX_VALUE)
//						.addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
//				);
//		panelNhanVien.add(btnAnhNhanVien);
//
//		lblErrHoVaTen.setFont(new Font("Segoe UI", 0, 13));
//		lblErrHoVaTen.setForeground(new Color(204, 0, 0));
//		lblErrHoVaTen.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrHoVaTen);
//
//		txtHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtHoVaTen.setBorder(null);
//		panelNhanVien.add(txtHoVaTen);
//
//		lblHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblHoVaTen.setText("Họ và tên:");
//		panelNhanVien.add(lblHoVaTen);
//
//		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtEmail.setBorder(null);
//		panelNhanVien.add(txtEmail);
//
//		lblErrEmail.setFont(new Font("Segoe UI", 0, 13));
//		lblErrEmail.setForeground(new Color(204, 0, 0));
//		lblErrEmail.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrEmail);
//
//		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblEmail.setText("Email:");
//		panelNhanVien.add(lblEmail);
//
//		txtSoCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtSoCCCD.setBorder(null);
//		panelNhanVien.add(txtSoCCCD);
//
//		lblErrSoCCCD.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrSoCCCD.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrSoCCCD.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrSoCCCD);
//
//		lblSoCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblSoCCCD.setText("Số CCCD:");
//		panelNhanVien.add(lblSoCCCD);
//
//		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtMaNhanVien.setBorder(null);
//		panelNhanVien.add(txtMaNhanVien);
//
//		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblMaNhanVien.setText("Mã nhân viên:");
//		panelNhanVien.add(lblMaNhanVien);
//
//		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtSoDienThoai.setBorder(null);
//		panelNhanVien.add(txtSoDienThoai);
//
//		lblErrNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrNgaySinh.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrNgaySinh.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrNgaySinh);
//
//		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblChucVu.setText("Chức vụ");
//		panelNhanVien.add(lblChucVu);
//
//		lblErrDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrDiaChi.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrDiaChi.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrDiaChi);
//
//		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtDiaChi.setBorder(null);
//		panelNhanVien.add(txtDiaChi);
//
//		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblGioiTinh.setText("Giới tính");
//		panelNhanVien.add(lblGioiTinh);
//
//		lblErrLuongThoaThuan.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrLuongThoaThuan.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrLuongThoaThuan.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrLuongThoaThuan);
//
//		txtLuongThoaThuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		txtLuongThoaThuan.setBorder(null);
//		panelNhanVien.add(txtLuongThoaThuan);
//
//		lblLuongThoaThuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblLuongThoaThuan.setText("Lương thỏa thuận:");
//		panelNhanVien.add(lblLuongThoaThuan);
//
//		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblDiaChi.setText("Địa chỉ:");
//		panelNhanVien.add(lblDiaChi);
//
//		rdoNam.setSelected(true);
//		rdoNam.setText("Nam");
//		rdoNam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//		rdoNam.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				rdoNamActionPerformed(evt);
//			}
//		});
//		panelNhanVien.add(rdoNam);
//
//		rdoNu.setText("Nữ");
//		rdoNu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//		rdoNu.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				rdoNuActionPerformed(evt);
//			}
//		});
//		panelNhanVien.add(rdoNu);
//
//		dcsNgaySinh.setDateFormatString("yyyy-MM-dd");
//		dcsNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseExited(java.awt.event.MouseEvent evt) {
//				dcsNgaySinhMouseExited(evt);
//			}
//		});
//		dcsNgaySinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
//			public void propertyChange(java.beans.PropertyChangeEvent evt) {
//				dcsNgaySinhPropertyChange(evt);
//			}
//		});
//		panelNhanVien.add(dcsNgaySinh);
//
//		cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng tài chính", "Phòng kinh doanh", "Phòng nhân sự" }));
//		cboPhongBan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//		panelNhanVien.add(cboPhongBan);
//
//		cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên","Trưởng phòng"}));
//		cboChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
//		cboChucVu.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				cboChucVuActionPerformed(evt);
//			}
//		});
//		setLayout(null);
//		panelNhanVien.add(cboChucVu);
//
//		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblSoDienThoai.setText("Số điện thoại:");
//		panelNhanVien.add(lblSoDienThoai);
//
//		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblNgaySinh.setText("Ngày sinh:");
//		panelNhanVien.add(lblNgaySinh);
//
//		lblErrSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrSoDienThoai.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrSoDienThoai.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrSoDienThoai);
//
//		lblPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblPhongBan.setText("Phòng ban:");
//		panelNhanVien.add(lblPhongBan);
//
//		dcsNgayVaoLam.setDateFormatString("yyyy-MM-dd");
//		panelNhanVien.add(dcsNgayVaoLam);
//
//		lblNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		lblNgayVaoLam.setText("Ngày vào làm:");
//		panelNhanVien.add(lblNgayVaoLam);
//
//		lblErrNgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 13));
//		lblErrNgayVaoLam.setForeground(new java.awt.Color(204, 0, 0));
//		lblErrNgayVaoLam.setText("đây là dòng thông báo lỗi");
//		panelNhanVien.add(lblErrNgayVaoLam);
//
//		add(panelNhanVien);
//
//		JSeparator jSeparator1 = new JSeparator();
//		jSeparator1.setForeground(Color.BLACK);
//		jSeparator1.setBounds(420, 70, 280, 10);
//		panelNhanVien.add(jSeparator1);
//
//		JSeparator jSeparator1_1 = new JSeparator();
//		jSeparator1_1.setForeground(Color.BLACK);
//		jSeparator1_1.setBounds(420, 120, 280, 10);
//		panelNhanVien.add(jSeparator1_1);
//
//		jSeparator1_2 = new JSeparator();
//		jSeparator1_2.setForeground(Color.BLACK);
//		jSeparator1_2.setBounds(420, 188, 280, 10);
//		panelNhanVien.add(jSeparator1_2);
//
//		jSeparator1_3 = new JSeparator();
//		jSeparator1_3.setForeground(Color.BLACK);
//		jSeparator1_3.setBounds(930, 70, 290, 10);
//		panelNhanVien.add(jSeparator1_3);
//
//		jSeparator1_4 = new JSeparator();
//		jSeparator1_4.setForeground(Color.BLACK);
//		jSeparator1_4.setBounds(930, 140, 290, 10);
//		panelNhanVien.add(jSeparator1_4);
//
//		jSeparator1_5 = new JSeparator();
//		jSeparator1_5.setForeground(Color.BLACK);
//		jSeparator1_5.setBounds(930, 200, 290, 10);
//		panelNhanVien.add(jSeparator1_5);
//
//		jSeparator1_6 = new JSeparator();
//		jSeparator1_6.setForeground(Color.BLACK);
//		jSeparator1_6.setBounds(930, 390, 290, 10);
//		panelNhanVien.add(jSeparator1_6);
//
//		btnThemNhieu = new JButton();
//		btnThemNhieu.setBounds(51, 483, 170, 40);
//		add(btnThemNhieu);
//
//		btnThemNhieu.setBackground(new Color(255, 215, 0));
//		btnThemNhieu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnThemNhieu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
//		btnThemNhieu.setText("Thêm nhiều");
//		btnThemNhieu.setBorder(null);
//		btnThem = new JButton();
//		btnThem.setBounds(260, 483, 170, 40);
//		add(btnThem);
//
//		btnThem.setBackground(new Color(255, 215, 0));
//		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnThem.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/them.png")));
//		btnThem.setText("Thêm");
//		btnThem.setBorder(null);
//		btnXoa = new JButton();
//		btnXoa.setBounds(474, 483, 160, 40);
//		add(btnXoa);
//
//		btnXoa.setBackground(new Color(255, 215, 0));
//		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnXoa.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/xoa.png")));
//		btnXoa.setText("Xóa");
//		btnXoa.setBorder(null);
//		btnCapNhat = new JButton();
//		btnCapNhat.setBounds(666, 483, 160, 40);
//		add(btnCapNhat);
//		btnCapNhat.setBackground(new Color(255, 215, 0));
//
//		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnCapNhat.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/capNhat.png")));
//		btnCapNhat.setText("Cập nhật");
//		btnCapNhat.setBorder(null);
//		btnLuu = new JButton();
//		btnLuu.setBounds(861, 483, 160, 40);
//		add(btnLuu);
//
//		btnLuu.setBackground(new Color(255, 0, 255));
//		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnLuu.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/luu.png")));
//		btnLuu.setText("Lưu");
//		btnLuu.setBorder(null);
//		btnHuy = new JButton();
//		btnHuy.setBounds(1053, 482, 170, 40);
//		add(btnHuy);
//
//		btnHuy.setBackground(new Color(255, 0, 255));
//		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//		btnHuy.setIcon(new ImageIcon(NhanVien_GUI.class.getResource("/image/icon/huy.png")));
//		btnHuy.setText("Hủy");
//		btnHuy.setBorder(null);
//
//		lblTieuDe = new JLabel("QUẢN LÝ NHÂN VIÊN");
//		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		lblTieuDe.setBounds(543, 11, 296, 40);
//		add(lblTieuDe);
//		btnHuy.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnHuyActionPerformed(evt);
//			}
//		});
//		btnLuu.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnLuuActionPerformed(evt);
//			}
//		});
//		btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnCapNhatActionPerformed(evt);
//			}
//		});
//		btnXoa.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnXoaActionPerformed(evt);
//			}
//		});
//		btnThem.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnThemActionPerformed(evt);
//			}
//		});
//		btnThemNhieu.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				//btnThemNhieuActionPerformed(evt);
//			}
//		});
//
//		LineBorder blackLineBorder1 = new LineBorder(Color.BLACK, 2);
//		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Danh sách nhân viên");
//		srcNhanVien.setBorder(titledBorder1);
//
//		srcNhanVien.setBackground(Color.WHITE);
//		tblNhanVien.getTableHeader().setBackground(new Color(128, 200, 255));
//
//		tblNhanVien.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"STT", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "S\u00F4 CCCd", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "\u1EA2nh \u0111\u1EA1i di\u1EC7n", "Email", "Ph\u00F2ng Ban", "Ch\u1EE9c v\u1EE5", "Ng\u00E0y v\u00E0o l\u00E0m", "L\u01B0\u01A1ng th\u1ECFa thu\u1EADn"
//			}
//		));
//		tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(35);
//		tblNhanVien.getColumnModel().getColumn(13).setPreferredWidth(101);
//		tblNhanVien.setSelectionBackground(new Color(255, 215, 0));
//		tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				tblNhanVienMouseClicked(evt);
//			}
//		});
//		srcNhanVien.setViewportView(tblNhanVien);
//		add(srcNhanVien);
//		ScrollBarCustom scrollBar = new ScrollBarCustom();
//		scrollBar.setForeground(Color.RED);
//		srcNhanVien.setVerticalScrollBar(scrollBar);
//	}
//
//	private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {
//		lblErrHoVaTen.setText("");
//		lblErrSoCCCD.setText("");
//		lblErrSoDienThoai.setText("");
//		lblErrEmail.setText("");
//		lblErrNgaySinh.setText("");
//		lblErrNgayVaoLam.setText("");
//		lblErrLuongThoaThuan.setText("");
//		lblErrDiaChi.setText("");
//		try {
//			setHidden(btnLuu, btnHuy);
//			setShow(btnThem, btnXoa, btnCapNhat, btnThemNhieu);
//			hienThiDuLieuLenTxt(tblNhanVien.getSelectedRow());
//			setEnableForInput(false);
//		} catch (ParseException ex) {
//			JOptionPane.showMessageDialog(null, "ERRO");
//
//		}
//		setEditTextDateChooser();
//	}
//
//	public void setInit() {
//		lblErrHoVaTen.setText("");
//		lblErrSoCCCD.setText("");
//		lblErrEmail.setText("");
//		lblErrSoDienThoai.setText("");
//		lblErrDiaChi.setText("");
//		lblErrNgaySinh.setText("");
//		lblErrNgayVaoLam.setText("");
//		lblErrLuongThoaThuan.setText("");
//	}
//
//	public void hienThiDuLieuLenTxt(int dong) throws ParseException {
//
//		txtMaNhanVien.setText(tblNhanVien.getValueAt(dong, 1).toString());
//		txtHoVaTen.setText(tblNhanVien.getValueAt(dong, 2).toString());
//		txtSoCCCD.setText(tblNhanVien.getValueAt(dong, 3).toString());
//		if (rdoNam.getText() == tblNhanVien.getValueAt(dong, 4).toString()) {
//			rdoNam.setSelected(true);
//		} else {
//			rdoNu.setSelected(true);
//		}
//		dcsNgaySinh.setDate(df.parse(tblNhanVien.getValueAt(dong, 5).toString()));
//		txtSoDienThoai.setText(tblNhanVien.getValueAt(dong, 6).toString());
//		txtDiaChi.setText(tblNhanVien.getValueAt(dong, 7).toString());
//		txtEmail.setText(tblNhanVien.getValueAt(dong, 9).toString());
//		cboPhongBan.setSelectedItem(tblNhanVien.getValueAt(dong, 10).toString());
//		cboChucVu.setSelectedItem(tblNhanVien.getValueAt(dong, 11).toString());
//		dcsNgayVaoLam.setDate(df.parse(tblNhanVien.getValueAt(dong, 12).toString()));
//		txtLuongThoaThuan.setText(tblNhanVien.getValueAt(dong, 13).toString().replaceAll("\\,", "."));
//		lblHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/anhNhanVien/" + tblNhanVien.getValueAt(dong, 8))));
//	}
//
//	private void lblAnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {
//		JFileChooser fileChooser = new JFileChooser("d:");
//		fileChooser.setCurrentDirectory(new File(".\\src\\image\\anhNhanVien"));
//		int respone = fileChooser.showSaveDialog(null);
//		if (respone == JFileChooser.APPROVE_OPTION) {
//			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
//			System.out.println(file);
//			String path = file.toString().split("src")[1].replace('\\', '/');
//			System.out.println("path file split: " + file.toString().split("src")[1]);
//			this.lblHinhAnh.setIcon(new ImageIcon(this.getClass().getResource(path)));
//			System.out.println(this.lblHinhAnh.getIcon().toString());
//		}
//	}
//
//	public void taiDuLieuLenBang() throws ParseException {
//		while (tblNhanVien.getRowCount() != 0) {
//			model.removeRow(0);
//		}
//		cboPhongBan.removeAllItems();
//		PhongBan_Dao daoPhongBan = new PhongBan_Dao();
//		ArrayList<PhongBan> phongBan = daoPhongBan.layDanhSachPhongBan();
//		if (phongBan.size() > 0) {
//			for (PhongBan pb : phongBan) {
//				cboPhongBan.addItem(pb.getTenPhongBan());
//			}
//			ArrayList<NhanVien> danhSachNhanVien = daoNhanVien.layDanhSachNhanVien();
//			for (NhanVien nv : danhSachNhanVien) {
//				String data[] = {(model.getRowCount() + 1) + "", nv.getMaNhanVien(), nv.getHoTen(), nv.getMaCCCD(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getNgaySinh().toString(),
//						nv.getSoDienThoai(), nv.getDiaChi(), nv.getAnhDaiDien(), nv.getEmail(), nv.getPhongBan().getTenPhongBan(),
//						nv.getChucVu(), nv.getNgayVaoLam().toString(), dcf.format(nv.getLuongCoBan()).replaceAll("\\,", ".")};
//				model.addRow(data);
//			}
//			if (tblNhanVien.getRowCount() != 0) {
//				tblNhanVien.setRowSelectionInterval(0, 0);
//				hienThiDuLieuLenTxt(0);
//			}
//		}
//	}
//
//	public void setHidden(JButton... btnHidden) {
//		for (JButton jButton : btnHidden) {
//			jButton.setEnabled(false);
//		}
//	}
//
//	public void setEnableForInput(boolean kq) {
//		this.txtHoVaTen.setEditable(kq);
//		this.txtSoCCCD.setEditable(kq);
//		this.txtEmail.setEditable(kq);
//		this.txtSoDienThoai.setEditable(kq);
//		this.txtDiaChi.setEditable(kq);
//		//this.dcsNgaySinh.setEnabled(kq);
//		//this.rdoNam.setEnabled(kq);
//		//this.rdoNu.setEnabled(kq);
//		//this.cboPhongBan.setEnabled(kq);
//		//this.cboChucVu.setEnabled(kq);
//		//this.dcsNgayVaoLam.setEnabled(kq);
//		this.txtLuongThoaThuan.setEditable(kq);
//		//this.lblAnhDaiDien.setEnabled(kq);
//	}
//
//	public void setShow(JButton... btnHidden) {
//		for (JButton jButton : btnHidden) {
//			jButton.setEnabled(true);
//		}
//	}
//
//	public void setEditTextDateChooser() {
//		JTextFieldDateEditor ngaySinh = (JTextFieldDateEditor) dcsNgaySinh.getDateEditor();
//		JTextFieldDateEditor ngayVaoLam = (JTextFieldDateEditor) dcsNgayVaoLam.getDateEditor();
//		ngaySinh.setEnabled(false);
//		ngayVaoLam.setEnabled(false);
//	}
//	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
//		setHidden(btnThem, btnXoa, btnCapNhat, btnThemNhieu);
//		setShow(btnLuu, btnHuy);
//		String EmployeeID = daoNhanVien.layRaMaNhanVienDeThem();
//		this.txtMaNhanVien.setText(EmployeeID);
//
//		this.txtHoVaTen.setText("");
//		this.txtSoCCCD.setText("");
//		this.txtEmail.setText("");
//		this.txtSoDienThoai.setText("");
//		this.txtDiaChi.setText("");
//		this.dcsNgaySinh.setDate(new Date());
//		this.rdoNam.setSelected(true);
//		this.cboPhongBan.setSelectedIndex(0);
//		this.cboChucVu.setSelectedIndex(0);
//		this.dcsNgayVaoLam.setDate(new Date());
//		this.txtLuongThoaThuan.setText("");
//		lblHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/anhNhanVien/man.png")));
//		setEnableForInput(true);
//		isThem = true;
//		setEditTextDateChooser();
//	}
//
//	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
//		int rowSelected = tblNhanVien.getSelectedRow();
//		if (rowSelected != -1) {
//			if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không","Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//				if (daoNhanVien.xoaMotNhanVienTheoMa(tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 1).toString())) {
//					JOptionPane.showMessageDialog(null, stXoaThanhCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
//					try {
//						taiDuLieuLenBang();
//					} catch (ParseException ex) {
//						JOptionPane.showMessageDialog(null, "Lỗi!!!", stThongbao, JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//			}
//		}
//	}
//
//	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {
//		setHidden(btnThem, btnXoa, btnCapNhat);
//		setShow(btnLuu, btnHuy);
//		setEnableForInput(true);
//		txtLuongThoaThuan.setText(txtLuongThoaThuan.getText().replaceAll(",", ""));
//		isCapNhat = true;
//		setEditTextDateChooser();
//		isThem = false;
//	}
//
//	private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
//		try {
//			PhongBan_Dao dao = new PhongBan_Dao();
//			PhongBan pb = dao.layMotPhongBanTheoTen(cboPhongBan.getSelectedItem().toString());
//			System.out.println(pb.getMaPhongBan());
//			String tienLuong = txtLuongThoaThuan.getText();
//			if (txtLuongThoaThuan.getText().contains(",")) {
//				tienLuong = txtLuongThoaThuan.getText().replaceAll(",", "");
//			}
//			if (dcsNgaySinh.getDate() != null && dcsNgayVaoLam.getDate() != null) {
//				nhanvienEntity = new NhanVien(txtMaNhanVien.getText(), txtHoVaTen.getText(), dcsNgaySinh.getDate(),
//						txtSoCCCD.getText(), txtSoDienThoai.getText(), txtEmail.getText(), "111111", cboChucVu.getSelectedItem().toString(),
//						dcsNgayVaoLam.getDate(), Double.parseDouble(tienLuong), rdoNam.isSelected(), lblHinhAnh.getIcon().toString().split("anhNhanVien/")[1], txtDiaChi.getText(), pb);
//				nhanvienEntity.toString();
//				if (isThem) {
//					if (this.daoNhanVien.themMotNhanVien(nhanvienEntity)) {
//						taiDuLieuLenBang();
//						JOptionPane.showMessageDialog(this,"Thêm nhân viên thành công");
//						setHidden(btnLuu, btnHuy);
//						setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
//						setEnableForInput(false);
//						isThem = false;
//					} else {
//						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại");
//						setHidden(btnLuu, btnHuy);
//						setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
//						setEnableForInput(false);
//					}
//				} else {
//					if (this.daoNhanVien.suaThongTinMotNhanVien(nhanvienEntity)) {
//						taiDuLieuLenBang();
//						JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công", stThongbao, JOptionPane.INFORMATION_MESSAGE);
//						setHidden(btnLuu, btnHuy);
//						setShow(btnThem, btnThemNhieu, btnCapNhat, btnXoa);
//						setEnableForInput(false);
//					} else {
//						JOptionPane.showMessageDialog(null, stCapNhatThatBai, stThongbao, JOptionPane.INFORMATION_MESSAGE);
//						setHidden(btnLuu, btnHuy);
//						setShow(btnThem, btnThemNhieu, btnXoa, btnCapNhat);
//						setEnableForInput(false);
//					}
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "ERROR: NgayVaoLam cannot be null");
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR");
//		}
//	}
//
//	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
//		setHidden(btnLuu, btnHuy);
//		setShow(btnXoa, btnCapNhat, btnThemNhieu, btnThem);
//		tblNhanVien.setRowSelectionInterval(0, 0);
//		setEnableForInput(false);
//		try {
//			hienThiDuLieuLenTxt(0);
//		} catch (ParseException ex) {
//			Logger.getLogger(NhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		isThem = false;
//		isCapNhat = false;
//		setInit();
//	}
//
//	private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {
//	}
//	
//	private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {
//	}
//	
//	private void cboChucVuActionPerformed(java.awt.event.ActionEvent evt) {
//	}
//	
//	private void dcsNgaySinhPropertyChange(java.beans.PropertyChangeEvent evt) {
//	}
//	
//	private void dcsNgaySinhMouseExited(java.awt.event.MouseEvent evt) {
//	}
//	
//}
