package Employee_Module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//This is the Basic Abstract Class Structure that is required for Employee Module.
public interface Employee {

	double salary();
	int addEmployee(List<String> list) throws SQLException;
	boolean modifyEmployee(int empID) throws SQLException;
	boolean removeEmpoyee(int empID) throws SQLException;
	ResultSet showEmployee() throws SQLException;

}
