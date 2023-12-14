package benefitsBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Employee_Module.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CancelReimb extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVerify;
	private JLabel lblBillNumber;
	private JTextField textField_1;
	private JButton buttonVerify;
	private JLabel lblBillNotFound;
	private JLabel lblBillFound;
	private JLabel lbl1;
	private JLabel lbl2;
	private JButton button;
	private JButton btnYes;
	private JButton btnNo;
	
	
	
	public CancelReimb() {
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setBounds(100, 5, 1080, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Connection con=Connect.getConnection();
		    Statement sst=con.createStatement();
		    
		    JLabel lblEmployeeid = new JLabel("EmployeeID");
		    lblEmployeeid.setFont(new Font("Tahoma", Font.BOLD, 25));
		    lblEmployeeid.setBounds(78, 45, 206, 40);
		    contentPane.add(lblEmployeeid);
		    
		    textField = new JTextField();
		    textField.setBounds(452, 52, 218, 36);
		    contentPane.add(textField);
		    textField.setColumns(10);
		    
		    
		    btnVerify = new JButton("Verify");
		    btnVerify.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
		    			int v1 = Integer.parseInt(textField.getText());
			    		ResultSet rs=sst.executeQuery("select * from employeedata");
			    		
			    		boolean flag = false;
				    
				    	while(rs.next()){
				    		int temp=Integer.parseInt(rs.getString("EmpId"));
				    		String ff1name=rs.getString("EmpFirstName");
				    		String ll1name=rs.getString("EmpLastName");
				    		
				    		
					    	if(temp==v1)
					    	{
					    		flag = true;
					    		btnVerify.setEnabled(false);
					    		repaint();
					    		JLabel lbl1 = new JLabel("Hello "+ff1name+" "+ll1name+"  :)"+"\n");
					    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
					    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
					    		lbl1.setBounds(78, 130, 840, 41);
					    		contentPane.add(lbl1);
					    		
					    		lblBillNumber = new JLabel("Bill Number");
					    		lblBillNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
					    		lblBillNumber.setBounds(78, 220, 206, 40);
					    		contentPane.add(lblBillNumber);
					    		
					    		textField_1 = new JTextField();
					    		textField_1.setColumns(10);
					    		textField_1.setBounds(452, 220, 218, 36);
					    		contentPane.add(textField_1);
					    		
					    		buttonVerify = new JButton("Verify");
					    		buttonVerify.addActionListener(new ActionListener() {
					    			public void actionPerformed(ActionEvent e) {
					    				try {
					    					Statement stmt=con.createStatement();
								    		ResultSet bi=stmt.executeQuery("select * from benefits where empid="+temp);
										    boolean Fl = false;
						    				String delbill = textField_1.getText();
						    				while(bi.next()) 
						    			    {
						    			    	String tp=bi.getString("BillNo");
						    			    	if(tp.equals(delbill))
						    			    	  {
						    			    	    Fl=true;
						    			    	    break;  		
						    			          }
						    			    	continue;
						    			    }
						    		    
							    			if(Fl) 
							    			{
							    				buttonVerify.setEnabled(false);
							    	    		repaint();
							    				lblBillFound = new JLabel("Are you sure wants to cancel this Claim ? ");
							    	    		lblBillFound.setHorizontalAlignment(SwingConstants.CENTER);
							    	    		lblBillFound.setFont(new Font("Tahoma", Font.BOLD , 25));
							    	    		lblBillFound.setBounds(78, 293, 840, 41);
							    	    		contentPane.add(lblBillFound);
							    	    		
							    	    		btnYes = new JButton("Yes");
							    	    		btnYes.addActionListener(new ActionListener() {
							    	    			public void actionPerformed(ActionEvent e) {
							    	    				try {
							    	    					stmt.executeUpdate("delete from benefits where empid='"+temp+"' and BillNo='"+delbill+"'");
							    	    					
							    	    					repaint();
							    	    					JOptionPane.showMessageDialog(null,"Cancellation Successfull");
							    	    					dispose();
							    	    					
							    	    				}catch(Exception a) {
									    					System.out.println(a);
											    		}
							    	    			}
							    	    		});
							    	    		btnYes.setForeground(Color.BLACK);
							    	    		btnYes.setFont(new Font("Tahoma", Font.BOLD, 15));
							    	    		btnYes.setBounds(271, 399, 130, 41);
							    	    		contentPane.add(btnYes);
							    	    		
							    	    		btnNo = new JButton("No");
							    	    		btnNo.addActionListener(new ActionListener() {
							    	    			public void actionPerformed(ActionEvent e) {
							    	    				dispose();
							    	    			}
							    	    		});
							    	    		btnNo.setForeground(Color.BLACK);
							    	    		btnNo.setFont(new Font("Tahoma", Font.BOLD, 15));
							    	    		btnNo.setBounds(546, 399, 130, 41);
							    	    		contentPane.add(btnNo);
							    	    		
							    	    	}else {
							    	    		buttonVerify.setEnabled(false);
							    	    		repaint();
							    	    		lblBillNotFound = new JLabel("Bill Not Found");
							    	    		lblBillNotFound.setHorizontalAlignment(SwingConstants.CENTER);
							    	    		lblBillNotFound.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
							    	    		lblBillNotFound.setBounds(78, 293, 840, 41);
							    	    		contentPane.add(lblBillNotFound);
							    	    		
							    	    	}
					    				}catch(Exception a) {
					    					System.out.println(a);
							    		}
					    	    	}
					    		});
					    		buttonVerify.setForeground(Color.BLACK);
					    		buttonVerify.setFont(new Font("Tahoma", Font.BOLD, 15));
					    		buttonVerify.setBounds(788, 220, 130, 41);
					    		contentPane.add(buttonVerify);
					    		
					    		
					    	}
				    	}
				    	if(!flag) {
				    		btnVerify.setEnabled(false);
				    		lbl1 = new JLabel("Employee ID Not Found");
				    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
				    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
				    		lbl1.setBounds(78, 130, 840, 41);
				    		contentPane.add(lbl1);
				    		repaint();
				    	}
		    		}catch(Exception a) {
		    			System.out.println(a);
		    		}
		    	}
		});
		btnVerify.setForeground(Color.BLACK);
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerify.setBounds(788, 49, 130, 41);
		contentPane.add(btnVerify);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 22));
		button.setBounds(78, 580, 160, 41);
		contentPane.add(button);
		repaint();
			
		
		}catch(Exception a) {
			System.out.println(a);
		}
		
	}
	public CancelReimb(int empid) {
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setBounds(100, 5, 1080, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Connection con=Connect.getConnection();
		    Statement sst=con.createStatement();
		    
    		ResultSet rs=sst.executeQuery("select * from employeedata where empid="+empid);
    		
    		boolean flag = false;
	    
	    	while(rs.next()){
	    		String ff1name=rs.getString("EmpFirstName");
	    		String ll1name=rs.getString("EmpLastName");
	    		
	    		flag = true;
	    		JLabel lbl1 = new JLabel("Hello "+ff1name+" "+ll1name+"  :)"+"\n");
	    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
	    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	    		lbl1.setBounds(78, 100, 840, 41);
	    		contentPane.add(lbl1);
	    		
	    		lblBillNumber = new JLabel("Bill Number");
	    		lblBillNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblBillNumber.setBounds(78, 220, 206, 40);
	    		contentPane.add(lblBillNumber);
	    		
	    		textField_1 = new JTextField();
	    		textField_1.setColumns(10);
	    		textField_1.setBounds(452, 220, 218, 36);
	    		contentPane.add(textField_1);
	    		
	    		buttonVerify = new JButton("Verify");
	    		buttonVerify.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				try {
	    					Statement stmt=con.createStatement();
				    		ResultSet bi=stmt.executeQuery("select * from benefits where empid="+empid);
						    boolean Fl = false;
		    				String delbill = textField_1.getText();
		    				while(bi.next()) 
		    			    {
		    			    	String tp=bi.getString("BillNo");
		    			    	if(tp.equals(delbill))
		    			    	  {
		    			    	    Fl=true;
		    			    	    break;  		
		    			          }
		    			    	continue;
		    			    }
		    		    
			    			if(Fl) 
			    			{
			    				buttonVerify.setEnabled(false);
			    	    		repaint();
			    				lblBillFound = new JLabel("Are you sure wants to cancel this Claim ? ");
			    	    		lblBillFound.setHorizontalAlignment(SwingConstants.CENTER);
			    	    		lblBillFound.setFont(new Font("Tahoma", Font.BOLD , 25));
			    	    		lblBillFound.setBounds(78, 293, 840, 41);
			    	    		contentPane.add(lblBillFound);
			    	    		
			    	    		btnYes = new JButton("Yes");
			    	    		btnYes.addActionListener(new ActionListener() {
			    	    			public void actionPerformed(ActionEvent e) {
			    	    				try {
			    	    					stmt.executeUpdate("delete from benefits where empid='"+empid+"' and BillNo='"+delbill+"'");
			    	    					
			    	    					repaint();
			    	    					JOptionPane.showMessageDialog(null,"Cancellation Successfull");
			    	    					dispose();
			    	    					
			    	    				}catch(Exception a) {
					    					System.out.println(a);
							    		}
			    	    			}
			    	    		});
			    	    		btnYes.setForeground(Color.BLACK);
			    	    		btnYes.setFont(new Font("Tahoma", Font.BOLD, 15));
			    	    		btnYes.setBounds(271, 399, 130, 41);
			    	    		contentPane.add(btnYes);
			    	    		
			    	    		btnNo = new JButton("No");
			    	    		btnNo.addActionListener(new ActionListener() {
			    	    			public void actionPerformed(ActionEvent e) {
			    	    				dispose();
			    	    			}
			    	    		});
			    	    		btnNo.setForeground(Color.BLACK);
			    	    		btnNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			    	    		btnNo.setBounds(546, 399, 130, 41);
			    	    		contentPane.add(btnNo);
			    	    		
			    	    	}else {
			    	    		buttonVerify.setEnabled(false);
			    	    		repaint();
			    	    		lblBillNotFound = new JLabel("Bill Not Found");
			    	    		lblBillNotFound.setHorizontalAlignment(SwingConstants.CENTER);
			    	    		lblBillNotFound.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
			    	    		lblBillNotFound.setBounds(78, 293, 840, 41);
			    	    		contentPane.add(lblBillNotFound);
			    	    		
			    	    	}
	    				}catch(Exception a) {
	    					System.out.println(a);
			    		}
	    	    	}
	    		});
	    		buttonVerify.setForeground(Color.BLACK);
	    		buttonVerify.setFont(new Font("Tahoma", Font.BOLD, 15));
	    		buttonVerify.setBounds(788, 220, 130, 41);
	    		contentPane.add(buttonVerify);	
	    	}
	    	
			button = new JButton("Back");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setFont(new Font("Tahoma", Font.BOLD, 22));
			button.setBounds(78, 580, 160, 41);
			contentPane.add(button);
			repaint();
			
		
		}catch(Exception a) {
			System.out.println(a);
		}
		
	}
}
