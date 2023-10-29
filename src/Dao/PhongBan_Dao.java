package Dao;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectionDB.ConnectDB;
import Entity.PhongBan;

public class PhongBan_Dao {
	public PhongBan_Dao() {
    }

    public ArrayList<PhongBan> layDanhSachPhongBan() {
        ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
        Statement stm = null;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "select * from PhongBan";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(truyVan);
            while (rs.next()) {
                String maPhongBan = rs.getString("maPhongBan");
                String tenPhongBan = rs.getString("tenPhongBan");
                int soLuongNhanVien = rs.getInt("soLuongNhanVien");
                dsPhongBan.add(new PhongBan(maPhongBan, tenPhongBan, soLuongNhanVien));
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
        return dsPhongBan;
    }

    public PhongBan layMotPhongBanTheoMa(String maPhongBan) {
        PreparedStatement stm = null;
        PhongBan phongBan = null;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "SELECT * FROM PhongBan where maPhongBan = ?";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, maPhongBan);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maPhongBanOb = rs.getString("maPhongBan");
                String tenPhongBan = rs.getString("tenPhongBan");
                int soLuongNhanVien = rs.getInt("soLuongNhanVien");
                phongBan = new PhongBan(maPhongBanOb, tenPhongBan, soLuongNhanVien);
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
        return phongBan;
    }

    public PhongBan layMotPhongBanTheoTen(String ten) {
        PreparedStatement stm = null;
        PhongBan phongBan = null;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "SELECT * FROM PhongBan where tenPhongBan = ?";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, ten);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maPhongBanOb = rs.getString("maPhongBan");
                String tenPhongBan = rs.getString("tenPhongBan");
                int soLuongNhanVien = rs.getInt("soLuongNhanVien");
                phongBan = new PhongBan(maPhongBanOb, tenPhongBan, soLuongNhanVien);
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
        return phongBan;
    }

    public boolean themMotPhongBan(PhongBan phongBan) {
        PreparedStatement stm = null;
        int soDongThemDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = " INSERT INTO PhongBan(maPhongBan, tenPhongBan)"
                    + " VALUES(?, ?)";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, phongBan.getMaPhongBan());
            stm.setString(2, phongBan.getTenPhongBan());
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

    public boolean suaMotPhongBan(PhongBan phongBan) {
        PreparedStatement stm = null;
        int soDongSuaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "UPDATE PhongBan"
                    + " SET tenPhongBan = ?"
                    + " WHERE maPhongBan = ?";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, phongBan.getTenPhongBan());
            stm.setString(2, phongBan.getMaPhongBan());
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

    public boolean xoaMotPhongBanTheoMa(String maPhongBan) {
        PreparedStatement stm = null;
        int soDongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String truyVan = "DELETE PhongBan"
                    + " WHERE maPhongBan = ?";
            stm = con.prepareStatement(truyVan);
            stm.setString(1, maPhongBan);
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

    public String layRaMaPhongBanDeThem() {
        Statement stm = null;
        String  maPhongBan = "";
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String truyVan = "select top 1 * from PhongBan order by LEN(maPhongBan), maPhongBan desc";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(truyVan);
            while (rs.next()) {
                maPhongBan = rs.getString("maPhongBan");
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (maPhongBan.equals("") || maPhongBan == null){
            return "PB100001";
            
        }

        String chuoiCanLay = maPhongBan.split("PB")[1];

        try {
            chuoiCanLay = "PB" + (Integer.parseInt(chuoiCanLay) + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return chuoiCanLay;
    }

    public int layRaSoLuongPhongBan(){
        Statement stm = null;
        int soLuong = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String truyVan = "select count(maPhongBan) as soLuongPhongBan from PhongBan";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(truyVan);
            while(rs.next()){
                soLuong = rs.getInt("soLuongPhongBan");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stm.close();;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return soLuong;
    }
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ConnectDB.getInstance().connect();
            System.out.println("Yes");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        PhongBan_Dao dao = new PhongBan_Dao();
        System.out.println(dao.themMotPhongBan(new PhongBan("PB111111", "Phòng Nhân sự", 0)));
        System.out.println("\n\n\nDanh sách: " + dao.layDanhSachPhongBan());
        System.out.println("\n\n\nSửa: " + dao.suaMotPhongBan(new PhongBan("PB111111", "Phòng Kế toán", 0)));
        System.out.println("\n\n\nXóa: " + dao.xoaMotPhongBanTheoMa("PB111111"));
        System.out.println("\n\n\nLấy 1: " + dao.layMotPhongBanTheoMa("PB123123"));
    }
}

