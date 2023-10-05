package Entity;

import java.util.Date;

public class ChamCongNhanVien {
	private NhanVien nhanVien;
    private Date ngayChamCong;
    private String caLam;
    private String trangThaiDiLam;
    private String gioDiLam;
    private NhanVien nguoiChamCong;
    
    public ChamCongNhanVien(NhanVien nhanVien, Date ngayChamCong, String caLam, String trangThaiDiLam, String gioDiLam, NhanVien nguoiChamCong) {
        try {
            
            setNhanVien(nhanVien);
            setNgayChamCong(ngayChamCong);
            setCaLam(caLam);
            setTrangThaiDiLam(trangThaiDiLam);
            setGioDiLam(gioDiLam);
            setNguoiChamCong(nguoiChamCong);
        } catch (Exception e) {
            e.getMessage();
        }
    }

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) throws Exception {
        if (ngayChamCong.after(new Date())) {
            throw new Exception("Ngày chấm công phải bằng hoặc trước ngày hiện tại");
        } else {
            this.ngayChamCong = ngayChamCong;
        }
    }

	public String getCaLam() {
		return caLam;
	}

	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}

	public String getTrangThaiDiLam() {
		return trangThaiDiLam;
	}

	private void setTrangThaiDiLam(String trangThaiDiLam) throws Exception {
        if (trangThaiDiLam.equalsIgnoreCase("Đi làm")
                || trangThaiDiLam.equalsIgnoreCase("Đi làm trễ")
                || trangThaiDiLam.equalsIgnoreCase("Nghỉ Không phép")
                || trangThaiDiLam.equalsIgnoreCase("Nghỉ có phép")) {
            this.trangThaiDiLam = trangThaiDiLam;
        } else {
            throw new Exception("Trạng thái đi làm phải là 1 trong 3: Đi làm, Đi làm trễ, Nghỉ");
        }
    }

	public String getGioDiLam() {
		return gioDiLam;
	}

	public void setGioDiLam(String gioDiLam) {
		this.gioDiLam = gioDiLam;
	}

	public NhanVien getNguoiChamCong() {
		return nguoiChamCong;
	}

	public void setNguoiChamCong(NhanVien nguoiChamCong) {
		this.nguoiChamCong = nguoiChamCong;
	}
    
	@Override
    public String toString() {
        return "ChamCongNhanVien{" + "nhanVien=" + nhanVien + ", ngayChamCong=" + ngayChamCong + ", caLam=" + caLam + ", trangThaiDiLam=" + trangThaiDiLam + ", gioDiLam=" + gioDiLam + ", nguoiChamCong=" + nguoiChamCong + '}';
    }
    
}
