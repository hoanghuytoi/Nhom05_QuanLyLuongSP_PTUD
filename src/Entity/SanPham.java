package Entity;

public class SanPham {
	private String maSanPham;
    private String tenSanPham;
    private int soLuongSanPham;
    private String mauSac;
    private String chatLieu;
    private int kichThuoc;
    private String anhSanPham;
    private int soLuongCongDoan;
    private HopDong hopDong;
    
    public SanPham(String maSanPham, String tenSanPham, int soLuongSanPham, String mauSac, String chatLieu, int kichThuoc, String anhSanPham, int soLuongCongDoan, HopDong hopDong) {
        try {
            setMaSanPham(maSanPham);
            setTenSanPham(tenSanPham);
            setSoLuongSanPham(soLuongSanPham);
            setMauSac(mauSac);
            setChatLieu(chatLieu);
            setKichThuoc(kichThuoc);
            setAnhSanPham(anhSanPham);
            setSoLuongCongDoan(soLuongCongDoan);
            setHopDong(hopDong);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
	public String getMaSanPham() {
		return maSanPham;
	}
	
	private void setMaSanPham(String maSanPham) throws Exception {
        if (maSanPham.equals("")) {
            throw new Exception("Mã sản phẩm không được để Trống!");
        } else if (!maSanPham.matches("^SP[1-9][0-9]{4}$")) {
            throw new Exception("Mã Sản phẩm phải theo dạng SPxxxxx với x là các kí tự số x đầu tiên từ [1-9], x sau từ [0-9]");
        } else {
            this.maSanPham = maSanPham;
        }
    }
	
	public String getTenSanPham() {
		return tenSanPham;
	}
	
	public void setTenSanPham(String tenSanPham) throws Exception {
        if (tenSanPham.equals("")) {
            throw new Exception("Tên sản phẩm không được để trống!");
        } else {
            this.tenSanPham = tenSanPham;
        }
    }
	
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	
	public void setSoLuongSanPham(int soLuongSanPham) throws Exception {
        if (soLuongSanPham <= 0) {
            throw new Exception("Số lượng sản phẩm không được <= 0!");
        } else {
            this.soLuongSanPham = soLuongSanPham;
        }
    }
	
	public String getMauSac() {
		return mauSac;
	}
	
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	
	public String getChatLieu() {
		return chatLieu;
	}
	
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	
	public int getKichThuoc() {
		return kichThuoc;
	}
	
	public void setKichThuoc(int kichThuoc) throws Exception {
        if (kichThuoc <= 0) {
            throw new Exception("Kích thước không được <= 0!");
        } else {
            this.kichThuoc = kichThuoc;
        }
    }
	
	public String getAnhSanPham() {
		return anhSanPham;
	}
	
	public void setAnhSanPham(String anhSanPham) throws Exception {
        if (anhSanPham.equals("")) {
            throw new Exception("Ảnh sản phẩm không được để trống!");
        } else if (!anhSanPham.matches(".+\\.(png|PNG|jpg|JPG|raw|RAW|JPEG|jpeg)$")) {
            throw new Exception("Chỉ chấp nhận các ảnh có định dạng png, jpg, raw, jpeg");
        } else {
            this.anhSanPham = anhSanPham;
        }
    }
	
	public int getSoLuongCongDoan() {
		return soLuongCongDoan;
	}
	
	public void setSoLuongCongDoan(int soLuongCongDoan) throws Exception {
        if (soLuongCongDoan < 0) {
            throw new Exception("Số lượng công đoạn không được < 0");
        } else {
            this.soLuongCongDoan = soLuongCongDoan;
        }
    }
	
	public HopDong getHopDong() {
		return hopDong;
	}
	
	public void setHopDong(HopDong hopDong) {
		this.hopDong = hopDong;
	}
    
	@Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuongSanPham=" + soLuongSanPham + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", kichThuoc=" + kichThuoc + ", anhSanPham=" + anhSanPham + ", soLuongCongDoan=" + soLuongCongDoan + ", hopDong=" + hopDong + '}';
    }
}
