package UI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import Custom_UI.MenuItem;
import Custom_UI.ScrollBarCustom;
import Dao.CongNhan_Dao;
import Dao.NhanVien_Dao;
import Entity.CongNhan;
import Entity.NhanVien;

/**
 * Hoàng Huy Tới
 */

public class Main_GUI extends JFrame {
	private JScrollPane jScrollPane;
    private JLabel lblTieuDe;
    private JLabel lblXinChao;
    private JPanel menus;
    private JPanel pnBody;
    private JPanel pnHeader;
    private JPanel pnMenu;
    
	private static final long serialVersionUID = 1L;
	
	// san pham
    private MenuItem capNhatSanPham = null;
    private MenuItem phanCongDoanSanPham = null;
    private MenuItem timKiemSanPham = null;
    
    // nhan vien
    private MenuItem capNhatNhanVien = null;
    private MenuItem chamCongNhanVien = null;
    private MenuItem tinhLuongNhanVien = null;
    private MenuItem timKiemNhanVien = null;
    private MenuItem phanCongCongNhan = null;
  
    // cong nhan
    private MenuItem capNhatCongNhan = null;
    private MenuItem chamCongCongNhan = null;
    private MenuItem tinhLuongCongNhan = null;
    private MenuItem timKiemCongNhan = null;
    
    // thong ke
    private MenuItem thongKeDoanhThu = null;
    private MenuItem thongKeNhanVien = null;
    private MenuItem thongKeCongNhan = null;
    
    // he thong
    private MenuItem thongTinCaNhan = null;
    private MenuItem doiMatKhau = null;
    private MenuItem dangXuat = null;
  
    private ImageIcon iconSubMenuNonSelect = null;
    private ImageIcon iconSubMenuSelect = null;
    private ImageIcon iconResetPassword = null;
    private ImageIcon iconLogOut = null;

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

	
	
    public Main_GUI() throws IOException {
        initComponents();
        execute();
    }
    
