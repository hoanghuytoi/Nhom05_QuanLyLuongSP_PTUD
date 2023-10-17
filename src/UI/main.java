package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main extends JFrame {

	private JPanel contentPane;

	
	public main() {
		setTitle("PACEPRO - Hệ thống quản lý lương sản phẩm");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/salary.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 830);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_TieuDe = new JPanel();
		panel_TieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_TieuDe.setBackground(new Color(255, 228, 181));
		panel_TieuDe.setBounds(0, 0, 1534, 50);
		panel.add(panel_TieuDe);
		
		JLabel lblTieuDe = new JLabel("HỆ THỐNG QUẢN LÝ LƯƠNG SẢN PHẨM CÔNG TY - PACEPRO");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel_TieuDe.add(lblTieuDe);
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Menu.setBounds(0, 50, 168, 542);
		panel.add(panel_Menu);
		panel_Menu.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(24, 11, 101, 22);
		panel_Menu.add(menuBar);
		menuBar.setLayout(new GridLayout(9,1));
		
		JMenu menuTrangChu = new JMenu("Trang chủ");
		menuTrangChu.setIcon(new ImageIcon("images\\Home.png"));
		menuTrangChu.setForeground(Color.BLACK);
		menuTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuTrangChu);
		
		JMenu menuPhongBan = new JMenu("Phòng ban");
		menuPhongBan.setIcon(new ImageIcon("images\\PB.png"));
		menuPhongBan.setForeground(Color.BLACK);
		menuPhongBan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuPhongBan);
		
		JMenu menuToNhom = new JMenu("Tổ nhóm");
		menuToNhom.setIcon(new ImageIcon("images\\TN.png"));
		menuToNhom.setForeground(Color.BLACK);
		menuToNhom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuToNhom);
		
		JMenu menuHopDong = new JMenu("Hợp đồng");
		menuHopDong.setIcon(new ImageIcon("images\\HĐ.png"));
		menuHopDong.setForeground(Color.BLACK);
		menuHopDong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuHopDong);
		
		JMenu menuSanPham = new JMenu("Sản phẩm");
		menuSanPham.setIcon(new ImageIcon("images\\SP.png"));
		menuSanPham.setForeground(Color.BLACK);
		menuSanPham.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuSanPham);
		
		JMenuItem submenuSanPham_CapNhat = new JMenuItem("Cập nhật");
		submenuSanPham_CapNhat.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuSanPham_CapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuSanPham.add(submenuSanPham_CapNhat);
		
		JMenuItem submenuSanPham_CongDoanSP = new JMenuItem("Công đoạn sản phẩm");
		submenuSanPham_CongDoanSP.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuSanPham_CongDoanSP.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuSanPham.add(submenuSanPham_CongDoanSP);
		
		JMenuItem submenuSanPham_TimKiem = new JMenuItem("Tìm kiếm");
		submenuSanPham_TimKiem.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuSanPham_TimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuSanPham.add(submenuSanPham_TimKiem);
		
		JMenu menuNhanVien = new JMenu("Nhân viên");
		menuNhanVien.setIcon(new ImageIcon("images\\NVien.png"));
		menuNhanVien.setForeground(Color.BLACK);
		menuNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuNhanVien);
		
		JMenuItem submenuNV_CapNhat = new JMenuItem("Cập nhật");
		submenuNV_CapNhat.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuNV_CapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuNhanVien.add(submenuNV_CapNhat);
		
		JMenuItem submenuNV_ChamCong = new JMenuItem("Chấm công");
		submenuNV_ChamCong.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuNV_ChamCong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuNhanVien.add(submenuNV_ChamCong);
		
		JMenuItem submenuNV_PhanCongCD = new JMenuItem("Phân công công đoạn");
		submenuNV_PhanCongCD.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuNV_PhanCongCD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuNhanVien.add(submenuNV_PhanCongCD);
		
		JMenuItem submenuNV_TienLuong = new JMenuItem("Tiền Lương");
		submenuNV_TienLuong.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuNV_TienLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuNhanVien.add(submenuNV_TienLuong);
		
		JMenuItem submenuNV_TimKiem = new JMenuItem("Tìm kiếm");
		submenuNV_TimKiem.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuNV_TimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuNhanVien.add(submenuNV_TimKiem);
		
		JMenu menuCongNhan = new JMenu("Công nhân");
		menuCongNhan.setIcon(new ImageIcon("images\\CN.png"));
		menuCongNhan.setForeground(Color.BLACK);
		menuCongNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuCongNhan);
		
		JMenuItem submenuCN_CapNhat = new JMenuItem("Cập nhật");
		submenuCN_CapNhat.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuCN_CapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuCongNhan.add(submenuCN_CapNhat);
		
		JMenuItem submenuCN_ChamCong = new JMenuItem("Chấm công");
		submenuCN_ChamCong.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuCN_ChamCong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuCongNhan.add(submenuCN_ChamCong);
		
		JMenuItem submenuCN_TienLuong = new JMenuItem("Tiền lương");
		submenuCN_TienLuong.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuCN_TienLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuCongNhan.add(submenuCN_TienLuong);
		
		JMenuItem submenuCN_TimKiem = new JMenuItem("Tìm kiếm");
		submenuCN_TimKiem.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuCN_TimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuCongNhan.add(submenuCN_TimKiem);
		
		JMenu menuThongKe = new JMenu("Thống kê");
		menuThongKe.setIcon(new ImageIcon("images\\ThongKe.png"));
		menuThongKe.setForeground(Color.BLACK);
		menuThongKe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuThongKe);
		
		JMenuItem submenuThongKe_DT = new JMenuItem("Doanh thu");
		submenuThongKe_DT.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuThongKe_DT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuThongKe.add(submenuThongKe_DT);
		
		JMenuItem submenuThongKe_NV = new JMenuItem("Lương nhân viên");
		submenuThongKe_NV.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuThongKe_NV.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuThongKe.add(submenuThongKe_NV);
		
		JMenuItem submenuThongKe_CN = new JMenuItem("Lương công nhân");
		submenuThongKe_CN.setIcon(new ImageIcon("images\\chamTrang.png"));
		submenuThongKe_CN.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuThongKe.add(submenuThongKe_CN);
		
		JMenu menuHoTro = new JMenu("Hỗ trợ");
		menuHoTro.setIcon(new ImageIcon("images\\HoTro.png"));
		menuHoTro.setForeground(Color.BLACK);
		menuHoTro.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuHoTro);
		
		JPanel panel_TaiKhoan = new JPanel();
		panel_TaiKhoan.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_TaiKhoan.setBounds(0, 585, 168, 206);
		panel.add(panel_TaiKhoan);
		panel_TaiKhoan.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Hoàng Huy Tới");
		lblTaiKhoan.setBounds(20, 69, 138, 24);
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_TaiKhoan.add(lblTaiKhoan);
		
		JLabel lblTK = new JLabel("");
		lblTK.setBounds(62, 18, 40, 40);
		lblTK.setIcon(new ImageIcon("images\\log-in.png"));
		lblTK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_TaiKhoan.add(lblTK);
		
		JLabel lblDoiMK = new JLabel("Đổi mật khẩu");
		lblDoiMK.setIcon(new ImageIcon("images\\DMK.png"));
		lblDoiMK.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDoiMK.setBounds(20, 104, 138, 40);
		panel_TaiKhoan.add(lblDoiMK);
		
		JLabel lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setIcon(new ImageIcon("images\\logout.png"));
		lblDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDangXuat.setBounds(20, 155, 122, 40);
		panel_TaiKhoan.add(lblDangXuat);
		
	}
	
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                main frame = new main();
	                frame.setVisible(true);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
