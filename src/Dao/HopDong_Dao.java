package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.HopDong;

public class HopDong_Dao {
	public HopDong_Dao() {
    }

    public ArrayList<HopDong> layDanhSachHopDong() {
        Statement stm = null;
        ArrayList<HopDong> dsHopDong = new ArrayList<HopDong>();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "select * from HopDong";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(truyVan);
            while (rs.next()) {
                String maHopDong = rs.getString("maHopDong");
                String tenHopDong = rs.getString("tenHopDong");
                String tenKhachHang = rs.getString("tenKhachHang");
                String diaChi = rs.getString("diaChi");
                double soTienCoc = rs.getBigDecimal("soTienCoc").doubleValue();
                double giaTriHD = rs.getBigDecimal("giaTriHD").doubleValue();
                Date ngayKyKet = rs.getDate("ngayKyKet");
                Date hanChot = rs.getDate("hanChot");
                String thoaThuan = rs.getString("thoaThuan");
                dsHopDong.add(new HopDong(maHopDong, tenHopDong, tenKhachHang,diaChi, soTienCoc, giaTriHD, ngayKyKet, hanChot, thoaThuan));
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
        return dsHopDong;
    }

    public HopDong layRaMotHopDongTheoMaHopDong(String maHopDong) {
        PreparedStatement stm = null;
        HopDong hopDong = null;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "select * from HopDong where maHopDong = ?";
            stm = con.prepareCall(truyVan);
            stm.setString(1, maHopDong);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maHopDongTmp = rs.getString("maHopDong");
                String tenHopDong = rs.getString("tenHopDong");
                String tenKhachHang = rs.getString("tenKhachHang");
                String diaChi = rs.getString("diaChi");
                double soTienCoc = rs.getBigDecimal("soTienCoc").doubleValue();
                double giaTriHD = rs.getBigDecimal("giaTriHD").doubleValue();
                Date ngayKyKet = rs.getDate("ngayKyKet");
                Date hanChot = rs.getDate("hanChot");
                String thoaThuan = rs.getString("thoaThuan");
                hopDong = new HopDong(maHopDongTmp, tenHopDong, tenKhachHang,diaChi, soTienCoc, giaTriHD, ngayKyKet, hanChot, thoaThuan);
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
        return hopDong;
    }
}
