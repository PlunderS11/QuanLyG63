package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public List<TaiKhoan> getAllTaiKhoan(){
		List<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				TaiKhoan tk = new TaiKhoan(taiKhoan, matKhau);
				dsTK.add(tk);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	public boolean createTK(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values(?,?)");
			stmt.setString(1, tk.getTenTaiKhoan());
			stmt.setString(2, tk.getMatKhau());
			
			n = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}return n > 0;
	}
	public boolean delete(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete TaiKhoan where taiKhoan = ?");
			stmt.setString(1, id);
			n = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}return n > 0;
	}
	public boolean updateDoiMatKhau(TaiKhoan tk, String mkMoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where taiKhoan = ?");
			stmt.setString(1, mkMoi);
			stmt.setString(2, tk.getTenTaiKhoan());
			n = stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				stmt.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}return n > 0;
	}
}