
package Entity;

import java.util.Date;

/**
 *
 * @author Student
 */
public class ChamCongNhanVien {
    private NhanVien nhanVien;
    private Date ngayChamCong;
    private String caLam;
    private String trangThaiDiLam;
    private String gioDiLam;
    private String gioTangCa;
    private NhanVien nguoiChamCong;

    
    public ChamCongNhanVien(NhanVien nhanVien, Date ngayChamCong, String caLam, String trangThaiDiLam, String gioDiLam,String gioTangCa, NhanVien nguoiChamCong) {
        try {
            
            setNhanVien(nhanVien);
            setNgayChamCong(ngayChamCong);
            setCaLam(caLam);
            setTrangThaiDiLam(trangThaiDiLam);
            setGioDiLam(gioDiLam);
            setGioTangCa(gioTangCa);
            setNguoiChamCong(nguoiChamCong);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public String getGioTangCa() {
		return gioTangCa;
	}

	public void setGioTangCa(String gioTangCa) {
		this.gioTangCa = gioTangCa;
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

    public String getTrangThaiDiLam() {
        return trangThaiDiLam;
    }

    public void setGioDiLam(String gioDiLam) {
        this.gioDiLam = gioDiLam;
    }

    public String getGioDiLam() {
        return gioDiLam;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhanVien getNguoiChamCong() {
        return nguoiChamCong;
    }

    public void setNguoiChamCong(NhanVien nguoiChamCong) {
        this.nguoiChamCong = nguoiChamCong;
    }

    @Override
    public String toString() {
        return "ChamCongNhanVien{" + "nhanVien=" + nhanVien + ", ngayChamCong=" + ngayChamCong + ", caLam=" + caLam + ", trangThaiDiLam=" + trangThaiDiLam + ", gioDiLam=" + gioDiLam +", gioTangCa=" + gioTangCa + ", nguoiChamCong=" + nguoiChamCong + '}';
    }

}
