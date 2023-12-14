package Employee_Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	static Connection con = null;
	private Connect() {}
	public static Connection getConnection() {
		if(con==null)
		{
		//Class.forName("com.mysql.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDetails","armanhcl","armanhcl");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		  }
		}	
		return con;
	}
}
