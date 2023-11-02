package UI;


import Entity.ChamCongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author December
 */
public class testPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel modelNhanVien;
    private DefaultTableModel modelChamCong;
//    private NhanVien_DAO daoNhanVien;
//    private NhanVien entityNhanVien;
//    private ChamCongNhanVien_DAO daoChamCong;
//    private ChamCongNhanVien entityChamCongNhanVien;
//    private PhongBan entityPhongBan;
//    private PhongBan_DAO daoPhongBan;
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

    public testPanel(NhanVien nhanVien, String fileName) throws ParseException, Exception {
        nhanvienDangNhap = nhanVien;
        ConnectionDB.ConnectDB.getInstance().connect();
        initComponents();
//        excute();
//        taiDuLieuLenBangNhanVien();
        while (modelChamCong.getRowCount() != 0) {
            modelChamCong.removeRow(0);
        }
        dcsNgayChamCong.setDate(new Date());
        btnChamCongTatCa.setEnabled(false);
        cmbCaLam.setSelectedIndex(0);
        caiDatNgonNguChoView(fileName);
        btnChamCong.setEnabled(false);
        setEditTextDateChooser();

    }

    public void setEditTextDateChooser() {
        JTextFieldDateEditor ngaySinh = (JTextFieldDateEditor) dcsNgayChamCong.getDateEditor();
        ngaySinh.setEnabled(false);

    }

    public void caiDatNgonNguChoView(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        btnCapNhat.setText(prop.getProperty("btnCapNhat"));
        btnLuu.setText(prop.getProperty("btnLuu"));
        btnHuy.setText(prop.getProperty("btnHuy"));
        btnLayDanhSach.setText(prop.getProperty("chamCong_layDanhSachChamCong"));
        btnChamCongTatCa.setText(prop.getProperty("chamCong_btnChamCongTatCa"));
        btnChamCong.setText(prop.getProperty("chamCong_btnChamCong"));
        scrChamCong.setBorder(new TitledBorder(prop.getProperty("chamCong_tieuDeChamCong")));
        scrNhanVien.setBorder(new TitledBorder(prop.getProperty("chamCong_tieuDeDanhSachNhanVien")));

        lblNgayChamCong.setText(prop.getProperty("chamCong_NgayChamCong"));
        lblCaLam.setText(prop.getProperty("chamCong_CaLam"));
        lblMaNhanVien.setText(prop.getProperty("chamCong_maNhanVien"));
        lblHoVaTen.setText(prop.getProperty("chamCong_hoTen"));
        lblTrangThai.setText(prop.getProperty("chamCong_trangThai"));
        lblGioDilam.setText(prop.getProperty("chamCong_gio"));
        lblPhut.setText(prop.getProperty("chamCong_phut"));
        lblHIenThi.setText(prop.getProperty("chamCong_hienThi"));

        ChangeName(tblChamCong, 0, prop.getProperty("chamCong_stt"));
        ChangeName(tblChamCong, 1, lblMaNhanVien.getText());
        ChangeName(tblChamCong, 2, lblHoVaTen.getText());
        ChangeName(tblChamCong, 3, prop.getProperty("chamCong_sdt"));
        ChangeName(tblChamCong, 4, prop.getProperty("chamCong_phongBan"));
        ChangeName(tblChamCong, 5, prop.getProperty("chamCong_chucVu"));

        ChangeName(tblNhanVien, 0, prop.getProperty("chamCong_stt"));
        ChangeName(tblNhanVien, 1, prop.getProperty("chamCong_maNhanVienChamCong"));
        ChangeName(tblNhanVien, 2, lblMaNhanVien.getText());
        ChangeName(tblNhanVien, 3, lblHoVaTen.getText());
        ChangeName(tblNhanVien, 4, prop.getProperty("chamCong_sdt"));
        ChangeName(tblNhanVien, 5, prop.getProperty("chamCong_phongBan"));
        ChangeName(tblNhanVien, 6, prop.getProperty("chamCong_chucVu"));
        ChangeName(tblNhanVien, 7, lblNgayChamCong.getText());
        ChangeName(tblNhanVien, 8, lblCaLam.getText());
        ChangeName(tblNhanVien, 9, lblTrangThai.getText());
        ChangeName(tblNhanVien, 10, lblGioDilam.getText());
        cmbHienThi.removeAllItems();
        cmbHienThi.addItem(prop.getProperty("cmbHienThiAll"));
        cmbHienThi.addItem(prop.getProperty("cmbHienThiLoc"));

        stChamCongThanhCong = prop.getProperty("chamCong_chamCongThanhCong");
        stErrNgayChamCong = prop.getProperty("chamCong_errNgayChamCong");

        stThongbao = prop.getProperty("thongBao");
        stBanXacNhanXoa = prop.getProperty("banXacNhanXoa");
        stXoaThanhCong = prop.getProperty("xoaThanhCong");
        stXoaThatBai = prop.getProperty("xoaThatBai");
        stThemThanhCong = prop.getProperty("themThanhCong");
        stThemThatBai = prop.getProperty("themThatBai");
        stTren = prop.getProperty("tren");
        stSanPham = prop.getProperty("sp_SanPham");
        stKhongDocDuocFile = prop.getProperty("khongDocDuocFile");
        stKhongTimThayFile = prop.getProperty("khongTimThayFile");
        stCapNhatThanhCong = prop.getProperty("capNhatThanhCong");
        stCapNhatThatBai = prop.getProperty("capNhatThatBai");
        stChonMauSacChoSanPham = prop.getProperty("sp_chonMauSacChoSanPham");
        stErrSoLuong = prop.getProperty("sp_lblErrSoLuong");
        stErrKhongDeTrong = prop.getProperty("KhongDeTrong");
        stErrHoTen = prop.getProperty("hoTenKhongHopLe");
        stErrSoCCCD = prop.getProperty("soCCCDKhongHopLe");
        stErrEmail = prop.getProperty("emailKhongHopLe");
        stErrSdt = prop.getProperty("sdtKhongHopLe");
        stErrNgaySinh = prop.getProperty("ngaySinhKhongHopLe");
        stErrNgayVaoLam = prop.getProperty("ngayVaoLamKhongHopLe");
        stErrNhanVienKhongDuTuoi = prop.getProperty("nhanVienChuaDuTuoi");
        stErrTienKhongHopLe = prop.getProperty("soTienKhongHople");
        stSoTienLonHonKhong = prop.getProperty("soTienLonHonKhong");
        stNgayThangKhongHople = prop.getProperty("ngayThangKhongHopLe");
    }

    public void ChangeName(JTable table, int col_index, String col_name) {
        table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }

