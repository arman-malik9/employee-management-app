package employeeManagementSystem;
 
import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.*;
 
public class EmployeeReport {
     
    public EmployeeReport() {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "EmployeeDetails.xlsx";
 
        try  {
        	
            String sql = "select * from employeedata";
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("EmployeeDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("First Name");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Last Name");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Email");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Employee Type");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Phone");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Joining Date");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Salary");
            
            headerCell = headerRow.createCell(8);
            headerCell.setCellValue("Gender");
            
            headerCell = headerRow.createCell(9);
            headerCell.setCellValue("DOB");
            
            headerCell = headerRow.createCell(10);
            headerCell.setCellValue("Age");
 
            int rowCount = 1;
            
            while (result.next()) {
                int empId = result.getInt("empId");
                String firstName = result.getString("EmpFirstName");
                String lastName = result.getString("EmpLastName");
                String empEmail = result.getString("EmpEmail");
                String empType = result.getString("EmpType");
                String empPhone = result.getString("EmpPhone");
                String empJoiningDate = result.getString("EmpJoiningDate");
                String empSalary = result.getString("EmpSalary");
                String empGender = result.getString("empGender");
                String empdob = result.getString("empdob");
                int age = result.getInt("age");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(firstName);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(lastName);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(empEmail);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(empType);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empPhone);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empJoiningDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empSalary);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empGender);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empdob);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(age);
     
            }
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            JOptionPane.showMessageDialog(null, "Download Successfull");
 
//            obj.stm.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
    
    public EmployeeReport(int empId) {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "EmployeeDetails1.xlsx";
 
        try  {
        	
            String sql = "select * from employeedata where EmpID="+empId;
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("EmployeeDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("First Name");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Last Name");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Email");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Employee Type");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Phone");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Joining Date");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Salary");
            
            headerCell = headerRow.createCell(8);
            headerCell.setCellValue("Gender");
            
            headerCell = headerRow.createCell(9);
            headerCell.setCellValue("DOB");
            
            headerCell = headerRow.createCell(10);
            headerCell.setCellValue("Age");
 
            int rowCount = 1;
            
            while (result.next()) {
//                int empId = result.getInt("empId");
                String firstName = result.getString("EmpFirstName");
                String lastName = result.getString("EmpLastName");
                String empEmail = result.getString("EmpEmail");
                String empType = result.getString("EmpType");
                String empPhone = result.getString("EmpPhone");
                String empJoiningDate = result.getString("EmpJoiningDate");
                String empSalary = result.getString("EmpSalary");
                String empGender = result.getString("empGender");
                String empdob = result.getString("empdob");
                int age = result.getInt("age");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(firstName);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(lastName);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(empEmail);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(empType);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empPhone);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empJoiningDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empSalary);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empGender);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(empdob);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(age);
     
            }
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            JOptionPane.showMessageDialog(null, "Download Successfull");
 
//            obj.stm.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
}