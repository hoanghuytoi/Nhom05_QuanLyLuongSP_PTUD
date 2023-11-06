package XuatFile;

public class HopDongForm {
	private String time;
	private String maHopDong;
	private String tenHopDong;
	private String tenKhachHang;
	private String nguoiKyKet;
	private String yeuCau;
	private String ngayBatDau;
	private String ngayKetThuc;
	private long triGiaHD;
	private long tienDatCoc;
	
	
	
	@Override
	public String toString() {
		return "HopDongForm [time=" + time + ", maHopDong=" + maHopDong + ", tenHopDong=" + tenHopDong
				+ ", tenKhachHang=" + tenKhachHang + ", nguoiKyKet=" + nguoiKyKet + ", yeuCau=" + yeuCau
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", triGiaHD=" + triGiaHD
				+ ", tienDatCoc=" + tienDatCoc + "]";
	}

	public HopDongForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HopDongForm(String time, String maHopDong, String tenHopDong, String tenKhachHang, String nguoiKyKet,
			String yeuCau, String ngayBatDau, String ngayKetThuc, long triGiaHD, long tienDatCoc) {
		super();
		this.time = time;
		this.maHopDong = maHopDong;
		this.tenHopDong = tenHopDong;
		this.tenKhachHang = tenKhachHang;
		this.nguoiKyKet = nguoiKyKet;
		this.yeuCau = yeuCau;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.triGiaHD = triGiaHD;
		this.tienDatCoc = tienDatCoc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public String getTenHopDong() {
		return tenHopDong;
	}

	public void setTenHopDong(String tenHopDong) {
		this.tenHopDong = tenHopDong;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getNguoiKyKet() {
		return nguoiKyKet;
	}

	public void setNguoiKyKet(String nguoiKyKet) {
		this.nguoiKyKet = nguoiKyKet;
	}

	public String getYeuCau() {
		return yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public long getTriGiaHD() {
		return triGiaHD;
	}

	public void setTriGiaHD(long triGiaHD) {
		this.triGiaHD = triGiaHD;
	}

	public long getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(long tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}
	
	
	
	
}
