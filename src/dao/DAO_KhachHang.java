package dao;
import entity.KhachHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connection.ConnectDB;
public class DAO_KhachHang {


	private KhachHang kh;

	public  ArrayList<KhachHang> getAllKH() {
		
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("maKH"));
				kh.setTenKH(rs.getString("tenKH"));
				kh.setNgaySinh(rs.getDate("ngaySinh"));
				kh.setDiaChi(rs.getString("diaChi"));
				kh.setsDT(rs.getString("sDT"));
				kh.setcCCD(rs.getString("cCCD"));
				kh.setGioiTinh(rs.getBoolean("gioiTinh"));
				dsKH.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	
	
	public String getMaKHCuoi() {
		
		String maCuoi = null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "select top 1 maKH from dbo.KhachHang order by maKH desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				maCuoi = rs.getString("maKH");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maCuoi;
	}
	
	public boolean create(KhachHang kh){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setDate(3, (Date) kh.getNgaySinh()); 
			stmt.setString(4, kh.getDiaChi()); 
			stmt.setString(5, kh.getsDT()); 
			stmt.setString(6, kh.getcCCD()); 
			stmt.setBoolean(7, kh.isGioiTinh()); 
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
	
	public boolean delete(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete KhachHang where maKH = ?");
			stmt.setString(1, ma);
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
	
	public boolean update(KhachHang kh){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenKH = ?, ngaySinh = ?, diaChi = ? , sDT = ?, cCCD = ?, gioiTinh = ? where maKH = ?");
			stmt.setString(1, kh.getTenKH());
			stmt.setDate(2, (Date) kh.getNgaySinh());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getsDT());
			stmt.setString(5, kh.getcCCD());
			stmt.setBoolean(6, kh.isGioiTinh());
			stmt.setString(7, kh.getMaKH());
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
	
public  KhachHang getKHtheoCCCD(String cccd) {
		KhachHang kh  = new KhachHang();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from KhachHang where cCCD = '"+cccd+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				
				kh.setMaKH(rs.getString("maKH"));
				kh.setTenKH(rs.getString("tenKH"));
				kh.setNgaySinh(rs.getDate("ngaySinh"));
				kh.setDiaChi(rs.getString("diaChi"));
				kh.setsDT(rs.getString("sDT"));
				kh.setcCCD(rs.getString("cCCD"));
				kh.setGioiTinh(rs.getBoolean("gioiTinh"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
public  KhachHang getKHtheoMaHopDong(String maHopDong) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();	
	PreparedStatement stmt = null;
	try {
		String sql = "select kh.maKH,tenKH,ngaySinh,diaChi,sDT,cCCD from KhachHang kh join HopDong hd on kh.maKH=hd.maKH where hd.maHopDong = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, maHopDong);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			KhachHang kh = new KhachHang();
			kh.setMaKH(rs.getString("maKH"));
			kh.setTenKH(rs.getString("tenKH"));
			kh.setNgaySinh(rs.getDate("ngaySinh"));
			kh.setDiaChi(rs.getString("diaChi"));
			kh.setsDT(rs.getString("sDT"));
			kh.setcCCD(rs.getString("cCCD"));			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return kh;
}
}
