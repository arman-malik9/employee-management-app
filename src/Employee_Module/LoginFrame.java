package Employee_Module;


import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import employeeManagementSystem.HomePageAdmin;
import employeeManagementSystem.HomePageEmp;



public class LoginFrame{
	public static final String USER_ID = "1";
	public static final String USER_MAIL = "admin_a1@hcl.com";
	JFrame f;
	JLabel headerText, idLabel, emaiLabel;
	JTextField empId, empMail;
	JButton logInButton;
	boolean flagAdmin = false;
	boolean flagEmp = false;
	
	public void logInframe()
	{
		f = new JFrame("Employee Management System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(400,100,550,550);
		Container c = f.getContentPane();
		c.setLayout(null);
		
		headerText = new JLabel("Log IN Here");
		headerText.setBounds(200, 50, 400, 30);
		Font font = new Font("Arial", 10, 20);
		headerText.setFont(font);
		c.add(headerText);
		
		
		JRadioButton jRadioButton1 = new JRadioButton("Admin");
		jRadioButton1.setBounds(200, 100, 100, 50);
		jRadioButton1.setActionCommand("admin");
		c.add(jRadioButton1);
		
		JRadioButton jRadioButton2 = new JRadioButton("Employee");
		jRadioButton2.setBounds(300, 100, 100, 50);
		jRadioButton2.setActionCommand("employee");
		c.add(jRadioButton2);
		
		ButtonGroup group = new ButtonGroup();
		group.add(jRadioButton1);
		group.add(jRadioButton2);
		
		idLabel = new JLabel("Employee ID");
		idLabel.setBounds(100, 200, 100, 30);
		c.add(idLabel);
		
		emaiLabel = new JLabel("Employee Email");
		emaiLabel.setBounds(100, 250, 100, 30);
		c.add(emaiLabel);
		
		empId = new JTextField();
		empId.setBounds(300, 200,200, 30);
		c.add(empId);
		
		
		empMail = new JTextField();
		empMail.setBounds(300, 250, 200, 30);
		c.add(empMail);
		
		logInButton = new JButton("Log In");
		logInButton.setBounds(300, 300, 200, 30);
		c.add(logInButton);
		
			logInButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Log In"))
				{
					
					
					if(group.getSelection().getActionCommand().equals("admin") )
					{
						try
						{
							Connection con = Connect.getConnection();
							String id=empId.getText();
							String email=empMail.getText();
							String q ="select * from employeedata where empId= '" +id+"' and empEmail = '" +email+"' ";
							PreparedStatement ps = con.prepareStatement(q);
							ResultSet rs =  ps.executeQuery();
							if(USER_ID.equals(id) && USER_MAIL.equals(email))
							{
								
								
								
							HomePageAdmin obAdmin =	 new HomePageAdmin("Admin");
								obAdmin.setVisible(true);
								HomePageAdmin.setID(Integer.parseInt(id));
							f.setVisible(false);
								//AdminScreen adminScreen = new AdminScreen();
								//adminScreen.adminScreen();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"You have entered Wrong ID and Email !");
								
							}
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
					}
					
					else if(group.getSelection().getActionCommand().equals("employee"))
					{
						try
						{
							Connection con = Connect.getConnection();
							String id=empId.getText();
							String email=empMail.getText();
							String q ="select * from employeedata where empId= '" +id+"' and empEmail = '" +email+"' ";
							PreparedStatement ps = con.prepareStatement(q);
							ResultSet rs =  ps.executeQuery();
							if(rs.next())
							{
								
								String firString = rs.getString("empFirstName");
								String lasString = rs.getString("empLastName");
								HomePageEmp homePageEmp = new HomePageEmp(firString,lasString);
								homePageEmp.setVisible(true);
								HomePageEmp.setID(Integer.parseInt(id));
								f.setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"You have entered Wrong ID and Email !");
								
							}
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You have entered Wrong ID and Email ! ");

					}
				}
			}			
		});
		
		f.setVisible(true);
	}
	
	
}
