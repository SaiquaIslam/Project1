package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Registration {

	private JFrame frmRegistration;
	private JTextField nameTF;
	private JTextField phoneTF;
	private JTextField genderTF;
	private JTextField emailTF;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton saveB;
	private JPasswordField passwordPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.getContentPane().setBackground(new Color(176, 196, 222));
		frmRegistration.setTitle("Registration");
		frmRegistration.setBounds(100, 100, 529, 590);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		nameTF = new JTextField();
		nameTF.setBounds(220, 34, 200, 50);
		frmRegistration.getContentPane().add(nameTF);
		nameTF.setColumns(10);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(220, 113, 200, 50);
		frmRegistration.getContentPane().add(phoneTF);
		phoneTF.setColumns(10);
		
		genderTF = new JTextField();
		genderTF.setBounds(220, 192, 200, 50);
		frmRegistration.getContentPane().add(genderTF);
		genderTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setBounds(220, 274, 200, 50);
		frmRegistration.getContentPane().add(emailTF);
		emailTF.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(145, 52, 46, 14);
		frmRegistration.getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Phone:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(145, 131, 46, 14);
		frmRegistration.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Gender:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(146, 209, 64, 14);
		frmRegistration.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email-Address:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(102, 287, 108, 22);
		frmRegistration.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(125, 388, 76, 14);
		frmRegistration.getContentPane().add(lblNewLabel_3);
		
		saveB = new JButton("Save");
		saveB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
			    {
			      // create a mysql database connection
			      String myDriver = "com.mysql.jdbc.Driver";
			      String myUrl = "jdbc:mysql://localhost:3306/ams";
			      Class.forName(myDriver);
			      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			      
			  

			      // the mysql insert statement
			      String query = " INSERT INTO `passengers` (`id`, `name`, `gender`, `phone`, `email`, `pass`) VALUES (NULL, ?, ?, ?, ?, ?);";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			      
			      preparedStmt.setString(1,nameTF.getText());
			      preparedStmt.setString(2, genderTF.getText());
			      preparedStmt.setString(3, phoneTF.getText());
			      preparedStmt.setString(4, emailTF.getText());
			      preparedStmt.setString(5, passwordPF.getText());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      JOptionPane.showMessageDialog(null, "You are succesfully registered");
			      conn.close();
			    }
			    catch (Exception e)
			    {
			    	JOptionPane.showMessageDialog(null, "Error");
			    
			    }
				
				
			}
		});
		saveB.setFont(new Font("Times New Roman", Font.BOLD, 17));
		saveB.setForeground(new Color(255, 255, 255));
		saveB.setBackground(new Color(65, 105, 225));
		saveB.setBounds(145, 464, 200, 50);
		frmRegistration.getContentPane().add(saveB);
		
		passwordPF = new JPasswordField();
		passwordPF.setBounds(220, 386, 200, 20);
		frmRegistration.getContentPane().add(passwordPF);
	}
}
