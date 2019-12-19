package org.eclipse.wb.swing;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Toolkit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Loginadmin {

	private JFrame frmLogInAs;
	private JTextField adminTF;
	private JTextArea txtrPassword;
	private JButton btnLogIn;
	private JPasswordField adminPO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginadmin window = new Loginadmin();
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
	public Loginadmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogInAs = new JFrame();
		frmLogInAs.getContentPane().setBackground(new Color(119, 136, 153));
		frmLogInAs.getContentPane().setEnabled(false);
		frmLogInAs.setTitle("Log In for Admin\r\n");
		frmLogInAs.setBounds(100, 100, 450, 300);
		frmLogInAs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogInAs.getContentPane().setLayout(null);
		
		JTextArea txtrUserid = new JTextArea();
		txtrUserid.setBackground(new Color(176, 224, 230));
		txtrUserid.setEditable(false);
		txtrUserid.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrUserid.setText("   AdminID:");
		txtrUserid.setBounds(73, 65, 94, 22);
		frmLogInAs.getContentPane().add(txtrUserid);
		
		adminTF = new JTextField();
		adminTF.setBounds(185, 58, 186, 35);
		frmLogInAs.getContentPane().add(adminTF);
		adminTF.setColumns(10);
		
		txtrPassword = new JTextArea();
		txtrPassword.setBackground(new Color(102, 205, 170));
		txtrPassword.setEditable(false);
		txtrPassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPassword.setText("  Password: ");
		txtrPassword.setBounds(73, 140, 94, 22);
		frmLogInAs.getContentPane().add(txtrPassword);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.addActionListener(new ActionListener() {
			String scheck;
			char[] ccheck;
			char[] ap={'1','\0'};
			public void actionPerformed(ActionEvent arg0) {
				AddFlight af = new AddFlight();
				af.main(null);
				
				//{
					//JOptionPane.showMessageDialog(null, "Invalid adminID or password");
				//}
				
			}
			public boolean check()
			{
				if (scheck.length() >= 5 || scheck.length() < 4)
					return false;
				for(int i=0;i<1;i++)
				{
					if(ccheck[i]!=ap[i])
						return false;
				}
				return true;
			}

		});
		btnLogIn.setBounds(168, 195, 142, 55);
		frmLogInAs.getContentPane().add(btnLogIn);
		
		adminPO = new JPasswordField();
		adminPO.setBounds(185, 142, 186, 20);
		frmLogInAs.getContentPane().add(adminPO);
	}
}
