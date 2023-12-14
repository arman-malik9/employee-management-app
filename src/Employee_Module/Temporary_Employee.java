package Employee_Module;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Temporary_Employee implements Employee {
	public static final String EMPLOYEE_TYPE = "Temporary";
	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addEmployee(List<String> list) throws SQLException {
		int i=-1;
		int NumberOfrecord =0;
		 String empFirstName = list.get(++i);
		 String empLastName = list.get(++i);
		 String dob = list.get(++i);
		 String empPhone = list.get(++i);
		 String empJoiningDate = list.get(++i);
		 String gender  = list.get(++i);
		 int empID = GenerateOrgData.gererateID();
		 String empEmail = GenerateOrgData.generateEmail(empFirstName, empLastName, empID);
		 String empType = EMPLOYEE_TYPE;
		 int age = GenerateOrgData.getAge(dob);
		 String empSalary = "250000" ; // have to fetch from the salary module.
		
		Connection connection = Connect.getConnection();
		try {
			PreparedStatement psmt = connection.prepareStatement("insert into employeedata values(?,?,?,?,?,?,?,?,?,?,?)");
			psmt.setInt(1, empID);
			psmt.setString(2, empFirstName);
			psmt.setString(3, empLastName);
			psmt.setString(4, empEmail);
			psmt.setString(5, empType);
			psmt.setString(6, empPhone);
			psmt.setString(7, empJoiningDate);
			psmt.setString(8, empSalary);
			psmt.setString(9, gender);
			psmt.setString(10, dob);
			psmt.setInt(11, age);
			
			 NumberOfrecord = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally
//		{
//			connection.close();
//		}
		return  NumberOfrecord;
	}

	@Override
	public boolean modifyEmployee(int empId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmpoyee(int empID) {
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet showEmployee() {
		return null;
		// TODO Auto-generated method stub
		
	}

}
