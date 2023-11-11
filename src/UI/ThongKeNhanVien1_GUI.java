package UI;

import java.awt.Dimension;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import Dao.BangLuongNhanVien_Dao;
import Entity.BangLuongNhanVien;

public class ThongKeNhanVien1_GUI extends JPanel{
	private JLabel lblTieuDe;
	private ChartPanel pnBarChar;
	private JComboBox cmbNam;
	private Component cmbThang;
	private String fileName;
	private JButton btnThngK;
	public ThongKeNhanVien1_GUI(String fileName) throws FileNotFoundException, IOException {
		this.fileName = fileName;
		setBackground(new Color(255, 255, 255));
		initComponents();
		cmbNam.removeAllItems();
        for (int i = 2000; i <= LocalDate.now().getYear(); i++) {
            cmbNam.addItem(i + "");
        }
        cmbNam.setSelectedItem(LocalDate.now().getYear() + "");
        thongKeTongLuongNhanVienTheoThangNam();
		
	}
	public void thongKeTongLuongNhanVienTheoThangNam() throws FileNotFoundException, IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        BangLuongNhanVien_Dao luongNhanVienDao = new BangLuongNhanVien_Dao();
        ArrayList<BangLuongNhanVien> bangLuongList = luongNhanVienDao.danhSachBangLuong();
        
        double tongLuong = 0;
//        for (BangLuongNhanVien e : bangLuongList) {
//        	tongLuong = e.getThucLanh();
//        }
        String manv = "";
        for (BangLuongNhanVien e1 : bangLuongList) {
        	tongLuong = e1.getThucLanh();
        	manv = e1.getNhanVien().getHoTen();
        	dataset.setValue(new BigDecimal(tongLuong), "Luong", manv);
        }
//        for (int i = 1; i < 13; i++) {
//            String nam = "2022";
//            try {
//                if (cmbNam.getSelectedItem().toString() == null) {
//                    nam = "2022";
//                } else {
//                    nam = cmbNam.getSelectedItem().toString();
//                }
//            } catch (Exception e) {}
//            
////            String value = i + "-" + nam;
////            if (i < 10) {
////                value = "0" + i + "-" + nam;
////            }
////            double tongLuong = 0;
////            for (BangLuongNhanVien e : bangLuongList) {
////                if (e.getLuongTheoThang().equalsIgnoreCase(value)) {
////                    tongLuong += e.getThucLanh();
////                }
////            }
//            dataset.setValue(new BigDecimal(tongLuong), "Amount", i + "");
//        }
//        dataset.setValue(new BigDecimal(tongLuong), "Luong", "minh");
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
	private void initComponents() {
		setPreferredSize(new Dimension(1290, 750));
		setLayout(null);
		lblTieuDe = new JLabel("THỐNG KÊ LƯƠNG NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(455, 5, 379, 30);
		add(lblTieuDe);
		
		JLabel lblNewLabel = new JLabel("Chọn loại thống kê:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(216, 64, 115, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiêu chí 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(216, 104, 62, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tiêu chí 1:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(216, 145, 62, 14);
		add(lblNewLabel_1_1);
		
		JComboBox cmbLoaiTK = new JComboBox();
		cmbLoaiTK.setModel(new DefaultComboBoxModel(new String[] {"Thống kê theo tháng", "Thống kê theo năm"}));
		cmbLoaiTK.setBounds(343, 57, 201, 30);
		add(cmbLoaiTK);
		
		JComboBox cmbTC1 = new JComboBox();
		cmbTC1.setBounds(343, 97, 201, 30);
		add(cmbTC1);
		
		JComboBox cmbTC2 = new JComboBox();
		cmbTC2.setBounds(343, 138, 201, 30);
		add(cmbTC2);
		
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThang.setBounds(655, 65, 62, 14);
		add(lblThang);
		
		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNam.setBounds(655, 104, 62, 14);
		add(lblNam);
		
		cmbThang = new JComboBox();
		cmbThang.setBounds(727, 57, 74, 30);
		add(cmbThang);
		
		cmbNam = new JComboBox();
		cmbNam.setBounds(727, 97, 74, 30);
		cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023" }));
        cmbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamActionPerformed(evt);
            }
        });
		add(cmbNam);
		
		btnThngK = new JButton();
		btnThngK.setText("Thống kê");
		btnThngK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThngK.setEnabled(false);
		btnThngK.setBorder(null);
		btnThngK.setBackground(new Color(255, 215, 0));
		btnThngK.setBounds(597, 138, 171, 30);
//		btnThngK.addActionListener(new java.awt.event.ActionListener() {
//          public void actionPerformed(java.awt.event.ActionEvent evt) {
//              cmbNamActionPerformed(evt);
//          }
//		});
		add(btnThngK);
		
		JButton btnInBngThng = new JButton();
		btnInBngThng.setText("In bảng thống kê");
		btnInBngThng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnInBngThng.setEnabled(false);
		btnInBngThng.setBorder(null);
		btnInBngThng.setBackground(new Color(255, 215, 0));
		btnInBngThng.setBounds(786, 138, 171, 30);
		add(btnInBngThng);
		
		pnBarChar = new ChartPanel((JFreeChart) null);
		pnBarChar.setBounds(20, 179, 700, 436);
		add(pnBarChar);
	}
	private void cmbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamActionPerformed
        try {
            thongKeTongLuongNhanVienTheoThangNam();
        } catch (IOException ex) {
            Logger.getLogger(ThongKeNhanVien1_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbNamActionPerformed
}
