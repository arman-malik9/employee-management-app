package benefitsBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;



import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class BenefitsMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BenefitsMenu frame = new BenefitsMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BenefitsMenu() {
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1080, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeBenefits = new JLabel("EMPLOYEE BENEFITS");
		lblEmployeeBenefits.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeBenefits.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEmployeeBenefits.setBounds(225, 25, 600, 80);
		contentPane.add(lblEmployeeBenefits);
		
		JButton btnApplyForNew = new JButton("Apply for New Reimbursement");
		btnApplyForNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
//				ApplyReimb frame = new ApplyReimb();
//				frame.setVisible(true);
			}
		});
		btnApplyForNew.setForeground(Color.BLACK);
		btnApplyForNew.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnApplyForNew.setBounds(215, 160, 620, 50);
		contentPane.add(btnApplyForNew);
		
		JButton btnView = new JButton("View My Reimbursements");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewReimb frame = new ViewReimb();
				frame.setVisible(true);
			}
		});
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnView.setBounds(215, 240, 620, 50);
		contentPane.add(btnView);
		
		JButton btnCancelMyReimbursement = new JButton("Cancel My Reimbursement Application");
		btnCancelMyReimbursement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CancelReimb frame = new CancelReimb();
				frame.setVisible(true);
			}
		});
		btnCancelMyReimbursement.setForeground(Color.BLACK);
		btnCancelMyReimbursement.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCancelMyReimbursement.setBounds(215, 320, 620, 50);
		contentPane.add(btnCancelMyReimbursement);
		
		JButton btnClainForMedical = new JButton("Clain for Medical Facilities");
		btnClainForMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
//				ClaimMedMenu frame = new ClaimMedMenu();
//				frame.setVisible(true);
			}
		});
		btnClainForMedical.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClainForMedical.setForeground(Color.BLACK);
		btnClainForMedical.setBounds(215, 400, 620, 50);
		contentPane.add(btnClainForMedical);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBack.setBounds(215, 480, 620, 50);
		contentPane.add(btnBack);
		
	}
}
