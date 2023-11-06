package XuatFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entity.HopDong;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class xuatHD {
	
//	public static void gerarRelatorio() throws JRException {
//	    InputStream arq = Relatorio.class.getResourceAsStream("/FileReport/InHopDong.jrxml");
//	    JasperReport report = JasperCompileManager.compileReport(arq);
//
//	    ArrayList<ThongTinHD> list = new ArrayList<>();
//	    ThongTinHD rp = new ThongTinHD("TP.HCM, ngày 20 tháng 11 năm 2023","PPHD100001", "Hợp đồng sản xuất","Huỳnh Công Vương", "Hoàng Huy Tới", "100 chiếc giày Adidas", "10/10/2023", "31/12/2023", 1000000000, 200000000);
//        list.add(rp)
//	    JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
//	    JasperViewer.viewReport(print, false);
//	}

	public void inHopDong(HopDong hd) throws JRException {
	    try {
	        InputStream arq = getClass().getResourceAsStream("/FileReport/InHopDong.jrxml");
	        JasperReport report = JasperCompileManager.compileReport(arq);
	        Map<String, Object> tthd = new HashMap<String, Object>();
	        tthd.put("time", hd.getNgayKyKetHD());
	        tthd.put("maHopDong", hd.getMaHopDong());
	        tthd.put("tenHopDong", hd.getTenHopDong());
	        tthd.put("tenKhachHang", hd.getTenKhachHang());
	        tthd.put("ngayBatDau", new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayKyKetHD()));
	        tthd.put("ngayKetThuc", new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayKetThucHD()));
	        tthd.put("triGiaHD", new DecimalFormat("#,###").format(hd.getTriGiaHD()) + " VNĐ");
	        tthd.put("tienDatCoc", new DecimalFormat("#,###").format(hd.getTienDatCoc()) + " VNĐ");
	        tthd.put("yeuCau", hd.getYeuCau());
	        tthd.put("nguoiKyKet", hd.getNguoiKyKet().getHoTen());
	        List<HopDong> hopDongList = new ArrayList<>();
	        hopDongList.add(hd);
	        
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(hopDongList);
	        JasperPrint print = JasperFillManager.fillReport(report, tthd, dataSource);
	        JasperViewer.viewReport(print, false);
	        
	    } catch (JRException e) {
	        e.printStackTrace();
	    }
	}
}
