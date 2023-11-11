/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectionDB.ConnectDB;
import Entity.HopDong;
import Entity.SanPham;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author December
 */
public class ThongKeNhanVien_Dao {

    public ThongKeNhanVien_Dao() {
    }

    public ArrayList<String> thongKeLuongNhanVienTheoThang(String nam) {
        PreparedStatement stm = null;
        ArrayList<String> thongKeList = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            for (int i = 1; i < 13; i++) {
                String sql = "select SUM(tongTien)as tongTien from BangLuongNhanVien\n"
                        + "where luongTheoThang like ? \n"
                        + "group by luongTheoThang";
                stm = con.prepareStatement(sql);
                String value=i+"-"+nam;
                if (i < 10) {
                    value="0"+i+"-"+nam;
                }
                System.out.println(value);
                stm.setString(1, value);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    String tongTien = rs.getString("tongTien");
                    thongKeList.add(tongTien);
                }
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
        return null;
    }
}

