package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectDB;
import entity.NhanVien;

public class TrangChu_DAO {
	public NhanVien getNhanVienSuDung(String id) {
		NhanVien nv =null;	
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select maNV,tenNV from NhanVien where tenTaiKhoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				nv = new NhanVien(maNV, tenNV);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nv;
	}
}