//    public void excute() throws ParseException {
//        tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        tblNhanVien.getTableHeader().setOpaque(false);
//        ((DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        tblNhanVien.setRowHeight(25);
//
//        tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        tblNhanVien.getTableHeader().setOpaque(false);
//        ((DefaultTableCellRenderer) tblNhanVien.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        tblNhanVien.setRowHeight(25);
//
//        tblChamCong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        tblChamCong.getTableHeader().setOpaque(false);
//        ((DefaultTableCellRenderer) tblChamCong.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        tblChamCong.setRowHeight(25);
//
//        tblChamCong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        tblChamCong.getTableHeader().setOpaque(false);
//        ((DefaultTableCellRenderer) tblChamCong.getTableHeader().getDefaultRenderer())
//                .setHorizontalAlignment(JLabel.CENTER);
//        tblChamCong.setRowHeight(25);
//        modelNhanVien = (DefaultTableModel) tblNhanVien.getModel();
//        modelChamCong = (DefaultTableModel) tblChamCong.getModel();
//        setHidden(btnLuu, btnHuy, btnChamCong);
//        setShow(btnCapNhat);
//    }
//
//    public void taiDuLieuLenBangNhanVien() throws ParseException {
//        while (modelNhanVien.getRowCount() != 0) {
//            modelNhanVien.removeRow(0);
//        }
//        daoChamCong = new ChamCongNhanVien_DAO();
//        ArrayList<ChamCongNhanVien> listChamCong = daoChamCong.danhSachChamCongNhanVien();
//        if (listChamCong != null) {
//            for (ChamCongNhanVien chamCong : listChamCong) {
//                String data[] = {(modelNhanVien.getRowCount() + 1) + "", chamCong.getNguoiChamCong().getMaNhanVien(),
//                    chamCong.getNhanVien().getMaNhanVien(), chamCong.getNhanVien().getHoTen(), chamCong.getNhanVien().getSoDienThoai(),
//                    chamCong.getNhanVien().getPhongBan().getTenPhongBan(), chamCong.getNhanVien().getChucVu(), chamCong.getNgayChamCong().toString(),
//                    chamCong.getCaLam(), chamCong.getTrangThaiDiLam(), chamCong.getGioDiLam()};
//                modelNhanVien.addRow(data);
//            }
//            if (tblNhanVien.getRowCount() > 0) {
//                tblNhanVien.setRowSelectionInterval(0, 0);
//                hienThiDuLieuLenTxtBangNhanVien(0);
//                setEditInput(false);
//            }
//        }
//        setEditInput(false);
//    }

