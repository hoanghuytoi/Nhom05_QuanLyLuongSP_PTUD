package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Entity.CongDoan;
import Entity.SanPham;

public class CongDoan_Dao {
	public CongDoan_Dao() {
    }

    public ArrayList<CongDoan> layDanhSachCongDoanTheoMaSP(String maSanPham) {
        PreparedStatement stm = null;
        ArrayList<CongDoan> dsCongDoan = new ArrayList<CongDoan>();
        SanPham_Dao sanPham_DAO = new SanPham_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "SELECT * FROM CongDoan WHERE maSanPham = ? order by thuTu ";
            stm = con.prepareStatement(query);
            stm.setString(1, maSanPham);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maCongDoan = rs.getString("maCongDoan");
                int thuTuCongDoan = rs.getInt("thuTu");
                String tenCongDoan = rs.getString("tenCongDoan");
                int soLuongCan = rs.getInt("soLuongCan");
                String tinhTrang = rs.getString("tinhTrang");
                Date thoiHan = rs.getDate("thoiHan");
                String maSanPhamOb = rs.getString("maSanPham");
                double tienLuong = rs.getBigDecimal("tienLuong").doubleValue();
                SanPham sanPham = sanPham_DAO.layMotSanPhamTheoMa(maSanPhamOb);
                dsCongDoan.add(new CongDoan(maCongDoan, thuTuCongDoan, tenCongDoan, soLuongCan, tinhTrang, thoiHan, sanPham, tienLuong));
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
        return dsCongDoan;
    }

    public CongDoan layMotCongDoanTheoMaCongDoan(String maCongDoan) {
        PreparedStatement stm = null;
        CongDoan congDoan = null;
        SanPham_Dao sanPham_DAO = new SanPham_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "select * from CongDoan where maCongDoan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maCongDoan);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maCongDoanOb = rs.getString("maCongDoan");
                int thuTuCongDoan = rs.getInt("thuTu");
                String tenCongDoan = rs.getString("tenCongDoan");
                int soLuongCan = rs.getInt("soLuongCan");
                String tinhTrang = rs.getString("tinhTrang");
                Date thoiHan = rs.getDate("thoiHan");
                String maSanPhamOb = rs.getString("maSanPham");
                double tienLuong = rs.getBigDecimal("tienLuong").doubleValue();
                SanPham sanPham = sanPham_DAO.layMotSanPhamTheoMa(maSanPhamOb);
                congDoan = new CongDoan(maCongDoanOb, thuTuCongDoan, tenCongDoan, soLuongCan, tinhTrang, thoiHan, sanPham, tienLuong);
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
        return congDoan;
    }
    
    public boolean themMotCongDoan(CongDoan congDoan) {
        PreparedStatement stm = null;
        int soDongThemDuoc = 0;

        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "INSERT INTO CongDoan(maCongDoan, thuTu, tenCongDoan, soLuongCan, tinhTrang, "
                    + " thoiHan, maSanPham, tienLuong)"
                    + " VALUES(?, ?, ?, ?, ? ,? ,?, ?)";
            stm = con.prepareStatement(query);
            stm.setString(1, congDoan.getMaCongDoan());
            stm.setInt(2, congDoan.getThuTuCongDoan());
            stm.setString(3, congDoan.getTenCongDoan());
            stm.setInt(4, congDoan.getSoLuongCan());
            stm.setString(5, congDoan.getTinhTrang());
            stm.setDate(6, new java.sql.Date(congDoan.getThoiHan().getTime()));
            stm.setString(7, congDoan.getSanPham().getMaSanPham());
            stm.setBigDecimal(8, new BigDecimal(congDoan.getTienLuong()));
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

    public boolean suaMotCongDoan(CongDoan congDoan) {
        PreparedStatement stm = null;
        int soDongDuocSua = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "update CongDoan "
                    + " set tenCongDoan = ?, thuTu = ?, soLuongCan = ?, tinhTrang = ?"
                    + " , thoiHan = ?, maSanPham = ?, tienLuong = ?"
                    + " where maCongDoan = ? ";
            stm = con.prepareStatement(query);
            stm.setString(1, congDoan.getTenCongDoan());
            stm.setInt(2, congDoan.getThuTuCongDoan());
            stm.setInt(3, congDoan.getSoLuongCan());
            stm.setString(4, congDoan.getTinhTrang());
            stm.setDate(5, new java.sql.Date(congDoan.getThoiHan().getTime()));
            stm.setString(6, congDoan.getSanPham().getMaSanPham());
            stm.setBigDecimal(7, new BigDecimal(congDoan.getTienLuong()));
            stm.setString(8, congDoan.getMaCongDoan());
            soDongDuocSua = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soDongDuocSua != 0;
    }

    public boolean xoaMotCongDoanTheoMa(String maCongDoan) {
        PreparedStatement stm = null;
        int soDongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = " DELETE FROM CongDoan"
                    + " WHERE maCongDoan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maCongDoan);
            soDongXoaDuoc = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soDongXoaDuoc != 0;
    }
}
