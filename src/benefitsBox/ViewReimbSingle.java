package benefitsBox;

import java.awt.*;
import javax.swing.*;

import Employee_Module.Connect;

import java.awt.event.*;
import java.sql.*;

public class ViewReimbSingle extends JFrame
{
	JTable t;
	//String x[]= {"Employee ID","Name","Email","First Half","Second Half"};
	String x[]={"Employee ID","Service","Service Provider/Hospital Name","Bill Number","Bill Date","Submitted Date","Total Bill Amount","Insurance Coverage"};
	String y[][]=new String [20][8];
	int i=0,j=0;
	Font f,f1;
	int count=0;
	int empidString;

	public ViewReimbSingle(int Eid)
	{
		super("Particular Employee Reimbursement Records");
		empidString =Eid;
		setSize(1480,400);
		setLocation(0,10);
		f=new Font("MS UI Gothic",Font.PLAIN,15);
		
		try
		{
			Connection con= Connect.getConnection();	
			Statement sst=con.createStatement();
			String q="select *from Benefits where Empid='"+empidString+"'";
			ResultSet rest=sst.executeQuery(q);
			while(rest.next())
			{
				count++;
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
			
			if(count==0)
			{
				JOptionPane.showMessageDialog(null, "No record Found");
				
			}
			else
			{
				super.setVisible(true);
				t=new JTable(y,x);
				t.setBackground(Color.WHITE);
				t.setForeground(Color.BLACK);
				t.setFont(f);
				setSize(1480,400);
				setLocation(0,10);
				JScrollPane js=new JScrollPane(t);
				add(js);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}














