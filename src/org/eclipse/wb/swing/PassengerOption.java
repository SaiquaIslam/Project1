package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengerOption {

	private JFrame frmOptionsForPassenger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerOption window = new PassengerOption();
					window.frmOptionsForPassenger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PassengerOption() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOptionsForPassenger = new JFrame();
		frmOptionsForPassenger.setTitle("Options for Passenger");
		frmOptionsForPassenger.getContentPane().setBackground(new Color(176, 196, 222));
		frmOptionsForPassenger.setBounds(100, 100, 450, 300);
		frmOptionsForPassenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOptionsForPassenger.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration au = new Registration();
				au.main(null);
			}
		});
		btnNewButton.setBackground(new Color(188, 143, 143));
		btnNewButton.setFont(new Font("Nirmala UI Semilight", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(110, 60, 209, 57);
		frmOptionsForPassenger.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpassenger lip = new Loginpassenger();
				lip.main(null);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 235, 205));
		btnNewButton_1.setFont(new Font("Nirmala UI", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(110, 166, 209, 57);
		frmOptionsForPassenger.getContentPane().add(btnNewButton_1);
	}

}
