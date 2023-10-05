package Entity;

import java.util.Date;

public class HopDong {
	private String maHopDong;
    private String tenHopDong;
    private String tenKhachHang;
    private String diaChi;
    private double soTienCoc;
    private double giaTriHD;
    private Date ngayKyKet;
    private Date hanChot;
    private String thoaThuan;
    
	public HopDong(String maHopDong, String tenHopDong, String tenKhachHang, String diaChi, double soTienCoc,
			double giaTriHD, Date ngayKyKet, Date hanChot, String thoaThuan) {
		try {
            setMaHopDong(maHopDong);
            setTenHopDong(tenHopDong);
            setTenKhachHang(tenKhachHang);
            setDiaChi(diaChi);
            setSoTienCoc(soTienCoc);
            setGiaTriHD(giaTriHD);
            setNgayKyKet(ngayKyKet);
            setHanChot(hanChot);
            setThoaThuan(thoaThuan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong)throws Exception {
		if (maHopDong.equals("")){
            throw new Exception("Mã hợp đồng không được để trống!");
        } else if (!maHopDong.matches("^HD[1-9][0-9]{4}$")) {
            throw new Exception("Mã hợp đồng phải theo dạng HDxxxxx với x là các kí tự số từ [0-9], x đầu tiên từ [1-9]");
        } else {
            this.maHopDong = maHopDong;
        }
	}

	public String getTenHopDong() {
		return tenHopDong;
	}

	public void setTenHopDong(String tenHopDong) throws Exception{
		 if (tenHopDong.equals("")){
	            throw new Exception("Tên hợp đồng không được trống!");
	        } else {
	            this.tenHopDong = tenHopDong;
	        }
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) throws Exception{
		 if (tenKhachHang.equals("")){
	            throw new Exception("Tên khách hàng không được trống!");
	        } else {
	            this.tenKhachHang = tenKhachHang;
	        }
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi)throws Exception {
		 if (diaChi.equals("")){
	            throw new Exception("Địa chỉ không được trống!");
	        } else {
	            this.diaChi = diaChi;
	        }
	}

	public double getSoTienCoc() {
		return soTienCoc;
	}

	public void setSoTienCoc(double soTienCoc) throws Exception{
		if (soTienCoc <= 0){
            throw new Exception("Số tiền cọc phải >0 !");
        } else {
            this.soTienCoc = soTienCoc;
        }
	}

	public double getGiaTriHD() {
		return giaTriHD;
	}

	public void setGiaTriHD(double giaTriHD) throws Exception{
		if (giaTriHD <= 0){
            throw new Exception("Gía trị hợp đồng phải >0 !");
        } else {
            this.giaTriHD = giaTriHD;
        }
	}

	public Date getNgayKyKet() {
		return ngayKyKet;
	}

	public void setNgayKyKet(Date ngayKyKet)throws Exception {
		if (ngayKyKet.after(new Date())){
            throw new Exception("Ngày kí kết phải trước ngày hiện tại !");
        } else {
            this.ngayKyKet = ngayKyKet;
        }
	}

	public Date getHanChot() {
		return hanChot;
	}

	public void setHanChot(Date hanChot) {
		this.hanChot = hanChot;
	}

	public String getThoaThuan() {
		return thoaThuan;
	}

	public void setThoaThuan(String thoaThuan) {
		this.thoaThuan = thoaThuan;
	}
    
	@Override
    public String toString() {
        return "HopDong{" + "maHopDong=" + maHopDong + ", tenHopDong=" + tenHopDong + ", tenKhachHang=" + tenKhachHang +", diaChi"+ diaChi + ", soTienCoc=" + soTienCoc + ", giaTriHD=" + giaTriHD + ", ngayKyKet=" + ngayKyKet + ", hanChot=" + hanChot + ", thoaThuan=" + thoaThuan + '}';
    }
	
}
