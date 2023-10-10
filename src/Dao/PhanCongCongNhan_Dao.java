package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ConnectionDB.ConnectDB;
import Entity.CongDoan;
import Entity.CongNhan;
import Entity.NhanVien;
import Entity.PhanCongCongNhan;
import Entity.ToNhom;

public class PhanCongCongNhan_Dao {
	public PhanCongCongNhan_Dao() {
    }

    public ArrayList<PhanCongCongNhan> layDanhSachPhanCongCongNhan() {
        ArrayList<PhanCongCongNhan> dsPhanCongCongNhan = new ArrayList<PhanCongCongNhan>();
        Statement stm = null;
        CongNhan_Dao congNhan_DAO = new CongNhan_Dao();
        NhanVien_Dao nhanVien_DAO = new NhanVien_Dao();
        CongDoan_Dao congDoan_DAO = new CongDoan_Dao();
        ToNhom_Dao toNhom_DAO = new ToNhom_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "select * from PhanCongCongNhan";
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String maPhanCong = rs.getString("maPhanCong");
                String maCongNhan = rs.getString("maCongNhan");
                String maNguoiPhanCong = rs.getString("maNguoiPhanCong");
                String maCongDoan = rs.getString("maCongDoan");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                int soLuongCanLam = rs.getInt("soLuongCanLam");
                String maToNhom = rs.getString("maToNhom");
                CongDoan congDoan = congDoan_DAO.layMotCongDoanTheoMaCongDoan(maCongDoan);
                NhanVien nguoiPhanCong = nhanVien_DAO.layMotNhanVienTheoMaNhanVien(maNguoiPhanCong);
                CongNhan congNhan = congNhan_DAO.layMotCongNhanTheoMa(maCongNhan);
                ToNhom toNhom = toNhom_DAO.layMotToNhomTheoMa(maToNhom);
                dsPhanCongCongNhan.add(new PhanCongCongNhan(maPhanCong, congNhan, congDoan, nguoiPhanCong, ngayPhanCong, soLuongCanLam, toNhom));
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
        return dsPhanCongCongNhan;
    }
    
    public PhanCongCongNhan layMotPhanCongCongNhanTheoMaPhanCong(String maPhanCong) {
        PreparedStatement stm = null;
        PhanCongCongNhan phanCongCongNhan = null;
        CongNhan_Dao congNhan_DAO = new CongNhan_Dao();
        NhanVien_Dao nhanVien_DAO = new NhanVien_Dao();
        CongDoan_Dao congDoan_DAO = new CongDoan_Dao();
        ToNhom_Dao toNhom_DAO = new ToNhom_Dao();
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "SELECT * FROM PhanCongCongNhan WHERE maPhanCong = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maPhanCong);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maPhanCongOb = rs.getString("maPhanCong");
                String maCongNhan = rs.getString("maCongNhan");
                String maNguoiPhanCong = rs.getString("maNguoiPhanCong");
                String maCongDoan = rs.getString("maCongDoan");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                int soLuongCanLam = rs.getInt("soLuongCanLam");
                String maToNhom = rs.getString("maToNhom");
                CongDoan congDoan = congDoan_DAO.layMotCongDoanTheoMaCongDoan(maCongDoan);
                NhanVien nguoiPhanCong = nhanVien_DAO.layMotNhanVienTheoMaNhanVien(maNguoiPhanCong);
                CongNhan congNhan = congNhan_DAO.layMotCongNhanTheoMa(maCongNhan);
                ToNhom toNhom = toNhom_DAO.layMotToNhomTheoMa(maToNhom);
                phanCongCongNhan = new PhanCongCongNhan(maPhanCongOb, congNhan, congDoan, nguoiPhanCong, ngayPhanCong, soLuongCanLam, toNhom);
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
        return phanCongCongNhan;
    }

