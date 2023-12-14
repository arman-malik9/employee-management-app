package Employee_Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Permanent_Employee implements Employee {
	
	
	public static final String EMPLOYEE_TYPE = "Permanent";
	

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
		 String empSalary = "100000" ; // have to fetch from the salary module.
	
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
		
		return  NumberOfrecord;
	}

	@Override
	public boolean modifyEmployee(int empID) throws SQLException {
		boolean res=false;
		Connection connection = Connect.getConnection();
		List<Integer> list = new ArrayList<>();
 		PreparedStatement ps = connection.prepareStatement("select empID from employeedata order by empID asc");
		ResultSet rs =  ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
		for(int i : list)
		{
			if(empID==i)
			{
				res = true;
				break;
//				PreparedStatement preparedStatement = connection.prepareStatement("update employeedata set ");
			}
			
		}
		
		//connection.close();
		
		return res;
	}

	@Override
	public int removeEmpoyee(int empID) throws SQLException {
		int remove=0;
		Connection connection = Connect.getConnection();
		List<Integer> list = new ArrayList<>();
 		PreparedStatement ps = connection.prepareStatement("select empID from employeedata order by empID asc");
		ResultSet rs =  ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
		for(int val : list)
		{
			if(empID==val)
			{
				PreparedStatement psmt = connection.prepareStatement("delete from employeedata where empId = "+empID);
				 remove = psmt.executeUpdate();
			}
			else {
				remove=0;
			}
		}
		return remove;
	}

	@Override
	public ResultSet showEmployee() throws SQLException {
	
		Connection connection = Connect.getConnection();
		PreparedStatement ps = connection.prepareStatement("Select * from employeedata");
		ResultSet rSet = ps.executeQuery();
		//connection.close();
		return rSet;
	}

}
