package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {
	private NhanVien nv;
	public List<NhanVien> getAllNhanVien(){
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String tenNV = rs.getString("tenNV");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sDT");
				String cccd = rs.getString("cCCD");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String chucVu = rs.getString("chucVu");
				String tenTK = rs.getString("tenTaiKhoan");
				TaiKhoan tk = new TaiKhoan(tenTK, "123");
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, sdt, cccd, gioiTinh, chucVu, tk);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean createNVCoTK(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setDate(3, (java.sql.Date) nv.getNgaySinh());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getSoDT());
			stmt.setString(6, nv.getcCCD());
			stmt.setBoolean(7, nv.isGioiTinh());
			stmt.setString(8, nv.getChucVu());
			stmt.setString(9, nv.getTaiKhoan().getTenTaiKhoan());			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean delete(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete NhanVien where maNV = ?");
			stmt.setString(1, id);
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		 int n = 0;
		 try {
			 stmt = con.prepareStatement("update NhanVien set tenNV = ?, ngaySinh = ?, "
					 + "diaChi = ?, sDT = ?, cCCD = ?, gioiTinh = ?, chucVu = ?, tenTaiKhoan = ? where maNV = ?");
			 stmt.setString(1, nv.getTenNV());
			 stmt.setDate(2, (java.sql.Date) nv.getNgaySinh());
			 stmt.setString(3, nv.getDiaChi());
			 stmt.setString(4, nv.getSoDT());
			 stmt.setString(5, nv.getcCCD());
			 stmt.setBoolean(6, nv.isGioiTinh());
			 stmt.setString(7, nv.getChucVu());
			 stmt.setString(8, nv.getTaiKhoan().getTenTaiKhoan());
			 stmt.setString(9, nv.getMaNV());
			 n = stmt.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
public  NhanVien getNVtheoMaHopDong(String maHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select nv.maNV,tenNV,ngaySinh,diaChi,sDT,cCCD from NhanVien nv join HopDong hd on nv.maNV=hd.maNV where hd.maHopDong = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHopDong);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("maNV"));
				nv.setTenNV(rs.getString("tenNV"));
				nv.setDiaChi(rs.getString("diaChi"));
				nv.setSoDT(rs.getString("sDT"));
				nv.setcCCD(rs.getString("cCCD"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setChucVu(rs.getString("chucVu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
}
