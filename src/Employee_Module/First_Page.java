package Employee_Module;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class First_Page {
	JFrame f;
	JLabel headerLabel, label1, label2;
	JButton go;
	JRadioButton jRadioButton1,jRadioButton2;
	ButtonGroup group ;
	
	public void logIN()
	{
		f = new JFrame("Employee Management System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(0,0,2000,2000);
		Container c = f.getContentPane();
		//c.setBackground(Color.LIGHT_GRAY);
		c.setLayout(null);
		
		headerLabel = new JLabel("Welcome to HCL Technologies");
		headerLabel.setForeground(Color.BLUE);
		headerLabel.setBounds(500, 50, 500, 50);
		c.add(headerLabel);
		c.setVisible(true);
		Font f1 = new Font("Arial",Font.BOLD,20);
		headerLabel.setFont(f1);
		
		jRadioButton1 = new JRadioButton("Admin");
		jRadioButton1.setBounds(500, 100, 500, 50);
		jRadioButton1.setActionCommand("admin");
		c.add(jRadioButton1);
		
		jRadioButton2 = new JRadioButton("Employee");
		jRadioButton2.setBounds(500, 140, 500, 50);
		jRadioButton2.setActionCommand("employee");
		c.add(jRadioButton2);
		
		group = new ButtonGroup();
		group.add(jRadioButton1);
		group.add(jRadioButton2);
		
		go = new JButton("GO");
		go.setBounds(500, 190, 100, 40);
		c.add(go);
		
		
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("GO"))
				{
					
					//resType = group.getSelection().getActionCommand();
					//System.out.println(resType);
				}				
			}
		});
			
		
//		  ImageIcon icon = new ImageIcon("HCL-Tech-Logo.jpg");
//		  f.setIconImage(icon.getImage());
		  
		  f.setVisible(true);		 
	}

	
}
