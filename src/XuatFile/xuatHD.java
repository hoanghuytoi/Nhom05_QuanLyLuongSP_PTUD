package XuatFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entity.HopDong;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class xuatHD {

	public void inHopDong(HopDong hd,ArrayList<HopDong> dsHD) throws JRException {
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

	        ArrayList<HopDongForm> list = new ArrayList<>();
			
			for(int i = 0; i < dsHD.size(); i++) {
				list.add(new HopDongForm());
			}
			
	        JasperPrint print = JasperFillManager.fillReport(report, tthd, new JRBeanCollectionDataSource(list));
	        JasperViewer.viewReport(print, false);

	    } catch (JRException e) {
	        e.printStackTrace();
	    }
	}
	
}
