package Employee_Module;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class AdminScreen {
	
	JFrame f, f2;
	JLabel jtextJLabel, jempID;
	JButton addPermanentEmp, addTemporaryEmp, updateButton, removeButton,displayButton;
	JPanel leftJPanel, rightJPanel, updatePanel, removeJPanel,displayPanel;
	JTable jTable;
	JTextField jempField,jempField2;
	
	JButton searchButton, removeInfoButton;
	JLabel headerLabel,LfirstName, LlastName, Ldob, Lphone, LjoiningDate,Lsalary, Lgender, LempType;
	JTextField firstName, lastName, dob, phone, joiningDate,salary, empType;
	JButton updateBtn, cancelBtn;
	
	public void adminScreen()
	{
		f = new JFrame("Employee Management System");
		f.setBounds(0,0,2000,1000);
		Container c = f.getContentPane();
		c.setLayout(null);
		Font font = new Font("Bold",20,20);
		
		leftJPanel = new JPanel();
		leftJPanel.setBounds(0,0,350,1000);
		leftJPanel.setBackground(Color.DARK_GRAY);
		leftJPanel.setLayout(null);
		c.add(leftJPanel);
		
		
		jtextJLabel = new JLabel("Admin Page");
		jtextJLabel.setBounds(80, 50, 200, 30);
		jtextJLabel.setFont(font);
		jtextJLabel.setForeground(Color.white);
		leftJPanel.add(jtextJLabel);
		
		addPermanentEmp = new JButton("Add Permanent Employee");
		addPermanentEmp.setBounds(50, 100, 200, 30);
		leftJPanel.add(addPermanentEmp);
		
		addTemporaryEmp = new JButton("Add Temporary Employee");
		addTemporaryEmp.setBounds(50, 150, 200, 30);
		leftJPanel.add(addTemporaryEmp);
		
		updateButton = new JButton("Update Employee Details");
		updateButton.setBounds(50, 200, 200, 30);
		leftJPanel.add(updateButton);
		
		removeButton = new JButton("Remove Employee Details");
		removeButton.setBounds(50, 250, 200, 30);
		leftJPanel.add(removeButton);
		
		displayButton = new JButton("Display All Employee Details");
		displayButton.setBounds(50, 300, 200, 30);
		leftJPanel.add(displayButton);
		
		
		rightJPanel = new JPanel();
		rightJPanel.setBounds(350,0,1650,1000);
		rightJPanel.setBackground(Color.gray);
		rightJPanel.setLayout(null);
		c.add(rightJPanel);
		rightJPanel.setVisible(true);
		
		
		updatePanel = new JPanel();
		updatePanel.setBounds(350,0,1650,1000);
		updatePanel.setBackground(Color.gray);
		updatePanel.setLayout(null);
		c.add(updatePanel);
		updatePanel.setVisible(false);
		
		jempID = new JLabel("Enter the Employee ID");
		jempID.setBounds(100, 50, 200, 30);
		jempID.setFont(font);
		updatePanel.add(jempID);
		jempID.setVisible(true);
		
		jempField = new JTextField();
		jempField.setBounds(350, 50, 200, 30);
		updatePanel.add(jempField);
		jempField.setVisible(true);
		
		searchButton = new JButton("Search"); 
		searchButton.setBounds(600, 50, 100, 30);
		updatePanel.add(searchButton);
		
		LfirstName = new JLabel("First Name : ");
		LfirstName.setBounds(200, 200, 100, 30);
		Font f2 = new Font("Arial",Font.BOLD,15);
		LfirstName.setFont(f2);
		updatePanel.add(LfirstName);
		
		firstName = new JTextField();   
		firstName.setBounds(450, 200,150, 30);
		updatePanel.add(firstName);
		
		
		LlastName = new JLabel("Last Name : ");
		LlastName.setBounds(200, 250, 100, 30);
		LlastName.setFont(f2);
		updatePanel.add(LlastName);
		
		lastName = new JTextField();
		lastName.setBounds(450, 250,150, 30);
		updatePanel.add(lastName);
		
		Ldob = new JLabel("Date of Birth (YYYY-MM-DD) : ");
		Ldob.setBounds(200, 300, 250, 30);
		Ldob.setFont(f2);
		updatePanel.add(Ldob);
		
		dob = new JTextField();
		dob.setBounds(450, 300,150, 30);
		updatePanel.add(dob);
		
		Lphone = new JLabel("Phone : ");
		Lphone.setBounds(200, 350, 250, 30);
		Lphone.setFont(f2);
		updatePanel.add(Lphone);
		
		phone = new JTextField();
		phone.setBounds(450, 350,150, 30);
		updatePanel.add(phone);
		
		LjoiningDate = new JLabel("Joining Date (YYYY-MM-DD) : ");
		LjoiningDate.setBounds(200, 400, 250, 30);
		LjoiningDate.setFont(f2);
		updatePanel.add(LjoiningDate);
		
		joiningDate = new JTextField();
		joiningDate.setBounds(450, 400,150, 30);
		updatePanel.add(joiningDate);
		
		
	
		updateBtn = new JButton("Update");
		updateBtn.setBounds(250, 450, 100, 30);
		updatePanel.add(updateBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(360, 450, 100, 30);	
		updatePanel.add(cancelBtn);
		
		
		removeJPanel = new JPanel();
		removeJPanel.setBounds(350,0,1650,1000);
		removeJPanel.setBackground(Color.gray);
		removeJPanel.setLayout(null);
		c.add(removeJPanel);
		removeJPanel.setVisible(false);
		
		
		jempID = new JLabel("Enter the Employee ID");
		jempID.setBounds(100, 50, 200, 30);
		jempID.setFont(font);
		removeJPanel.add(jempID);
		jempID.setVisible(true);
		
		jempField2 = new JTextField();
		jempField2.setBounds(350, 50, 200, 30);
		removeJPanel.add(jempField2);
		jempField2.setVisible(true);
		
		removeInfoButton = new JButton("Remove"); 
		removeInfoButton.setBounds(600, 50, 100, 30);
		removeJPanel.add(removeInfoButton);
		
		
		displayPanel = new JPanel();
		displayPanel.setBounds(350,0,1650,1000);
		displayPanel.setBackground(Color.gray);
		displayPanel.setLayout(null);
		c.add(displayPanel);
		displayPanel.setVisible(false);
		

		 
		addPermanentEmp.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Add Permanent Employee"))
			{
				new NewRegisteration("Permanent").registerEmployee();
			}	
		}
	});
		addTemporaryEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Add Temporary Employee"))
				{
					new NewRegisteration("Temporary").registerEmployee();
					
				}	
			}
		});
		
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Update Employee Details"))
				{
					rightJPanel.setVisible(false);
					removeJPanel.setVisible(false);
					displayPanel.setVisible(false);
					updatePanel.setVisible(true);
					
				}	
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Remove Employee Details"))
				{
					
					rightJPanel.setVisible(false);
					removeJPanel.setVisible(true);
					displayPanel.setVisible(false);
					updatePanel.setVisible(false);
					jempField2.setText(null);
					
				}	
			}
		});
		
		
		
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Display All Employee Details"))
				{
					
				
				rightJPanel.setVisible(false);
				removeJPanel.setVisible(false);
				displayPanel.setVisible(true);
				new ViewEmployeeDetails().setVisible(true);
				updatePanel.setVisible(false);
				}	
			}
		});
		
		
		removeInfoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Remove"))
				{
					boolean result;
					int val = Integer.parseInt(jempField2.getText().trim());
					try {
						//result = JOptionPane.showConfirmDialog(c, "Do You Want to delete?", "alert", JOptionPane.OK_CANCEL_OPTION);
						 result = new Permanent_Employee().removeEmpoyee(val);
						String str = "Deleted Succesfully!";
						
						if(result)
							JOptionPane.showMessageDialog(null,str);
						else {
							JOptionPane.showMessageDialog(null,"Employee does not exist, Cannnot Delete!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Search"))
				{
					Permanent_Employee ob = new Permanent_Employee();
					int eid = Integer.parseInt(jempField.getText());
				try {
					Boolean flag =	ob.modifyEmployee(eid);
					
					
					if(flag)
					{
						Connection connection = Connect.getConnection();
						PreparedStatement psmt = connection.prepareStatement("Select * from employeedata where empid = "+eid);
						ResultSet set = psmt.executeQuery();
						while(set.next()) 
						{
							firstName.setText(set.getString("EmpFirstName"));
							lastName.setText(set.getString("EmpLastName"));
							dob.setText(set.getString("empdob"));
							phone.setText(set.getString("empPhone"));
							joiningDate.setText(set.getString("empJoiningDate"));
						}
								
					}
					else {
						JOptionPane.showMessageDialog(null,"Employee does not exist !");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
					
				}	
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Update"))
				{
					int nID = Integer.parseInt(jempField.getText());
					String fname = firstName.getText();
					String  lName= lastName.getText();
					String dobStr=dob.getText();
					String phoneStr=phone.getText();
					String joinDate=joiningDate.getText();
					String newEmail = GenerateOrgData.generateEmail(fname, lName, nID);
					int nAge = GenerateOrgData.getAge(dobStr);
					System.out.println(nAge);
				try {
						Connection connection = Connect.getConnection();
						System.out.println("con");
						String q ="update employeedata set EmpFirstName = '"+fname+"', EmpLastName = '"+lName+"', empdob = '"+dobStr+"', empPhone = '"+phoneStr+"', empJoiningDate = '"+joinDate+"', empemail = '"+newEmail+"', age = '"+nAge+"' where empID ='"+nID+"'";
						System.out.println("q");
						PreparedStatement psmt = connection.prepareStatement(q);
						System.out.println("ps");
						int i = psmt.executeUpdate();
						System.out.println(i);
				
					JOptionPane.showMessageDialog(null,"Update Successfully !");
					}
				catch (Exception e2) {
					e2.printStackTrace();
				}
				}	
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				if(e.getActionCommand().equals("Cancel"))
				{
					rightJPanel.setVisible(true);
					removeJPanel.setVisible(false);
					displayPanel.setVisible(false);
					updatePanel.setVisible(false);
				}	
			}
		});
		
		f.setVisible(true);		
	}

}
