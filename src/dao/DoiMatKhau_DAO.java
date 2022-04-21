package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectDB;
import entity.TaiKhoan;

public class DoiMatKhau_DAO {
	public TaiKhoan getTaiKhoanTheoTenTaiKhoan(String tenTK) {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select tk.tenTaiKhoan,matKhau\r\n" + 
					"from NhanVien nv join TaiKhoan tk on nv.tenTaiKhoan = tk.tenTaiKhoan\r\n" + 
					"where nv.tenTaiKhoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTK);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan(rs.getString(1), rs.getString(2));
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
		return tk;
	}
}
