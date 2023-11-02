package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Custom_UI.ScrollBarCustom;
import Dao.ChamCongNhanVien_Dao;
import Dao.NhanVien_Dao;
import Entity.ChamCongNhanVien;
import Entity.NhanVien;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JButton;

public class ChamCongNhanVien_GUI extends JPanel {

    private static final long serialVersionUID = 1L;
    
	private JScrollPane scrChamCong;
	private JTable tblChamCong;
	private JTextField txtMaNV;
	private JTextField txtTenNV;

	private JComboBox<String> cmbCaLam;
	private JComboBox<String> cmbGio;
	private JComboBox<String> cmbPhut;
	private JComboBox<String> cmbTinhTrang;

	private JScrollPane scrNhanVien;
	private JTable tblNhanVien;
	private JLabel lblTieuDe;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblPhut;
	private JLabel lblCaLam;
	private JLabel lblGioDiLam;
	private JLabel lblGioTangCa;
	private JLabel lblTinhTrang;
	private JLabel lblNgayChamCong;
	private JDateChooser dcsNgayChamCong;
	private JPanel pnlThongTinChamCong;
	private JComboBox<String> cmbGioTangCa;
	private JComboBox<String> cmbPhutTangCa;
	private JButton btnLayDanhSach;
	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnChamCongTatCa;
	private JButton btnChamLai;
	private JButton btnCapNhat;

	private DefaultTableModel modelNhanVien;
	private DefaultTableModel modelChamCong;
	private NhanVien_Dao daoNhanVien;
	private ChamCongNhanVien_Dao daoChamCong;
	private ArrayList<NhanVien> listNhanVien;
	ArrayList<NhanVien> listNhanVienForEvtChamCongTatCa;
	private boolean checkChamCong = false;


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
	private String stErrHoTen;
	private String stErrSoCCCD;
	private String stErrEmail;
	private String stErrSdt;
	private String stErrNgaySinh;
	private String stErrNgayVaoLam;
	private String stErrNhanVienKhongDuTuoi;
	private String stErrTienKhongHopLe;
	private String stSoTienLonHonKhong;
	private String stChamCongThanhCong;
	private String stErrNgayChamCong;
	private NhanVien nhanvienDangNhap;
	private String stNgayThangKhongHople;
	


	public ChamCongNhanVien_GUI(NhanVien nhanVien) throws ParseException, Exception {
		nhanvienDangNhap = nhanVien;
        ConnectionDB.ConnectDB.getInstance().connect();
        initComponents();
        excute();
        taiDuLieuLenBangNhanVien();
        while (modelChamCong.getRowCount() != 0) {
            modelChamCong.removeRow(0);
        }
        dcsNgayChamCong.setDate(new Date());
        btnChamCongTatCa.setEnabled(false);
        cmbCaLam.setSelectedIndex(0);
        
        JLabel lblGio = new JLabel();
        lblGio.setText("giờ");
        lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblGio.setBounds(216, 195, 57, 30);
        pnlThongTinChamCong.add(lblGio);
        
        JLabel lblGio_1 = new JLabel();
        lblGio_1.setText("giờ");
        lblGio_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblGio_1.setBounds(216, 324, 57, 30);
        pnlThongTinChamCong.add(lblGio_1);
        btnChamLai.setEnabled(false);
        setEditTextDateChooser();
	}
	
	public void setEditTextDateChooser() {
        JTextFieldDateEditor ngayChamCong = (JTextFieldDateEditor) dcsNgayChamCong.getDateEditor();
        ngayChamCong.setEnabled(false);

    }

