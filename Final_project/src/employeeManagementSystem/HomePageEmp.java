package employeeManagementSystem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Employee_Module.Connect;
import Employee_Module.ViewEmployeeData;
import benefitsBox.ApplyReimb;
import benefitsBox.BenefitsMenu;
import benefitsBox.CancelReimb;
import benefitsBox.ClaimMed;

import benefitsBox.ViewReimbSingle;


import java.sql.*;


public class HomePageEmp extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4;
	Font f, f1, f2;
	JPanel p1;
	JPanel jPanel;
	static int empid;

	
	public static void setID(int id)
	{
		empid = id;
	}

	
	

	public HomePageEmp(String s1, String s2) {
		
		

		super("Employee Home Page");
		setLocation(0, 0);
		setSize(2000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		JMenuBar m1= new JMenuBar();
		m1.setSize(500, 100);
		JMenu menu1= new JMenu("Profile");
//		JMenuItem ment1= new JMenuItem("Add profile");
		JMenuItem ment2 = new JMenuItem("View Profile");


//		JMenu menu2= new JMenu("Manage");
//		JMenuItem ment3= new JMenuItem("Manage");
//		JMenuItem ment4 = new JMenuItem("Delete Profile");


		JMenu menu3= new JMenu("Salary");
//		JMenuItem ment5= new JMenuItem("Add Salary");
		JMenuItem ment6= new JMenuItem("View Salary");
		JMenuItem ment7= new JMenuItem("Generate Payslip");


		JMenu menu4= new JMenu("Benefits");
		JMenuItem ment8= new JMenuItem("Apply for New Reimbursement");
		JMenuItem ment9= new JMenuItem("View My Reimbursements");
		JMenuItem ment10= new JMenuItem("Cancel My Reimbursement Application");
		JMenuItem ment11= new JMenuItem("Claim for Medical Facilities");
		//JMenuItem ment8 = new JMenuItem("Delete Profile");


		JMenu menu5= new JMenu("Attendance");
		JMenuItem ment12= new JMenuItem("Add Attendance");
		JMenuItem ment13= new JMenuItem("View Attendance");
		
		JMenu menu6= new JMenu("Download Report");
		JMenuItem ment14= new JMenuItem("Employees Details");
		JMenuItem ment15= new JMenuItem("Salary Details");
		JMenuItem ment16= new JMenuItem("Timesheet Details");
		JMenuItem ment17= new JMenuItem("Benefits Details");
		

//		menu1.add(ment1);
		menu1.add(ment2);

//		menu2.add(ment3);
//		menu2.add(ment4);

//		menu3.add(ment5);
		menu3.add(ment6);
		menu3.add(ment7);
		
		menu4.add(ment8);
		menu4.add(ment9);
		menu4.add(ment10);
		menu4.add(ment11);

		menu5.add(ment12);
		menu5.add(ment13);
		
		menu6.add(ment14);
		menu6.add(ment15);
		menu6.add(ment16);
		menu6.add(ment17);



		m1.add(menu1);
//		m1.add(menu2);
		m1.add(menu3);
		m1.add(menu4);
		m1.add(menu5);
		m1.add(menu6);

		m1.setBackground(Color.GRAY);
		menu1.setForeground(Color.black);
//		menu2.setForeground(Color.black);
		menu3.setForeground(Color.black);
		menu4.setForeground(Color.black);
		menu5.setForeground(Color.black);
		menu6.setForeground(Color.black);


//		ment1.setBackground(Color.black);
//		ment1.setForeground(Color.gray);
		ment2.setBackground(Color.black);
		ment2.setForeground(Color.gray);
//		ment3.setBackground(Color.black);
//		ment3.setForeground(Color.gray);
//		ment4.setBackground(Color.black);
//		ment4.setForeground(Color.gray);
//		ment5.setBackground(Color.black);
//		ment5.setForeground(Color.gray);
		ment6.setBackground(Color.black);
		ment6.setForeground(Color.gray);
		ment7.setBackground(Color.black);
		ment7.setForeground(Color.gray);
		ment8.setBackground(Color.black);
		ment8.setForeground(Color.gray);
		ment9.setBackground(Color.black);
		ment9.setForeground(Color.gray);
		ment10.setBackground(Color.black);
		ment10.setForeground(Color.gray);
		ment11.setBackground(Color.black);
		ment11.setForeground(Color.gray);
		ment12.setBackground(Color.black);
		ment12.setForeground(Color.gray);
		ment13.setBackground(Color.black);
		ment13.setForeground(Color.gray);
		ment14.setBackground(Color.black);
		ment14.setForeground(Color.gray);
		ment15.setBackground(Color.black);
		ment15.setForeground(Color.gray);
		ment16.setBackground(Color.black);
		ment16.setForeground(Color.gray);
		ment17.setBackground(Color.black);
		ment17.setForeground(Color.gray);


		


		setJMenuBar(m1);
		
//		ment1.addActionListener(this);
		ment2.addActionListener(this);
//		ment3.addActionListener(this);
//		ment4.addActionListener(this);
//		ment5.addActionListener(this);
		ment6.addActionListener(this);
		ment7.addActionListener(this);
		ment8.addActionListener(this);
		ment9.addActionListener(this); 
		ment10.addActionListener(this);
		ment11.addActionListener(this);
		ment12.addActionListener(this);
		ment13.addActionListener(this);
		ment14.addActionListener(this);
		ment15.addActionListener(this);
		ment16.addActionListener(this);
		ment17.addActionListener(this);
		
		
		
		Container c=getContentPane();
        JPanel panel=new JPanel();
        panel.setLayout(null);
        Font font = new Font("Bold",100,50);
        JLabel label=new JLabel("Welcome "+s1+" "+ s2);
        label.setBounds(400,100,1000,100);
        label.setFont(font);
        panel.add(label);
        panel.setBackground(Color.WHITE);
        panel.setBounds(100,50,300,200);
        c.add(panel);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command =e.getActionCommand();
//		if(command.equals("Add profile")) {
//			new AddEmployee();
//			//System.out.println("complete");
//		}
		if(command.equals("View Profile")) {
			new ViewEmployeeData(empid);
			
		}
		if(command.equals("Manage")) {
			
		}
//		if(command.equals("Delete Profile")) {
//			new DeleteEmployee().setVisible(true);
//
//		}

		if(command.equals("Apply for New Reimbursement")) {
			ApplyReimb frame = new ApplyReimb(empid);
			frame.setVisible(true);

		}
		
		if(command.equals("View My Reimbursements")) {
			ViewReimbSingle frame = new ViewReimbSingle(empid);
			frame.setVisible(true);

		}
		
		if(command.equals("Cancel My Reimbursement Application")) {
			CancelReimb frame = new CancelReimb(empid);
			frame.setVisible(true);

		}
		
		if(command.equals("Claim for Medical Facilities")) {
			ClaimMed frame = new ClaimMed(empid);
			frame.setVisible(true);

		}
		
		if(command.equals("Add Attendance")) {
			new Employee_Attendance(empid).setVisible(true);

		}
		if(command.equals("View Attendance")) {
		new View_Attandance_single(empid);
			//ob.setVisible(true);
			
			

		}
		if(command.equals("Add Salary")) {
			new EmployeeDetail().setVisible(true);
			

		}
		if(command.equals("View Salary")) {
			new SalaryCalculation(empid);
			

		}
		if(command.equals("Generate Payslip")) {
			new PaySlip_Emp(empid).setVisible(true);
		}
		
		if(command.equals("Employees Details")) {
			new EmployeeReport(empid);
		}
		
		if(command.equals("Salary Details")) {
			new SalaryReport(empid);
		}
		
		if(command.equals("Timesheet Details")) {
			new TimesheetReport(empid);
		}
		
		if(command.equals("Benefits Details")) {
			new BenefitsReport(empid);
		}
		
	}
	
}
