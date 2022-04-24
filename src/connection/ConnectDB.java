package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();	
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {				
			String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyG63";
			String user = "sa";
<<<<<<< HEAD

			String password = "sapass";

=======
			String password = "1";
>>>>>>> 6c2815586de3ccff80aca0a72c8750959810ec15
			con = DriverManager.getConnection(url, user, password);		
	}
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {	e.printStackTrace();			}
	}
	public static Connection getConnection() {
		return con;
	}

}