	public void excute() throws ParseException {
        tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblNhanVien.getTableHeader().setOpaque(false);
        ((DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        tblNhanVien.setRowHeight(25);

        tblChamCong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblChamCong.getTableHeader().setOpaque(false);
        ((DefaultTableCellRenderer) tblChamCong.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        tblChamCong.setRowHeight(25);
        
        modelNhanVien = (DefaultTableModel) tblNhanVien.getModel();
        modelChamCong = (DefaultTableModel) tblChamCong.getModel();
        setHidden(btnLuu, btnHuy, btnChamLai);
        setShow(btnCapNhat);
    }
	
	private void initComponents() {
		setBackground(new Color(255, 255, 255));
		setSize(1290, 750);
		setLayout(null);

		lblTieuDe = new JLabel("CHẤM CÔNG NHÂN VIÊN");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblTieuDe.setBounds(44, 11, 299, 50);
		add(lblTieuDe);

		tblChamCong = new JTable();
		tblChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tblChamCong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblChamCong.setRowHeight(20);

		tblChamCong.setModel(new DefaultTableModel(
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
		tblChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblChamCongMouseClicked(evt);
			}
		});

		tblChamCong.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblChamCong.getColumnModel().getColumn(0).setMinWidth(20);
		tblChamCong.getColumnModel().getColumn(0).setMaxWidth(40);
		tblChamCong.getColumnModel().getColumn(1).setPreferredWidth(72);
		tblChamCong.getColumnModel().getColumn(2).setPreferredWidth(76);
		tblChamCong.getColumnModel().getColumn(3).setPreferredWidth(86);

		tblChamCong.getTableHeader().setBackground(new Color(128, 200, 255));
		tblChamCong.setSelectionBackground(new Color(255, 215, 0));


		scrChamCong = new JScrollPane(tblChamCong);
		scrChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrChamCongMouseClicked(evt);
            }
        });
		LineBorder blackLineBorder = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(blackLineBorder, "Danh sách nhân viên cần chấm công");
		scrChamCong.setBorder(titledBorder);
		scrChamCong.setBackground(Color.WHITE);
		scrChamCong.setBounds(44, 84, 639, 286);
		add(scrChamCong);

		ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.RED);
		scrChamCong.setVerticalScrollBar(scrollBar);

		lblNgayChamCong = new JLabel();
		lblNgayChamCong.setText("Ngày chấm công:");
		lblNgayChamCong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgayChamCong.setBounds(74, 381, 115, 41);
		add(lblNgayChamCong);

		dcsNgayChamCong = new JDateChooser();
		dcsNgayChamCong.setDateFormatString("yyyy-MM-dd");
		dcsNgayChamCong.setBounds(198, 381, 177, 41);
		dcsNgayChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dcsNgayChamCongMouseClicked(evt);
			}
		});
		dcsNgayChamCong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				dcsNgayChamCongPropertyChange(evt);
			}
		});
		add(dcsNgayChamCong);

		JLabel lblMuiTen = new JLabel();
		lblMuiTen.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/muitenNgang.png")));
		lblMuiTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMuiTen.setBounds(704, 240, 57, 30);
		add(lblMuiTen);

		tblNhanVien = new JTable();
		tblNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tblNhanVien.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblNhanVien.setRowHeight(20);

		tblNhanVien.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
						"STT", "Mã người chấm", "Mã nhân viên", "Họ và tên", "SĐT", "Phòng ban", "Chức vụ", "Ngày chấm công", "Ca làm", "Trạng thái", "Giờ đi làm","Giờ tăng ca"
				}
				));
		tblNhanVien.setSelectionBackground(new java.awt.Color(232, 57, 95));
		tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblNhanVienMouseClicked(evt);
			}
		});

		tblNhanVien.getTableHeader().setBackground(new Color(128, 200, 255));
		tblNhanVien.setSelectionBackground(new Color(255, 215, 0));


		scrNhanVien = new JScrollPane(tblNhanVien);
		LineBorder blackLineBorder1 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Danh sách chấm công nhân viên");
		scrNhanVien.setBorder(titledBorder1);
		scrNhanVien.setBackground(Color.WHITE);
		scrNhanVien.setBounds(44, 535, 1200, 185);
		add(scrNhanVien);

		ScrollBarCustom scrollBar1 = new ScrollBarCustom();
		scrollBar1.setForeground(Color.RED);
		scrNhanVien.setVerticalScrollBar(scrollBar1);

		pnlThongTinChamCong = new JPanel();
		LineBorder blackLineBorder2 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(blackLineBorder2, "Thông tin chấm công");
		pnlThongTinChamCong.setBorder(titledBorder2);
		pnlThongTinChamCong.setBackground(new Color(255, 255, 255));
		pnlThongTinChamCong.setBounds(757, 56, 487, 390);
		add(pnlThongTinChamCong);
		pnlThongTinChamCong.setLayout(null);

		lblMaNV = new JLabel();
		lblMaNV.setBounds(27, 33, 84, 20);
		pnlThongTinChamCong.add(lblMaNV);
		lblMaNV.setText("Mã nhân viên:");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtMaNV = new JTextField();
		txtMaNV.setBounds(149, 11, 301, 36);
		pnlThongTinChamCong.add(txtMaNV);
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaNV.setBorder(null);

		JSeparator jSeparator = new JSeparator();
		jSeparator.setBounds(149, 47, 301, 10);
		pnlThongTinChamCong.add(jSeparator);
		jSeparator.setForeground(Color.BLACK);

		lblTenNV = new JLabel();
		lblTenNV.setBounds(29, 86, 102, 30);
		pnlThongTinChamCong.add(lblTenNV);
		lblTenNV.setText("Họ và tên:");
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtTenNV = new JTextField();
		txtTenNV.setBounds(149, 68, 301, 36);
		pnlThongTinChamCong.add(txtTenNV);
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNV.setBorder(null);

		JSeparator jSeparator1 = new JSeparator();
		jSeparator1.setBounds(149, 106, 301, 10);
		pnlThongTinChamCong.add(jSeparator1);
		jSeparator1.setForeground(Color.BLACK);

		lblTinhTrang = new JLabel();
		lblTinhTrang.setBounds(27, 150, 102, 30);
		pnlThongTinChamCong.add(lblTinhTrang);
		lblTinhTrang.setText("Tình trạng:");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbTinhTrang = new JComboBox<String>();
		cmbTinhTrang.setBounds(149, 139, 301, 36);
		pnlThongTinChamCong.add(cmbTinhTrang);
		cmbTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbTinhTrang.setBackground(Color.WHITE);

		cmbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi Làm", "Đi Trễ", "Nghỉ Có Phép", "Nghỉ Không Phép" }));
		cmbTinhTrang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbTrangThaiActionPerformed(evt);
			}
		});

		lblGioDiLam = new JLabel();
		lblGioDiLam.setBounds(27, 210, 102, 30);
		pnlThongTinChamCong.add(lblGioDiLam);
		lblGioDiLam.setText("Giờ đi làm:");
		lblGioDiLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbGio = new JComboBox<String>();
		cmbGio.setBounds(149, 189, 57, 43);
		pnlThongTinChamCong.add(cmbGio);
		cmbGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbGio.setBackground(Color.WHITE);

		cmbGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "1", "2", "3", "4", "5", "6" }));

		lblPhut = new JLabel();
		lblPhut.setBounds(350, 195, 57, 30);
		pnlThongTinChamCong.add(lblPhut);
		lblPhut.setText("phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbPhut = new JComboBox<String>();
		cmbPhut.setBounds(283, 189, 57, 43);
		pnlThongTinChamCong.add(cmbPhut);
		cmbPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbPhut.setBackground(Color.WHITE);

		cmbPhut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));

		lblCaLam = new JLabel();
		lblCaLam.setBounds(27, 277, 102, 30);
		pnlThongTinChamCong.add(lblCaLam);
		lblCaLam.setText("Ca làm:");
		lblCaLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbCaLam = new JComboBox<String>();
		cmbCaLam.setBounds(149, 255, 301, 41);
		pnlThongTinChamCong.add(cmbCaLam);
		cmbCaLam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbCaLam.setBackground(Color.WHITE);

		cmbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng ", "Chiều", "Đêm" }));
		cmbCaLam.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbCaLamActionPerformed(evt);
			}
		});

		lblGioTangCa = new JLabel();
		lblGioTangCa.setBounds(27, 339, 102, 30);
		pnlThongTinChamCong.add(lblGioTangCa);
		lblGioTangCa.setText("Giờ tăng ca:");
		lblGioTangCa.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbGioTangCa = new JComboBox<String>();
		cmbGioTangCa.setBounds(149, 319, 57, 40);
		pnlThongTinChamCong.add(cmbGioTangCa);
		cmbGioTangCa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbGioTangCa.setBackground(Color.WHITE);

		cmbGioTangCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "7", "8", "9", "10", "11","12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "1", "2", "3", "4", "5", "6" }));
		cmbGioTangCa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbGioTangCaActionPerformed(evt);
			}
		});
		
		JLabel lblPhut_1 = new JLabel();
		lblPhut_1.setBounds(350, 324, 57, 30);
		pnlThongTinChamCong.add(lblPhut_1);
		lblPhut_1.setText("phút");
		lblPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cmbPhutTangCa = new JComboBox<String>();
		cmbPhutTangCa.setBounds(283, 319, 57, 38);
		pnlThongTinChamCong.add(cmbPhutTangCa);
		cmbPhutTangCa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbPhutTangCa.setBackground(Color.WHITE);

		cmbPhutTangCa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));

		btnChamCongTatCa = new JButton();
		btnChamCongTatCa.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
		btnChamCongTatCa.setText("Chấm công tất cả");
		btnChamCongTatCa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnChamCongTatCa.setBorder(null);
		btnChamCongTatCa.setBackground(new Color(255, 215, 0));
		btnChamCongTatCa.setBounds(109, 471, 170, 40);
		btnChamCongTatCa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChamCongTatCaActionPerformed(evt);
			}
		});
		add(btnChamCongTatCa);

		btnChamLai = new JButton();
		btnChamLai.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
		btnChamLai.setText("Chấm lại");
		btnChamLai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnChamLai.setBorder(null);
		btnChamLai.setBackground(new Color(255, 215, 0));
		btnChamLai.setBounds(336, 471, 170, 40);
		add(btnChamLai);

		btnCapNhat = new JButton();
		btnCapNhat.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/capNhat.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCapNhat.setBorder(null);
		btnCapNhat.setBackground(new Color(255, 215, 0));
		btnCapNhat.setBounds(557, 471, 170, 40);
		add(btnCapNhat);

		btnLayDanhSach = new JButton();
		btnLayDanhSach.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/them.png")));
		btnLayDanhSach.setText("Lấy danh sách");
		btnLayDanhSach.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLayDanhSach.setBorder(null);
		btnLayDanhSach.setBackground(new Color(0, 255, 127));
		btnLayDanhSach.setBounds(444, 380, 237, 40);
		btnLayDanhSach.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLayDanhSachActionPerformed(evt);
			}
		});
		add(btnLayDanhSach);

		btnLuu = new JButton();
		btnLuu.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/luu.png")));
		btnLuu.setText("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnLuu.setEnabled(false);
		btnLuu.setBorder(null);
		btnLuu.setBackground(Color.MAGENTA);
		btnLuu.setBounds(800, 471, 160, 40);
		add(btnLuu);

		btnHuy = new JButton();
		btnHuy.setIcon(new ImageIcon(ChamCongNhanVien_GUI.class.getResource("/image/icon/huy.png")));
		btnHuy.setText("Lưu");
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHuy.setEnabled(false);
		btnHuy.setBorder(null);
		btnHuy.setBackground(Color.MAGENTA);
		btnHuy.setBounds(1023, 471, 160, 40);
		add(btnHuy);

	}
	
	
	private void cmbGioTangCaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	public void taiDuLieuLenBangNhanVien() throws ParseException {
        while (modelNhanVien.getRowCount() != 0) {
            modelNhanVien.removeRow(0);
        }
        daoChamCong = new ChamCongNhanVien_Dao();
        ArrayList<ChamCongNhanVien> listChamCong = daoChamCong.danhSachChamCongNhanVien();
        if (listChamCong != null) {
            for (ChamCongNhanVien chamCong : listChamCong) {
            	if (chamCong.getNguoiChamCong() != null) {
                String data[] = {(modelNhanVien.getRowCount() + 1) + "", chamCong.getNguoiChamCong().getMaNhanVien(),
                    chamCong.getNhanVien().getMaNhanVien(), chamCong.getNhanVien().getHoTen(), chamCong.getNhanVien().getSoDienThoai(),
                    chamCong.getNhanVien().getPhongBan().getTenPhongBan(), chamCong.getNhanVien().getChucVu(), chamCong.getNgayChamCong().toString(),
                    chamCong.getCaLam(), chamCong.getTrangThaiDiLam(), chamCong.getGioDiLam(),chamCong.getGioTangCa()};
                modelNhanVien.addRow(data);
            	}
            }
            if (tblNhanVien.getRowCount() > 0) {
                tblNhanVien.setRowSelectionInterval(0, 0);
                hienThiDuLieuLenTxtBangNhanVien(0);
                setEditInput(false);
            }
        }
        
        setEditInput(false);
    }

    public void taiDuLieuLenBangChamCongEvt() {
        daoChamCong = new ChamCongNhanVien_Dao();
        daoNhanVien = new NhanVien_Dao();
        ArrayList<ChamCongNhanVien> listChamCong = daoChamCong.danhSachChamCongNhanVien();
        listNhanVien = daoNhanVien.layDanhSachNhanVien();
        ArrayList<NhanVien> listTemp1 = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(dcsNgayChamCong.getDate());
        listChamCong.forEach(e -> {
            if (e.getCaLam().equalsIgnoreCase(cmbCaLam.getSelectedItem().toString()) && strDate.equalsIgnoreCase(e.getNgayChamCong().toString())) {
                listTemp1.add(e.getNhanVien());
            }
        });
        listNhanVienForEvtChamCongTatCa = new ArrayList<>();
        listNhanVien.forEach(e -> {
            boolean flag = false;
            if (e.getNgayVaoLam().after(dcsNgayChamCong.getDate())) {
//                System.out.println(e.getMaNhanVien() + "Nhan vien nay chua du dk de cham cong");
            } else {
                for (NhanVien nhanVien : listTemp1) {
                    if (nhanVien.getMaNhanVien().equalsIgnoreCase(e.getMaNhanVien())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    listNhanVienForEvtChamCongTatCa.add(e);
                    String data[] = {(modelChamCong.getRowCount() + 1) + "", e.getMaNhanVien(), e.getHoTen(), e.getSoDienThoai(), e.getPhongBan().getTenPhongBan(), e.getChucVu()};
                    modelChamCong.addRow(data);
                }
            }
        });
    }

    public void taiDuLieuLenBangChamCong() throws ParseException, InterruptedException {
        while (modelChamCong.getRowCount() != 0) {
            modelChamCong.removeRow(0);
        }
        taiDuLieuLenBangChamCongEvt();
        if (tblNhanVien.getRowCount() != 0) {
            tblNhanVien.setRowSelectionInterval(0, 0);
        }
        if (modelChamCong.getRowCount() > 0) {
            tblChamCong.setRowSelectionInterval(0, 0);
            hienThiDuLieuLenTxtBangNhanVien(0);
            setEditInput(false);
            btnChamLai.setEnabled(false);
        } else {
        	btnChamLai.setEnabled(false);
        }
    }

    public void setComBoBoxToSunDay() {
        cmbCaLam.removeAllItems();
        cmbCaLam.addItem("Sáng chủ nhật");
        cmbCaLam.addItem("Chiều chủ nhật");
    }

    public void setComBoBoxToReset() {
        cmbCaLam.removeAllItems();
        cmbCaLam.addItem("Sáng");
        cmbCaLam.addItem("Chiều");
        cmbCaLam.addItem("Đêm");
    }

    public void hienThiDuLieuLenTxtBangNhanVien(int dong) throws ParseException {
        if (modelNhanVien.getRowCount() > 0) {
            txtMaNV.setText(tblNhanVien.getValueAt(dong, 2).toString());
            txtTenNV.setText(tblNhanVien.getValueAt(dong, 3).toString());
            cmbTinhTrang.setSelectedItem(tblNhanVien.getValueAt(dong, 9).toString());
            if (cmbTinhTrang.getSelectedIndex() != 2 && cmbTinhTrang.getSelectedIndex() != 3) {
                cmbGio.setSelectedItem(tblNhanVien.getValueAt(dong, 10).toString().split("h")[0]);
                cmbPhut.setSelectedItem(tblNhanVien.getValueAt(dong, 10).toString().split("h")[1]);
                cmbGio.setEditable(true);
                cmbPhut.setEditable(true);
            } else {
                cmbGio.setEditable(true);
                cmbPhut.setEditable(true);
            }
        }
    }

    public void hienThiDuLieuLenTxtBangChamCong(int dong) throws ParseException {
        txtMaNV.setText(tblChamCong.getValueAt(dong, 1).toString());
        txtTenNV.setText(tblChamCong.getValueAt(dong, 2).toString());
    }

    public void setHidden(JButton... btn) {
        for (JButton jButton : btn) {
            jButton.setEnabled(false);
        }
    }

    public void setShow(JButton... btn) {
        for (JButton jButton : btn) {
            jButton.setEnabled(true);
        }
    }

    public void setEditInput(boolean check) {
        cmbTinhTrang.setEnabled(check);
        cmbGio.setEnabled(check);
        cmbPhut.setEnabled(check);
    }

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            capNhatCmbGio();
            hienThiDuLieuLenTxtBangNhanVien(tblNhanVien.getSelectedRow());
            setEditInput(false);
            setShow(btnCapNhat);
            setHidden(btnHuy, btnLuu, btnChamLai);
            checkChamCong = false;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "ERRO, please reset (T_T)(T_T)");
        }
        if (tblChamCong.getSelectedRow() != -1) {
            tblChamCong.removeRowSelectionInterval(tblChamCong.getSelectedRow(), 0);
        }
    }

    private void tblChamCongMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            capNhatCmbGio();
            hienThiDuLieuLenTxtBangChamCong(tblChamCong.getSelectedRow());
            setEditInput(false);
            setHidden(btnHuy, btnLuu, btnCapNhat);
            setShow(btnChamLai, btnChamCongTatCa);
            checkChamCong = false;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "ERRO, please reset (T_T)(T_T)");
        }
        if (tblNhanVien.getSelectedRow() != -1) {
            tblNhanVien.removeRowSelectionInterval(tblNhanVien.getSelectedRow(), 0);
        }
    }
    
    private void btnLayDanhSachActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (dcsNgayChamCong.getDate().after(new Date())) {
                JOptionPane.showMessageDialog(null, stErrNgayChamCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                taiDuLieuLenBangChamCong();
            } catch (ParseException ex) {
                Logger.getLogger(ChamCongNhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChamCongNhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tblChamCong.getRowCount() != 0) {
                setShow(btnChamCongTatCa);
            } else {
                setHidden(btnChamLai, btnChamCongTatCa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, stNgayThangKhongHople, stThongbao, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dcsNgayChamCongMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void dcsNgayChamCongPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dcsNgayChamCong.getDate());
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                setComBoBoxToSunDay();
            } else {
                setComBoBoxToReset();
            }
        }
        btnChamLai.setEnabled(false);
        while (modelChamCong.getRowCount() > 0) {
            modelChamCong.removeRow(0);
        }

    }

    private void btnChamCongTatCaActionPerformed(java.awt.event.ActionEvent evt) {
        daoChamCong = new ChamCongNhanVien_Dao();
        String gio = "";
        String gioTangCa = "";

        if (cmbCaLam.getSelectedIndex() == 0) {
            gio = "7h00";
        } else if (cmbCaLam.getSelectedIndex() == 1) {
            gio = "14h00";
        } else {
            gio = "22h00";
        }
        if (cmbGioTangCa.getSelectedIndex() == 0) {
            gioTangCa = "0";
        }
        
        
//      NhanVien nhanVienChamCong = daoNhanVien.layMotNhanVienTheoMaNhanVien("NV100001");
        cmbTinhTrang.setSelectedIndex(0);
        taiDuLieuLenBangChamCongEvt();
        for (NhanVien nhanVien : listNhanVienForEvtChamCongTatCa) {
            
            try {
            	ChamCongNhanVien chamCong = new ChamCongNhanVien(nhanVien, dcsNgayChamCong.getDate(), cmbCaLam.getSelectedItem().toString(), cmbTinhTrang.getSelectedItem().toString(),
                        gio,gioTangCa, nhanvienDangNhap);
                daoChamCong.themMotChamCongNhanVien(chamCong);
				taiDuLieuLenBangNhanVien();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        btnChamCongTatCa.setEnabled(false);
        while (modelChamCong.getRowCount() != 0) {
            modelChamCong.removeRow(0);
        }
        btnChamLai.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Chấm công thành công");
    }
    
    public void thayDouCmbBox() {
        if (cmbTinhTrang.getSelectedIndex() == 0 || cmbTinhTrang.getSelectedIndex() == 2 || cmbTinhTrang.getSelectedIndex() == 3) {
            cmbGio.setEnabled(false);
            cmbPhut.setEnabled(false);
            cmbGioTangCa.setEnabled(false);
            cmbPhutTangCa.setEnabled(false);
        } else {
            cmbGio.setEnabled(true);
            cmbPhut.setEnabled(true);
            cmbGio.setEditable(false);
            cmbPhut.setEditable(false);
        }
    }
    private void cmbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {
        thayDouCmbBox();
    }

    private void scrChamCongMouseClicked(java.awt.event.MouseEvent evt) {
    }

    public void capNhatCmbGio() {
        cmbGio.removeAllItems();
        if (cmbCaLam.getSelectedIndex() == 0) {
            for (int i = 7; i < 12; i++) {
                cmbGio.addItem(i + "");
            }
        } else if (cmbCaLam.getSelectedIndex() == 1) {
            for (int i = 13; i < 18; i++) {
                cmbGio.addItem(i + "");
            }
        } else {
            for (int i = 19; i <= 24; i++) {
                cmbGio.addItem(i + "");
            }
            for (int i = 0; i < 7; i++) {
                cmbGio.addItem(i + "");
            }
        }
    }
    
    public void capNhatCmbGioTangCa() {
    	cmbGioTangCa.removeAllItems();

        if (cmbCaLam.getSelectedIndex() == 0) {
            for (int i = 7; i < 12; i++) {
                cmbGioTangCa.addItem(i + "");
            }
        } else if (cmbCaLam.getSelectedIndex() == 1) {
            for (int i = 13; i < 18; i++) {
                cmbGioTangCa.addItem(i + "");
            }
        } else {
            for (int i = 19; i <= 24; i++) {
                cmbGioTangCa.addItem(i + "");
            }
            for (int i = 1; i < 7; i++) {
                cmbGioTangCa.addItem(i + "");
            }
        }
    }
    
    private void cmbCaLamActionPerformed(java.awt.event.ActionEvent evt) {
        capNhatCmbGio();
        setHidden(btnHuy, btnLuu, btnChamCongTatCa, btnChamLai, btnCapNhat);
        setEditInput(false);
        btnChamLai.setEnabled(false);
        while (modelChamCong.getRowCount() > 0) {
            modelChamCong.removeRow(0);
        }
    }
}