package Entity;

import java.util.Date;

public class CongDoan {
	private String maCongDoan;
    private int thuTuCongDoan;
    private String tenCongDoan;
    private int soLuongCan;
    private String tinhTrang;
    private Date thoiHan;
    private SanPham sanPham;
    private double tienLuong;
    
	public CongDoan(String maCongDoan, int thuTuCongDoan, String tenCongDoan, int soLuongCan, String tinhTrang,
			Date thoiHan, SanPham sanPham, double tienLuong) {
		try {
            setMaCongDoan(maCongDoan);
            setTenCongDoan(tenCongDoan);
            setSoLuongCan(soLuongCan);
            setTinhTrang(tinhTrang);
            setThoiHan(thoiHan);
            setSanPham(sanPham);
            setTienLuong(tienLuong);
            setThuTuCongDoan(thuTuCongDoan);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}

	public String getMaCongDoan() {
		return maCongDoan;
	}

	public void setMaCongDoan(String maCongDoan) throws Exception{
		if (maCongDoan.equals("")) {
            throw new Exception("Mã công đoạn không được để trống!");
        } else if (!maCongDoan.matches("^CD[1-9][0-9]{4}$")) {
            throw new Exception("Mã Công đoạn phải theo dạng CDxxxxx với x là các kí tự số x đầu tiền từ [1-9], x sau từ [0-9]");
        } else {
            this.maCongDoan = maCongDoan;
        }
	}

	public int getThuTuCongDoan() {
		return thuTuCongDoan;
	}

	public void setThuTuCongDoan(int thuTuCongDoan) throws Exception{
		if (thuTuCongDoan <= 0){
            throw new Exception("Thứ tự công đoạn phải từ 1 trở lên!");
        } else {
            this.thuTuCongDoan = thuTuCongDoan;
        }
	}

	public String getTenCongDoan() {
		return tenCongDoan;
	}

	public void setTenCongDoan(String tenCongDoan) throws Exception{
		if (tenCongDoan.equals("")){
            throw new Exception("Tên công đoạn không được để trống!");
        } else {
            this.tenCongDoan = tenCongDoan;
        }
	}

	public int getSoLuongCan() {
		return soLuongCan;
	}

	public void setSoLuongCan(int soLuongCan) throws Exception{
		if (soLuongCan <= 0) {
            throw new Exception("Số lượng cần phải >0 !");
        } else {
            this.soLuongCan = soLuongCan;
        }
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getThoiHan() {
		return thoiHan;
	}

	public void setThoiHan(Date thoiHan) {
		this.thoiHan = thoiHan;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) throws Exception{
		if (tienLuong <= 0) {
            throw new Exception("Tiền lương phải >0 !");
        } else {
            this.tienLuong = tienLuong;
        }
	}
    
	@Override
    public String toString() {
        return "CongDoan{" + "maCongDoan=" + maCongDoan + ", thuTuCongDoan=" + thuTuCongDoan + ", tenCongDoan=" + tenCongDoan + ", soLuongCan=" + soLuongCan + ", tinhTrang=" + tinhTrang + ", thoiHan=" + thoiHan + ", sanPham=" + sanPham + ", tienLuong=" + tienLuong + '}';
    }
	
    
}
