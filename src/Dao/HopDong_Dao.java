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
            String query = "select * from HopDong";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
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
            String query = "select * from HopDong where maHopDong = ?";
            stm = con.prepareCall(query);
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
    
    public boolean themMotHopDong(HopDong hopDong) {
        PreparedStatement stm = null;
        int soDongThemDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "insert into HopDong(maHopDong, tenHopDong, tenKhachHang, diaChi, soTienCoc, giaTriHD ,ngayKyKet ,hanChot, thoaThuan)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = con.prepareStatement(query);
            stm.setString(1, hopDong.getMaHopDong());
            stm.setString(2, hopDong.getTenHopDong());
            stm.setString(3, hopDong.getTenKhachHang());
            stm.setString(4, hopDong.getDiaChi());
            stm.setDouble(5, hopDong.getSoTienCoc());
            stm.setDouble(6, hopDong.getGiaTriHD());
            stm.setDate(7, new java.sql.Date(hopDong.getNgayKyKet().getTime()));
            stm.setDate(8, new java.sql.Date(hopDong.getHanChot().getTime()));
            stm.setString(9, hopDong.getThoaThuan());
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

    public boolean suaMotHopDong(HopDong hopDong) {
        PreparedStatement stm = null;
        int soDongSuaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "update HopDong"
                    + " set tenHopDong = ?, tenKhachHang = ?, diaChi = ?, soTienCoc = ?, giaTriHD = ? ,ngayKyKet = ?"
                    + " , hanChot = ?, thoaThuan = ?"
                    + " where maHopDong = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, hopDong.getMaHopDong());
            stm.setString(2, hopDong.getTenHopDong());
            stm.setString(3, hopDong.getTenKhachHang());
            stm.setString(4, hopDong.getDiaChi());
            stm.setDouble(5, hopDong.getSoTienCoc());
            stm.setDouble(6, hopDong.getGiaTriHD());
            stm.setDate(7, new java.sql.Date(hopDong.getNgayKyKet().getTime()));
            stm.setDate(8, new java.sql.Date(hopDong.getHanChot().getTime()));
            stm.setString(9, hopDong.getThoaThuan());
            soDongSuaDuoc = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soDongSuaDuoc != 0;
    }
    
    public boolean xoaMotHopDong(String maHopDong) {
        PreparedStatement stm = null;
        int soDongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "delete HopDong"
                    + " where maHopDong = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maHopDong);
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
