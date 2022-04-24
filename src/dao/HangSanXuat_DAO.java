package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectDB;
import entity.HangSanXuat;


public class HangSanXuat_DAO {
	private HangSanXuat hsx;
	public HangSanXuat getHSXTheoMa(String ma) {
		HangSanXuat hsx = new HangSanXuat();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HangSanXuat where maHangSX = '"+ma+"'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				hsx.setMaHangSX(rs.getString(1));
				hsx.setTenHangSX(rs.getString(2));
				hsx.setNguonGoc(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return hsx;
	}
}
