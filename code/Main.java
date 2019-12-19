import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Toolkit;

import org.eclipse.wb.swing.AddFlight;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.eclipse.wb.swing.Loginadmin;
import org.eclipse.wb.swing.PassengerOption;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Main {

	private JFrame frmLoginPage;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
 private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("ActorType");
		frmLoginPage.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Administration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginadmin cla = new Loginadmin();
				cla.main(null);
				
				
				
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(81, 29, 254, 58);
		frmLoginPage.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Passenger");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PassengerOption po = new PassengerOption();
				po.main(null);
			}
		});
		btnNewButton_1.setBounds(81, 154, 254, 58);
		frmLoginPage.getContentPane().add(btnNewButton_1);
		frmLoginPage.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnNewButton_1}));
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
