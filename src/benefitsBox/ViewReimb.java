package benefitsBox;

import java.awt.*;
import javax.swing.*;

import Employee_Module.Connect;

import java.awt.event.*;
import java.sql.*;


public class ViewReimb extends JFrame implements ActionListener{
	JTable t;
	JButton bt1;
	JTextField tf1;
	JPanel p1,p2,p3;
	String x[]={"Employee ID","Service","Service Provider/Hospital Name","Bill Number","Bill Date","Submitted Date","Total Bill Amount","Insurance Coverage"};
	String y[][]=new String [20][8];
	int i=0,j=0;
	Font f,f1,f2;
	JLabel l1,l2;
	

	
	public ViewReimb()
	{
		super("All Employee Reimbursement Records");
		setSize(1480,400);
		setLocation(0,10);
		f=new Font("MS UI Gothic",Font.PLAIN,15);
		f2=new Font("MS UI Gothic",Font.BOLD,17);

		try
		{
			Connection con= Connect.getConnection();
		    Statement sst=con.createStatement();
			String q="select * from benefits";
			
			ResultSet rest=sst.executeQuery(q);
			while(rest.next())
			{
				y[i][j++]=rest.getString("Empid");
				y[i][j++]=rest.getString("Service");
				y[i][j++]=rest.getString("ServiceProvider");
				y[i][j++]=rest.getString("BillNo");
				y[i][j++]=rest.getString("BillDate");
				y[i][j++]=rest.getString("AppliedDate");
				y[i][j++]=rest.getString("BillAmount");
				y[i][j++]=rest.getString("InsuranceCoverage");
				i++;
				j=0;
				
			}
			
			t=new JTable(y,x);
			
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		t.setBackground(Color.WHITE);
		t.setForeground(Color.BLACK);
		t.setFont(f);
		
		JScrollPane js=new JScrollPane(t);
		
		f1=new Font("Lucida fax",Font.BOLD,25);
		
		l1=new JLabel("Search Employee");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(f1);
		
		l2=new JLabel("Employee ID");
		l2.setFont(f1);
		
		tf1=new JTextField();
		bt1=new JButton("Search Employee");
		tf1.setFont(f);
		bt1.setFont(f2);
		
		
		
		bt1.addActionListener(this);
		
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(1,3,10,10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(bt1);
		
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(2,1,10,10));
		p3.add(p1);
		p3.add(p2);
		
		
		
		
		add(p3,"South");
		add(js);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int eid=Integer.parseInt(tf1.getText());
		if(e.getSource()==bt1)
		{
			new ViewReimbSingle(eid).setVisible(true);
		}
		
	}
	
	public static void main(String args[]) 
	{
		new ViewReimb().setVisible(true);
	}
}









