package employeeManagementSystem;
 
import java.io.*;
import java.sql.*;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.*;
 
public class BenefitsReport {
     
    public BenefitsReport() {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "BenefitsDetails.xlsx";
 
        try  {
        	
            String sql = "select * from benefits";
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("BenefitsDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Service");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Service Provider/Hospital Name");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Bill Number");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Bill Date");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Submitted Date");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Total Bill Amount");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Insurance Coverage");
 
            int rowCount = 1;
            
            while (result.next()) {
                int empId = result.getInt("EmpId");
                String Service = result.getString("Service");
                String ServiceProvider = result.getString("ServiceProvider");
                String BillNo = result.getString("BillNo");
                String BillDate = result.getString("BillDate");
                String AppliedDate = result.getString("AppliedDate");
                String BillAmount = result.getString("BillAmount");
                String InsuranceCoverage = result.getString("InsuranceCoverage");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(Service);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(ServiceProvider);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillNo);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(AppliedDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillAmount);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(InsuranceCoverage);
     
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
    
    public BenefitsReport(int empId) {
    	ConnectionClass obj=new ConnectionClass();
 
        String excelFilePath = "EmpBenefitsDetails.xlsx";
 
        try  {
        	
            String sql = "select * from benefits where EmpID="+empId;
            ResultSet result = obj.stm.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("BenefitsDetails");
            XSSFRow headerRow = sheet.createRow(0);
            
            XSSFCell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Employee ID");
     
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Service");
     
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Service Provider/Hospital Name");
     
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Bill Number");
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Bill Date");
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Submitted Date");
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Total Bill Amount");
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Insurance Coverage");
 
            int rowCount = 1;
            
            while (result.next()) {
                String Service = result.getString("Service");
                String ServiceProvider = result.getString("ServiceProvider");
                String BillNo = result.getString("BillNo");
                String BillDate = result.getString("BillDate");
                String AppliedDate = result.getString("AppliedDate");
                String BillAmount = result.getString("BillAmount");
                String InsuranceCoverage = result.getString("InsuranceCoverage");
     
                XSSFRow row = sheet.createRow(rowCount++);
     
                int columnCount = 0;
                XSSFCell cell = row.createCell(columnCount++);
                cell.setCellValue(empId);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(Service);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(ServiceProvider);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillNo);
     
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(AppliedDate);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(BillAmount);
                
                cell = row.createCell(columnCount);
                cell.setCellValue(InsuranceCoverage);
     
            }
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            obj.stm.close();
            
            JOptionPane.showMessageDialog(null, "Download Successfull");
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
}