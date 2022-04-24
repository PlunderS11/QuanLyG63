package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.HangSanXuat;
import entity.LoaiXe;
import entity.Xe;

public class Xe_DAO {
	private Xe xe;
	
	public ArrayList<Xe> getDanhSachXe(){
		ArrayList<Xe> lsXe = new ArrayList<Xe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		String sql = "Select * from Xe";	
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Xe xe = new Xe();
				xe.setMaXe(rs.getString(1));
				xe.setTenXe(rs.getString(2));
				xe.setMauXe(rs.getString(3));
				xe.setSoKhung(rs.getString(4));
				xe.setSoMay(rs.getString(5));
				xe.setNhaCungCap(rs.getString(6));
				xe.setHangSanXuat(new HangSanXuat(rs.getString(7)));
				xe.setLoaiXe(new LoaiXe(rs.getString(8)));
				xe.setGiaXe(rs.getDouble(9));
				xe.setTrangThai(rs.getString(10));

				
				lsXe.add(xe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsXe;
	}
	public Xe getXeTheoMaHopDong(String maHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("select x.maXe,tenXe,mauXe,soKhung,soMay,nhaCungCap,maHangSX,maLoaiXe,giaXe from HopDong hd join Xe x on hd.maXe=x.maXe where hd.maHopDong = ?");
			stmt.setString(1, maHopDong);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Xe xe = new Xe();
				xe.setMaXe(rs.getString(1));
				xe.setTenXe(rs.getString(2));
				xe.setMauXe(rs.getString(3));
				xe.setSoKhung(rs.getString(4));
				xe.setSoMay(rs.getString(5));
				xe.setNhaCungCap(rs.getString(6));
				xe.setHangSanXuat(new HangSanXuat(rs.getString(7)));
				xe.setLoaiXe(new LoaiXe(rs.getString(8)));
				xe.setGiaXe(rs.getDouble(9));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return xe;
	}
}
