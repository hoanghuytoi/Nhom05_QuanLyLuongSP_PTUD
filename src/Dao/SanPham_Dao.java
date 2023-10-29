package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectionDB.ConnectDB;
import Entity.HopDong;
import Entity.SanPham;

public class SanPham_Dao {
	public SanPham_Dao() {
    }

//    public ArrayList<SanPham> layDanhSachSanPham() {
//        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
//        Statement stm = null;
//        HopDong_Dao hopDong_DAO = new HopDong_Dao();
//        try {
//            ConnectionDB.ConnectDB.getInstance();
//            Connection con = ConnectionDB.ConnectDB.getConnection();
//            String truyVan = "SELECT * FROM SanPham";
//            stm = con.createStatement();
//            ResultSet rs = stm.executeQuery(truyVan);
//            while (rs.next()) {
//                String maSanPham = rs.getString("maSanPham");
//                String maHopDong = rs.getString("maHopDong");
//                String tenSanPham = rs.getString("tenSanPham");
//                int soLuongSanPham = rs.getInt("soLuongSanPham");
//                String mauSac = rs.getString("mauSac");
//                String chatLieu = rs.getString("chatLieu");
//                int kichThuoc = rs.getInt("kichThuoc");
//                String anhSanPham = rs.getString("anhSanPham");
//                int soLuongCongDoan = rs.getInt("soLuongCongDoan");
//                HopDong hopDong = hopDong_DAO.layRaMotHopDongTheoMaHopDong(maHopDong);
//                dsSanPham.add(new SanPham(maSanPham, tenSanPham, soLuongSanPham, mauSac, chatLieu, kichThuoc, anhSanPham, soLuongCongDoan, hopDong));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return dsSanPham;
//    }
//    public ArrayList<SanPham> layDanhSachSanPhamTheoMaHopDong(String maHopDongTemp) {
//        PreparedStatement stm = null;
//        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();
//        HopDong_Dao hopDong_DAO = new HopDong_Dao();
//        try {
//            ConnectDB.getInstance();
//            Connection con = ConnectDB.getConnection();
//            String truyVan = "select * from SanPham where maHopDong = ?";
//            stm = con.prepareStatement(truyVan);
//            stm.setString(1, maHopDongTemp);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                String maSanPham = rs.getString("maSanPham");
//                String maHopDong = rs.getString("maHopDong");
//                String tenSanPham = rs.getString("tenSanPham");
//                int soLuongSanPham = rs.getInt("soLuongSanPham");
//                String mauSac = rs.getString("mauSac");
//                String chatLieu = rs.getString("chatLieu");
//                int kichThuoc = rs.getInt("kichThuoc");
//                String anhSanPham = rs.getString("anhSanPham");
//                int soLuongCongDoan = rs.getInt("soLuongCongDoan");
//                HopDong hopDong = hopDong_DAO.layRaMotHopDongTheoMaHopDong(maHopDong);
//                dsSanPham.add(new SanPham(maSanPham, tenSanPham, soLuongSanPham, mauSac, chatLieu, kichThuoc, anhSanPham, soLuongCongDoan, hopDong));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return dsSanPham;
//    }
//
//    public SanPham layMotSanPhamTheoMa(String maSanPham) {
//        PreparedStatement stm = null;
//        SanPham sanPham = null;
//        HopDong_Dao hopDong_DAO = new HopDong_Dao();
//        try {
//            ConnectionDB.ConnectDB.getInstance();
//            Connection con = ConnectionDB.ConnectDB.getConnection();
//            String truyVan = "select * from SanPham where maSanPham = ?";
//            stm = con.prepareStatement(truyVan);
//            stm.setString(1, maSanPham);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                String maSanPhamOB = rs.getString("maSanPham");
//                String maHopDong = rs.getString("maHopDong");
//                String tenSanPham = rs.getString("tenSanPham");
//                int soLuongSanPham = rs.getInt("soLuongSanPham");
//                String mauSac = rs.getString("mauSac");
//                String chatLieu = rs.getString("chatLieu");
//                int kichThuoc = rs.getInt("kichThuoc");
//                String anhSanPham = rs.getString("anhSanPham");
//                int soLuongCongDoan = rs.getInt("soLuongCongDoan");
//                HopDong hopDong = hopDong_DAO.layRaMotHopDongTheoMaHopDong(maHopDong);
//                sanPham = new SanPham(maSanPham, tenSanPham, soLuongSanPham, mauSac, chatLieu, kichThuoc, anhSanPham, soLuongCongDoan, hopDong);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return sanPham;
//    }
//    
//    public boolean themMotSanPham(SanPham sanPham) {
//        PreparedStatement stm = null;
//        int soDongThemDuoc = 0;
//        try {
//            ConnectionDB.ConnectDB.getInstance();
//            Connection con = ConnectionDB.ConnectDB.getConnection();
//            String truyVan = "INSERT INTO SanPham(maSanPham, maHopDong, tenSanPham, soLuongSanPham"
//                    + "	, mauSac, chatLieu, kichThuoc, anhSanPham)"
//                    + "  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//            stm = con.prepareStatement(truyVan);
//            stm.setString(1, sanPham.getMaSanPham());
//            stm.setString(2, sanPham.getHopDong().getMaHopDong());
//            stm.setString(3, sanPham.getTenSanPham());
//            stm.setInt(4, sanPham.getSoLuongSanPham());
//            stm.setString(5, sanPham.getMauSac());
//            stm.setString(6, sanPham.getChatLieu());
//            stm.setInt(7, sanPham.getKichThuoc());
//            stm.setString(8, sanPham.getAnhSanPham());
//            soDongThemDuoc = stm.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return soDongThemDuoc != 0;
//    }
//
//    public boolean suaMotSanPham(SanPham sanPham) {
//        PreparedStatement stm = null;
//        int soLuongSuaDuoc = 0;
//        System.out.println(sanPham.toString());
//        try {
//            ConnectionDB.ConnectDB.getInstance();
//            Connection con = ConnectionDB.ConnectDB.getConnection();
//            String truyVan = "UPDATE SanPham"
//                    + " set tenSanPham = ?, maHopDong = ?, soLuongSanPham = ?,"
//                    + " mauSac = ?, chatLieu = ?, kichThuoc = ?,"
//                    + " anhSanPham = ?"
//                    + " where maSanPham = ?";
//            stm = con.prepareStatement(truyVan);
//            stm.setString(1, sanPham.getTenSanPham());
//            stm.setString(2, sanPham.getHopDong().getMaHopDong());
//            stm.setInt(3, sanPham.getSoLuongSanPham());
//            stm.setString(4, sanPham.getMauSac());
//            stm.setString(5, sanPham.getChatLieu());
//            stm.setInt(6, sanPham.getKichThuoc());
//            stm.setString(7, sanPham.getAnhSanPham());
//            stm.setString(8, sanPham.getMaSanPham());
//
//            soLuongSuaDuoc = stm.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return soLuongSuaDuoc != 0;
//    }
//
//    public boolean xoaMotSanPhamTheoMa(String maSanPham) {
//        PreparedStatement stm = null;
//        int soLuongXoaDuoc = 0;
//        try {
//            ConnectionDB.ConnectDB.getInstance();
//            Connection con = ConnectionDB.ConnectDB.getConnection();
//            String truyVan = "DELETE FROM SanPham WHERE maSanPham = ?";
//            stm = con.prepareStatement(truyVan);
//            stm.setString(1, maSanPham);
//            soLuongXoaDuoc = stm.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                stm.close();
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return soLuongXoaDuoc != 0;
//    }
}