//    public void taiDuLieuLenBangChamCongEvt() {
//        daoChamCong = new ChamCongNhanVien_DAO();
//        daoNhanVien = new NhanVien_DAO();
//        ArrayList<ChamCongNhanVien> listChamCong = daoChamCong.danhSachChamCongNhanVien();
//        listNhanVien = daoNhanVien.layDanhSachNhanVien();
//        ArrayList<NhanVien> listTemp1 = new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = formatter.format(dcsNgayChamCong.getDate());
//        listChamCong.forEach(e -> {
//            if (e.getCaLam().equalsIgnoreCase(cmbCaLam.getSelectedItem().toString()) && strDate.equalsIgnoreCase(e.getNgayChamCong().toString())) {
//                listTemp1.add(e.getNhanVien());
//            }
//        });
//        listNhanVienForEvtChamCongTatCa = new ArrayList<>();
//        listNhanVien.forEach(e -> {
//            boolean flag = false;
//            if (e.getNgayVaoLam().after(dcsNgayChamCong.getDate())) {
//                System.out.println(e.getMaNhanVien() + "Nhan vien nay chua du dk de cham cong");
//            } else {
//                for (NhanVien nhanVien : listTemp1) {
//                    if (nhanVien.getMaNhanVien().equalsIgnoreCase(e.getMaNhanVien())) {
//                        flag = true;
//                    }
//                }
//                if (!flag) {
//                    listNhanVienForEvtChamCongTatCa.add(e);
//                    String data[] = {(modelChamCong.getRowCount() + 1) + "", e.getMaNhanVien(), e.getHoTen(), e.getSoDienThoai(), e.getPhongBan().getTenPhongBan(), e.getChucVu()};
//                    modelChamCong.addRow(data);
//                }
//            }
//        });
//    }

