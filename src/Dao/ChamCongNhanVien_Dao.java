package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.ChamCongNhanVien;
import Entity.NhanVien;

public class ChamCongNhanVien_Dao {
	public ChamCongNhanVien_Dao() {
    }

    public ArrayList<ChamCongNhanVien> danhSachChamCongNhanVien() {
        Statement stm = null;
        NhanVien_Dao nhanVien_Dao = new NhanVien_Dao();
        ArrayList<ChamCongNhanVien> dsChamCong = new ArrayList<ChamCongNhanVien>();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "select * from BangChamCongNhanVien order by ngayChamCong desc";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(truyVan);
            while (rs.next()) {
                String maNhanVien = rs.getString("maNhanVien");
                String caLam = rs.getString("caLam");
                Date ngayChamCong = rs.getDate("ngayChamCong");
                String trangThaiDiLam = rs.getString("trangThaiDiLam");
                String gioDiLam = rs.getString("gioDiLam");
                String gioTangCa = rs.getString("gioTangCa");
                String maNguoiCham = rs.getString("maNguoiCham");
                NhanVien nhanVien = nhanVien_Dao.layMotNhanVienTheoMaNhanVien(maNhanVien);
                NhanVien nguoiChamCong = nhanVien_Dao.layMotNhanVienTheoMaNhanVien(maNguoiCham);
                dsChamCong.add(new ChamCongNhanVien(nhanVien, ngayChamCong, caLam, trangThaiDiLam, gioDiLam, gioTangCa, nguoiChamCong));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dsChamCong;
    }

    public boolean themMotChamCongNhanVien(ChamCongNhanVien chamCongNhanVien) {
        PreparedStatement stm = null;
        int soDongThemDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "INSERT INTO BangChamCongNhanVien(maNhanVien, caLam, ngayChamCong, trangThaiDiLam"
                    + " , gioDiLam, gioTangCa, maNguoiCham)"
                    + " VALUES(?, ?, ?, ?, ?, ?,?)";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, chamCongNhanVien.getNhanVien().getMaNhanVien());
            stm.setString(2, chamCongNhanVien.getCaLam());
            stm.setDate(3, new java.sql.Date(chamCongNhanVien.getNgayChamCong().getTime()));
            stm.setString(4, chamCongNhanVien.getTrangThaiDiLam());
            stm.setString(5, chamCongNhanVien.getGioDiLam());
            stm.setString(6, chamCongNhanVien.getGioTangCa());
            stm.setString(7, chamCongNhanVien.getNguoiChamCong().getMaNhanVien());

            soDongThemDuoc = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soDongThemDuoc != 0;
    }

}
