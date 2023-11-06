package UI;

import Entity.NhanVien;
import Entity.PhongBan;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Dao.NhanVien_Dao;
import Dao.PhongBan_Dao;
import javax.swing.JSeparator;

/**
 *
 * @author December
 */
public class TimKiemNhanVien_GUI extends JPanel implements ActionListener {
	private JButton btnTimKiem;
	private JComboBox<String> cmbGioiTinh;
	private JComboBox<String> cmbPhongBan;
	private JPanel pnlNV;
	private JLabel lblEmail;
	private JLabel lblErrEmail;
	private JLabel lblErrHoTen;
	private JLabel lblErrSoCCCD;
	private JLabel lblErrSoDienThoai;
	private JLabel lblGioiTinh;
	private JLabel lblHoTen;
	private JLabel lblMaNhanVien;
	private JLabel lblPhongBan;
	private JLabel lblSoCCCD;
	private JLabel lblSoDienThoai;
	private JScrollPane scrTableNhanVien;
	private JTable tblNhanVien;
	private JTextField txtEmail;
	private JTextField txtHoTen;
	private JTextField txtMaNhanVien;
	private JTextField txtSoCCCD;
	private JTextField txtSoDienThoai;

	private NhanVien_Dao daoNhanVien;
	private PhongBan_Dao daoPhongBan;
	private DefaultTableModel model;
	private DecimalFormat dcf;
	private JSeparator jSeparator_2;
	private JSeparator jSeparator_3;
	private JSeparator jSeparator_4;
	private JLabel lblTieuDe;

