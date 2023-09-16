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

<<<<<<< HEAD
import javax.swing.BorderFactory;
=======
>>>>>>> 2be857b (Sign In)
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
	private JButton btnTrangChu,btnNhanVien,btnCongNhan,btnSanPham,btnCapNhat,btnTimKiem,btnThongKe,btnTaiKhoan;
	
	public Home_GUI() {
		setTitle("PACEPRO - Phầm mềm quản lý lương sản phẩm");
		setSize(1500, 830);
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
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnNhanVien = new JButton("Nhân Viên", imgNV));
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnNhanVien.setBackground(new Color(60, 200, 110));
		btnNhanVien.setForeground(new Color(255, 255, 255));
		btnNhanVien.setPreferredSize(btnTrangChu.getPreferredSize());
		
		JPopupMenu popupMenu = new JPopupMenu();

		// Thêm các mục menu vào menu con
		JMenuItem itemChamCong = new JMenuItem("Chấm Công");
		itemChamCong.setFont(new Font("Arial", Font.BOLD, 16));
		itemChamCong.setBackground(new Color(60, 200, 110)); // Đặt màu nền
		itemChamCong.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemChamCong.setForeground(new Color(255, 255, 255)); // Đặt màu văn bản
		itemChamCong.setPreferredSize(btnNhanVien.getPreferredSize());
		
		JMenuItem itemTL = new JMenuItem("Tiền Lương");
		itemTL.setFont(new Font("Arial", Font.BOLD, 16));
		itemTL.setBackground(new Color(80, 240, 100)); 
		itemTL.setBorder(new EmptyBorder(10, 10, 10, 10));
		itemTL.setForeground(new Color(255, 255, 255));
		itemTL.setPreferredSize(btnNhanVien.getPreferredSize());
		
		popupMenu.add(itemChamCong);
		popupMenu.add(itemTL);
		
		// Đặt sự kiện cho nút "Nhân Viên" để hiển thị menu con khi được nhấn
		btnNhanVien.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        popupMenu.show(btnNhanVien, 0, btnNhanVien.getHeight());
		    }
		});
	
		ImageIcon imgCN = new ImageIcon("images/logoCN.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnCongNhan = new JButton("Công Nhân", imgCN));
		btnCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		btnCongNhan.setBackground(Color.WHITE);
		btnCongNhan.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCongNhan.setBackground(new Color(60, 200, 110));
		btnCongNhan.setForeground(new Color(255, 255, 255));
		btnCongNhan.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgSP = new ImageIcon("images/logoSPham.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnSanPham = new JButton("Sản Phẩm", imgSP));
		btnSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		btnSanPham.setBackground(Color.WHITE);
		btnSanPham.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnSanPham.setBackground(new Color(60, 200, 110));
		btnSanPham.setForeground(new Color(255, 255, 255));
		btnSanPham.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgCNhat = new ImageIcon("images/logoLuong.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnCapNhat = new JButton("Lương", imgCNhat));
		btnCapNhat.setFont(new Font("Arial", Font.BOLD, 14));
		btnCapNhat.setBackground(Color.WHITE);
		btnCapNhat.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnCapNhat.setBackground(new Color(60, 200, 110));
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgTKiem = new ImageIcon("images/logoTKiem.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnTimKiem = new JButton("Tìm Kiếm", imgTKiem));
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTimKiem.setBackground(new Color(60, 200, 110));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgThongKe = new ImageIcon("images/logoThongKe.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnThongKe = new JButton("Thống Kê", imgThongKe));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnThongKe.setBackground(new Color(60, 200, 110));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setPreferredSize(btnTrangChu.getPreferredSize());
		
		ImageIcon imgTKhoan = new ImageIcon("images/logoTK.png");
		panelHead.add(Box.createHorizontalStrut(15));
		panelHead.add(btnThongKe = new JButton("Tài Khoản", imgTKhoan));
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnThongKe.setBackground(new Color(60, 200, 110));
		btnThongKe.setForeground(new Color(255, 255, 255));
		btnThongKe.setPreferredSize(btnTrangChu.getPreferredSize());
		
		
		JPanel bannerPanel = new JPanel();
		bannerPanel.setLayout(new BorderLayout());
		JLabel lblChuongTrinh = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ LƯƠNG SẢN PHẨM");
		lblChuongTrinh.setHorizontalAlignment(JLabel.CENTER);
		lblChuongTrinh.setForeground(Color.RED);
		Font chuongTrinhFont = new Font(lblChuongTrinh.getFont().getName(), Font.BOLD, 30);
		lblChuongTrinh.setFont(chuongTrinhFont);
		bannerPanel.add(lblChuongTrinh, BorderLayout.CENTER);
		add(bannerPanel, BorderLayout.CENTER);

		// Tạo JLabel cho hình ảnh nền
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
