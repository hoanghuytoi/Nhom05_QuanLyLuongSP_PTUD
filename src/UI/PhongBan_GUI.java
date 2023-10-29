package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Custom_UI.ScrollBarCustom;
import Dao.PhongBan_Dao;
import Entity.NhanVien;
import Entity.PhongBan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;

public class PhongBan_GUI extends JPanel implements MouseListener, ActionListener{
	private JButton btnCapNhat;
	private JButton btnHuy;
	private JButton btnLuu;
	private JButton btnThem;
	private JButton btnXoa;
	private JLabel lblAnhPB;
	private JSeparator jSeparator1;
	private JSeparator jSeparator3;
	private JSeparator jSeparator2;
	private JLabel lbErrTenPhongBan;
	private JLabel lblMaPhongBan;
	private JLabel lblSoLuongNhanVien;
	private JLabel lblTenPhongBan;
	private JPanel pnlPhongBan;
	private JScrollPane scrPhongBan;
	private JTable tblPhongBan;
	private JTextField txtMaPhongBan;
	private JTextField txtSoLuongNhanVien;
	private JTextField txtTenPhongBan;
	private JLabel lblDsPhongBan;

	private PhongBan_Dao phongBan_DAO;
	private DefaultTableModel defaultTablePhongBan;
	private Object oFlag;
	private NhanVien nhanVienDangNhap;
	private String fileName;
	
	private String stThongbao;
	private String stBanXacNhanXoa;
	private String stXoaThanhCong;
	private String stXoaThatBai;


