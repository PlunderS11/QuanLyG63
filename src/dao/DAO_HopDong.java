package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Xe;

public class DAO_HopDong {
public  ArrayList<HopDong> getAllHopDong() {
		
		ArrayList<HopDong> dsHopDong = new ArrayList<HopDong>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from HopDong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
			HopDong hd = new HopDong();
			hd.setMaHopDong(rs.getString(1));
			hd.setKhachHang(new KhachHang(rs.getString(2)));
			hd.setNhanVien(new NhanVien(rs.getString(3)));
			hd.setXe(new Xe(rs.getString(4)));
			hd.setNgayLapHopDong(rs.getDate(5));
			dsHopDong.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHopDong;
	}
	public String getMaHDCuoi() {
		
		String maCuoi = null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "select top 1 maHopDong from dbo.HopDong order by maHopDong desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maCuoi = rs.getString("maHopDong");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCuoi;
	}

	public boolean create(HopDong hd){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HopDong values(?,?,?,?,?)");
			stmt.setString(1, hd.getMaHopDong());
			stmt.setString(2, hd.getKhachHang().getMaKH());
			stmt.setString(3, hd.getNhanVien().getMaNV()); 
			stmt.setString(4, hd.getXe().getMaXe()); 
			stmt.setDate(5, (Date) hd.getNgayLapHopDong()); 
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
