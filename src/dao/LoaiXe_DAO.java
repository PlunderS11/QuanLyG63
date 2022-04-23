package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectDB;

import entity.LoaiXe;

public class LoaiXe_DAO {
	private LoaiXe loaiXe;
	public LoaiXe getLoaiXeTheoMa(String maLoaiXe) {
		LoaiXe loaiXe = new LoaiXe();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiXe where maLoaiXe = '"+maLoaiXe+"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				loaiXe.setMaLoaiXe(rs.getString(1));
				loaiXe.setTenLoaiXe(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loaiXe;
	}
	
}