    public ArrayList<PhanCongCongNhan> layDanhSachPhanCongTheoMaCongDoan(String maCongDoanTemp) {
        PreparedStatement stm = null;
        ArrayList<PhanCongCongNhan> dsPhanCong = new ArrayList<PhanCongCongNhan>();
        CongNhan_Dao congNhan_DAO = new CongNhan_Dao();
        NhanVien_Dao nhanVien_DAO = new NhanVien_Dao();
        CongDoan_Dao congDoan_DAO = new CongDoan_Dao();
        ToNhom_Dao toNhom_DAO = new ToNhom_Dao();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String query = "SELECT * FROM PhanCongCongNhan WHERE maCongDoan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maCongDoanTemp);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maPhanCongOb = rs.getString("maPhanCong");
                String maCongNhan = rs.getString("maCongNhan");
                String maNguoiPhanCong = rs.getString("maNguoiPhanCong");
                String maCongDoan = rs.getString("maCongDoan");
                Date ngayPhanCong = rs.getDate("ngayPhanCong");
                int soLuongCanLam = rs.getInt("soLuongCanLam");
                String maToNhom = rs.getString("maToNhom");
                CongDoan congDoan = congDoan_DAO.layMotCongDoanTheoMaCongDoan(maCongDoan);
                NhanVien nguoiPhanCong = nhanVien_DAO.layMotNhanVienTheoMaNhanVien(maNguoiPhanCong);
                CongNhan congNhan = congNhan_DAO.layMotCongNhanTheoMa(maCongNhan);
                ToNhom toNhom = toNhom_DAO.layMotToNhomTheoMa(maToNhom);
                dsPhanCong.add(new PhanCongCongNhan(maPhanCongOb, congNhan, congDoan, nguoiPhanCong, ngayPhanCong, soLuongCanLam, toNhom));
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
        return dsPhanCong;
    }
    
    public boolean themMotPhanCongNhan(PhanCongCongNhan phanCongCongNhan) {
        PreparedStatement stm = null;
        int soDongThemDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "insert into PhanCongCongNhan(maPhanCong, maCongNhan"
                    + " , maNguoiPhanCong, maCongDoan, ngayPhanCong, soLuongCanLam, maToNhom)"
                    + " values(? , ? , ?, ? , ?, ? , ?)";
            stm = con.prepareStatement(query);
            stm.setString(1, phanCongCongNhan.getMaPhanCong());
            stm.setString(2, phanCongCongNhan.getCongNhan().getMaCongNhan());
            stm.setString(3, phanCongCongNhan.getNguoiPhanCong().getMaNhanVien());
            stm.setString(4, phanCongCongNhan.getCongDoan().getMaCongDoan());
            stm.setDate(5, new java.sql.Date(phanCongCongNhan.getNgayPhanCong().getTime()));
            stm.setInt(6, phanCongCongNhan.getSoLuongCanLam());
            stm.setString(7, phanCongCongNhan.getToNhom().getMaToNhom());
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

    public boolean suaMotPhanCongNhan(PhanCongCongNhan phanCongCongNhan) {
        PreparedStatement stm = null;
        int soDongSuaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = " UPDATE PhanCongCongNhan"
                    + "  set maCongNhan = ?, maNguoiPhanCong = ?,"
                    + "  maCongDoan = ?, ngayPhanCong = ?, soLuongCanLam = ?,maToNhom = ?"
                    + "  where maPhanCong = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, phanCongCongNhan.getCongNhan().getMaCongNhan());
            stm.setString(2, phanCongCongNhan.getNguoiPhanCong().getMaNhanVien());
            stm.setString(3, phanCongCongNhan.getCongDoan().getMaCongDoan());
            stm.setDate(4, new java.sql.Date(phanCongCongNhan.getNgayPhanCong().getTime()));
            stm.setInt(5, phanCongCongNhan.getSoLuongCanLam());
            stm.setString(6, phanCongCongNhan.getToNhom().getMaToNhom());
            stm.setString(7, phanCongCongNhan.getMaPhanCong());
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

    public boolean suaMotPhanCongNhanTheoMaCongDoan(String maToNhom, int soLuongCanLam, String maCongDoan) {
        PreparedStatement stm = null;
        int soDongSuaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "update PhanCongCongNhan set maToNhom =? , soLuongCanLam = ? where maCongDoan=?";
            stm = con.prepareStatement(query);
            stm.setString(1, maToNhom);
            stm.setInt(2, soLuongCanLam);
            stm.setString(3, maCongDoan);
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
        return soDongSuaDuoc > 0;
    }

    public boolean xoaMotPhanCongTheoMaPhanCong(String maPhanCong) {
        PreparedStatement stm = null;
        int soDongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "DELETE FROM PhanCongCongNhan WHERE maPhanCong = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maPhanCong);
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
    
    public boolean xoaMotPhanCongTheoMaToNhomVaMaCongDoan(String maToNhom, String maCongDoan) {
        PreparedStatement stm = null;
        int soDongXoaDuoc = 0;
        try {
            ConnectionDB.ConnectDB.getInstance();
            Connection con = ConnectionDB.ConnectDB.getConnection();
            String query = "DELETE FROM PhanCongCongNhan WHERE maToNhom = ? and maCongDoan = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, maToNhom);
            stm.setString(2, maCongDoan);
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
