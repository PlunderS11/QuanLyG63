package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.HoaDon;
import entity.HopDong;
import entity.KhachHang;

public class DAO_HoaDon {
	public  ArrayList<HoaDon> getAllHoaDon() {
		
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getString(1));
				hd.setHopDong(new HopDong(rs.getString(2)));
				hd.setNgayLap(rs.getDate(3));
				hd.setDonGia(Double.parseDouble(rs.getString(4)));
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	
	public String getMaHDCuoi() {
		
		String maCuoi = null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "select top 1 maHoaDon from dbo.HoaDon order by maHoaDon desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maCuoi = rs.getString("maHoaDon");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCuoi;
	}
	
	public boolean create(HoaDon hd){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values(?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getHopDong().getMaHopDong());
			stmt.setDate(3, (Date) hd.getNgayLap()); 
			stmt.setDouble(4, hd.getDonGia()); 
		
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
