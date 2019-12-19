package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.BufferCapabilities.FlipContents;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookingTicket {

	private JFrame frmBuyingTicket;
	private JTextField timeTF;
	private JTextField noPassengerTF;
	private JTextField totalPriceTF;
	private JTextField priceLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BookingTicket window = new BookingTicket();
					window.frmBuyingTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingTicket() {
		initialize();
		
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuyingTicket = new JFrame();
		frmBuyingTicket.setTitle("Buying Ticket");
		frmBuyingTicket.getContentPane().setBackground(new Color(188, 143, 143));
		frmBuyingTicket.setBounds(100, 100, 540, 587);
		frmBuyingTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyingTicket.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Flight");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(61, 71, 97, 14);
		frmBuyingTicket.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTimeDate = new JLabel("Time & Date:");
		lblTimeDate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTimeDate.setBounds(37, 166, 108, 14);
		frmBuyingTicket.getContentPane().add(lblTimeDate);
		
		JLabel lblNoOfPassenger = new JLabel("No. of Passenger:");
		lblNoOfPassenger.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNoOfPassenger.setBounds(10, 227, 142, 14);
		frmBuyingTicket.getContentPane().add(lblNoOfPassenger);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPrice.setBounds(85, 296, 71, 14);
		frmBuyingTicket.getContentPane().add(lblPrice);
		
		final JComboBox flightCB = new JComboBox();
		flightCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try
			    {
			      // create a mysql database connection
			      String myDriver = "com.mysql.jdbc.Driver";
			      String myUrl = "jdbc:mysql://localhost:3306/ams";
			      Class.forName(myDriver);
			      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			      
			  

			      // the mysql insert statement
			      String query = " SELECT * FROM `flights` ";

			      
			      
			      Statement sm = conn.createStatement();
			       ResultSet rs =sm.executeQuery(query); 
			       flightCB.removeAllItems();
			       while(rs.next()){
			    	  
			    	 flightCB.addItem(rs.getObject("id")+"-"+rs.getObject("source")+"-"+rs.getObject("destination"));
			    	 
			      }

			      
			      
			      
			      conn.close();
			    }
			    catch (Exception e)
			    {
			    	JOptionPane.showMessageDialog(null, "Error");
			    
			    }

				
			}
		});
		flightCB.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				
				
			}
		});
		flightCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try
			    {
			      // create a mysql database connection
			      String myDriver = "com.mysql.jdbc.Driver";
			      String myUrl = "jdbc:mysql://localhost:3306/ams";
			      Class.forName(myDriver);
			      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			      
			  
			      String flight_info = flightCB.getSelectedItem().toString();
			      String flight_String[] = flight_info.split("-");
			      
			      // the mysql insert statement
			      String query = " SELECT * FROM `flights` where id = "+flight_String[0];

			      
			      
			      Statement sm = conn.createStatement();
			       ResultSet rs =sm.executeQuery(query); 
			       
			       if(rs.next()){
			    	  
			    	 priceLabel.setText(rs.getString("price"));
			    	
			    	 
			      }

			      
			      
			      
			      conn.close();
			    }
			    catch (Exception e)
			    {
			    	//JOptionPane.showMessageDialog(null, "Error");
			    
			    }

			
			}
		});
		flightCB.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			
			}
		});
		flightCB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
			
			}
		});
		flightCB.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		flightCB.setBounds(143, 68, 243, 20);
		frmBuyingTicket.getContentPane().add(flightCB);
		
		timeTF = new JTextField();
		timeTF.setBounds(143, 150, 200, 50);
		frmBuyingTicket.getContentPane().add(timeTF);
		timeTF.setColumns(10);
		
		noPassengerTF = new JTextField();
		noPassengerTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				int price =Integer.parseInt( priceLabel.getText());
				int noPassenger = Integer.parseInt(noPassengerTF.getText());
				int totalPrice = price*noPassenger;
				
				totalPriceTF.setText(String.valueOf(totalPrice));
				
			}
		});
		noPassengerTF.setBounds(143, 211, 200, 50);
		frmBuyingTicket.getContentPane().add(noPassengerTF);
		noPassengerTF.setColumns(10);
		
		totalPriceTF = new JTextField();
		totalPriceTF.setBounds(143, 280, 200, 50);
		frmBuyingTicket.getContentPane().add(totalPriceTF);
		totalPriceTF.setColumns(10);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBackground(new Color(192, 192, 192));
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
			    {
			      // create a mysql database connection
			      String myDriver = "com.mysql.jdbc.Driver";
			      String myUrl = "jdbc:mysql://localhost:3306/ams";
			      Class.forName(myDriver);
			      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
			      
			  

			      // the mysql insert statement
			      String query = " INSERT INTO `booking` (`id`, `flight`, `price`, `datetime`, `nofp`, `total_price`) VALUES (NULL, ?, ?, ?, ?, ?);";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			      
			     preparedStmt.setString(1,(String)flightCB.getSelectedItem());
			      preparedStmt.setString(2, priceLabel.getText());
			      preparedStmt.setString(3, timeTF.getText());
			      preparedStmt.setString(4, noPassengerTF.getText());
			      preparedStmt.setString(5, totalPriceTF.getText());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      JOptionPane.showMessageDialog(null, "Buying Ticket Successful");
			      conn.close();
			    }
			    catch (Exception e)
			    {
			    	JOptionPane.showMessageDialog(null, "Error");
			    
			    }
				
				
			}
				
				
				
			
		});
		btnBuy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBuy.setBounds(116, 367, 200, 50);
		frmBuyingTicket.getContentPane().add(btnBuy);
		
		priceLabel = new JTextField();
		priceLabel.setBounds(143, 96, 200, 50);
		frmBuyingTicket.getContentPane().add(priceLabel);
		priceLabel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(47, 114, 71, 14);
		frmBuyingTicket.getContentPane().add(lblNewLabel);
	}
}