	public PhongBan_GUI() throws IOException {
		setBackground(Color.WHITE);
		initComponents();
		//caiDatNgonNguChoView(fileName);
		try {
			ConnectionDB.ConnectDB.getInstance().connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
        tblPhongBan.addMouseListener(this);
		phongBan_DAO = new PhongBan_Dao();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnHuy.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLuu.setEnabled(false);
		btnHuy.setEnabled(false);
		execute();
	}

	private void initComponents() {
		setSize(1290, 750);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ PHÒNG BAN");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(510, 11, 296, 55);
		add(lblTieuDe);

		lblDsPhongBan = new JLabel("Danh sách phòng ban:");
		lblDsPhongBan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDsPhongBan.setBounds(100, 414, 162, 20);
		add(lblDsPhongBan);
		
		pnlPhongBan = new JPanel();
		pnlPhongBan.setBounds(24, 93, 1241, 300);
		txtMaPhongBan = new JTextField();
		txtMaPhongBan.setBounds(690, 30, 290, 30);
		jSeparator1 = new JSeparator();
		jSeparator1.setForeground(new Color(0, 0, 0));
		jSeparator1.setBounds(690, 60, 290, 10);
		lblTenPhongBan = new JLabel();
		lblTenPhongBan.setBounds(500, 85, 190, 50);
		txtTenPhongBan = new JTextField();
		txtTenPhongBan.setBounds(690, 90, 290, 30);
		lblAnhPB = new JLabel();
		lblAnhPB.setBounds(24, 20, 422, 192);
		btnLuu = new JButton();
		btnLuu.setBounds(797, 240, 160, 40);
		btnThem = new JButton();
		btnThem.setBounds(138, 240, 170, 40);
		btnXoa = new JButton();
		btnXoa.setBounds(373, 240, 160, 40);
		btnCapNhat = new JButton();
		btnCapNhat.setBackground(new Color(240, 230, 140));
		btnCapNhat.setBounds(584, 240, 160, 40);
		lbErrTenPhongBan = new JLabel();
		lbErrTenPhongBan.setBounds(690, 130, 290, 30);
		lblMaPhongBan = new JLabel();
		lblMaPhongBan.setBounds(500, 25, 190, 50);
		lblSoLuongNhanVien = new JLabel();
		lblSoLuongNhanVien.setBounds(500, 135, 190, 60);
		txtSoLuongNhanVien = new JTextField();
		txtSoLuongNhanVien.setBackground(Color.WHITE);
		txtSoLuongNhanVien.setBounds(690, 150, 290, 30);
		jSeparator2 = new JSeparator();
		jSeparator2.setForeground(Color.BLACK);
		jSeparator2.setBounds(690, 125, 290, 10);
		pnlPhongBan.add(jSeparator2);
		
		jSeparator3 = new JSeparator();
		jSeparator3.setForeground(new Color(0, 0, 0));
		jSeparator3.setBounds(690, 180, 290, 10);
		btnHuy = new JButton();
		btnHuy.setBounds(1010, 240, 170, 40);
		scrPhongBan = new JScrollPane();
		scrPhongBan.setBounds(100, 445, 1078, 292);
		tblPhongBan = new JTable();

		setPreferredSize(new Dimension(1293, 700));

		pnlPhongBan.setBackground(new Color(255, 255, 255));
		pnlPhongBan.setPreferredSize(new java.awt.Dimension(1250, 300));

		txtMaPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaPhongBan.setText("jTextField1");
		txtMaPhongBan.setBorder(null);
		txtMaPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaPhongBanActionPerformed(evt);
			}
		});
		pnlPhongBan.setLayout(null);
		pnlPhongBan.add(txtMaPhongBan);
		pnlPhongBan.add(jSeparator1);

		lblTenPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenPhongBan.setText("Tên phòng ban:");
		pnlPhongBan.add(lblTenPhongBan);

		txtTenPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenPhongBan.setText("jTextField1");
		txtTenPhongBan.setBorder(null);
		txtTenPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtTenPhongBanActionPerformed(evt);
			}
		});
		pnlPhongBan.add(txtTenPhongBan);

		lblAnhPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PhongBan.png")));
		lblAnhPB.setText("jLabel1");
		pnlPhongBan.add(lblAnhPB);

		btnThem.setBackground(new Color(46, 204, 113));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThem.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/them.png")));
		btnThem.setText("Thêm");
		btnThem.setBorder(null);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnThemActionPerformed(evt);
			}
		});
		pnlPhongBan.add(btnThem);

		btnXoa.setBackground(new Color(41, 128, 185));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoa.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/xoa.png")));
		btnXoa.setText("Xóa");
		btnXoa.setBorder(null);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});
		pnlPhongBan.add(btnXoa);

		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCapNhat.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/capNhat.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBorder(null);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCapNhatActionPerformed(evt);
			}
		});
		pnlPhongBan.add(btnCapNhat);

		btnLuu.setBackground(new Color(156, 136, 255));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLuu.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/luu.png")));
		btnLuu.setText("Lưu");
		btnLuu.setBorder(null);
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLuuActionPerformed(evt);
			}
		});
		pnlPhongBan.add(btnLuu);

		lbErrTenPhongBan.setFont(new Font("Segoe UI", 0, 13));
		lbErrTenPhongBan.setForeground(new Color(255, 0, 0));
		lbErrTenPhongBan.setText("đây là dòng thông báo lỗi");
		pnlPhongBan.add(lbErrTenPhongBan);

		lblMaPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaPhongBan.setText("Mã phòng ban:");
		pnlPhongBan.add(lblMaPhongBan);

		lblSoLuongNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18)); 
		lblSoLuongNhanVien.setText("Số lượng nhân viên:");
		pnlPhongBan.add(lblSoLuongNhanVien);

		txtSoLuongNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuongNhanVien.setBorder(null);
		txtSoLuongNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtSoLuongNhanVienActionPerformed(evt);
			}
		});
		pnlPhongBan.add(txtSoLuongNhanVien);
		pnlPhongBan.add(jSeparator3);

		btnHuy.setBackground(new Color(255, 121, 121));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHuy.setIcon(new ImageIcon(PhongBan_GUI.class.getResource("/image/icon/huy.png")));
		btnHuy.setText("Hủy");
		btnHuy.setBorder(null);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnHuyActionPerformed(evt);
			}
		});
		setLayout(null);
		pnlPhongBan.add(btnHuy);
		add(pnlPhongBan);

		scrPhongBan.setBackground(new Color(0, 0, 0));
		tblPhongBan.getTableHeader().setBackground(new Color(128, 200, 255));
		tblPhongBan.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
						"STT", "M\u00E3 ph\u00F2ng ban", "T\u00EAn ph\u00F2ng ban", "S\u1ED1 l\u01B0\u01A1ng nh\u00E2n vi\u00EAn"
				}
				));
		tblPhongBan.setSelectionBackground(new Color(255, 160, 122));
		tblPhongBan.getTableHeader().setReorderingAllowed(false);
		tblPhongBan.setRowHeight(30); 
		tblPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblPhongBan.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		tblPhongBan.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblPhongBan.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblPhongBan.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblPhongBan.getColumnModel().getColumn(3).setPreferredWidth(150);

		scrPhongBan.setViewportView(tblPhongBan);

		add(scrPhongBan);
		ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.RED);
		scrPhongBan.setVerticalScrollBar(scrollBar);
	}

	private void txtMaPhongBanActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtTenPhongBanActionPerformed(java.awt.event.ActionEvent evt) {	
	}

	private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void txtSoLuongNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
		txtTenPhongBan.setEditable(false);
	}


	public void execute() {
		this.txtMaPhongBan.setBackground(Color.WHITE);
		this.txtMaPhongBan.setText("");
		this.txtTenPhongBan.setBackground(Color.WHITE);
		this.txtTenPhongBan.setText("");
		this.lbErrTenPhongBan.setText("");
		txtMaPhongBan.setEditable(false);
		txtTenPhongBan.setEditable(false);
		txtSoLuongNhanVien.setEditable(false);
		defaultTablePhongBan = (DefaultTableModel) tblPhongBan.getModel();
		taiDuLieuLenBang();
	}

	public void taiDuLieuLenBang() {
		while (tblPhongBan.getRowCount() != 0) {
			defaultTablePhongBan.removeRow(0);
		}
		ArrayList<PhongBan> danhSachPhongBan = phongBan_DAO.layDanhSachPhongBan();

		for (PhongBan phongBan : danhSachPhongBan) {
			String data[] = {(defaultTablePhongBan.getRowCount() + 1) + "", phongBan.getMaPhongBan(), phongBan.getTenPhongBan(), phongBan.getSoLuongNhanVien() + ""};
			defaultTablePhongBan.addRow(data);
		}
		if (tblPhongBan.getRowCount() != 0) {
			tblPhongBan.setRowSelectionInterval(0, 0);
			hienThiDuLieuLenTxt(0);
		}
	}

	public void hienThiDuLieuLenTxt(int dong) {
		txtMaPhongBan.setText(tblPhongBan.getValueAt(dong, 1).toString());
		txtTenPhongBan.setText(tblPhongBan.getValueAt(dong, 2).toString());
		txtSoLuongNhanVien.setText(tblPhongBan.getValueAt(dong, 3).toString());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tblPhongBan)) {

			int row = tblPhongBan.getSelectedRow();
			if (row != -1) {
				hienThiDuLieuLenTxt(row);
				if (!btnThem.isEnabled()) {
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					btnCapNhat.setEnabled(true);
					btnLuu.setEnabled(false);
					btnHuy.setEnabled(false);
					txtTenPhongBan.setEditable(false);
					lbErrTenPhongBan.setText("");
				}
			}
		}
	}

	public void khoaMoTxt(boolean b) {
		txtTenPhongBan.setEditable(b);
		txtTenPhongBan.requestFocus();
	}
	
	public void xoaTrang() {
		txtTenPhongBan.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		if (o.equals(btnThem)) {
			// gán cờ 
			oFlag = e.getSource();
			khoaMoTxt(true);
			xoaTrang();
			// đóng | mở button
			btnCapNhat.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThem.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			txtMaPhongBan.setText(phongBan_DAO.layRaMaPhongBanDeThem());
			txtSoLuongNhanVien.setText("0");

		} else if (o.equals(btnLuu)) {
			// Xử lý sự kiện lưu
			// Xử lý Thêm phòng ban
			// btnFlag để lưu các JButton vừa click
			if (oFlag.equals(btnThem)) {
				String maPhongBan = txtMaPhongBan.getText();
				if (txtTenPhongBan.getText().equals("")) {
					lbErrTenPhongBan.setText("Không để trống");
					return;
				} else if (!txtTenPhongBan.getText().toLowerCase().matches("^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){0,})$")) {
					lbErrTenPhongBan.setText("Tên phòng ban sai! Nhập lại");
					return;
				} else {
					lbErrTenPhongBan.setText("");
				}
				String tenPhongBan = txtTenPhongBan.getText().trim();
				boolean coThemDuoc = phongBan_DAO.themMotPhongBan(new PhongBan(maPhongBan, tenPhongBan, 0));
				if (coThemDuoc) {
					// tải dữ liệu lại vào jtable
					taiDuLieuLenBang();
					// đóng mở các button
					btnCapNhat.setEnabled(true);
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					btnLuu.setEnabled(false);
					btnHuy.setEnabled(false);
					oFlag = null;
					khoaMoTxt(false); // false là khóa lại, true là mở ra
					JOptionPane.showMessageDialog(null,"Thêm phòng ban thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Thêm phòng ban thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (oFlag.equals(btnCapNhat)) {
				String maPhongBan = txtMaPhongBan.getText();
				if (txtTenPhongBan.getText().equals("")) {
					lbErrTenPhongBan.setText("Không để trống");
					return;
				} else if (!txtTenPhongBan.getText().toLowerCase().matches("^([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)(\\s{1}[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){0,}$")) {
					lbErrTenPhongBan.setText("Tên phòng ban sai! Nhập lại");
					return;
				}else {
					lbErrTenPhongBan.setText("");
				}
				int soLuongNhanVien = 0;
				try {
					soLuongNhanVien = Integer.parseInt(txtSoLuongNhanVien.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Số lượng nhân viên phải là số");
				}
				String tenPhongBan = txtTenPhongBan.getText().trim();
				boolean coSuaDuoc = phongBan_DAO.suaMotPhongBan(new PhongBan(maPhongBan, tenPhongBan, soLuongNhanVien));
				if (coSuaDuoc) {
					// đóng mở button
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					btnCapNhat.setEnabled(true);
					btnHuy.setEnabled(false);
					btnLuu.setEnabled(false);
					oFlag = null;
					khoaMoTxt(false);
					taiDuLieuLenBang();
					JOptionPane.showMessageDialog(null,"Cập nhật phòng ban thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Cập nhật phòng bban thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else if (o.equals(btnCapNhat)) {
			// Xử lý cập nhật phòng ban
			khoaMoTxt(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnCapNhat.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			// gán cờ
			oFlag = btnCapNhat;
		} else if (o.equals(btnXoa)) {

			int rowSelected = tblPhongBan.getSelectedRow();
			if (rowSelected != -1) {
				int coXacNhanXoa = JOptionPane.showConfirmDialog(null, stBanXacNhanXoa, stThongbao, JOptionPane.ERROR_MESSAGE);
				if (coXacNhanXoa == 0) {
					boolean coXoaDuoc = phongBan_DAO.xoaMotPhongBanTheoMa(tblPhongBan.getValueAt(tblPhongBan.getSelectedRow(), 1).toString());
					if (coXoaDuoc) {
						JOptionPane.showMessageDialog(null, stXoaThanhCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
						taiDuLieuLenBang();
					} else {
						JOptionPane.showMessageDialog(null, stXoaThatBai, stThongbao, JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		} else if (o.equals(btnHuy)) {
			btnThem.setEnabled(true);
			btnCapNhat.setEnabled(true);
			btnXoa.setEnabled(true);
			btnHuy.setEnabled(false);
			btnLuu.setEnabled(false);
			lbErrTenPhongBan.setText("");
			if (tblPhongBan.getSelectedRow() != -1) {
				hienThiDuLieuLenTxt(tblPhongBan.getSelectedRow());
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
