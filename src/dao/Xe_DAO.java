package dao;

import java.sql.Connection;

import java.sql.Date;

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
	
	public boolean themDanhSachXe(Xe xe) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into Xe values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, xe.getMaXe());
			stmt.setString(2, xe.getTenXe());
			stmt.setString(3, xe.getMauXe());
			stmt.setString(4, xe.getSoKhung());
			stmt.setString(5, xe.getSoMay());
			stmt.setString(6, xe.getNhaCungCap());
			stmt.setString(7, xe.getHangSanXuat().getMaHangSX());
			stmt.setString(8, xe.getLoaiXe().getMaLoaiXe());
			stmt.setDouble(9, xe.getGiaXe());
			stmt.setString(10, xe.getTrangThai());

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
	public String getMaXeCuoi() {
		
		String maCuoi = null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "select top 1 maXe from dbo.Xe order by maXe desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maCuoi = rs.getString("maXe");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCuoi;
	}
	public boolean suaThongTinXe(Xe xe) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("update Xe set tenXe=?, mauXe = ?, soKhung=?, soMay=?, nhaCungCap=?, maHangSX=?, maLoaiXe=?, giaXe=?, trangThai=? where maXe=?");

			
			stmt.setString(1, xe.getTenXe());
			stmt.setString(2, xe.getMauXe());
			stmt.setString(3, xe.getSoKhung());
			stmt.setString(4, xe.getSoMay());
			stmt.setString(5, xe.getNhaCungCap());
			stmt.setString(6, xe.getHangSanXuat().getMaHangSX());
			stmt.setString(7, xe.getLoaiXe().getMaLoaiXe());
			stmt.setDouble(8, xe.getGiaXe());
			stmt.setString(9, xe.getTrangThai());
			stmt.setString(10, xe.getMaXe());

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
	
	public boolean xoaXe(String ma) throws SQLException {

		Connection con= ConnectDB.getConnection();
		String sql = "delete Xe where maXe = '"+ma+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}

	
	public String getMaXe() {
		String maXe="";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('X', RIGHT(CONCAT('0000',ISNULL(right(max(maXe),3),0) + 1),4)) from [dbo].[Xe] where maXe like 'X%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				maXe = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return maXe;
	}
	
	
	public ArrayList<Xe> getDanhSachXe(){
		ArrayList<Xe> lsXe = new ArrayList<Xe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		String sql = "Select * from Xe where not trangThai = N'Đã bán'";	
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

	
	public Xe getGiaXeTheoMa(String ma) {
		Xe xe = new Xe();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql ="  select * from Xe where maXe = '"+ma+"'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {

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

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return xe;
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

				xe.setTrangThai(rs.getString(10));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return xe;
	}
	
	public ArrayList<Xe> sortByGia() {

		ArrayList<Xe> lsXe = new ArrayList<Xe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		String sql = "select *from Xe where not trangThai = N'Đã bán' order by giaXe desc";	
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
	
	public ArrayList<Xe> sortByGiaTangDan() {

		ArrayList<Xe> lsXe = new ArrayList<Xe>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		String sql = "select *from Xe where not trangThai = N'Đã bán' order by giaXe asc";	
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
	

	
	public boolean update(String ma, String trangthai){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update Xe set trangThai = '"+trangthai+"' where maXe = N'"+ma+"'");

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
