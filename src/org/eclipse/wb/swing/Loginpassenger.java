package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Loginpassenger {

	private JFrame frmLogInAs;
	private JTextField emailTF;
	private JPasswordField passwordPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpassenger window = new Loginpassenger();
					window.frmLogInAs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginpassenger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogInAs = new JFrame();
		frmLogInAs.getContentPane().setBackground(new Color(175, 238, 238));
		frmLogInAs.setTitle("Log In as Passenger");
		frmLogInAs.setBounds(100, 100, 450, 300);
		frmLogInAs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogInAs.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Email-Address:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(71, 59, 113, 14);
		frmLogInAs.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(95, 118, 75, 14);
		frmLogInAs.getContentPane().add(lblNewLabel);
		
		emailTF = new JTextField();
		emailTF.setBounds(177, 55, 217, 29);
		frmLogInAs.getContentPane().add(emailTF);
		emailTF.setColumns(10);
		
		JButton signinB = new JButton("Sign In");
		signinB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
			    {
			      // create a mysql database connection
			      String myDriver = "com.mysql.jdbc.Driver";
			      String myUrl = "jdbc:mysql://localhost:3306/ams";
			      Class.forName(myDriver);
			      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			      
			  

			      // the mysql insert statement
			      String query = " SELECT * FROM `passengers` where email = '"+emailTF.getText()+"' and pass='"+passwordPF.getText()+"';";

			      
			      
			      Statement sm = conn.createStatement();
			       ResultSet rs =sm.executeQuery(query); 
			      if(rs.next()){
			    	  
			    	 //success login
			    	  TicketLogin ps = new TicketLogin();
			    	  ps.main(null);
			      }else{
			    	  JOptionPane.showMessageDialog(null, "Email or password invalid");
			      }

			      
			      
			      
			      conn.close();
			    }
			    catch (Exception e)
			    {
			    	JOptionPane.showMessageDialog(null, "Error");
			    
			    }
				
				
				
				
			}
		});
		signinB.setForeground(new Color(255, 235, 205));
		signinB.setBackground(new Color(32, 178, 170));
		signinB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		signinB.setBounds(102, 175, 200, 50);
		frmLogInAs.getContentPane().add(signinB);
		
		passwordPF = new JPasswordField();
		passwordPF.setBounds(180, 116, 217, 20);
		frmLogInAs.getContentPane().add(passwordPF);
	}

}
