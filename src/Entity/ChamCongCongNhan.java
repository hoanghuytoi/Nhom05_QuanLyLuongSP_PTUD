package Entity;

import java.util.Date;

public class ChamCongCongNhan {
	private PhanCongCongNhan phanCong;
    private String caLam;
    private Date ngayChamCong;
    private int soLuongLam;
    private String trangThaiDiLam;
    private String gioDiLam;
    
	public ChamCongCongNhan(PhanCongCongNhan phanCong, String caLam, Date ngayChamCong, int soLuongLam,
			String trangThaiDiLam, String gioDiLam) {
		try {
            setPhanCong(phanCong);
            setCaLam(caLam);
            setNgayChamCong(ngayChamCong);
            setSoLuongLam(soLuongLam);
            setTrangThaiDiLam(trangThaiDiLam);
            setGioDiLam(gioDiLam);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	public PhanCongCongNhan getPhanCong() {
		return phanCong;
	}

	public void setPhanCong(PhanCongCongNhan phanCong) {
		this.phanCong = phanCong;
	}

	public String getCaLam() {
		return caLam;
	}

	public void setCaLam(String caLam) throws Exception {
        if (caLam.equalsIgnoreCase("")){
            throw new Exception("Ca làm không được trống!");
        } else {
            this.caLam = caLam;
        }
    }

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) throws Exception {
        if (ngayChamCong.after(new Date())) {
            throw new Exception("Ngày chấm công công nhân phải trước hoặc bằng ngày hiện tại");
        } else {
            this.ngayChamCong = ngayChamCong;
        }
    }

	public int getSoLuongLam() {
		return soLuongLam;
	}

	public void setSoLuongLam(int soLuongLam) throws Exception {
        if (soLuongLam <= 0) {
            throw new Exception("Số lượng làm phải > 0");
        } else {
            this.soLuongLam = soLuongLam;
        }
    }

	public String getTrangThaiDiLam() {
		return trangThaiDiLam;
	}

	private void setTrangThaiDiLam(String trangThaiDiLam) throws Exception {
        if (trangThaiDiLam.equalsIgnoreCase("Đi làm")
                || trangThaiDiLam.equalsIgnoreCase("Đi trễ")
                || trangThaiDiLam.equalsIgnoreCase("Nghỉ Không phép")
                || trangThaiDiLam.equalsIgnoreCase("Nghỉ có phép")) {
            this.trangThaiDiLam = trangThaiDiLam;
        } else {
            throw new Exception("Trạng thái đi làm phải là 1 trong 3: Đi làm, Đi trễ, Nghỉ");
        }
    }

	public String getGioDiLam() {
		return gioDiLam;
	}

	public void setGioDiLam(String gioDiLam) {
		this.gioDiLam = gioDiLam;
	}
    
	@Override
    public String toString() {
        return "ChamCongCongNhan{" + "phanCong=" + phanCong + ", caLam=" + caLam + ", ngayChamCong=" + ngayChamCong + ", soLuongLam=" + soLuongLam + ", trangThaiDiLam=" + trangThaiDiLam + ", gioDiLam=" + gioDiLam + '}';
    }
    
}
