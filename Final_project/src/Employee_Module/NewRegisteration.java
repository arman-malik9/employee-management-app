package Employee_Module;

import java.util.List;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewRegisteration {

	JFrame f;
	JLabel headerLabel,LfirstName, LlastName, Ldob, Lphone, LjoiningDate,Lsalary, Lgender, LempType;
	JButton submit, cancel;
	JRadioButton sexM, sexF, typePerm, typeTemp;
	ButtonGroup group1, group2;
	JTextField firstName, lastName, dob, phone, joiningDate,salary, empType;
	String empTypeString;
	public NewRegisteration()
	{}
	
	public NewRegisteration(String empTypeString)
	{
		this.empTypeString= empTypeString;
	}
	public void registerEmployee() {
	f = new JFrame("Employee Management System");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setBounds(0,0,2000,700);
	Container c = f.getContentPane();
	//c.setBackground(Color.LIGHT_GRAY);
	c.setLayout(null);
	
	headerLabel = new JLabel("New Employee Registeration");
	headerLabel.setForeground(Color.BLUE);
	headerLabel.setBounds(400, 10, 500, 50);
	c.add(headerLabel);
	c.setVisible(true);
	Font f1 = new Font("Arial",Font.BOLD,30);
	headerLabel.setFont(f1);
	
	LfirstName = new JLabel("First Name : ");
	LfirstName.setBounds(400, 100, 100, 30);
	Font f2 = new Font("Arial",Font.BOLD,15);
	LfirstName.setFont(f2);
	c.add(LfirstName);
	
	firstName = new JTextField();
	firstName.setBounds(700, 100,150, 30);
	c.add(firstName);
	
	
	LlastName = new JLabel("Last Name : ");
	LlastName.setBounds(400, 150, 100, 30);
	LlastName.setFont(f2);
	c.add(LlastName);
	
	lastName = new JTextField();
	lastName.setBounds(700, 150,150, 30);
	c.add(lastName);
	
	Ldob = new JLabel("Date of Birth (YYYY-MM-DD) : ");
	Ldob.setBounds(400, 200, 250, 30);
	Ldob.setFont(f2);
	c.add(Ldob);
	
	dob = new JTextField();
	dob.setBounds(700, 200,150, 30);
	c.add(dob);
	
	Lphone = new JLabel("Phone : ");
	Lphone.setBounds(400, 250, 250, 30);
	Lphone.setFont(f2);
	c.add(Lphone);
	
	phone = new JTextField();
	phone.setBounds(700, 250,150, 30);
	c.add(phone);
	
	LjoiningDate = new JLabel("Joining Date (YYYY-MM-DD) : ");
	LjoiningDate.setBounds(400, 300, 250, 30);
	LjoiningDate.setFont(f2);
	c.add(LjoiningDate);
	
	joiningDate = new JTextField();
	joiningDate.setBounds(700, 300,150, 30);
	c.add(joiningDate);
	
	Lgender = new JLabel("Gender : ");
	Lgender.setBounds(400, 350, 250, 30);
	Lgender.setFont(f2);
	c.add(Lgender);
	
	sexM = new JRadioButton("Male");
	sexM.setBounds(700, 350, 70, 30);
	sexM.setActionCommand("M");
	c.add(sexM);
	
	sexF = new JRadioButton("Female");
	sexF.setBounds(770, 350, 170, 30);
	sexF.setActionCommand("F");
	c.add(sexF);
	
	group1 = new ButtonGroup();
	group1.add(sexM);
	group1.add(sexF);
	
	submit = new JButton("Submit");
	submit.setBounds(500, 420, 100, 30);
	c.add(submit);
	
	cancel = new JButton("Cancel");
	cancel.setBounds(650, 420, 100, 30);	
	c.add(cancel);
	f.setVisible(true);
	
	submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Submit"))
			{
				List<String> list = new ArrayList<>();
				
				list.add(firstName.getText());
				list.add(lastName.getText());
				list.add(dob.getText());
				list.add(phone.getText());
				list.add(joiningDate.getText());
				list.add(group1.getSelection().getActionCommand());
				
				
				Employee emp = GetObject.getObject(empTypeString);
				int i;
				try {
					i = emp.addEmployee(list);
					System.out.println(i+" Record Inserted");
					JOptionPane.showMessageDialog(null,"your data Insert Successfully ");
//					this.setVisible(false);
	    			
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		}
	});
	
	cancel.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Cancel"))
			{
				f.setVisible(false);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}	
		}
	});
	
	}
}