    private void initComponents() {
    	setTitle("PACEPRO - Hệ thống quản lý lương sản phẩm");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_GUI.class.getResource("/image/icon/salary.png")));
		
        pnHeader = new JPanel();
        lblTieuDe = new JLabel();
        lblXinChao = new JLabel();
        lblXinChao.setIcon(new ImageIcon(Main_GUI.class.getResource("/image/icon/logocty.png")));
        lblXinChao.setText("Welcome ");
        pnMenu = new JPanel();
        jScrollPane = new JScrollPane();
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

        jScrollPane.setBorder(null);

        menus.setBackground(new Color(60, 99, 130));
        menus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        menus.setLayout(new BoxLayout(menus,BoxLayout.Y_AXIS));
        jScrollPane.setViewportView(menus);
        
        ScrollBarCustom scrollBar = new ScrollBarCustom();

        // Chèn ScrollBarCustom vào JScrollPane
        jScrollPane.setVerticalScrollBar(scrollBar);

        javax.swing.GroupLayout pnMenuLayout = new GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );

        getContentPane().add(pnMenu, BorderLayout.LINE_START);

        pnBody.setBackground(new Color(255, 255, 204));
        pnBody.setLayout(new BorderLayout());
        getContentPane().add(pnBody, BorderLayout.CENTER);

        setSize(new Dimension(1540, 835));
        setLocationRelativeTo(null);
        
        setVisible(true);
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
        
        iconResetPassword = new ImageIcon(getClass().getResource("/image/icon/doimatkhau.png"));
        iconLogOut = new ImageIcon(getClass().getResource("/image/icon/dangxuat.png"));

        // subMenu sản phẩm
        capNhatSanPham = new MenuItem(iconSubMenuNonSelect, "Cập nhật", ((e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new SanPham_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(capNhatSanPham);
        }));
        
        phanCongDoanSanPham = new MenuItem(iconSubMenuNonSelect, "Công đoạn sản phẩm", ((e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new CongDoanSanPham_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(phanCongDoanSanPham);
        }));
        
        timKiemSanPham = new MenuItem(iconSubMenuNonSelect, "Tìm kiếm", ((e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new TimKiemSanPham_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(timKiemSanPham);
        }));
        
        // subMenu nhan vien
        capNhatNhanVien = new MenuItem(iconSubMenuNonSelect, "Cập nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnBody.removeAll();
                
                pnBody.repaint();
                pnBody.revalidate();
                iconSubMenuMacDinh((capNhatNhanVien));
            }
        });
        
        chamCongNhanVien = new MenuItem(iconSubMenuNonSelect, "Chấm công", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((chamCongNhanVien));
        });
        
        tinhLuongNhanVien = new MenuItem(iconSubMenuNonSelect, "Tính lương", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnBody.removeAll();
                
                pnBody.repaint();
                pnBody.revalidate();
                iconSubMenuMacDinh(tinhLuongNhanVien);
            }

        });
        
        timKiemNhanVien = new MenuItem(iconSubMenuNonSelect, "Tìm kiếm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnBody.removeAll();
                
                pnBody.repaint();
                pnBody.revalidate();
                iconSubMenuMacDinh(timKiemNhanVien);
            }

        });
        
        phanCongCongNhan = new MenuItem(iconSubMenuNonSelect, "Phân công công đoạn", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(phanCongCongNhan);
        }));
        
        // subMenu công nhân
        capNhatCongNhan = new MenuItem(iconSubMenuNonSelect, "Cập nhật", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(capNhatCongNhan);
        }));
        
        chamCongCongNhan = new MenuItem(iconSubMenuNonSelect, "Chấm công", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(chamCongCongNhan);
        }));
        
        timKiemCongNhan = new MenuItem(iconSubMenuNonSelect, "Tìm kiếm", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh(timKiemCongNhan);
        }));
        
        tinhLuongCongNhan = new MenuItem(iconSubMenuNonSelect, "Tính lương", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((tinhLuongCongNhan));
        }));
        
        // subMenu thống kê
        thongKeDoanhThu = new MenuItem(iconSubMenuNonSelect, "Doanh thu", ((e) -> {
            pnBody.removeAll();
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((thongKeDoanhThu));
            
        }));
        
        thongKeNhanVien = new MenuItem(iconSubMenuNonSelect, "Nhân viên", ((e) -> {
            pnBody.removeAll();
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((thongKeNhanVien));
            
        }));
        
        thongKeCongNhan = new MenuItem(iconSubMenuNonSelect, "Công nhân", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((thongKeCongNhan));
        }));
        
        // subMenu he thong
        thongTinCaNhan = new MenuItem(iconSubMenuNonSelect, "Thông tin cá nhân", ((e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new ThongTinCaNhan_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((thongTinCaNhan));
        }));
        
        doiMatKhau = new MenuItem(iconResetPassword, "Đổi mật khẩu", ((e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            iconSubMenuMacDinh((doiMatKhau));
        }));
        
        dangXuat = new MenuItem(iconLogOut, "Đăng xuất", ((e) -> {
        	iconSubMenuMacDinh((dangXuat));
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất tài khoản không!!!", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                Login_GUI loginGUI = new Login_GUI();
                loginGUI.setLocationRelativeTo(null);
                loginGUI.setVisible(true);
                loginGUI.setResizable(false);
            } else {
                dangXuat.setIcon(iconLogOut);
            }
        }));
        
        
        // menu Trang chủ
        menuTrangChu = new MenuItem(iconTrangChu, "Trang chủ", (ActionEvent e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new TrangChu_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuTrangChu);

        });
        
        // menu Phòng ban
        menuPhongBan = new MenuItem(iconPhongBan, "Phòng ban", (ActionEvent e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new PhongBan_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuPhongBan);
        });
        
        // menu Tổ nhóm
        menuToNhom = new MenuItem(iconToNhom, "Tổ nhóm", (ActionEvent e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new ToNhom_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuToNhom);
        });
        
        // menu Hộp đồng
        menuHopDong = new MenuItem(iconHopDong, "Hợp đồng", (ActionEvent e) -> {
            pnBody.removeAll();
            try {
                pnBody.add(new HopDong_GUI(), BorderLayout.CENTER);
            } catch (Exception ex) {
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHopDong);
        });
        
        //menu Sản phẩm
        menuSanPham = new MenuItem(iconSanPham, "Sản phẩm", (ActionEvent e) -> {
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuSanPham);
        },capNhatSanPham,phanCongDoanSanPham,timKiemSanPham);
        
        // menu Nhân viên
        menuNhanVien = new MenuItem(iconNhanVien, "Nhân viên", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuNhanVien);
        }, capNhatNhanVien, chamCongNhanVien, phanCongCongNhan, tinhLuongNhanVien, timKiemNhanVien);
        
        // menu Công nhân
        menuCongNhan = new MenuItem(iconCongNhan, "Công nhân", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuCongNhan);
        }, capNhatCongNhan, chamCongCongNhan, tinhLuongCongNhan, timKiemCongNhan);
        
        // menu Thống kê
        menuThongKe = new MenuItem(iconThongKe, "Thống kê", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuThongKe);
        },thongKeDoanhThu,thongKeNhanVien,thongKeCongNhan);
        
        // menu Hỗ trợ
        menuHoTro = new MenuItem(iconHoTro, "Hỗ trợ", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHoTro);
        });
        
        // menu Tài khoản
        menuHeThong = new MenuItem(iconHeThong, "Tài khoản", (ActionEvent e) -> {
            pnBody.removeAll();
            
            pnBody.repaint();
            pnBody.revalidate();
            setNonSelectMenu(menuTrangChu, menuHopDong, menuPhongBan, menuToNhom, menuNhanVien, menuCongNhan, menuSanPham, menuThongKe, menuHoTro,menuHeThong);
            setSelectMenu(menuHeThong);
        },thongTinCaNhan,doiMatKhau,dangXuat);
        
        addMenu(menuTrangChu,menuPhongBan,menuToNhom,menuHopDong,menuSanPham,menuNhanVien,menuCongNhan,menuThongKe,menuHoTro,menuHeThong);
        
    }
	
    public void iconSubMenuMacDinh(MenuItem menu) {
        resetSelect();
        menu.setIcon(iconSubMenuSelect);
    }
    
    public void resetSelect() {
    	/// san pham
        capNhatSanPham.setIcon(iconSubMenuNonSelect);
        phanCongDoanSanPham.setIcon(iconSubMenuNonSelect);
        timKiemSanPham.setIcon(iconSubMenuNonSelect);
        
    	// nhan vien
        capNhatNhanVien.setIcon(iconSubMenuNonSelect);
        chamCongNhanVien.setIcon(iconSubMenuNonSelect);
        tinhLuongNhanVien.setIcon(iconSubMenuNonSelect);
        timKiemNhanVien.setIcon(iconSubMenuNonSelect);
        phanCongCongNhan.setIcon(iconSubMenuNonSelect);
    	
        // công nhân
        capNhatCongNhan.setIcon(iconSubMenuNonSelect);
        chamCongCongNhan.setIcon(iconSubMenuNonSelect);
        tinhLuongCongNhan.setIcon(iconSubMenuNonSelect);
        timKiemCongNhan.setIcon(iconSubMenuNonSelect);
        
        // thong ke
        thongKeDoanhThu.setIcon(iconSubMenuNonSelect);
        thongKeNhanVien.setIcon(iconSubMenuNonSelect);
        thongKeCongNhan.setIcon(iconSubMenuNonSelect);
        
        // he thong
        thongTinCaNhan.setIcon(iconSubMenuNonSelect);
        doiMatKhau.setIcon(iconResetPassword);
        dangXuat.setIcon(iconLogOut);

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
                label.setFont(new Font("Times New Roman", Font.BOLD, 16));
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
                    label.setFont(new Font("Times New Roman", Font.BOLD, 16));
                }
            }
        }
    }


    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                Main_GUI frame = new Main_GUI();
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

