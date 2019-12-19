package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JSpinner;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

public class AddFlight {

	private JFrame frmAddFlightBy;
	private JTextField dtTF;
	private JTextField priceTF;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight window = new AddFlight();
					window.frmAddFlightBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddFlightBy = new JFrame();
		frmAddFlightBy.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			}
		});
		frmAddFlightBy.getContentPane().setBackground(new Color(144, 238, 144));
		frmAddFlightBy.setTitle("Add Flight by Admin");
		frmAddFlightBy.getContentPane().setForeground(new Color(216, 191, 216));
		frmAddFlightBy.setBounds(100, 100, 524, 327);
		frmAddFlightBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddFlightBy.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 110, -15, -56);
		frmAddFlightBy.getContentPane().add(scrollPane);
		
		final JComboBox fromCB = new JComboBox();
		fromCB.setName("fromCB");
		fromCB.setForeground(new Color(199, 21, 133));
		fromCB.setFont(new Font("Times New Roman", Font.BOLD, 11));
		fromCB.setModel(new DefaultComboBoxModel(new String[] {"Dhaka", "Chittagong", "Jessore", "Sylhet", "Rajshahi", "Chicago", "Las Vegas", "Dubai", "Bangkok", "Rome"}));
		fromCB.setSelectedIndex(1);
		
		fromCB.setBounds(78, 56, 129, 34);
		frmAddFlightBy.getContentPane().add(fromCB);
		
		final JComboBox toCB = new JComboBox();
		toCB.setName("toCB");
		toCB.setForeground(new Color(178, 34, 34));
		toCB.setFont(new Font("Times New Roman", Font.BOLD, 11));
		toCB.setModel(new DefaultComboBoxModel(new String[] {"Dhaka", "Chittagong", "Jessore", "Sylhet", "Rajshahi", "Chicago", "Las Vegas", "Dubai", "Bangkok", "Rome"}));
		toCB.setSelectedIndex(1);
		toCB.setBounds(337, 56, 129, 34);
		frmAddFlightBy.getContentPane().add(toCB);
		
		dtTF = new JTextField();
		dtTF.setName("dtTF");
		dtTF.setBounds(188, 110, 186, 34);
		frmAddFlightBy.getContentPane().add(dtTF);
		dtTF.setColumns(10);
		
		priceTF = new JTextField();
		priceTF.setName("priceTF");
		priceTF.setBounds(188, 155, 186, 34);
		frmAddFlightBy.getContentPane().add(priceTF);
		priceTF.setColumns(10);
		
		JButton saveB = new JButton("Save");
		saveB.setName("sabeB");
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
			      String query = " INSERT INTO `flights` (`id`, `source`, `destination`, `date_time`, `price`) VALUES (NULL, ?, ?, ?, ?);";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			      
			      preparedStmt.setString(1,(String) fromCB.getSelectedItem());
			      preparedStmt.setString(2, (String) toCB.getSelectedItem());
			      preparedStmt.setString(3, dtTF.getText());
			      preparedStmt.setString(4, priceTF.getText());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      conn.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("rezaGot an exception!");
			      System.err.println(e.getMessage());
			    }
				
				
			}
		});
		saveB.setBackground(new Color(102, 205, 170));
		saveB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		saveB.setBounds(138, 223, 169, 43);
		frmAddFlightBy.getContentPane().add(saveB);
		
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 66, 46, 14);
		frmAddFlightBy.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(309, 66, 18, 14);
		frmAddFlightBy.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date & Time:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(78, 119, 100, 14);
		frmAddFlightBy.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(132, 165, 46, 14);
		frmAddFlightBy.getContentPane().add(lblPrice);
	}
}

