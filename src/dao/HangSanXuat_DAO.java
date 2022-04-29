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


public class HangSanXuat_DAO {
	private HangSanXuat hsx;
	public boolean themHangSanXuat(HangSanXuat hsx) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into HangSanXuat values (?,?,?)");
			stmt.setString(1, hsx.getMaHangSX());
			stmt.setString(2, hsx.getTenHangSX());
			stmt.setString(3, hsx.getNguonGoc());


			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n>0;
	}
	
	public String getMaHSX() {
		String maHSX="";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('HSX', RIGHT(CONCAT('0000',ISNULL(right(max(maHangSX),3),0) + 1),4)) from [dbo].[Xe] where maHangSX like 'HSX%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				maHSX = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return maHSX;
	}
	
	public boolean suaThongTinHangSanXuat(HangSanXuat hsx) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("update HangSanXuat set tenHangSX=?, nguonGoc = ? where maHangSX=?");

			
			stmt.setString(1, hsx.getTenHangSX());
			stmt.setString(2, hsx.getNguonGoc());
			stmt.setString(3, hsx.getMaHangSX());


			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n>0;
	}
	
	
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
	
	public String getMaTheoHangSanXuat(String tenHangSanXuat) {
		String maLoai ="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maHangSX from HangSanXuat where tenHangSX = N'"+tenHangSanXuat +"'";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				maLoai = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maLoai;
		
	}


public ArrayList<HangSanXuat> getDanhSachHangSanXat(){
	ArrayList<HangSanXuat> lsHSX = new ArrayList<HangSanXuat>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();	
	String sql = "select * from HangSanXuat";	
	try {
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			HangSanXuat hsx = new HangSanXuat();
			hsx.setMaHangSX(rs.getString(1));
			hsx.setTenHangSX(rs.getString(2));
			hsx.setNguonGoc(rs.getString(3));
			
			lsHSX.add(hsx);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lsHSX;
}

public ArrayList<Xe> getDanhSachXe(String maHangSanXuat){
	ArrayList<Xe> lsXe = new ArrayList<Xe>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	String sql = "select * from Xe where maHangSX = '"+maHangSanXuat+"'";
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
			Xe xe = new Xe();
			xe.setMaXe(rs.getString(1));
			xe.setTenXe(rs.getString(2));
			
			lsXe.add(xe);
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return lsXe;
	
	
}
	public String getMaXeCuoi() {
	
		String maCuoi = null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "select top 1 maHangSX from dbo.HangSanXuat order by maHangSX desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maCuoi = rs.getString("maHangSX");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCuoi;
	}
	public boolean delete(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete HangSanXuat where maHangSX = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				
			}
		}
		return n > 0;
	}
}