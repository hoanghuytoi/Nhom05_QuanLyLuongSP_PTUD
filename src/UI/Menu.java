package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;

import Custom_UI.MenuItem;
import Dao.CongNhan_Dao;
import Dao.NhanVien_Dao;
import Entity.CongNhan;
import Entity.NhanVien;

public class Menu extends JFrame {
	private JScrollPane jScrollPane1;
    private JLabel lblTieuDe;
    private JLabel lblXinChao;
    private JPanel menus;
    private JPanel pnBody;
    private JPanel pnHeader;
    private JPanel pnMenu;
    
	private static final long serialVersionUID = 1L;
    // cong nhan
    private MenuItem capNhatCongNhan = null;
    private MenuItem chamCongCongNhan = null;
    private MenuItem tinhLuongCongNhan = null;
    private MenuItem timKiemCongNhan = null;
    // nhan vien
    private MenuItem capNhatNhanVien = null;
    private MenuItem chamCongNhanVien = null;
    private MenuItem tinhLuongNhanVien = null;
    private MenuItem timKiemNhanVien = null;
    private MenuItem phanCongCongNhan = null;
    /// san pham
    private MenuItem capNhatSanPham = null;
    private MenuItem phanCongDoanSanPham = null;
    private MenuItem timKiemSanPham = null;
    // he thong
    private MenuItem dangXuat = null;
    private MenuItem thongTinCaNhan = null;
    // thong ke
    private MenuItem thongKeNhanVien = null;
    private MenuItem thongKeCongNhan = null;
    
    private ImageIcon iconSubMenuNonSelect = null;
    private ImageIcon iconSubMenuSelect = null;

    private CongNhan_Dao congNhan_DAO;
    private NhanVien_Dao nhanVien_DAO;
    private NhanVien nhanVien;
    private CongNhan congNhan;
    
    private MenuItem menuTrangChu;
    private MenuItem menuHopDong;
    private MenuItem menuPhongBan;
    private MenuItem menuToNhom;
    private MenuItem menuNhanVien;
    private MenuItem menuCongNhan;
    private MenuItem menuSanPham;
    private MenuItem menuThongKe;
    private MenuItem menuHoTro;
    private MenuItem menuHeThong;

    
    private String lblTrangChu;
    private String lblPhongBan;
    private String lblToNhom;
    private String lblHopDong;
    private String lblSanPham;
    private String lblCapNhat;
    private String lblPhanCongDoanSanPham;
    private String lblTimKiem;
    private String lblNhanVien;
    private String lblChamCong;
    private String lblPhanCong;
    private String lblLuong;
    private String lblCongNhan;
    private String lblThongKe;
    private String lblHoTro;
    private String lblHeThong;
    private String lblThongTinCaNhan;
    private String lblDangXuat;
    private String lblXacNhanDangXuat;
   
    private String userName;
    private String fileName;
    private NhanVien nhanVienDangNhap;
	
	
    public Menu() throws IOException {
        initComponents();
        execute();
        //caiDatNgonNguChoView(fileName);
    }
    
    
    
