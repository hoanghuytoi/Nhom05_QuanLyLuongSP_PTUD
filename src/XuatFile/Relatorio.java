package XuatFile;

import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	public static void gerarRelatorio() throws JRException {
		InputStream arq = Relatorio.class.getResourceAsStream("/FileReport/InHopDong.jrxml");
		JasperReport report = JasperCompileManager.compileReport(arq);
		ThongTinHD rp = new ThongTinHD("TP.HCM, ngày 20 tháng 11 năm 2023","PPHD100001", "Hợp đồng sản xuất","Huỳnh Công Vương", "Hoàng Huy Tới", "100 chiếc giày Adidas", "10/10/2023", "31/12/2023", 1000000000, 200000000);
		ArrayList<ThongTinHD> list = new ArrayList<>();
		list.add(rp);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
		JasperViewer.viewReport(print, false);
	}
	public static void main(String[] args) {
		try {
			gerarRelatorio();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
