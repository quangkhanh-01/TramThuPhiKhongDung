package restman25.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO424 {
	protected static Connection conn;
	public DAO424() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restman", "root", "admin");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
}
