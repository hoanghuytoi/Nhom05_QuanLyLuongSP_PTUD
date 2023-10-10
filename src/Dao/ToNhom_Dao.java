package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectionDB.ConnectDB;
import Entity.ToNhom;

public class ToNhom_Dao {
	public ToNhom_Dao() {
    }
	
	public ArrayList<ToNhom> layDanhSachToNhom(){
		ArrayList<ToNhom> dsToNhom = new ArrayList<ToNhom>();
		Statement stm = null;
		try {
			ConnectionDB.ConnectDB.getInstance();
			Connection con = ConnectionDB.ConnectDB.getConnection();
			String query = "select *from ToNhom";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				String maToNhom = rs.getString("maToNhom");
				String tenToNhom = rs.getString("tenToNhom");
				int soLuongCongNhan = rs.getInt("soLuongCongNhan");
				dsToNhom.add(new ToNhom(maToNhom, tenToNhom, soLuongCongNhan));
 			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				stm.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dsToNhom;
	}
}
