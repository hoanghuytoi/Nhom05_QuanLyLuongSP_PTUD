/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import Dao.BangLuongNhanVien_Dao;
import Dao.NhanVien_Dao;
import Dao.PhongBan_Dao;
import Entity.BangLuongNhanVien;
import Entity.NhanVien;
import Entity.PhongBan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author December
 */
public class ThongKeNhanVien_GUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienView
     */
    private DefaultTableModel model;
    private String fileName;

    public ThongKeNhanVien_GUI(String fileName) throws IOException {
        this.fileName = fileName;
        initComponents();
        cmbNam.removeAllItems();
        for (int i = 2000; i <= LocalDate.now().getYear(); i++) {
            cmbNam.addItem(i + "");
        }
        cmbNam.setSelectedItem(LocalDate.now().getYear() + "");
        excute();
        thongKeTiLeGioiTinhNhanVien();
        thongKeTongLuongNhanVienTheoThangNam();
        thongKeNhanVienTheoPhongBan();
        taiDuLieuLenBangNhanVien();
        caiDatNgonNguChoView(fileName);
    }

    public void caiDatNgonNguChoView(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        ChangeName(tblNhanVien, 0, prop.getProperty("pcd_stt"));
        ChangeName(tblNhanVien, 1, prop.getProperty("maNhanVien"));
        ChangeName(tblNhanVien, 2, prop.getProperty("hoTen"));
        ChangeName(tblNhanVien, 3, prop.getProperty("gioiTinh"));
        ChangeName(tblNhanVien, 4, prop.getProperty("phongBan"));
        ChangeName(tblNhanVien, 5, prop.getProperty("chucVu"));
    }

    public void ChangeName(JTable table, int col_index, String col_name) {
        table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }

    public void excute() {
        ButtonGroup btnGroup = new ButtonGroup();
        model = (DefaultTableModel) tblNhanVien.getModel();
    }

    public void thongKeTiLeGioiTinhNhanVien() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        NhanVien_Dao daoNhanVien = new NhanVien_Dao();
        ArrayList<NhanVien> nhanVienList = daoNhanVien.layDanhSachNhanVien();
        double soLuongNam = 0;
        double soLuongNu = 0;
        if (nhanVienList != null) {
            for (NhanVien nhanVien : nhanVienList) {
                if (nhanVien.isGioiTinh()) {
                    soLuongNam++;
                } else {
                    soLuongNu++;
                }
            }
        }
        DefaultPieDataset barDataset = new DefaultPieDataset();
        String nam =prop.getProperty("nam");
        String nu =prop.getProperty("nu");
        barDataset.setValue(nam, soLuongNam);
        barDataset.setValue(nu, soLuongNu);
        JFreeChart piechart = ChartFactory.createPieChart(prop.getProperty("gioiTinh"), barDataset, true, true, true);
        PiePlot piePlot = (PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(Color.white);
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pnPieChar.removeAll();
        pnPieChar.add(barChartPanel, BorderLayout.CENTER);
        pnPieChar.validate();
    }

    public void taiDuLieuLenBangNhanVien() {
        NhanVien_Dao daoNhanVien = new NhanVien_Dao();
        ArrayList<NhanVien> nhanVienList = daoNhanVien.layDanhSachNhanVien();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        if (nhanVienList != null) {
            nhanVienList.forEach(e -> {
                model.addRow(new Object[]{model.getRowCount() + 1, e.getMaNhanVien(), e.getHoTen(), e.isGioiTinh() ? "Nam" : "Nữ", e.getPhongBan().getTenPhongBan(), e.getChucVu()});
            });
        }
    }

//    public void showLineChart() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Amount", "1");
//        dataset.setValue(150, "Amount", "2");
//        dataset.setValue(18, "Amount", "3");
//        dataset.setValue(100, "Amount", "4");
//        dataset.setValue(80, "Amount", "5");
//        dataset.setValue(250, "Amount", "6");
//        dataset.setValue(250, "Amount", "7");
//        dataset.setValue(250, "Amount", "8");
//        dataset.setValue(250, "Amount", "9");
//        dataset.setValue(250, "Amount", "10");
//        dataset.setValue(250, "Amount", "11");
//        dataset.setValue(250, "Amount", "12");
//        JFreeChart linechart = ChartFactory.createLineChart("Line char", "Tháng", "Số tiền",
//                dataset, PlotOrientation.VERTICAL, true, true, true);
//        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204, 0, 51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//
//        //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
////        pnLineChar.removeAll();
////        pnLineChar.add(lineChartPanel, BorderLayout.CENTER);
////        pnLineChar.validate();
//    }
//
    /*========================================================================================*/
