package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class Home_GUI extends JFrame implements ActionListener, MouseListener{
	private JButton btnTrangChu,btnNhanVien,btnCongNhan,btnSanPham,btnLuong,btnThongKe,btnTaiKhoan;
	
	public Home_GUI() {
		setTitle("PACEPRO - Phầm mềm quản lý lương sản phẩm");
		setSize(1450, 820);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/logo.png"));
		createGUI();
	}
	
	public void createGUI() {
		JPanel panelHead = new JPanel();
		panelHead.setLayout(new FlowLayout());
		panelHead.setBackground(new Color(175, 238, 238));
		add(panelHead, BorderLayout.NORTH);
		
		ImageIcon imgLogo = new ImageIcon("images/logoApp.png");
		panelHead.add(new JLabel(imgLogo));
		panelHead.add(Box.createHorizontalStrut(30));

		ImageIcon imgHome = new ImageIcon("images/logoTC.png");
		panelHead.add(btnTrangChu = new JButton("Trang chủ", imgHome));
		btnTrangChu.setFont(new Font("Arial", Font.BOLD, 14));
		btnTrangChu.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTrangChu.setBackground(new Color(90, 110, 200));
		btnTrangChu.setForeground(new Color(0,0,0));
		
		ImageIcon imgNV = new ImageIcon("images/logoNV.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnNhanVien = new JButton("Nhân Viên", imgNV));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnNhanVien.setBackground(new Color(60, 200, 110));
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem itemCNhat = new JMenuItem("Cập Nhật");
		itemCNhat.setFont(new Font("Arial", Font.BOLD, 14));
		itemCNhat.setBackground(new Color(80, 240, 100)); 
		itemCNhat.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemCNhat.setForeground(new Color(255, 255, 255));
		itemCNhat.setPreferredSize(btnNhanVien.getPreferredSize());
		
		JMenuItem itemChamCong = new JMenuItem("Chấm Công");
		itemChamCong.setFont(new Font("Arial", Font.BOLD, 14));
		itemChamCong.setBackground(new Color(60, 200, 110)); 
		itemChamCong.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemChamCong.setForeground(new Color(255, 255, 255));
		itemChamCong.setPreferredSize(btnNhanVien.getPreferredSize());
		
		popupMenu.add(itemCNhat);
		popupMenu.add(itemChamCong);
		
		btnNhanVien.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        popupMenu.show(btnNhanVien, 0, btnNhanVien.getHeight());
		    }
		});
	
		ImageIcon imgCN = new ImageIcon("images/logoCN.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnCongNhan = new JButton("Công Nhân", imgCN));
		btnCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		btnCongNhan.setBackground(Color.WHITE);
		btnCongNhan.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCongNhan.setBackground(new Color(60, 200, 110));
		btnCongNhan.setForeground(new Color(255, 255, 255));
		btnCongNhan.setPreferredSize(btnTrangChu.getPreferredSize());
		
				
		btnCongNhan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(btnCongNhan, 0, btnCongNhan.getHeight());
			}
		});
		
		ImageIcon imgSP = new ImageIcon("images/logoSPham.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnSanPham = new JButton("Sản Phẩm", imgSP));
		btnSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		btnSanPham.setBackground(Color.WHITE);
		btnSanPham.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnSanPham.setBackground(new Color(60, 200, 110));
		btnSanPham.setForeground(new Color(255, 255, 255));
		btnSanPham.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenuSP = new JPopupMenu();
		
		JMenuItem itemCN = new JMenuItem("Cập Nhật");
		itemCN.setFont(new Font("Arial", Font.BOLD, 14));
		itemCN.setBackground(new Color(80, 240, 100)); 
		itemCN.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemCN.setForeground(new Color(255, 255, 255));
		itemCN.setPreferredSize(btnSanPham.getPreferredSize());
		
		JMenuItem itemPhanCongDoan = new JMenuItem("Phân công đoạn");
		itemPhanCongDoan.setFont(new Font("Arial", Font.BOLD, 14));
		itemPhanCongDoan.setBackground(new Color(60, 200, 110)); 
		itemPhanCongDoan.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemPhanCongDoan.setForeground(new Color(255, 255, 255));
		itemPhanCongDoan.setPreferredSize(btnSanPham.getPreferredSize());
		
		popupMenuSP.add(itemCN);
		popupMenuSP.add(itemPhanCongDoan);
		
		btnSanPham.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenuSP.show(btnSanPham, 0, btnSanPham.getHeight());
			}
		});
		
		
		ImageIcon imgCNhat = new ImageIcon("images/logoLuong.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnLuong = new JButton("Lương", imgCNhat));
		btnLuong.setFont(new Font("Arial", Font.BOLD, 14));
		btnLuong.setBackground(Color.WHITE);
		btnLuong.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnLuong.setBackground(new Color(60, 200, 110));
		btnLuong.setForeground(new Color(255, 255, 255));
		btnLuong.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenuLuong = new JPopupMenu();
		
		JMenuItem itemLuongCN = new JMenuItem("Lương Công Nhân");
		itemLuongCN.setFont(new Font("Arial", Font.BOLD, 13));
		itemLuongCN.setBackground(new Color(80, 240, 100)); 
		itemLuongCN.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemLuongCN.setForeground(new Color(255, 255, 255));
		itemLuongCN.setPreferredSize(btnLuong.getPreferredSize());
		
		JMenuItem itemLuongNV = new JMenuItem("Lương Nhân Viên");
		itemLuongNV.setFont(new Font("Arial", Font.BOLD, 13));
		itemLuongNV.setBackground(new Color(60, 200, 110)); 
		itemLuongNV.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemLuongNV.setForeground(new Color(255, 255, 255));
		itemLuongNV.setPreferredSize(btnLuong.getPreferredSize());
		
		popupMenuLuong.add(itemLuongCN);
		popupMenuLuong.add(itemLuongNV);
		
		btnLuong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenuLuong.show(btnLuong, 0, btnLuong.getHeight());
			}
		});
		
		ImageIcon imgThongKe = new ImageIcon("images/logoThongKe.png");
		panelHead.add(Box.createHorizontalStrut(20));
		panelHead.add(btnThongKe = new JButton("Thống Kê", imgThongKe));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnThongKe.setBackground(new Color(60, 200, 110));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenuTKe = new JPopupMenu();
		
		JMenuItem itemThongKeCN = new JMenuItem("Lương Công Nhân");
		itemThongKeCN.setFont(new Font("Arial", Font.BOLD, 13));
		itemThongKeCN.setBackground(new Color(80, 240, 100)); 
		itemThongKeCN.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemThongKeCN.setForeground(new Color(255, 255, 255));
		itemThongKeCN.setPreferredSize(btnThongKe.getPreferredSize());
		
		JMenuItem itemThongKeNV = new JMenuItem("Lương Nhân Viên");
		itemThongKeNV.setFont(new Font("Arial", Font.BOLD, 13));
		itemThongKeNV.setBackground(new Color(60, 200, 110)); 
		itemThongKeNV.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemThongKeNV.setForeground(new Color(255, 255, 255));
		itemThongKeNV.setPreferredSize(btnThongKe.getPreferredSize());

		JMenuItem itemThongKeDT = new JMenuItem("Doanh Thu");
		itemThongKeDT.setFont(new Font("Arial", Font.BOLD, 13));
		itemThongKeDT.setBackground(new Color(30, 250, 110)); 
		itemThongKeDT.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemThongKeDT.setForeground(new Color(255, 255, 255));
		itemThongKeDT.setPreferredSize(btnThongKe.getPreferredSize());
		
		popupMenuTKe.add(itemThongKeCN);
		popupMenuTKe.add(itemThongKeNV);
		popupMenuTKe.add(itemThongKeDT);
		
		btnThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenuTKe.show(btnThongKe, 0, btnThongKe.getHeight());
			}
		});
		
		
		ImageIcon imgTKhoan = new ImageIcon("images/logoTK.png");
		panelHead.add(Box.createHorizontalStrut(30));
		panelHead.add(btnTaiKhoan = new JButton("Tài Khoản", imgTKhoan));
		btnTaiKhoan.setFont(new Font("Arial", Font.BOLD, 14));
		btnTaiKhoan.setBackground(Color.WHITE);
		btnTaiKhoan.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTaiKhoan.setBackground(new Color(60, 200, 110));
		btnTaiKhoan.setForeground(new Color(255, 255, 255));
		btnTaiKhoan.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenuTK = new JPopupMenu();
		
		JMenuItem itemDoiMK = new JMenuItem("Đổi mật khẩu");
		itemDoiMK.setFont(new Font("Arial", Font.BOLD, 13));
		itemDoiMK.setBackground(new Color(80, 240, 100)); 
		itemDoiMK.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemDoiMK.setForeground(new Color(255, 255, 255));
		itemDoiMK.setPreferredSize(btnTaiKhoan.getPreferredSize());
		ImageIcon imgLogoDMK = new ImageIcon("images/logoDMK.png");
		itemDoiMK.setIcon(imgLogoDMK);
		
		
		JMenuItem itemDangXuat = new JMenuItem("Đăng xuất");
		itemDangXuat.setFont(new Font("Arial", Font.BOLD, 14));
		itemDangXuat.setBackground(new Color(60, 200, 110)); 
		itemDangXuat.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemDangXuat.setForeground(new Color(255, 255, 255));
		itemDangXuat.setPreferredSize(btnTaiKhoan.getPreferredSize());
		ImageIcon imgLogoDX = new ImageIcon("images/logoThoat.png");
		itemDangXuat.setIcon(imgLogoDX);
		
		popupMenuTK.add(itemDoiMK);
		popupMenuTK.add(itemDangXuat);
		
		btnTaiKhoan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenuTK.show(btnTaiKhoan, 0, btnTaiKhoan.getHeight());
			}
		});
		
		
		JPanel bannerPanel = new JPanel();
		bannerPanel.setLayout(new BorderLayout());
		JLabel lblChuongTrinh = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ LƯƠNG SẢN PHẨM");
		lblChuongTrinh.setHorizontalAlignment(JLabel.CENTER);
		lblChuongTrinh.setForeground(Color.RED);
		Font chuongTrinhFont = new Font(lblChuongTrinh.getFont().getName(), Font.BOLD, 30);
		lblChuongTrinh.setFont(chuongTrinhFont);
		bannerPanel.add(lblChuongTrinh, BorderLayout.CENTER);
		add(bannerPanel, BorderLayout.CENTER);

		ImageIcon banner = new ImageIcon("images/background.png");
		JLabel lblBanner = new JLabel(banner);
		bannerPanel.add(lblBanner, BorderLayout.SOUTH);
		
		
		btnTrangChu.addActionListener(this);
		//btnNhanVien.addActionListener(this);
		//btnCongNhan.addActionListener(this);
		//btnThoat.addActionListener(this);
		
		btnTrangChu.addMouseListener(this);
		//btnNhanVien.addMouseListener(this);
		//btnCongNhan.addMouseListener(this);
		//btnThoat.addMouseListener(this);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnTrangChu) {
			setVisible(false);
			new Home_GUI().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Home_GUI().setVisible(true);
	}

}
