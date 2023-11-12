package XuatFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entity.HopDong;

import java.io.InputStream;
import java.math.BigDecimal;
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

	public void inHopDong(ArrayList<HopDong> dsHD) throws JRException {
	    try {
	        InputStream arq = getClass().getResourceAsStream("/FileReport/InHopDong.jrxml");
	        JasperReport report = JasperCompileManager.compileReport(arq);

	        Map<String, Object> parameters = new HashMap<String, Object>();
	        ArrayList<HopDongForm> list = new ArrayList<>();

	        for (HopDong hd : dsHD) {
	            HopDongForm hopDongForm = new HopDongForm();
	            hopDongForm.setTime(hd.getNgayKyKetHD());
	            hopDongForm.setMaHopDong(hd.getMaHopDong());
	            hopDongForm.setTenHopDong(hd.getTenHopDong());
	            hopDongForm.setTenKhachHang(hd.getTenKhachHang());
	            hopDongForm.setNgayBatDau(new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayKyKetHD()));
	            hopDongForm.setNgayKetThuc(new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayKetThucHD()));
	            hopDongForm.setTriGiaHD(new BigDecimal(hd.getTriGiaHD()));
	            hopDongForm.setTienDatCoc(new BigDecimal(hd.getTienDatCoc()));
	            hopDongForm.setYeuCau(hd.getYeuCau());
	            hopDongForm.setNguoiKyKet(hd.getNguoiKyKet().getHoTen());

	            list.add(hopDongForm);
	        }

	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
	        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);
	        JasperViewer.viewReport(print, false);

	    } catch (JRException e) {
	        e.printStackTrace();
	    }
	}

}
