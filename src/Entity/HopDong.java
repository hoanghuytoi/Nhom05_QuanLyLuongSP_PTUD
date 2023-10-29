package Entity;

import java.util.Date;

public class HopDong {
	private String maHopDong;
    private String tenHopDong;
    private String tenKhachHang;
    private double tienDatCoc;
    private double triGiaHD;
    private Date ngayKyKetHD;
    private Date ngayKetThucHD;
    private String yeuCau;
    private NhanVien nguoiKyKet;
    
	public HopDong(String maHopDong, String tenHopDong, String tenKhachHang, double tienDatCoc, double triGiaHD,
			Date ngayKyKetHD, Date ngayKetThucHD, String yeuCau, NhanVien nguoiKyKet) {
		super();
		this.maHopDong = maHopDong;
		this.tenHopDong = tenHopDong;
		this.tenKhachHang = tenKhachHang;
		this.tienDatCoc = tienDatCoc;
		this.triGiaHD = triGiaHD;
		this.ngayKyKetHD = ngayKyKetHD;
		this.ngayKetThucHD = ngayKetThucHD;
		this.yeuCau = yeuCau;
		this.nguoiKyKet = nguoiKyKet;
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

	public double getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(double TienDatCoc) throws Exception{
		if (tienDatCoc <= 0){
            throw new Exception("Số tiền cọc phải >0 !");
        } else {
            this.tienDatCoc = tienDatCoc;
        }
	}

	public double getTriGiaHD() {
		return triGiaHD;
	}

	public void setTriGiaHD(double giaTriHD) throws Exception{
		if (giaTriHD <= 0){
            throw new Exception("Gía trị hợp đồng phải >0 !");
        } else {
            this.triGiaHD = giaTriHD;
        }
	}

	public Date getNgayKyKetHD() {
		return ngayKyKetHD;
	}

	public void setNgayKyKetHD(Date ngayKyKetHD)throws Exception {
		if (ngayKyKetHD.after(new Date())){
            throw new Exception("Ngày kí kết phải trước ngày hiện tại !");
        } else {
            this.ngayKyKetHD = ngayKyKetHD;
        }
	}

	public Date getNgayKetThucHD() {
		return ngayKetThucHD;
	}

	public void setNgayKetThucHD(Date ngayKetThucHD) {
		this.ngayKetThucHD = ngayKetThucHD;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public NhanVien getNguoiKyKet() {
		return nguoiKyKet;
	}

	public void setNguoiKyKet(NhanVien nguoiKyKet) {
		this.nguoiKyKet = nguoiKyKet;
	}

	@Override
	public String toString() {
		return "HopDong [maHopDong=" + maHopDong + ", tenHopDong=" + tenHopDong + ", tenKhachHang=" + tenKhachHang
				+ ", tienDatCoc=" + tienDatCoc + ", triGiaHD=" + triGiaHD + ", ngayKyKetHD=" + ngayKyKetHD
				+ ", ngayKetThucHD=" + ngayKetThucHD + ", yeuCau=" + yeuCau + ", maNguoiKyKet=" + nguoiKyKet + "]";
	}
}
