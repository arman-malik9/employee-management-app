package employeeManagementSystem;

import java.sql.*;

public class ConnectionClass {
    
    Connection con;
    Statement stm;
    public ConnectionClass() {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/employeeDetails","armanhcl","armanhcl");  
		stm=con.createStatement();  
		
		
	}
	catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
	new ConnectionClass();
    }
    

}
