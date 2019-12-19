package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketLogin {

	private JFrame frmChoiceOfPassenger;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketLogin window = new TicketLogin();
					window.frmChoiceOfPassenger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChoiceOfPassenger = new JFrame();
		frmChoiceOfPassenger.getContentPane().setBackground(new Color(255, 222, 173));
		frmChoiceOfPassenger.setTitle("Choice of Passenger");
		frmChoiceOfPassenger.setBounds(100, 100, 450, 300);
		frmChoiceOfPassenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChoiceOfPassenger.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Buy a Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookingTicket cla = new BookingTicket();
				cla.main(null);
			}
		});
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(108, 110, 200, 50);
		frmChoiceOfPassenger.getContentPane().add(btnNewButton);
	}

}
