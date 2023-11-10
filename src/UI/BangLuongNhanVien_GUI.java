package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import Custom_UI.ScrollBarCustom;
import Dao.BangLuongNhanVien_Dao;
import Dao.ChamCongNhanVien_Dao;
import Dao.NhanVien_Dao;
import Entity.BangLuongNhanVien;
import Entity.ChamCongNhanVien;
import Entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;

public class BangLuongNhanVien_GUI extends JPanel {

	private JScrollPane scrBangLuong;
	private JTable tblBangLuong;
	private JLabel lblTieuDe;
	private JButton btnTinhLuong;
	private JButton btnInBangLuong;
	private JButton btnChiTiet;
	private JComboBox<String> cmbHienThi;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;

	private DefaultTableModel model;
	private NhanVien_Dao nhanVienDao;
	private BangLuongNhanVien_Dao bangLuongNhanVienDao;
	private ChamCongNhanVien_Dao chamCongNhanVienDao;

	private String fileName;

	public BangLuongNhanVien_GUI() {
		initComponents();
		excute();
		taiDuLieuLenBangLuong();
	}

	public void excute() {

		model = (DefaultTableModel) tblBangLuong.getModel();
		// custom table
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		tblBangLuong.getTableHeader().setOpaque(false);
		((DefaultTableCellRenderer) tblBangLuong.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(JLabel.CENTER);
		tblBangLuong.setRowHeight(25);
		cmbNam.removeAllItems();

		LocalDate lcDate = LocalDate.now();
		for (int i = 2023; i <= lcDate.getYear(); i++) {
			cmbNam.addItem(i + "");
		}
	}

	private void initComponents() {
		setSize(1290, 750);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		lblTieuDe = new JLabel("BẢNG LƯƠNG NHÂN VIÊN");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(415, 24, 490, 52);
		add(lblTieuDe);

		tblBangLuong = new JTable();
		tblBangLuong.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tblBangLuong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 11));
		tblBangLuong.getTableHeader().setBackground(new Color(128, 200, 255));

