package Employee_Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;  
import java.time.Period; 

public class GenerateOrgData {
	//Employee ID Generation method
	public static int gererateID() throws SQLException
	{
		
		ArrayList<Integer> list = new ArrayList<>();
		Connection connection = Connect.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select empID from employeedata order by empID asc");
		ResultSet rs =  ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
//		connection.close();
		return list.get(list.size()-1)+1;
	}
	
	//email ID generation method.
	public static String generateEmail(String firstName, String lastName, int empID)
	{
		String emailString ="";
		if(lastName.trim().equals(".") || lastName.trim().equals("") || lastName.equals(null)) 
			emailString = firstName.toLowerCase()+"_"+firstName.toLowerCase().charAt(0)+empID+"@hcl.com";
		else 
			emailString = firstName.toLowerCase()+"."+lastName.toLowerCase()+empID+"@hcl.com";
		return emailString;
	}
	
	//Employee Age calculation method
	public static int getAge(String dob)
	{
		LocalDate empDOB = LocalDate.parse(dob);
		LocalDate curDate = LocalDate.now(); 
		if ((dob != null) && (curDate != null))   
			return Period.between(empDOB, curDate).getYears();    
		else  
			return 0;  
	}

}
