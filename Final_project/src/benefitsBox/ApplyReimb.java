package benefitsBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Employee_Module.Connect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class ApplyReimb extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVerify;
	private JLabel lblServiceProvider;
	private JTextField textField_SP;
	private JLabel lblBillNumber;
	private JLabel lblBillDateyyyymmdd;
	private JLabel lblBillAmount;
	private JLabel lbl1;
	private JTextField textField_BN;
	private JTextField textField_BD;
	private JTextField textField_BA;
	private JButton btnSubmit;
	private JButton btnBack;
	private JButton button;
	private JComboBox comboBox;
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ApplyReimb frame = new ApplyReimb();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public ApplyReimb() {
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1080, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Connection con=Connect.getConnection();
//		    Statement sst=con.createStatement();
		    
		    JLabel lblEmployeeid = new JLabel("EmployeeID");
		    lblEmployeeid.setFont(new Font("Tahoma", Font.BOLD, 25));
		    lblEmployeeid.setBounds(78, 45, 206, 41);
		    contentPane.add(lblEmployeeid);
		    
		    textField = new JTextField();
		    textField.setBounds(452, 52, 218, 36);
		    contentPane.add(textField);
		    textField.setColumns(10);
		    
		    
		    btnVerify = new JButton("Verify");
		    btnVerify.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String sql="insert into benefits values(?,?,?,?,?,?,?,?)";
		    		try {
		    		PreparedStatement preparedStatement = con.prepareStatement(sql);
		    		int v1 = Integer.parseInt(textField.getText());
		    		ResultSet rs=preparedStatement.executeQuery("select * from employeedata");
		    		
		    		boolean flag = false;
			    
			    	while(rs.next()){
			    		int temp=Integer.parseInt(rs.getString("EmpId"));
			    		String ff1name=rs.getString("EmpFirstName");
			    		String ll1name=rs.getString("EmpLastName");
			    		
			    		
				    	if(temp==v1) 
				    	{
				    		preparedStatement.setInt(1,v1);   	
				    		flag = true;
				    		btnVerify.setEnabled(false);
				    		repaint();
				    		JLabel lbl1 = new JLabel("Hello "+ff1name+" "+ll1name+"  :)"+"\n");
				    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
				    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
				    		lbl1.setBounds(78, 130, 840, 41);
				    		contentPane.add(lbl1);
				    		
				    		JLabel lblRT = new JLabel("Reimbursement Type *");
				    		lblRT.setFont(new Font("Tahoma", Font.BOLD, 25));
				    		lblRT.setBounds(78, 220, 300, 41);
				    		contentPane.add(lblRT);
				    		
				    		String rt[]= {"Internet","Home Rent","Cab","Fuel"};
				    		
				    		comboBox = new JComboBox(rt);
				    		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				    		comboBox.setBounds(470, 220, 218, 36);
				    		contentPane.add(comboBox);
				    		
				    		lblServiceProvider = new JLabel("Service Provider");
				    		lblServiceProvider.setFont(new Font("Tahoma", Font.BOLD, 25));
				    		lblServiceProvider.setBounds(78, 290, 240, 41);
				    		contentPane.add(lblServiceProvider);
				    		
				    		textField_SP = new JTextField();
				    		textField_SP.setColumns(10);
				    		textField_SP.setBounds(470, 290, 218, 36);
				    		contentPane.add(textField_SP);
				    		
				    		lblBillNumber = new JLabel("Bill Number *");
				    		lblBillNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
				    		lblBillNumber.setBounds(78, 360, 206, 41);
				    		contentPane.add(lblBillNumber);
				    		
				    		textField_BN = new JTextField();
				    		textField_BN.setColumns(10);
				    		textField_BN.setBounds(470, 360, 218, 36);
				    		contentPane.add(textField_BN);
				    		
				    		lblBillDateyyyymmdd = new JLabel("Bill Date (yyyy-mm-dd) *");
				    		lblBillDateyyyymmdd.setFont(new Font("Tahoma", Font.BOLD, 25));
				    		lblBillDateyyyymmdd.setBounds(78, 430, 325, 41);
				    		contentPane.add(lblBillDateyyyymmdd);

				    		textField_BD = new JTextField();
				    		textField_BD.setColumns(10);
				    		textField_BD.setBounds(470, 430, 218, 36);
				    		contentPane.add(textField_BD);
				    		
				    		lblBillAmount = new JLabel("Bill Amount *");
				    		lblBillAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
				    		lblBillAmount.setBounds(78, 500, 206, 41);
				    		contentPane.add(lblBillAmount);
				    		
				    		textField_BA = new JTextField();
				    		textField_BA.setColumns(10);
				    		textField_BA.setBounds(470, 500, 218, 36);
				    		contentPane.add(textField_BA);
				    		
				    		btnBack = new JButton("Back");
				    		btnBack.addActionListener(new ActionListener() {
				    			public void actionPerformed(ActionEvent arg0) {
				    				dispose();
//				    				ApplyReimbMenu f= new ApplyReimbMenu();
//				    				f.setVisible(true);
				    			}
				    		});
				    		btnBack.setFont(new Font("Tahoma", Font.BOLD, 22));
				    		btnBack.setBounds(215, 580, 160, 41);
				    		contentPane.add(btnBack);
				    		
				    		btnSubmit = new JButton("Submit");
				    		btnSubmit.addActionListener(new ActionListener() {
				    			public void actionPerformed(ActionEvent arg0) {
				    				try
				    				{
				    					preparedStatement.setString(2,comboBox.getSelectedItem().toString());
				    					
				    					String v3 = textField_SP.getText();
					    				preparedStatement.setString(3,v3);
							    		
							    		String v4 = textField_BN.getText();
							    		preparedStatement.setString(4,v4);
							    		
							    		String v5 = textField_BD.getText();
							    		preparedStatement.setString(5,v5);
							    		
							    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							    		LocalDateTime now = LocalDateTime.now();
							    		String v6 = dtf.format(now);
							    		preparedStatement.setString(6,v6);
							    		
							    		int v7 = Integer.parseInt(textField_BA.getText());
							    		if(comboBox.getSelectedIndex()==0){
								    		if(v7>600){
								    			JLabel lbl2 = new JLabel("Max claim Rs 600 Added");
								    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
								    			lbl2.setBounds(700, 490, 389, 41);
								    			contentPane.add(lbl2);
								    			preparedStatement.setInt(7,600);
								    		}
								    		else 
								    		{
								    			preparedStatement.setInt(7,v7);
									        }
							    		}else if(comboBox.getSelectedIndex()==1) {
							    			if(v7>7000){
								    			JLabel lbl2 = new JLabel("Max claim Rs 7000 Added");
								    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
								    			lbl2.setBounds(700, 490, 389, 41);
								    			contentPane.add(lbl2);
								    			preparedStatement.setInt(7,7000);
								    		}
								    		else 
								    		{
								    			preparedStatement.setInt(7,v7);
									        }
							    		}else if(comboBox.getSelectedIndex()==2) {
							    			if(v7>5000){
								    			JLabel lbl2 = new JLabel("Max claim Rs 5000 Added");
								    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
								    			lbl2.setBounds(700, 490, 389, 41);
								    			contentPane.add(lbl2);
								    			preparedStatement.setInt(7,5000);
								    		}
								    		else 
								    		{
								    			preparedStatement.setInt(7,v7);
									        }
							    			
							    		}else if(comboBox.getSelectedIndex()==3) {
							    			if(v7>3500){
								    			JLabel lbl2 = new JLabel("Max claim Rs 3500 Added");
								    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
								    			lbl2.setBounds(700, 490, 389, 41);
								    			contentPane.add(lbl2);
								    			preparedStatement.setInt(7,3500);
								    		}
								    		else 
								    		{
								    			preparedStatement.setInt(7,v7);
									        }
							    		}
							    		preparedStatement.setInt(8,0);
							    		
							    		int x=preparedStatement.executeUpdate();
							    		
							    		if(x>0)
							    		{
							    			JLabel lblNewLabel = new JLabel("Details Submitted Successfully");
							    			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
							    			lblNewLabel.setBounds(684, 590, 286, 25);
							    			contentPane.add(lblNewLabel);
							    			btnSubmit.setEnabled(false);
							    			repaint();
								    	}
							    		else
							    		{
							    			JLabel lblNewLabel = new JLabel("Details Not Submitted");
							    			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
							    			lblNewLabel.setBounds(684, 590, 286, 25);
							    			contentPane.add(lblNewLabel);
							    			repaint();
							    		}
							    		
				    				}catch(Exception a) {
				    					System.out.println(a);
				    					JLabel lblNewLabel = new JLabel("Details Not Submitted");
						    			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
						    			lblNewLabel.setBounds(684, 590, 286, 25);
						    			contentPane.add(lblNewLabel);
						    			repaint();
				    				}
						    		
				    			}
				    		});
				    		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
				    		btnSubmit.setBounds(450, 580, 160, 41);
				    		contentPane.add(btnSubmit);
				    		revalidate();
						    
				    		break;	
				    	}
				    	
				    }
			    	if(!flag) {
			    		btnVerify.setEnabled(false);
			    		lbl1 = new JLabel("Employee ID Not Found");
			    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
			    		lbl1.setBounds(78, 130, 840, 41);
			    		contentPane.add(lbl1);
			    		
			    		button = new JButton("Back");
			    		button.addActionListener(new ActionListener() {
			    			public void actionPerformed(ActionEvent e) {
			    				dispose();
//			    				ApplyReimbMenu f= new ApplyReimbMenu();
//			    				f.setVisible(true);
			    			}
			    		});
			    		button.setFont(new Font("Tahoma", Font.BOLD, 22));
			    		button.setBounds(425, 210, 160, 41);
			    		contentPane.add(button);
			    		repaint();
			    	}}
		    	catch(Exception a) {
					System.out.println(a);
				}}
		});
		btnVerify.setForeground(Color.BLACK);
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerify.setBounds(788, 49, 130, 41);
		contentPane.add(btnVerify);
			
		
		}catch(Exception a) {
			System.out.println(a);
		}
		
	}
	
	public ApplyReimb(int empid) {
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setBounds(100, 5, 1080, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Connection con=Connect.getConnection();
		    Statement sst=con.createStatement();
		    String sql="insert into benefits values(?,?,?,?,?,?,?,?)";

    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    		ResultSet rs=preparedStatement.executeQuery("select * from employeedata where EmpId="+empid);
    		
    		boolean flag = false;
	    
	    	while(rs.next()){
	    		String ff1name=rs.getString("EmpFirstName");
	    		String ll1name=rs.getString("EmpLastName");
	    		
	    		preparedStatement.setInt(1,empid);   	
	    		flag = true;
	    		JLabel lbl1 = new JLabel("Hello "+ff1name+" "+ll1name+"  :)"+"\n");
	    		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
	    		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	    		lbl1.setBounds(78, 23, 840, 41);
	    		contentPane.add(lbl1);
	    		
	    		JLabel lblRT = new JLabel("Reimbursement Type *");
	    		lblRT.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblRT.setBounds(78, 170, 300, 41);
	    		contentPane.add(lblRT);
	    		
	    		String rt[]= {"Internet","Home Rent","Cab","Fuel"};
	    		
	    		comboBox = new JComboBox(rt);
	    		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    		comboBox.setBounds(470, 170, 218, 36);
	    		contentPane.add(comboBox);
	    		repaint();
	    		
	    		lblServiceProvider = new JLabel("Service Provider");
	    		lblServiceProvider.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblServiceProvider.setBounds(78, 250, 240, 41);
	    		contentPane.add(lblServiceProvider);
	    		
	    		textField_SP = new JTextField();
	    		textField_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    		textField_SP.setColumns(10);
	    		textField_SP.setBounds(470, 250, 218, 36);
	    		contentPane.add(textField_SP);
	    		
	    		lblBillNumber = new JLabel("Bill Number *");
	    		lblBillNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblBillNumber.setBounds(78, 330, 206, 41);
	    		contentPane.add(lblBillNumber);
	    		
	    		textField_BN = new JTextField();
	    		textField_BN.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    		textField_BN.setColumns(10);
	    		textField_BN.setBounds(470, 330, 218, 36);
	    		contentPane.add(textField_BN);
	    		
	    		lblBillDateyyyymmdd = new JLabel("Bill Date (yyyy-mm-dd) *");
	    		lblBillDateyyyymmdd.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblBillDateyyyymmdd.setBounds(78, 410, 325, 41);
	    		contentPane.add(lblBillDateyyyymmdd);

	    		textField_BD = new JTextField();
	    		textField_BD.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    		textField_BD.setColumns(10);
	    		textField_BD.setBounds(470, 410, 218, 36);
	    		contentPane.add(textField_BD);
	    		
	    		lblBillAmount = new JLabel("Bill Amount *");
	    		lblBillAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
	    		lblBillAmount.setBounds(78, 490, 206, 41);
	    		contentPane.add(lblBillAmount);
	    		
	    		textField_BA = new JTextField();
	    		textField_BA.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    		textField_BA.setColumns(10);
	    		textField_BA.setBounds(470, 490, 218, 36);
	    		contentPane.add(textField_BA);
	    		
	    		btnBack = new JButton("Back");
	    		btnBack.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				dispose();
//	    				HomePageAdmin f= new HomePageAdmin();
//	    				f.setVisible(true);
	    			}
	    		});
	    		btnBack.setFont(new Font("Tahoma", Font.BOLD, 22));
	    		btnBack.setBounds(215, 580, 160, 41);
	    		contentPane.add(btnBack);
	    		
	    		btnSubmit = new JButton("Submit");
	    		btnSubmit.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent arg0) {
	    				try
	    				{
	    					preparedStatement.setString(2,comboBox.getSelectedItem().toString());
	    					String v3 = textField_SP.getText();
		    				preparedStatement.setString(3,v3);
				    		
				    		String v4 = textField_BN.getText();
				    		preparedStatement.setString(4,v4);
				    		
				    		String v5 = textField_BD.getText();
				    		preparedStatement.setString(5,v5);
				    		
				    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    		LocalDateTime now = LocalDateTime.now();
				    		String v6 = dtf.format(now);
				    		preparedStatement.setString(6,v6);
				    		
				    		int v7 = Integer.parseInt(textField_BA.getText());
				    		if(comboBox.getSelectedIndex()==0){
					    		if(v7>600){
					    			JLabel lbl2 = new JLabel("Max claim Rs 600 Added");
					    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
					    			lbl2.setBounds(700, 490, 389, 41);
					    			contentPane.add(lbl2);
					    			preparedStatement.setInt(7,600);
					    		}
					    		else 
					    		{
					    			preparedStatement.setInt(7,v7);
						        }
				    		}else if(comboBox.getSelectedIndex()==1) {
				    			if(v7>7000){
					    			JLabel lbl2 = new JLabel("Max claim Rs 7000 Added");
					    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
					    			lbl2.setBounds(700, 490, 389, 41);
					    			contentPane.add(lbl2);
					    			preparedStatement.setInt(7,7000);
					    		}
					    		else 
					    		{
					    			preparedStatement.setInt(7,v7);
						        }
				    		}else if(comboBox.getSelectedIndex()==2) {
				    			if(v7>5000){
					    			JLabel lbl2 = new JLabel("Max claim Rs 5000 Added");
					    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
					    			lbl2.setBounds(700, 490, 389, 41);
					    			contentPane.add(lbl2);
					    			preparedStatement.setInt(7,5000);
					    		}
					    		else 
					    		{
					    			preparedStatement.setInt(7,v7);
						        }
				    			
				    		}else if(comboBox.getSelectedIndex()==3) {
				    			if(v7>3500){
					    			JLabel lbl2 = new JLabel("Max claim Rs 3500 Added");
					    			lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
					    			lbl2.setBounds(700, 490, 389, 41);
					    			contentPane.add(lbl2);
					    			preparedStatement.setInt(7,3500);
					    		}
					    		else 
					    		{
					    			preparedStatement.setInt(7,v7);
						        }
				    		}
				    		preparedStatement.setInt(8,0);
				    		
				    		int x=preparedStatement.executeUpdate();
				    		
				    		if(x>0)
				    		{
				    			JLabel lblNewLabel = new JLabel("Details Submitted Successfully");
				    			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				    			lblNewLabel.setBounds(684, 590, 286, 25);
				    			contentPane.add(lblNewLabel);
				    			btnSubmit.setEnabled(false);
				    			repaint();
					    	}
				    		else
				    		{
				    			JLabel lblNewLabel = new JLabel("Details Not Submitted");
				    			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				    			lblNewLabel.setBounds(684, 590, 286, 25);
				    			contentPane.add(lblNewLabel);
				    			repaint();
				    		}
				    		
	    				}catch(Exception a) {
	    					System.out.println(a);
	    				}
			    		
	    			}
	    		});
	    		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
	    		btnSubmit.setBounds(450, 580, 160, 41);
	    		contentPane.add(btnSubmit);
	    		
			    
	    		break;	
	    	}
			
		
		}catch(Exception a) {
			System.out.println(a);
		}
		
	}
}
