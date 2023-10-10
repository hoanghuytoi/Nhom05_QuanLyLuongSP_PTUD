package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.CongNhan;
import Entity.ToNhom;

public class CongNhan_Dao {
	public CongNhan_Dao() {
    }

    public ArrayList<CongNhan> layDanhSachCongNhan() {
        ArrayList<CongNhan> dsCongNhan = new ArrayList<CongNhan>();
        Statement stm = null;
        ToNhom_Dao toNhom_DAO = new ToNhom_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "SELECT * FROM CongNhan";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String maCongNhan = rs.getString("maCongNhan");
                String hoTen = rs.getString("hoTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String maCCCD = rs.getString("maCCCD");
                String soDienThoai = rs.getString("soDienThoai");
                String email = rs.getString("email");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                String anhDaiDien = rs.getString("anhDaiDien");
                String diaChi = rs.getString("diaChi");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String maToNhom = rs.getString("toNhom");
                ToNhom toNhom = toNhom_DAO.layMotToNhomTheoMa(maToNhom);
                dsCongNhan.add(new CongNhan(maCongNhan, hoTen, ngaySinh, maCCCD, soDienThoai, email, ngayVaoLam, gioiTinh, anhDaiDien, diaChi, toNhom));
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
        return dsCongNhan;
    }

    public CongNhan layMotCongNhanTheoMa(String maCongNhan) {
        CongNhan congNhan = null;
        PreparedStatement stm = null;
        ToNhom_Dao toNhom_DAO = new ToNhom_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "SELECT * FROM CongNhan where maCongNhan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maCongNhan);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maCongNhanOb = rs.getString("maCongNhan");
                String hoTen = rs.getString("hoTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String maCCCD = rs.getString("maCCCD");
                String soDienThoai = rs.getString("soDienThoai");
                String email = rs.getString("email");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                String anhDaiDien = rs.getString("anhDaiDien");
                String diaChi = rs.getString("diaChi");
                Date ngayVaoLam = rs.getDate("ngayVaoLam");
                String maToNhom = rs.getString("toNhom");
                ToNhom toNhom = toNhom_DAO.layMotToNhomTheoMa(maToNhom);
                congNhan = new CongNhan(maCongNhan, hoTen, ngaySinh, maCCCD, soDienThoai, email, ngayVaoLam, gioiTinh, anhDaiDien, diaChi, toNhom);
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
        return congNhan;
    }

    public boolean themMotCongNhan(CongNhan congNhan) {
        PreparedStatement stm = null;
        int soLuongThemDuoc = 0;

        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "INSERT INTO CongNhan(maCongNhan, hoTen, ngaySinh, maCCCD, soDienThoai, email, gioiTinh, anhDaiDien, diaChi, ngayVaoLam, toNhom) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = con.prepareStatement(query);
            stm.setString(1, congNhan.getMaCongNhan());
            stm.setString(2, congNhan.getHoTen());
            stm.setDate(3, new java.sql.Date(congNhan.getNgaySinh().getTime()));
            stm.setString(4, congNhan.getMaCCCD());
            stm.setString(5, congNhan.getSoDienThoai());
            stm.setString(6, congNhan.getEmail());
            stm.setBoolean(7, congNhan.isGioiTinh());
            stm.setString(8, congNhan.getAnhDaiDien());
            stm.setString(9, congNhan.getDiaChi());
            stm.setDate(10, new java.sql.Date(congNhan.getNgayVaoLam().getTime()));
            stm.setString(11, congNhan.getToNhom().getMaToNhom());
            soLuongThemDuoc = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soLuongThemDuoc != 0;
    }
    
    public boolean capNhatMotCongNhan(CongNhan congNhan) {
        PreparedStatement stm = null;
        int soLuongDuocCapNhat = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "UPDATE CongNhan"
                    + " SET hoTen = ?, ngaySinh = ?, maCCCD = ?,"
                    + " soDienThoai = ?, email = ?,"
                    + " gioiTinh = ?, anhDaiDien = ?, diaChi = ?,"
                    + " ngayVaoLam = ?, toNhom = ?"
                    + " WHERE maCongNhan = ? ";
            stm = con.prepareStatement(query);
            stm.setString(1, congNhan.getHoTen());
            stm.setDate(2, new java.sql.Date(congNhan.getNgaySinh().getTime()));
            stm.setString(3, congNhan.getMaCCCD());
            stm.setString(4, congNhan.getSoDienThoai());
            stm.setString(5, congNhan.getEmail());
            stm.setBoolean(6, congNhan.isGioiTinh());
            stm.setString(7, congNhan.getAnhDaiDien());
            stm.setString(8, congNhan.getDiaChi());
            stm.setDate(9, new java.sql.Date(congNhan.getNgayVaoLam().getTime()));
            stm.setString(10, congNhan.getToNhom().getMaToNhom());
            stm.setString(11, congNhan.getMaCongNhan());
            soLuongDuocCapNhat = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soLuongDuocCapNhat != 0;
    }

    public boolean xoaCongNhanTheoMa(String maCongNhan) {
        PreparedStatement stm = null;
        int soLuongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "delete from CongNhan where maCongNhan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maCongNhan);
            soLuongXoaDuoc = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soLuongXoaDuoc != 0;
    }
}