	public TimKiemNhanVien_GUI() throws IOException {
		initComponents();
		excute();

		try {
			ConnectionDB.ConnectDB.getInstance().connect();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		daoNhanVien = new NhanVien_Dao();
		daoPhongBan = new PhongBan_Dao();
		dcf = new DecimalFormat("###,###,###,###,###.###");
		model = (DefaultTableModel) tblNhanVien.getModel();
		
		cmbPhongBan.removeAllItems();
		ArrayList<PhongBan> phongBan = daoPhongBan.layDanhSachPhongBan();
		for (PhongBan pb : phongBan) {
			cmbPhongBan.addItem(pb.getTenPhongBan());
		}
		cmbPhongBan.setSelectedItem("Tất cả");
		taiDuLieuLenBang("all", "all", "all", "all", "all", "all", "all");
		btnTimKiem.addActionListener(this);
		
		lblErrEmail.setText("");
		lblErrHoTen.setText("");
		lblErrSoCCCD.setText("");
		lblErrSoDienThoai.setText("");
		cmbPhongBan.removeItemAt(0);
	}

	private void initComponents() {
		setBackground(new Color(255, 255, 255));

		pnlNV = new JPanel();
		pnlNV.setBounds(10, 62, 1190, 342);
		lblErrHoTen = new JLabel();
		lblErrHoTen.setBounds(930, 60, 280, 0);
		txtHoTen = new JTextField();
		txtHoTen.setBounds(823, 30, 280, 40);
		lblHoTen = new JLabel();
		lblHoTen.setBounds(699, 40, 130, 40);
		txtEmail = new JTextField();
		txtEmail.setBounds(823, 90, 280, 40);
		lblErrEmail = new JLabel();
		lblErrEmail.setBounds(930, 130, 280, 0);
		lblEmail = new JLabel();
		lblEmail.setBounds(699, 100, 88, 40);
		txtSoCCCD = new JTextField();
		txtSoCCCD.setBounds(296, 90, 280, 40);
		lblErrSoCCCD = new JLabel();
		lblErrSoCCCD.setBounds(420, 130, 280, 0);
		lblSoCCCD = new JLabel();
		lblSoCCCD.setBounds(156, 100, 140, 40);
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(296, 30, 280, 40);
		lblMaNhanVien = new JLabel();
		lblMaNhanVien.setBounds(156, 49, 140, 40);
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(296, 150, 280, 40);
		lblGioiTinh = new JLabel();
		lblGioiTinh.setBounds(699, 180, 88, 40);
		cmbGioiTinh = new JComboBox<>();
		cmbGioiTinh.setBounds(823, 180, 280, 40);
		lblSoDienThoai = new JLabel();
		lblSoDienThoai.setBounds(156, 150, 140, 40);
		lblErrSoDienThoai = new JLabel();
		lblErrSoDienThoai.setBounds(420, 190, 280, 0);
		lblPhongBan = new JLabel();
		lblPhongBan.setBounds(156, 218, 130, 40);
		btnTimKiem = new JButton();
		btnTimKiem.setBackground(new Color(255, 192, 203));
		btnTimKiem.setBounds(260, 290, 230, 40);
		cmbPhongBan = new JComboBox<>();
		cmbPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cmbPhongBan.setBounds(296, 220, 280, 40);
		scrTableNhanVien = new JScrollPane();
		scrTableNhanVien.setBounds(62, 421, 1164, 300);
		tblNhanVien = new JTable();

		setPreferredSize(new Dimension(1290, 750));

		pnlNV.setBackground(new Color(255, 255, 255));
		pnlNV.setPreferredSize(new Dimension(1250, 400));
		pnlNV.setLayout(null);

		lblErrHoTen.setFont(new Font("Segoe UI", 0, 13));
		lblErrHoTen.setForeground(new Color(204, 0, 0));
		lblErrHoTen.setText("đây là dòng thông báo lỗi");
		pnlNV.add(lblErrHoTen);

		txtHoTen.setFont(new Font("Tahoma", 0, 16));
		txtHoTen.setBorder(null);
		txtHoTen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtHoTenActionPerformed(evt);
			}
		});
		pnlNV.add(txtHoTen);

		lblHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHoTen.setText("Họ và tên:");
		pnlNV.add(lblHoTen);

		txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16));
		txtEmail.setBorder(null);
		pnlNV.add(txtEmail);

		lblErrEmail.setFont(new Font("Segoe UI", 0, 13));
		lblErrEmail.setForeground(new Color(204, 0, 0));
		lblErrEmail.setText("đây là dòng thông báo lỗi");
		pnlNV.add(lblErrEmail);

		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setText("Email:");
		pnlNV.add(lblEmail);

		txtSoCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoCCCD.setBorder(null);
		pnlNV.add(txtSoCCCD);

		lblErrSoCCCD.setFont(new java.awt.Font("Segoe UI", 0, 13));
		lblErrSoCCCD.setForeground(new java.awt.Color(204, 0, 0));
		lblErrSoCCCD.setText("đây là dòng thông báo lỗi");
		pnlNV.add(lblErrSoCCCD);

		lblSoCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoCCCD.setText("Số CCCD:");
		pnlNV.add(lblSoCCCD);

		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaNhanVien.setBorder(null);
		pnlNV.add(txtMaNhanVien);

		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaNhanVien.setText("Mã nhân viên:");
		pnlNV.add(lblMaNhanVien);

		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoDienThoai.setBorder(null);
		pnlNV.add(txtSoDienThoai);

		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGioiTinh.setText("Giới tính");
		pnlNV.add(lblGioiTinh);

		cmbGioiTinh.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ"}));
		cmbGioiTinh.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnlNV.add(cmbGioiTinh);

		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoDienThoai.setText("Số điện thoại:");
		pnlNV.add(lblSoDienThoai);

		lblErrSoDienThoai.setFont(new Font("Segoe UI", 0, 13));
		lblErrSoDienThoai.setForeground(new Color(204, 0, 0));
		lblErrSoDienThoai.setText("đây là dòng thông báo lỗi");
		pnlNV.add(lblErrSoDienThoai);

		lblPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhongBan.setText("Phòng ban:");
		pnlNV.add(lblPhongBan);
		
		JSeparator jSeparator = new JSeparator();
		jSeparator.setForeground(Color.BLACK);
		jSeparator.setBounds(296, 70, 280, 10);
		pnlNV.add(jSeparator);
		
		JSeparator jSeparator_1 = new JSeparator();
		jSeparator_1.setForeground(Color.BLACK);
		jSeparator_1.setBounds(296, 130, 280, 10);
		pnlNV.add(jSeparator_1);
		
		jSeparator_2 = new JSeparator();
		jSeparator_2.setForeground(Color.BLACK);
		jSeparator_2.setBounds(296, 190, 280, 10);
		pnlNV.add(jSeparator_2);
		
		jSeparator_3 = new JSeparator();
		jSeparator_3.setForeground(Color.BLACK);
		jSeparator_3.setBounds(823, 130, 280, 10);
		pnlNV.add(jSeparator_3);
		
		jSeparator_4 = new JSeparator();
		jSeparator_4.setForeground(Color.BLACK);
		jSeparator_4.setBounds(823, 70, 280, 10);
		pnlNV.add(jSeparator_4);
		
		lblTieuDe = new JLabel();
		lblTieuDe.setBounds(485, 23, 288, 40);
		add(lblTieuDe);
		lblTieuDe.setText("TÌM KIẾM NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));

		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiem.setIcon(new ImageIcon(TimKiemNhanVien_GUI.class.getResource("/image/icon/timKiem.png")));
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemActionPerformed(evt);
			}
		});
		setLayout(null);
		pnlNV.add(btnTimKiem);

		cmbPhongBan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		pnlNV.add(cmbPhongBan);

		add(pnlNV);

		tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null}
				},
				new String [] {
						"STT", "Mã nhân viên", "Họ và tên", "Số CCCD", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Ảnh đại diện", "Email", "Phòng ban", "Chức vụ", "Ngày vào làm"
				}
				));
		scrTableNhanVien.setViewportView(tblNhanVien);

		add(scrTableNhanVien);
	}
	
	public void taiDuLieuLenBang(String maNhanVien, String hoTen, String cccd, String email, String soDienThoai, String gioiTinh, String tenPhongBan) {
		while (tblNhanVien.getRowCount() != 0) {
			model.removeRow(0);
		}
		ArrayList<PhongBan> phongBan = daoPhongBan.layDanhSachPhongBan();
		if (phongBan.size() > 0) {

			ArrayList<NhanVien> danhSachNhanVien = daoNhanVien.layDanhSachNhanVien();
			for (NhanVien nv : danhSachNhanVien) {
				String gioiTinhStr = nv.isGioiTinh() ? "Nam" : "Nữ";
				if (!maNhanVien.equalsIgnoreCase("all") || !hoTen.equalsIgnoreCase("all") || !cccd.equalsIgnoreCase("all")
						|| !email.equalsIgnoreCase("all") || !soDienThoai.equalsIgnoreCase("all") || !gioiTinh.equalsIgnoreCase("all")
						|| !tenPhongBan.equalsIgnoreCase("all")) {
					boolean flag = true;
					if (!maNhanVien.equalsIgnoreCase("all") && !nv.getMaNhanVien().toLowerCase().contains(maNhanVien.toLowerCase())) {
						flag = false;
					}
					if (!hoTen.equalsIgnoreCase("all") && !nv.getHoTen().toLowerCase().contains(hoTen.toLowerCase())) {
						flag = false;
					}
					if (!cccd.equalsIgnoreCase("all") && !nv.getMaCCCD().toLowerCase().contains(cccd.toLowerCase())) {
						flag = false;
					}
					if (!email.equalsIgnoreCase("all") && !nv.getEmail().toLowerCase().contains(email.toLowerCase())) {
						flag = false;
					}
					if (!soDienThoai.equalsIgnoreCase("all") && !nv.getSoDienThoai().toLowerCase().contains(soDienThoai.toLowerCase())) {
						flag = false;
					}
					if (!gioiTinh.equalsIgnoreCase("all") && !gioiTinhStr.equalsIgnoreCase(gioiTinh)) {
						flag = false;
					}
					if (!tenPhongBan.equalsIgnoreCase("all") && !nv.getPhongBan().getTenPhongBan().equalsIgnoreCase(tenPhongBan)) {
						flag = false;
					}
					if (flag) {
						String data[] = {(model.getRowCount() + 1) + "", nv.getMaNhanVien(), nv.getHoTen(), nv.getMaCCCD(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getNgaySinh().toString(),
								nv.getSoDienThoai(), nv.getDiaChi(), nv.getAnhDaiDien(), nv.getEmail(), nv.getPhongBan().getTenPhongBan(),
								nv.getChucVu(), nv.getNgayVaoLam().toString(), dcf.format(nv.getLuongCoBan())};
						model.addRow(data);
					}
				} else {
					String data[] = {(model.getRowCount() + 1) + "", nv.getMaNhanVien(), nv.getHoTen(), nv.getMaCCCD(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getNgaySinh().toString(),
							nv.getSoDienThoai(), nv.getDiaChi(), nv.getAnhDaiDien(), nv.getEmail(), nv.getPhongBan().getTenPhongBan(),
							nv.getChucVu(), nv.getNgayVaoLam().toString(), dcf.format(nv.getLuongCoBan())};
					model.addRow(data);
				}
			}
			if (tblNhanVien.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào có yêu cầu này!", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
			}
			if (tblNhanVien.getRowCount() != 0) {
				tblNhanVien.setRowSelectionInterval(0, 0);
			}
		}
	}

	public void excute() {
		tblNhanVien.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 13));
		tblNhanVien.getTableHeader().setOpaque(false);
		((DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(JLabel.CENTER);
		tblNhanVien.setRowHeight(25);
	}

	

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {
			String maNhanVien = txtMaNhanVien.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String soCCCD = txtSoCCCD.getText().trim();
			String email = txtEmail.getText().trim();
			String soDienThoai = txtSoDienThoai.getText().trim();
			String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
			String phongBan = cmbPhongBan.getSelectedItem().toString();
			if (cmbGioiTinh.getSelectedIndex() == cmbGioiTinh.getItemCount() - 1) {
				System.out.println(cmbGioiTinh.getItemAt(cmbGioiTinh.getItemCount() - 1));
				System.out.println(cmbGioiTinh.getItemAt(cmbGioiTinh.getSelectedIndex()));
				gioiTinh = "all";
			}
			if (cmbPhongBan.getSelectedIndex() == cmbPhongBan.getItemCount() - 1) {
				phongBan = "all";
			}
			if (maNhanVien.equalsIgnoreCase("")) {
				maNhanVien = "all";
			}
			if (hoTen.equals("")) {
				hoTen = "all";
			}
			if (soCCCD.equals("")) {
				soCCCD = "all";
			}
			if (email.equals("")) {
				email = "all";
			}
			if (soDienThoai.equals("")) {
				soDienThoai = "all";
			}
			System.out.println(maNhanVien);
			System.out.println(hoTen);
			System.out.println(soCCCD);
			System.out.println(email);
			System.out.println(soDienThoai);
			System.out.println(gioiTinh);
			System.out.println(phongBan);

			taiDuLieuLenBang(maNhanVien, hoTen, soCCCD, email, soDienThoai, gioiTinh, phongBan);
		}
	}
}