//    public void showHistogram() {
//
//        double[] values = {95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
//            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
//            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
//            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
//            77, 44, 58, 91, 10, 67, 57, 19, 88, 84
//        };
//
//        HistogramDataset dataset = new HistogramDataset();
//        dataset.addSeries("key", values, 20);
//
//        JFreeChart chart = ChartFactory.createHistogram("Thống kê nhân viên theo phòng ban", "Phòng Ban", "Số lượng nhân viên", dataset, PlotOrientation.VERTICAL, false, true, false);
//        XYPlot plot = chart.getXYPlot();
//        plot.setBackgroundPaint(Color.WHITE);
//
//        ChartPanel barpChartPanel2 = new ChartPanel(chart);
//        pnHitogramChar.removeAll();
//        pnHitogramChar.add(barpChartPanel2, BorderLayout.CENTER);
//        pnHitogramChar.validate();
//    }

    /*========================================================================================*/
    public void thongKeTongLuongNhanVienTheoThangNam() throws FileNotFoundException, IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        BangLuongNhanVien_Dao luongNhanVienDao = new BangLuongNhanVien_Dao();
        ArrayList<BangLuongNhanVien> bangLuongList = luongNhanVienDao.danhSachBangLuong();
        for (int i = 1; i < 13; i++) {
            String nam = "2022";
            try {
                if (cmbNam.getSelectedItem().toString() == null) {
                    nam = "2022";
                } else {
                    nam = cmbNam.getSelectedItem().toString();
                }
            } catch (Exception e) {
            }
            String value = i + "-" + nam;
            if (i < 10) {
                value = "0" + i + "-" + nam;
            }
            double tongLuong = 0;
            for (BangLuongNhanVien e : bangLuongList) {
                if (e.getLuongTheoThang().equalsIgnoreCase(value)) {
                    tongLuong += e.getThucLanh();
                }
            }
            dataset.setValue(new BigDecimal(tongLuong), "Amount", i + "");
        }
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        JFreeChart chart = ChartFactory.createBarChart(prop.getProperty("tk_tieudeThongeKeNhanVien"), prop.getProperty("tk_thang"), prop.getProperty("tk_soTien"),
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        pnBarChar.removeAll();
        pnBarChar.add(barpChartPanel, BorderLayout.CENTER);
        pnBarChar.validate();

    }

    public void thongKeNhanVienTheoPhongBan() throws FileNotFoundException, IOException {
        PhongBan_Dao phongBanDao = new PhongBan_Dao();
        ArrayList<PhongBan> phongBanList = phongBanDao.layDanhSachPhongBan();
        DefaultPieDataset barDataset = new DefaultPieDataset();
        if (phongBanList != null) {
            phongBanList.forEach(e -> extracted(barDataset, e));
        }
        FileInputStream fis = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(fis);
        JFreeChart piechart = ChartFactory.createPieChart(prop.getProperty("tk_tieudeThongeKeNhanVienPhongBan"), barDataset, true, true, true);//explain
        PiePlot piePlot = (PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(Color.white);
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pnHitogramChar.removeAll();
        pnHitogramChar.add(barChartPanel, BorderLayout.CENTER);
        pnHitogramChar.validate();
    }

	@SuppressWarnings("removal")
	private void extracted(DefaultPieDataset barDataset, PhongBan e) {
		barDataset.setValue(e.getTenPhongBan(), new Double(e.getSoLuongNhanVien()));
	}

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("serial")
	private void initComponents() {

        pnPieChar = new javax.swing.JPanel();
        pnPieChar.setBounds(780, 40, 420, 310);
        pnHitogramChar = new javax.swing.JPanel();
        pnHitogramChar.setBounds(10, 40, 550, 310);
        pnBarChar = new javax.swing.JPanel();
        pnBarChar.setBounds(570, 440, 620, 250);
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.setBounds(10, 460, 530, 230);
        tblNhanVien = new javax.swing.JTable();
        cmbNam = new javax.swing.JComboBox<>();
        cmbNam.setBounds(780, 390, 160, 40);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(null);

        pnPieChar.setLayout(new java.awt.BorderLayout());
        add(pnPieChar);

        pnHitogramChar.setLayout(new java.awt.BorderLayout());
        add(pnHitogramChar);

        pnBarChar.setLayout(new java.awt.BorderLayout());
        add(pnBarChar);

        tblNhanVien.getTableHeader().setBackground(new Color(32,136,203));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ trên", "Giới tính", "Phòng ban", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblNhanVien.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblNhanVien);

        add(jScrollPane3);

        cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000" }));
        cmbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamActionPerformed(evt);
            }
        });
        add(cmbNam);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamActionPerformed
        try {
            thongKeTongLuongNhanVienTheoThangNam();
        } catch (IOException ex) {
            Logger.getLogger(ThongKeNhanVien_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbNam;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnBarChar;
    private javax.swing.JPanel pnHitogramChar;
    private javax.swing.JPanel pnPieChar;
    private javax.swing.JTable tblNhanVien;
    // End of variables declaration//GEN-END:variables
}
