package UI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Custom_UI.RoundedButton;
import Custom_UI.ScrollBarCustom;
import Dao.HopDong_Dao;
import Dao.NhanVien_Dao;
import Entity.HopDong;
import Entity.NhanVien;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HopDong_GUI extends JPanel {
	private JTextField txtMaHD;
	private JTextField txtTenHD;
	private JTextField txtTriGiaHD;
	private JTextField txtTienDatCoc;
	private JTextField txtTenKH;
	private JButton btnThem;
	private JButton btnLuu;
    private JButton btnXoa;
	private JButton btnCapNhat;
    private JButton btnHuy;
    private JButton btnInHD;

    private JLabel lblErrNgayKetThuc;
    private JLabel lblErrNgayKiKet;
    private JLabel lblErrTenHopDong;
    private JLabel lblErrTenKhachHang;
    private JLabel lblErrTienDatCoc;
    private JLabel lblErrTriGiaHD;

    
    private DefaultTableModel model;
    private JDateChooser dcsNgayKetThuc;
    private JDateChooser dcsNgayKyKet;
    private JTextArea txtAreaYeuCau;
	
	private JScrollPane scrHopDong;
    private JTable tblHopDong;
    
    private String stBanXacNhanXoa;
    private String stXoaThanhCong;
    private String stXoaThatBai;
    private String stThemThanhCong;
    private String stThemThatBai;
    private String stThongbao;

    
    private HopDong_Dao hopDongDao;
    private NhanVien_Dao daoNhanVien;
    private DecimalFormat dcf = new DecimalFormat("###.00");
    private NhanVien nhanVienDangNhap;
    private String fileName;
    
    private boolean isThem = false;


    public HopDong_GUI() throws ParseException, IOException {
    	setBackground(Color.WHITE);
//        this.nhanVienDangNhap = nv;
//        this.fileName = fileName;
        initComponents();
//        caiDatNgonNguChoView(fileName);
//        excute();
//        taiDuLieuLenTable();
    }

	private void initComponents() {
	    setSize(1290, 750);
	    setLayout(null);
	    
	    JLabel lblTieuDe = new JLabel("QUẢN LÝ HỢP ĐỒNG ");
	    lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 23));
	    lblTieuDe.setBounds(501, 0, 368, 50);
	    add(lblTieuDe);
	    
	    JPanel panelHD = new JPanel();
	    panelHD.setBackground(Color.WHITE);
	    panelHD.setBounds(10, 23, 1280, 355);
	    add(panelHD);
	    panelHD.setLayout(null);
	    
	    JLabel lblAnhHD = new JLabel();
	    lblAnhHD.setBounds(34, 83, 200, 173);
	    panelHD.add(lblAnhHD);
	    lblAnhHD.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/hopDong.PNG")));
	    
	    JLabel lblMaHopDong = new JLabel();
	    lblMaHopDong.setBounds(272, 35, 111, 30);
	    panelHD.add(lblMaHopDong);
	    lblMaHopDong.setText("Mã hợp đồng:");
	    lblMaHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    
	    txtMaHD = new JTextField();
	    txtMaHD.setBackground(Color.WHITE);
	    txtMaHD.setBounds(417, 21, 224, 36);
	    panelHD.add(txtMaHD);
	    txtMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtMaHD.setBorder(null);
	    
	    JSeparator jSeparator = new JSeparator();
	    jSeparator.setForeground(Color.BLACK);
	    jSeparator.setBounds(417, 57, 224, 10);
	    panelHD.add(jSeparator);
	    
	    JLabel lblTenHD = new JLabel();
	    lblTenHD.setText("Tên hợp đồng:");
	    lblTenHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenHD.setBounds(272, 100, 111, 30);
	    panelHD.add(lblTenHD);
	    
	    txtTenHD = new JTextField();
	    txtTenHD.setBackground(Color.WHITE);
	    txtTenHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenHD.setBorder(null);
	    txtTenHD.setBounds(417, 85, 224, 36);
	    panelHD.add(txtTenHD);
	    
	    JSeparator jSeparator1 = new JSeparator();
	    jSeparator1.setForeground(Color.BLACK);
	    jSeparator1.setBounds(417, 122, 224, 10);
	    panelHD.add(jSeparator1);
	    
	    JLabel lblTriGiaHD = new JLabel();
	    lblTriGiaHD.setText("Trị giá hợp đồng:");
	    lblTriGiaHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTriGiaHD.setBounds(272, 160, 135, 30);
	    panelHD.add(lblTriGiaHD);
	    
	    txtTriGiaHD = new JTextField();
	    txtTriGiaHD.setBackground(Color.WHITE);
	    txtTriGiaHD.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtTriGiaHD.setBorder(null);
	    txtTriGiaHD.setBounds(417, 149, 224, 30);
	    panelHD.add(txtTriGiaHD);
	    
	    JSeparator jSeparator2 = new JSeparator();
	    jSeparator2.setForeground(Color.BLACK);
	    jSeparator2.setBounds(417, 180, 224, 10);
	    panelHD.add(jSeparator2);
	    
	    JLabel lblTienDatCoc = new JLabel();
	    lblTienDatCoc.setText("Tiền đặt cọc:");
	    lblTienDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTienDatCoc.setBounds(272, 226, 111, 30);
	    panelHD.add(lblTienDatCoc);
	    
	    txtTienDatCoc = new JTextField();
	    txtTienDatCoc.setBackground(Color.WHITE);
	    txtTienDatCoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	    txtTienDatCoc.setBorder(null);
	    txtTienDatCoc.setBounds(417, 213, 224, 30);
	    panelHD.add(txtTienDatCoc);
	    
	    JSeparator jSeparator3 = new JSeparator();
	    jSeparator3.setForeground(Color.BLACK);
	    jSeparator3.setBounds(417, 246, 224, 10);
	    panelHD.add(jSeparator3);
	    
	    JLabel lblTenKH = new JLabel();
	    lblTenKH.setText("Tên khách hàng:");
	    lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblTenKH.setBounds(785, 35, 146, 30);
	    panelHD.add(lblTenKH);
	    
	    JLabel lblNgayBatDau = new JLabel();
	    lblNgayBatDau.setText("Ngày bắt đầu:");
	    lblNgayBatDau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblNgayBatDau.setBounds(785, 100, 170, 30);
	    panelHD.add(lblNgayBatDau);
	    
	    JLabel lblNgayKT = new JLabel();
	    lblNgayKT.setText("Ngày kết thúc:");
	    lblNgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblNgayKT.setBounds(785, 160, 110, 30);
	    panelHD.add(lblNgayKT);
	    
	    txtTenKH = new JTextField();
	    txtTenKH.setBackground(Color.WHITE);
	    txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtTenKH.setBorder(null);
	    txtTenKH.setBounds(956, 21, 224, 36);
	    panelHD.add(txtTenKH);
	    
	    JSeparator jSeparator4 = new JSeparator();
	    jSeparator4.setForeground(Color.BLACK);
	    jSeparator4.setBounds(956, 57, 224, 17);
	    panelHD.add(jSeparator4);
	    
	    dcsNgayKyKet = new JDateChooser();
	    dcsNgayKyKet.setDateFormatString("yyyy-MM-dd");
	    dcsNgayKyKet.setBounds(956, 83, 224, 36);
	    panelHD.add(dcsNgayKyKet);
	    
	    dcsNgayKetThuc = new JDateChooser();
	    dcsNgayKetThuc.setDateFormatString("yyyy-MM-dd");
	    dcsNgayKetThuc.setBounds(956, 154, 224, 36);
	    panelHD.add(dcsNgayKetThuc);
	    
	    JLabel lblErrTenKhachHang = new JLabel();
	    lblErrTenKhachHang.setText("lblErrTenKhachHang");
	    lblErrTenKhachHang.setForeground(new Color(204, 0, 0));
	    lblErrTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTenKhachHang.setBounds(956, 64, 200, 17);
	    panelHD.add(lblErrTenKhachHang);
	    
	    lblErrTriGiaHD = new JLabel();
	    lblErrTriGiaHD.setText("thông báo lỗi");
	    lblErrTriGiaHD.setForeground(new Color(204, 0, 0));
	    lblErrTriGiaHD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTriGiaHD.setBounds(417, 184, 200, 18);
	    panelHD.add(lblErrTriGiaHD);
	    
	    lblErrNgayKiKet = new JLabel();
	    lblErrNgayKiKet.setText("thông báo lỗi");
	    lblErrNgayKiKet.setForeground(new Color(204, 0, 0));
	    lblErrNgayKiKet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayKiKet.setBounds(956, 122, 200, 23);
	    panelHD.add(lblErrNgayKiKet);
	    
	    lblErrNgayKetThuc = new JLabel();
	    lblErrNgayKetThuc.setText("thông báo lỗi");
	    lblErrNgayKetThuc.setForeground(new Color(204, 0, 0));
	    lblErrNgayKetThuc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrNgayKetThuc.setBounds(956, 201, 200, 18);
	    panelHD.add(lblErrNgayKetThuc);
	    
	    JLabel lblYeuCau = new JLabel();
	    lblYeuCau.setText("Yêu cầu:");
	    lblYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    lblYeuCau.setBounds(272, 284, 135, 30);
	    panelHD.add(lblYeuCau);
	    
	    lblErrTienDatCoc = new JLabel();
	    lblErrTienDatCoc.setText("thông báo lỗi");
	    lblErrTienDatCoc.setForeground(new Color(204, 0, 0));
	    lblErrTienDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	    lblErrTienDatCoc.setBounds(417, 253, 200, 18);
	    panelHD.add(lblErrTienDatCoc);
	    
	    ScrollBarCustom scrollBar = new ScrollBarCustom();
        scrollBar.setForeground(Color.BLACK);
        
	    JScrollPane jScrollPane = new JScrollPane();
	    jScrollPane.setAutoscrolls(true);
	    jScrollPane.setBounds(417, 280, 763, 52);
	    jScrollPane.setVerticalScrollBar(scrollBar);
	    panelHD.add(jScrollPane);
	    
	    txtAreaYeuCau = new JTextArea();
	    jScrollPane.setViewportView(txtAreaYeuCau);
	    txtAreaYeuCau.setBackground(Color.WHITE);
	    txtAreaYeuCau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    txtAreaYeuCau.setRows(5);
	    txtAreaYeuCau.setColumns(20);
	    
	    JPanel panelButton = new JPanel();
	    panelButton.setBackground(Color.WHITE);
	    panelButton.setBounds(10, 376, 1280, 65);
	    add(panelButton);
	    panelButton.setLayout(null);

	    // Tạo một RoundedButton thay vì JButton
	    btnThem = new RoundedButton("Thêm", SystemColor.inactiveCaption, null);
	    btnThem.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/them.png")));
	    btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnThem.setBounds(10, 14, 170, 40);
	    btnThem.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            btnThemActionPerformed(evt);
	        }
	    });
	    panelButton.add(btnThem);


	    // Tạo và thêm nút Xóa
	    btnXoa = new RoundedButton("Xóa", new Color(222, 184, 135), null);
	    btnXoa.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/xoa.png")));
	    btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnXoa.setBounds(219, 14, 170, 40);
	    btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnXoaActionPerformed(evt);
            }
        });
	    panelButton.add(btnXoa);

	    // Tạo và thêm nút Cập nhật
	    btnCapNhat = new RoundedButton("Cập nhật", new Color(255, 218, 185), null);
	    btnCapNhat.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/capNhat.png")));
	    btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnCapNhat.setBounds(439, 14, 170, 40);
	    btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnCapNhatActionPerformed(evt);
            }
        });
	    panelButton.add(btnCapNhat);

	    // Tạo và thêm nút Lưu
	    btnLuu = new RoundedButton("Lưu", new Color(192, 192, 192), null);
	    btnLuu.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/luu.png")));
	    btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnLuu.setBounds(877, 14, 170, 40);
	    btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
	    panelButton.add(btnLuu);

	    // Tạo và thêm nút Hủy
	    btnHuy = new RoundedButton("Hủy", new Color(255, 222, 173), null);
	    btnHuy.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/huy.png")));
	    btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    btnHuy.setBounds(1100, 14, 170, 40);
	    btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
	    panelButton.add(btnHuy);
	    
	    	    // Tạo và thêm nút In hợp đồng
	    	    btnInHD = new RoundedButton("In hợp đồng", new Color(211, 211, 211), null);
	    	    btnInHD.setBounds(670, 14, 150, 40);
	    	    panelButton.add(btnInHD);
	    	    btnInHD.setIcon(new ImageIcon(HopDong_GUI.class.getResource("/image/icon/in.png")));
	    	    btnInHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    
	    tblHopDong = new JTable();
	    tblHopDong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    tblHopDong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
	    
	    tblHopDong.setRowHeight(30);

	    tblHopDong.setModel(new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    		{null, null, null, null, null, null, null, null, null},
	    	},
	    	new String[] {
    				"STT", "Mã hợp đồng", "Tên hợp đồng", "Tên khách hàng", "Trị giá hợp đồng", "Tiền đặt cọc", "Ngày bắt đầu", "Ngày kết thúc","Mã người ký kết"
    		}
	    )); 
	    

	    scrHopDong = new JScrollPane(tblHopDong);
	    scrHopDong.setBounds(39, 523, 1225, 194);
	    add(scrHopDong);
	    
        ScrollBarCustom scrollBar1 = new ScrollBarCustom();
        scrollBar1.setForeground(Color.RED);

        // Chèn ScrollBarCustom vào JScrollPane
        scrHopDong.setVerticalScrollBar(scrollBar1);
	    
	    JLabel lblDsHD = new JLabel("Danh sách hợp đồng:");
	    lblDsHD.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblDsHD.setBounds(39, 475, 243, 37);
	    add(lblDsHD);

	}
	
	public void setShow(JButton... btn) {
        for (JButton jButton : btn) {
            jButton.setEnabled(true);
        }
    }

    public void setHidden(JButton... btn) {
        for (JButton jButton : btn) {
            jButton.setEnabled(false);
        }
    }
    
    public void hienThiDuLieuLenTxt(int dong) throws ParseException {
        hopDongDao = new HopDong_Dao();
        HopDong hd = hopDongDao.layRaMotHopDongTheoMaHopDong(tblHopDong.getValueAt(dong, 1).toString());

        txtMaHD.setText(tblHopDong.getValueAt(dong, 1).toString());
        txtTenHD.setText(tblHopDong.getValueAt(dong, 2).toString());
        txtTenKH.setText(tblHopDong.getValueAt(dong, 3).toString());
        txtTienDatCoc.setText(tblHopDong.getValueAt(dong, 4).toString().split(" ")[0].replaceAll("\\,", "."));
        txtTriGiaHD.setText(tblHopDong.getValueAt(dong, 5).toString().split(" ")[0].replaceAll("\\,", "."));
        dcsNgayKyKet.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblHopDong.getValueAt(dong, 6).toString()));
        dcsNgayKetThuc.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblHopDong.getValueAt(dong, 7).toString()));
        txtAreaYeuCau.setText(hd.getYeuCau());
        setEnableForSelected(false);

    }
    
    public void setEnableForSelected(boolean check) {
        txtMaHD.setEditable(false);
        txtTenHD.setEditable(check);
        txtTenKH.setEditable(check);
        txtTienDatCoc.setEditable(check);
        txtTriGiaHD.setEditable(check);
        dcsNgayKyKet.setEnabled(check);
        dcsNgayKetThuc.setEnabled(check);
        txtAreaYeuCau.setEditable(check);
    }
    
    public void taiDuLieuLenTable() throws ParseException {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        hopDongDao = new HopDong_Dao();
        ArrayList<HopDong> hopDongList = hopDongDao.layDanhSachHopDong();
        if (hopDongList != null) {
            hopDongList.forEach(e -> {
                model.addRow(new Object[]{model.getRowCount() + 1, e.getMaHopDong(), e.getTenHopDong(), e.getTenKhachHang(), dcf.format(e.getTienDatCoc()).replaceAll("\\,", "."), dcf.format(e.getTriGiaHD()).replaceAll("\\,", "."), e.getNgayKyKetHD(), e.getNgayKetThucHD()});
            });
        }
        if (tblHopDong.getRowCount() != 0) {
            tblHopDong.setRowSelectionInterval(0, 0);
            hienThiDuLieuLenTxt(0);
        }
    }
    
    public void xoaTrangTextField() {
        txtMaHD.setText("");
        txtTenHD.setText("");
        txtTenKH.setText("");
        txtTriGiaHD.setText("");
        txtTienDatCoc.setText("");
        dcsNgayKyKet.setDate(new Date());
        dcsNgayKetThuc.setDate(new Date());
        txtAreaYeuCau.setText("");
        txtTenHD.requestFocus();
    }
    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
        if (isThem) {
            String maHopDong = txtMaHD.getText().trim();
            String tenHopDong = txtTenHD.getText().trim();
            String tenKhachHang = txtTenHD.getText().trim();
            double tienDatCoc = 0, triGiaHD = 0;
            try {
                tienDatCoc = Double.parseDouble(txtTienDatCoc.getText().trim());
                triGiaHD = Double.parseDouble(txtTriGiaHD.getText().trim());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Date ngayKyKet = dcsNgayKyKet.getDate();
            Date ngayKetThuc = dcsNgayKetThuc.getDate();
            String yeuCau = txtAreaYeuCau.getText().trim();
            daoNhanVien = new NhanVien_Dao();
            boolean isThemDuoc = hopDongDao.themMotHopDong(new HopDong(maHopDong, tenHopDong, tenKhachHang, tienDatCoc, triGiaHD, ngayKyKet, ngayKetThuc, yeuCau,daoNhanVien.layMotNhanVienTheoMaNhanVien(maHopDong)));
            if (isThemDuoc) {
                JOptionPane.showMessageDialog(null, stThemThanhCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
                try {
                    taiDuLieuLenTable();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                setEnableForSelected(false);
                setShow(btnThem, btnCapNhat, btnXoa);
                setHidden(btnLuu, btnHuy);
                isThem = false;
            } else {
                JOptionPane.showMessageDialog(null, stThemThatBai, stThongbao, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void setEditTextDateChooser() {
        JTextFieldDateEditor ngaySinh = (JTextFieldDateEditor) dcsNgayKetThuc.getDateEditor();
        JTextFieldDateEditor ngayVaoLam = (JTextFieldDateEditor) dcsNgayKyKet.getDateEditor();
        ngaySinh.setEnabled(false);
        ngayVaoLam.setEnabled(false);
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        setShow(btnHuy, btnLuu);
        setHidden(btnThem, btnXoa, btnCapNhat,btnInHD);

        this.isThem = true;
        xoaTrangTextField();
        setEnableForSelected(true);
        if (tblHopDong.getRowHeight() > 0) {
            txtMaHD.setText("HD" + (Integer.parseInt(tblHopDong.getValueAt(tblHopDong.getRowCount() - 1, 1).toString().split("D")[1]) + 1));
        } else {
            txtMaHD.setText("HD100001");
        }
        setEditTextDateChooser();
    }
    
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        setShow(btnThem, btnXoa, btnCapNhat);
        setHidden(btnHuy, btnLuu);
        isThem = false;
        setEnableForSelected(false);
        lblErrNgayKetThuc.setText("");
        lblErrNgayKiKet.setText("");
        lblErrTenHopDong.setText("");
        lblErrTenKhachHang.setText("");
        lblErrTienDatCoc.setText("");
        lblErrTriGiaHD.setText("");
        if (tblHopDong.getRowCount() != 0) {
            try {
                hienThiDuLieuLenTxt(tblHopDong.getSelectedRow());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        setEditTextDateChooser();
    }
}
