package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;

public class DAO_ThongKe {
	public ArrayList<Object> thongKeTheoNgay(java.util.Date ngay){
		
		ArrayList<Object> dsThongKe = new ArrayList<Object>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "SELECT HoaDon.maHopDong, HoaDon.maHoaDon, Xe.maXe, KhachHang.tenKH, NhanVien.tenNV, Xe.tenXe, HoaDon.donGia\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  HopDong ON HoaDon.maHopDong = HopDong.maHopDong INNER JOIN\r\n"
					+ "                  NhanVien ON HopDong.maNV = NhanVien.maNV INNER JOIN\r\n"
					+ "                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n"
					+ "                  KhachHang ON HopDong.maKH = KhachHang.maKH\r\n"
					+ "where ngayLapHoaDon = "+"'"+ngay+"'";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHopDong");
				String maHoaDon = rs.getString("maHoaDon");
				String maXe = rs.getString("maXe");
				String tenKhachHang = rs.getString("tenKH");
				String tenNhanVien = rs.getString("tenNV");
				String tenXe = rs.getString("tenXe");
				Double giaXe = rs.getDouble("donGia");
				String[] temp = {maHD,maHoaDon,maXe,tenKhachHang,tenNhanVien,tenXe,String.valueOf(giaXe)};
				dsThongKe.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKe;
	}
	
	
	public ArrayList<Object> thongKeTheoKhoang(java.util.Date tuNgay, java.util.Date denNgay){
		
		ArrayList<Object> dsThongKe = new ArrayList<Object>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "SELECT HoaDon.maHopDong, HoaDon.maHoaDon, Xe.maXe, KhachHang.tenKH, NhanVien.tenNV, Xe.tenXe, HoaDon.donGia\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  HopDong ON HoaDon.maHopDong = HopDong.maHopDong INNER JOIN\r\n"
					+ "                  NhanVien ON HopDong.maNV = NhanVien.maNV INNER JOIN\r\n"
					+ "                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n"
					+ "                  KhachHang ON HopDong.maKH = KhachHang.maKH\r\n"
					+ "where  ngayLapHoaDon between "+"'"+tuNgay+"' and "+"'"+denNgay+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHopDong");
				String maHoaDon = rs.getString("maHoaDon");
				String maXe = rs.getString("maXe");
				String tenKhachHang = rs.getString("tenKH");
				String tenNhanVien = rs.getString("tenNV");
				String tenXe = rs.getString("tenXe");
				Double giaXe = rs.getDouble("donGia");
				String[] temp = {maHD,maHoaDon,maXe,tenKhachHang,tenNhanVien,tenXe,String.valueOf(giaXe)};
				dsThongKe.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKe;
	}
	
	
	public ArrayList<Object> thongKeTheoThang(int thang, int nam){
		
		ArrayList<Object> dsThongKe = new ArrayList<Object>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "SELECT HoaDon.maHopDong, HoaDon.maHoaDon, Xe.maXe, KhachHang.tenKH, NhanVien.tenNV, Xe.tenXe, HoaDon.donGia\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  HopDong ON HoaDon.maHopDong = HopDong.maHopDong INNER JOIN\r\n"
					+ "                  NhanVien ON HopDong.maNV = NhanVien.maNV INNER JOIN\r\n"
					+ "                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n"
					+ "                  KhachHang ON HopDong.maKH = KhachHang.maKH\r\n"
					+ "where MONTH(ngayLapHoaDon) ="+thang+ "and YEAR(ngayLapHoaDon) ="+nam;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHopDong");
				String maHoaDon = rs.getString("maHoaDon");
				String maXe = rs.getString("maXe");
				String tenKhachHang = rs.getString("tenKH");
				String tenNhanVien = rs.getString("tenNV");
				String tenXe = rs.getString("tenXe");
				Double giaXe = rs.getDouble("donGia");
				String[] temp = {maHD,maHoaDon,maXe,tenKhachHang,tenNhanVien,tenXe,String.valueOf(giaXe)};
				dsThongKe.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKe;
	}
	
	
	public ArrayList<Object> thongKeTheoNam(int nam){
		
		ArrayList<Object> dsThongKe = new ArrayList<Object>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "SELECT HoaDon.maHopDong, HoaDon.maHoaDon, Xe.maXe, KhachHang.tenKH, NhanVien.tenNV, Xe.tenXe, HoaDon.donGia\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  HopDong ON HoaDon.maHopDong = HopDong.maHopDong INNER JOIN\r\n"
					+ "                  NhanVien ON HopDong.maNV = NhanVien.maNV INNER JOIN\r\n"
					+ "                  Xe ON HopDong.maXe = Xe.maXe INNER JOIN\r\n"
					+ "                  KhachHang ON HopDong.maKH = KhachHang.maKH\r\n"
					+ "where YEAR(ngayLapHoaDon) ="+nam;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHopDong");
				String maHoaDon = rs.getString("maHoaDon");
				String maXe = rs.getString("maXe");
				String tenKhachHang = rs.getString("tenKH");
				String tenNhanVien = rs.getString("tenNV");
				String tenXe = rs.getString("tenXe");
				Double giaXe = rs.getDouble("donGia");
				String[] temp = {maHD,maHoaDon,maXe,tenKhachHang,tenNhanVien,tenXe,String.valueOf(giaXe)};
				dsThongKe.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKe;
	}

	
	
}