    private void execute() throws IOException {
    	ImageIcon iconTrangChu = new ImageIcon(getClass().getResource("/image/icon/home.png"));
    	ImageIcon iconPhongBan = new ImageIcon(getClass().getResource("/image/icon/phongban.png"));
        ImageIcon iconToNhom = new ImageIcon(getClass().getResource("/image/icon/tonhom.png"));
        ImageIcon iconHopDong = new ImageIcon(getClass().getResource("/image/icon/hopdong.png"));  
        ImageIcon iconSanPham = new ImageIcon(getClass().getResource("/image/icon/sanpham.png"));
        ImageIcon iconNhanVien = new ImageIcon(getClass().getResource("/image/icon/nhanvien.png"));
        ImageIcon iconCongNhan = new ImageIcon(getClass().getResource("/image/icon/congnhan.png"));
        ImageIcon iconThongKe = new ImageIcon(getClass().getResource("/image/icon/thongke.png"));
        ImageIcon iconHoTro = new ImageIcon(getClass().getResource("/image/icon/hotro.png"));
        ImageIcon iconHeThong = new ImageIcon(getClass().getResource("/image/icon/hethong.png"));
        
        iconSubMenuNonSelect = new ImageIcon(getClass().getResource("/image/icon/kochon.png"));
        iconSubMenuSelect = new ImageIcon(getClass().getResource("/image/icon/chon.png"));


        capNhatCongNhan = new MenuItem(iconSubMenuNonSelect, lblCapNhat, ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            macDinh(capNhatCongNhan);
        }));
        chamCongCongNhan = new MenuItem(iconSubMenuNonSelect, lblChamCong, ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            macDinh(chamCongCongNhan);
        }));
        timKiemCongNhan = new MenuItem(iconSubMenuNonSelect, lblTimKiem, ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            macDinh(timKiemCongNhan);
        }));
        tinhLuongCongNhan = new MenuItem(iconSubMenuNonSelect, lblLuong, ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            macDinh((tinhLuongCongNhan));
        }));
        
        
        // menu
        menuTrangChu = new MenuItem(iconTrangChu, "Trang chủ", (ActionEvent e) -> {
            pnBody.removeAll();
            
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuTrangChu);

        });
     
        
        menuPhongBan = new MenuItem(iconPhongBan, "Phòng ban", (ActionEvent e) -> {
            pnBody.removeAll();

            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuPhongBan);
        });
        menuToNhom = new MenuItem(iconToNhom, "Tổ nhóm", (ActionEvent e) -> {
            pnBody.removeAll();

            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuToNhom);
        });
        
        menuHopDong = new MenuItem(iconHopDong, "Hợp đồng", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHopDong);
        });
        
        menuSanPham = new MenuItem(iconSanPham, "Sản phẩm", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuSanPham);
        });
        
        menuNhanVien = new MenuItem(iconNhanVien, "Nhân viên", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuNhanVien);
        }, capNhatCongNhan, chamCongCongNhan, tinhLuongCongNhan, timKiemCongNhan);
        
        menuCongNhan = new MenuItem(iconCongNhan, "Công nhân", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuCongNhan);
        });
        
        menuThongKe = new MenuItem(iconThongKe, "Thống kê", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuThongKe);
        });
        menuHoTro = new MenuItem(iconHoTro, "Hỗ trợ", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHoTro);
        });
        menuHeThong = new MenuItem(iconHeThong, "Tài khoản", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHeThong);
        });
        
        addMenu(menuTrangChu,menuPhongBan,menuToNhom,menuHopDong,menuSanPham,menuNhanVien,menuCongNhan,menuThongKe,menuHoTro,menuHeThong);
        
    }
	
    public void macDinh(MenuItem menu) {
        resetSelect();
        menu.setIcon(iconSubMenuSelect);
    }
    
    public void resetSelect() {
        capNhatCongNhan.setIcon(iconSubMenuNonSelect);
        chamCongCongNhan.setIcon(iconSubMenuNonSelect);
        tinhLuongCongNhan.setIcon(iconSubMenuNonSelect);
        timKiemCongNhan.setIcon(iconSubMenuNonSelect);
        
    }
	private void addMenu(MenuItem... menu) {
        for (MenuItem menu1 : menu) {
            menus.add(menu1);
            ArrayList<MenuItem> subMenu = menu1.getSubMenu();
            subMenu.forEach(menuItem -> {
                addMenu(menuItem);
            });
        }
        menus.revalidate();
    }
	
	public void setSelectMenu(JPanel pnelSelect) {
        pnelSelect.setBackground(new Color(0, 206, 201));
        for (Component jc : pnelSelect.getComponents()) {
            if (jc instanceof JLabel) {
                JLabel label = (JLabel) jc;
                label.setForeground(new Color(255, 255, 255));
                label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            }
        }
    }

    public void setNonSelectMenu(JPanel... jPanels) {
        for (JPanel jPanel : jPanels) {
            jPanel.setBackground(new Color(255, 255, 255));
            for (Component jc : jPanel.getComponents()) {
                if (jc instanceof JLabel) {
                    JLabel label = (JLabel) jc;
                    label.setForeground(new Color(12, 12, 12));
                    label.setFont(new Font("Times New Roman", Font.BOLD, 20));
                }
            }
        }
    }

    
    private void initComponents() {

        pnHeader = new JPanel();
        lblTieuDe = new JLabel();
        lblXinChao = new JLabel();
        lblXinChao.setIcon(new ImageIcon(Menu.class.getResource("/image/icon/logocty.png")));
        lblXinChao.setText("Welcome ");
        pnMenu = new JPanel();
        jScrollPane1 = new JScrollPane();
        menus = new JPanel();
        pnBody = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        pnHeader.setBackground(new Color(240, 128, 128));
        pnHeader.setForeground(new Color(41, 128, 185));
        pnHeader.setFont(new Font("Times New Roman", Font.BOLD, 30)); 
        pnHeader.setPreferredSize(new Dimension(1500, 75));
        pnHeader.setLayout(new AbsoluteLayout());

        lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblTieuDe.setForeground(new Color(0, 0, 0));
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setText("HỆ THỐNG QUẢN LÝ LƯƠNG SẢN PHẨM CÔNG TY - PACEPRO");
        pnHeader.add(lblTieuDe, new AbsoluteConstraints(250, 0, 1250, 75));

        lblXinChao.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblXinChao.setForeground(new Color(0, 0, 0));
        lblXinChao.setHorizontalAlignment(SwingConstants.CENTER);
        pnHeader.add(lblXinChao, new AbsoluteConstraints(0, 4, 244, 70));

        getContentPane().add(pnHeader,BorderLayout.PAGE_START);

        pnMenu.setBackground(new Color(255, 255, 255));
        pnMenu.setPreferredSize(new Dimension(250, 725));

        jScrollPane1.setBorder(null);

        menus.setBackground(new Color(60, 99, 130));
        menus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        menus.setLayout(new BoxLayout(menus,BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout pnMenuLayout = new GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );

        getContentPane().add(pnMenu, BorderLayout.LINE_START);

        pnBody.setBackground(new Color(255, 255, 204));
        pnBody.setLayout(new BorderLayout());
        getContentPane().add(pnBody, BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1516, 839));
        setLocationRelativeTo(null);
    }
    
    public void caiDatNgonNguChoView(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        lblTieuDe.setText(prop.getProperty("Menu_lblTieuDe"));
        lblTrangChu = prop.getProperty("Menu_lblTrangChu");
        lblPhongBan = prop.getProperty("Main_lblPhongBan");
        lblToNhom = prop.getProperty("Main_lblToNhom");
        lblHopDong = prop.getProperty("Main_lblHopDong");
        lblSanPham = prop.getProperty("Main_lblSanPham");
        lblCapNhat = prop.getProperty("Main_lblCapNhat");
        lblPhanCongDoanSanPham = prop.getProperty("Main_lblPhanCongDoanSanPham");
        lblTimKiem = prop.getProperty("Main_lblTimKiem");
        lblNhanVien = prop.getProperty("Main_lblNhanVien");
        lblChamCong = prop.getProperty("Main_lblChamCong");
        lblPhanCong = prop.getProperty("Main_lblPhanCongViec");
        lblLuong = prop.getProperty("Main_lblLuong");
        lblCongNhan = prop.getProperty("Main_lblCongNhan");
        lblThongKe = prop.getProperty("Main_lblThongKe");
        lblHoTro = prop.getProperty("Main_lblHoTro");
        lblThongTinCaNhan = prop.getProperty("Main_lblThongTinCaNhan");
        lblDangXuat = prop.getProperty("Main_lblDangXuat");
        lblXacNhanDangXuat = prop.getProperty("Main_lblXacNhanDangXuat");
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Menu frame = new Menu();
	                frame.setVisible(true);
	                frame.setResizable(false);
	                frame.setLocationRelativeTo(null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
}
