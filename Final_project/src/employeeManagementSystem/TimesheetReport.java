package employeeManagementSystem;
 
import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.*;
 
public class TimesheetReport {
     
    public TimesheetReport() {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "TimesheetDetails.xlsx";
 
        try  {
        	
            String sql = "select * from attendence";
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("TimesheetDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Name");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Email");
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("First Half");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Second Half");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Date");
 
            int rowCount = 1;
            
            while (result.next()) {
                int empId = result.getInt("eid");
                String Name = result.getString("name");
                String Email = result.getString("email");
                String firstHalf = result.getString("first_half");
                String secondHalf = result.getString("second_half");
                String Date = result.getString("day_date");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(Name);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(Email);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(firstHalf);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(secondHalf);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(Date);
     
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
    
    public TimesheetReport(int empId) {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "EmpTimesheetDetails.xlsx";
 
        try  {
        	
            String sql = "select * from attendence where eid="+empId;
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("TimesheetDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Name");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Email");
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("First Half");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Second Half");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Date");
 
            int rowCount = 1;
            
            while (result.next()) {
                String name = result.getString("name");
                String Email = result.getString("email");
                String firstHalf = result.getString("first_half");
                String secondHalf = result.getString("second_half");
                String Date = result.getString("day_date");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(name);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(Email);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(firstHalf);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(secondHalf);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(Date);
     
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