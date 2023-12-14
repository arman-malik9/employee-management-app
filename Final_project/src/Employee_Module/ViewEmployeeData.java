package Employee_Module;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class ViewEmployeeData implements ActionListener{
	
	JFrame f;
	JLabel id,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,aid8,id9,aid9;
 public	String  ID,first_Name,last_Name, email, emp_type, phone,joinind_Date, salary, emp_gender,dob;
	JButton b1,b2;
	int age;
	static int Eid;
	
	public static void setEmpID(int id)
	{
		Eid=id;
	}
	public ViewEmployeeData()
	{
	}
	public ViewEmployeeData(int Eid) {
		/* System.out.println(Eid); */
		try
		{
			Connection con = Connect.getConnection();
			
			String s ="select * from employeedata where empid= '" +Eid+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(s);
			while(rs.next())
			{
				ID=rs.getString("empID");
				first_Name=rs.getString("empFirstName");
				last_Name=rs.getString("empLastName");
				email=rs.getString("empemail");
				emp_type=rs.getString("empType");
				phone=rs.getString("empPhone");
				joinind_Date=rs.getString("empJoiningDate");
				salary= rs.getString("empSalary");
				emp_gender= rs.getString("empGender");
				dob = rs.getString("empdob");
				age = rs.getInt("age");
			
			}
			
			String newAge = String.valueOf(age);
			f= new JFrame("Display Employee Details");
			f.setVisible(true);
			f.setSize(595,642);
			f.setLocation(360, 30);
			f.setBackground(Color.DARK_GRAY);
			f.setLayout(null);
			
			id9= new JLabel("Employee Details");
			id9.setBounds(170,10,250,40);
			id9.setFont(new Font("Arial", Font.BOLD,25) );
			f.add(id9);
			
			id1= new JLabel("Employee ID : ");
			id1.setBounds(150, 70, 120, 30);
			id1.setFont(new Font("serif",Font.BOLD,15));
			f.add(id1); 
			
			aid1 = new JLabel(ID);
			aid1.setBounds(330, 70, 200, 30);
			aid1.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid1);
			
			
			id2= new JLabel("Name : ");
			id2.setBounds(150, 120, 100, 30);
			id2.setFont(new Font("serif",Font.BOLD,15));
			f.add(id2);
			
			aid2 = new JLabel(first_Name+" "+last_Name);
			aid2.setBounds(330, 120, 300, 30);
			aid2.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid2);
			
			id9= new JLabel("Email : ");
			id9.setBounds(150, 170, 200, 30);
			id9.setFont(new Font("serif",Font.BOLD,15));
			f.add(id9);
			
			aid9 = new JLabel(email);
			aid9.setBounds(330, 170, 300, 30);
			aid9.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid9);
			
			id3= new JLabel("Mobile No. : ");
			id3.setBounds(150, 220, 150, 30);
			id3.setFont(new Font("serif",Font.BOLD,15));
			f.add(id3);
			
			aid3 = new JLabel(phone);
			aid3.setBounds(330, 220, 300, 30);
			aid3.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid3);
			
			
			id4= new JLabel("Date Of Birth:");
			id4.setBounds(150, 270, 100, 30);
			id4.setFont(new Font("serif",Font.BOLD,15));
			f.add(id4);
			
			aid4 = new JLabel(dob);
			aid4.setBounds(330, 270, 300, 30);
			aid4.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid4);
			
			
			id5= new JLabel("Age : ");
			id5.setBounds(150, 320, 100, 30);
			id5.setFont(new Font("serif",Font.BOLD,15));
			f.add(id5);
			
			aid5 = new JLabel(newAge);
			aid5.setBounds(330, 320, 300, 30);
			aid5.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid5);
			
			
			id6= new JLabel("Employee Type:");
			id6.setBounds(150, 370, 100, 30);
			id6.setFont(new Font("serif",Font.BOLD,15));
			f.add(id6);
			
			aid6 = new JLabel(emp_type);
			aid6.setBounds(330, 370, 300, 30);
			aid6.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid6);
			
			
			
			id7= new JLabel("Joining Date : ");
			id7.setBounds(150, 420, 100, 30);
			id7.setFont(new Font("serif",Font.BOLD,15));
			f.add(id7);
			
			aid7 = new JLabel(joinind_Date);
			aid7.setBounds(330, 420, 300, 30);
			aid7.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid7);
			
			
			
			id8= new JLabel("Salary : ");
			id8.setBounds(150, 470, 100, 30);
			id8.setFont(new Font("serif",Font.BOLD,15));
			f.add(id8);
			
			aid8 = new JLabel(salary);
			aid8.setBounds(330, 470, 200, 30);
			aid8.setFont(new Font("serif",Font.BOLD,15));
			f.add(aid8);
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		b1= new JButton("Back");
		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b1.setBounds(250,540,100,30);
		b1.addActionListener(this);
		f.add(b1);

	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
//			JOptionPane.showMessageDialog(null, "Do you want to close it?");
			f.setVisible(false);
			//new HomePage();
		}

		
	}


}