//    public void taiDuLieuLenBangChamCong() throws ParseException, InterruptedException {
//        while (modelChamCong.getRowCount() != 0) {
//            modelChamCong.removeRow(0);
//        }
//        taiDuLieuLenBangChamCongEvt();
//        if (tblNhanVien.getRowCount() != 0) {
//            tblNhanVien.setRowSelectionInterval(0, 0);
//        }
//        if (modelChamCong.getRowCount() > 0) {
//            tblChamCong.setRowSelectionInterval(0, 0);
//            hienThiDuLieuLenTxtBangNhanVien(0);
//            setEditInput(false);
//            btnChamCong.setEnabled(false);
//        } else {
//            btnChamCong.setEnabled(false);
//        }
//    }
//
//    public void setComBoBoxToSunDay() {
//        cmbCaLam.removeAllItems();
//        cmbCaLam.addItem("Sáng chủ nhật");
//        cmbCaLam.addItem("Chiều chủ nhật");
//    }
//
//    public void setComBoBoxToReset() {
//        cmbCaLam.removeAllItems();
//        cmbCaLam.addItem("Sáng");
//        cmbCaLam.addItem("Chiều");
//        cmbCaLam.addItem("Đêm");
//    }
//
//    public void hienThiDuLieuLenTxtBangNhanVien(int dong) throws ParseException {
//        if (modelNhanVien.getRowCount() > 0) {
//            lblValueMaNhanVien.setText(tblNhanVien.getValueAt(dong, 2).toString());
//            lblValueHoVaTen.setText(tblNhanVien.getValueAt(dong, 3).toString());
//            cmbTrangThai.setSelectedItem(tblNhanVien.getValueAt(dong, 9).toString());
//            if (cmbTrangThai.getSelectedIndex() != 2 && cmbTrangThai.getSelectedIndex() != 3) {
//                cmbGio.setSelectedItem(tblNhanVien.getValueAt(dong, 10).toString().split("h")[0]);
//                cmbPhut.setSelectedItem(tblNhanVien.getValueAt(dong, 10).toString().split("h")[1]);
//                cmbGio.setEditable(true);
//                cmbPhut.setEditable(true);
//            } else {
//                cmbGio.setEditable(true);
//                cmbPhut.setEditable(true);
//            }
//        }
//    }
//
//    public void hienThiDuLieuLenTxtBangChamCong(int dong) throws ParseException {
//        lblValueMaNhanVien.setText(tblChamCong.getValueAt(dong, 1).toString());
//        lblValueHoVaTen.setText(tblChamCong.getValueAt(dong, 2).toString());
//    }
//
//    public void setHidden(JButton... btn) {
//        for (JButton jButton : btn) {
//            jButton.setEnabled(false);
//        }
//    }
//
//    public void setShow(JButton... btn) {
//        for (JButton jButton : btn) {
//            jButton.setEnabled(true);
//        }
//    }
//
//    public void setEditInput(boolean check) {
//        cmbTrangThai.setEnabled(check);
//        cmbGio.setEnabled(check);
//        cmbPhut.setEnabled(check);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrNhanVien = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        dcsNgayChamCong = new com.toedter.calendar.JDateChooser();
        scrChamCong = new javax.swing.JScrollPane();
        tblChamCong = new javax.swing.JTable();
        lblNgayChamCong = new javax.swing.JLabel();
        lblGioDilam = new javax.swing.JLabel();
        lblValueMaNhanVien = new javax.swing.JLabel();
        lblValueHoVaTen = new javax.swing.JLabel();
        lblMaNhanVien = new javax.swing.JLabel();
        lblHoVaTen = new javax.swing.JLabel();
        cmbTrangThai = new javax.swing.JComboBox<>();
        lblTrangThai = new javax.swing.JLabel();
        lblCaLam = new javax.swing.JLabel();
        cmbGio = new javax.swing.JComboBox<>();
        cmbCaLam = new javax.swing.JComboBox<>();
        btnLayDanhSach = new javax.swing.JButton();
        lblPhut = new javax.swing.JLabel();
        cmbPhut = new javax.swing.JComboBox<>();
        btnChamCongTatCa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblHIenThi = new javax.swing.JLabel();
        cmbHienThi = new javax.swing.JComboBox<>();
        btnChamCong = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        scrNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        scrNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã người chấm", "Mã nhân viên", "Họ và tên", "Sđt", "Phòng ban", "Chức vụ", "Ngày chấm công", "Ca làm", "Trạng thái", "Giờ đi làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	//tblNhanVienMouseClicked(evt);
            }
        });
        scrNhanVien.setViewportView(tblNhanVien);

        add(scrNhanVien, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1250, 400));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dcsNgayChamCong.setDateFormatString("yyyy-MM-dd");
        dcsNgayChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //dcsNgayChamCongMouseClicked(evt);
            }
        });
        dcsNgayChamCong.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
               //dcsNgayChamCongPropertyChange(evt);
            }
        });
        jPanel5.add(dcsNgayChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 160, 40));

        scrChamCong.setBackground(new java.awt.Color(255, 255, 255));
        scrChamCong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên cần chấm công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        scrChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //scrChamCongMouseClicked(evt);
            }
        });

        tblChamCong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblChamCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ và tên", "Sđt", "Phòng ban", "Chức vụ"
            }
        ));
        tblChamCong.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblChamCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //tblChamCongMouseClicked(evt);
            }
        });
        scrChamCong.setViewportView(tblChamCong);

        jPanel5.add(scrChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 810, 210));

        lblNgayChamCong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNgayChamCong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayChamCong.setText("Ngày chấm công:");
        jPanel5.add(lblNgayChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 150, 40));

        lblGioDilam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblGioDilam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGioDilam.setText("Giờ đi làm:");
        jPanel5.add(lblGioDilam, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 120, 40));

        lblValueMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblValueMaNhanVien.setText("NV001");
        jPanel5.add(lblValueMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, 240, 40));

        lblValueHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblValueHoVaTen.setText("Nguyễn Văn A");
        jPanel5.add(lblValueHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 240, 40));

        lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMaNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaNhanVien.setText("Mã nhân viên:");
        jPanel5.add(lblMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 140, 40));

        lblHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHoVaTen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHoVaTen.setText("Họ và tên:");
        jPanel5.add(lblHoVaTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 140, 40));

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi Làm", "Đi Trễ", "Nghỉ Có Phép", "Nghỉ Không Phép" }));
        cmbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //cmbTrangThaiActionPerformed(evt);
            }
        });
        jPanel5.add(cmbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 200, 40));

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai.setText("Trạng thái:");
        jPanel5.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 130, 40));

        lblCaLam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCaLam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCaLam.setText("Ca làm:");
        jPanel5.add(lblCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 90, 40));

        cmbGio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "1", "2", "3", "4", "5", "6" }));
        jPanel5.add(cmbGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 60, 40));

        cmbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng ", "Chiều", "Đêm" }));
        cmbCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbCaLamActionPerformed(evt);
            }
        });
        jPanel5.add(cmbCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 130, 40));

        btnLayDanhSach.setBackground(new java.awt.Color(46, 204, 113));
        btnLayDanhSach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLayDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
        btnLayDanhSach.setText("Lấy danh sách");
        btnLayDanhSach.setBorder(null);
        btnLayDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnLayDanhSachActionPerformed(evt);
            }
        });
        jPanel5.add(btnLayDanhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 210, 40));

        lblPhut.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPhut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhut.setText("Phút:");
        jPanel5.add(lblPhut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 220, 50, 40));

        cmbPhut.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cmbPhut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        jPanel5.add(cmbPhut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 60, 40));

        btnChamCongTatCa.setBackground(new java.awt.Color(46, 204, 113));
        btnChamCongTatCa.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnChamCongTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
        btnChamCongTatCa.setText("Chấm công tất cả");
        btnChamCongTatCa.setBorder(null);
        btnChamCongTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnChamCongTatCaActionPerformed(evt);
            }
        });
        jPanel5.add(btnChamCongTatCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 160, 40));

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/update.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnCapNhatActionPerformed(evt);
            }
        });
        jPanel5.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 160, 40));

        btnLuu.setBackground(new java.awt.Color(156, 136, 255));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/save.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnLuuActionPerformed(evt);
            }
        });
        jPanel5.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 160, 40));

        btnHuy.setBackground(new java.awt.Color(255, 121, 121));
        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/xoaTrang.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setBorder(null);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnHuyActionPerformed(evt);
            }
        });
        jPanel5.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 170, 40));

        lblHIenThi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHIenThi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHIenThi.setText("Hiển thị");
        jPanel5.add(lblHIenThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 80, 40));

        cmbHienThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Theo ngày chấm công" }));
        cmbHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //cmbHienThiActionPerformed(evt);
            }
        });
        jPanel5.add(cmbHienThi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 130, 40));

        btnChamCong.setBackground(new java.awt.Color(46, 204, 113));
        btnChamCong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnChamCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/add.png"))); // NOI18N
        btnChamCong.setText("Chấm công");
        btnChamCong.setBorder(null);
        btnChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //btnChamCongActionPerformed(evt);
            }
        });
        jPanel5.add(btnChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 140, 40));

        add(jPanel5, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

//    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
//        try {
//            String ngayCham = tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 7).toString();
//            capNhatCmbGio();
//            hienThiDuLieuLenTxtBangNhanVien(tblNhanVien.getSelectedRow());
//            setEditInput(false);
//            setShow(btnCapNhat);
//            setHidden(btnHuy, btnLuu, btnChamCong);
//            checkChamCong = false;
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(null, "ERRO, please reset (T_T)(T_T)");
//        }
//        if (tblChamCong.getSelectedRow() != -1) {
//            tblChamCong.removeRowSelectionInterval(tblChamCong.getSelectedRow(), 0);
//        }
//    }//GEN-LAST:event_tblNhanVienMouseClicked
//
//    public void change() {
//        if (cmbHienThi.getSelectedIndex() == 1) {
//            daoChamCong = new ChamCongNhanVien_DAO();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String strDate = formatter.format(dcsNgayChamCong.getDate());
//            ArrayList<ChamCongNhanVien> listChamCong = daoChamCong.layDanhSachCHamCongTheoNgay(strDate);
//            while (modelNhanVien.getRowCount() != 0) {
//                modelNhanVien.removeRow(0);
//            }
//            daoChamCong = new ChamCongNhanVien_DAO();
//            if (daoChamCong != null) {
//                for (ChamCongNhanVien chamCong : listChamCong) {
//                    String data[] = {(modelNhanVien.getRowCount() + 1) + "", chamCong.getNguoiChamCong().getMaNhanVien(),
//                        chamCong.getNhanVien().getMaNhanVien(), chamCong.getNhanVien().getHoTen(), chamCong.getNhanVien().getSoDienThoai(),
//                        chamCong.getNhanVien().getPhongBan().getTenPhongBan(), chamCong.getNhanVien().getChucVu(), chamCong.getNgayChamCong().toString(),
//                        chamCong.getCaLam(), chamCong.getTrangThaiDiLam(), chamCong.getGioDiLam()};
//                    modelNhanVien.addRow(data);
//                }
//                if (tblNhanVien.getRowCount() > 0) {
//                    tblNhanVien.setRowSelectionInterval(0, 0);
//                    try {
//                        hienThiDuLieuLenTxtBangNhanVien(0);
//                    } catch (ParseException ex) {
//                        Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        } else {
//            try {
//                taiDuLieuLenBangNhanVien();
//            } catch (ParseException ex) {
//                Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    private void cmbHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHienThiActionPerformed
//        change();
//    }//GEN-LAST:event_cmbHienThiActionPerformed
//
//    private void tblChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChamCongMouseClicked
//        try {
//            capNhatCmbGio();
//            hienThiDuLieuLenTxtBangChamCong(tblChamCong.getSelectedRow());
//            setEditInput(false);
//            setHidden(btnHuy, btnLuu, btnCapNhat);
//            setShow(btnChamCong, btnChamCongTatCa);
//            checkChamCong = false;
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(null, "ERRO, please reset (T_T)(T_T)");
//        }
//        if (tblNhanVien.getSelectedRow() != -1) {
//            tblNhanVien.removeRowSelectionInterval(tblNhanVien.getSelectedRow(), 0);
//        }
//    }//GEN-LAST:event_tblChamCongMouseClicked
//    private void btnLayDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayDanhSachActionPerformed
//
//        try {
//            if (dcsNgayChamCong.getDate().after(new Date())) {
//                JOptionPane.showMessageDialog(null, stErrNgayChamCong, stThongbao, JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//            try {
//                taiDuLieuLenBangChamCong();
//            } catch (ParseException ex) {
//                Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (tblChamCong.getRowCount() != 0) {
//                setShow(btnChamCongTatCa);
//            } else {
//                setHidden(btnChamCong, btnChamCongTatCa);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, stNgayThangKhongHople, stThongbao, JOptionPane.ERROR_MESSAGE);
//        }
//    }//GEN-LAST:event_btnLayDanhSachActionPerformed
//
//    private void dcsNgayChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcsNgayChamCongMouseClicked
//    }//GEN-LAST:event_dcsNgayChamCongMouseClicked
//
//    private void dcsNgayChamCongPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcsNgayChamCongPropertyChange
//        if ("date".equals(evt.getPropertyName())) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(dcsNgayChamCong.getDate());
//            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
//                setComBoBoxToSunDay();
//            } else {
//                setComBoBoxToReset();
//            }
//        }
//        btnChamCong.setEnabled(false);
//        change();
//        while (modelChamCong.getRowCount() > 0) {
//            modelChamCong.removeRow(0);
//        }
//
//    }//GEN-LAST:event_dcsNgayChamCongPropertyChange
//
//    private void btnChamCongTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongTatCaActionPerformed
//        daoChamCong = new ChamCongNhanVien_DAO();
//        String gio = "";
////        NhanVien nhanVienChamCong = daoNhanVien.layMotNhanVienTheoMaNhanVien("NV100001");
//        if (cmbCaLam.getSelectedIndex() == 0) {
//            gio = "6h00";
//        } else if (cmbCaLam.getSelectedIndex() == 1) {
//            gio = "14h00";
//        } else {
//            gio = "22h00";
//        }
//        cmbTrangThai.setSelectedIndex(0);
//        taiDuLieuLenBangChamCongEvt();
//        for (NhanVien nhanVien : listNhanVienForEvtChamCongTatCa) {
//            ChamCongNhanVien chamCong = new ChamCongNhanVien(nhanVien, dcsNgayChamCong.getDate(), cmbCaLam.getSelectedItem().toString(), cmbTrangThai.getSelectedItem().toString(),
//                    gio, nhanvienDangNhap);
//            daoChamCong.themMotChamCongNhanVien(chamCong);
//        }
//        btnChamCongTatCa.setEnabled(false);
//        //            taiDuLieuLenBangNhanVien();
//        change();
//        while (modelChamCong.getRowCount() != 0) {
//            modelChamCong.removeRow(0);
//        }
//        btnChamCong.setEnabled(false);
//        JOptionPane.showMessageDialog(null, stChamCongThanhCong);
//    }//GEN-LAST:event_btnChamCongTatCaActionPerformed
//    public void thayDouCmbBox() {
//        if (cmbTrangThai.getSelectedIndex() == 0 || cmbTrangThai.getSelectedIndex() == 2 || cmbTrangThai.getSelectedIndex() == 3) {
//            cmbGio.setEnabled(false);
//            cmbPhut.setEnabled(false);
//        } else {
//            cmbGio.setEnabled(true);
//            cmbPhut.setEnabled(true);
//            cmbGio.setEditable(false);
//            cmbPhut.setEditable(false);
//        }
//    }
//    private void cmbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTrangThaiActionPerformed
//        thayDouCmbBox();
//    }//GEN-LAST:event_cmbTrangThaiActionPerformed
//
//    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
//        setHidden(btnCapNhat, btnChamCong, btnChamCongTatCa);
//        setShow(btnHuy, btnLuu);
//        setEditInput(true);
//        thayDouCmbBox();
//    }//GEN-LAST:event_btnCapNhatActionPerformed
//
//    private void scrChamCongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrChamCongMouseClicked
//    }//GEN-LAST:event_scrChamCongMouseClicked
//    public void capNhatCmbGio() {
//        cmbGio.removeAllItems();
//        if (cmbCaLam.getSelectedIndex() == 0) {
//            for (int i = 6; i < 14; i++) {
//                cmbGio.addItem(i + "");
//            }
//        } else if (cmbCaLam.getSelectedIndex() == 1) {
//            for (int i = 14; i < 22; i++) {
//                cmbGio.addItem(i + "");
//            }
//        } else {
//            for (int i = 22; i <= 24; i++) {
//                cmbGio.addItem(i + "");
//            }
//            for (int i = 0; i < 6; i++) {
//                cmbGio.addItem(i + "");
//            }
//        }
//    }
//    private void cmbCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCaLamActionPerformed
//        capNhatCmbGio();
//        setHidden(btnHuy, btnLuu, btnChamCongTatCa, btnChamCong, btnCapNhat);
////        setShow(btnCapNhat);
//        setEditInput(false);
//        btnChamCong.setEnabled(false);
//        change();
//        while (modelChamCong.getRowCount() > 0) {
//            modelChamCong.removeRow(0);
//        }
//    }//GEN-LAST:event_cmbCaLamActionPerformed
//    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
//        String gioLam = "";
//        if (cmbTrangThai.getSelectedIndex() == 0) {
//            gioLam = cmbGio.getSelectedItem().toString() + "h" + cmbPhut.getSelectedItem();
//        } else if (cmbGio.isEnabled()) {
//            gioLam = cmbGio.getSelectedItem().toString() + "h" + cmbPhut.getSelectedItem();
//        } else {
//            gioLam = "";
//        }
//        daoChamCong = new ChamCongNhanVien_DAO();
//        daoNhanVien = new NhanVien_DAO();
//        NhanVien nhanVienDuocChamCong = daoNhanVien.layMotNhanVienTheoMaNhanVien(lblValueMaNhanVien.getText());
//        if (checkChamCong) {
//            ChamCongNhanVien chamcong = new ChamCongNhanVien(nhanVienDuocChamCong, dcsNgayChamCong.getDate(),
//                    cmbCaLam.getSelectedItem().toString(), cmbTrangThai.getSelectedItem().toString(), gioLam, nhanvienDangNhap);
//            if (daoChamCong.themMotChamCongNhanVien(chamcong)) {
//                try {
//                    JOptionPane.showMessageDialog(null, stChamCongThanhCong);
//                    taiDuLieuLenBangChamCong();
//                    change();
//                    setShow(btnCapNhat, btnChamCong);
//                    setHidden(btnLuu, btnHuy);
//                } catch (ParseException | InterruptedException ex) {
//                    Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//                } finally {
//                    if (modelChamCong.getRowCount() > 0) {
//                        setShow(btnChamCongTatCa);
//                    }
//                    setHidden(btnLuu, btnHuy, btnCapNhat, btnChamCong);
//                    checkChamCong = false;
//                }
//            }
//            checkChamCong = false;
//        } else {
//            String ngayCham = tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 7).toString();
//            SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
//            Date kq = null;
//            try {
//                kq = dfm.parse(ngayCham);
//            } catch (ParseException ex) {
//                Logger.getLogger(ChamCongNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ChamCongNhanVien chamcong = new ChamCongNhanVien(nhanVienDuocChamCong, kq,
//                    tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 8).toString(), cmbTrangThai.getSelectedItem().toString(), gioLam, nhanvienDangNhap);
//            if (daoChamCong.suaMotChamCongNhanVien(chamcong)) {
//                //                    taiDuLieuLenBangNhanVien();
//                change();
//                JOptionPane.showMessageDialog(null, stCapNhatThanhCong);
//                if (modelChamCong.getRowCount() > 0) {
//                    setShow(btnChamCongTatCa, btnChamCong);
//                }
//                setHidden(btnLuu, btnHuy, btnCapNhat);
//            }
//        }
//        cmbGio.setEnabled(false);
//        cmbPhut.setEnabled(false);
//    }//GEN-LAST:event_btnLuuActionPerformed
//
//    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
//        setShow(btnChamCong, btnChamCongTatCa);
//        if (modelChamCong.getRowCount() > 0) {
//            setShow(btnChamCong, btnChamCongTatCa);
//        } else {
//            setHidden(btnChamCong, btnChamCongTatCa);
//        }
//        setHidden(btnLuu, btnHuy, btnCapNhat);
//        checkChamCong = false;
//        this.cmbTrangThai.setEnabled(false);
//        cmbGio.setEnabled(false);
//        cmbPhut.setEnabled(false);
//    }//GEN-LAST:event_btnHuyActionPerformed
//
//    private void btnChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongActionPerformed
//        setShow(btnLuu, btnHuy);
//        setHidden(btnChamCong, btnCapNhat, btnChamCongTatCa);
//        setEditInput(true);
//        checkChamCong = true;
//        cmbTrangThai.setSelectedIndex(0);
//        cmbGio.setEditable(false);
//        cmbPhut.setEditable(false);
//    }//GEN-LAST:event_btnChamCongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChamCong;
    private javax.swing.JButton btnChamCongTatCa;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLayDanhSach;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cmbCaLam;
    private javax.swing.JComboBox<String> cmbGio;
    private javax.swing.JComboBox<String> cmbHienThi;
    private javax.swing.JComboBox<String> cmbPhut;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private com.toedter.calendar.JDateChooser dcsNgayChamCong;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblCaLam;
    private javax.swing.JLabel lblGioDilam;
    private javax.swing.JLabel lblHIenThi;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblNgayChamCong;
    private javax.swing.JLabel lblPhut;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblValueHoVaTen;
    private javax.swing.JLabel lblValueMaNhanVien;
    private javax.swing.JScrollPane scrChamCong;
    private javax.swing.JScrollPane scrNhanVien;
    private javax.swing.JTable tblChamCong;
    private javax.swing.JTable tblNhanVien;
    // End of variables declaration//GEN-END:variables
}