		tblBangLuong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 l\u01B0\u01A1ng", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Ch\u1EE9c v\u1EE5", "L\u01B0\u01A1ng th\u00E1ng", "L\u01B0\u01A1ng c\u01A1 b\u1EA3n", "S\u1ED1 ng\u00E0y \u0111i l\u00E0m", "S\u1ED1 ng\u00E0y ngh\u1EC9", "S\u1ED1 ph\u00E9p ngh\u1EC9", "L\u01B0\u01A1ng t\u0103ng ca", "Ph\u1EE5 c\u1EA5p", "T\u1ED5ng l\u01B0\u01A1ng", "\u0110\u01A1n v\u1ECB ti\u1EC1n", "Ng\u00E0y t\u00EDnh l\u01B0\u01A1ng"
			}
		));
		tblBangLuong.getColumnModel().getColumn(0).setPreferredWidth(34);
		tblBangLuong.getColumnModel().getColumn(3).setPreferredWidth(110);
		tblBangLuong.getColumnModel().getColumn(5).setPreferredWidth(67);
		tblBangLuong.getColumnModel().getColumn(6).setPreferredWidth(70);
		tblBangLuong.getColumnModel().getColumn(7).setPreferredWidth(70);
		tblBangLuong.getColumnModel().getColumn(9).setPreferredWidth(79);
		tblBangLuong.getColumnModel().getColumn(10).setPreferredWidth(69);
		tblBangLuong.getColumnModel().getColumn(12).setPreferredWidth(55);
		tblBangLuong.getColumnModel().getColumn(13).setPreferredWidth(70);
		tblBangLuong.getColumnModel().getColumn(14).setPreferredWidth(62);
		tblBangLuong.getColumnModel().getColumn(15).setPreferredWidth(85);

		tblBangLuong.setSelectionBackground(new Color(255, 215, 0));
		tblBangLuong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblBangLuongMouseClicked(evt);
			}
		});

		scrBangLuong = new JScrollPane(tblBangLuong);
		LineBorder blackLineBorder1 = new LineBorder(Color.BLACK, 2);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(blackLineBorder1, "Bảng lương nhân viên");
		scrBangLuong.setBorder(titledBorder1);
		scrBangLuong.setBackground(new java.awt.Color(255, 255, 255));
		scrBangLuong.setBounds(0, 305, 1280, 393);
		add(scrBangLuong);

		ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.RED);
		scrBangLuong.setVerticalScrollBar(scrollBar);

		JPanel panelButton = new JPanel();
		panelButton.setBounds(10, 197, 1270, 62);
		add(panelButton);
		panelButton.setLayout(null);
		panelButton.setBackground(Color.WHITE);

		btnTinhLuong = new JButton();
		btnTinhLuong.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/tinhLuong.png")));
		btnTinhLuong.setText("Tính lương");
		btnTinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTinhLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTinhLuong.setBorder(null);
		btnTinhLuong.setBackground(new Color(255, 215, 0));
		btnTinhLuong.setBounds(411, 11, 170, 40);
		btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTinhLuongActionPerformed(evt);
			}
		});		
		panelButton.add(btnTinhLuong);

		btnInBangLuong = new JButton();
		btnInBangLuong.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/in.png")));
		btnInBangLuong.setText("In bảng lương");
		btnInBangLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnInBangLuong.setBorder(null);
		btnInBangLuong.setBackground(new Color(255, 215, 0));
		btnInBangLuong.setBounds(697, 11, 170, 40);
		btnInBangLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInBangLuongActionPerformed(evt);
			}
		});
		panelButton.add(btnInBangLuong);

		btnChiTiet = new JButton();
		btnChiTiet.setIcon(new ImageIcon(BangLuongNhanVien_GUI.class.getResource("/image/icon/xemChiTiet.png")));
		btnChiTiet.setText("Xem chi tiết");
		btnChiTiet.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnChiTiet.setBorder(null);
		btnChiTiet.setBackground(new Color(255, 215, 0));
		btnChiTiet.setBounds(972, 11, 170, 40);
		btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChiTietActionPerformed(evt);
			}
		});
		panelButton.add(btnChiTiet);

		JLabel lblHienThi = new JLabel();
		lblHienThi.setText("Hiển thị:");
		lblHienThi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHienThi.setBounds(91, 11, 51, 40);
		panelButton.add(lblHienThi);

		cmbHienThi = new JComboBox<String>();
		cmbHienThi.setBounds(164, 12, 145, 40);
		cmbHienThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Theo tháng/năm" }));
		cmbHienThi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbHienThiActionPerformed(evt);
			}
		});
		panelButton.add(cmbHienThi);

		JLabel lblThang = new JLabel();
		lblThang.setBounds(498, 100, 66, 41);
		add(lblThang);
		lblThang.setText("Tháng");
		lblThang.setFont(new Font("Times New Roman", Font.BOLD, 20));

		cmbThang = new JComboBox<String>();
		cmbThang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbThang.setBackground(Color.WHITE);
		cmbThang.setBounds(586, 103, 57, 37);
		add(cmbThang);

		cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cmbThang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbThangActionPerformed(evt);
			}
		});

		JLabel lblNam = new JLabel();
		lblNam.setText("Năm");
		lblNam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNam.setBounds(676, 99, 66, 41);
		add(lblNam);

		cmbNam = new JComboBox<String>();
		cmbNam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cmbNam.setBackground(Color.WHITE);
		cmbNam.setBounds(745, 103, 78, 37);
		add(cmbNam);

		cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023" }));
		cmbNam.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbNamActionPerformed(evt);
			}
		});
	}

	private void btnChiTietActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {
		tinhLuongNhanVien();
		taiDuLieuLenBangLuong();
	}


	public void taiDuLieuLenBangLuong() {
		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}
		bangLuongNhanVienDao = new BangLuongNhanVien_Dao();
		DecimalFormat dfm = new DecimalFormat("###,###,###,###,###");
		ArrayList<BangLuongNhanVien> bangLuongNhanVienList = bangLuongNhanVienDao.danhSachBangLuong();
		if (bangLuongNhanVienList != null) {
			if (cmbHienThi.getSelectedIndex() == 0) {
				for (BangLuongNhanVien l : bangLuongNhanVienList) {
					model.addRow(new Object[]{model.getRowCount() + 1, l.getMaBangLuong(), l.getNhanVien().getMaNhanVien(), l.getNhanVien().getHoTen(),
							l.getNhanVien().getSoDienThoai(),l.getNhanVien().getChucVu(), l.getLuongTheoThang(),dfm.format(l.getNhanVien().getLuongCoBan()), l.getSoNgayDiLam(), l.getSoNgayNghi(), l.getSoPhepNghi(),
							dfm.format(l.getLuongTangCa()),dfm.format(l.getPhuCap()),dfm.format(l.getThucLanh()), l.getDonViTien(), l.getNgayTinh()
					});
				}
			} else {
				for (BangLuongNhanVien l : bangLuongNhanVienList) {
					if (l.getLuongTheoThang().equalsIgnoreCase(cmbThang.getSelectedItem().toString() + "-" + cmbNam.getSelectedItem().toString())) {
						model.addRow(new Object[]{model.getRowCount() + 1, l.getMaBangLuong(), l.getNhanVien().getMaNhanVien(), l.getNhanVien().getHoTen(),
								l.getNhanVien().getSoDienThoai(),l.getNhanVien().getChucVu(), l.getLuongTheoThang(),dfm.format(l.getNhanVien().getLuongCoBan()), l.getSoNgayDiLam(), l.getSoNgayNghi(), l.getSoPhepNghi(),
								dfm.format(l.getLuongTangCa()),dfm.format(l.getPhuCap()),dfm.format(l.getThucLanh()), l.getDonViTien(), l.getNgayTinh()
						});
					}
				}
			}

		}
	}

	public void tinhLuongNhanVien() {
	    bangLuongNhanVienDao = new BangLuongNhanVien_Dao();
	    nhanVienDao = new NhanVien_Dao();
	    chamCongNhanVienDao = new ChamCongNhanVien_Dao();
	    ArrayList<NhanVien> nhanVienList = nhanVienDao.layDanhSachNhanVien();
	    bangLuongNhanVienDao.xoaBangLuongInsert(cmbThang.getSelectedItem().toString(), cmbNam.getSelectedItem().toString());

	    for (NhanVien nv : nhanVienList) {
	        ArrayList<BangLuongNhanVien> bangLuongList = bangLuongNhanVienDao.danhSachBangLuong();
	        String maBangLuong = "PPLN100001";
	        if (bangLuongList.size() > 0) {
	            maBangLuong = "PPLN" + (Integer.parseInt(bangLuongList.get(bangLuongList.size() - 1).getMaBangLuong().split("N")[1]) + 1);
	        }
	        int soNgayDiLam = 0;
	        int soNgayNghi = 0;
	        int soPhepNghi = 0;
	        double luongTangCa = 0;
	        double phuCapCV = 0;
	        double phuCapThamNien = 0;

	        // Lấy thông tin chấm công
	        ArrayList<String[]> danhSach = chamCongNhanVienDao.layDanhSachChamCongTheoMaNhanVienVaThang(nv.getMaNhanVien(),
	                cmbThang.getSelectedItem().toString(), cmbNam.getSelectedItem().toString());
	        for (String[] string : danhSach) {
	            if (string[1].contains("Đi")) {
	                soNgayDiLam++;
	            }
	            if (string[1].contains("Nghỉ")) {
	                soNgayNghi++;
	            }
	            if (string[1].contains("Nghỉ có phép")) {
	                soPhepNghi++;
	            }
	            if (!string[2].isEmpty()) {
	                double gioTangCa = Double.parseDouble(string[2]);
	                luongTangCa += (nv.getLuongCoBan() / 28) / 24 * (gioTangCa) * 2;
	            }
	        }

	        // Xác định phụ cấp chức danh dựa trên chức vụ
	        if (nv.getChucVu().equals("Nhân viên")) {
	            phuCapCV = (nv.getLuongCoBan() / 28) * 0.8;
	        } else if (nv.getChucVu().equals("Trưởng phòng")) {
	            phuCapCV = (nv.getLuongCoBan() / 28) * 1;
	        } else if (nv.getChucVu().equals("Quản lý")) {
	            phuCapCV = (nv.getLuongCoBan() / 28) * 1.2;
	        }

	        // Tính phụ cấp thâm niên sau 1 năm làm việc
	        Date ngayVaoLam = nv.getNgayVaoLam();
	        Date ngayHienTai = new Date();
	        long soNamLamViec = (ngayHienTai.getTime() - ngayVaoLam.getTime()) / (1000L * 60 * 60 * 24 * 365);
	        if (soNamLamViec >= 1) {
	            phuCapThamNien = (nv.getLuongCoBan() / 28) * 0.05 * soNamLamViec;
	        }

	        double phuCap = phuCapCV + phuCapThamNien;
	        String luongTheoThang = cmbThang.getSelectedItem().toString() + "-" + cmbNam.getSelectedItem().toString();
	        double luongThang = (nv.getLuongCoBan() / 28) * (soNgayDiLam + soNgayNghi - soPhepNghi);
	        double thucLanh = luongThang + luongTangCa + phuCap; 

	        bangLuongNhanVienDao.themMotBangLuongString(maBangLuong, nv.getMaNhanVien(), soNgayDiLam, soNgayNghi, soPhepNghi, new Date(), luongTheoThang, luongTangCa, phuCap, thucLanh, "VND");
	    }

	    // Hiển thị thông báo khi tính lương thành công
	    JOptionPane.showMessageDialog(this, "Tính lương thành công");
	}

	private void btnInBangLuongActionPerformed(java.awt.event.ActionEvent evt) {
		MessageFormat header = new MessageFormat("Bảng lương nhân viên công ty PacePro tháng " + cmbThang.getSelectedItem().toString() + "-" + cmbNam.getSelectedItem().toString());
		MessageFormat footer = new MessageFormat("Nhóm 5");
		try {
			tblBangLuong.print(JTable.PrintMode.FIT_WIDTH, header, footer);
		} catch (Exception e) {
			e.getMessage();
		}
	}


	private void cmbHienThiActionPerformed(java.awt.event.ActionEvent evt) {
		taiDuLieuLenBangLuong();
		if (cmbHienThi.getSelectedIndex() == 0) {
			btnInBangLuong.setEnabled(false);
		} else {
			if (cmbHienThi.getSelectedIndex() == 1) {
				if (tblBangLuong.getRowCount() > 0) {
					btnInBangLuong.setEnabled(true);
				} else {
					btnInBangLuong.setEnabled(false);
				}
			}
		}

	}

	private void cmbThangActionPerformed(java.awt.event.ActionEvent evt) {
		taiDuLieuLenBangLuong();
		if (cmbHienThi.getSelectedIndex() == 1) {
			if (tblBangLuong.getRowCount() > 0) {
				btnInBangLuong.setEnabled(true);
			} else {
				btnInBangLuong.setEnabled(false);
			}
		}
	}

	private void cmbNamActionPerformed(java.awt.event.ActionEvent evt) {
		taiDuLieuLenBangLuong();
		if (cmbHienThi.getSelectedIndex() == 1) {
			if (tblBangLuong.getRowCount() > 0) {
				btnInBangLuong.setEnabled(true);
			} else {
				btnInBangLuong.setEnabled(false);
			}
		}
	}

	private void tblBangLuongMouseClicked(MouseEvent evt) {
	}
}
