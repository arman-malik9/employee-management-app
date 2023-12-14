package employeeManagementSystem;
 
import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.*;
 
public class SalaryReport {
     
    public SalaryReport() {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "SalaryDetails.xlsx";
 
        try  {
        	
            String sql = "select * from salary1";
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("SalaryDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Basic Salary");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("HRA");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("HA");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Food Wallet");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Pf");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Month");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Year");
 
            int rowCount = 1;
            
            while (result.next()) {
                int empId = result.getInt("empId");
                float basicSalary = result.getFloat("Basic_salary");
                Float HRA = result.getFloat("HRA");
                Float HA = result.getFloat("HA");
                Float foodWallet = result.getFloat("Food_wallet");
                Float PF = result.getFloat("PF");
                String Month = result.getString("Month");
                String year = result.getString("year");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(basicSalary);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(HRA);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(HA);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(foodWallet);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(PF);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(Month);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(year);
     
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
    
    public SalaryReport(int empId) {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "EmpSalaryDetails.xlsx";
 
        try  {
        	
            String sql = "select * from salary1 where EmpID="+empId;
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("SalaryDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Basic Salary");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("HRA");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("HA");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Food Wallet");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Pf");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Month");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Year");
 
            int rowCount = 1;
            
            while (result.next()) {
                float basicSalary = result.getFloat("Basic_salary");
                float HRA = result.getFloat("HRA");
                float HA = result.getFloat("HA");
                float foodWallet = result.getFloat("Food_wallet");
                float PF = result.getFloat("PF");
                String Month = result.getString("Month");
                String year = result.getString("year");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(basicSalary);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(HRA);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(HA);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(foodWallet);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(PF);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(Month);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(year);
     
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